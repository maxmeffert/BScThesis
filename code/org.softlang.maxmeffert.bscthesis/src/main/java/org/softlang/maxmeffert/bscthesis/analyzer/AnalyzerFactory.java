package org.softlang.maxmeffert.bscthesis.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerFactory;

public class AnalyzerFactory implements IAnalyzerFactory {

    private final IAntlrParsingConfigurations antlrParsingConfigurations;
    private final IParseTreeConverter parseTreeConverter;
    private final ITreeWalkerFactory treeWalkerFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public AnalyzerFactory(IAntlrParsingConfigurations antlrParsingConfigurations, IParseTreeConverter parseTreeConverter, ITreeWalkerFactory treeWalkerFactory, ICollectionFactory collectionFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.parseTreeConverter = parseTreeConverter;
        this.treeWalkerFactory = treeWalkerFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public IAnalyzer newAnalyzer() {
        return new Analyzer(antlrParsingConfigurations, parseTreeConverter, treeWalkerFactory, collectionFactory.newList());
    }
}
