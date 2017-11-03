package org.softlang.megal.fragmentprovider;

import static com.google.common.collect.Iterables.skip;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.softlang.megal.util.Persistent.append;
import static org.softlang.megal.util.Persistent.concatenate;
import static org.softlang.megal.util.Persistent.prepend;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.google.common.base.Splitter;

public class Evaluator {

	private static final String FRAGMENT_PROVIDER_ID = "org.softlang.megal.FragmentProvider";
	private static final String ROOT_PROVIDER_ID = "org.softlang.megal.RootProvider";

	private final Collection<RootProvider> rootProviders = new ArrayList<RootProvider>();
	private final Collection<FragmentProvider> fragmentProviders = new ArrayList<FragmentProvider>();

	private final Map<FragmentProvider, Set<FragmentProvider>> fragmentProviderSubTypes = new HashMap<FragmentProvider, Set<FragmentProvider>>();

	public Evaluator() {

		try {
			// Initialise provider collections.
			rootProviders.addAll(getAllRootProviders());
			fragmentProviders.addAll(getAllFragmentProvider());

			// Initialise subtypes.
			for (FragmentProvider fragmentProvider : fragmentProviders) {

				Set<FragmentProvider> subtypes = new HashSet<FragmentProvider>();
				fragmentProviderSubTypes.put(fragmentProvider, subtypes);

				for (FragmentProvider subtype : fragmentProviders) {
					if (subtype == fragmentProvider)
						continue;

					if (fragmentProvider.getClass().isAssignableFrom(subtype.getClass()))
						subtypes.add(subtype);
				}
			}

		} catch (CoreException e) {
			// Error while initialisation of plugin list.
			e.printStackTrace();
		}
	}

	private static boolean isNet(URI uri) {
		return uri.getSchemeSpecificPart().startsWith("//");
	}

	private static List<String> allSegments(URI uri) {
		if (uri.isOpaque()) {
			List<String> result = singletonList(uri.getSchemeSpecificPart());

			if (uri.getScheme() != null)
				result = prepend(uri.getScheme(), result);

			if (uri.getFragment() != null)
				result = append(result, uri.getFragment());

			return result;
		} else {
			List<String> result = emptyList();

			if (uri.getScheme() != null)
				result = append(result, uri.getScheme());

			if (uri.getUserInfo() != null)
				result = append(result, uri.getUserInfo());

			if (uri.getHost() != null)
				result = append(result, uri.getHost());

			if (uri.getPort() != -1)
				result = append(result, Integer.toString(uri.getPort()));

			// Potentially followed by a path
			if (uri.getPath() != null)
				result = concatenate(result, Splitter.on('/').omitEmptyStrings().splitToList(uri.getPath()));

			// Then query
			if (uri.getQuery() != null)
				result = append(result, uri.getQuery());

			// And finally
			if (uri.getFragment() != null)
				result = append(result, uri.getFragment());

			return result;
		}
	}

	public List<Object> evaluate(URI uri) {
		List<Object> current = roots(uri.getScheme(), isNet(uri));
		for (String segment : skip(allSegments(uri), 1))
			current = navigate(current, segment);

		return current;
	}

	public Set<String> next(Object object) {
		Set<String> result = new HashSet<String>();

		for (FragmentProvider fragmentProvider : getApplicableFragmentProviders(object))
			result.addAll(fragmentProvider.next(object));

		return result;
	}

	private List<Object> navigate(List<Object> currents, String segment) {
		List<Object> nexts = new ArrayList<Object>();

		for (Object current : currents)
			nexts.addAll(navigate(current, segment));

		return nexts;
	}

	private List<Object> navigate(Object current, String segment) {
		// Get fragment providers applicable on this object.
		List<FragmentProvider> applicableProviders = getApplicableFragmentProviders(current);

		// Navigate to next nodes.
		List<Object> nexts = new ArrayList<Object>();

		for (FragmentProvider applicableProvider : applicableProviders) {
			nexts.addAll(applicableProvider.navigate(current, segment));
		}

		return nexts;
	}

	private List<FragmentProvider> getApplicableFragmentProviders(Object current) {
		List<FragmentProvider> allFragmentProviders = fragmentProviders.stream().filter(x -> x.accept(current))
				.collect(Collectors.toList());

		List<FragmentProvider> applicableFragmentProvider = new ArrayList<FragmentProvider>();

		for (FragmentProvider fragmentProvider : allFragmentProviders) {
			boolean valid = true;

			for (FragmentProvider subType : fragmentProviderSubTypes.get(fragmentProvider)) {
				if (allFragmentProviders.contains(subType)) {
					valid = false;
					break;
				}
			}

			if (valid)
				applicableFragmentProvider.add(fragmentProvider);
		}

		return applicableFragmentProvider;
	}

	private List<Object> roots(String protocol, boolean net) {
		List<Object> result = new ArrayList<Object>();

		// TODO: think of solution for net.
		for (RootProvider rootProvider : rootProviders) {
			result.addAll(rootProvider.navigate(protocol));
		}

		return result;
	}

	/**
	 * Getting the extension points of current platform.
	 * 
	 * @return
	 * @throws CoreException
	 */
	private Set<RootProvider> getAllRootProviders() throws CoreException {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = reg.getConfigurationElementsFor(ROOT_PROVIDER_ID);

		Set<RootProvider> result = new HashSet<RootProvider>();

		for (IConfigurationElement element : elements) {
			result.add((RootProvider) element.createExecutableExtension("class"));
		}

		return result;
	}

	/**
	 * Getting the extension points of current platform.
	 * 
	 * @return
	 * @throws CoreException
	 */
	private Set<FragmentProvider> getAllFragmentProvider() throws CoreException {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = reg.getConfigurationElementsFor(FRAGMENT_PROVIDER_ID);

		Set<FragmentProvider> result = new HashSet<FragmentProvider>();

		for (IConfigurationElement element : elements) {
			result.add((FragmentProvider) element.createExecutableExtension("class"));
		}

		return result;
	}

}
