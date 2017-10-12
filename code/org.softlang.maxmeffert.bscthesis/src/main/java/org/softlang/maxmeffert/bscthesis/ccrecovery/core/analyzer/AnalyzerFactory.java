package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;

public class AnalyzerFactory implements IAnalyzerFactory {

    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public AnalyzerFactory(ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }

    @Override
    public IAnalyzer newAnalyzer() {
        return new Analyzer(correspondenceAnalyzerFactory);
    }
}
