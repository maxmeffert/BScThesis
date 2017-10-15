package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public class ParserResult implements IParserResult {

    private final boolean hasAcceptedInput;
    private final ITree<ITextSource> parseTree;
    private final ParserException parserException;

    public ParserResult(boolean hasAcceptedInput, ITree<ITextSource> parseTree, ParserException parserException) {
        this.hasAcceptedInput = hasAcceptedInput;
        this.parseTree = parseTree;
        this.parserException = parserException;
    }

    @Override
    public boolean hasAcceptedInput() {
        return hasAcceptedInput;
    }

    @Override
    public boolean hasNotAcceptedInput() {
        return !hasAcceptedInput();
    }

    @Override
    public ITree<ITextSource> getParseTree() {
        return parseTree;
    }

    @Override
    public ParserException getParserException() {
        return parserException;
    }
}
