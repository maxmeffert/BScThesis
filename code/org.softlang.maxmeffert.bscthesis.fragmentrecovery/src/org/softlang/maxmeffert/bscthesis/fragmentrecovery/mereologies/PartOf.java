package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereologies;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs.IPair;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.relations.ReflexiveTransitiveClosure;

import java.util.Set;

public class PartOf<T extends Comparable<T>> extends ReflexiveTransitiveClosure<T> {
    public PartOf(Set<IPair<T, T>> elements) {
        super(elements);
    }
}
