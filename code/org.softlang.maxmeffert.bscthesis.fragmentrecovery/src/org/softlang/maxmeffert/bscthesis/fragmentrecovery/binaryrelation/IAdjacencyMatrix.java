package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

import java.util.function.Function;

public interface IAdjacencyMatrix {

    int size();

    boolean get(int i, int j);

    IAdjacencyMatrix set(int i, int j, boolean value);

    IAdjacencyMatrix map(Function<IAdjacencyMatrix, IAdjacencyMatrix> function);

}
