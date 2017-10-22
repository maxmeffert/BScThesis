package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.Pair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DiGraph<TValue extends Comparable<TValue>>  implements IDiGraph<TValue> {

    private final SortedMap<TValue, IDiGraphNode<TValue>> nodes = Maps.newTreeMap();

    @Override
    public SortedSet<TValue> getNodes() {
        return Sets.newTreeSet(nodes.keySet());
    }

    @Override
    public SortedSet<TValue> getNodes(Predicate<TValue> predicate) {
        return nodes.keySet().stream().filter(predicate).collect(Collectors.toCollection(Sets::newTreeSet));
    }

    @Override
    public SortedSet<IPair<TValue, TValue>> getEdges() {
        SortedSet<IPair<TValue,TValue>> edges = Sets.newTreeSet();
        for(TValue node : getNodes()) {
            for(TValue source : getSourceNodesOf(node)) {
                edges.add(new Pair<>(source, node));
            }
            for (TValue target: getTargetNodesOf(node)) {
                edges.add(new Pair<>(node, target));
            }
        }
        return edges;
    }

    @Override
    public SortedSet<TValue> getSourceNodesOf(TValue value) {
        return nodes.get(value).getSourceNodes();
    }

    @Override
    public SortedSet<TValue> getTargetNodesOf(TValue value) {
        return nodes.get(value).getTargetNodes();
    }

    @Override
    public SortedSet<TValue> getSourceWalk(TValue start) {
        return Sets.newTreeSet(() -> new DiGraphSourceIterator<>(this, start));
    }

    @Override
    public SortedSet<TValue> getTargetWalk(TValue start) {
        return Sets.newTreeSet(() -> new DiGraphTargetIterator<>(this, start));
    }

    private IDiGraphNode<TValue> getNode(TValue value) {
        if (!hasNode(value)) {
            nodes.put(value, new DiGraphNode<>(value));
        }
        return nodes.get(value);
    }

    @Override
    public boolean addEdge(TValue sourceValue, TValue targetValue) {
        IDiGraphNode<TValue> source = getNode(sourceValue);
        IDiGraphNode<TValue> target = getNode(targetValue);
        source.addTargetNode(targetValue);
        target.addSourceNode(sourceValue);
        return true;
    }

    @Override
    public boolean addEdge(IPair<TValue, TValue> edge) {
        return addEdge(edge.getFirst(), edge.getSecond());
    }

    @Override
    public boolean addEdges(Iterable<? extends IPair<TValue, TValue>> edges) {
        boolean changed = false;
        for (IPair<TValue,TValue> edge : edges) {
            changed |= addEdge(edge);
        }
        return changed;
    }

    @Override
    public boolean removeEdge(TValue sourceValue, TValue targetValue) {
        if (!hasEdge(sourceValue, targetValue)) {
            return false;
        }
        IDiGraphNode<TValue> source = nodes.get(sourceValue);
        IDiGraphNode<TValue> target = nodes.get(targetValue);
        source.removeTargetNode(targetValue);
        target.removeSourceNode(sourceValue);
        if (source.getSourceNodes().isEmpty() && source.getTargetNodes().isEmpty()) {
            nodes.remove(sourceValue, source);
        }
        if (target.getSourceNodes().isEmpty() && source.getTargetNodes().isEmpty()) {
            nodes.remove(targetValue, target);
        }
        return true;
    }

    @Override
    public boolean removeEdge(IPair<TValue, TValue> edge) {
        return removeEdge(edge.getFirst(), edge.getSecond());
    }

    @Override
    public boolean removeEdges(Iterable<? extends IPair<TValue, TValue>> edges) {
        boolean changed = false;
        for (IPair<TValue,TValue> edge : edges) {
            changed |= removeEdge(edge);
        }
        return changed;
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

    @Override
    public void clear() {
        nodes.clear();
    }


}
