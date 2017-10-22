package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

import java.util.SortedSet;

public class DiGraphNodeBuilder<TValue extends Comparable<TValue>> implements IDiGraphNodeBuilder<TValue> {

    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;
    private final TValue value;
    private final SortedSet<TValue> sourceNodes;
    private final SortedSet<TValue> targetNodes;
    private final SortedSet<TValue> adjacentNodes;


    public DiGraphNodeBuilder(ICollectionFactory collectionFactory, IViewFactory viewFactory, TValue value, SortedSet<TValue> sourceNodes, SortedSet<TValue> targetNodes, SortedSet<TValue> adjacentNodes) {
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withValue(TValue value) {
        return new DiGraphNodeBuilder<>(collectionFactory, viewFactory, value, sourceNodes, targetNodes, adjacentNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withSource(TValue source) {
        sourceNodes.add(source);
        adjacentNodes.add(source);
        return new DiGraphNodeBuilder<>(collectionFactory, viewFactory, value, sourceNodes, targetNodes, adjacentNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withTarget(TValue target) {
        targetNodes.add(target);
        adjacentNodes.add(target);
        return new DiGraphNodeBuilder<>(collectionFactory, viewFactory, value, sourceNodes, targetNodes, adjacentNodes);
    }

    private TValue buildValue() {
        return value;
    }

    private IView<TValue> buildSourceNodes() {
        return viewFactory.newView(sourceNodes);
    }

    private IView<TValue> buildTargetNodes() {
        return viewFactory.newView(targetNodes);
    }

    private IView<TValue> buildAdjacentNodes() {
        return viewFactory.newView(adjacentNodes);
    }

    @Override
    public IDiGraphNode<TValue> build() {
        return new DiGraphNode<>(buildValue(), buildSourceNodes(), buildTargetNodes(), buildAdjacentNodes());
    }
}
