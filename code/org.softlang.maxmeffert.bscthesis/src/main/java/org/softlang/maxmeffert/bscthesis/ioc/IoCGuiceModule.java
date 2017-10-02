package org.softlang.maxmeffert.bscthesis.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.AntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.analyzer.AnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.analyzer.IAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.antlr.*;
import org.softlang.maxmeffert.bscthesis.artifacts.ArtifactFactory;
import org.softlang.maxmeffert.bscthesis.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.utils.*;
import org.softlang.maxmeffert.bscthesis.correspondences.CorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.CorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.graphs.*;
import org.softlang.maxmeffert.bscthesis.graphs.GraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.IGraphWalkerFactory;
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

public class IoCGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        configureAnalyzer();
        configureAntlr();
        configureArtifacts();
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
        configureUtils();
    }

    private void configureAnalyzer() {
        bind(IAnalyzerFactory.class).to(AnalyzerFactory.class);
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

        bind(IGraphIteratorFactory.class).to(GraphIteratorFactory.class);
        bind(IGraphWalkFactory.class).to(GraphWalkFactory.class);
        bind(IGraphWalkerFactory.class).to(GraphWalkerFactory.class);

        bind(IGraphBuilders.class).to(GraphBuilders.class);
        bind(IGraphClosures.class).to(GraphClosures.class);
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

    private void configureUtils() {
        bind(ICollectionFactory.class).to(CollectionFactory.class);
        bind(IStringUtils.class).to(StringUtils.class);
        bind(IIterableUtils.class).to(IterableUtils.class);
        bind(IComparableUtils.class).to(ComparableUtils.class);
    }

}
