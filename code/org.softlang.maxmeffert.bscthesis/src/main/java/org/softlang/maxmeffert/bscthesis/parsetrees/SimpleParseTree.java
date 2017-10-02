package org.softlang.maxmeffert.bscthesis.parsetrees;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public class SimpleParseTree implements ISimpleParseTree {

    private final ITree<ITextSource> tree;

    public SimpleParseTree(ITree<ITextSource> tree) {
        this.tree = tree;
    }

    @Override
    public ITextSource getValue() {
        return tree.getValue();
    }

    @Override
    public boolean hasParent() {
        return tree.hasParent();
    }

    @Override
    public boolean hasParent(ITree<ITextSource> parent) {
        return tree.hasParent(parent);
    }

    @Override
    public ITree<ITextSource> getParent() {
        return tree.getParent();
    }

    @Override
    public void setParent(ITree<ITextSource> parent) {
        tree.setParent(parent);
    }

    @Override
    public boolean hasChildren() {
        return tree.hasChildren();
    }

    @Override
    public boolean hasChild(ITree<ITextSource> child) {
        return tree.hasChild(child);
    }

    @Override
    public Iterable<ITree<ITextSource>> getChildren() {
        return tree.getChildren();
    }

    @Override
    public void addChild(ITree<ITextSource> child) {
        tree.addChild(child);
    }

    @Override
    public void addChildren(Iterable<ITree<ITextSource>> children) {
        tree.addChildren(children);
    }

    @Override
    public int compareTo(ITree<ITextSource> iTextSourceITree) {
        return tree.compareTo(iTextSourceITree);
    }
}
