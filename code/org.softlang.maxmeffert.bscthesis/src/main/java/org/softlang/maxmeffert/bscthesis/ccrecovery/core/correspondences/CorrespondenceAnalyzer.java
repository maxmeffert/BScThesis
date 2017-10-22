package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;

import java.util.Set;
import java.util.TreeSet;

public class CorrespondenceAnalyzer implements ICorrespondenceAnalyzer {

    private final IFragmentKBFactory fragmentKBFactory;

    public CorrespondenceAnalyzer(IFragmentKBFactory fragmentKBFactory) {
        this.fragmentKBFactory = fragmentKBFactory;
    }

    @Override
    public Set<ICorrespondence> analyze(ISimilarity similarity, IFragmentAST fragment1, IFragmentAST fragment2) {
        Set<ICorrespondence> correspondences = new TreeSet<>();
        IFragmentKB fragmentKB1 = fragmentKBFactory.newFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = fragmentKBFactory.newFragmentKB(fragment2);
        for (IFragmentAST f1 : fragmentKB1.getFragments()) {
            for (IFragmentAST f2 : fragmentKB2.getFragments()) {
                if (similarity.contains(f1, f2)) {
                    Iterable<IFragmentAST> fragmentsOfF1 = fragmentKB1.getFragmentsOf(f1);
                    Iterable<IFragmentAST> fragmentsOfF2 = fragmentKB2.getFragmentsOf(f2);
//                    boolean correspondsTo = fragmentsOfF1.all( ff1 -> fragmentsOfF2.any( ff2 -> similarity.contains(ff1,ff2)));
//                    if (correspondsTo) {
//                        // add correspondence
//                    }
                }
            }
        }
        return correspondences;
    }
}
