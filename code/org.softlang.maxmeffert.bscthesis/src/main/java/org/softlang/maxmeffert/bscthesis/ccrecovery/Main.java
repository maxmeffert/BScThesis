package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languagedefinitions.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languagedefinitions.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languagedefinitions.xml.XMLLexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languagedefinitions.xml.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ParserException, JAXBException {
		ICCRecovery ccRecovery = CCRecovery.create();

		ILanguage java8 = ccRecovery.defineLanguage("Java8", Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit);
		ILanguage xml = ccRecovery.defineLanguage("XML", XMLLexer::new, XMLParser::new, XMLParser::document);


		ICorrespondenceDefinition correspondenceDefinition = ccRecovery.defineCorrespondence(java8, java8, (f1,f2) -> {
			System.out.println(f1 +","+ f2);
			return true;
		});


        InputStream artifact1 = ccRecovery.getInputStream(new File("./src/scenarios/java/softlanginc/model/Company.java"));
        InputStream artifact2 = ccRecovery.getInputStream("class A {class A {}}");

		ccRecovery.findCorrespondences(correspondenceDefinition, artifact1, artifact2);


 	}

}
