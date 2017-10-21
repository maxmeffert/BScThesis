package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface ICorrespondence extends Comparable<ICorrespondence> {
    IFragmentAST getFragment1();
    IFragmentAST getFragment2();
}
