package org.softlang.megal.mi2.api.resolution;

import java.net.URI;
import java.util.List;

import org.softlang.megal.mi2.api.Artifact;
import org.softlang.sourcesupport.SourceSupport;

/**
 * <p>
 * Evaluation context of a plugin.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public interface Resolution {

	/**
	 * <p>
	 * Gets the source support for this context.
	 * </p>
	 * 
	 * @return Returns the source support
	 */
	SourceSupport getSourceSupport();

	/**
	 * <p>
	 * Gets the bindings class location. This method constitutes the model relative classpath.
	 * </p>
	 * 
	 * @param object
	 *            The binding to evaluate, may be a {@link String} or an {@link URI} or any other class specification.
	 * @return Returns a class
	 */
	<T> Class<? extends T> getClass(Object binding, Class<T> deriving);

	<T> Class<? extends T> getClass(Object binding, Class<T> deriving, Class<?> nextTo);

	List<Artifact> getArtifacts(Object binding);

	Artifact getArtifact(Object binding);
}
