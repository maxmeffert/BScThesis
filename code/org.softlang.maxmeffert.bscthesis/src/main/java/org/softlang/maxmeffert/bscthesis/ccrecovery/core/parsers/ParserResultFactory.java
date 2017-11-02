package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

public class ParserResultFactory implements IParserResultFactory {
    @Override
    public IParserResult notAccepted(Exception exception) {
        return new ParserResult(false, null, exception);
    }

    @Override
    public IParserResult accepted(IFragmentAST fragmentAST) {
        return new ParserResult(true, fragmentAST, null);
    }
}
