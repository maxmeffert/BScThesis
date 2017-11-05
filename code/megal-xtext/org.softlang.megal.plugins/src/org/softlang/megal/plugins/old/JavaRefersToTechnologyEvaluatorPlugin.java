package org.softlang.megal.plugins.old;

import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.FluentIterable.from;

import java.io.IOException;
import java.util.Set;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedEvaluatorPlugin;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;

public class JavaRefersToTechnologyEvaluatorPlugin extends GuidedEvaluatorPlugin {
	/**
	 * <p>
	 * More like: STOP_WORD
	 * </p>
	 */
	private static final Set<String> STOP_WORDS = ImmutableSet.of("Library"
			.toLowerCase());

	private static final Set<String> getIndicators(CharSequence name) {
		return from(Splitter.on(CharMatcher.anyOf("._")).split(name))
				.transform(String::toLowerCase).filter(not(in(STOP_WORDS)))
				.toSet();
	}

	@Override
	public void guidedEvaluate(Relationship relationship) throws IOException {
		Artifact artifact = artifactOf(relationship.getLeft());

		Set<String> indicators = getIndicators(relationship.getRight()
				.getName());

		for (String indicator : indicators)
			for (String line : artifact.getChars().readLines())
				if (line.toLowerCase().contains(indicator)) {
					valid();
					return;
				}

		error("No indicator found suggesting the referral to the technology "
				+ relationship.getRight().getName()
				+ ", looking for the indicators " + indicators);

	}
}
