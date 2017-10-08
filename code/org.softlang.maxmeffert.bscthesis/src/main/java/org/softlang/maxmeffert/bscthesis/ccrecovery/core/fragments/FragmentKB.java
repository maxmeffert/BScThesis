package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

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
    public boolean isFragmentOf(IFragment component, IFragment composite) {
        return mereology.isPartOf(component, composite);
    }
}
