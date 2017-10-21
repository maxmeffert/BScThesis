package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface ISimilarity {
    boolean isEmpty();
    boolean contains(IFragmentAST fragment1, IFragmentAST fragment2);
    int size();
    void add(IFragmentAST fragment1, IFragmentAST fragment2);
}
