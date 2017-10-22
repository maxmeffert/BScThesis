package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface IFragmentKB {
    Iterable<IFragmentAST> getFragments();
    Iterable<IFragmentAST> getFragmentsOf(IFragmentAST fragment);
    Iterable<IFragmentAST> getProperFragmentsOf(IFragmentAST fragment);

    boolean isFragmentOf(IFragmentAST fragment, IFragmentAST total);
    boolean isProperFragmentOf(IFragmentAST fragment, IFragmentAST total);
}
