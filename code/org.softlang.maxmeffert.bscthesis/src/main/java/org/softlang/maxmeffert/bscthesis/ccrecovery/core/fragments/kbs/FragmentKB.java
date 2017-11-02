package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;

import java.util.SortedSet;
import java.util.function.Predicate;

public class FragmentKB implements IFragmentKB {

    private final IMereology<IFragment> mereology;

    public FragmentKB(IMereology<IFragment> mereology) {
        this.mereology = mereology;
    }

    @Override
    public SortedSet<IFragment> getFragments() {
        return mereology.getElements();
    }

    @Override
    public SortedSet<IFragment> getFragmentsOf(IFragment fragment) {
        return mereology.getPartsOf(fragment);
    }

    @Override
    public SortedSet<IFragment> getProperFragmentsOf(IFragment fragment) {
        return mereology.getProperPartsOf(fragment);
    }

    @Override
    public boolean all(Predicate<IFragment> predicate) {
        return mereology.all(predicate);
    }

    @Override
    public boolean any(Predicate<IFragment> predicate) {
        return mereology.any(predicate);
    }

    @Override
    public boolean none(Predicate<IFragment> predicate) {
        return mereology.none(predicate);
    }

    @Override
    public boolean allFragmentsOf(IFragment fragmentAST, Predicate<IFragment> predicate) {
        return mereology.allPartsOf(fragmentAST, predicate);
    }

    @Override
    public boolean anyFragmentsOf(IFragment fragmentAST, Predicate<IFragment> predicate) {
        return mereology.anyPartsOf(fragmentAST, predicate);
    }

    @Override
    public boolean noneFragmentsOf(IFragment fragmentAST, Predicate<IFragment> predicate) {
        return mereology.nonePartsOf(fragmentAST, predicate);
    }

    @Override
    public boolean isFragmentOf(IFragment partialFragment, IFragment completeFragment) {
        return mereology.isPartOf(partialFragment, completeFragment);
    }

    @Override
    public boolean isProperFragmentOf(IFragment properFragment, IFragment completeFragment) {
        return mereology.isProperPartOf(properFragment, completeFragment);
    }

    @Override
    public boolean isAtomicFragmentOf(IFragment atomicFragment, IFragment completeFragment) {
        return mereology.isAtomOf(atomicFragment, completeFragment);
    }
}
