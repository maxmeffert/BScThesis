package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

public class SimilaritiyFactory implements ISimilarityFactory {
    @Override
    public ISimilarity newSimilarity() {
        return new Similarity();
    }
}
