package org.softlang.maxmeffert.bscthesis.graphs.old;

import com.google.common.collect.Maps;
import org.softlang.maxmeffert.bscthesis.utils.AdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.utils.IAdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.Map;
import java.util.function.Supplier;

public class GraphClosures {

    public static <T extends Comparable<T>> IGraphBuilder<T, DiGraph<T>> diGraphBuilder() {
        return DiGraph.Builder.get();
    }



    public static <T extends Comparable<T>, G extends IGraph<T>> G copyOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = supplier.get();
        builder.add(graph.getEdges());
        return builder.build();
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G reflexiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = supplier.get();
        builder.add(graph.getEdges());
        for (T vertex : graph.getVertices()) {
            builder.add(vertex, vertex);
        }
        return builder.build();
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G transitiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = supplier.get();
        builder.add(graph.getEdges());
        for (T vertex : graph.getVertices()) {
            for (T v : GraphWalker.<T>get().getDepthFirstWalk(graph::getAdjacentVerticesOf, vertex)) {
                if (!vertex.equals(v) && !graph.getAdjacentVerticesOf(v).contains(vertex)) {
                    builder.add(vertex, v);
                }
            }
        }
        return builder.build();
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G reflexiveTransitiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = supplier.get();
        builder.add(graph.getEdges());
        for (T vertex : graph.getVertices()) {
            for (T v : GraphWalker.<T>get().getDepthFirstWalk(graph::getAdjacentVerticesOf, vertex)) {
                if (!graph.getAdjacentVerticesOf(v).contains(vertex)) {
                    builder.add(vertex, v);
                }
            }
        }
        return builder.build();
    }

    public static <T extends Comparable<T>> boolean reflexiveClosureContainsEdge(IGraph<T> graph, T vertex1, T vertex2) {
        return vertex1.compareTo(vertex2) == 0 || graph.getAdjacentVerticesOf(vertex1).contains(vertex2);
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
        return GraphWalker.<T>get().anyDepthFirst(graph, vertex1, (v) -> vertex2.compareTo(v) == 0);
    }

    public static <T extends Comparable<T>> boolean reflexiveTransitiveClosureContainsEdge(IGraph<T> graph, IPair<T,T> edge) {
        return reflexiveTransitiveClosureContainsEdge(graph, edge.getFirst(), edge.getSecond());
    }

    private static <T extends Comparable<T>> Map<T, Integer> buildVertexIndices(IGraph<T> graph) {
        Map<T, Integer> indices = Maps.newTreeMap();
        graph.getVertices().forEach(vertex -> indices.put(vertex, indices.size()));
        return indices;
    }

    public static <T extends Comparable<T>> IAdjacencyMatrix toAdjacencyMatrix(IGraph<T> graph) {
        IAdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph.getVertices().size());
        Map<T, Integer> indices = buildVertexIndices(graph);
        for (IPair<T,T> edge : graph.getEdges()) {
            adjacencyMatrix = adjacencyMatrix.set(indices.get(edge.getFirst()), indices.get(edge.getSecond()), true);
        }
        return adjacencyMatrix;
    }

}
