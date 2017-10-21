package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface IFragmentKBFactory {
    IFragmentKB newFragmentKB(IFragmentAST fragment);
}
