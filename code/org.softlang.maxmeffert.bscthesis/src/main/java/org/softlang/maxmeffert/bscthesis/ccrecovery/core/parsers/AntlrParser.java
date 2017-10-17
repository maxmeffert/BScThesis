package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentBuildingListener;

import java.io.IOException;
import java.io.InputStream;

public class AntlrParser implements IParser {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrLexerFactory antlrLexerFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParserFactory antlrParserFactory;
    private final IAntlrParseTreeFactory antlrParseTreeFactory;
    private final IAntlrParseTreeWalkerFactory antlrParseTreeWalkerFactory;
    private final IFragmentBuildingListener fragmentBuildingListener;
    private final IParserResultFactory parserResultFactory;

    public AntlrParser(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrLexerFactory antlrLexerFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParserFactory antlrParserFactory, IAntlrParseTreeFactory antlrParseTreeFactory, IAntlrParseTreeWalkerFactory antlrParseTreeWalkerFactory, IFragmentBuildingListener fragmentBuildingListener, IParserResultFactory parserResultFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrLexerFactory = antlrLexerFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParserFactory = antlrParserFactory;
        this.antlrParseTreeFactory = antlrParseTreeFactory;
        this.antlrParseTreeWalkerFactory = antlrParseTreeWalkerFactory;
        this.fragmentBuildingListener = fragmentBuildingListener;
        this.parserResultFactory = parserResultFactory;
    }


    @Override
    public IFragment parse(InputStream inputStream) throws IOException {
        CharStream charStream = antlrCharStreamFactory.newCharStream(inputStream);
        Lexer lexer = antlrLexerFactory.newLexer(charStream);
        TokenStream tokenStream = antlrTokenStreamFactory.newTokenStream(lexer);
        Parser parser = antlrParserFactory.newParser(tokenStream);
        ParseTree parseTree = antlrParseTreeFactory.newParseTree(parser);
        ParseTreeWalker parseTreeWalker = antlrParseTreeWalkerFactory.newParseTreeWalker();
        parseTreeWalker.walk(fragmentBuildingListener, parseTree);
        return fragmentBuildingListener.getFragment();
    }

    @Override
    public IParserResult tryParse(InputStream inputStream) {
        try {
            return parserResultFactory.accepted(parse(inputStream));
        } catch (Exception exception) {
            return parserResultFactory.notAccepted(exception);
        }
    }

}
