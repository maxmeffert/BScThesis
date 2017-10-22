package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

import java.util.LinkedList;
import java.util.List;

public class SimilarityAnalyzer implements ISimilarityAnalyzer {

    private final IBinaryRelationFactory binaryRelationFactory;
    private final List<ISimilarityHeuristic> similarityHeuristics = new LinkedList<>();

    public SimilarityAnalyzer(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public void addSimilarityHeuristic(ISimilarityHeuristic similarityHeuristic) {
        similarityHeuristics.add(similarityHeuristic);
    }

    @Override
    public IBinaryRelation<IFragmentAST> analyze(IFragmentAST fragment1, IFragmentAST fragment2) {
        IBinaryRelation<IFragmentAST> similarity = binaryRelationFactory.newBinaryRelation();
        for(ISimilarityHeuristic similarityHeuristic : similarityHeuristics) {
            similarityHeuristic.analyze(similarity, fragment1, fragment2);
        }
        return similarity;
    }
}
