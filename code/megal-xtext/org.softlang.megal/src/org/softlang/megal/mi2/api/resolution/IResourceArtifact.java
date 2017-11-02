package org.softlang.megal.mi2.api.resolution;

import static com.google.common.base.Objects.equal;

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.softlang.megal.mi2.api.Artifact;

public abstract class IResourceArtifact extends Artifact {

	protected abstract IResource getResource();

	@Override
	public boolean exists() {
		return getResource().exists();
	}

	@Override
	public URI getLocation() {
		return getResource().getLocationURI();
	}

	@Override
	public String getName() {
		return getResource().getName();
	}

	@Override
	public Artifact getParent() {
		return EclipseArtifacts.toArtifact(getResource().getParent());
	}

	@Override
	public int hashCode() {
		return getResource().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof IResourceArtifact) {
			IResourceArtifact other = (IResourceArtifact) obj;

			return equal(getResource(), other.getResource());
		}

		if (obj instanceof Artifact) {
			Artifact other = (Artifact) obj;

			return equal(getLocation(), other.getLocation());
		}

		return false;
	}

	@Override
	public String toString() {
		return getResource().toString();
	}
}