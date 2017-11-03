package org.softlang.megal.defaultprovider.searchengine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.softlang.megal.fragmentprovider.RootProvider;

public class SearchEngineRoot implements RootProvider {
	/**
	 * <p>The decomposition pattern for the qualified names</p>
	 */
	private static final Pattern DECOMPOSITION = Pattern.compile("\\.");

	/**
	 * <p>The search engine used for searching type names</p>
	 */
	private final SearchEngine engine = new SearchEngine();

	/**
	 *  <p>The search scope on the entire workspace</p>
	 */
	private final IJavaSearchScope scope = SearchEngine.createWorkspaceScope();

	@Override
	public List<? extends Object> navigate(String protocol) {
		if (!"classpath".equals(protocol))
			return Collections.emptyList();

		try {
			// Make result vector
			TypenameDatabase database = new TypenameDatabase();

			// Search with help of engine
			engine.searchAllTypeNames(null, 0, null, 0,
					IJavaSearchConstants.TYPE, scope,
					new TypeNameMatchRequestor() {
						@Override
						public void acceptTypeNameMatch(TypeNameMatch match) {
							// Split the package by the decomposition pattern
							String[] px = DECOMPOSITION.split(match
									.getPackageName());

							// Split the type container name by the
							// decomposition pattern
							String[] ex = DECOMPOSITION.split(match
									.getTypeContainerName());

							// Compose a match
							Typename item = Typename.createComplete(
									// Package is complete as is
									Arrays.asList(px),
									// Type container name contains the
									// package
									// name as a prefix
									Arrays.asList(ex).subList(px.length,
											ex.length),
									match.getSimpleTypeName());

							// Add it to the matches database
							database.getTypenames().add(item);
						}
					}, IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);

			// Return the database
			return Collections.singletonList(database);

		} catch (CoreException e) {
			// Throw wrapped exception
			throw new RuntimeException(e);
		}
	}
}
