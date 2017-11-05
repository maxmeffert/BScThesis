package org.softlang.megal.plugins.impl.xml;

import java.io.IOException;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.IdentifiedJavaFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.NamedXmlFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.FragmentRecoveryPlugin;
import org.softlang.megal.plugins.api.IGuidedReasonerProxy;

public class XMLFragmentRecoveryPlugin extends FragmentRecoveryPlugin {

	private final ICCRecoveryScenarios recovery = CCRecoveryScenarios.create();
	
	private IFragment parseArtifact(Artifact artifact) throws IOException, ParserException {
		return recovery.getXmlParser().parse(artifact.getBytes().openStream());
	}
	
	private IFragmentKB getFragmentKB(IFragment fragment) {
		return recovery.getFragmentKB(fragment);
	}
	
	private String getQualifiedName(NamedXmlFragment fragment, Entity entity) {
		String qualifiedName = fragment.getName();
		if (fragment.hasParent()) {
			IFragment parent = fragment.getParent();
			while (parent != null && parent instanceof NamedXmlFragment) {
				qualifiedName = ((NamedXmlFragment) parent).getName() + "." + qualifiedName;
				parent = parent.getParent();
			}
		}
		return entity.getName() + "." + qualifiedName;
	}
	
	private String getLanguageOf(IFragment fragment) {
		if (fragment instanceof XmlElementFragment) {
			return "XMLElementFragments";
		}
		if (fragment instanceof XmlAttributeFragment) {
			return "XMLAttributeFragments";
		}
		return "";
	}
	
	private void deriveOne(IGuidedReasonerProxy reasoner, Entity entity, NamedXmlFragment fragment) {
		String name = getQualifiedName(fragment, entity);
		reasoner.addEntity(name, "Fragment");
		reasoner.addRelationship("elementOf", name, getLanguageOf(fragment));
		reasoner.addRelationship("partOf", name, entity.getName());
	}
	
	private void derive(IGuidedReasonerProxy reasoner, Entity entity, IFragment fragment) {
		IFragmentKB fragmentKb = getFragmentKB(fragment);
		
		for (IFragment ff : fragmentKb.getFragmentsOf(fragment)) {
			if (ff instanceof NamedXmlFragment) {
				deriveOne(reasoner, entity, (NamedXmlFragment)ff);
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
