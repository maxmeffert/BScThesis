package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.ccrecovery.AntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.ccrecovery.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.CorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.TextSourceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.TreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer.AnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer.IAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.ArtifactFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.ITextSourceTreeNormalizerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.ParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.TextSourceTreeNormalizerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators.GraphIterators;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators.IGraphIterators;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers.GraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers.IGraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.CorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.TextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.TextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProviderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.TextProviderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSourceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSourceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.TextSourceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.TreeFactory;

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
        bind(IFragmentFactory.class).to(FragmentFactory.class);
        bind(IFragmentBuilderFactory.class).to(FragmentBuilderFactory.class);
        bind(IFragmentKBFactory.class).to(FragmentKBFactory.class);
        bind(IFragmentKBBuilderFactory.class).to(FragmentKBBuilderFactory.class);
    }

    private void configureGraphs() {
        bind(IGraphBuilderFactory.class).to(GraphBuilderFactory.class);
        bind(IGraphNodeBuilderFactory.class).to(GraphNodeBuilderFactory.class);

        bind(IDiGraphBuilderFactory.class).to(DiGraphBuilderFactory.class);
        bind(IDiGraphNodeBuilderFactory.class).to(DiGraphNodeBuilderFactory.class);

        bind(IGraphBuilders.class).to(GraphBuilders.class);

        bind(IGraphIterators.class).to(GraphIterators.class);

        bind(IGraphWalkerFactory.class).to(GraphWalkerFactory.class);

        bind(IGraphWalkFactory.class).to(GraphWalkFactory.class);
        bind(IDiGraphWalkFactory.class).to(DiGraphWalkFactory.class);
        bind(IGraphWalks.class).to(GraphWalks.class);


        bind(IGraphClosureFactory.class).to(GraphClosureFactory.class);
        bind(IDiGraphClosureFactory.class).to(DiGraphClosureFactory.class);
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
