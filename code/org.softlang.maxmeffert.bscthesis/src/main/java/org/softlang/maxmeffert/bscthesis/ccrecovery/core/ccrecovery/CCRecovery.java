package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrLexerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers.IFragmentReader;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers.IFragmentReaderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriConverterFactory;
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
    private final IFragmentUriConverterFactory fragmentUriConverterFactory;
    private final IFragmentReaderFactory fragmentReaderFactory;
    private final IFragmentKBFactory fragmentKBFactory;
    private final IFragmentAnalyzerFactory fragmentAnalyzerFactory;
    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCRecovery(IParserFactory parserFactory, IFragmentUriConverterFactory fragmentUriConverterFactory, IFragmentReaderFactory fragmentReaderFactory, IFragmentKBFactory fragmentKBFactory, IFragmentAnalyzerFactory fragmentAnalyzerFactory, ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.parserFactory = parserFactory;
        this.fragmentUriConverterFactory = fragmentUriConverterFactory;
        this.fragmentReaderFactory = fragmentReaderFactory;
        this.fragmentKBFactory = fragmentKBFactory;
        this.fragmentAnalyzerFactory = fragmentAnalyzerFactory;
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> IParser getParser(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentBuildingListener fragmentBuildingListener) {
        return parserFactory.newParser(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory, fragmentBuildingListener);
    }

    @Override
    public IFragmentUriConverter getFragmentUriConverter() {
        return fragmentUriConverterFactory.newFragmentUriConverter();
    }

    @Override
    public IFragmentReader getFragmentReader() {
        return fragmentReaderFactory.newFragmentReader();
    }

    @Override
    public IFragmentKB getFragmentKB(IFragment fragment) {
        return fragmentKBFactory.newFragmentKB(fragment);
    }

    @Override
    public IFragmentAnalyzer getFragmentAnalyzer() {
        return fragmentAnalyzerFactory.newFragmentAnalyzer();
    }

}
