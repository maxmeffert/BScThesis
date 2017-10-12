package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.ILanguages;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

public class AnalyzerFactory implements IAnalyzerFactory {

    private final ILanguages antlrParsingConfigurations;
    private final IParserFactory parserFactory;
    private final IParseTreeConverter parseTreeConverter;
    private final ITreeWalkerFactory treeWalkerFactory;
    private final IFragmentKBFactory fragmentKBFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public AnalyzerFactory(ILanguages antlrParsingConfigurations, IParserFactory parserFactory, IParseTreeConverter parseTreeConverter, ITreeWalkerFactory treeWalkerFactory, IFragmentKBFactory fragmentKBFactory, ICollectionFactory collectionFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.parserFactory = parserFactory;
        this.parseTreeConverter = parseTreeConverter;
        this.treeWalkerFactory = treeWalkerFactory;
        this.fragmentKBFactory = fragmentKBFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public IAnalyzer newAnalyzer() {
        return new Analyzer(antlrParsingConfigurations, fragmentKBFactory, collectionFactory.newList());
    }
}
