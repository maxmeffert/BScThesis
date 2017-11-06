package org.softlang.megal.plugins.impl.xml;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.NamedXmlFragment;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;

public class XMLFragmentNameProvider implements IFragmentNameProvider {

	@Override
	public boolean hasName(IFragment fragment) {
		return fragment instanceof NamedXmlFragment;
	}

	@Override
	public String getName(IFragment fragment) {
		return ((NamedXmlFragment)fragment).getName();
	}

}
