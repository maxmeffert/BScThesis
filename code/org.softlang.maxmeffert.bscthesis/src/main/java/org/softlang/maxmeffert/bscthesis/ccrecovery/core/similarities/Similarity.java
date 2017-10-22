package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.BinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.Pair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;

import java.util.Set;
import java.util.TreeSet;

public class Similarity extends BinaryRelation<IFragmentAST> implements ISimilarity {
    public Similarity(IDiGraph<IFragmentAST> diGraph) {
        super(diGraph);
    }
}
