package org.softlang.megal.plugins.impl.java;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.IdentifiedJavaFragment;
import org.softlang.megal.plugins.api.recovery.IFragmentNameProvider;

public class JavaFragmentNameProvider implements IFragmentNameProvider {

	@Override
	public boolean hasName(IFragment fragment) {
		return fragment instanceof IdentifiedJavaFragment;
	}

	@Override
	public String getName(IFragment fragment) {
		return ((IdentifiedJavaFragment)fragment).getIdentifier();
	}

}
