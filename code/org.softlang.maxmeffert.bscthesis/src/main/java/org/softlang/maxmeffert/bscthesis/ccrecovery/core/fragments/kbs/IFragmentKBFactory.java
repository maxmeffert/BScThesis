package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

public interface IFragmentKBFactory {
    IFragmentKB newFragmentKB(IFragmentAST fragment);
}
