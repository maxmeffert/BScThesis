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
import org.softlang.maxmeffert.bscthesis.correspondences.CorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.CorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceBuilderFactory;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.graphs.DiGraphBuilderFactory;
import org.softlang.maxmeffert.bscthesis.graphs.DiGraphNodeBuilderFactory;
import org.softlang.maxmeffert.bscthesis.graphs.IDiGraphBuilderFactory;
import org.softlang.maxmeffert.bscthesis.graphs.IDiGraphNodeBuilderFactory;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.GraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeNormalizerFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.SimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.SimpleParseTreeNormalizerFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.TextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.texts.intervals.TextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.texts.providers.ITextProviderFactory;
import org.softlang.maxmeffert.bscthesis.texts.providers.TextProviderFactory;
import org.softlang.maxmeffert.bscthesis.texts.sources.*;
import org.softlang.maxmeffert.bscthesis.graphs.trees.*;
import org.softlang.maxmeffert.bscthesis.tuples.ITuples;
import org.softlang.maxmeffert.bscthesis.tuples.Tuples;

public class IoCGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ICollectionFactory.class).to(CollectionFactory.class);

        bind(IDiGraphBuilderFactory.class).to(DiGraphBuilderFactory.class);
        bind(IDiGraphNodeBuilderFactory.class).to(DiGraphNodeBuilderFactory.class);
        bind(IGraphWalkerFactory.class).to(GraphWalkerFactory.class);

        bind(ITuples.class).to(Tuples.class);

        bind(IAntlrCharStreamFactory.class).to(AntlrCharStreamFactory.class);
        bind(IAntlrIntervalFactory.class).to(AntlrIntervalFactory.class);
        bind(IAntlrTokenStreamFactory.class).to(AntlrCommonTokenStreamFactory.class);
        bind(IAntlrConfigurationBuilderFactory.class).to(AntlrConfigurationBuilderFactory.class);
        bind(IAntlrConfigurationFactory.class).to(AntlrConfigurationFactory.class);

        bind(IAntlrParsingConfigurations.class).to(AntlrParsingConfigurations.class);

        bind(ITextIntervalFactory.class).to(TextIntervalFactory.class);
        bind(ITextIntervalConverterFactory.class).to(TextIntervalConverterFactory.class);
        bind(ITextProviderFactory.class).to(TextProviderFactory.class);
        bind(ITextSourceBuilderFactory.class).to(TextSourceBuilderFactory.class);
        bind(ITextSourceFactory.class).to(TextSourceFactory.class);

        bind(ITreeFactory.class).to(TreeFactory.class);
        bind(ITreeWalkerFactory.class).to(TreeWalkerFactory.class);
        bind(ITreeMapperFactory.class).to(TreeMapperFactory.class);

        bind(ISimpleParseTreeNormalizerFactory.class).to(SimpleParseTreeNormalizerFactory.class);
        bind(ISimpleParseTreeFactory.class).to(SimpleParseTreeFactory.class);

        bind(IArtifactFactory.class).to(ArtifactFactory.class);

        bind(IAnalyzer.class).to(Analyzer.class);

        bind(ICorrespondenceBuilderFactory.class).to(CorrespondenceBuilderFactory.class);
        bind(ICorrespondenceFactory.class).to(CorrespondenceFactory.class);
    }
}
