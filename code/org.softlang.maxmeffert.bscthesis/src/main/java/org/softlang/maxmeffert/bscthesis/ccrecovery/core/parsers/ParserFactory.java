package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTBuildingListener;

public class ParserFactory implements IParserFactory {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParseTreeWalkerFactory antlrParseTreeWalkerFactory;
    private final IAntlrParseTreeErrorNodeListenerFactory antlreParseTreeErrorNodeListenerFactory;
    private final IParserResultFactory parserResultFactory;

    @Inject
    public ParserFactory(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParseTreeWalkerFactory antlrParseTreeWalkerFactory, IAntlrParseTreeErrorNodeListenerFactory antlreParseTreeErrorNodeListenerFactory, IParserResultFactory parserResultFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParseTreeWalkerFactory = antlrParseTreeWalkerFactory;
        this.antlreParseTreeErrorNodeListenerFactory = antlreParseTreeErrorNodeListenerFactory;
        this.parserResultFactory = parserResultFactory;
    }


    @Override
    public IParser newParser(IAntlrLexerFactory antlrLexerFactory, IAntlrParserFactory antlrParserFactory, IAntlrParseTreeFactory antlrParseTreeFactory, IFragmentASTBuildingListener fragmentBuildingListener) {
        return new AntlrParser(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory, antlreParseTreeErrorNodeListenerFactory, antlrParseTreeWalkerFactory, fragmentBuildingListener, parserResultFactory);
    }
}
