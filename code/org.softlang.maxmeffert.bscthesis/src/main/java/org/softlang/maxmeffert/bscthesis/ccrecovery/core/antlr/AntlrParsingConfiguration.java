package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;

public class AntlrParsingConfiguration implements IAntlrParsingConfiguration {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrLexerFactory antlrLexerFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParserFactory antlrParserFactory;
    private final IAntlrParseTreeFactory antlrParseTreeFactory;

    public AntlrParsingConfiguration(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrLexerFactory antlrLexerFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParserFactory antlrParserFactory, IAntlrParseTreeFactory antlrParseTreeFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrLexerFactory = antlrLexerFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParserFactory = antlrParserFactory;
        this.antlrParseTreeFactory = antlrParseTreeFactory;
    }

    private CharStream newCharStream(InputStream inputStream) throws IOException {
        return antlrCharStreamFactory.newCharStream(inputStream);
    }

    private Lexer newLexer(CharStream charStream) {
        return antlrLexerFactory.newLexer(charStream);
    }

    private TokenStream newTokenStream(Lexer lexer) {
        return antlrTokenStreamFactory.newTokenStream(lexer);
    }

    private Parser newParser(TokenStream tokenStream) {
        return antlrParserFactory.newParser(tokenStream);
    }

    private ParseTree newParseTree(Parser parser) {
        return antlrParseTreeFactory.newParseTree(parser);
    }

    @Override
    public IAntlrParsingResult parse(InputStream inputStream) throws IOException {
        CharStream charStream = newCharStream(inputStream);
        Lexer lexer = newLexer(charStream);
        TokenStream tokenStream = newTokenStream(lexer);
        Parser parser = newParser(tokenStream);
        ParseTree parseTree = newParseTree(parser);
        return new AntlrParsingResult(tokenStream, parseTree);
    }

}
