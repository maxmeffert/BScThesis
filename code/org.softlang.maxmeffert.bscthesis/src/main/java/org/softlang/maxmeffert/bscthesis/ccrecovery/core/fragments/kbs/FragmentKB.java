package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;

import java.util.SortedSet;
import java.util.function.Predicate;

public class FragmentKB implements IFragmentKB {

    private final IMereology<IFragmentAST> mereology;

    public FragmentKB(IMereology<IFragmentAST> mereology) {
        this.mereology = mereology;
    }

    @Override
    public SortedSet<IFragmentAST> getFragments() {
        return mereology.getElements();
    }

    @Override
    public SortedSet<IFragmentAST> getFragmentsOf(IFragmentAST fragment) {
        return mereology.getPartsOf(fragment);
    }

    @Override
    public SortedSet<IFragmentAST> getProperFragmentsOf(IFragmentAST fragment) {
        return mereology.getProperPartsOf(fragment);
    }

    @Override
    public boolean all(Predicate<IFragmentAST> predicate) {
        return mereology.all(predicate);
    }

    @Override
    public boolean any(Predicate<IFragmentAST> predicate) {
        return mereology.any(predicate);
    }

    @Override
    public boolean none(Predicate<IFragmentAST> predicate) {
        return mereology.none(predicate);
    }

    @Override
    public boolean allFragmentsOf(IFragmentAST fragmentAST, Predicate<IFragmentAST> predicate) {
        return mereology.allPartsOf(fragmentAST, predicate);
    }

    @Override
    public boolean anyFragmentsOf(IFragmentAST fragmentAST, Predicate<IFragmentAST> predicate) {
        return mereology.anyPartsOf(fragmentAST, predicate);
    }

    @Override
    public boolean noneFragmentsOf(IFragmentAST fragmentAST, Predicate<IFragmentAST> predicate) {
        return mereology.nonePartsOf(fragmentAST, predicate);
    }

    @Override
    public boolean isFragmentOf(IFragmentAST partialFragment, IFragmentAST completeFragment) {
        return mereology.isPartOf(partialFragment, completeFragment);
    }

    @Override
    public boolean isProperFragmentOf(IFragmentAST properFragment, IFragmentAST completeFragment) {
        return mereology.isProperPartOf(properFragment, completeFragment);
    }

    @Override
    public boolean isAtomicFragmentOf(IFragmentAST atomicFragment, IFragmentAST completeFragment) {
        return mereology.isAtomOf(atomicFragment, completeFragment);
    }
}
