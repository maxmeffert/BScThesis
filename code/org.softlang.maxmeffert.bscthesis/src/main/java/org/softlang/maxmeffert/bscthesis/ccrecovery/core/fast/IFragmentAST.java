package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast;


import java.util.List;
import java.util.Optional;

public interface IFragmentAST {
    boolean hasParent();
    boolean hasParent(IFragmentAST parent);
    Optional<IFragmentAST> getParent();
    void setParent(IFragmentAST parent);
    boolean hasChildren();
    boolean hasChild(IFragmentAST child);
    List<IFragmentAST> getChildren();
    void addChild(IFragmentAST child);
    void addChildren(Iterable<IFragmentAST> children);
}
