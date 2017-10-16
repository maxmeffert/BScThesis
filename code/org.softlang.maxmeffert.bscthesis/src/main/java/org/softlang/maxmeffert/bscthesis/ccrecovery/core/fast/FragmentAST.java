package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast;

import java.util.List;
import java.util.Optional;

public class FragmentAST implements IFragmentAST {
    private final List<IFragmentAST> children;
    private IFragmentAST parent;

    public FragmentAST(List<IFragmentAST> children) {
        this.children = children;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public boolean hasParent(IFragmentAST parent) {
        return this.parent == parent;
    }

    @Override
    public Optional<IFragmentAST> getParent() {
        return Optional.ofNullable(parent);
    }

    @Override
    public void setParent(IFragmentAST parent) {
        if(cannotSetParent(parent)) {
            return;
        }
        this.parent = parent;
        this.parent.addChild(this);
    }

    private boolean cannotSetParent(IFragmentAST parent) {
        return parent == null || parent == this || hasParent(parent) || parent.hasParent(this);
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public boolean hasChild(IFragmentAST child) {
        return children.contains(child);
    }

    @Override
    public List<IFragmentAST> getChildren() {
        return (List<IFragmentAST>) children;
    }

    @Override
    public void addChild(IFragmentAST child) {
        if (cannotAddChild(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    private boolean cannotAddChild(IFragmentAST child) {
        return child == null || child == this || hasChild(child) || child.hasChild(this);
    }

    @Override
    public void addChildren(Iterable<IFragmentAST> children) {
        for (IFragmentAST child : children) {
            addChild(child);
        }
    }

}
