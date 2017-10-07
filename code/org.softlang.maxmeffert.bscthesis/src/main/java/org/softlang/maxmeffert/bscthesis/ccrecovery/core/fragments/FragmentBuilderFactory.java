package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

public class FragmentBuilderFactory implements IFragmentBuilderFactory {
    @Override
    public IFragmentBuilder newFragmentBuilder() {
        return new FragmentBuilder();
    }
}
