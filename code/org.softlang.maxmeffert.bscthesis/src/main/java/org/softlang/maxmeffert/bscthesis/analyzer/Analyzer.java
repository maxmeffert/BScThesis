package org.softlang.maxmeffert.bscthesis.analyzer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalker;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerListener;

import java.io.File;
import java.util.Collection;

public class Analyzer implements IAnalyzer {

    private final IAntlrParsingConfigurations antlrParsingConfigurations;
    private final IParseTreeConverter parseTreeConverter;
    private final ITreeWalkerFactory treeWalkerFactory;

    private final Collection<ICorrespondenceDefinition> correspondenceDefinitions = Lists.newLinkedList();

    @Inject
    public Analyzer(IAntlrParsingConfigurations antlrParsingConfigurations, IParseTreeConverter parseTreeConverter, ITreeWalkerFactory treeWalkerFactory) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.parseTreeConverter = parseTreeConverter;
        this.treeWalkerFactory = treeWalkerFactory;
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

        ITree<ITextSource> textSourceTree = parseTreeConverter.toTextSourceTree(antlrParsingResult);

        ITreeWalker<ITextSource> treeWalker = treeWalkerFactory.newTreeWalker();
        treeWalker.walk(textSourceTree, new ITreeWalkerListener<ITextSource>() {
            @Override
            public void enter(ITree<ITextSource> tree) {
                System.out.println(tree.getValue());
            }

            @Override
            public void exit(ITree<ITextSource> tree) {

            }
        });
    }
}
