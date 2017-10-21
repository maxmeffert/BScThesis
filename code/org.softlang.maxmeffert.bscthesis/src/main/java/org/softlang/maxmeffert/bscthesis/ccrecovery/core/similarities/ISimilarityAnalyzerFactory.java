package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

public interface ISimilarityAnalyzerFactory {
    ISimilarityAnalyzer newSimilarityAnalyzer(ISimilarityHeuristic similarityAnalyzerStrategy);
}
