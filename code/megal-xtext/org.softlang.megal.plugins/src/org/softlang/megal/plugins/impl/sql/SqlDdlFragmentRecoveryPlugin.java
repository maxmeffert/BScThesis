package org.softlang.megal.plugins.impl.sql;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlCreateTableFragment;
import org.softlang.megal.plugins.api.recovery.BaseFragmentRecoveryPlugin;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;

public class SqlDdlFragmentRecoveryPlugin extends BaseFragmentRecoveryPlugin {

	@Override
	protected IParser getParser(ICCRecoveryScenarios ccRecoveryScenarios) {
		return ccRecoveryScenarios.getSqlParser();
	}

	@Override
	protected String getLanguage(IFragment fragment) {
		if (fragment instanceof SqlCreateTableFragment) {
			return "SQLCreateTableFragments";
		}
		if (fragment instanceof SqlColumnFragment) {
			return "SQLColumnDefinitionFragments";
		}
		return null;
	}

	@Override
	protected IFragmentNameProvider getNameProvider() {
		return new SqlFragmentNameProvider();
	}

}
