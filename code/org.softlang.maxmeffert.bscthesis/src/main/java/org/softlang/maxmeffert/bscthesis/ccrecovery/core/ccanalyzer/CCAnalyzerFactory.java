package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;

public class CCAnalyzerFactory implements ICCAnalyzerFactory {

    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCAnalyzerFactory(ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }

    @Override
    public ICCAnalyzer newCCAnalyzer() {
        return new CCAnalyzer(correspondenceAnalyzerFactory);
    }
}
