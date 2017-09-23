package org.softlang.maxmeffert.bscthesis.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.AntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.antlr.*;
import org.softlang.maxmeffert.bscthesis.artifacts.ArtifactFactory;
import org.softlang.maxmeffert.bscthesis.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeNormalizerFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.SimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.SimpleParseTreeNormalizerFactory;
import org.softlang.maxmeffert.bscthesis.text.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.text.intervals.ITextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.text.intervals.TextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.text.intervals.TextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.text.providers.ITextProviderFactory;
import org.softlang.maxmeffert.bscthesis.text.providers.TextProviderFactory;
import org.softlang.maxmeffert.bscthesis.text.sources.*;
import org.softlang.maxmeffert.bscthesis.graphs.trees.*;
import org.softlang.maxmeffert.bscthesis.tuples.ITupleFactory;
import org.softlang.maxmeffert.bscthesis.tuples.TupleFactory;

public class IoCGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ITupleFactory.class).to(TupleFactory.class);

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
    }
}
