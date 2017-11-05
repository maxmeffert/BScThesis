package org.softlang.megal.plugins.prelude;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

public class FragmentOfReasonerPlugin extends GuidedReasonerPlugin {

	protected void guidedDerive(Relationship relationship) throws Throwable {
		
		this.when(relationship.getTypeName().equals("partOf"));
		this.when(relationship.getLeft().isInstance(relationship.getKB().getEntityType("Fragment")));
		
		this.relationship(relationship.getLeft().getName(), relationship.getRight().getName(), "fragmentOf");
		
	}
	
}
