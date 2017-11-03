package org.softlang.megal.mi2.api;

import org.softlang.megal.mi2.Element;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.context.Context;

public class Plugins {

	public static KB apply(ReasonerPlugin plugin, Context context, Element element) {
		if (element instanceof EntityType)
			return plugin.derive(context, (EntityType) element);
		else if (element instanceof RelationshipType)
			return plugin.derive(context, (RelationshipType) element);
		else if (element instanceof Entity)
			return plugin.derive(context, (Entity) element);
		else if (element instanceof Relationship)
			return plugin.derive(context, (Relationship) element);
	
		return KBs.empty();
	}

	public static void apply(EvaluatorPlugin plugin, Context context, Element element) {
		if (element instanceof EntityType)
			plugin.evaluate(context, (EntityType) element);
		else if (element instanceof RelationshipType)
			plugin.evaluate(context, (RelationshipType) element);
		else if (element instanceof Entity)
			plugin.evaluate(context, (Entity) element);
		else if (element instanceof Relationship)
			plugin.evaluate(context, (Relationship) element);
	}

}
