package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite);
    IFragmentKB build();

}
