package org.softlang.megal.fragmentprovider;

import java.util.List;

/**
 * Extension points interface used for customization of fragment resolution.
 * 
 * @author Johannes
 *
 */
public interface RootProvider {
	/**
	 * Returns all root objects for this id.
	 * 
	 * @param id
	 * @return
	 */
	List<? extends Object> navigate(String protocol);

}
