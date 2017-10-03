package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.iterables.IIterableUtils;

import java.util.SortedSet;

public class DiGraphNodeBuilder<TValue extends Comparable<TValue>> implements IDiGraphNodeBuilder<TValue> {

    private final ICollectionFactory collectionFactory;
    private final IIterableUtils iterableUtils;
    private final TValue value;
    private final SortedSet<TValue> sourceNodes;
    private final SortedSet<TValue> targetNodes;


    public DiGraphNodeBuilder(ICollectionFactory collectionFactory, IIterableUtils iterableUtils, TValue value, SortedSet<TValue> sourceNodes, SortedSet<TValue> targetNodes) {
        this.collectionFactory = collectionFactory;
        this.iterableUtils = iterableUtils;
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withValue(TValue value) {
        return new DiGraphNodeBuilder<>(collectionFactory, iterableUtils, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withSource(TValue source) {
        sourceNodes.add(source);
        return new DiGraphNodeBuilder<>(collectionFactory, iterableUtils, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withTarget(TValue target) {
        targetNodes.add(target);
        return new DiGraphNodeBuilder<>(collectionFactory, iterableUtils, value, sourceNodes, targetNodes);
    }

    private TValue buildValue() {
        return value;
    }

    private ISetView<TValue> buildSourceNodes() {
        return collectionFactory.newSetView(sourceNodes);
    }

    private ISetView<TValue> buildTargetNodes() {
        return collectionFactory.newSetView(targetNodes);
    }

    @Override
    public IDiGraphNode<TValue> build() {
        return new DiGraphNode<>(iterableUtils, buildValue(), buildSourceNodes(), buildTargetNodes());
    }
}
