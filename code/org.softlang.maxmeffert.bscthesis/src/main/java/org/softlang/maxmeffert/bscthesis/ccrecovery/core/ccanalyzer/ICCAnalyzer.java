package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccanalyzer;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondence;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface ICCAnalyzer {
    Set<ICorrespondence> findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws Exception;
    Set<ICorrespondence> findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws Exception;
}
