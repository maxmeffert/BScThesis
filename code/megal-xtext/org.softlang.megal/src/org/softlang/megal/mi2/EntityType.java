package org.softlang.megal.mi2;

import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Set;

import org.softlang.megal.util.Persistent;

import com.google.common.collect.ImmutableList;

/**
 * <p>
 * Base class for entity type in the model interface that supports a basic set of reasoning operations.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public abstract class EntityType extends Named {
	public static boolean isTheEntityType(EntityType entityType) {
		return KB.ENTITY.equals(entityType.getName());
	}

	/**
	 * <p>
	 * Gets the supertype of the entity type. If the type is the base type {@link BasicKB#ENTITY}, then this method
	 * returns <code>this</code>.
	 * </p>
	 * 
	 * @return Returns the super type
	 */
	public abstract EntityType getSupertype();

	/**
	 * <p>
	 * Gets all instances of this entity type.
	 * </p>
	 * 
	 * @return Iterates over the instances
	 */
	public abstract Set<Entity> getInstances();

	/**
	 * <p>
	 * Gets all subtypes of this entity type.
	 * </p>
	 * 
	 * @return Iterates over the instances
	 */
	public abstract Set<EntityType> getSpecializations();

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof EntityType))
			return false;

		EntityType other = (EntityType) obj;

		return equal(getName(), other.getName());
	}

	@Override
	public String toString() {
		if (getSupertype() == null)
			return getName();

		return getName() + " < " + getSupertype().getName();
	}

	/**
	 * <p>
	 * Gets the supertypes of this entity type.
	 * </p>
	 * 
	 * @return Returns a sequence of supertypes
	 */
	public ImmutableList<EntityType> getSupertypeHierarchy() {
		ImmutableList.Builder<EntityType> builder = ImmutableList.builder();

		EntityType x = this;
		while ((x = x.getSupertype()) != null)
			builder.add(x);

		return builder.build();
	}

	/**
	 * <p>
	 * Tests if this is assignable to a store of the given type.
	 * </p>
	 * 
	 * @param other
	 *            The type to check
	 * @return True if assignable
	 */
	public boolean isSpecializationOf(EntityType other) {
		EntityType x = this;
		while ((x = x.getSupertype()) != null) {
			if (equal(x, other))
				return true;
		}

		return false;
	}

	/**
	 * <p>
	 * Returns the first common supertype of the inputs.
	 * </p>
	 * 
	 * @param x
	 *            The first entity type
	 * @param y
	 *            The second entity type
	 * @param zs
	 *            The remaining entity types
	 * @return Returns the first common entity type
	 */
	public static EntityType gcd(EntityType x, EntityType y, EntityType... zs) {
		// Get supertype hierarchies
		List<EntityType> aSupertypes = Persistent.prepend(x, x.getSupertypeHierarchy());
		List<EntityType> bSupertypes = Persistent.prepend(y, y.getSupertypeHierarchy());

		// Make a common list
		List<EntityType> common = newArrayList(aSupertypes);
		common.retainAll(bSupertypes);

		// First common element is the greatest common divisor
		EntityType result = common.get(0);

		// Apply to remaining
		for (EntityType z : zs)
			result = gcd(result, z);

		return result;
	}
}