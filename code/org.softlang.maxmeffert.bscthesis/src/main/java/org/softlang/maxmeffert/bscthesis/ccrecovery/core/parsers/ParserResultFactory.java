package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public class ParserResultFactory implements IParserResultFactory {
    @Override
    public IParserResult notAccepted(ParserException parserException) {
        return new ParserResult(false, null, parserException);
    }

    @Override
    public IParserResult accepted(IParseTree parseTree) {
        return new ParserResult(true, parseTree, null);
    }
}
