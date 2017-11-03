package org.softlang.megal.mi2.api.resolution;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.filter;
import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.softlang.megal.MegalPlugin;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.sourcesupport.SourceSupport;
import org.softlang.sourcesupport.SourceSupportPlugin;

import com.google.common.collect.ImmutableList;

public abstract class ProjectResolution extends AbstractResolution {

	protected abstract IProject getProject();

	@Override
	public SourceSupport getSourceSupport() {
		return SourceSupportPlugin.getSupport().analyze(getProject());
	}

	private Iterable<IResource> unbindEclipse(Object object) {
		// If object is an URI
		if (object instanceof URI)
			return filter(MegalPlugin.getEvaluator().evaluate((URI) object), IResource.class);

		// If object is a string
		if (object instanceof String) {
			String string = (String) object;
			try {
				return unbindEclipse(new URI(string));
			} catch (URISyntaxException e) {
				// Convert to file
				File file = new File(string);

				try {
					// Get project workspace URI
					URI projectURI = new URI("workspace:/" + getProject().getName() + "/");
					// Get workspace relative file URI
					URI rootRelativeURI = getProject().getLocationURI().relativize(file.toURI());

					// Unbind the composite
					return unbindEclipse(projectURI.resolve(rootRelativeURI));
				} catch (URISyntaxException f) {
					return emptyList();
				}
			}
		}

		return emptyList();
	}

	private Iterable<URL> unbindWeb(Object object) {
		if (object instanceof URL)
			return singleton((URL) object);

		if (object instanceof URI)
			try {
				return unbindWeb(((URI) object).toURL());
			} catch (MalformedURLException e) {
				return emptyList();
			}

		if (object instanceof String)
			try {
				return unbindWeb(new URI((String) object));
			} catch (URISyntaxException e) {
				return emptyList();
			}

		return emptyList();

	}

	@Override
	public List<Artifact> getArtifacts(Object binding) {
		// Enumerate eclipse artifacts
		Iterable<Artifact> eclipseArtifacts = from(unbindEclipse(binding)).transform(EclipseArtifacts::toArtifact);

		// Enumerate web artifacts
		Iterable<Artifact> webArtifacts = from(unbindWeb(binding)).transform(WebArtifacts::toArtifact);

		// Return both
		return ImmutableList.copyOf(concat(eclipseArtifacts, webArtifacts));
	}
}
