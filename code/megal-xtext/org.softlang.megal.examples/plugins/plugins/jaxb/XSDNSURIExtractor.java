package plugins.jaxb;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.mi2.api.resolution.Resolution;

public class XSDNSURIExtractor extends NSURIExtractor {

	private static final Pattern EXTRACTOR_PATTERN = Pattern.compile(".*schema xmlns\\s*=\\s*\"([^\"]*)\".*",
			Pattern.DOTALL);

	@Override
	public URI extractNSURI(Resolution resolution, Entity entity) {
		Artifact artifact = resolution.getArtifact(entity.getBinding());
		if (artifact == null)
			return null;

		try {
			Matcher matcher = EXTRACTOR_PATTERN.matcher(artifact.getChars().read());
			if (!matcher.matches())
				return null;

			String nsuri = matcher.group(1);
			return new URI(nsuri);
		} catch (IOException | URISyntaxException e) {
			return null;
		}
	}

}
