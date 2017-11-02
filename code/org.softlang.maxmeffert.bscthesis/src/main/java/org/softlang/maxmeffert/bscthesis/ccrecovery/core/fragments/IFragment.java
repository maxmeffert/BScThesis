package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;


import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.util.List;

public interface IFragment extends Comparable<IFragment> {
    boolean hasText();
    String getText();
    void setText(String text);

    boolean hasPosition();
    IFragmentPosition getPosition();
    void setPosition(IFragmentPosition position);

    boolean hasParent();
    IFragment getParent();
    void setParent(IFragment parent);

    boolean hasChildren();
    List<IFragment> getChildren();
    void addChild(IFragment child);
    void addChildren(Iterable<IFragment> children);

    boolean isParentOf(IFragment child);
    boolean isChildOf(IFragment parent);
}
