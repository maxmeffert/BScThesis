package org.softlang.sourcesupport;

import static com.google.common.collect.Maps.immutableEntry;
import static com.google.common.collect.Sets.newHashSet;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public final class LocalSourceSupport implements SourceSupport {
	public static final LocalSourceSupport INSTANCE = new LocalSourceSupport();

	private LocalSourceSupport() {
		// Private constructor
	}

	@Override
	public Set<String> getPackages() {
		Set<String> packages = newHashSet();
		findClasses(x -> packages.add(x.getKey()));

		return packages;
	}

	@Override
	public Set<String> getClasses() {
		ImmutableSet.Builder<String> builder = ImmutableSet.builder();
		findClasses(x -> builder.add(x.getValue()));

		return builder.build();
	}

	@Override
	public <T> Class<? extends T> loadClass(Class<T> deriving, String name) {
		return loadClass(deriving, deriving, name);
	}

	@Override
	public <T> Class<? extends T> loadClass(Class<?> nextTo, Class<T> deriving, String name) {
		try {
			// Try to load and subclass the class for this name
			Class<?> c = Class.forName(name, false, nextTo.getClassLoader());
			if (deriving.isAssignableFrom(c))
				return c.asSubclass(deriving);

			// If not assignable, return null
			return null;
		} catch (ClassNotFoundException e) {
			// If not resolvable, return null
			return null;
		}
	}

	private static void findClasses(Consumer<Entry<String, String>> visitor) {
		String classpath = System.getProperty("java.class.path");
		String[] paths = classpath.split(System.getProperty("path.separator"));

		String javaHome = System.getProperty("java.home");
		File file = new File(javaHome + File.separator + "lib");
		if (file.exists()) {
			findClasses(file, file, true, visitor);
		}

		for (String path : paths) {
			file = new File(path);
			if (file.exists()) {
				findClasses(file, file, false, visitor);
			}
		}
	}

	private static boolean findClasses(File root, File file, boolean includeJars,
			Consumer<Entry<String, String>> visitor) {
		if (file.isDirectory()) {
			for (File child : file.listFiles())
				if (!findClasses(root, child, includeJars, visitor))
					return false;
		} else {
			if (file.getName().toLowerCase().endsWith(".jar") && includeJars)
				try (JarFile jar = new JarFile(file)) {
					for (JarEntry entry : Collections.list(jar.entries())) {
						String name = entry.getName();

						if (name.lastIndexOf(".class") > 0)
							visitor.accept(infoOf(name));
					}
				} catch (IOException e) {
				}
			else if (file.getName().toLowerCase().endsWith(".class"))
				visitor.accept(infoOf(root, file));
		}

		return true;
	}

	private static Entry<String, String> infoOf(String name) {
		List<String> parts = ImmutableList.copyOf(name.substring(0, name.lastIndexOf(".class")).split(
				Pattern.quote("/")));
		String classPackage = Joiner.on('.').join(parts.subList(0, parts.size() - 1));
		String className = Joiner.on('.').join(parts);

		return immutableEntry(classPackage, className);

	}

	private static Entry<String, String> infoOf(File root, File file) {
		StringBuffer sb = new StringBuffer();

		String fileName = file.getName().substring(0, file.getName().lastIndexOf(".class"));

		file = file.getParentFile();
		boolean inserted = true;
		while (file != null && !file.equals(root)) {
			if (!inserted)
				sb.insert(0, '.');
			sb.insert(0, file.getName());
			file = file.getParentFile();
			inserted = false;
		}

		if (inserted)
			return immutableEntry(sb.toString(), fileName);
		else
			return immutableEntry(sb.toString(), sb.toString() + fileName);
	}
}
