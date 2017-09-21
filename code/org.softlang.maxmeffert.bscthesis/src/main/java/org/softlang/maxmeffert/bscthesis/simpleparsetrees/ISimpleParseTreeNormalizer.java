package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.textsources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface ISimpleParseTreeNormalizer {
    ITree<ITextSource> normalize(ITree<ITextSource> tree);
}
