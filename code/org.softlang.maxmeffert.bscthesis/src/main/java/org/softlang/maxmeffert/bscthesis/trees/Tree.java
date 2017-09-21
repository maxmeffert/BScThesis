package org.softlang.maxmeffert.bscthesis.trees;

import com.google.common.collect.Lists;

import java.util.Collection;

public class Tree<T> implements ITree<T> {

    private T value;
    private ITree<T> parent;
    private Collection<ITree<T>> children = Lists.newLinkedList();

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public ITree<T> getParent() {
        return parent;
    }

    private boolean cannotSetParent(ITree<T> parent) {
        return parent == null || parent == this || hasParent(parent) || parent.hasParent(this);
    }

    @Override
    public void setParent(ITree<T> parent) {
        if (cannotSetParent(parent)) {
            return;
        }
        this.parent = parent;
        this.parent.addChild(this);
    }

    @Override
    public boolean hasParent(ITree<T> parent) {
        return this.parent == parent;
    }

    @Override
    public Collection<ITree<T>> getChildren() {
        return children;
    }

    private boolean cannotAddChild(ITree<T> child) {
        return child == null || child == this || hasChild(child) || child.hasChild(this);
    }

    @Override
    public void addChild(ITree<T> child) {
        if (cannotAddChild(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    @Override
    public void addChildren(Collection<ITree<T>> children) {
        for(ITree<T> child : children) {
            addChild(child);
        }
    }

    @Override
    public boolean hasChild(ITree<T> child) {
        return children.contains(child);
    }

    @Override
    public String toString() {
        return "Tree('" + getValue() + "')";
    }
}
