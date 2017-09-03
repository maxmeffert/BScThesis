package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

public interface IBinaryRelation<T extends Comparable<T>> {

    IBinaryRelationNodes<T> getNodes();

    boolean contains(T value);

    boolean contains(T left, T right);

    BinaryRelation<T> reflexiveClosure();

    BinaryRelation<T> reflexiveTransitiveClosure();
}
