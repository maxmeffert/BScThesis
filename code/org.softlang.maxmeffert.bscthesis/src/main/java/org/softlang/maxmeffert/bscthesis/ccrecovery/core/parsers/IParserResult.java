package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public interface IParserResult {
    boolean hasAcceptedInput();
    boolean hasNotAcceptedInput();
    ITree<ITextSource> getParseTree();
    ParserException getParserException();
}
