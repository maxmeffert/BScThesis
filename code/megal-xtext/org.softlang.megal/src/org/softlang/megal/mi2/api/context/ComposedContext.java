package org.softlang.megal.mi2.api.context;

import java.util.List;

import org.softlang.megal.mi2.Element;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.mi2.api.emission.Emission;
import org.softlang.megal.mi2.api.resolution.Resolution;
import org.softlang.sourcesupport.SourceSupport;

public final class ComposedContext implements Context {
	private final Resolution resolutionDelegate;

	private final Emission emissionDelegate;

	public ComposedContext(Resolution resolutionDelegate, Emission emissionDelegate) {
		this.resolutionDelegate = resolutionDelegate;
		this.emissionDelegate = emissionDelegate;
	}

	@Override
	public void valid() {
		emissionDelegate.valid();
	}

	@Override
	public void info(String message) {
		emissionDelegate.info(message);
	}

	@Override
	public void warning(String message) {
		emissionDelegate.warning(message);
	}

	@Override
	public void error(String message) {
		emissionDelegate.error(message);
	}

	@Override
	public void valid(Element x, Element... xs) {
		emissionDelegate.valid(x, xs);
	}

	@Override
	public void info(String message, Element x, Element... xs) {
		emissionDelegate.info(message, x, xs);
	}

	@Override
	public void warning(String message, Element x, Element... xs) {
		emissionDelegate.warning(message, x, xs);
	}

	@Override
	public void error(String message, Element x, Element... xs) {
		emissionDelegate.error(message, x, xs);
	}

	@Override
	public SourceSupport getSourceSupport() {
		return resolutionDelegate.getSourceSupport();
	}

	@Override
	public <T> Class<? extends T> getClass(Object object, Class<T> deriving) {
		return resolutionDelegate.getClass(object, deriving);
	}

	@Override
	public <T> Class<? extends T> getClass(Object binding, Class<T> deriving, Class<?> nextTo) {
		return resolutionDelegate.getClass(binding, deriving, nextTo);
	}

	@Override
	public Artifact getArtifact(Object binding) {
		return resolutionDelegate.getArtifact(binding);
	}

	@Override
	public List<Artifact> getArtifacts(Object binding) {
		return resolutionDelegate.getArtifacts(binding);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emissionDelegate.hashCode();
		result = prime * result + resolutionDelegate.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComposedContext other = (ComposedContext) obj;
		if (!emissionDelegate.equals(other.emissionDelegate))
			return false;
		if (!resolutionDelegate.equals(other.resolutionDelegate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComposedContext [TresolutionDelegate=" + resolutionDelegate + ", emissionDelegate=" + emissionDelegate
				+ "]";
	}

}