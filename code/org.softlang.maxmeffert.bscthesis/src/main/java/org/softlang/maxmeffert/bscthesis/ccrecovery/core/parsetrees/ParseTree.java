package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

import java.util.List;
import java.util.Optional;

public class ParseTree implements IParseTree {

    private final String name;
    private final ITextSource textSource;
    private final Class<? extends org.antlr.v4.runtime.tree.ParseTree> antlrType;

    private final List<IParseTree> children;
    private IParseTree parent;

    public ParseTree(String name, ITextSource textSource, Class<? extends org.antlr.v4.runtime.tree.ParseTree> antlrType, List<IParseTree> children) {
        this.name = name;
        this.textSource = textSource;
        this.antlrType = antlrType;
        this.children = children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITextSource getTextSource() {
        return textSource;
    }

    @Override
    public Class<? extends org.antlr.v4.runtime.tree.ParseTree> getAntlrType() {
        return antlrType;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public boolean hasParent(IParseTree parent) {
        return this.parent == parent;
    }

    @Override
    public Optional<IParseTree> getParent() {
        return Optional.ofNullable(parent);
    }

    @Override
    public void setParent(IParseTree parent) {
        if(cannotSetParent(parent)) {
            return;
        }
        this.parent = parent;
        this.parent.addChild(this);
    }

    private boolean cannotSetParent(IParseTree parent) {
        return parent == null || parent == this || hasParent(parent) || parent.hasParent(this);
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public boolean hasChild(IParseTree child) {
        return children.contains(child);
    }

    @Override
    public List<IParseTree> getChildren() {
        return children;
    }

    @Override
    public void addChild(IParseTree child) {
        if (cannotAddChild(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);
    }

    private boolean cannotAddChild(IParseTree child) {
        return child == null || child == this || hasChild(child) || child.hasChild(this);
    }

    @Override
    public void addChildren(Iterable<IParseTree> children) {
        for (IParseTree child : children) {
            addChild(child);
        }
    }

    private int compareChildrenTo(List<IParseTree> children) {
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
    public int compareTo(IParseTree parseTree) {
        int result = getName().compareTo(parseTree.getName());
        if (result == 0) {
            result = getTextSource().compareTo(parseTree.getTextSource());
        }
        if (result == 0) {
            result = compareChildrenTo(parseTree.getChildren());
        }
        return result;
    }
}
