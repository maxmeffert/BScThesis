package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrLexerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentASTAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentASTAnalyzerFactory;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final IParserFactory parserFactory;
    private final IFragmentASTAnalyzerFactory similarityAnalyzerFactory;
    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCRecovery(IParserFactory parserFactory, IFragmentASTAnalyzerFactory similarityAnalyzerFactory, ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.parserFactory = parserFactory;
        this.similarityAnalyzerFactory = similarityAnalyzerFactory;
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> IParser getParser(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentASTBuildingListener fragmentBuildingListener) {
        return parserFactory.newParser(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory, fragmentBuildingListener);
    }

    @Override
    public IFragmentASTAnalyzer getFragmentASTAnalyzer() {
        return similarityAnalyzerFactory.newFragmentASTAnalyzer();
    }

    @Override
    public ICorrespondenceAnalyzer getCorrespondenceAnalyzer() {
        return correspondenceAnalyzerFactory.newCorrespondenceAnalyzer();
    }


}
