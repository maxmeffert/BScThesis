package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public class ParserResultFactory implements IParserResultFactory {
    @Override
    public IParserResult notAccepted(Exception exception) {
        return new ParserResult(false, null, exception);
    }

    @Override
    public IParserResult accepted(IFragment fragmentAST) {
        return new ParserResult(true, fragmentAST, null);
    }
}
