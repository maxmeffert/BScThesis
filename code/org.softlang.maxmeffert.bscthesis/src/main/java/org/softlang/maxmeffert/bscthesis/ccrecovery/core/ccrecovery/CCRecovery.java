package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrLexerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerFactory;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final IParserFactory parserFactory;
    private final ISimilarityAnalyzerFactory similarityAnalyzerFactory;

    @Inject
    public CCRecovery(IParserFactory parserFactory, ISimilarityAnalyzerFactory similarityAnalyzerFactory) {
        this.parserFactory = parserFactory;
        this.similarityAnalyzerFactory = similarityAnalyzerFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> IParser getParser(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentASTBuildingListener fragmentBuildingListener) {
        return parserFactory.newParser(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory, fragmentBuildingListener);
    }

    @Override
    public ISimilarityAnalyzer getSimilarityAnalyzer() {
        return similarityAnalyzerFactory.newSimilarityAnalyzer();
    }


}
