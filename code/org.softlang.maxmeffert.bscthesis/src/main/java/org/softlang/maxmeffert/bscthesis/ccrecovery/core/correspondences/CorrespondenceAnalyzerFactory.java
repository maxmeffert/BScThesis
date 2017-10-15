package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;

public class CorrespondenceAnalyzerFactory implements ICorrespondenceAnalyzerFactory {

    private final ICorrespondenceFactory correspondenceFactory;
    private final IFragmentKBFactory fragmentKBFactory;

    @Inject
    public CorrespondenceAnalyzerFactory(ICorrespondenceFactory correspondenceFactory, IFragmentKBFactory fragmentKBFactory) {
        this.correspondenceFactory = correspondenceFactory;
        this.fragmentKBFactory = fragmentKBFactory;
    }

    @Override
    public ICorrespondenceAnalyzer newCorrespondenceAnalyzer() {
        return new CorrespondenceAnalyzer(correspondenceFactory, fragmentKBFactory);
    }
}
