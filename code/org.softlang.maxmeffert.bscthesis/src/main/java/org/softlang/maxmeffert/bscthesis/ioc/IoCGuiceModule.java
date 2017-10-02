package org.softlang.maxmeffert.bscthesis.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.AntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.analyzer.Analyzer;
import org.softlang.maxmeffert.bscthesis.analyzer.IAnalyzer;
import org.softlang.maxmeffert.bscthesis.antlr.*;
import org.softlang.maxmeffert.bscthesis.artifacts.ArtifactFactory;
import org.softlang.maxmeffert.bscthesis.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.collections.CollectionFactory;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.collections.ITuples;
import org.softlang.maxmeffert.bscthesis.collections.Tuples;
import org.softlang.maxmeffert.bscthesis.correspondences.CorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.CorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.graphs.*;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.GraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.parsetrees.*;
import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.TextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.TextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.texts.providers.ITextProviderFactory;
import org.softlang.maxmeffert.bscthesis.texts.providers.TextProviderFactory;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSourceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSourceFactory;
import org.softlang.maxmeffert.bscthesis.texts.sources.TextSourceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.texts.sources.TextSourceFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.trees.TreeFactory;
import org.softlang.maxmeffert.bscthesis.trees.TreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.utils.IStringUtils;
import org.softlang.maxmeffert.bscthesis.utils.StringUtils;

public class IoCGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        configureAnalyzer();
        configureAntlr();
        configureArtifacts();
        configureCollections();
        configureConformances();
        configureCorrespondences();
        configureFragments();
        configureGraphs();
        configureLanguages();
        configureMereologies();
        configureRelations();
        configureParseTrees();
        configureTexts();
        configureTrees();
        configureTuples();
        configureUtils();
    }

    private void configureAnalyzer() {
        bind(IAnalyzer.class).to(Analyzer.class);
    }

    private void configureAntlr() {
        bind(IAntlrCharStreamFactory.class).to(AntlrCharStreamFactory.class);
        bind(IAntlrIntervalFactory.class).to(AntlrIntervalFactory.class);
        bind(IAntlrTokenStreamFactory.class).to(AntlrCommonTokenStreamFactory.class);
        bind(IAntlrConfigurationBuilderFactory.class).to(AntlrConfigurationBuilderFactory.class);
        bind(IAntlrConfigurationFactory.class).to(AntlrConfigurationFactory.class);

        bind(IAntlrParsingConfigurations.class).to(AntlrParsingConfigurations.class);
    }

    private void configureArtifacts() {
        bind(IArtifactFactory.class).to(ArtifactFactory.class);
    }

    private void configureCollections() {
        bind(ICollectionFactory.class).to(CollectionFactory.class);
    }

    private void configureConformances() {

    }

    private void configureCorrespondences() {
        bind(ICorrespondenceBuilderFactory.class).to(CorrespondenceBuilderFactory.class);
        bind(ICorrespondenceFactory.class).to(CorrespondenceFactory.class);
    }

    private void configureFragments() {

    }

    private void configureGraphs() {
        bind(IGraphBuilderFactory.class).to(GraphBuilderFactory.class);
        bind(IGraphNodeBuilderFactory.class).to(GraphNodeBuilderFactory.class);

        bind(IDiGraphBuilderFactory.class).to(DiGraphBuilderFactory.class);
        bind(IDiGraphNodeBuilderFactory.class).to(DiGraphNodeBuilderFactory.class);

        bind(IGraphWalkerFactory.class).to(GraphWalkerFactory.class);
    }

    private void configureLanguages() {

    }

    private void configureMereologies() {

    }

    private void configureRelations() {

    }

    private void configureParseTrees() {
        bind(ITextSourceTreeNormalizerFactory.class).to(TextSourceTreeNormalizerFactory.class);
        bind(IParseTreeConverter.class).to(ParseTreeConverter.class);
    }

    private void configureTexts() {
        bind(ITextIntervalFactory.class).to(TextIntervalFactory.class);
        bind(ITextIntervalConverterFactory.class).to(TextIntervalConverterFactory.class);
        bind(ITextProviderFactory.class).to(TextProviderFactory.class);
        bind(ITextSourceBuilderFactory.class).to(TextSourceBuilderFactory.class);
        bind(ITextSourceFactory.class).to(TextSourceFactory.class);
    }

    private void configureTrees() {
        bind(ITreeFactory.class).to(TreeFactory.class);
        bind(ITreeWalkerFactory.class).to(TreeWalkerFactory.class);
    }

    private void configureTuples() {
        bind(ITuples.class).to(Tuples.class);
    }

    private void configureUtils() {
        bind(IStringUtils.class).to(StringUtils.class);
    }

}
