package org.softlang.maxmeffert.bscthesis.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerFactory;

public class AnalyzerFactory implements IAnalyzerFactory {

    private final IAntlrParsingConfigurations antlrParsingConfigurations;
    private final IParseTreeConverter parseTreeConverter;
    private final ITreeWalkerFactory treeWalkerFactory;
    private final IFragmentKBFactory fragmentKBFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public AnalyzerFactory(IAntlrParsingConfigurations antlrParsingConfigurations, IParseTreeConverter parseTreeConverter, ITreeWalkerFactory treeWalkerFactory, IFragmentKBFactory fragmentKBFactory, ICollectionFactory collectionFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.parseTreeConverter = parseTreeConverter;
        this.treeWalkerFactory = treeWalkerFactory;
        this.fragmentKBFactory = fragmentKBFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public IAnalyzer newAnalyzer() {
        return new Analyzer(antlrParsingConfigurations, parseTreeConverter, treeWalkerFactory, fragmentKBFactory, collectionFactory.newList());
    }
}
