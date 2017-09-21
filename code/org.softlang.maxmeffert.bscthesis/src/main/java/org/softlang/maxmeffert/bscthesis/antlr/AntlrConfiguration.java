package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrConfiguration implements IAntlrConfiguration {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrLexerFactory antlrLexerFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParseTreeFactory antlrParseTreeFactory;

    public AntlrConfiguration(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrLexerFactory antlrLexerFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParseTreeFactory antlrParseTreeFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrLexerFactory = antlrLexerFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParseTreeFactory = antlrParseTreeFactory;
    }

    @Override
    public IAntlrParsingResult parse(String string) {
        CharStream charStream = antlrCharStreamFactory.newCharStreamFromString(string);
        Lexer lexer = antlrLexerFactory.newLexer(charStream);
        TokenStream tokenStream = antlrTokenStreamFactory.newTokenStream(lexer);
        ParseTree parseTree = antlrParseTreeFactory.newParseTree(tokenStream);
        return new AntlrParsingResult(tokenStream, parseTree);
    }
}
