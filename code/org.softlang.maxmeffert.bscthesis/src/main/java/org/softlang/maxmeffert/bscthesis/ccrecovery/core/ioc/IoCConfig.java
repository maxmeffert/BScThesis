package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.CorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.CorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.FragmentKBBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.FragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators.GraphIterators;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators.IGraphIterators;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers.GraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers.IGraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereologyBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.MereologyBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserResultFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserResultFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.SimilaritiyFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.SimilarityAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.CollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.comparables.ComparableUtils;
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
        configureAntlr();
        configureCCRecovery();
        configureConformances();
        configureCorrespondences();
        configureFragments();
        configureGraphs();
        configureMereologies();
        configureParsers();
        configureUtils();
        configureSimilarities();
    }

    private void configureSimilarities() {
        bind(ISimilarityFactory.class).to(SimilaritiyFactory.class);
        bind(ISimilarityAnalyzerFactory.class).to(SimilarityAnalyzerFactory.class);
    }

    private void configureAntlr() {
        bind(IAntlrCharStreamFactory.class).to(AntlrCharStreamFactory.class);
        bind(IAntlrIntervalFactory.class).to(AntlrIntervalFactory.class);
        bind(IAntlrTokenStreamFactory.class).to(AntlrCommonTokenStreamFactory.class);
        bind(IAntlrParseTreeWalkerFactory.class).to(AntlrParseTreeWalkerFactory.class);
        bind(IAntlrParseTreeErrorNodeListenerFactory.class).to(AntlrParseTreeErrorNodeListerFactory.class);
    }

    private void configureCCRecovery() {
        bind(ICCRecovery.class).to(CCRecovery.class);
    }

    private void configureConformances() {

    }

    private void configureCorrespondences() {
        bind(ICorrespondenceAnalyzerFactory.class).to(CorrespondenceAnalyzerFactory.class);
        bind(ICorrespondenceFactory.class).to(CorrespondenceFactory.class);
    }

    private void configureFragments() {
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

    private void configureMereologies() {
        bind(IMereologyBuilderFactory.class).to(MereologyBuilderFactory.class);
    }

    private void configureParsers() {
        bind(IParserResultFactory.class).to(ParserResultFactory.class);
        bind(IParserFactory.class).to(ParserFactory.class);
    }


    private void configureUtils() {
        bind(ICollectionFactory.class).to(CollectionFactory.class);
        bind(IStringUtils.class).to(StringUtils.class);
        bind(IIterableUtils.class).to(IterableUtils.class);
        bind(IComparableUtils.class).to(ComparableUtils.class);
        bind(IViewFactory.class).to(ViewFactory.class);
    }

}
