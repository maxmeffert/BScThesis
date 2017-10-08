package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IFragmentKB {
    IView<IFragment> getFragments();
    IView<IFragment> getFragmentsOf(IFragment fragment);
    IView<IFragment> getProperFragmentsOf(IFragment fragment);

    boolean isFragmentOf(IFragment fragment, IFragment total);
    boolean isProperFragmentOf(IFragment fragment, IFragment total);
}
