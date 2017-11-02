package org.softlang.sourcesupport;

import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameMatch;

/**
 * <p>
 * The search scope set extracts string from all type names found in the search
 * scope.
 * </p>
 * <p>
 * Containment check is performed without extracting all information
 * </p>
 * <p>
 * The extracted information is the name of the package
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class SearchScopePackageSet extends SearchScopeSet {

	public SearchScopePackageSet(SearchEngine searchEngine,
			IJavaSearchScope scope) {
		super(searchEngine, scope);
	}

	@Override
	protected String extract(TypeNameMatch match) {
		return match.getPackageName();
	}

}
