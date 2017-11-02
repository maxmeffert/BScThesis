package plugins.prelude;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.AbstractEvaluatorPlugin;
import org.softlang.megal.mi2.api.EvaluatorPlugin;
import org.softlang.megal.mi2.api.Plugin;
import org.softlang.megal.mi2.api.context.Context;

public class AggregatingEvaluator extends AbstractEvaluatorPlugin {
	@Override
	public void evaluate(Context context, Entity entity) {
		for (Plugin p : getParts())
			if (p instanceof EvaluatorPlugin)
				((EvaluatorPlugin) p).evaluate(context, entity);
	}

	@Override
	public void evaluate(Context context, EntityType entityType) {
		for (Plugin p : getParts())
			if (p instanceof EvaluatorPlugin)
				((EvaluatorPlugin) p).evaluate(context, entityType);
	}

	@Override
	public void evaluate(Context context, Relationship relationship) {
		for (Plugin p : getParts())
			if (p instanceof EvaluatorPlugin)
				((EvaluatorPlugin) p).evaluate(context, relationship);
	}

	@Override
	public void evaluate(Context context, RelationshipType relationshipType) {
		for (Plugin p : getParts())
			if (p instanceof EvaluatorPlugin)
				((EvaluatorPlugin) p).evaluate(context, relationshipType);
	}

}
