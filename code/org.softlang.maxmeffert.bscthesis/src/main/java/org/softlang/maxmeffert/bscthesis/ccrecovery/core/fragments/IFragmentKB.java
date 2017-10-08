package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IFragmentKB {

    IView<IFragment> getFragments();
    IView<IFragment> getFragmentsOf(IFragment fragment);
    boolean isFragmentOf(IFragment component, IFragment composite);

}
