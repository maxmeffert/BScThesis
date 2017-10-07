package org.softlang.maxmeffert.bscthesis.ccrecovery;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer.IAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoCGuiceModule;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer.IAnalyzer;

import java.io.File;

public class CCRecoveryAnalyzer {

    public static CCRecoveryAnalyzer create() {
        Injector injector = Guice.createInjector(new IoCGuiceModule());
        IAnalyzerFactory analyzerFactory = injector.getInstance(IAnalyzerFactory.class);
        return new CCRecoveryAnalyzer(analyzerFactory.newAnalyzer());
    }

    private final IAnalyzer analyzer;

    public CCRecoveryAnalyzer(IAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void findCorrespondences(File file1, File file2) {
        analyzer.findCorrespondences(file1, file1);
    }

    public void findCorrespondences(String string1, String string2) {
        analyzer.findCorrespondences(string1, string2);
    }
}
