package org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;

import java.io.File;

public interface IAnalyzer {
    void addCorrespondenceDefinition(ICorrespondenceDefinition correspondenceDefinition);
    void findCorrespondences(File file1, File file2);
    void findCorrespondences(String string1, String string2);
}
