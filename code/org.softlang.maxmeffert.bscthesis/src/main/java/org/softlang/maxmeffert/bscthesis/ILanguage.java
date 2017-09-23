package org.softlang.maxmeffert.bscthesis;

import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;

public interface ILanguage {
    boolean accept(String string);
    ITree<ITextSource> parse(String string);
}
