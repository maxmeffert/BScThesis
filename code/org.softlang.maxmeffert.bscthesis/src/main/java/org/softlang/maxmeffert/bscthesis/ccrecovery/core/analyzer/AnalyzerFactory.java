package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.ILanguages;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

public class AnalyzerFactory implements IAnalyzerFactory {

    private final ILanguages antlrParsingConfigurations;
    private final IArtifactFactory artifactFactory;
    private final IFragmentKBFactory fragmentKBFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public AnalyzerFactory(ILanguages antlrParsingConfigurations, IArtifactFactory artifactFactory, IFragmentKBFactory fragmentKBFactory, ICollectionFactory collectionFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.artifactFactory = artifactFactory;
        this.fragmentKBFactory = fragmentKBFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public IAnalyzer newAnalyzer() {
        return new Analyzer(antlrParsingConfigurations, artifactFactory, fragmentKBFactory, collectionFactory.newList());
    }
}
