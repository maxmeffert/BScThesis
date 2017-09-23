package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;

public class DiGraphNode<TNode extends Comparable<TNode>,TEdge extends Comparable<TEdge>> implements IDiGraphNode<TNode,TEdge> {

    private final TNode value;
    private final SortedMap<TNode,TEdge> sourceEdges;
    private final SortedMap<TNode,TEdge> targetEdges;

    public DiGraphNode(TNode value, SortedMap<TNode, TEdge> sourceEdges, SortedMap<TNode, TEdge> targetEdges) {
        this.value = value;
        this.sourceEdges = sourceEdges;
        this.targetEdges = targetEdges;
    }


    @Override
    public Iterable<TNode> getSourceNodes() {
        return sourceEdges.keySet();
    }

    @Override
    public Iterable<TNode> getTargetNodes() {
        return targetEdges.keySet();
    }

    @Override
    public Map<TNode, TEdge> getSourceEdges() {
        return Collections.unmodifiableMap(sourceEdges);
    }

    @Override
    public Map<TNode, TEdge> getTargetEdges() {
        return Collections.unmodifiableMap(targetEdges);
    }


    @Override
    public TNode getValue() {
        return value;
    }

    @Override
    public Iterable<TNode> getAdjacentNodes() {
        return Iterables.concat(getSourceNodes(), getTargetNodes());
    }

    @Override
    public Map<TNode, TEdge> getAdjacentEdges() {
        Map<TNode,TEdge> map = Maps.newTreeMap();
        map.putAll(getSourceEdges());
        map.putAll(getTargetEdges());
        return map;
    }


    @Override
    public int compareTo(IGraphNode<TNode, TEdge> graphNode) {
        return value.compareTo(graphNode.getValue());
    }
}
