package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrParsingResult implements IAntlrParsingResult {

    private final CharStream charStream;
    private final TokenStream tokenStream;
    private final ParseTree parseTree;

    public AntlrParsingResult(CharStream charStream, TokenStream tokenStream, ParseTree parseTree) {
        this.charStream = charStream;
        this.tokenStream = tokenStream;
        this.parseTree = parseTree;
    }

    @Override
    public CharStream getCharStream() {
        return charStream;
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
