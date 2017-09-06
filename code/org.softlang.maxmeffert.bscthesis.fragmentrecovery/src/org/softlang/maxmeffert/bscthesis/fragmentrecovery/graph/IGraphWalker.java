package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IGraphWalker<T extends Comparable<T>> {

    public void walkDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex, Consumer<T> vertexConsumer);
    void walkDepthFirst(IGraph<T> graph, T startVertex, Consumer<T> vertexConsumer);

}
