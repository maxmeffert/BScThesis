package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public abstract class AbstractGraphNode<TValue extends Comparable<TValue>> implements IGraphNode<TValue> {

    private TValue tValue;

    @Override
    public TValue getValue() {
        return tValue;
    }

    public void setValue(TValue tValue) {
        this.tValue = tValue;
    }

    @Override
    public int compareTo(IGraphNode<TValue> tValueIGraphNode) {
        return getValue().compareTo(tValueIGraphNode.getValue());
    }
}
