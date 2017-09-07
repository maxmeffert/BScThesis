package org.softlang.maxmeffert.bscthesis.mereologies;

import org.softlang.maxmeffert.bscthesis.relations.ReflexiveTransitiveClosure;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Set;

public class PartOf<T extends Comparable<T>> extends ReflexiveTransitiveClosure<T> {
    public PartOf(Set<IPair<T, T>> elements) {
        super(elements);
    }
}
