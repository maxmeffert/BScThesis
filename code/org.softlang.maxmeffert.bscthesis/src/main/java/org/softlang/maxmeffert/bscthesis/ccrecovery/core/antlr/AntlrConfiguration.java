package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class AntlrConfiguration implements IAntlrConfiguration {

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

    private IAntlrParsingResult parse(CharStream charStream) {
        Lexer lexer = antlrLexerFactory.newLexer(charStream);
        TokenStream tokenStream = antlrTokenStreamFactory.newTokenStream(lexer);
        Parser parser = antlrParserFactory.newParser(tokenStream);
        ParseTree parseTree = antlrParseTreeFactory.newParseTree(parser);
        return new AntlrParsingResult(tokenStream, parseTree);
    }

    @Override
    public IAntlrParsingResult parse(String string) {
        return parse(antlrCharStreamFactory.newCharStream(string));
    }

    @Override
    public IAntlrParsingResult parse(File file) throws IOException {
        return parse(antlrCharStreamFactory.newCharStream(file));
    }

    @Override
    public IAntlrParsingResult parse(InputStream inputStream) throws IOException {
        return parse(antlrCharStreamFactory.newCharStream(inputStream));
    }

    @Override
    public IAntlrParsingResult parse(URI uri) throws IOException {
        return parse(antlrCharStreamFactory.newCharStream(uri));
    }

    @Override
    public IAntlrParsingResult parse(URL url) throws IOException {
        return parse(antlrCharStreamFactory.newCharStream(url));
    }
}
