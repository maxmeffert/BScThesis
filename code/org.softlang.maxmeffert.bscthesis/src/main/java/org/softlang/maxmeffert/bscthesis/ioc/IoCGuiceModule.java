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
import org.softlang.maxmeffert.bscthesis.textsources.*;
import org.softlang.maxmeffert.bscthesis.trees.*;

public class IoCGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
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