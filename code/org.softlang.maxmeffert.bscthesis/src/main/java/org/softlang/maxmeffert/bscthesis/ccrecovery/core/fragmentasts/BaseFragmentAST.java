package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseFragmentAST implements IFragmentAST {

    private String text;
    private IFragmentAST parent;
    private List<IFragmentAST> children = new LinkedList<>();

    private boolean isNull(IFragmentAST fragment) {
        return fragment == null;
    }

    private boolean isSameInstance(IFragmentAST fragment) {
        return fragment == this;
    }

    @Override
    public final boolean hasText() {
        return text != null;
    }

    @Override
    public final String getText() {
        return text;
    }

    @Override
    public final void setText(String text) {
        this.text = text;
    }

    @Override
    public final boolean hasParent() {
        return parent != null;
    }

    @Override
    public final IFragmentAST getParent() {
        return parent;
    }

    @Override
    public final List<IFragmentAST> getChildren() {
        return children;
    }

    private boolean cannotSetParent(IFragmentAST parent) {
        return isNull(parent) || isSameInstance(parent) || parent.isParentOf(this) || parent.isChildOf(this);
    }

    @Override
    public final void setParent(IFragmentAST parent) {
        if (cannotSetParent(parent)) {
            return;
        }
        this.parent = parent;
        this.parent.addChild(this);
    }

    @Override
    public final boolean hasChildren() {
        return !children.isEmpty();
    }

    private boolean cannotAddChild(IFragmentAST child) {
        return isNull(child) || isSameInstance(child) || child.isChildOf(this) || child.isParentOf(this);
    }

    @Override
    public final void addChild(IFragmentAST child) {
        if (cannotAddChild(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    @Override
    public final void addChildren(Iterable<IFragmentAST> children) {
        for (IFragmentAST child : children) {
            addChild(child);
        }
    }

    @Override
    public final boolean isParentOf(IFragmentAST child) {

        return !isSameInstance(child) && child.getParent() == this;
    }

    @Override
    public final boolean isChildOf(IFragmentAST parent) {
        return !isSameInstance(parent) && parent.isParentOf(this);
    }

    @Override
    public final int compareTo(IFragmentAST fragment) {
        if (fragment == this) {
            return 0;
        }
        return getText().compareTo(fragment.getText());
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof IFragmentAST) {
            return compareTo((IFragmentAST) obj) == 0;
        }
        return false;
    }

    @Override
    public final String toString() {
//        return getClass().getSimpleName();
        return getText();
    }
}
