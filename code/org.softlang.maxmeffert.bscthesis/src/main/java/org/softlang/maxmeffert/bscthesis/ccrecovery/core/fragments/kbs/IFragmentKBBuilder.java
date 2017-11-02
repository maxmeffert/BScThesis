package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragmentAST component, IFragmentAST composite);
    IFragmentKB build();

}
