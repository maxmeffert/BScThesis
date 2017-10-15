package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public interface IParserResultFactory {
    IParserResult notAccepted(ParserException parserException);
    IParserResult accepted(ITree<ITextSource> parseTree);
}
