package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrParsingResult implements IAntlrParsingResult {

    private final TokenStream tokenStream;
    private final ParseTree parseTree;

    public AntlrParsingResult(TokenStream tokenStream, ParseTree parseTree) {
        this.tokenStream = tokenStream;
        this.parseTree = parseTree;
    }

    @Override
    public TokenStream getTokenStream() {
        return tokenStream;
    }

    @Override
    public ParseTree getParseTree() {
        return parseTree;
    }
}
