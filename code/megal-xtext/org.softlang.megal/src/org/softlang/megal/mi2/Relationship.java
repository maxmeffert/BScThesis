package org.softlang.megal.mi2;

import static com.google.common.base.Objects.equal;

/**
 * <p>
 * Base class for relationships in the model interface that supports a basic set of reasoning operations.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public abstract class Relationship extends Element {
	/**
	 * <p>
	 * Gets the left side of the relationship.
	 * </p>
	 * 
	 * @return Returns the resolved left side
	 */
	public abstract Entity getLeft();

	/**
	 * <p>
	 * Gets the name of the relationship type. This returns the name even if there is no applicable type.
	 * </p>
	 * 
	 * @return Returns the type name
	 */
	public abstract String getTypeName();

	/**
	 * <p>
	 * Gets the applied relationship type for this relationship. This may be <code>null</code> if no relationship type
	 * could be applied.
	 * </p>
	 * 
	 * @return Returns the resolved and applied type, or <code>null</code> if no type is applicable.
	 * @see #getTypeName()
	 */
	public abstract RelationshipType getType();

	/**
	 * <p>
	 * Gets the right side of the relationship.
	 * </p>
	 * 
	 * @return Returns the resolved right side
	 */
	public abstract Entity getRight();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getLeft().hashCode();
		result = prime * result + getType().hashCode();
		result = prime * result + getRight().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Relationship))
			return false;

		Relationship other = (Relationship) obj;

		if (!equal(getLeft(), other.getLeft()))
			return false;

		if (!equal(getType(), other.getType()))
			return false;

		if (!equal(getRight(), other.getRight()))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return getLeft().getName() + " " + getTypeName() + " " + getRight().getName();
	}
}