package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.ComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IPair;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DiGraph<TValue extends Comparable<TValue>>  implements IDiGraph<TValue> {

    private final SortedMap<TValue, IDiGraphNode<TValue>> nodes = Maps.newTreeMap();

    @Override
    public Iterable<TValue> getNodes() {
        return nodes.keySet();
    }

    @Override
    public Iterable<TValue> getNodes(Predicate<TValue> predicate) {
        return nodes.keySet().stream().filter(predicate).collect(Collectors.toCollection(Sets::newTreeSet));
    }

    @Override
    public Iterable<IPair<TValue, TValue>> getEdges() {
        SortedSet<IComparablePair<TValue,TValue>> edges = Sets.newTreeSet();
        for(TValue node : getNodes()) {
            for(TValue source : getSourceNodesOf(node)) {
                edges.add(new ComparablePair<>(source, node));
            }
            for (TValue target: getTargetNodesOf(node)) {
                edges.add(new ComparablePair<>(node, target));
            }
        }
        return (Iterable) edges;
    }

    @Override
    public Iterable<TValue> getSourceNodesOf(TValue value) {
        return nodes.get(value).getSourceNodes();
    }

    @Override
    public Iterable<TValue> getTargetNodesOf(TValue value) {
        return nodes.get(value).getTargetNodes();
    }

    @Override
    public Iterable<TValue> getSourceWalk(TValue start) {
        return () -> new DiGraphSourceIterator<>(this, start);
    }

    @Override
    public Iterable<TValue> getTargetWalk(TValue start) {
        return () -> new DiGraphTargetIterator<>(this, start);
    }

    private IDiGraphNode<TValue> getNode(TValue value) {
        if (!hasNode(value)) {
            nodes.put(value, new DiGraphNode<>(value));
        }
        return nodes.get(value);
    }

    @Override
    public void addEdge(TValue sourceValue, TValue targetValue) {
        IDiGraphNode<TValue> source = getNode(sourceValue);
        IDiGraphNode<TValue> target = getNode(targetValue);
        source.addTargetNode(targetValue);
        target.addSourceNode(sourceValue);
    }

    @Override
    public void addEdge(IPair<TValue, TValue> edge) {
        addEdge(edge.getFirst(), edge.getSecond());
    }

    @Override
    public void addEdges(Iterable<IPair<TValue, TValue>> edges) {
        for (IPair<TValue,TValue> edge : edges) {
            addEdge(edge);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasNode(TValue value) {
        return nodes.containsKey(value);
    }

    @Override
    public boolean hasEdge(TValue source, TValue target) {
        if (!hasNode(source) && !hasNode(target)) {
            return false;
        }
        return nodes.get(source).isSourceOf(target);
    }

    @Override
    public boolean allNodes(Predicate<TValue> predicate) {
        return false;
    }

    @Override
    public boolean anyNodes(Predicate<TValue> predicate) {
        return false;
    }

    @Override
    public boolean noneNodes(Predicate<TValue> predicate) {
        return false;
    }

    @Override
    public IDiGraph<TValue> getCopy() {
        IDiGraph<TValue> copy = new DiGraph<>();
        copy.addEdges(getEdges());
        return copy;
    }

    private void addReflexiveEdges(IDiGraph<TValue> diGraph) {
        for (TValue node : diGraph.getNodes()) {
            diGraph.addEdge(node, node);
        }
    }

    private void addTransitiveEdges(IDiGraph<TValue> diGraph) {
        for (TValue node : diGraph.getNodes()) {
            for (TValue transitiveNode : diGraph.getTargetWalk(node)) {
                if (node.compareTo(transitiveNode) != 0 && !hasEdge(node, transitiveNode) && !hasEdge(transitiveNode, node)) {
                    diGraph.addEdge(node, transitiveNode);
                }
            }
        }
    }

    @Override
    public IDiGraph<TValue> getReflexiveClosure() {
        IDiGraph<TValue> closure = getCopy();
        addReflexiveEdges(closure);
        return closure;
    }

    @Override
    public IDiGraph<TValue> getTransitiveClosure() {
        IDiGraph<TValue> closure = getCopy();
        addTransitiveEdges(closure);
        return closure;
    }

    @Override
    public IDiGraph<TValue> getReflexiveTransitiveClosure() {
        return getReflexiveClosure().getTransitiveClosure();
    }


}
