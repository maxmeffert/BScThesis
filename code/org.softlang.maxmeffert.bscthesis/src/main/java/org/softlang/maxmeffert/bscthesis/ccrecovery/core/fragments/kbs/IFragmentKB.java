package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface IFragmentKB {
    SortedSet<IFragmentAST> getFragments();
    SortedSet<IFragmentAST> getFragmentsOf(IFragmentAST fragment);
    SortedSet<IFragmentAST> getProperFragmentsOf(IFragmentAST fragment);

    boolean all(Predicate<IFragmentAST> predicate);
    boolean any(Predicate<IFragmentAST> predicate);
    boolean none(Predicate<IFragmentAST> predicate);

    boolean allFragmentsOf(IFragmentAST fragmentAST, Predicate<IFragmentAST> predicate);
    boolean anyFragmentsOf(IFragmentAST fragmentAST, Predicate<IFragmentAST> predicate);
    boolean noneFragmentsOf(IFragmentAST fragmentAST, Predicate<IFragmentAST> predicate);

    boolean isFragmentOf(IFragmentAST partialFragment, IFragmentAST completeFragment);
    boolean isProperFragmentOf(IFragmentAST properFragment, IFragmentAST completeFragment);
    boolean isAtomicFragmentOf(IFragmentAST atomicFragment, IFragmentAST completeFragment);

}
