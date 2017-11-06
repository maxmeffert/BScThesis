package org.softlang.megal.plugins.prelude;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.filter;
import static java.util.Collections.singleton;
import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedEvaluatorPlugin;
import org.softlang.megal.plugins.api.acceptors.AcceptorPlugin;

import com.google.common.base.Optional;

/**
 * <p>
 * Parts for this evaluator will be seen as acceptors
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class FileElementOfLanguageEvaluatorPlugin extends GuidedEvaluatorPlugin {

	private static Iterable<Artifact> expandIfFolder(Iterable<Artifact> iterable) {
		return from(iterable).transformAndConcat(
				x -> x.hasContent() ? singleton(x) : x.getChildren());
	}

	@Override
	public void guidedEvaluate(Relationship relationship) {
		Entity element = relationship.getLeft();
		
		Iterable<Artifact> items = expandIfFolder(artifactsOf(element));
		
		boolean anyError = false;
		for (Artifact artifact : items) {
			
			Optional<String> error = isElement(element, artifact);

			if (error.isPresent()) {
				anyError = true;
				error(error.get());
			}
		}

		if (!anyError) {
			valid();
		}
			
	}

	private Optional<String> isElement(Entity element, Artifact artifact) {
		if (!artifact.hasContent())  {
			return Optional.absent();
		}			
		
		for (AcceptorPlugin acceptor : filter(getParts(), AcceptorPlugin.class)) {
			if (!any(acceptor.getRealization(),	x -> isElementOfLanguage(element, x))) {
				continue;
			}				
			
			Optional<String> error = acceptor.accept(artifact);

			if (error.isPresent()) {
				return error;
			}
		}

		return Optional.absent();
	}
}
