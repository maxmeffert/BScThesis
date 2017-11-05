package org.softlang.megal.plugins.old;

import static com.google.common.collect.Iterables.getFirst;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;

import org.softlang.megal.plugins.api.GuidedEvaluatorPlugin;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class JavaFileDefinesStaticFunctionEvaluatorPlugin extends GuidedEvaluatorPlugin {
	@Override
	public void guidedEvaluate(Relationship relationship) throws IOException,
			URISyntaxException {
		// Get artifact and binding
		Artifact javaFile = artifactOf(relationship.getLeft());
		URI binding = new URI(bindingOf(relationship.getRight()).toString());

		// Responsible when classpath is the schema specific part
		when("classpath".equals(binding.getScheme()));

		// Obtain qualified name and function
		String qname = binding.getSchemeSpecificPart();
		String function = binding.getFragment();

		// Split qualified name
		List<String> split = Splitter.on('.').omitEmptyStrings()
				.splitToList(qname);
		// Find package and class name
		String frag = Joiner.on('.').join(split.subList(0, split.size() - 2));
		String name = split.get(split.size() - 1);

		// Find function name
		String fname = getFirst(
				Splitter.on('(').omitEmptyStrings().split(function), null);

		// Get file content and check it
		String file = javaFile.getChars().read();

		if (!file.contains(frag)) {
			error("Not in the same package.");
			return;
		}

		if (!(file.contains("class " + name) || file.contains("interface "
				+ name))) {
			error("Does not define class or interface " + name + ".");
			return;
		}

		if (!file.contains(fname)) {
			error("Does not contain method symbol " + fname + "!");
			return;
		}

		valid();
	}
}
