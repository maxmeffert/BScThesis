package org.softlang.megal.plugins.impl.sql;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlCreateTableFragment;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;

public class SqlFragmentNameProvider implements IFragmentNameProvider {

	@Override
	public boolean hasName(IFragment fragment) {
		return fragment instanceof SqlCreateTableFragment || fragment instanceof SqlColumnFragment;
	}

	@Override
	public String getName(IFragment fragment) {
		if (fragment instanceof SqlCreateTableFragment) {
			return ((SqlCreateTableFragment)fragment).getTableName();
		}
		if (fragment instanceof SqlColumnFragment) {
			return ((SqlColumnFragment)fragment).getColumnName();
		}
		return null;
	}

}
