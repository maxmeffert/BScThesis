package org.softlang.maxmeffert.bscthesis.analyzer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.graphs.oldtrees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalker;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalkerListener;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTree;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

import java.io.File;
import java.util.Collection;

public class Analyzer implements IAnalyzer {

    private final IAntlrParsingConfigurations antlrParsingConfigurations;
    private final ISimpleParseTreeFactory simpleParseTreeFactory;
    private final ITreeWalkerFactory treeWalkerFactory;
    private final IGraphWalkerFactory graphWalkerFactory;

    private final Collection<ICorrespondenceDefinition> correspondenceDefinitions = Lists.newLinkedList();

    @Inject
    public Analyzer(IAntlrParsingConfigurations antlrParsingConfigurations, ISimpleParseTreeFactory simpleParseTreeFactory, ITreeWalkerFactory treeWalkerFactory, IGraphWalkerFactory graphWalkerFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.simpleParseTreeFactory = simpleParseTreeFactory;
        this.treeWalkerFactory = treeWalkerFactory;
        this.graphWalkerFactory = graphWalkerFactory;
    }

    @Override
    public void addCorrespondenceDefinition(ICorrespondenceDefinition correspondenceDefinition) {
        correspondenceDefinitions.add(correspondenceDefinition);
    }

    @Override
    public void findCorrespondences(File file1, File file2) {

    }

    @Override
    public void findCorrespondences(String string1, String string2) {
        IAntlrParsingConfiguration antlrParsingConfiguration = antlrParsingConfigurations.newJava8Configuration();
        IAntlrParsingResult antlrParsingResult = antlrParsingConfiguration.parse(string1);
        ISimpleParseTree simpleParseTree = simpleParseTreeFactory.newSimpleParseTree2(antlrParsingResult);
        IGraphWalker<ITextSource> graphWalker = graphWalkerFactory.newGraphWalker();
        graphWalker.walk(simpleParseTree, simpleParseTree.getRoot(), new IGraphWalkerListener<ITextSource>() {

            @Override
            public void enter(ITextSource iTextSource) {
                System.out.println(iTextSource);
            }

            @Override
            public void exit(ITextSource iTextSource) {

            }
        });
//        ITree<ITextSource> simpleParseTree = simpleParseTreeFactory.newSimpleParseTree(antlrParsingResult);
//        ITreeWalker<ITextSource> treeWalker = treeWalkerFactory.newTreeWalker();
//        treeWalker.walk(simpleParseTree, new ITreeWalkerListener<ITextSource>() {
//            @Override
//            public void enter(ITree<ITextSource> tree) {
//                System.out.println(tree);
//            }
//
//            @Override
//            public void exit(ITree<ITextSource> tree) {
//
//            }
//        });
    }
}
