package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

public interface IBinaryRelationFactory {
    <T extends Comparable<T>> IBinaryRelation<T> newBinaryRelation();
}
