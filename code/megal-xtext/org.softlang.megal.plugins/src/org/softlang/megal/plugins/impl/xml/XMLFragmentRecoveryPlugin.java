package org.softlang.megal.plugins.impl.xml;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.NamedXmlFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.megal.plugins.api.fragmentrecovery.BaseFragmentRecoveryPlugin;

public class XMLFragmentRecoveryPlugin extends BaseFragmentRecoveryPlugin {

	@Override
	protected IParser getParser(ICCRecoveryScenarios ccRecoveryScenarios) {
		return ccRecoveryScenarios.getXmlParser();
	}

	@Override
	protected boolean hasName(IFragment fragment) {
		return fragment instanceof NamedXmlFragment;
	}

	@Override
	protected String getName(IFragment fragment) {
		return ((NamedXmlFragment)fragment).getName();
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

}
