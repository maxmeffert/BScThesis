package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;

public interface ISimpleParseTreeNormalizer {
    ITree<ITextSource> normalize(ITree<ITextSource> tree);
}
