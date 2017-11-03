package org.softlang.megal.plugins.old;

import static com.google.common.collect.Lists.transform;
import static java.util.Arrays.asList;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedEvaluatorPlugin;

import com.google.common.base.Joiner;

public class ObjectCorrespondsToJavaFiles extends GuidedEvaluatorPlugin {
	private static String createSignatureString(Class<?>[] p) {
		return Joiner.on(", ").join(transform(asList(p), Class::getSimpleName));
	}

	@Override
	public void guidedEvaluate(Relationship relationship) throws IOException {
		// Get the object and the artifact parent
		Object object = bindingOf(relationship.getLeft());
		Artifact right = artifactOf(relationship.getRight());

		// Get the object class
		Class<?> objectClass = object.getClass();

		// Needs to be in the artifact
		Artifact corrChild = right.getChild(objectClass.getSimpleName()
				+ ".java");

		if (corrChild != null && corrChild.exists()) {
			String content = corrChild.getChars().read();
			boolean invalidated = false;

			// Check all the fields
			for (Field field : objectClass.getDeclaredFields())
				if (invalidated |= !content.contains(field.getName()))
					error("Cannot find the declared field " + field.getName()
							+ ": " + field.getType());

			// Check all the methods
			for (Method method : objectClass.getDeclaredMethods())
				if (invalidated |= !content.contains(method.getName()))
					error("Cannot find the declared method" + method.getName()
							+ "("
							+ createSignatureString(method.getParameterTypes())
							+ ")" + ": " + method.getReturnType());

			// No invalidation evidence found, regard as valid
			if (!invalidated)
				valid();
		} else
			// No java file
			error("Can not find a file corresponding to "
					+ objectClass.getSimpleName() + ".");
	}
}
