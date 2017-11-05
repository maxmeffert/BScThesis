package org.softlang.megal.plugins.api;

import java.io.IOException;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;

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
	
	private void deriveOne(IGuidedReasonerProxy reasoner, Entity entity, IFragment fragment) {
		String name = getQualifiedName(fragment, entity);
		reasoner.addEntity(name, "Fragment");
		reasoner.addRelationship("elementOf", name, getLanguage(fragment));
		reasoner.addRelationship("partOf", name, entity.getName());
	}
	
	private void derive(IGuidedReasonerProxy reasoner, Entity entity, IFragment fragment) {
		IFragmentKB fragmentKb = getFragmentKB(fragment);
		
		for (IFragment ff : fragmentKb.getFragmentsOf(fragment)) {
			if (hasName(ff)) {
				deriveOne(reasoner, entity, ff);
			}
		}
	}
	
	@Override
	public void derive(IGuidedReasonerProxy reasoner, Entity entity, Artifact artifact) {
		try {
			derive(reasoner, entity, parseArtifact(artifact));			
		} catch (IOException e) {
			System.err.print(e);
		} catch (ParserException e) {
			System.err.print(e);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
