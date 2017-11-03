package org.softlang.sourcesupport;

import java.util.Set;

public interface SourceSupport {
	Set<String> getPackages();

	Set<String> getClasses();

	<T> Class<? extends T> loadClass(Class<T> deriving, String name);

	<T> Class<? extends T> loadClass(Class<?> nextTo, Class<T> deriving, String name);
}
