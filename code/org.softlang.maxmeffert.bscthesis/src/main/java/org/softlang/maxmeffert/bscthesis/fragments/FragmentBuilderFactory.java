package org.softlang.maxmeffert.bscthesis.fragments;

public class FragmentBuilderFactory implements IFragmentBuilderFactory {
    @Override
    public IFragmentBuilder newFragmentBuilder() {
        return new FragmentBuilder();
    }
}
