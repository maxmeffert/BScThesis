package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import java.util.Iterator;
import java.util.Set;

public class Mereology<T extends Comparable<T>> implements IMereology<T> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public boolean isPartOf(T left, T right) {
        return false;
    }

    @Override
    public boolean isProperPartOf(T left, T right) {
        return false;
    }

    @Override
    public boolean isAtomOf(T left, T right) {
        return false;
    }

    @Override
    public boolean isAtom(T value) {
        return false;
    }

    @Override
    public boolean isFusion(T value) {
        return false;
    }

    @Override
    public boolean isBottom(T value) {
        return false;
    }

    @Override
    public boolean isTop(T value) {
        return false;
    }

    @Override
    public T getBottom() {
        return null;
    }

    @Override
    public T getTop() {
        return null;
    }

    @Override
    public Set<T> getProperPartsOf(T value) {
        return null;
    }

    @Override
    public Set<T> getPartsOf(T value) {
        return null;
    }

    @Override
    public Set<T> getAtomsOf(T value) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
