package org.softlang.megal.plugins.impl.xsd;

import java.io.IOException;
import java.io.InputStream;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.recovery.BaseConformsToRecoveryPlugin;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;
import org.softlang.megal.plugins.impl.xml.XMLFragmentNameProvider;
import org.softlang.megal.plugins.util.Prelude;

public class XmlXsdConformsToRecoveryPlugin extends BaseConformsToRecoveryPlugin {
	
	@Override
	protected IBinaryRelation<IFragment> getSimilarities(ICCRecoveryScenarios ccRecoveryScenarios, InputStream left, InputStream right)
			throws IOException, ParserException {
		IBinaryRelation<IFragment> similarities = ccRecoveryScenarios.getXmlXsdSimilarities(left, right);
		return similarities;
	}

	@Override
	public boolean canBeAppliedTo(Entity leftEntity, Entity rightEntity) {
		return Prelude.isElementOfLanguage(leftEntity, "XML") 
				&& Prelude.isElementOfLanguage(rightEntity, "XSD");
				
	}
	
	@Override
	protected IFragmentNameProvider getLeftNameProvider() {
		return new XMLFragmentNameProvider();
	}

	@Override
	protected IFragmentNameProvider getRightNameProvider() {
		return new XMLFragmentNameProvider();
	}
}
