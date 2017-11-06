package org.softlang.megal.plugins.impl.jaxb;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.prelude.CorrespondsToReasonerPlugin.CorrespondsToRecoveryPlugin;

import com.google.common.collect.Maps;

public class JaxbJavaXmlCorrespondsToRecoveryPlugin extends CorrespondsToRecoveryPlugin {

	private final ICCRecoveryScenarios recovery = CCRecoveryScenarios.create();
	
	@Override
	public String getLeftLanguage() {
		return "Java";
	}

	@Override
	public String getRightLanguage() {
		return "XML";
	}

	@Override
	public Map<String, String> init(Artifact left, Artifact right) {
		try {
			IBinaryRelation<IFragment> similarities = recovery.getJaxbSimilarities(left.getBytes().openStream(), right.getBytes().openStream());
			Map<String, String> result = Maps.newTreeMap();
			for (IPair<IFragment,IFragment> similarity : similarities) {
				result.put(similarity.getFirst().getText(), similarity.getSecond().getText());
			}
			return result;
		} catch (IOException | ParserException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

}
