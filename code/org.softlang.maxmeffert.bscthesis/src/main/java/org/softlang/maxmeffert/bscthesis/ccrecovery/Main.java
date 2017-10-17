package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondence;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast.Java8FragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities.JaxbJavaXmlSimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast.XMLFragmentBuildingListener;

import java.io.File;
import java.io.InputStream;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		ICCRecovery ccRecovery = CCRecovery.create();

		ILanguage java8 = ccRecovery.defineLanguage("Java8", Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit, new Java8FragmentBuildingListener());
		ILanguage xml = ccRecovery.defineLanguage("XML", XMLLexer::new, XMLParser::new, XMLParser::document, new XMLFragmentBuildingListener());


		ICorrespondenceDefinition correspondenceDefinition = ccRecovery.defineCorrespondence(java8, xml, new JaxbJavaXmlSimilarity());


        InputStream artifact1 = ccRecovery.getInputStream(new File("./src/scenarios/java/softlanginc/model/Company.java"));
        InputStream artifact2 = ccRecovery.getInputStream(new File("./xml/companies.xml"));

		Set<ICorrespondence> correspondenceSet = ccRecovery.findCorrespondences(correspondenceDefinition, artifact1, artifact2);

        System.out.println(correspondenceSet);
        System.out.println(correspondenceSet.size());

 	}

}
