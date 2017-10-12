package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class CorrespondenceAnalyzer implements ICorrespondenceAnalyzer {

    private final IFragmentKBFactory fragmentKBFactory;

    public CorrespondenceAnalyzer(IFragmentKBFactory fragmentKBFactory) {
        this.fragmentKBFactory = fragmentKBFactory;
    }

    @Override
    public Set<ICorrespondence> analyze(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException {
        IFragmentKB fragmentKB1 = fragmentKBFactory.newFragmentKB(correspondenceDefinition.getLanguage1().getParser().parse(artifact1));
        IFragmentKB fragmentKB2 = fragmentKBFactory.newFragmentKB(correspondenceDefinition.getLanguage2().getParser().parse(artifact2));
        for(IFragment fragment1 : fragmentKB1.getFragments()) {
            for (IFragment fragment2 : fragmentKB2.getFragments()) {

            }
        }
        for (IFragment fragment : fragmentKB1.getFragments()) {
            System.out.println(fragment + "\t\t\t\t\t" + fragmentKB1.getFragmentsOf(fragment));
        }
        return null;
    }
}
