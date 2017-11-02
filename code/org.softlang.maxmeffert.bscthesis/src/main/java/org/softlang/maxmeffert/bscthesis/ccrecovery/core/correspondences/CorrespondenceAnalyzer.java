package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKBFactory;

public class CorrespondenceAnalyzer implements ICorrespondenceAnalyzer {

    private final IBinaryRelationFactory binaryRelationFactory;
    private final IFragmentKBFactory fragmentKBFactory;

    public CorrespondenceAnalyzer(IBinaryRelationFactory binaryRelationFactory, IFragmentKBFactory fragmentKBFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
        this.fragmentKBFactory = fragmentKBFactory;
    }

    private boolean weaklyCorrespondsTo(IBinaryRelation<IFragment> similarities, IFragment fragmentAST1, IFragmentKB fragmentKB1, IFragment fragmentAST2, IFragmentKB fragmentKB2) {
        return similarities.contains(fragmentAST1, fragmentAST2)
                && fragmentKB1.anyFragmentsOf(fragmentAST1, f1 -> fragmentKB2.anyFragmentsOf(fragmentAST2, f2 -> similarities.contains(f1,f2)))
                && fragmentKB2.anyFragmentsOf(fragmentAST2, f2 -> fragmentKB1.anyFragmentsOf(fragmentAST1, f1 -> similarities.contains(f1,f2)));
    }

    private boolean strictlyCorrespondsTo(IBinaryRelation<IFragment> similarities, IFragment fragmentAST1, IFragmentKB fragmentKB1, IFragment fragmentAST2, IFragmentKB fragmentKB2) {
        return similarities.contains(fragmentAST1, fragmentAST2)
                && fragmentKB1.allFragmentsOf(fragmentAST1, f1 -> fragmentKB2.anyFragmentsOf(fragmentAST2, f2 -> similarities.contains(f1,f2)))
                && fragmentKB2.allFragmentsOf(fragmentAST2, f2 -> fragmentKB1.anyFragmentsOf(fragmentAST1, f1 -> similarities.contains(f1,f2)));
    }

    private IBinaryRelation<IFragment> analyzeWeakCorrespondences(IBinaryRelation<IFragment> similarities, IFragmentKB fragmentKB1, IFragmentKB fragmentKB2) {
        IBinaryRelation<IFragment> correspondences = createBinaryRelation();
        for (IFragment fragmentAST1 : fragmentKB1.getFragments()) {
            for (IFragment fragmentAST2 : fragmentKB2.getFragments()) {
                if (weaklyCorrespondsTo(similarities, fragmentAST1, fragmentKB1, fragmentAST2, fragmentKB2)) {
                    correspondences.add(fragmentAST1, fragmentAST2);
                }
            }
        }
        return correspondences;
    }

    private IBinaryRelation<IFragment> analyzeStrictCorrespondences(IBinaryRelation<IFragment> similarities, IFragmentKB fragmentKB1, IFragmentKB fragmentKB2) {
        IBinaryRelation<IFragment> correspondences = createBinaryRelation();
        for (IFragment fragmentAST1 : fragmentKB1.getFragments()) {
            for (IFragment fragmentAST2 : fragmentKB2.getFragments()) {
                if (strictlyCorrespondsTo(similarities, fragmentAST1, fragmentKB1, fragmentAST2, fragmentKB2)) {
                    correspondences.add(fragmentAST1, fragmentAST2);
                }
            }
        }
        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragment> analyzeWeakCorrespondences(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2) {
        IFragmentKB fragmentKB1 = createFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = createFragmentKB(fragment2);
        return analyzeWeakCorrespondences(similarity, fragmentKB1, fragmentKB2);
    }

    @Override
    public IBinaryRelation<IFragment> analyzeStrictCorrespondences(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2) {
        IFragmentKB fragmentKB1 = createFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = createFragmentKB(fragment2);
        return analyzeStrictCorrespondences(similarity, fragmentKB1, fragmentKB2);
    }

    private IFragmentKB createFragmentKB(IFragment fragmentAST) {
        return fragmentKBFactory.newFragmentKB(fragmentAST);
    }

    private IBinaryRelation<IFragment> createBinaryRelation() {
        return binaryRelationFactory.newBinaryRelation();
    }
}
