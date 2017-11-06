package org.softlang.megal.plugins.api.recovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentNameProvider {
	boolean hasName(IFragment fragment);
	String getName(IFragment fragment);
}
