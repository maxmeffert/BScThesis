package org.softlang.maxmeffert.bscthesis.utils;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Mapping<TKey extends Comparable<TKey>, TValue extends Comparable<TValue>> implements IMapping<TKey,TValue> {

    private final SortedSet<IPair<TKey,TValue>> pairs;

    public Mapping(SortedSet<IPair<TKey, TValue>> pairs) {
        this.pairs = pairs;
    }


    @Override
    public boolean isEmpty() {
        return pairs.isEmpty();
    }

    @Override
    public int size() {
        return pairs.size();
    }

    @Override
    public Iterable<TKey> getKeys() {
        return pairs.stream()
                .map(pair -> pair.getFirst())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Iterable<TValue> getValues() {
        return null;
    }

    @Override
    public TValue getValue(TKey tKey) {
        return null;
    }

    @Override
    public Iterator<IPair<TKey, TValue>> iterator() {
        return pairs.iterator();
    }
}
