package org.softlang.megal.plugins.impl.hibernate;

import java.io.IOException;
import java.io.InputStream;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.recovery.BaseCorrespondsToRecoveryPlugin;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;
import org.softlang.megal.plugins.impl.java.JavaFragmentNameProvider;
import org.softlang.megal.plugins.impl.xml.XMLFragmentNameProvider;
import org.softlang.megal.plugins.util.Prelude;

public class HibernateJavaXmlCorrespondsToRecoveryPlugin extends BaseCorrespondsToRecoveryPlugin {
	
	@Override
	protected IBinaryRelation<IFragment> getSimilarities(ICCRecoveryScenarios ccRecoveryScenarios, InputStream left, InputStream right)
			throws IOException, ParserException {
		IBinaryRelation<IFragment> similarities = ccRecoveryScenarios.getHibernateJavaXmlSimilarities(left, right);
		similarities.removeIf(p -> p.getFirst() instanceof JavaMethodFragment);
		return similarities;
	}

	@Override
	public boolean canBeAppliedTo(Entity leftEntity, Entity rightEntity) {
		
		return Prelude.isElementOfLanguage(leftEntity, "Java") 
				&& Prelude.isElementOfLanguage(rightEntity, "XML");
	}

	@Override
	protected IFragmentNameProvider getLeftNameProvider() {
		return new JavaFragmentNameProvider();
	}

	@Override
	protected IFragmentNameProvider getRightNameProvider() {
		return new XMLFragmentNameProvider();
	}

}
