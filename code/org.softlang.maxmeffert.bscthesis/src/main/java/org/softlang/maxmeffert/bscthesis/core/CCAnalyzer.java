package org.softlang.maxmeffert.bscthesis.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.softlang.maxmeffert.bscthesis.core.analyzer.IAnalyzer;
import org.softlang.maxmeffert.bscthesis.core.analyzer.IAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.core.ioc.IoCGuiceModule;

import java.io.File;

public class CCAnalyzer {

    public static CCAnalyzer create() {
        Injector injector = Guice.createInjector(new IoCGuiceModule());
        IAnalyzerFactory analyzerFactory = injector.getInstance(IAnalyzerFactory.class);
        return new CCAnalyzer(analyzerFactory.newAnalyzer());
    }

    private final IAnalyzer analyzer;

    public CCAnalyzer(IAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void findCorrespondences(File file1, File file2) {
        analyzer.findCorrespondences(file1, file1);
    }

    public void findCorrespondences(String string1, String string2) {
        analyzer.findCorrespondences(string1, string2);
    }
}
