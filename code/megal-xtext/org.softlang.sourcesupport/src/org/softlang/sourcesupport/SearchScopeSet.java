package org.softlang.sourcesupport;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;

import com.google.common.collect.Sets;

/**
 * <p>
 * The search scope set extracts string from all type names found in the search
 * scope.
 * </p>
 * <p>
 * Containment check is performed without extracting all information
 * </p>
 * 
 * @author Pazuzu
 *
 */
public abstract class SearchScopeSet implements Set<String> {
	private final SearchEngine searchEngine;

	private final IJavaSearchScope scope;;

	private Set<String> calculated = null;

	public SearchScopeSet(SearchEngine searchEngine, IJavaSearchScope scope) {
		this.searchEngine = searchEngine;
		this.scope = scope;
	}

	public SearchEngine getSearchEngine() {
		return searchEngine;
	}

	public IJavaSearchScope getScope() {
		return scope;
	}

	/**
	 * <p>
	 * Tries to find the first match
	 * 
	 * @param value
	 * @return
	 */
	private boolean find(String value) {
		/**
		 * <p>
		 * I really really hate me for canceling with an exception
		 * </p>
		 * 
		 * @author Pazuzu
		 *
		 */
		class CancelSearch extends RuntimeException {
			private static final long serialVersionUID = 102495304033209430L;
		}

		try {
			// Search with help of engine
			searchEngine.searchAllTypeNames(null, 0, null, 0,
					IJavaSearchConstants.TYPE, scope,
					new TypeNameMatchRequestor() {
						@Override
						public void acceptTypeNameMatch(TypeNameMatch match) {
							// If matching, throw cancellation
							if (Objects.equals(value, extract(match)))
								throw new CancelSearch();
						}
					}, IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);

			// If the search returned, no cancellation and therefore no match
			return false;
		} catch (CancelSearch e) {
			// If thrown, than a match occurred
			return true;
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
	}

	private void calculate() {
		if (calculated != null)
			return;

		try {
			calculated = Sets.newHashSet();

			// Search with help of engine
			searchEngine.searchAllTypeNames(null, 0, null, 0,
					IJavaSearchConstants.TYPE, scope,
					new TypeNameMatchRequestor() {
						@Override
						public void acceptTypeNameMatch(TypeNameMatch match) {
							String value = extract(match);
							if (value != null)
								calculated.add(value);
						}
					}, IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract String extract(TypeNameMatch match);

	@Override
	public int size() {
		calculate();

		return calculated.size();
	}

	@Override
	public boolean isEmpty() {
		calculate();

		return calculated.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if (o instanceof String) {
			if (calculated == null)
				return find((String) o);
			else
				return calculated.contains(o);
		}
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		calculate();

		return calculated.iterator();
	}

	@Override
	public Object[] toArray() {
		return calculated.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return calculated.toArray(a);
	}

	@Override
	public boolean add(String e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c)
			if (!contains(o))
				return false;

		return true;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((calculated == null) ? 0 : calculated.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result
				+ ((searchEngine == null) ? 0 : searchEngine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof Set<?>) {
			Set<?> other = (Set<?>) obj;

			return this.containsAll(other) && other.containsAll(this);
		}

		return false;
	}

	@Override
	public String toString() {
		return scope
				+ (calculated == null ? " unexhausted" : " exhausted, "
						+ calculated);
	}
}
