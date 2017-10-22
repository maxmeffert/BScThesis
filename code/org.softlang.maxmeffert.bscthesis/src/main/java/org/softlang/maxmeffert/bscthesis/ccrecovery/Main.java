package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.BinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.DiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.DiGraphFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraph;
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
		InputStream xmlArtifact = new FileInputStream("./xml/companies.xml");

		iccRecoveryScenarios.getJaxbCorrespondences(java8Artifact, xmlArtifact);

//		IDiGraph<Integer> diGraph = new DiGraph<>();
//		diGraph.addEdge(1,2);
//		diGraph.addEdge(2,3);
//		diGraph.addEdge(2,1);
//
//		IDiGraph<Integer> reflexiveClosure = diGraph.getReflexiveClosure();
//		IDiGraph<Integer> transitiveClosure = diGraph.getTransitiveClosure();
//
//		IBinaryRelation<Integer> br = new BinaryRelationFactory(new DiGraphFactory()).newBinaryRelation();
//		br.add(1,2);
//		br.add(2,3);
//		br.add(2,1);
//		br.remove(3,4);
//
//		System.out.println(br);
//		System.out.println(br.getReflexiveClosure());
//		System.out.println(br.getTransitiveClosure());

 	}

}
