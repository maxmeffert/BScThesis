package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBFactory;

public class CorrespondenceAnalyzer implements ICorrespondenceAnalyzer {

    private final IBinaryRelationFactory binaryRelationFactory;
    private final IFragmentKBFactory fragmentKBFactory;

    public CorrespondenceAnalyzer(IBinaryRelationFactory binaryRelationFactory, IFragmentKBFactory fragmentKBFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
        this.fragmentKBFactory = fragmentKBFactory;
    }

    private boolean correspondsTo(IFragmentAST fragmentAST1, IFragmentKB fragmentKB1, IFragmentAST fragmentAST2, IFragmentKB fragmentKB2) {
        Iterable<IFragmentAST> fragmentsOfF1 = fragmentKB1.getFragmentsOf(fragmentAST1);
        Iterable<IFragmentAST> fragmentsOfF2 = fragmentKB2.getFragmentsOf(fragmentAST2);
//                    boolean correspondsTo = fragmentsOfF1.all( ff1 -> fragmentsOfF2.any( ff2 -> similarity.contains(ff1,ff2)));
        return false;
    }


    private IBinaryRelation<IFragmentAST> analyze(IBinaryRelation<IFragmentAST> similarities, IFragmentKB fragmentKB1, IFragmentKB fragmentKB2) {
        IBinaryRelation<IFragmentAST> correspondences = createBinaryRelation();
        for (IFragmentAST fragmentAST1 : fragmentKB1.getFragments()) {
            for (IFragmentAST fragmentAST2 : fragmentKB2.getFragments()) {
                if (similarities.contains(fragmentAST1, fragmentAST2)
                        && correspondsTo(fragmentAST1, fragmentKB1, fragmentAST2, fragmentKB2)) {
                    correspondences.add(fragmentAST1, fragmentAST2);
                }
            }
        }
        return correspondences;
    }


    @Override
    public IBinaryRelation<IFragmentAST> analyze(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2) {
        IFragmentKB fragmentKB1 = createFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = createFragmentKB(fragment2);
        return analyze(similarity, fragmentKB1, fragmentKB2);
    }

    private IFragmentKB createFragmentKB(IFragmentAST fragmentAST) {
        return fragmentKBFactory.newFragmentKB(fragmentAST);
    }

    private IBinaryRelation<IFragmentAST> createBinaryRelation() {
        return binaryRelationFactory.newBinaryRelation();
    }
}
