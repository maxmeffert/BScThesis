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

	public static String fragmentQuery(IFragment fragmentAST) {
		String start = "L" + fragmentAST.getPosition().getStartLine() + "C" + fragmentAST.getPosition().getStartCharInLine();
		String stop = "L" + fragmentAST.getPosition().getStopLine() + "C" + fragmentAST.getPosition().getStopCharInLine();
		return "fragment=F" + start + stop;
	}

	public static URI fragmentUri(URI baseUri, IFragment fragmentAST) throws URISyntaxException {

		String oldQuery = baseUri.getQuery();
		String newQuery = oldQuery == null ? fragmentQuery(fragmentAST) : oldQuery + "&" + fragmentQuery(fragmentAST);

		return new URI(baseUri.getScheme(), baseUri.getAuthority(), baseUri.getPath(), newQuery, baseUri.getFragment());
	}


	public static void queryParameters(URI uri) {
        Map<String,String> map = Arrays.stream(uri.getQuery().split("&"))
                .map(str -> str.split("="))
                .map(array -> new String[] {
                        array.length > 0 ? array[0] : null,
                        array.length > 1 ? array[1] : null
                })
                .collect(Collectors.toMap(a -> a[0], a -> a[1]));
        System.out.println(map);
    }

	public static List<String> readFragmentLines(BufferedReader reader, IFragmentPosition position) throws IOException {
        int skip = position.getStartLine() - 1;
        int limit = position.getStopLine() - position.getStartLine() + 1;
        return reader.lines()
                .skip(skip)
                .limit(limit)
                .collect(Collectors.toList());
    }

	public static String readFragment(BufferedReader reader, IFragmentPosition position) throws IOException {

	    List<String> lines = readFragmentLines(reader, position);

	    int indexOfFirstLine = 0;
	    int indexOfLastLine = lines.size() - 1;

	    String firstLine = lines.get(indexOfFirstLine);
	    String lastLine = lines.get(indexOfLastLine);

		lines.set(indexOfFirstLine, firstLine.substring(position.getStartCharInLine(), lines.get(0).length()));
		lines.set(indexOfLastLine, lastLine.substring(0, position.getStopCharInLine()));

        return String.join(System.lineSeparator(), lines);
	}

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
//		    String encodedPosition = encoder.encode(position);
//		    System.out.println(encodedPosition);
//		    System.out.println(encoder.decode(encodedPosition));
//			System.out.println(fragmentUri(file.toURI(), pair.getFirst()));
//			queryParameters(fragmentUri(file.toURI(), pair.getFirst()));
//			System.out.println(pair.getFirst().getText());1
//			String text = readFragment(new BufferedReader(new FileReader(file)), pair.getFirst().getPosition());
//			System.out.println(text);
//			System.out.println(text.endsWith(pair.getFirst().getText()));
		}
//
//		System.out.println(correspondences);
//		System.out.println(correspondences.size());

 	}

}
