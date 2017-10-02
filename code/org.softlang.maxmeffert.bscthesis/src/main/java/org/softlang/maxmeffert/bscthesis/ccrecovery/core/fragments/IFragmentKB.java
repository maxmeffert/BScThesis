package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

public interface IFragmentKB {

    Iterable<IFragment> getFragments();
    Iterable<IFragment> getFragmentsOf(IFragment fragment);
    boolean fragmentOf(IFragment component, IFragment composite);

}
