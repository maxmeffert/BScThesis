package org.softlang.maxmeffert.bscthesis.fragments;

public interface IFragmentBuilder {
    IFragmentBuilder withText(String text);
    IFragment build();
}
