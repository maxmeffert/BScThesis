package org.softlang.megal.mi2.api.resolution;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.softlang.sourcesupport.SourceSupportPlugin;

public class ContainingProjectResolution extends ProjectResolution {
	private final EObject contained;

	public ContainingProjectResolution(EObject contained) {
		this.contained = contained;
	}

	@Override
	protected IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(SourceSupportPlugin.findProjectName(contained));
	}
}
