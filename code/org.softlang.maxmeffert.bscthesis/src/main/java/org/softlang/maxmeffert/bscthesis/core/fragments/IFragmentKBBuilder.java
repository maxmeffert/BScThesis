package org.softlang.maxmeffert.bscthesis.core.fragments;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite);
    IFragmentKB build();

}
