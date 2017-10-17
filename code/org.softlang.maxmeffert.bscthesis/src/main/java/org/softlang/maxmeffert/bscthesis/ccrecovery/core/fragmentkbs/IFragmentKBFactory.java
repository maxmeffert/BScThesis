package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentKBFactory {
    IFragmentKB newFragmentKB(IFragment fragment);
}
