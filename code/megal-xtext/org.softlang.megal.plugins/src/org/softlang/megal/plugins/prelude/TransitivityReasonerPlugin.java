package org.softlang.megal.plugins.prelude;

import java.util.Set;
import java.util.stream.Collectors;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

public class TransitivityReasonerPlugin extends GuidedReasonerPlugin {

	@Override
	public boolean isContextBased () {
		return true;
	}
	
	@Override
	protected void guidedDerive(Relationship relationship) throws Throwable {
		KB kb = relationship.getKB();
		Set<Entity> entities = kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship.getTypeName())
						&& !r.getRight().getName().equals(relationship.getLeft().getName())
						&& r.getLeft().getName().equals(relationship.getRight().getName()) )
				.map(r -> r.getRight())
				.collect(Collectors.toSet());
		for (Entity entity : entities) {
			relationship(relationship.getLeft().getName(), entity.getName(), relationship.getTypeName());
		}
		
	}
	
}