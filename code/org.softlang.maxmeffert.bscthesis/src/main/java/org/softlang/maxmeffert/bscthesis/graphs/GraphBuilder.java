package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.softlang.maxmeffert.bscthesis.graphs.old.IDiGraph;
import org.softlang.maxmeffert.bscthesis.text.sources.TextSource;
import org.softlang.maxmeffert.bscthesis.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.tuples.ITriple;
import org.softlang.maxmeffert.bscthesis.tuples.ITupleFactory;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

public class GraphBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> {

    private final ITupleFactory tupleFactory;
    private final SortedSet<TNode> nodes = Sets.newTreeSet();
    private final SortedMap<TNode, SortedSet<IPair<TNode,TEdge>>> sourceEdges = Maps.newTreeMap();
    private final SortedMap<TNode, SortedSet<IPair<TNode,TEdge>>> targetEdges = Maps.newTreeMap();

    public GraphBuilder(ITupleFactory tupleFactory) {
        this.tupleFactory = tupleFactory;
    }

    private <K,V> V get(Map<K,V> map, K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, value);
        }
        return map.get(key);
    }

    private SortedSet<IPair<TNode,TEdge>> getSourceEdges(TNode node) {
        return get(sourceEdges, node, Sets.newTreeSet());
    }


    private SortedSet<IPair<TNode,TEdge>> getTargetEdges(TNode node) {
        return get(targetEdges, node, Sets.newTreeSet());
    }

    public GraphBuilder<TNode, TEdge> with(TNode node1, TNode node2, TEdge edgeValue) {
        nodes.add(node1);
        nodes.add(node2);
        getTargetEdges(node1).add(tupleFactory.newPair(node2, edgeValue));
        getSourceEdges(node2).add(tupleFactory.newPair(node1, edgeValue));
        return this;
    }

    public IGraph<TNode,TEdge> build() {
        SortedMap<TNode, IDiGraphNode<TNode,TEdge>> nodes = Maps.newTreeMap();
        for (TNode node : this.nodes) {
            nodes.put(node, new DiGraphNode<>(node, getSourceEdges(node), getTargetEdges(node)));
        }
        return null;
    }
}
