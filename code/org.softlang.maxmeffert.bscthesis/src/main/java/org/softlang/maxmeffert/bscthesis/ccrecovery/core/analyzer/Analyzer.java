package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.ILanguages;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifact;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Analyzer implements IAnalyzer {

    private final ILanguages languages;
    private final IArtifactFactory artifactFactory;
    private final IFragmentKBFactory fragmentKBFactory;
    private final List<ICorrespondenceDefinition> correspondenceDefinitions;

    @Inject
    public Analyzer(ILanguages languages, IArtifactFactory artifactFactory, IFragmentKBFactory fragmentKBFactory, List<ICorrespondenceDefinition> correspondenceDefinitions) {
        this.languages = languages;
        this.artifactFactory = artifactFactory;
        this.fragmentKBFactory = fragmentKBFactory;
        this.correspondenceDefinitions = correspondenceDefinitions;
    }

    @Override
    public void addCorrespondenceDefinition(ICorrespondenceDefinition correspondenceDefinition) {
        correspondenceDefinitions.add(correspondenceDefinition);
    }

    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, IArtifact artifact1, IArtifact artifact2) throws IOException {
        IFragmentKB fragmentKB1 = fragmentKBFactory.newFragmentKB(artifact1);
        IFragmentKB fragmentKB2 = fragmentKBFactory.newFragmentKB(artifact2);
        for(IFragment fragment1 : fragmentKB1.getFragments()) {
            for (IFragment fragment2 : fragmentKB2.getFragments()) {

            }
        }
        for (IFragment fragment : fragmentKB1.getFragments()) {
            System.out.println(fragment + "\t\t\t\t\t" + fragmentKB1.getFragmentsOf(fragment));
        }
    }

//    @Override
//    public void findCorrespondences(File file1, File file2) throws IOException {
//
//    }
//
//    @Override
//    public void findCorrespondences(String string1, String string2) throws IOException {
//        IArtifact artifact1 = artifactFactory.newArtifact(languages.getJava8(), string1);
//        IArtifact artifact2 = artifactFactory.newArtifact(languages.getJava8(), string2);
//        findCorrespondences(artifact1, artifact2);
//
////        IFragmentKB fragmentKB = fragmentKBFactory.newFragmentKB(artifact1);
////
////        for (IFragment fragment : fragmentKB.getFragments()) {
////            System.out.println(fragment + "\t\t\t\t\t" + fragmentKB.getFragmentsOf(fragment));
////        }
//
////        ITreeWalker<ITextSource> treeWalker = treeWalkerFactory.newTreeWalker();
////        treeWalker.walk(textSourceTree, new ITreeWalkerListener<ITextSource>() {
////            @Override
////            public void enter(ITree<ITextSource> tree) {
////                System.out.println(tree.getValue());
////            }
////
////            @Override
////            public void exit(ITree<ITextSource> tree) {
////
////            }
////        });
//    }
}
