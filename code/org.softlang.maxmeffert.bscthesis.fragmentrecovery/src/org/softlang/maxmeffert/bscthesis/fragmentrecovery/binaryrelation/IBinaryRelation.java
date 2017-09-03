package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

import java.util.Set;

public interface IBinaryRelation<T extends Comparable<T>> {

    Set<T> getValues();

    Set<IPair<T,T>> getPairs();

    boolean contains(T value);

    boolean contains(T left, T right);

    boolean contains(IPair<T,T> pair);

}
