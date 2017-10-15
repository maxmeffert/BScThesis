package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.inputstreams.IInputStreamFactory;

import java.io.IOException;
import java.io.InputStream;

public class CCAnalyzer implements ICCAnalyzer {

    private final IInputStreamFactory inputStreamFactory;
    private final ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory;

    @Inject
    public CCAnalyzer(IInputStreamFactory inputStreamFactory, ICorrespondenceAnalyzerFactory correspondenceAnalyzerFactory) {
        this.inputStreamFactory = inputStreamFactory;
        this.correspondenceAnalyzerFactory = correspondenceAnalyzerFactory;
    }


    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException, ParserException {
        correspondenceAnalyzerFactory.newCorrespondenceAnalyzer().analyze(correspondenceDefinition, artifact1, artifact2);
    }

    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws IOException, ParserException {
        findCorrespondences(correspondenceDefinition, inputStreamFactory.newInputStream(artifact1), inputStreamFactory.newInputStream(artifact2));
    }

}
