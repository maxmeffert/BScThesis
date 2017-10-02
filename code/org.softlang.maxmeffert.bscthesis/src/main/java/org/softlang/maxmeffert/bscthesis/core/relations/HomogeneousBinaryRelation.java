package org.softlang.maxmeffert.bscthesis.core.relations;


import org.softlang.maxmeffert.bscthesis.core.utils.IPair;

public class HomogeneousBinaryRelation<T extends Comparable<T>> implements IHomogeneousBinaryRelation<T> {

    @Override
    public Iterable<IPair<T, T>> getPairs() {
        return null;
    }

    @Override
    public boolean contains(IPair<T, T> pair) {
        return false;
    }
}
