package org.softlang.maxmeffert.bscthesis.fragments;

public class FragmentKBBuildingParseTreeListenerFactory implements IFragmentKBBuildingParseTreeListenerFactory {

    private final IFragmentFactory fragmentFactory;

    public FragmentKBBuildingParseTreeListenerFactory(IFragmentFactory fragmentFactory) {
        this.fragmentFactory = fragmentFactory;
    }

    @Override
    public IFragmentKBBuildingParseTreeListener newFragmentKBBuildingParseTreeListener() {
        return new FragmentKBBuildingParseTreeListener(fragmentFactory);
    }
}
