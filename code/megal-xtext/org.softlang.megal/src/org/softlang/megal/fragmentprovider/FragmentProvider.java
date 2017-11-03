package org.softlang.megal.fragmentprovider;

import java.util.List;
import java.util.Set;

/**
 * Extension points interface used for customization of fragment resolution.
 * 
 * @author Johannes
 *
 */
public interface FragmentProvider {

	/**
	 * <p>
	 * Returns if this node can be resolved by the fragment provider. If more
	 * than one FragmentProvider accepts this node, only the deepest nodes in
	 * the inheritance tree are used and the results of navigate are collected.
	 * </p>
	 * 
	 * @param node
	 * @return
	 */
	boolean accept(Object node);

	/**
	 * Navigates from the given node to the next segment.
	 * 
	 * @param node
	 * @param segment
	 * @return
	 */
	List<? extends Object> navigate(Object node, String segment);

	/**
	 * Used for autocomplete.
	 * 
	 * @param node
	 * @return
	 */
	Set<String> next(Object node);
}
