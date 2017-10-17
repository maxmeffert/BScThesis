package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.ComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.Set;
import java.util.TreeSet;

public class Similarity implements ISimilarity {

    private final Set<IComparablePair<IFragment,IFragment>> similarities = new TreeSet<>();

    @Override
    public boolean isEmpty() {
        return similarities.isEmpty();
    }

    @Override
    public boolean contains(IFragment fragment1, IFragment fragment2) {
        return similarities.contains(new ComparablePair<>(fragment1, fragment2));
    }

    @Override
    public void add(IFragment fragment1, IFragment fragment2) {
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
