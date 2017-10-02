package org.softlang.maxmeffert.bscthesis.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrConfiguration implements IAntlrParsingConfiguration {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrLexerFactory antlrLexerFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParserFactory antlrParserFactory;
    private final IAntlrParseTreeFactory antlrParseTreeFactory;

    public AntlrConfiguration(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrLexerFactory antlrLexerFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParserFactory antlrParserFactory, IAntlrParseTreeFactory antlrParseTreeFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrLexerFactory = antlrLexerFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParserFactory = antlrParserFactory;
        this.antlrParseTreeFactory = antlrParseTreeFactory;
    }

    @Override
    public IAntlrParsingResult parse(String string) {
        CharStream charStream = antlrCharStreamFactory.newCharStreamFromString(string);
        Lexer lexer = antlrLexerFactory.newLexer(charStream);
        TokenStream tokenStream = antlrTokenStreamFactory.newTokenStream(lexer);
        Parser parser = antlrParserFactory.newParser(tokenStream);
        ParseTree parseTree = antlrParseTreeFactory.newParseTree(parser);
        return new AntlrParsingResult(tokenStream, parseTree);
    }
}
