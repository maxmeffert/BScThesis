package org.softlang.megal.plugins.prelude;

import static com.google.common.collect.Iterables.getFirst;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.plugins.api.InjectedEvaluatorPlugin;

public class PairElementWhenComputed extends InjectedEvaluatorPlugin {
	@Override
	public void evaluate(Relationship relationship) {
		// Get pair
		Entity pair = relationship.getLeft();

		// Get relationships to the parameters
		Relationship firstOf = getFirst(pair.incoming("firstOf"), null);
		Relationship secondOf = getFirst(pair.incoming("secondOf"), null);

		// If any of them does not exist, return
		if (firstOf == null || secondOf == null)
			return;

		boolean firstComputed = firstOf.getLeft().hasAnnotation("Computed");
		boolean secondComputed = secondOf.getLeft().hasAnnotation("Computed");

		if (firstComputed != secondComputed)
			valid(relationship, pair, firstOf, secondOf);
		else
			error("Either first or second must be computed");
	}
}
