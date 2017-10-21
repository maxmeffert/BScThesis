package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer.ICCAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinitionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.inputstreams.IInputStreamFactory;

import java.io.IOException;
import java.io.InputStream;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final ILanguageFactory languageFactory;
    private final IParserFactory parserFactory;
    private final ISimilarityAnalyzerFactory similarityAnalyzerFactory;

    @Inject
    public CCRecovery(ILanguageFactory languageFactory, IParserFactory parserFactory, ISimilarityAnalyzerFactory similarityAnalyzerFactory) {
        this.languageFactory = languageFactory;
        this.parserFactory = parserFactory;
        this.similarityAnalyzerFactory = similarityAnalyzerFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> ILanguage defineLanguage(String name, IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentBuildingListener fragmentBuildingListener) {
        IParser parser = parserFactory.newParser(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory, fragmentBuildingListener);
        return languageFactory.newLanguage(name, parser);
    }

    @Override
    public IFragment getFragmentAST(ILanguage language, InputStream inputStream) throws IOException, ParserException {
        return language.getParser().parse(inputStream);
    }

    @Override
    public ISimilarityAnalyzer getSimilarityAnalyzer() {
        return similarityAnalyzerFactory.newSimilarityAnalyzer();
    }


}
