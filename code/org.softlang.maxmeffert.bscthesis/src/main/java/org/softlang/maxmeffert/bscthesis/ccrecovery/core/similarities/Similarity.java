package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.ComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.Set;
import java.util.TreeSet;

public class Similarity implements ISimilarity {

    private final Set<IComparablePair<IFragmentAST,IFragmentAST>> similarities = new TreeSet<>();

    @Override
    public boolean isEmpty() {
        return similarities.isEmpty();
    }

    @Override
    public boolean contains(IFragmentAST fragment1, IFragmentAST fragment2) {
        return similarities.contains(new ComparablePair<>(fragment1, fragment2));
    }

    @Override
    public void add(IFragmentAST fragment1, IFragmentAST fragment2) {
        similarities.add(new ComparablePair<>(fragment1, fragment2));
    }

    @Override
    public int size() {
        return similarities.size();
    }

    @Override
    public String toString() {
        return similarities.toString();
    }
}
