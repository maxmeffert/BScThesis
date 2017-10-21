package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public class FragmentKB implements IFragmentKB {

    private final IMereology<IFragmentAST> mereology;

    public FragmentKB(IMereology<IFragmentAST> mereology) {
        this.mereology = mereology;
    }

    @Override
    public IView<IFragmentAST> getFragments() {
        return mereology.getElements();
    }

    @Override
    public IView<IFragmentAST> getFragmentsOf(IFragmentAST fragment) {
        return mereology.getPartsOf(fragment);
    }

    @Override
    public IView<IFragmentAST> getProperFragmentsOf(IFragmentAST fragment) {
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
