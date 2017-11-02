package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrLexerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzerFactory;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final IParserFactory parserFactory;
    private final IFragmentUriFactory fragmentUriFactory;
    private final IFragmentAnalyzerFactory similarityAnalyzerFactory;
    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCRecovery(IParserFactory parserFactory, IFragmentUriFactory fragmentUriFactory, IFragmentAnalyzerFactory similarityAnalyzerFactory, ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.parserFactory = parserFactory;
        this.fragmentUriFactory = fragmentUriFactory;
        this.similarityAnalyzerFactory = similarityAnalyzerFactory;
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> IParser getParser(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentBuildingListener fragmentBuildingListener) {
        return parserFactory.newParser(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory, fragmentBuildingListener);
    }

    @Override
    public IFragmentUriFactory getFragmentUriFactory() {
        return fragmentUriFactory;
    }

    @Override
    public IFragmentAnalyzer getFragmentASTAnalyzer() {
        return similarityAnalyzerFactory.newFragmentAnalyzer();
    }

    @Override
    public ICorrespondenceAnalyzer getCorrespondenceAnalyzer() {
        return correspondenceAnalyzerFactory.newCorrespondenceAnalyzer();
    }


}
