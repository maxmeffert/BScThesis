package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities.JaxbSimilarityAnalyzerStrategy;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLFragmentBuildingListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException, ParserException {
		ICCRecovery ccRecovery = CCRecovery.create();

		ILanguage java8 = ccRecovery.defineLanguage("Java8", Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentBuildingListener());
		ILanguage xml = ccRecovery.defineLanguage("XML", XMLLexer::new, XMLParser::new, XMLParser::document, new XMLFragmentBuildingListener());

        InputStream java8Artifact = ccRecovery.getInputStream(new File("./src/scenarios/java/softlanginc/model/Company.java"));
        InputStream xmlArtifact = ccRecovery.getInputStream(new File("./xml/companies.xml"));

		IFragment java8fragmentAST = ccRecovery.getFragmentAST(java8, java8Artifact);
		IFragment xmlfragmentAST = ccRecovery.getFragmentAST(xml, xmlArtifact);

		ISimilarity similarity = ccRecovery.analyzeSimilarities(new JaxbSimilarityAnalyzerStrategy(), java8fragmentAST, xmlfragmentAST);

		System.out.println(similarity);
		System.out.println(similarity.size());

//		ICorrespondenceDefinition correspondenceDefinition = ccRecovery.defineCorrespondence(java8, xml, new JaxbJavaXmlSimilarity());
//		Set<ICorrespondence> correspondenceSet = ccRecovery.findCorrespondences(correspondenceDefinition, artifact1, artifact2);
//
//        System.out.println(correspondenceSet);
//        System.out.println(correspondenceSet.size());

 	}

}
