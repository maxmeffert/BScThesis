package org.softlang.megal.plugins.api.recovery;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.prelude.CorrespondsToReasonerPlugin.CorrespondsToRecoveryPlugin;

import com.google.common.collect.Maps;

public abstract class BaseCorrespondsToRecoveryPlugin extends CorrespondsToRecoveryPlugin {
	
	abstract protected IBinaryRelation<IFragment> getSimilarities(InputStream left, InputStream right) throws IOException, ParserException;
	
	private Map<String,String> getTextMap(IBinaryRelation<IFragment> similarities) {
		Map<String, String> result = Maps.newTreeMap();
		for (IPair<IFragment,IFragment> similarity : similarities) {
			result.put(similarity.getFirst().getText(), similarity.getSecond().getText());
		}
		return result;
	}
	
	@Override
	public Map<String, String> init(Artifact left, Artifact right) {
		try {
			return getTextMap(getSimilarities(left.getBytes().openStream(), right.getBytes().openStream()));
		} catch (IOException | ParserException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}
	
}
