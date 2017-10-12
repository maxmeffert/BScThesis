package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.inputstreams.IInputStreamFactory;

public class CCAnalyzerFactory implements ICCAnalyzerFactory {

    private final IInputStreamFactory inputStreamFactory;
    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCAnalyzerFactory(IInputStreamFactory inputStreamFactory, ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.inputStreamFactory = inputStreamFactory;
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }

    @Override
    public ICCAnalyzer newCCAnalyzer() {
        return new CCAnalyzer(inputStreamFactory, correspondenceAnalyzerFactory);
    }
}
