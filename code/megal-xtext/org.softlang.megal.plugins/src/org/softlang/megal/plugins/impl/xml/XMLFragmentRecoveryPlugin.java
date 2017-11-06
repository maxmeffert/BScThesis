package org.softlang.megal.plugins.impl.xml;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.megal.plugins.api.recovery.BaseFragmentRecoveryPlugin;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;

public class XMLFragmentRecoveryPlugin extends BaseFragmentRecoveryPlugin {

	@Override
	protected IParser getParser(ICCRecoveryScenarios ccRecoveryScenarios) {
		return ccRecoveryScenarios.getXmlParser();
	}

	@Override
	protected String getLanguage(IFragment fragment) {
		if (fragment instanceof XmlElementFragment) {
			return "XMLElementFragments";
		}
		if (fragment instanceof XmlAttributeFragment) {
			return "XMLAttributeFragments";
		}
		return "";
	}

	@Override
	protected IFragmentNameProvider getNameProvider() {
		return new XMLFragmentNameProvider();
	}

}
