package org.softlang.maxmeffert.bscthesis;

import java.io.File;

public interface IAnalyzer {
    void findCorrespondences(File file1, File file2);
    void findCorrespondences(String string1, String string2);
}
