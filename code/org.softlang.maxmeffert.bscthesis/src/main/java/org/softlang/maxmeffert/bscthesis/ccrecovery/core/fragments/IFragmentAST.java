package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;


import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.util.List;

public interface IFragmentAST extends Comparable<IFragmentAST> {
    boolean hasText();
    String getText();
    void setText(String text);

    boolean hasPosition();
    IFragmentPosition getPosition();
    void setPosition(IFragmentPosition position);

    boolean hasParent();
    IFragmentAST getParent();
    void setParent(IFragmentAST parent);

    boolean hasChildren();
    List<IFragmentAST> getChildren();
    void addChild(IFragmentAST child);
    void addChildren(Iterable<IFragmentAST> children);

    boolean isParentOf(IFragmentAST child);
    boolean isChildOf(IFragmentAST parent);
}
