package org.softlang.megal.mi2.api.resolution;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.softlang.megal.mi2.api.Artifact;

public class EclipseArtifacts {
	public static Artifact toArtifact(IResource resource) {
		if (resource instanceof IContainer)
			return toArtifact((IContainer) resource);

		if (resource instanceof IFile)
			return toArtifact((IFile) resource);

		return null;
	}

	public static Artifact toArtifact(IContainer container) {
		return new IContainerArtifact(container);
	}

	public static Artifact toArtifact(IFile file) {
		return new IFileArtifact(file);
	}
}
