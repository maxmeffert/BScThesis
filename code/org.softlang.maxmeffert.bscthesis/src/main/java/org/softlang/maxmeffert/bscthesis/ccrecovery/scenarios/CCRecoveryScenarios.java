package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.Java8FragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast.SqlFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.hibernate.HibernateJavaSqlNamingCorrespondenceSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.hibernate.HibernateJavaXmlNamingCorrespondenceSimilarityHeuristic;
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

    private IParser getSqlParser() {
        return ccRecovery.getParser(SqlLexer::new, SqlParser::new, SqlParser::sqlDocument, new SqlFragmentBuildingListener());
    }

    private IFragmentAnalyzer getFragmentASTAnalyzer() {
        return ccRecovery.getFragmentASTAnalyzer();
    }

    private ICorrespondenceAnalyzer getCorrespondenceAnalyzer() {
        return ccRecovery.getCorrespondenceAnalyzer();
    }

    private IFragmentAnalyzer getJaxbCorrespondenceSimilarityAnalyzer() {
        IFragmentAnalyzer analyzer = getFragmentASTAnalyzer();
        analyzer.addHeuristic(new JaxbXmlCorrespondenceNamingSimilarityHeuristic());
        analyzer.addHeuristic(new JaxbXmlCorrespondenceAnnotationSimilarityHeuristic());
        analyzer.addHeuristic(new JaxbXsdCorrespondenceNamingSimilarityHeuristic());
        analyzer.addHeuristic(new JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic());
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

        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragmentAST> getStrictJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getJaxbCorrespondenceSimilarities(java8FragmentAST, xmlFragmentAST);
        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeStrictCorrespondences(similarities, java8FragmentAST, xmlFragmentAST);

        return correspondences;
    }

    private IFragmentAnalyzer getHibernateJavaXmlCorrespondenceSimilarityAnalyzer() {
        IFragmentAnalyzer analyzer = getFragmentASTAnalyzer();
        analyzer.addHeuristic(new HibernateJavaXmlNamingCorrespondenceSimilarityHeuristic());
        return analyzer;
    }

    private IFragmentAnalyzer getHibernateJavaSqlCorrespondenceSimilarityAnalyzer() {
        IFragmentAnalyzer analyzer = getFragmentASTAnalyzer();
        analyzer.addHeuristic(new HibernateJavaSqlNamingCorrespondenceSimilarityHeuristic());
        return analyzer;
    }

    private IBinaryRelation<IFragmentAST> getHibernateJavaXmlCorrespondenceSimilarities(IFragmentAST java8FragmentAST, IFragmentAST xmlFragmentAST) {
        return getHibernateJavaXmlCorrespondenceSimilarityAnalyzer().analyze(java8FragmentAST, xmlFragmentAST);
    }

    private IBinaryRelation<IFragmentAST> getHibernateJavaSqlCorrespondenceSimilarities(IFragmentAST java8FragmentAST, IFragmentAST sqlFragmentAST) {
        return getHibernateJavaSqlCorrespondenceSimilarityAnalyzer().analyze(java8FragmentAST, sqlFragmentAST);
    }

    @Override
    public IBinaryRelation<IFragmentAST> getWeakHibernateJavaXmlCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getHibernateJavaXmlCorrespondenceSimilarities(java8FragmentAST, xmlFragmentAST);

        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeWeakCorrespondences(similarities, java8FragmentAST, xmlFragmentAST);

        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragmentAST> getStrictHibernateJavaXmlCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST xmlFragmentAST = getXmlParser().parse(xmlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getHibernateJavaXmlCorrespondenceSimilarities(java8FragmentAST, xmlFragmentAST);

        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeStrictCorrespondences(similarities, java8FragmentAST, xmlFragmentAST);

        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragmentAST> getWeakHibernateJavaSqlCorrespondences(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST sqlFragmentAST = getSqlParser().parse(sqlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getHibernateJavaSqlCorrespondenceSimilarities(java8FragmentAST, sqlFragmentAST);

        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeWeakCorrespondences(similarities, java8FragmentAST, sqlFragmentAST);

        return correspondences;
    }

    @Override
    public IBinaryRelation<IFragmentAST> getStrictHibernateJavaSqlCorrespondences(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException {
        IFragmentAST java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragmentAST sqlFragmentAST = getSqlParser().parse(sqlInputStream);

        IBinaryRelation<IFragmentAST> similarities = getHibernateJavaSqlCorrespondenceSimilarities(java8FragmentAST, sqlFragmentAST);

        IBinaryRelation<IFragmentAST> correspondences = getCorrespondenceAnalyzer().analyzeStrictCorrespondences(similarities, java8FragmentAST, sqlFragmentAST);

        return correspondences;
    }


}
