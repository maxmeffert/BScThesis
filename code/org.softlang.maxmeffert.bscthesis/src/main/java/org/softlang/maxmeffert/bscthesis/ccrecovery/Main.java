package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Parser;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		ICCRecovery ccRecovery = CCRecovery.create();

		ILanguage java8 = ccRecovery.defineLanguage("Java8", Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit);

		ICorrespondenceDefinition correspondenceDefinition = ccRecovery.defineCorrespondence(java8, java8, (f1,f2) -> {
			System.out.println(f1 +","+ f2);
			return true;
		});

		ccRecovery.findCorrespondences(correspondenceDefinition,"class A {class A {}}","class A {class A {}}");
 	}

}
