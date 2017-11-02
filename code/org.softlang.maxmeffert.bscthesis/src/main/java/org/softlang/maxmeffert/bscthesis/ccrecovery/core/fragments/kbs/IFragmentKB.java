package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface IFragmentKB {
    SortedSet<IFragment> getFragments();
    SortedSet<IFragment> getFragmentsOf(IFragment fragment);
    SortedSet<IFragment> getProperFragmentsOf(IFragment fragment);

    boolean all(Predicate<IFragment> predicate);
    boolean any(Predicate<IFragment> predicate);
    boolean none(Predicate<IFragment> predicate);

    boolean allFragmentsOf(IFragment fragmentAST, Predicate<IFragment> predicate);
    boolean anyFragmentsOf(IFragment fragmentAST, Predicate<IFragment> predicate);
    boolean noneFragmentsOf(IFragment fragmentAST, Predicate<IFragment> predicate);

    boolean isFragmentOf(IFragment partialFragment, IFragment completeFragment);
    boolean isProperFragmentOf(IFragment properFragment, IFragment completeFragment);
    boolean isAtomicFragmentOf(IFragment atomicFragment, IFragment completeFragment);

}
