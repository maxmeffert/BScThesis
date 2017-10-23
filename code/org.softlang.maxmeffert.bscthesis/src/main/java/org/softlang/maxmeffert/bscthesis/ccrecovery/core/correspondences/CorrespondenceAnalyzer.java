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

    private boolean weaklyCorrespondsTo(IBinaryRelation<IFragmentAST> similarities, IFragmentAST fragmentAST1, IFragmentKB fragmentKB1, IFragmentAST fragmentAST2, IFragmentKB fragmentKB2) {
        return similarities.contains(fragmentAST1, fragmentAST2)
                && fragmentKB1.anyFragmentsOf(fragmentAST1, f1 -> fragmentKB2.anyFragmentsOf(fragmentAST2, f2 -> similarities.contains(f1,f2)))
                && fragmentKB2.anyFragmentsOf(fragmentAST2, f2 -> fragmentKB1.anyFragmentsOf(fragmentAST1, f1 -> similarities.contains(f1,f2)));
    }

    private boolean strictlyCorrespondsTo(IBinaryRelation<IFragmentAST> similarities, IFragmentAST fragmentAST1, IFragmentKB fragmentKB1, IFragmentAST fragmentAST2, IFragmentKB fragmentKB2) {
        return similarities.contains(fragmentAST1, fragmentAST2)
                && fragmentKB1.allFragmentsOf(fragmentAST1, f1 -> fragmentKB2.anyFragmentsOf(fragmentAST2, f2 -> similarities.contains(f1,f2)))
                && fragmentKB2.allFragmentsOf(fragmentAST2, f2 -> fragmentKB1.anyFragmentsOf(fragmentAST1, f1 -> similarities.contains(f1,f2)));
    }

    private IBinaryRelation<IFragmentAST> analyzeWeakCorrespondences(IBinaryRelation<IFragmentAST> similarities, IFragmentKB fragmentKB1, IFragmentKB fragmentKB2) {
        IBinaryRelation<IFragmentAST> correspondences = createBinaryRelation();
        for (IFragmentAST fragmentAST1 : fragmentKB1.getFragments()) {
            for (IFragmentAST fragmentAST2 : fragmentKB2.getFragments()) {
                if (weaklyCorrespondsTo(similarities, fragmentAST1, fragmentKB1, fragmentAST2, fragmentKB2)) {
                    correspondences.add(fragmentAST1, fragmentAST2);
                }
            }
        }
        return correspondences;
    }

    private IBinaryRelation<IFragmentAST> analyzeStrictCorrespondences(IBinaryRelation<IFragmentAST> similarities, IFragmentKB fragmentKB1, IFragmentKB fragmentKB2) {
        IBinaryRelation<IFragmentAST> correspondences = createBinaryRelation();
        for (IFragmentAST fragmentAST1 : fragmentKB1.getFragments()) {
            for (IFragmentAST fragmentAST2 : fragmentKB2.getFragments()) {
                if (strictlyCorrespondsTo(similarities, fragmentAST1, fragmentKB1, fragmentAST2, fragmentKB2)) {
                    correspondences.add(fragmentAST1, fragmentAST2);
                }
            }
        }
        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragmentAST> analyzeWeakCorrespondences(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2) {
        IFragmentKB fragmentKB1 = createFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = createFragmentKB(fragment2);
        return analyzeWeakCorrespondences(similarity, fragmentKB1, fragmentKB2);
    }

    @Override
    public IBinaryRelation<IFragmentAST> analyzeStrictCorrespondences(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2) {
        IFragmentKB fragmentKB1 = createFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = createFragmentKB(fragment2);
        return analyzeStrictCorrespondences(similarity, fragmentKB1, fragmentKB2);
    }

    private IFragmentKB createFragmentKB(IFragmentAST fragmentAST) {
        return fragmentKBFactory.newFragmentKB(fragmentAST);
    }

    private IBinaryRelation<IFragmentAST> createBinaryRelation() {
        return binaryRelationFactory.newBinaryRelation();
    }
}
