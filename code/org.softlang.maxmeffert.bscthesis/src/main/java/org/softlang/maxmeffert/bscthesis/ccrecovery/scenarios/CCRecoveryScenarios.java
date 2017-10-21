package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbXmlCorrespondenceAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbXmlCorrespondenceNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbXsdCorrespondenceNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLFragmentBuildingListener;

import java.io.IOException;
import java.io.InputStream;

public class CCRecoveryScenarios implements ICCRecoveryScenarios {

    public static ICCRecoveryScenarios create() {
        return new CCRecoveryScenarios(CCRecovery.create());
    }

    private final ICCRecovery ccRecovery;

    public CCRecoveryScenarios(ICCRecovery ccRecovery) {
        this.ccRecovery = ccRecovery;
    }

    private IParser getJava8Parser() {
        return ccRecovery.getParser(Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentBuildingListener());
    }

    private IParser getXmlParser() {
        return ccRecovery.getParser(XMLLexer::new, XMLParser::new, XMLParser::document, new XMLFragmentBuildingListener());
    }


    private ISimilarityAnalyzer getSimilarityAnalyzer() {
        return ccRecovery.getSimilarityAnalyzer();
    }

    private ISimilarityAnalyzer getJaxbCorrespondenceSimilarityAnalyzer() {
        ISimilarityAnalyzer similarityAnalyzer = getSimilarityAnalyzer();
        similarityAnalyzer.addSimilarityHeuristic(new JaxbXmlCorrespondenceNamingSimilarityHeuristic());
        similarityAnalyzer.addSimilarityHeuristic(new JaxbXmlCorrespondenceAnnotationSimilarityHeuristic());
        similarityAnalyzer.addSimilarityHeuristic(new JaxbXsdCorrespondenceNamingSimilarityHeuristic());
        similarityAnalyzer.addSimilarityHeuristic(new JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic());
        return similarityAnalyzer;
    }

    @Override
    public void getJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragment java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragment xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        ISimilarity similarity = getJaxbCorrespondenceSimilarityAnalyzer().analyze(java8FragmentAST, xmlFragmentAST);

        System.out.println(similarity);
        System.out.println(similarity.size());
    }





}
