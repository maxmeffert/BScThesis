package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.FragmentPositionEncoder;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionEncoder;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException, ParserException, URISyntaxException {

		IFragmentUriFactory fragmentUriFactory = CCRecovery.create().getFragmentUriFactory();
		ICCRecoveryScenarios iccRecoveryScenarios = CCRecoveryScenarios.create();

		InputStream java8Artifact = new FileInputStream("./src/main/java/org/softlang/companies/model/Company.java");
		InputStream xmlArtifact = new FileInputStream("./artifacts/companies.xsd");
		InputStream sqlArtifact = new FileInputStream("./artifacts/companies.ddl.sql");


		IBinaryRelation<IFragment> correspondences = iccRecoveryScenarios.getWeakHibernateJavaSqlCorrespondences(java8Artifact, sqlArtifact);

		File file = new File("./src/main/java/org/softlang/companies/model/Company.java");

        IFragmentPositionEncoder encoder = new FragmentPositionEncoder();

		for (IPair<IFragment, IFragment> pair : correspondences) {
		    IFragmentPosition position = pair.getFirst().getPosition();
		    System.out.println(fragmentUriFactory.newFragmentUri(file.toURI(), pair.getFirst()));
		}
//
//		System.out.println(correspondences);
//		System.out.println(correspondences.size());

 	}

}
