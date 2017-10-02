package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

public interface IFragmentBuilder {
    IFragmentBuilder withText(String text);
    IFragment build();
}
