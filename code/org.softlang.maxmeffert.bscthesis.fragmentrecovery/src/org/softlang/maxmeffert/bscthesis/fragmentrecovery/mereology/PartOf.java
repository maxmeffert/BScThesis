package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereology;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.BinaryRelation;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.IPair;

import java.util.Set;

public class PartOf<T extends Comparable<T>> extends BinaryRelation<T> {

    public PartOf(Set<IPair<T, T>> elements) {
        super(elements);
    }
}
