package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs;


import org.softlang.maxmeffert.bscthesis.fragmentrecovery.utils.IPair;

public interface IGraphBuilder<T extends Comparable<T>, G extends IGraph<T>> {

    void add(T vertex1, T vertex2);
    void add(IPair<T,T> edge);
    void add(Iterable<IPair<T,T>> edges);
    G build();

}
