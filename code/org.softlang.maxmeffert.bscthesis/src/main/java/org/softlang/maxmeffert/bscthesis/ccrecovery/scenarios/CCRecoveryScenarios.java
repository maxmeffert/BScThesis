package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.Java8FragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXmlCorrespondenceAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXmlCorrespondenceNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXsdCorrespondenceNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLFragmentASTBuildingListener;

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
        return ccRecovery.getParser(Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentASTBuildingListener());
    }

    private IParser getXmlParser() {
        return ccRecovery.getParser(XMLLexer::new, XMLParser::new, XMLParser::document, new XMLFragmentASTBuildingListener());
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
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        ISimilarity similarity = getJaxbCorrespondenceSimilarityAnalyzer().analyze(java8FragmentAST, xmlFragmentAST);

        System.out.println(similarity);
        System.out.println(similarity.size());
    }





}
