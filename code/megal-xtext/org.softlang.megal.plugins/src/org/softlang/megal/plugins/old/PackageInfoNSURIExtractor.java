package org.softlang.megal.plugins.old;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.mi2.api.resolution.Resolution;

public class PackageInfoNSURIExtractor extends NSURIExtractor {
	
	private static final Pattern EXTRACTOR_PATTERN = Pattern.compile(
			".*namespace\\s*=\\s*\"([^\"]*)\".*", Pattern.DOTALL);

	@Override
	public URI extractNSURI(Resolution resolution, Entity entity) {
		Artifact artifact = resolution.getArtifact(entity.getBinding());
		if (artifact == null)
			return null;

		Artifact packageInfo = artifact.getChild("package-info.java");

		try {
			Matcher matcher = EXTRACTOR_PATTERN.matcher(packageInfo.getChars()
					.read());

			if (!matcher.matches())
				return null;

			String nsuri = matcher.group(1);
			return new URI(nsuri);
		} catch (IOException | URISyntaxException e) {
			return null;
		}
	}
}
