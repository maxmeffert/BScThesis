package org.softlang.megal.plugins.impl.jaxb;

import java.io.IOException;
import java.io.InputStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.plugins.api.recovery.BaseCorrespondsToRecoveryPlugin;

public class JaxbJavaXmlCorrespondsToRecoveryPlugin extends BaseCorrespondsToRecoveryPlugin {

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
	protected IBinaryRelation<IFragment> getSimilarities(InputStream left, InputStream right)
			throws IOException, ParserException {
		return recovery.getJaxbSimilarities(left, right);
	}

}
