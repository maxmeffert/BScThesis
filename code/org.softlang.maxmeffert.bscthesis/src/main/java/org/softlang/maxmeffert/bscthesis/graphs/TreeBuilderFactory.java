package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;

public class TreeBuilderFactory implements ITreeBuilderFactory {

    private final IDiGraphBuilderFactory diGraphBuilderFactory;

    @Inject
    public TreeBuilderFactory(IDiGraphBuilderFactory diGraphBuilderFactory) {
        this.diGraphBuilderFactory = diGraphBuilderFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> ITreeBuilder<TValue> newTreeBuilder() {
        return new TreeBuilder<>();
    }
}
