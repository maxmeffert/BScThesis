package org.softlang.maxmeffert.bscthesis.relations;

import org.softlang.maxmeffert.bscthesis.collections.IPair;

public interface IBinaryRelation<TFirst extends Comparable<TFirst>, TSecond extends Comparable<TSecond>> {

    Iterable<IPair<TFirst, TSecond>> getPairs();

    boolean contains(IPair<TFirst, TSecond> pair);

}
