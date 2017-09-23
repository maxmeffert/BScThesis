package org.softlang.maxmeffert.bscthesis.graphs.trees;

import java.util.Collection;

public interface ITree<T> {
    T getValue();
    void setValue(T value);
    ITree<T> getParent();
    void setParent(ITree<T> parent);
    boolean hasParent(ITree<T> parent);
    Collection<ITree<T>> getChildren();
    void addChild(ITree<T> child);
    void addChildren(Collection<ITree<T>> children);
    boolean hasChild(ITree<T> child);
}
