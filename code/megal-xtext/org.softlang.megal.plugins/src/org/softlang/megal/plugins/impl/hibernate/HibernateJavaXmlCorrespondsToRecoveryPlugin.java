package org.softlang.megal.plugins.impl.hibernate;

import java.io.IOException;
import java.io.InputStream;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.plugins.api.recovery.BaseCorrespondsToRecoveryPlugin;

public class HibernateJavaXmlCorrespondsToRecoveryPlugin extends BaseCorrespondsToRecoveryPlugin {
	
	@Override
	protected IBinaryRelation<IFragment> getSimilarities(ICCRecoveryScenarios ccRecoveryScenarios, InputStream left, InputStream right)
			throws IOException, ParserException {
		return ccRecoveryScenarios.getHibernateJavaXmlSimilarities(left, right);
	}

	@Override
	public String getLeftLanguage() {
		return "Java";
	}

	@Override
	public String getRightLanguage() {
		return "XML";
	}

}
