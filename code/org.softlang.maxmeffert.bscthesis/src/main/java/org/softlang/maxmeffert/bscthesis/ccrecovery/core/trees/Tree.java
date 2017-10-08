package org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees;

import java.util.List;

public class Tree<TValue extends Comparable<TValue>> implements ITree<TValue> {

    private final TValue value;
    private final List<ITree<TValue>> children;
    private ITree<TValue> parent;

    public Tree(TValue value, List<ITree<TValue>> children) {
        this.value = value;
        this.children = children;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public boolean hasParent(ITree<TValue> parent) {
        return this.parent == parent;
    }

    @Override
    public ITree<TValue> getParent() {
        return parent;
    }

    @Override
    public void setParent(ITree<TValue> parent) {
        if(cannotSetParent(parent)) {
            return;
        }
        this.parent = parent;
        this.parent.addChild(this);
    }

    private boolean cannotSetParent(ITree<TValue> parent) {
        return parent == null || parent == this || hasParent(parent) || parent.hasParent(this);
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public boolean hasChild(ITree<TValue> child) {
        return children.contains(child);
    }

    @Override
    public List<ITree<TValue>> getChildren() {
        return children;
    }

    @Override
    public void addChild(ITree<TValue> child) {
        if (cannotAddChild(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    private boolean cannotAddChild(ITree<TValue> child) {
        return child == null || child == this || hasChild(child) || child.hasChild(this);
    }

    @Override
    public void addChildren(Iterable<ITree<TValue>> children) {
        for (ITree<TValue> child : children) {
            addChild(child);
        }
    }

    private int compareChildrenTo(List<ITree<TValue>> children) {
        if (getChildren().size() < children.size()) {
            return -1;
        }
        if (getChildren().size() > children.size()) {
            return 1;
        }
        int result = 0;
        for (int i=0; i < getChildren().size(); i++) {
            result = getChildren().get(i).compareTo(children.get(i));
            if (result != 0) {
                return result;
            }
        }
        return result;
    }

    @Override
    public int compareTo(ITree<TValue> iTree) {
        int result = getValue().compareTo(iTree.getValue());
        if (result == 0) {
            result = compareChildrenTo(iTree.getChildren());
        }
        return result;
    }
}
