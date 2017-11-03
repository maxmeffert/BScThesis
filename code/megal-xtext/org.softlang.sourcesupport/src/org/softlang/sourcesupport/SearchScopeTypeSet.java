package org.softlang.sourcesupport;

import org.eclipse.jdt.core.JavaModelException;
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
 * The information extracted is the fully qualified, parameterized name of the
 * type
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class SearchScopeTypeSet extends SearchScopeSet {

	public SearchScopeTypeSet(SearchEngine searchEngine, IJavaSearchScope scope) {
		super(searchEngine, scope);
	}

	@Override
	protected String extract(TypeNameMatch match) {
		if (match.getType() != null)
			try {
				return match.getType().getFullyQualifiedParameterizedName();
			} catch (JavaModelException e) {
				return null;
			}
		return null;
	}

}
