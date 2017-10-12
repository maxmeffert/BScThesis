package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;

import java.io.IOException;
import java.io.InputStream;

public interface IAnalyzer {
    void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException;
    void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws IOException;
}
