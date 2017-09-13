package org.softlang.maxmeffert.bscthesis.fragments;

public interface IFragmentKBBuilder {

    void fragmentOf(IFragment component, IFragment composite);
    IFragmentKB build();

}
