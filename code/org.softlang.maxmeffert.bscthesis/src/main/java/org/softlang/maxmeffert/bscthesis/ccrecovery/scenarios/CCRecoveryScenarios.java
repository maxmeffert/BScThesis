package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbCorrespondenceAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb.JaxbCorrespondenceNamingSimilarityHeuristic;
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

    private IParser getJava8Parser() {
        return ccRecovery.getParser(Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentBuildingListener());
    }

    private IParser getXmlParser() {
        return ccRecovery.getParser(XMLLexer::new, XMLParser::new, XMLParser::document, new XMLFragmentBuildingListener());
    }


    private ISimilarityAnalyzer getSimilarityAnalyzer() {
        return ccRecovery.getSimilarityAnalyzer();
    }

    private ISimilarityAnalyzer getJaxbSimilarityAnalyzer() {
        ISimilarityAnalyzer similarityAnalyzer = getSimilarityAnalyzer();
        similarityAnalyzer.addSimilarityHeuristic(new JaxbCorrespondenceNamingSimilarityHeuristic());
        similarityAnalyzer.addSimilarityHeuristic(new JaxbCorrespondenceAnnotationSimilarityHeuristic());
        return similarityAnalyzer;
    }

    @Override
    public void getJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IParser java8Parser = getJava8Parser();
        IParser xmlParser = getXmlParser();

        IFragment java8FragmentAST = java8Parser.parse(javaInputStream);
        IFragment xmlFragmentAST = xmlParser.parse(xmlInputStream);

        ISimilarityAnalyzer similarityAnalyzer = getJaxbSimilarityAnalyzer();
        ISimilarity similarity = similarityAnalyzer.analyze(java8FragmentAST, xmlFragmentAST);

        System.out.println(similarity);
        System.out.println(similarity.size());
    }





}
