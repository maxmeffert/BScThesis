package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.graphs.ITree;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

public interface ISimpleParseTreeNormalizer {
    ITree<ITextSource> normalize(ITree<ITextSource> tree);
}
