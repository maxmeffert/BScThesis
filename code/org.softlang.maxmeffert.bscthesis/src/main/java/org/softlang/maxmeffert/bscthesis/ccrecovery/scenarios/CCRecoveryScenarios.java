package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLFragmentBuildingListener;

import java.io.IOException;
import java.io.InputStream;

public class CCRecoveryScenarios implements ICCRecoveryScenarios {

    public static ICCRecoveryScenarios create() {
        return new CCRecoveryScenarios(IoC.get(ICCRecovery.class));
    }

    private final ICCRecovery ccRecovery;

    public CCRecoveryScenarios(ICCRecovery ccRecovery) {
        this.ccRecovery = ccRecovery;
    }


    @Override
    public void getJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        ILanguage java8 = ccRecovery.defineLanguage("Java8", Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentBuildingListener());
        ILanguage xml = ccRecovery.defineLanguage("XML", XMLLexer::new, XMLParser::new, XMLParser::document, new XMLFragmentBuildingListener());

        IFragment java8fragmentAST = ccRecovery.getFragmentAST(java8, javaInputStream);
        IFragment xmlfragmentAST = ccRecovery.getFragmentAST(xml, xmlInputStream);

        ISimilarityAnalyzer similarityAnalyzer = ccRecovery.getSimilarityAnalyzer();
        similarityAnalyzer.addSimilarityHeuristic(new JaxbNamingSimilarityHeuristic());
        similarityAnalyzer.addSimilarityHeuristic(new JaxbAnnotationSimilarityHeuristic());

        ISimilarity similarity = similarityAnalyzer.analyze(java8fragmentAST, xmlfragmentAST);

        System.out.println(similarity);
        System.out.println(similarity.size());
    }
}
