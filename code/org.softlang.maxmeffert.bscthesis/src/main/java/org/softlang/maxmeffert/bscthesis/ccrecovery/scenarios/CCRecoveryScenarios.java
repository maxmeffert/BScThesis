package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.Java8FragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXmlCorrespondenceAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXmlCorrespondenceNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb.JaxbXsdCorrespondenceNamingSimilarityHeuristic;

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


    private IFragmentASTAnalyzer getFragmentASTAnalyzer() {
        return ccRecovery.getFragmentASTAnalyzer();
    }

    private ICorrespondenceAnalyzer getCorrespondenceAnalyzer() {
        return ccRecovery.getCorrespondenceAnalyzer();
    }

    private IFragmentASTAnalyzer getJaxbCorrespondenceSimilarityAnalyzer() {
        IFragmentASTAnalyzer analyzer = getFragmentASTAnalyzer();
        analyzer.addSimilarityHeuristic(new JaxbXmlCorrespondenceNamingSimilarityHeuristic());
        analyzer.addSimilarityHeuristic(new JaxbXmlCorrespondenceAnnotationSimilarityHeuristic());
        analyzer.addSimilarityHeuristic(new JaxbXsdCorrespondenceNamingSimilarityHeuristic());
        analyzer.addSimilarityHeuristic(new JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic());
        return analyzer;
    }

    private IBinaryRelation<IFragmentAST> getJaxbCorrespondenceSimilarities(IFragmentAST java8FragmentAST, IFragmentAST xmlFragmentAST) {
        return getJaxbCorrespondenceSimilarityAnalyzer().analyze(java8FragmentAST, xmlFragmentAST);
    }

    @Override
    public IBinaryRelation<IFragmentAST> getWeakJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getJaxbCorrespondenceSimilarities(java8FragmentAST, xmlFragmentAST);
        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeWeakCorrespondences(similarities, java8FragmentAST, xmlFragmentAST);

        System.out.println(similarities);
        System.out.println(similarities.size());
        System.out.println(correspondences);
        System.out.println(correspondences.size());
        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragmentAST> getStrictJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getJaxbCorrespondenceSimilarities(java8FragmentAST, xmlFragmentAST);
        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeStrictCorrespondences(similarities, java8FragmentAST, xmlFragmentAST);

        System.out.println(similarities);
        System.out.println(similarities.size());
        System.out.println(correspondences);
        System.out.println(correspondences.size());
        return correspondences;
    }


}
