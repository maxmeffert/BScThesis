package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.IAntlrParsingConfigurations;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

import java.io.File;
import java.util.List;

public class Analyzer implements IAnalyzer {

    private final IAntlrParsingConfigurations antlrParsingConfigurations;
    private final IParseTreeConverter parseTreeConverter;
    private final ITreeWalkerFactory treeWalkerFactory;
    private final IFragmentKBFactory fragmentKBFactory;
    private final List<ICorrespondenceDefinition> correspondenceDefinitions;

    @Inject
    public Analyzer(IAntlrParsingConfigurations antlrParsingConfigurations, IParseTreeConverter parseTreeConverter, ITreeWalkerFactory treeWalkerFactory, IFragmentKBFactory fragmentKBFactory, List<ICorrespondenceDefinition> correspondenceDefinitions) {
        this.antlrParsingConfigurations = antlrParsingConfigurations;
        this.parseTreeConverter = parseTreeConverter;
        this.treeWalkerFactory = treeWalkerFactory;
        this.fragmentKBFactory = fragmentKBFactory;
        this.correspondenceDefinitions = correspondenceDefinitions;
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

        IFragmentKB fragmentKB = fragmentKBFactory.newFragmentKB(textSourceTree);

        for (IFragment fragment : fragmentKB.getFragments()) {
            System.out.println(fragment + "\t\t\t\t\t" + fragmentKB.getFragmentsOf(fragment));
        }

//        ITreeWalker<ITextSource> treeWalker = treeWalkerFactory.newTreeWalker();
//        treeWalker.walk(textSourceTree, new ITreeWalkerListener<ITextSource>() {
//            @Override
//            public void enter(ITree<ITextSource> tree) {
//                System.out.println(tree.getValue());
//            }
//
//            @Override
//            public void exit(ITree<ITextSource> tree) {
//
//            }
//        });
    }
}
