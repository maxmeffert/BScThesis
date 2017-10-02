package org.softlang.maxmeffert.bscthesis.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.core.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.core.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.core.utils.ICollectionFactory;

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
