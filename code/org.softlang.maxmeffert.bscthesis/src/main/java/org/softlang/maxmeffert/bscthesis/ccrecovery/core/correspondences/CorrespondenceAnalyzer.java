package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;

public class CorrespondenceAnalyzer implements ICorrespondenceAnalyzer {

    private final ICorrespondenceFactory correspondenceFactory;
    private final IFragmentKBFactory fragmentKBFactory;

    public CorrespondenceAnalyzer(ICorrespondenceFactory correspondenceFactory, IFragmentKBFactory fragmentKBFactory) {
        this.correspondenceFactory = correspondenceFactory;
        this.fragmentKBFactory = fragmentKBFactory;
    }

    @Override
    public Set<ICorrespondence> analyze(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException {
        Set<ICorrespondence> correspondences = new TreeSet<>();
        IFragmentKB fragmentKB1 = fragmentKBFactory.newFragmentKB(correspondenceDefinition.getLanguage1().getParser().parse(artifact1));
        IFragmentKB fragmentKB2 = fragmentKBFactory.newFragmentKB(correspondenceDefinition.getLanguage2().getParser().parse(artifact2));
        for(IFragment fragment1 : fragmentKB1.getFragments()) {
            for (IFragment fragment2 : fragmentKB2.getFragments()) {
                if (correspondenceDefinition.accept(fragment1, fragment2)) {
                    correspondences.add(correspondenceFactory.newCorrespondence(correspondenceDefinition, fragment1, fragment2));
                }
            }
        }
        return null;
    }
}
