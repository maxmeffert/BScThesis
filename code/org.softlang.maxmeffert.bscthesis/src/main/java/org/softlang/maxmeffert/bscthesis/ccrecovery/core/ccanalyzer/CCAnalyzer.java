package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CCAnalyzer implements ICCAnalyzer {

    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCAnalyzer(ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }


    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException {
        correspondenceAnalyzerFactory.newCorrespondenceAnalyzer().analyze(correspondenceDefinition, artifact1, artifact2);
    }

    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws IOException {
        findCorrespondences(correspondenceDefinition, new ByteArrayInputStream(artifact1.getBytes()), new ByteArrayInputStream(artifact2.getBytes()));
    }

}
