package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrLexerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers.IFragmentReader;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate.HibernateJavaSqlAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate.HibernateJavaSqlNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate.HibernateJavaXmlAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate.HibernateJavaXmlNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb.JaxbJavaXmlAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb.JaxbJavaXmlNamingSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb.JaxbJavaXsdAnnotationSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb.JaxbJavaXsdNamingSimilarityHeuristic;

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


    @Override
    public <TLexer extends Lexer, TParser extends Parser> IParser getParser(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentBuildingListener fragmentBuildingListener) {
        return ccRecovery.getParser(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory, fragmentBuildingListener);
    }

    @Override
    public IFragmentUriConverter getFragmentUriConverter() {
        return ccRecovery.getFragmentUriConverter();
    }

    @Override
    public IFragmentReader getFragmentReader() {
        return ccRecovery.getFragmentReader();
    }

    @Override
    public IFragmentKB getFragmentKB(IFragment fragment) {
        return ccRecovery.getFragmentKB(fragment);
    }

    @Override
    public IFragmentAnalyzer getFragmentAnalyzer() {
        return ccRecovery.getFragmentAnalyzer();
    }

    @Override
    public IParser getJava8Parser() {
        return ccRecovery.getParser(Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentBuildingListener());
    }

    @Override
    public IParser getXmlParser() {
        return ccRecovery.getParser(XMLLexer::new, XMLParser::new, XMLParser::document, new XmlFragmentBuildingListener());
    }

    @Override
    public IParser getSqlParser() {
        return ccRecovery.getParser(SqlLexer::new, SqlParser::new, SqlParser::sqlDocument, new SqlFragmentBuildingListener());
    }

    @Override
    public IFragmentAnalyzer getJaxbSimilarityAnalyzer() {
        IFragmentAnalyzer analyzer = getFragmentAnalyzer();
        analyzer.addHeuristic(new JaxbJavaXmlNamingSimilarityHeuristic());
        analyzer.addHeuristic(new JaxbJavaXmlAnnotationSimilarityHeuristic());
        analyzer.addHeuristic(new JaxbJavaXsdNamingSimilarityHeuristic());
        analyzer.addHeuristic(new JaxbJavaXsdAnnotationSimilarityHeuristic());
        return analyzer;
    }

    @Override
    public IFragmentAnalyzer getHibernateJavaXmlSimilarityAnalyzer() {
        IFragmentAnalyzer analyzer = getFragmentAnalyzer();
        analyzer.addHeuristic(new HibernateJavaXmlNamingSimilarityHeuristic());
        analyzer.addHeuristic(new HibernateJavaXmlAnnotationSimilarityHeuristic());
        return analyzer;
    }

    @Override
    public IFragmentAnalyzer getHibernateJavaSqlSimilarityAnalyzer() {
        IFragmentAnalyzer analyzer = getFragmentAnalyzer();
        analyzer.addHeuristic(new HibernateJavaSqlNamingSimilarityHeuristic());
        analyzer.addHeuristic(new HibernateJavaSqlAnnotationSimilarityHeuristic());
        return analyzer;
    }


    @Override
    public IBinaryRelation<IFragment> getJaxbSimilarities(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragment java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragment xmlFragmentAST = getXmlParser().parse(xmlInputStream);
        return getJaxbSimilarityAnalyzer().analyze(java8FragmentAST, xmlFragmentAST);
    }

    @Override
    public IBinaryRelation<IFragment> getHibernateJavaXmlSimilarities(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException {
        IFragment java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragment xmlFragmentAST = getXmlParser().parse(xmlInputStream);
        return getHibernateJavaXmlSimilarityAnalyzer().analyze(java8FragmentAST, xmlFragmentAST);
    }

    @Override
    public IBinaryRelation<IFragment> getHibernateJavaSqlSimilarities(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException {
        IFragment java8FragmentAST = getJava8Parser().parse(javaInputStream);
        IFragment sqlFragmentAST = getSqlParser().parse(sqlInputStream);
        return getHibernateJavaSqlSimilarityAnalyzer().analyze(java8FragmentAST, sqlFragmentAST);
    }


}
