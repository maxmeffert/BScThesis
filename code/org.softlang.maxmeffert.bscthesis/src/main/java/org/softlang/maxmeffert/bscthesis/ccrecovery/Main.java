package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException, ParserException {

		ICCRecoveryScenarios iccRecoveryScenarios = CCRecoveryScenarios.create();

		InputStream java8Artifact = new FileInputStream("./src/scenarios/java/softlanginc/model/Company.java");
		InputStream xmlArtifact = new FileInputStream("./xml/companies.xml");

		iccRecoveryScenarios.getJaxbCorrespondences(java8Artifact, xmlArtifact);

 	}

}
