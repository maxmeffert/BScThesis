package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;

import java.util.LinkedList;
import java.util.List;

public class FragmentASTAnalyzer implements IFragmentASTAnalyzer {

    private final IBinaryRelationFactory binaryRelationFactory;
    private final List<IFragmentASTAnalyzerHeuristic> similarityHeuristics = new LinkedList<>();

    public FragmentASTAnalyzer(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public void addSimilarityHeuristic(IFragmentASTAnalyzerHeuristic similarityHeuristic) {
        similarityHeuristics.add(similarityHeuristic);
    }

    @Override
    public IBinaryRelation<IFragmentAST> analyze(IFragmentAST fragment1, IFragmentAST fragment2) {
        IBinaryRelation<IFragmentAST> similarity = binaryRelationFactory.newBinaryRelation();
        for(IFragmentASTAnalyzerHeuristic similarityHeuristic : similarityHeuristics) {
            similarityHeuristic.analyze(similarity, fragment1, fragment2);
        }
        return similarity;
    }
}
