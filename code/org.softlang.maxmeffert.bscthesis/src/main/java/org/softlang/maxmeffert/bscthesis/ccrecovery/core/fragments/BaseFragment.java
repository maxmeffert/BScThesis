package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseFragment implements IFragment {

    private String text = "";
    private IFragmentPosition position;
    private IFragment parent;
    private List<IFragment> children = new LinkedList<>();

    private boolean isNull(IFragment fragment) {
        return fragment == null;
    }

    private boolean isSameInstance(IFragment fragment) {
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
    public final boolean hasPosition() {
        return position != null;
    }

    @Override
    public final IFragmentPosition getPosition() {
        return position;
    }

    @Override
    public final void setPosition(IFragmentPosition position) {
        this.position = position;
    }

    @Override
    public final boolean hasParent() {
        return parent != null;
    }

    @Override
    public final IFragment getParent() {
        return parent;
    }

    @Override
    public final List<IFragment> getChildren() {
        return children;
    }

    private boolean cannotSetParent(IFragment parent) {
        return isNull(parent) || isSameInstance(parent) || parent.isParentOf(this) || parent.isChildOf(this);
    }

    @Override
    public final void setParent(IFragment parent) {
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

    private boolean cannotAddChild(IFragment child) {
        return isNull(child) || isSameInstance(child) || child.isChildOf(this) || child.isParentOf(this);
    }

    @Override
    public final void addChild(IFragment child) {
        if (cannotAddChild(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    @Override
    public final void addChildren(Iterable<IFragment> children) {
        for (IFragment child : children) {
            addChild(child);
        }
    }

    @Override
    public final boolean isParentOf(IFragment child) {

        return !isSameInstance(child) && child.getParent() == this;
    }

    @Override
    public final boolean isChildOf(IFragment parent) {
        return !isSameInstance(parent) && parent.isParentOf(this);
    }

    @Override
    public final int compareTo(IFragment fragment) {
        if (fragment == this) {
            return 0;
        }
        return getText().compareTo(fragment.getText());
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof IFragment) {
            return compareTo((IFragment) obj) == 0;
        }
        return false;
    }

    @Override
    public final String toString() {
//        return getClass().getSimpleName();
        return getText() + "#" + getPosition();
    }
}
