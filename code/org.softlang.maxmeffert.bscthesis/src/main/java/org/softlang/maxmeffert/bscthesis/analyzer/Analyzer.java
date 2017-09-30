package org.softlang.maxmeffert.bscthesis.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalker;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalkerListener;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;

import java.io.File;

public class Analyzer implements IAnalyzer {

    private final IAntlrParsingConfigurations antlrParsingConfigurations;
    private final ISimpleParseTreeFactory simpleParseTreeFactory;
    private final ITreeWalkerFactory treeWalkerFactory;

    @Inject
    public Analyzer(IAntlrParsingConfigurations antlrParsingConfigurations, ISimpleParseTreeFactory simpleParseTreeFactory, ITreeWalkerFactory treeWalkerFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.simpleParseTreeFactory = simpleParseTreeFactory;
        this.treeWalkerFactory = treeWalkerFactory;
    }

    @Override
    public void findCorrespondences(File file1, File file2) {

    }

    @Override
    public void findCorrespondences(String string1, String string2) {
        IAntlrParsingConfiguration antlrParsingConfiguration = antlrParsingConfigurations.newJava8Configuration();
        IAntlrParsingResult antlrParsingResult = antlrParsingConfiguration.parse(string1);
        ITree<ITextSource> simpleParseTree = simpleParseTreeFactory.newSimpleParseTree(antlrParsingResult);
        ITreeWalker<ITextSource> treeWalker = treeWalkerFactory.newTreeWalker();
        treeWalker.walk(simpleParseTree, new ITreeWalkerListener<ITextSource>() {
            @Override
            public void enter(ITree<ITextSource> tree) {
                System.out.println(tree);
            }

            @Override
            public void exit(ITree<ITextSource> tree) {

            }
        });
    }
}
