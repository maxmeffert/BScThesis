package org.softlang.megal.plugins.fragments;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

public class FragmentLanguageSubsetOfReasonerPlugin extends GuidedReasonerPlugin {

	protected void guidedDerive(Relationship relationship) throws Throwable {
		this.when(relationship.getTypeName().equals("fragmentLanguageOf"));
		this.relationship(relationship.getRight().getName(), relationship.getLeft().getName(), "subsetOf");
	}
	
}
