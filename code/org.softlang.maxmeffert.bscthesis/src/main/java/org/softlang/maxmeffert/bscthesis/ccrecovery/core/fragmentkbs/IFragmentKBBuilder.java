package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragmentAST component, IFragmentAST composite);
    IFragmentKB build();

}
