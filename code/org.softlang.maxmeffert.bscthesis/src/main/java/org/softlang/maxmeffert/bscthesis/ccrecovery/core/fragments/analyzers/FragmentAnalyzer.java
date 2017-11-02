package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.LinkedList;
import java.util.List;

public class FragmentAnalyzer implements IFragmentAnalyzer {

    private final IBinaryRelationFactory binaryRelationFactory;
    private final List<IFragmentAnalyzerHeuristic> similarityHeuristics = new LinkedList<>();

    public FragmentAnalyzer(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public void addHeuristic(IFragmentAnalyzerHeuristic similarityHeuristic) {
        similarityHeuristics.add(similarityHeuristic);
    }

    @Override
    public IBinaryRelation<IFragment> analyze(IFragment fragment1, IFragment fragment2) {
        IBinaryRelation<IFragment> binaryRelation = binaryRelationFactory.newBinaryRelation();
        for(IFragmentAnalyzerHeuristic heuristic : similarityHeuristics) {
            heuristic.analyze(binaryRelation, fragment1, fragment2);
        }
        return binaryRelation;
    }
}
