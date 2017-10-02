package org.softlang.maxmeffert.bscthesis.core.fragments;

public class FragmentBuilderFactory implements IFragmentBuilderFactory {
    @Override
    public IFragmentBuilder newFragmentBuilder() {
        return new FragmentBuilder();
    }
}
