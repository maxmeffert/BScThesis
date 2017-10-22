package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class SortedSetProxy<T extends Comparable<T>> implements SortedSet<T> {

    protected final SortedSet<T> sortedSet;

    public SortedSetProxy(SortedSet<T> sortedSet) {
        this.sortedSet = sortedSet;
    }

    @Override
    public Comparator<? super T> comparator() {
        return sortedSet.comparator();
    }

    @Override
    public SortedSet<T> subSet(T t, T e1) {
        return sortedSet.subSet(t,e1);
    }

    @Override
    public SortedSet<T> headSet(T t) {
        return sortedSet.headSet(t);
    }

    @Override
    public SortedSet<T> tailSet(T t) {
        return sortedSet.tailSet(t);
    }

    @Override
    public T first() {
        return sortedSet.first();
    }

    @Override
    public T last() {
        return sortedSet.last();
    }

    @Override
    public int size() {
        return sortedSet.size();
    }

    @Override
    public boolean isEmpty() {
        return sortedSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return sortedSet.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return sortedSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return sortedSet.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return sortedSet.toArray(t1s);
    }

    @Override
    public boolean add(T t) {
        return sortedSet.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return sortedSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return sortedSet.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return sortedSet.addAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return sortedSet.retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return sortedSet.removeAll(collection);
    }

    @Override
    public void clear() {
        sortedSet.clear();
    }

    @Override
    public String toString() {
        return sortedSet.toString();
    }
}
