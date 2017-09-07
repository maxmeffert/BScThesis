package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs.old;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

public class Tree<T extends Comparable<T>> implements ITree<T> {

    private T data;
    private Optional<ITree<T>> parent;
    private final Map<T, ITree<T>> children = Maps.newTreeMap();


    @Override
    public boolean isRoot() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public ITree<T> getParent() {
        return parent.get();
    }

    @Override
    public void setParent(ITree<T> parent) {
        this.parent.get().removeChild(this);
        this.parent = Optional.of(parent);
        this.parent.get().addChild(this);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public Iterable<ITree<T>> getChildren() {
        return children.values();
    }

    @Override
    public boolean hasChild(T child) {
        return children.containsKey(child);
    }

    @Override
    public boolean hasChild(ITree<T> child) {
        return children.containsValue(child);
    }

    @Override
    public ITree<T> getChild(T child) {
        return children.get(child);
    }

    @Override
    public void addChild(ITree<T> child) {
        children.put(child.getData(), child);
    }

    @Override
    public void removeChild(ITree<T> child) {
        children.remove(child.getData());
    }

    @Override
    public int compareTo(ITree<T> tiTree) {
        return data.compareTo(tiTree.getData());
    }
}
