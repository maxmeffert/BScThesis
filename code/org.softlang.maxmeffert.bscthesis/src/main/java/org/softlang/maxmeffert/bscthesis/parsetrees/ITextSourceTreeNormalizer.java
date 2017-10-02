package org.softlang.maxmeffert.bscthesis.parsetrees;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface ITextSourceTreeNormalizer {
    ITree<ITextSource> normalize(ITree<ITextSource> iTextSourceITree);
}
