package org.softlang.megal.defaultprovider;

import java.util.List;
import java.util.Set;

import org.softlang.megal.defaultprovider.object.ObjectFragmentProvider;
import org.softlang.megal.fragmentprovider.FragmentProvider;

/**
 * <p>
 * Abstract typed fragment provider, checks for applicability by type checking
 * </p>
 * 
 * @author Pazuzu
 *
 * @param <T>
 *            The type to check
 */
public abstract class TypeFragmentProvider<T> extends ObjectFragmentProvider {
	/**
	 * <p>
	 * Backing field for check type
	 * </p>
	 */
	private final Class<T> type;

	/**
	 * <p>
	 * Getter for the check type
	 * </p>
	 * 
	 * @return Returns the value of the backing field
	 */
	public Class<T> getType() {
		return type;
	}

	/**
	 * <p>
	 * Constructs the type fragment provider
	 * </p>
	 * 
	 * @param type
	 *            The type to check
	 */
	public TypeFragmentProvider(Class<T> type) {
		this.type = type;
	}

	/**
	 * <p>
	 * Variant of {@link #navigate(Object, String)} with regard to type
	 * </p>
	 * 
	 * @param t
	 *            The value to navigate for
	 * @param segment
	 *            The segment to navigate over
	 * @return Returns a list of targets
	 */
	protected abstract List<? extends Object> navigateTyped(T t, String segment);

	/**
	 * <p>
	 * Variant of {@link #next(Object)} with regard to type
	 * </p>
	 * 
	 * @param t
	 *            The value to propose for
	 * @return Returns the set of available target names
	 */
	protected abstract Set<String> nextTyped(T t);

	@Override
	public boolean accept(Object node) {
		return type.isInstance(node);
	}

	@Override
	public List<? extends Object> navigate(Object node, String segment) {
		return navigateTyped(type.cast(node), segment);
	}

	@Override
	public Set<String> next(Object node) {
		return nextTyped(type.cast(node));
	}

}
