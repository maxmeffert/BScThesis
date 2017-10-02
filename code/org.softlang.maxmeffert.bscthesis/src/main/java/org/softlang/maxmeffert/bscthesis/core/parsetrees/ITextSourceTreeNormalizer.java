package org.softlang.maxmeffert.bscthesis.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;

public interface ITextSourceTreeNormalizer {
    ITree<ITextSource> normalize(ITree<ITextSource> iTextSourceITree);
}
