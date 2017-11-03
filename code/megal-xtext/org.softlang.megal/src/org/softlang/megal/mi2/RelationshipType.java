package org.softlang.megal.mi2;

import static com.google.common.base.Objects.equal;

import java.util.Set;

/**
 * <p>
 * Base class for relationship types in the model interface that supports a
 * basic set of reasoning operations.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public abstract class RelationshipType extends Named {
	/**
	 * <p>
	 * Gets the left input type.
	 * </p>
	 * 
	 * @return Returns the left input type
	 */
	public abstract EntityType getLeft();

	/**
	 * <p>
	 * Returns true if the left input type is a many reference.
	 * </p>
	 */
	public abstract boolean isLeftMany();

	/**
	 * <p>
	 * Gets the right input type.
	 * </p>
	 * 
	 * @return Returns the right input type
	 */
	public abstract EntityType getRight();

	/**
	 * <p>
	 * Returns true if the right input type is a many reference.
	 * </p>
	 */
	public abstract boolean isRightMany();

	/**
	 * <p>
	 * Gets all instances of this relationship type.
	 * </p>
	 * 
	 * @return Iterates over the instances
	 */
	public abstract Set<Relationship> getInstances();
	
	/**
	 * <p>
	 * Gets all subtypes of this relationship type.
	 * </p>
	 * 
	 * @return Iterates over the instances
	 */
	public abstract Set<RelationshipType> getSpecializations();

	public boolean isApplicable(Entity left, Entity right) {
		return isApplicable(left.getType(), left.isTypeMany(), right.getType(), right.isTypeMany());
	}

	public boolean isApplicable(EntityType left, boolean leftMany, EntityType right, boolean rightMany) {
		if (leftMany != isLeftMany())
			return false;

		if (rightMany != isRightMany())
			return false;

		if (equal(left, getLeft()) || left.isSpecializationOf(getLeft()))
			if (equal(right, getRight()) || right.isSpecializationOf(getRight()))
				return true;

		return false;
	}

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

		if (!(obj instanceof RelationshipType))
			return false;

		RelationshipType other = (RelationshipType) obj;

		if (!equal(getName(), other.getName()))
			return false;

		if (!equal(getLeft(), other.getLeft()))
			return false;

		if (!equal(isLeftMany(), other.isLeftMany()))
			return false;

		if (!equal(getRight(), other.getRight()))
			return false;

		if (!equal(isRightMany(), other.isRightMany()))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return getName() + " < " + (getLeft().getName() + (isLeftMany() ? "+" : "")) + " * "
				+ (getRight().getName() + (isRightMany() ? "+" : ""));
	}

	public boolean isSpecializationOf(RelationshipType x) {
		// Check left many is equal
		if (!equal(getName(), x.getName()))
			return false;

		// Check left many is equal
		if (isLeftMany() != x.isLeftMany())
			return false;

		// Check right many is equal
		if (isRightMany() != x.isRightMany())
			return false;

		// Get equals and true subtype values
		boolean le = equal(getLeft(), x.getLeft());
		boolean re = equal(getRight(), x.getRight());
		boolean las = getLeft().isSpecializationOf(x.getLeft());
		boolean ras = getRight().isSpecializationOf(x.getRight());

		// Check matrix
		return le && ras || las && re || las && ras;
	}
}