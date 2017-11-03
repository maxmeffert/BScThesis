package org.softlang.megal.mi2.api.resolution;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

public class DiscreteProjectResolution extends ProjectResolution {
	private final String projectName;

	public DiscreteProjectResolution(String projectName) {
		this.projectName = projectName;
	}

	@Override
	protected IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	}
}
