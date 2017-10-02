package org.softlang.maxmeffert.bscthesis.core.trees;

public interface ITree<TValue extends Comparable<TValue>> extends Comparable<ITree<TValue>> {
    TValue getValue();
    boolean hasParent();
    boolean hasParent(ITree<TValue> parent);
    ITree<TValue> getParent();
    void setParent(ITree<TValue> parent);
    boolean hasChildren();
    boolean hasChild(ITree<TValue> child);
    Iterable<ITree<TValue>> getChildren();
    void addChild(ITree<TValue> child);
    void addChildren(Iterable<ITree<TValue>> children);
}
