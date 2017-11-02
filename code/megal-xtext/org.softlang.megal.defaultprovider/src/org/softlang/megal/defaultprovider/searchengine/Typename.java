package org.softlang.megal.defaultprovider.searchengine;

import java.util.List;
import java.util.Optional;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * <p>
 * Typename composes the package as a list, the enclosing types as a list and
 * the typename as an optional string
 * <p>
 * 
 * @author Pazuzu
 *
 */
public class Typename {
	/**
	 * Backing location for package prefix
	 */
	private final ImmutableList<String> packagePrefix;

	/**
	 * Backing location for enclosing type
	 */
	private final ImmutableList<String> enclosingTypes;

	/**
	 * Backing location for the optional type name
	 */
	private final String typename;

	/**
	 * <p>
	 * Constructor, carrying the parameters into the backing
	 * </p>
	 * 
	 * @param packagePrefix
	 *            The package prefix, will be copied
	 * @param enclosingTypes
	 *            The package prefix, will be copied
	 * @param typename
	 *            The type name or null
	 */
	private Typename(List<String> packagePrefix, List<String> enclosingTypes,
			String typename) {
		this.packagePrefix = ImmutableList.copyOf(packagePrefix);
		this.enclosingTypes = ImmutableList.copyOf(enclosingTypes);
		this.typename = typename;
	}

	/**
	 * <p>
	 * Creates an incomplete type name, has not actual class but just a
	 * container
	 * </p>
	 * 
	 * @param packagePrefix
	 *            The package prefix, will be copied
	 * @param enclosingTypes
	 *            The package prefix, will be copied
	 * @return Returns a newly constructed type name
	 */
	public static Typename createIncomplete(List<String> packagePrefix,
			List<String> enclosingTypes) {
		return new Typename(packagePrefix, enclosingTypes, null);
	}

	/**
	 * <p>
	 * Creates a complete type name, has actual class
	 * </p>
	 * 
	 * @param packagePrefix
	 *            The package prefix, will be copied
	 * @param enclosingTypes
	 *            The package prefix, will be copied
	 * @param typename
	 *            The type name
	 * @return Returns a newly constructed type name
	 */
	public static Typename createComplete(List<String> packagePrefix,
			List<String> enclosingTypes, String typename) {
		return new Typename(packagePrefix, enclosingTypes, typename);
	}

	/**
	 * <p>
	 * Getter for the package prefix
	 * </p>
	 * 
	 * @return Returns the backing fields value
	 */
	public ImmutableList<String> getPackagePrefix() {
		return packagePrefix;
	}

	/**
	 * <p>
	 * Getter for the enclosing type
	 * </p>
	 * 
	 * @return Returns the backing fields value
	 */
	public ImmutableList<String> getEnclosingTypes() {
		return enclosingTypes;
	}

	/**
	 * <p>
	 * Gets the type name, throws an {@link IllegalStateException} if no type
	 * name present
	 * </p>
	 * 
	 * @return Returns the type name
	 */
	public String getTypename() {
		if (typename == null)
			throw new IllegalStateException();
		return typename;
	}

	/**
	 * <p>
	 * Status evaluator, true when a type name is present
	 * </p>
	 * 
	 * @return Returns true if type name is not null
	 */
	public boolean isComplete() {
		return typename != null;
	}

	/**
	 * <p>
	 * Views this type name as a list of segments and gets the element at the
	 * position
	 * </p>
	 * 
	 * @param i
	 *            The index to get at
	 * @return The gotten segment
	 */
	public String getSegment(int i) {
		if (i < 0)
			throw new IndexOutOfBoundsException();

		if (i < getPackagePrefix().size())
			return getPackagePrefix().get(i);

		i -= getPackagePrefix().size();

		if (i < getEnclosingTypes().size())
			return getEnclosingTypes().get(i);

		i -= getEnclosingTypes().size();
		if (i != 0)
			throw new IndexOutOfBoundsException();

		return getTypename();
	}

	/**
	 * <p>
	 * Views this type name as a list of segments and gets the size of the list
	 * </p>
	 * 
	 * @return Returns the size of the segment concatenation
	 */
	public int size() {
		return getPackagePrefix().size() + getEnclosingTypes().size()
				+ (isComplete() ? 1 : 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enclosingTypes == null) ? 0 : enclosingTypes.hashCode());
		result = prime * result
				+ ((packagePrefix == null) ? 0 : packagePrefix.hashCode());
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
		Typename other = (Typename) obj;
		if (enclosingTypes == null) {
			if (other.enclosingTypes != null)
				return false;
		} else if (!enclosingTypes.equals(other.enclosingTypes))
			return false;
		if (packagePrefix == null) {
			if (other.packagePrefix != null)
				return false;
		} else if (!packagePrefix.equals(other.packagePrefix))
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
		return "TypenamePrefix [packagePrefix=" + packagePrefix
				+ ", enclosingTypes=" + enclosingTypes + ", typename="
				+ typename + "]";
	}

	/**
	 * <p>
	 * Stores the value of load
	 * </p>
	 */
	private Optional<Class<?>> loaded = Optional.empty();

	/**
	 * <p>
	 * Tries to load the class, returns null if no class definition found
	 * </p>
	 * <p>
	 * Cache invalidation may be done by passing this object to
	 * {@link #invalidateLoad(Typename)}
	 * </p>
	 * 
	 * @return Returns the value of the cache store
	 */
	public Class<?> load() {
		if (loaded.isPresent())
			return loaded.get();

		String fqn;
		if (enclosingTypes.isEmpty()) {
			if (packagePrefix.isEmpty())
				fqn = getTypename();
			else
				fqn = Joiner.on('.').join(packagePrefix) + '.' + getTypename();
		} else {
			if (packagePrefix.isEmpty())
				fqn = Joiner.on('$').join(enclosingTypes) + '$' + getTypename();
			else
				fqn = Joiner.on('.').join(packagePrefix) + '.'
						+ Joiner.on('$').join(enclosingTypes) + '$'
						+ getTypename();
		}

		try {
			loaded = Optional.of(Class.forName(fqn));
		} catch (ClassNotFoundException e) {
			loaded = Optional.empty();
		}

		return loaded.get();
	}

	/**
	 * <p>
	 * Invalidates the stored value for {@link #load()}
	 * </p>
	 * 
	 * @param t
	 *            The type name to invalidate for
	 */
	public static void invalidateLoad(Typename t) {
		t.loaded = Optional.empty();
	}
}
