package org.softlang.megal.plugins.impl.java;

import java.io.IOException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.IdentifiedJavaFragment;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.FragmentRecoveryPlugin;
import org.softlang.megal.plugins.api.IGuidedReasonerProxy;

public class JavaFragmentRecoveryPlugin extends FragmentRecoveryPlugin {

	private final ICCRecoveryScenarios recovery = CCRecoveryScenarios.create();
		
	private IFragment parseArtifact(Artifact artifact) throws IOException, ParserException {
		return recovery.getJava8Parser().parse(artifact.getBytes().openStream());
	}
	
	private IFragmentKB getFragmentKB(IFragment fragment) {
		return recovery.getFragmentKB(fragment);
	}
	
	private void deriveMetadata(IGuidedReasonerProxy reasoner) {
		reasoner.addEntity("Java", "Language");
		reasoner.addEntity("JavaFragments", "Language");
		reasoner.addEntity("JavaClassFragments", "Language");
		reasoner.addRelationship("subsetOf", "Java", "JavaFragments");
		reasoner.addRelationship("subsetOf", "JavaClassFragments", "JavaFragments");
		
	}
	
	public void derive(IGuidedReasonerProxy reasoner, Entity entity, Artifact artifact) {
		deriveMetadata(reasoner);
		try {
			IFragment fragment = parseArtifact(artifact);
			IFragmentKB fragmentKb = getFragmentKB(fragment);
						
			for (IFragment ff : fragmentKb.getFragmentsOf(fragment)) {
				if (ff instanceof IdentifiedJavaFragment) {
					String id = ((IdentifiedJavaFragment) ff).getIdentifier();
					reasoner.addEntity(id, "Fragment");
					reasoner.addRelationship("elementOf", id, "JavaFragments");
					reasoner.addRelationship("partOf", id, entity.getName());
				}
			}
			
		} catch (IOException e) {
			System.err.print(e);
		} catch (ParserException e) {
			System.err.print(e);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
