package org.softlang.megal.plugins.util;

import static com.google.common.base.Objects.equal;
//import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newLinkedList;
import static com.google.common.collect.Sets.newHashSet;
import java.util.Deque;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Relationship;

/**
 * 
 * @author maxmeffert
 *
 */
public class Prelude {
	
	/* ==================================================================
	 * Prelude Entity Sub-Types
	 * ==================================================================
	 */
	
	static final public String ARTIFACT = "Artifact";
	static final public String CONCEPT = "Concept";
	static final public String FUNCTION = "Function";
	static final public String SET = "SET";
	static final public String TECHNOLOGY = "Technology";
	static final public String LANGUAGE = "Language";
	static final public String FILE = "File";
	static final public String FOLDER = "Folder";
	static final public String FRAGMENT = "Fragment";
	static final public String RESOURCE = "Resource";
	static final public String TRANSIENT = "Transient";
	static final public String PLUGIN = "Plugin";
	
	/* ==================================================================
	 * Instance-level Type-Checkers
	 * ==================================================================
	 */
	
	static public boolean isInstance(Entity entity, String type) {
		
		EntityType entityType = entity.getKB().getEntityType(type);
		
		if (entityType == null) {
			return false;
		}

		return entity.isInstance(entityType);
		
	}
	
	static public boolean isArtifact (Entity entity) {
		return isInstance(entity,ARTIFACT);
	}
	
	static public boolean isConcept (Entity entity) {
		return isInstance(entity,CONCEPT);
	}
	
	static public boolean isFunction (Entity entity) {
		return isInstance(entity,FUNCTION);
	}
	
	static public boolean isSet (Entity entity) {
		return isInstance(entity,SET);
	}
	
	static public boolean isTechnology (Entity entity) {
		return isInstance(entity,TECHNOLOGY);
	}
	
	static public boolean isLanguage (Entity entity) {
		return isInstance(entity,LANGUAGE);
	}
	
	static public boolean isFile (Entity entity) {
		return isInstance(entity,FILE);
	}
	
	static public boolean isFolder (Entity entity) {
		return isInstance(entity,FOLDER);
	}
	
	static public boolean isFragment (Entity entity) {
		return isInstance(entity,FRAGMENT);
	}
	
	static public boolean isResource (Entity entity) {
		return isInstance(entity,RESOURCE);
	}
	
	static public boolean isTransient (Entity entity) {
		return isInstance(entity,TRANSIENT);
	}
	
	static public boolean isPlugin (Entity entity) {
		return isInstance(entity,PLUGIN);
	}

	/* ==================================================================
	 * Instance-level Type-Checkers
	 * ==================================================================
	 */
	
	static public boolean isAssignable (Entity left, Relationship relationship, Entity right) {
		
		return (left.getType().equals(relationship.getType().getLeft())
				&& right.getType().equals(relationship.getType().getRight()));
		
	}
	
	static public boolean ok (Entity left, Relationship relationship, Entity right) {
		
		return outgoingTo(left, relationship.getTypeName()).contains(right);
		
	}
	
	public static Set<Entity> outgoingTo(Entity entity, String relationshipName) {
		
//		return entity.getKB().getRelationships().stream()
//				.filter( r -> r.getTypeName().equals(name) && r.getLeft().equals(entity))
//				.map( r -> r.getRight() )
//				.collect(Collectors.toSet());
		
		return entity.outgoing(relationshipName).stream()
				.map(Relationship::getRight)
				.collect(Collectors.toSet());
		
//		return from(entity.outgoing(relationshipName)).transform(Relationship::getRight);
		
	}

	public static Set<Entity> incomingFrom(Entity entity, String relationshipName) {
		
		return entity.incoming(relationshipName).stream()
				.map(Relationship::getLeft)
				.collect(Collectors.toSet());
		
//		return from(entity.incoming(relationshipName)).transform(Relationship::getLeft);
		
	}

	public static boolean isElementOfLanguage(Entity entity, String language) {
		return isElementOfLanguage(entity, entity.getKB().getEntity(language));
	}

	public static boolean isElementOfLanguage(Entity entity, Entity language) {
		for (Entity other : outgoingTo(entity, "elementOf"))
			if (isLanguageAssignable(other, language))
				return true;

		return false;
	}

	public static boolean isLanguageAssignable(Entity sub, String language) {
		return isLanguageAssignable(sub, sub.getKB().getEntity(language));
	}

	public static boolean isLanguageAssignable(Entity sub, Entity language) {
		if (!isInstance(sub, "Language"))
			return false;
		if (!isInstance(language, "Language"))
			return false;

		if (equal(language, sub))
			return true;

		Set<Entity> visited = newHashSet();
		Deque<Entity> candidates = newLinkedList(outgoingTo(sub, "subsetOf"));

		while (!candidates.isEmpty()) {
			Entity superset = candidates.poll();

			if (equal(language, superset))
				return true;

			if (!isInstance(superset, "Language"))
				continue;

			visited.add(superset);

			for (Entity supSup : outgoingTo(superset, "subsetOf"))
				if (!visited.contains(supSup))
					candidates.offer(supSup);
		}

		return false;
	}
	
	/* ==================================================================
	 * Instance-level Type-Checkers
	 * ==================================================================
	 */
	
	static public Set<Entity> getInstancesWhere (KB kb, Predicate<Entity> predicate) {
		
		return kb.getEntities().stream()
				.filter(predicate)
				.collect(Collectors.toSet());
		
	}
	
	static public Set<Entity> getInstancesOf (KB kb, String type) {
		
		return getInstancesWhere(kb, e -> isInstance(e, type) );
		
	}
	
	static public Set<Entity> getArtifacts (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isArtifact);
		
	}
	
	static public Set<Entity> getConcepts (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isConcept);
		
	}
	
	static public Set<Entity> getFunctions (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isFunction);
		
	}
	
	static public Set<Entity> getSets (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isSet);
		
	}
	
	static public Set<Entity> getTechnologies (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isTechnology);
		
	}
	
	static public Set<Entity> getLanguages (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isLanguage);
		
	}
	
	static public Set<Entity> getFiles (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isFile);
		
	}
	
	static public Set<Entity> getFolders (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isFolder);
		
	}
	
	static public Set<Entity> getFragments (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isFragment);
		
	}
	
	static public Set<Entity> getResources (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isResource);
		
	}
	
	static public Set<Entity> getTransients (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isTransient);
		
	}
	
	static public Set<Entity> getPlugins (KB kb) {
		
		return getInstancesWhere(kb, Prelude::isPlugin);
		
	}
	
	
	
	public static Entity firstEntityOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Entity first : incomingFrom(pair, "firstOf"))
			return first;

		return null;
	}

	public static Entity secondEntityOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Entity second : incomingFrom(pair, "secondOf"))
			return second;

		return null;
	}

	public static Relationship firstOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Relationship first : pair.incoming("firstOf"))
			return first;

		return null;
	}

	public static Relationship secondOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Relationship second : pair.incoming("secondOf"))
			return second;

		return null;
	}
	
}
