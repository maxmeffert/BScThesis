package org.softlang.megal.plugins.impl.java;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.megal.plugins.api.recovery.BaseFragmentRecoveryPlugin;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;

public class JavaFragmentRecoveryPlugin extends BaseFragmentRecoveryPlugin {

	@Override
	protected IParser getParser(ICCRecoveryScenarios ccRecoveryScenarios) {
		return ccRecoveryScenarios.getJava8Parser();
	}

	@Override
	protected String getLanguage(IFragment fragment) {
		if (fragment instanceof JavaClassFragment) {
			return "JavaClassFragments";
		}
		if (fragment instanceof JavaFieldFragment) {
			return "JavaFieldFragments";
		}
		if (fragment instanceof JavaMethodFragment) {
			return "JavaMethodFragments";
		}
		return "";
	}

	@Override
	protected IFragmentNameProvider getNameProvider() {
		return new JavaFragmentNameProvider();
	}

}
