package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifact;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;

import java.io.File;
import java.io.IOException;

public interface IAnalyzer {
    void addCorrespondenceDefinition(ICorrespondenceDefinition correspondenceDefinition);

    void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, IArtifact artifact1, IArtifact artifact2) throws IOException;
}
