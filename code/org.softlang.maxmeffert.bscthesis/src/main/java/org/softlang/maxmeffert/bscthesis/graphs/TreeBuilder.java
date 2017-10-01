package org.softlang.maxmeffert.bscthesis.graphs;

public class TreeBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> implements ITreeBuilder<TNode, TEdge> {

    private final IDiGraphBuilder<TNode,TEdge> diGraphBuilder;

    public TreeBuilder(IDiGraphBuilder<TNode, TEdge> diGraphBuilder) {
        this.diGraphBuilder = diGraphBuilder;
    }

    @Override
    public ITreeBuilder<TNode, TEdge> withChild(TNode parent, TNode child, TEdge tEdge) {
        return null;
    }

    @Override
    public ITree<TNode, TEdge> build() {
        return null;
    }
}
