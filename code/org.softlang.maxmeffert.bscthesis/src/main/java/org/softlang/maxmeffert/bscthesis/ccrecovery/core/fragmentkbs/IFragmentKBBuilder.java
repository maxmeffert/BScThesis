package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite);
    IFragmentKB build();

}
