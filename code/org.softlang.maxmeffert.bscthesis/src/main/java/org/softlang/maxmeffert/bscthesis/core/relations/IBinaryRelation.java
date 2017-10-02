package org.softlang.maxmeffert.bscthesis.core.relations;

import org.softlang.maxmeffert.bscthesis.core.utils.IPair;

public interface IBinaryRelation<TFirst extends Comparable<TFirst>, TSecond extends Comparable<TSecond>> {

    Iterable<IPair<TFirst, TSecond>> getPairs();

    boolean contains(IPair<TFirst, TSecond> pair);

}
