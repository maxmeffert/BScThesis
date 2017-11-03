package org.softlang.megal.mi2.api.resolution;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.concat;
import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.softlang.megal.mi2.api.Artifact;
import org.softlang.sourcesupport.LocalSourceSupport;
import org.softlang.sourcesupport.SourceSupport;

import com.google.common.collect.ImmutableList;

public abstract class LocalResolution extends AbstractResolution {
	public static void main(String[] args) throws IOException {
		File root = new File("..").getCanonicalFile();

		LocalResolution r = new LocalResolution() {
			@Override
			protected File getRoot() {
				return root;
			}
		};

		Artifact x = r.getArtifact("workspace:/org.softlang.megal/build.properties");
		System.out.println(x);
		Artifact y = r
				.getArtifact("http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.pde.doc.user%2Ftasks%2Fui_export_install_into_host.htm");
		System.out.println(y);
	}

	protected abstract File getRoot();

	@Override
	public SourceSupport getSourceSupport() {
		return LocalSourceSupport.INSTANCE;
	}

	private Iterable<File> unbindFile(Object object) {
//		System.err.println(object);
		// If object is an URI
		if (object instanceof URI) {
			URI uri = (URI) object;
//			System.err.println(uri);
//			System.err.println("file".equals(uri.getScheme()));
			// Directly map file
			if ("file".equals(uri.getScheme())) {
//				System.err.println(uri);
				return singletonList(new File(uri));
			}
			// Redirect workspace
			else if ("workspace".equals(uri.getScheme()))
				try {
					// Get path
					String path = getRoot().toURI().getPath() + uri.getPath().substring(1);
					// Unbind with redirected path
					return unbindFile(new URI("file", uri.getUserInfo(), uri.getHost(), uri.getPort(), path,
							uri.getQuery(), uri.getFragment()));
				} catch (URISyntaxException e) {
					return emptyList();
				}
			else
				return emptyList();
		}

		// If object is a string
		if (object instanceof String) {
			String string = (String) object;
			try {
				return unbindFile(new URI(string));
			} catch (URISyntaxException e) {
				// Convert to file
				return singletonList(new File(string));
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
		Iterable<Artifact> eclipseArtifacts = from(unbindFile(binding)).transform(LocalArtifacts::toArtifact);

		// Enumerate web artifacts
		Iterable<Artifact> webArtifacts = from(unbindWeb(binding)).transform(WebArtifacts::toArtifact);

		// Return both
		return ImmutableList.copyOf(concat(eclipseArtifacts, webArtifacts));
	}
}
