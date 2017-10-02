package org.softlang.maxmeffert.bscthesis.core.fragments;

public interface IFragmentKB {

    Iterable<IFragment> getFragments();
    Iterable<IFragment> getFragmentsOf(IFragment fragment);
    boolean fragmentOf(IFragment component, IFragment composite);

}
