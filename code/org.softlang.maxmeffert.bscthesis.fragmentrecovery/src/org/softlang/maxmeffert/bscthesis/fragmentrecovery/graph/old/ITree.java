package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph.old;

public interface ITree<T extends Comparable<T>> extends Comparable<ITree<T>> {

    boolean isRoot();

    boolean isLeaf();

    T getData();

    void setData(T data);

    ITree<T> getParent();

    void setParent(ITree<T> parent);

    int getChildCount();

    Iterable<ITree<T>> getChildren();

    boolean hasChild(T child);

    boolean hasChild(ITree<T> child);

    ITree<T> getChild(T child);

    void addChild(ITree<T> child);

    void removeChild(ITree<T> child);

}
