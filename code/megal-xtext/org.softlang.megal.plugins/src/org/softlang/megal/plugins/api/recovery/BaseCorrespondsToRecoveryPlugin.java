package org.softlang.megal.plugins.api.recovery;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.prelude.CorrespondsToReasonerPlugin.CorrespondsToRecoveryPlugin;

import com.google.common.collect.Maps;

public abstract class BaseCorrespondsToRecoveryPlugin extends CorrespondsToRecoveryPlugin {
	
	abstract protected IBinaryRelation<IFragment> getSimilarities(ICCRecoveryScenarios ccRecoveryScenarios, InputStream left, InputStream right) throws IOException, ParserException;
	abstract protected IFragmentNameProvider getLeftNameProvider();
	abstract protected IFragmentNameProvider getRightNameProvider();
	
	private final ICCRecoveryScenarios ccRecoveryScenarios = CCRecoveryScenarios.create();
	
	private Map<String,String> getTextMap(IBinaryRelation<IFragment> similarities, Entity left, Entity right) {
		QualifiedFragmentNameProvider leftNameProvider = new QualifiedFragmentNameProvider(getLeftNameProvider());
		QualifiedFragmentNameProvider rightNameProvider = new QualifiedFragmentNameProvider(getRightNameProvider());
		Map<String, String> result = Maps.newTreeMap();
		for (IPair<IFragment,IFragment> similarity : similarities) {
			result.put(leftNameProvider.getQualifiedName(similarity.getFirst(), left), rightNameProvider.getQualifiedName(similarity.getSecond(), right));
		}
		return result;
	}
	
	@Override
	public Map<String, String> init(Entity leftEntity, Artifact leftArtifact, Entity rightEntity, Artifact rightArtifact) {
		try {
			IBinaryRelation<IFragment> similarities = getSimilarities(ccRecoveryScenarios, leftArtifact.getBytes().openStream(), rightArtifact.getBytes().openStream());
			return getTextMap(similarities, leftEntity, rightEntity);
		} catch (IOException | ParserException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}
	
}
