package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface ICorrespondenceFactory {
    ICorrespondence newCorrespondence(IFragmentAST fragment1, IFragmentAST fragment2);
}
