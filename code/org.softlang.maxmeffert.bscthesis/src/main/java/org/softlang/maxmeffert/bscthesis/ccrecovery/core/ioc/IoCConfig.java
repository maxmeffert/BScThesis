package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.ccrecovery.Languages;
import org.softlang.maxmeffert.bscthesis.ccrecovery.ILanguages;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.LanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereologyBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.MereologyBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.TextSourceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.TreeWalkerFactory;
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
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.CollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.comparables.ComparableUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.comparables.IComparableUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.iterables.IIterableUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.iterables.IterableUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.strings.IStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.strings.StringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.ViewFactory;

public class IoCConfig extends AbstractModule {
    @Override
    protected void configure() {
        configureAnalyzer();
        configureAntlr();
        configureArtifacts();
        configureCCRecovery();
        configureConformances();
        configureCorrespondences();
        configureFragments();
        configureGraphs();
        configureLanguages();
        configureMereologies();
        configureParsers();
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

        bind(ILanguages.class).to(Languages.class);
    }

    private void configureArtifacts() {
        bind(IArtifactFactory.class).to(ArtifactFactory.class);
    }

    private void configureCCRecovery() {
        bind(ICCRecovery.class).to(CCRecovery.class);
    }

    private void configureConformances() {

    }

    private void configureCorrespondences() {
        bind(ICorrespondenceDefinitionBuilderFactory.class).to(CorrespondenceDefinitionBuilderFactory.class);
        bind(ICorrespondenceBuilderFactory.class).to(CorrespondenceBuilderFactory.class);
        bind(ICorrespondenceFactory.class).to(CorrespondenceFactory.class);
    }

    private void configureFragments() {
        bind(IFragmentFactory.class).to(FragmentFactory.class);
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
        bind(ILanguageFactory.class).to(LanguageFactory.class);
    }

    private void configureMereologies() {
        bind(IMereologyBuilderFactory.class).to(MereologyBuilderFactory.class);
    }

    private void configureParsers() {
        bind(IParserFactory.class).to(ParserFactory.class);
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
        bind(IViewFactory.class).to(ViewFactory.class);
    }

}
