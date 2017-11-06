package org.softlang.megal.plugins.api.fragmentrecovery;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.IGuidedReasonerProxy;

public abstract class BaseFragmentRecoveryPlugin extends FragmentRecoveryPlugin {

	abstract protected IParser getParser(ICCRecoveryScenarios ccRecoveryScenarios);
	abstract protected boolean hasName(IFragment fragment);
	abstract protected String getName(IFragment fragment);
	abstract protected String getLanguage(IFragment fragment);
	
	private final ICCRecoveryScenarios recovery = CCRecoveryScenarios.create();
	
	private IFragment parseArtifact(Artifact artifact) throws IOException, ParserException {
		return getParser(recovery).parse(artifact.getBytes().openStream());
	}
	
	private IFragmentKB getFragmentKB(IFragment fragment) {
		return recovery.getFragmentKB(fragment);
	}
	
	private URI getFragmentUri(URI uri, IFragment fragment) throws URISyntaxException {
		return recovery.getFragmentUriConverter().toFragmentUri(uri, fragment);
	}
	
	private String getQualifiedName(IFragment fragment, Entity entity) {
		String qualifiedName = getName(fragment);
		if (fragment.hasParent()) {
			IFragment parent = fragment.getParent();
			while (parent != null && hasName(parent)) {
				qualifiedName = getName(parent) + "." + qualifiedName;
				parent = parent.getParent();
			}
		}
		return entity.getName() + "." + qualifiedName;
	}
	
	private void deriveOneFragment(IGuidedReasonerProxy reasoner, Entity entity, URI location, IFragment fragment) throws URISyntaxException {
		String qualifiedName = getQualifiedName(fragment, entity);
		reasoner.addEntity(qualifiedName, "Fragment");
		reasoner.addEntityAnnotation(qualifiedName, "FragmentText", fragment.getText());
		reasoner.addBinding(qualifiedName, getFragmentUri(location, fragment));
		reasoner.addRelationship("elementOf", qualifiedName, getLanguage(fragment));
		reasoner.addRelationship("partOf", qualifiedName, entity.getName());
	}
	
	private void deriveAllFragments(IGuidedReasonerProxy reasoner, Entity entity, URI location, IFragment fragment) throws URISyntaxException {
		for (IFragment ff : getFragmentKB(fragment).getFragmentsOf(fragment)) {
			if (hasName(ff)) {
				deriveOneFragment(reasoner, entity, location, ff);
			}
		}
	}
	
	@Override
	public void derive(IGuidedReasonerProxy reasoner, Entity entity, Artifact artifact) {
		try {
			deriveAllFragments(reasoner, entity, artifact.getLocation(), parseArtifact(artifact));			
		} catch (IOException e) {
			System.err.print(e);
		} catch (ParserException e) {
			System.err.print(e);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
