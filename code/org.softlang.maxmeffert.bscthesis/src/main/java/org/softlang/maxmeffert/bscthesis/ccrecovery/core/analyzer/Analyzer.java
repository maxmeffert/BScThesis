package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.ILanguages;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

import java.io.File;
import java.util.List;

public class Analyzer implements IAnalyzer {

    private final ILanguages languages;
    private final IFragmentKBFactory fragmentKBFactory;
    private final List<ICorrespondenceDefinition> correspondenceDefinitions;

    @Inject
    public Analyzer(ILanguages languages, IFragmentKBFactory fragmentKBFactory, List<ICorrespondenceDefinition> correspondenceDefinitions) {
        this.languages = languages;
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

        ITree<ITextSource> textSourceTree = languages.getJava8().getParser().parse(string1);

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
