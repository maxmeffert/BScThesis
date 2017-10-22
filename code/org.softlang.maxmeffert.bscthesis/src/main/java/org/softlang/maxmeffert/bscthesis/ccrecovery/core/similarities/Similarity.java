package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.Pair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;

import java.util.Set;
import java.util.TreeSet;

public class Similarity implements ISimilarity {

    private final Set<IPair<IFragmentAST,IFragmentAST>> similarities = new TreeSet<>();

    @Override
    public boolean isEmpty() {
        return similarities.isEmpty();
    }

    @Override
    public boolean contains(IFragmentAST fragment1, IFragmentAST fragment2) {
        return similarities.contains(new Pair<>(fragment1, fragment2));
    }

    @Override
    public void add(IFragmentAST fragment1, IFragmentAST fragment2) {
        similarities.add(new Pair<>(fragment1, fragment2));
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
