package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public interface ITextSourceTreeNormalizer {
    ITree<ITextSource> normalize(ITree<ITextSource> iTextSourceITree);
}
