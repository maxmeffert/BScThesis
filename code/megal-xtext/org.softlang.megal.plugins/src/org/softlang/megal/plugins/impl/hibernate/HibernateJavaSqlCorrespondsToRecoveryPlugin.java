package org.softlang.megal.plugins.impl.hibernate;

import java.io.IOException;
import java.io.InputStream;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.plugins.api.recovery.BaseCorrespondsToRecoveryPlugin;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;
import org.softlang.megal.plugins.impl.java.JavaFragmentNameProvider;
import org.softlang.megal.plugins.impl.sql.SqlFragmentNameProvider;

public class HibernateJavaSqlCorrespondsToRecoveryPlugin extends BaseCorrespondsToRecoveryPlugin {
	
	@Override
	protected IBinaryRelation<IFragment> getSimilarities(ICCRecoveryScenarios ccRecoveryScenarios, InputStream left, InputStream right)
			throws IOException, ParserException {
		return ccRecoveryScenarios.getHibernateJavaSqlSimilarities(left, right);
	}

	@Override
	public String getLeftLanguage() {
		return "Java";
	}

	@Override
	public String getRightLanguage() {
		return "SQL";
	}

	@Override
	protected IFragmentNameProvider getLeftNameProvider() {
		return new JavaFragmentNameProvider();
	}

	@Override
	protected IFragmentNameProvider getRightNameProvider() {
		return new SqlFragmentNameProvider();
	}

}
