package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.graphs.ITree;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

import java.util.Map;
import java.util.Optional;

public class SimpleParseTree implements ISimpleParseTree {

    private final ITree<ITextSource,Integer> tree;

    public SimpleParseTree(ITree<ITextSource, Integer> tree) {
        this.tree = tree;
    }

    @Override
    public ITextSource getRoot() {
        return tree.getRoot();
    }

    @Override
    public boolean isRoot(ITextSource iTextSource) {
        return tree.isRoot(iTextSource);
    }

    @Override
    public boolean hasParent(ITextSource iTextSource) {
        return tree.hasParent(iTextSource);
    }

    @Override
    public Optional<ITextSource> getParentOf(ITextSource iTextSource) {
        return tree.getParentOf(iTextSource);
    }

    @Override
    public Iterable<ITextSource> getChildrenOf(ITextSource iTextSource) {
        return tree.getChildrenOf(iTextSource);
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int getNodeCount() {
        return tree.getNodeCount();
    }

    @Override
    public Iterable<ITextSource> getNodes() {
        return tree.getNodes();
    }

    @Override
    public Iterable<ITextSource> getAdjacentNodesOf(ITextSource iTextSource) {
        return tree.getAdjacentNodesOf(iTextSource);
    }

    @Override
    public Map<ITextSource, Integer> getAdjacentEdgesOf(ITextSource iTextSource) {
        return tree.getAdjacentEdgesOf(iTextSource);
    }

    @Override
    public Iterable<ITextSource> getSourceNodesOf(ITextSource iTextSource) {
        return null;
    }

    @Override
    public Iterable<ITextSource> getTargetNodesOf(ITextSource iTextSource) {
        return null;
    }

    @Override
    public Map<ITextSource, Integer> getSourceEdgesOf(ITextSource iTextSource) {
        return null;
    }

    @Override
    public Map<ITextSource, Integer> getTargetEdgesOf(ITextSource iTextSource) {
        return null;
    }
}
