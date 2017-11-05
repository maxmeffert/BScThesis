package org.softlang.megal.plugins.old;

import static com.google.common.base.Objects.equal;
import static com.google.common.collect.FluentIterable.from;
import static org.softlang.megal.plugins.util.Pairs.firstOf;
import static org.softlang.megal.plugins.util.Pairs.secondOf;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.List;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.InjectedReasonerPlugin;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;

public class FileToObjectFunctionReasonerPlugin extends InjectedReasonerPlugin {
	@Override
	public KB derive(Relationship relationship) {

		if (!relationship.getRight().hasBinding())
			return KBs.empty();

		Object binding = relationship.getRight().getBinding();
		Class<?> home = getClass(binding, Object.class, getClass());

		if (home == null) {
			error("Can not resolve the class.");
			return KBs.empty();
		}

		Method resolved = findAccessibleMethod(home, binding);

		if (resolved == null) {
			error("Can not resolve the method.");
			return KBs.empty();
		}

		if (resolved.getParameterCount() != 1) {
			error("Can not invoke method, it needs to have one parameter.");
			return KBs.empty();
		}

		// Get first parameter
		Class<?> firstParameter = resolved.getParameterTypes()[0];
		Relationship firstRelationshipOf = firstOf(relationship.getLeft());
		Relationship secondRelationshipOf = secondOf(relationship.getLeft());

		if (firstRelationshipOf == null || secondRelationshipOf == null)
			return KBs.empty();

		Entity input = firstRelationshipOf.getLeft();
		Entity output = secondRelationshipOf.getLeft();

		if (output.hasBinding())
			return KBs.empty();

		if (input == null)
			return KBs.empty();

		if (!input.hasBinding())
			return KBs.empty();

		Artifact inputArtifact = getArtifact(input.getBinding());

		if (inputArtifact == null)
			return KBs.empty();

		try {
			Optional<Object> value = Optional.absent();
			if (ByteSource.class.isAssignableFrom(firstParameter))
				value = Optional.of(resolved.invoke(null,
						inputArtifact.getBytes()));
			else if (CharSource.class.isAssignableFrom(firstParameter))
				value = Optional.of(resolved.invoke(null,
						inputArtifact.getChars()));
			else if (InputStream.class.isAssignableFrom(firstParameter))
				try (InputStream stream = inputArtifact.getBytes().openStream()) {
					value = Optional.of(resolved.invoke(null, stream));
				}
			else if (Reader.class.isAssignableFrom(firstParameter))
				try (Reader stream = inputArtifact.getChars().openStream()) {
					value = Optional.of(resolved.invoke(null, stream));
				}
			else
				error("Cannot invoke method with parameter "
						+ firstParameter.getSimpleName(), relationship,
						firstRelationshipOf, secondRelationshipOf);

			valid(relationship, firstRelationshipOf, secondRelationshipOf);

			if (!value.isPresent())
				return KBs.empty();
			return KBs
					.builder()
					.setBindings(ImmutableMap.of(output.getName(), value.get()))
					.build();
		} catch (InvocationTargetException | IllegalAccessException
				| IllegalArgumentException | IOException e) {
			error("Error while invoking function, " + e);
			return KBs.empty();
		}
	}

	public static Method findAccessibleMethod(Class<?> home, Object binding) {
		String location = URI.create(binding.toString()).getFragment();

		Iterable<String> commands = Splitter.onPattern("[(),]")
				.omitEmptyStrings().split(location);

		Method resolved = findAccessibleMethod(home, from(commands).first()
				.orNull(), from(commands).skip(1).toList());
		return resolved;
	}

	public static Method findAccessibleMethod(Class<?> home, String name,
			List<String> signature) {
		Method resolved = null;

		nextMethod: for (Method method : home.getMethods()) {
			if (!Modifier.isStatic(method.getModifiers()))
				continue;

			if (!Modifier.isPublic(method.getModifiers()))
				continue;

			if (!equal(name, method.getName()))
				continue;

			if (signature.size() != method.getParameterCount())
				continue;

			for (int i = 0; i < signature.size(); i++)
				if (!equal(signature.get(i),
						method.getParameterTypes()[i].getSimpleName()))
					continue nextMethod;

			resolved = method;
			break;
		}
		return resolved;
	}
}
