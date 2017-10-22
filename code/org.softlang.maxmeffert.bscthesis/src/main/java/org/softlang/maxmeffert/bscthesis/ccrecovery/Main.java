package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.DiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException, ParserException {

//		ICCRecoveryScenarios iccRecoveryScenarios = CCRecoveryScenarios.create();
//
//		InputStream java8Artifact = new FileInputStream("./src/main/java/org/softlang/companies/model/Company.java");
//		InputStream xmlArtifact = new FileInputStream("./xml/companies.xml");
//
//		iccRecoveryScenarios.getJaxbCorrespondences(java8Artifact, xmlArtifact);

		IDiGraph<Integer> diGraph = new DiGraph<>();
		diGraph.addEdge(1,2);
		diGraph.addEdge(2,3);
		diGraph.addEdge(2,1);

		IDiGraph<Integer> reflexiveClosure = diGraph.getReflexiveClosure();
		IDiGraph<Integer> transitiveClosure = diGraph.getTransitiveClosure();

		System.out.println(diGraph.getEdges());
		System.out.println(reflexiveClosure.getEdges());
		System.out.println(transitiveClosure.getEdges());

 	}

}
