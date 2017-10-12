package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

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

    @Override
    public IAntlrParsingResult parse(InputStream inputStream) throws IOException {
        CharStream charStream = antlrCharStreamFactory.newCharStream(inputStream);
        Lexer lexer = antlrLexerFactory.newLexer(charStream);
        TokenStream tokenStream = antlrTokenStreamFactory.newTokenStream(lexer);
        Parser parser = antlrParserFactory.newParser(tokenStream);
        ParseTree parseTree = antlrParseTreeFactory.newParseTree(parser);
        return new AntlrParsingResult(tokenStream, parseTree);
    }

}
