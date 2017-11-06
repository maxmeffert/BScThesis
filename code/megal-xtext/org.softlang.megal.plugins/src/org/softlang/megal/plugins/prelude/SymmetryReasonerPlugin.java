package org.softlang.megal.plugins.prelude;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

public class SymmetryReasonerPlugin extends GuidedReasonerPlugin {

	@Override
	public boolean isContextBased () {
		return true;
	}
	
	@Override
	protected void guidedDerive(Relationship relationship) throws Throwable {
		relationship(relationship.getRight().getName(), relationship.getLeft().getName(), relationship.getTypeName());
	}
	
}
