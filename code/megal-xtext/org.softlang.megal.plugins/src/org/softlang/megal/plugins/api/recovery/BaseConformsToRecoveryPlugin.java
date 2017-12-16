package org.softlang.megal.plugins.api.recovery;

import java.io.IOException;
import java.io.InputStream;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.BinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.DiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.prelude.ConformsToReasonerPlugin.ConformsToRecoveryPlugin;

public abstract class BaseConformsToRecoveryPlugin extends ConformsToRecoveryPlugin {
	
	abstract protected IBinaryRelation<IFragment> getSimilarities(ICCRecoveryScenarios ccRecoveryScenarios, InputStream left, InputStream right) throws IOException, ParserException;
	abstract protected IFragmentNameProvider getLeftNameProvider();
	abstract protected IFragmentNameProvider getRightNameProvider();
	
	private final ICCRecoveryScenarios ccRecoveryScenarios = CCRecoveryScenarios.create();
	
	private IBinaryRelation<String> newBinaryRelation() {
		return new BinaryRelation<String>(new DiGraph<String>());
	}
	
	private IBinaryRelation<String> getTextMap(IBinaryRelation<IFragment> similarities, Entity left, Entity right) {
		QualifiedFragmentNameProvider leftNameProvider = new QualifiedFragmentNameProvider(getLeftNameProvider());
		QualifiedFragmentNameProvider rightNameProvider = new QualifiedFragmentNameProvider(getRightNameProvider());
		
		IBinaryRelation<String> result = newBinaryRelation();
		for (IPair<IFragment,IFragment> similarity : similarities) {
			String leftName = leftNameProvider.getQualifiedName(similarity.getFirst(), left);
			String rightName = rightNameProvider.getQualifiedName(similarity.getSecond(), right);
			
			result.add(leftName, rightName);
		}
		return result;
	}
	
	@Override
	public IBinaryRelation<String> init(Entity leftEntity, Artifact leftArtifact, Entity rightEntity, Artifact rightArtifact) {
		try {
			IBinaryRelation<IFragment> similarities = getSimilarities(ccRecoveryScenarios, leftArtifact.getBytes().openStream(), rightArtifact.getBytes().openStream());
			return getTextMap(similarities, leftEntity, rightEntity);
		} catch (IOException | ParserException e) {
			e.printStackTrace();
		}
		return newBinaryRelation();
	}
	
}