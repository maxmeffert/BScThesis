package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public class FragmentKB implements IFragmentKB {

    private final IMereology<IFragment> mereology;

    public FragmentKB(IMereology<IFragment> mereology) {
        this.mereology = mereology;
    }

    @Override
    public IView<IFragment> getFragments() {
        return mereology.getElements();
    }

    @Override
    public IView<IFragment> getFragmentsOf(IFragment fragment) {
        return mereology.getPartsOf(fragment);
    }

    @Override
    public IView<IFragment> getProperFragmentsOf(IFragment fragment) {
        return mereology.getProperPartsOf(fragment);
    }

    @Override
    public boolean isFragmentOf(IFragment fragment, IFragment total) {
        return mereology.isPartOf(fragment, total);
    }

    @Override
    public boolean isProperFragmentOf(IFragment fragment, IFragment total) {
        return mereology.isProperPartOf(fragment, total);
    }
}
