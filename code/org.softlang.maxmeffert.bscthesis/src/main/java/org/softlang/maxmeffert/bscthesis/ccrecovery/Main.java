package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException, ParserException {

		ICCRecoveryScenarios iccRecoveryScenarios = CCRecoveryScenarios.create();

		InputStream java8Artifact = new FileInputStream("./src/main/java/org/softlang/companies/model/Company.java");
		InputStream xmlArtifact = new FileInputStream("./artifacts/companies.xsd");
		InputStream sqlArtifact = new FileInputStream("./artifacts/companies.ddl.sql");

		IBinaryRelation<IFragmentAST> correspondences = iccRecoveryScenarios.getWeakHibernateCorrespondences(java8Artifact, sqlArtifact);

		System.out.println(correspondences);
		System.out.println(correspondences.size());

 	}

}
