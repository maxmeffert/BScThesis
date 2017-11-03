package plugins.util;

import static com.google.common.base.Objects.equal;
import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newLinkedList;
import static com.google.common.collect.Sets.newHashSet;

import java.util.Deque;
import java.util.Set;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.Relationship;

public class Prelude {
	public static boolean isInstance(Entity entity, String type) {
		EntityType entityType = entity.getKB().getEntityType(type);
		if (entityType == null)
			return false;

		return entity.isInstance(entityType);
	}

	public static Iterable<Entity> outgoingTo(Entity entity, String name) {
		return from(entity.outgoing(name)).transform(Relationship::getRight);
	}

	public static Iterable<Entity> incomingFrom(Entity entity, String name) {
		return from(entity.incoming(name)).transform(Relationship::getLeft);
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
}
