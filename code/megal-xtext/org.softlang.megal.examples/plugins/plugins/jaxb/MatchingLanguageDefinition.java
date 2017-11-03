package plugins.jaxb;

import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.filter;
import static plugins.util.Prelude.isElementOfLanguage;

import java.net.URI;
import java.net.URISyntaxException;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;

import plugins.prelude.GuidedEvaluatorPlugin;

public class MatchingLanguageDefinition extends GuidedEvaluatorPlugin {
	private NSURIExtractor getExtractor(Entity artifact) {
		for (NSURIExtractor extractor : filter(getParts(), NSURIExtractor.class))
			if (any(extractor.getRealization(), x -> isElementOfLanguage(artifact, x)))
				return extractor;

		return null;
	}

	@Override
	public void guidedEvaluate(Relationship relationship) throws URISyntaxException {

		Object rightBinding = bindingOf(relationship.getRight());

		NSURIExtractor extractor = getExtractor(relationship.getLeft());
		if (extractor == null)
			return;

		URI toURI = new URI(rightBinding.toString());
		URI extracted = extractor.extractNSURI(this, relationship.getLeft());

		if (extractor != null && toURI.equals(extracted))
			valid();
		else
			error("The artifacts language " + extracted + " does not match the expected " + toURI);
	}
}
