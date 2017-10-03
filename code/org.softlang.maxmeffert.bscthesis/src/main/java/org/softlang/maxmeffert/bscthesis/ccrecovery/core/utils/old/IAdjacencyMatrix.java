package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.old;

import java.util.function.Function;

public interface IAdjacencyMatrix {

    int size();

    boolean get(int i, int j);

    IAdjacencyMatrix set(int i, int j, boolean value);

    IAdjacencyMatrix map(Function<IAdjacencyMatrix, IAdjacencyMatrix> function);

}
