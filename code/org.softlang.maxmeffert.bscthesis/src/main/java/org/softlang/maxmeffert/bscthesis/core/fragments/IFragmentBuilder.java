package org.softlang.maxmeffert.bscthesis.core.fragments;

public interface IFragmentBuilder {
    IFragmentBuilder withText(String text);
    IFragment build();
}
