package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ISimilarity {
    boolean isEmpty();
    boolean contains(IFragment fragment1, IFragment fragment2);
    int size();
    void add(IFragment fragment1, IFragment fragment2);
}
