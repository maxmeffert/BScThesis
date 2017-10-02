package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

public interface IFragmentKBBuilder {

    IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite);
    IFragmentKB build();

}
