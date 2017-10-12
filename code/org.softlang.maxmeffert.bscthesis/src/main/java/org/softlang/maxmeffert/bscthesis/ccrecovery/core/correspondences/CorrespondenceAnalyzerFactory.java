package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;

public class CorrespondenceAnalyzerFactory implements ICorrespondenceAnalyzerFactory {

    private final IFragmentKBFactory fragmentKBFactory;

    @Inject
    public CorrespondenceAnalyzerFactory(IFragmentKBFactory fragmentKBFactory) {
        this.fragmentKBFactory = fragmentKBFactory;
    }

    @Override
    public ICorrespondenceAnalyzer newCorrespondenceAnalyzer() {
        return new CorrespondenceAnalyzer(fragmentKBFactory);
    }
}
