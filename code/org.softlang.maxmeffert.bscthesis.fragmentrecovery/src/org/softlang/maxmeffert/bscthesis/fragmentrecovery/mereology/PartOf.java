package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereology;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.IPair;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.ReflexiveTransitiveClosure;

import java.util.Set;

public class PartOf<T extends Comparable<T>> extends ReflexiveTransitiveClosure<T> {
    public PartOf(Set<IPair<T, T>> elements) {
        super(elements);
    }
}
