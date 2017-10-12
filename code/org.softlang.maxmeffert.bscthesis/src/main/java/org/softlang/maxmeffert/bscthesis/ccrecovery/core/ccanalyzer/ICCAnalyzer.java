package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;

import java.io.IOException;
import java.io.InputStream;

public interface ICCAnalyzer {
    void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException;
    void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws IOException;
}
