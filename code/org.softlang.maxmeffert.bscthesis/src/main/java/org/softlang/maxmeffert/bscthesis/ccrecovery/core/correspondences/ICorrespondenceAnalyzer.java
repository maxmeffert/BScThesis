package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface ICorrespondenceAnalyzer {
    Set<ICorrespondence> analyze(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException;
}
