package org.softlang.megal.plugins.prelude;

import java.util.Collection;
import java.util.stream.Collectors;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

public class ElementOfLanguageReasonerPlugin extends GuidedReasonerPlugin {
	
	private Collection<Entity> getSuperLanguagesOf(KB kb, Entity language) {
		return kb.getRelationships().stream()
				.filter(rel -> rel.getTypeName().equals("subsetOf") )
				.filter(rel -> rel.getLeft().getName().equals(language.getName()))
				.map(rel -> rel.getRight())
				.collect(Collectors.toList());
	}
	
	protected void guidedDerive(Relationship relationship) throws Throwable {
		KB kb = relationship.getKB();
		this.when(relationship.getTypeName().equals("elementOf"));
		this.when(relationship.getRight().isInstance(kb.getEntityType("Language")));
				
		for(Entity superLang : getSuperLanguagesOf(kb, relationship.getRight())) {
			this.relationship(relationship.getLeft().getName(), superLang.getName(), "elementOf");
		}
		
	}
}
