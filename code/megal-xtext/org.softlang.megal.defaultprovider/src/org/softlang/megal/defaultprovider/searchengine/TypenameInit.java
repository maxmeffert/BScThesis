package org.softlang.megal.defaultprovider.searchengine;

/**
 * <p>
 * Skips a part in the type name
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class TypenameInit {
	/**
	 * <p>
	 * Backing field for the type name
	 * </p>
	 */
	private final Typename typename;
	/**
	 * <p>
	 * Backing field for the skip amount
	 * </p>
	 */
	private final int skip;

	/**
	 * <p>
	 * Consturcts the init
	 * </p>
	 * 
	 * @param typename
	 *            The type name to skip in
	 * @param skip
	 *            The amount of items skipped
	 */
	public TypenameInit(Typename typename, int skip) {
		this.typename = typename;
		this.skip = skip;
	}

	/**
	 * <p>
	 * Gets the complete type name
	 * </p>
	 * 
	 * @return Returns the value of the backing field
	 */
	public Typename getTypename() {
		return typename;
	}

	/**
	 * <p>
	 * Gets the skip amount
	 * </p>
	 * 
	 * @return Returns the value of the backing field
	 */
	public int getSkip() {
		return skip;
	}

	/**
	 * <p>
	 * Returns true if the init has another following element, be it another
	 * init or a final type name
	 * </p>
	 * 
	 * @return Returns true if skip is less than the size of the type name minus
	 *         one
	 */
	public boolean hasNext() {
		return skip < typename.size() - 1;
	}

	/**
	 * <p>
	 * Gets the value of the next segment
	 * </p>
	 * 
	 * @return Returns the type names segments gotten at skip plus one
	 */
	public String nextSegment() {
		return typename.getSegment(skip + 1);
	}

	/**
	 * <p>
	 * Returns either the next init or the complete type name
	 * </p>
	 * 
	 * @return Decides on next availability, returns either value of the backing
	 *         field or another type name init
	 */
	public Object next() {
		if (skip == typename.size() - 1)
			return typename;
		else
			return new TypenameInit(typename, skip + 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skip;
		result = prime * result
				+ ((typename == null) ? 0 : typename.hashCode());
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
		TypenameInit other = (TypenameInit) obj;
		if (skip != other.skip)
			return false;
		if (typename == null) {
			if (other.typename != null)
				return false;
		} else if (!typename.equals(other.typename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypenameInit [typename=" + typename + ", skip=" + skip + "]";
	}
}
