package org.softlang.megal.mi2.api;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.context.Context;

public abstract class AbstractEvaluatorPlugin extends AbstractPlugin implements EvaluatorPlugin {

	@Override
	public void evaluate(Context context, EntityType entityType) {
	}

	@Override
	public void evaluate(Context context, RelationshipType relationshipType) {
	}

	@Override
	public void evaluate(Context context, Entity entity) {
	}

	@Override
	public void evaluate(Context context, Relationship relationship) {
	}

}
