package org.softlang.megal.mi2.api.resolution;

import static com.google.common.collect.Lists.transform;
import static java.util.Collections.emptyList;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.softlang.megal.mi2.api.Artifact;

import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;

public class IContainerArtifact extends IResourceArtifact {
	private final IContainer container;

	public IContainerArtifact(IContainer container) {
		this.container = container;
	}

	@Override
	protected IContainer getResource() {
		return container;
	}

	@Override
	public List<? extends Artifact> getChildren() {
		try {
			return transform(Arrays.asList(getResource().members()), EclipseArtifacts::toArtifact);
		} catch (CoreException e) {
			return emptyList();
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The name equality condition is relaxed, as case sensitivity is not present in the context of resources.
	 * </p>
	 */
	@Override
	public Artifact getChild(String name) {
		for (Artifact child : getChildren())
			if (name.equalsIgnoreCase(child.getName()))
				return child;

		return null;
	}

	@Override
	public boolean hasContent() {
		return false;
	}

	@Override
	public ByteSource getBytes() {
		throw new IllegalStateException("Can not read bytes from a container");
	}

	@Override
	public CharSource getChars() {
		throw new IllegalStateException("Can not read chars from a container");
	}
}