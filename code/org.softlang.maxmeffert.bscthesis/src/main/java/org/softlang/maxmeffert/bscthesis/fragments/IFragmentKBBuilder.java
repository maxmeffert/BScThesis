package org.softlang.maxmeffert.bscthesis.fragments;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite);
    IFragmentKB build();

}
