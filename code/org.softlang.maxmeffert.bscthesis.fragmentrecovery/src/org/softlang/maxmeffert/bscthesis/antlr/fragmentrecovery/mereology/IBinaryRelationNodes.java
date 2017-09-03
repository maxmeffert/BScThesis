package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

public interface IBinaryRelationNodes<N> extends Iterable<N> {
    boolean contains(N node);
    int indexOf(N node);
    N nodeOf(int index);
    int size();
}
