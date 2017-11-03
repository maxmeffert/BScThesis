package org.softlang.megal.defaultprovider.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.softlang.megal.defaultprovider.object.ObjectFragmentProvider;

public class ResourceFragmentProvider extends ObjectFragmentProvider {

	@Override
	public boolean accept(Object node) {
		return node instanceof IResource;
	}

	@Override
	public List<? extends Object> navigate(Object node, String segment) {
		return getChildren((IContainer) node).stream().filter(x -> x.getName().equals(segment))
				.collect(Collectors.toList());
	}	

	private List<IResource> getChildren(IResource node) {
		List<IResource> children = new ArrayList<IResource>();

		if (node instanceof IContainer) {
			IContainer container = (IContainer) node;
			try {
				for (IResource child : container.members()) {
					children.add(child);
				}

			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return children;
	}

	@Override
	public Set<String> next(Object node) {
		return getChildren((IResource) node).stream().map(x -> x.getName())
				.collect(Collectors.toSet());
	}
}
