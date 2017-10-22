package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;

public class FragmentKB implements IFragmentKB {

    private final IMereology<IFragmentAST> mereology;

    public FragmentKB(IMereology<IFragmentAST> mereology) {
        this.mereology = mereology;
    }

    @Override
    public Iterable<IFragmentAST> getFragments() {
        return mereology.getElements();
    }

    @Override
    public Iterable<IFragmentAST> getFragmentsOf(IFragmentAST fragment) {
        return mereology.getPartsOf(fragment);
    }

    @Override
    public Iterable<IFragmentAST> getProperFragmentsOf(IFragmentAST fragment) {
        return mereology.getProperPartsOf(fragment);
    }

    @Override
    public boolean isFragmentOf(IFragmentAST fragment, IFragmentAST total) {
        return mereology.isPartOf(fragment, total);
    }

    @Override
    public boolean isProperFragmentOf(IFragmentAST fragment, IFragmentAST total) {
        return mereology.isProperPartOf(fragment, total);
    }
}
