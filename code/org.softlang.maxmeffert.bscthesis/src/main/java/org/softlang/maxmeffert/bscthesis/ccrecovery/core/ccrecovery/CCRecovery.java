package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer.ICCAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondence;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinitionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerStrategy;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.inputstreams.IInputStreamFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final IInputStreamFactory inputStreamFactory;
    private final ICCAnalyzerFactory ccAnalyzerFactory;
    private final ILanguageFactory languageFactory;
    private final IParserFactory parserFactory;
    private final ICorrespondenceDefinitionFactory correspondenceDefinitionFactory;
    private final ISimilarityAnalyzerFactory similarityAnalyzerFactory;

    @Inject
    public CCRecovery(IInputStreamFactory inputStreamFactory, ICCAnalyzerFactory analyzerFactory, ILanguageFactory languageFactory, IParserFactory parserFactory, ICorrespondenceDefinitionFactory correspondenceDefinitionFactory, ISimilarityAnalyzerFactory similarityAnalyzerFactory) {
        this.inputStreamFactory = inputStreamFactory;
        this.ccAnalyzerFactory = analyzerFactory;
        this.languageFactory = languageFactory;
        this.parserFactory = parserFactory;
        this.correspondenceDefinitionFactory = correspondenceDefinitionFactory;
        this.similarityAnalyzerFactory = similarityAnalyzerFactory;
    }

    @Override
    public InputStream getInputStream(String string) {
        return inputStreamFactory.newInputStream(string);
    }

    @Override
    public InputStream getInputStream(File file) throws IOException {
        return inputStreamFactory.newInputStream(file);
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
    public ISimilarity analyzeSimilarities(IFragment fragment1, IFragment fragment2, ISimilarityAnalyzerStrategy similarityAnalyzerStrategy) {
        ISimilarityAnalyzer similarityAnalyzer = similarityAnalyzerFactory.newSimilarityAnalyzer(similarityAnalyzerStrategy);
        return similarityAnalyzer.analyze(fragment1, fragment2);
    }

    @Override
    public ICorrespondenceDefinition defineCorrespondence(ILanguage language1, ILanguage language2, ISimilarity similarity) {
        return correspondenceDefinitionFactory.newCorrespondenceDefinition(language1,language2, similarity);
    }


    @Override
    public Set<ICorrespondence> findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws Exception {
        return ccAnalyzerFactory.newCCAnalyzer().findCorrespondences(correspondenceDefinition, artifact1, artifact2);
    }

    @Override
    public Set<ICorrespondence> findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws Exception {
        return ccAnalyzerFactory.newCCAnalyzer().findCorrespondences(correspondenceDefinition, artifact1, artifact2);
    }
}
