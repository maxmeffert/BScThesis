package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlFragmentBuildingListener;

import java.io.IOException;
import java.io.InputStream;

public interface ICCRecoveryScenarios extends ICCRecovery {

    IParser getJava8Parser();

    IParser getXmlParser();

    IParser getSqlParser();

    IFragmentAnalyzer getXmlXsdSimilarityAnalyzer();

    IFragmentAnalyzer getJaxbSimilarityAnalyzer();

    IFragmentAnalyzer getHibernateJavaXmlSimilarityAnalyzer();

    IFragmentAnalyzer getHibernateJavaSqlSimilarityAnalyzer();

    IBinaryRelation<IFragment> getXmlXsdSimilarities(InputStream xmlInputStream, InputStream xsdInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getJaxbSimilarities(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getHibernateJavaXmlSimilarities(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getHibernateJavaSqlSimilarities(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException;


}
