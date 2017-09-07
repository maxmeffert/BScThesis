package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs;

import java.util.function.Supplier;

public class Graphs {

    public static <T extends Comparable<T>, G extends IGraph<T>> IGraphBuilder<T,G> copyBuilderOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = supplier.get();
        builder.add(graph.getEdges());
        return builder;
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G copyOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        return copyBuilderOf(graph, supplier).build();
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> IGraphBuilder<T,G> reflexiveTransitiveClosureBuilderOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = copyBuilderOf(graph, supplier);
        graph.getVertices().forEach(vertex -> {
            GraphWalker.<T>get().walkDepthFirst(graph, vertex, v -> {
                if (!graph.getAdjacentVerticesOf(v).contains(vertex)) {
                    builder.add(vertex, v);
                }
            });
        });
        return builder;
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G reflexiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = copyBuilderOf(graph, supplier);
        graph.getVertices().forEach(vertex -> builder.add(vertex, vertex));
        return builder.build();
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G transitiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = copyBuilderOf(graph, supplier);
        graph.getVertices().forEach(vertex -> {
            GraphWalker.<T>get().walkDepthFirst(graph, vertex, v -> {
                if (vertex.compareTo(v) != 0 && !graph.getAdjacentVerticesOf(v).contains(vertex)) {
                    builder.add(vertex, v);
                }
            });
        });
        return builder.build();
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G reflexiveTransitiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        return reflexiveTransitiveClosureBuilderOf(graph, supplier).build();
    }

    public static <T extends Comparable<T>> boolean reflexiveClosureContainsEdge(IGraph<T> graph, T vertex1, T vertex2) {
        return vertex1.compareTo(vertex2) == 0 || graph.containsEdge(vertex1, vertex2);
    }

    public static <T extends Comparable<T>> boolean reflexiveClosureContainsEdge(IGraph<T> graph, IPair<T,T> edge) {
        return reflexiveClosureContainsEdge(graph, edge.getFirst(), edge.getSecond());
    }

    public static <T extends Comparable<T>> boolean transitiveClosureContainsEdge(IGraph<T> graph, T vertex1, T vertex2) {
        return false;
    }

    public static <T extends Comparable<T>> boolean transitiveClosureContainsEdge(IGraph<T> graph, IPair<T,T> edge) {
        return reflexiveClosureContainsEdge(graph, edge.getFirst(), edge.getSecond());
    }

    public static <T extends Comparable<T>> boolean reflexiveTransitiveClosureContainsEdge(IGraph<T> graph, T vertex1, T vertex2) {
        return GraphWalker.<T>get().findDepthFirst(graph, vertex1, (v) -> vertex2.compareTo(v) == 0);
    }

    public static <T extends Comparable<T>> boolean reflexiveTransitiveClosureContainsEdge(IGraph<T> graph, IPair<T,T> edge) {
        return reflexiveTransitiveClosureContainsEdge(graph, edge.getFirst(), edge.getSecond());
    }

}
