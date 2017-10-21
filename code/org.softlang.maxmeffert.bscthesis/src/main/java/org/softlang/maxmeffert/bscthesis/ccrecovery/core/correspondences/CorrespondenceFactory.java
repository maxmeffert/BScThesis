package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public class CorrespondenceFactory implements ICorrespondenceFactory {


    @Override
    public ICorrespondence newCorrespondence(IFragmentAST fragment1, IFragmentAST fragment2) {
        return new Correspondence(fragment1, fragment2);
    }
}
