package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IFragmentKB {
    IView<IFragmentAST> getFragments();
    IView<IFragmentAST> getFragmentsOf(IFragmentAST fragment);
    IView<IFragmentAST> getProperFragmentsOf(IFragmentAST fragment);

    boolean isFragmentOf(IFragmentAST fragment, IFragmentAST total);
    boolean isProperFragmentOf(IFragmentAST fragment, IFragmentAST total);
}
