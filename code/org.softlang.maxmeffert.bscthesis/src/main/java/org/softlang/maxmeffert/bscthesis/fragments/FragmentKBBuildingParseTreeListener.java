package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.textsources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public class FragmentKBBuildingParseTreeListener implements IFragmentKBBuildingParseTreeListener {

    private final IFragmentFactory fragmentFactory;

    public FragmentKBBuildingParseTreeListener(IFragmentFactory fragmentFactory) {
        this.fragmentFactory = fragmentFactory;
    }

    @Override
    public IFragmentKB getFragmentKB() {
        return null;
    }


    @Override
    public void enter(ITree<ITextSource> tree) {

    }

    @Override
    public void exit(ITree<ITextSource> tree) {

    }
}
