package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;

import java.io.*;
import java.net.URISyntaxException;

public class Main {


    public static void main(String[] args) throws IOException, ParserException, URISyntaxException {

		ICCRecoveryScenarios iccRecoveryScenarios = CCRecoveryScenarios.create();

		InputStream java8Artifact = new FileInputStream("./companies/src/main/java/org/softlang/maxmeffert/bscthesis/ccrecovery/companies/model/Company.java");
		InputStream xmlArtifact = new FileInputStream("./artifacts/companies.xml");
		InputStream xsdArtifact = new FileInputStream("./artifacts/companies.xsd");
		InputStream sqlArtifact = new FileInputStream("./artifacts/companies.ddl.sql");
		InputStream hbmArtifact = new FileInputStream("./companies/src/main/java/org/softlang/maxmeffert/bscthesis/ccrecovery/companies/model/Company.hbm.xml");


		IBinaryRelation<IFragment> correspondences = iccRecoveryScenarios.getXmlXsdSimilarities(xmlArtifact, xsdArtifact);

		System.out.println(correspondences);
		System.out.println(correspondences.size());

 	}

}
