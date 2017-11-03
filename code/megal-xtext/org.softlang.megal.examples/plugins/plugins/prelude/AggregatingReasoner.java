package plugins.prelude;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.AbstractReasonerPlugin;
import org.softlang.megal.mi2.api.Plugin;
import org.softlang.megal.mi2.api.ReasonerPlugin;
import org.softlang.megal.mi2.api.context.Context;

public class AggregatingReasoner extends AbstractReasonerPlugin {
	@Override
	public KB derive(Context context, Entity entity) {
		KB r = KBs.empty();
		for (Plugin p : getParts())
			if (p instanceof ReasonerPlugin)
				r = KBs.union(r, ((ReasonerPlugin) p).derive(context, entity));

		return r;
	}

	@Override
	public KB derive(Context context, EntityType entityType) {
		KB r = KBs.empty();
		for (Plugin p : getParts())
			if (p instanceof ReasonerPlugin)
				r = KBs.union(r, ((ReasonerPlugin) p).derive(context, entityType));

		return r;
	}

	@Override
	public KB derive(Context context, Relationship relationship) {
		KB r = KBs.empty();
		for (Plugin p : getParts())
			if (p instanceof ReasonerPlugin)
				r = KBs.union(r, ((ReasonerPlugin) p).derive(context, relationship));

		return r;
	}

	@Override
	public KB derive(Context context, RelationshipType relationshipType) {
		KB r = KBs.empty();
		for (Plugin p : getParts())
			if (p instanceof ReasonerPlugin)
				r = KBs.union(r, ((ReasonerPlugin) p).derive(context, relationshipType));

		return r;
	}

}
