package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.graphs.ITree;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

import java.util.Map;
import java.util.Optional;

public class SimpleParseTree implements ISimpleParseTree {

    @Override
    public ITextSource getRoot() {
        return null;
    }

    @Override
    public boolean isRoot(ITextSource iTextSource) {
        return false;
    }

    @Override
    public boolean hasParent(ITextSource iTextSource) {
        return false;
    }

    @Override
    public Optional<ITextSource> getParentOf(ITextSource iTextSource) {
        return null;
    }

    @Override
    public Iterable<ITextSource> getChildrenOf(ITextSource iTextSource) {
        return null;
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
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getNodeCount() {
        return 0;
    }

    @Override
    public Iterable<ITextSource> getNodes() {
        return null;
    }

    @Override
    public Iterable<ITextSource> getAdjacentNodesOf(ITextSource iTextSource) {
        return null;
    }
}
