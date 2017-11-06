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

	private static final String FragmentTextAnnotationName = "FragmentText";
	private static final String FragmentTypeName = "Fragment";
	private static final String ElementOfTypeName = "elementOf";
	private static final String PartOfTypeName = "partOf";
	
	private static final String FragmentNamePrefix = "F";
	private static final String IndexNameSeparator = "$";
	private static final String PartOfNameSeparator = ".";
	
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
	
	private int getIndex(IFragment fragment) {
		if (fragment.hasParent()) {
			return fragment.getParent().getChildren().indexOf(fragment);
		}
		return -1;
	}
	
	private String getIndexedName(IFragment fragment) {
		int index = getIndex(fragment);
		String name = getName(fragment);
		if (index < 0) {
			return name;
		}
		return FragmentNamePrefix + index + IndexNameSeparator + name;
	}
	
	private String prependAncestorNames(String qualifiedName, IFragment parent) {
		while (parent != null && hasName(parent)) {
			qualifiedName = getIndexedName(parent) + PartOfNameSeparator + qualifiedName;
			parent = parent.getParent();
		}
		return qualifiedName;
	}
	
	private String getQualifiedName(IFragment fragment, Entity entity) {
		String qualifiedName = getIndexedName(fragment);
		if (fragment.hasParent()) {
			qualifiedName = prependAncestorNames(qualifiedName, fragment.getParent());
		}
		return entity.getName() + PartOfNameSeparator + qualifiedName;
	}
	
	private void deriveOneFragment(IGuidedReasonerProxy reasoner, Entity entity, URI location, IFragment fragment) throws URISyntaxException {
		String qualifiedName = getQualifiedName(fragment, entity);
		reasoner.addEntity(qualifiedName, FragmentTypeName);
		reasoner.addEntityAnnotation(qualifiedName, FragmentTextAnnotationName, fragment.getText());
		reasoner.addBinding(qualifiedName, getFragmentUri(location, fragment));
		reasoner.addRelationship(ElementOfTypeName, qualifiedName, getLanguage(fragment));
		reasoner.addRelationship(PartOfTypeName, qualifiedName, entity.getName());
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
