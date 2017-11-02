package org.softlang.megal.mi2.api;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.context.Context;

public abstract class AbstractReasonerPlugin extends AbstractPlugin implements ReasonerPlugin {
	@Override
	public KB derive(Context context, EntityType entityType) {
		return KBs.empty();
	}

	@Override
	public KB derive(Context context, RelationshipType relationshipType) {
		return KBs.empty();
	}

	@Override
	public KB derive(Context context, Entity entity) {
		return KBs.empty();
	}

	@Override
	public KB derive(Context context, Relationship relationship) {
		return KBs.empty();
	}

	@Override
	public boolean isContextBased() {
		return false;
	}
}
