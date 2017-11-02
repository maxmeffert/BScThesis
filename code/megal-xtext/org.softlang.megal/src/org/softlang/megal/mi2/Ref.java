package org.softlang.megal.mi2;

/**
 * <p>
 * Reference to a defined entity type.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public final class Ref {
	/**
	 * <p>
	 * Internal backing field.
	 * </p>
	 */
	private final String type;

	/**
	 * <p>
	 * Internal backing field.
	 * </p>
	 */
	private final boolean many;

	/**
	 * <p>
	 * Internal field assigning constructor.
	 * </p>
	 */
	private Ref(String type, boolean many) {
		this.type = type;
		this.many = many;
	}

	/**
	 * <p>
	 * Constructs a reference on the given parameters.
	 * </p>
	 * 
	 * @param type
	 *            The type to refer to
	 * @param many
	 *            True if this is a many type
	 * @return Returns a new {@link Ref}
	 */
	public static Ref to(String type, boolean many) {
		return new Ref(type, many);
	}

	/**
	 * <p>
	 * Gets the name of the type to referred to.
	 * </p>
	 * 
	 * @return Returns the field
	 */
	public String getType() {
		return type;
	}

	/**
	 * <p>
	 * Returns true if this is a many reference.
	 * </p>
	 * 
	 * @return Returns the field
	 */
	public boolean isMany() {
		return many;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (many ? 1231 : 1237);
		result = prime * result + type.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Ref other = (Ref) obj;

		if (many != other.many)
			return false;
		if (!type.equals(other.type))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return getType() + (isMany() ? "+" : "");
	}
}