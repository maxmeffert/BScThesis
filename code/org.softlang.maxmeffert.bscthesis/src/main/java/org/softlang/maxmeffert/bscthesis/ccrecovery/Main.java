package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static String fragmentQuery(IFragmentAST fragmentAST) {
		String start = "L" + fragmentAST.getPosition().getStartLine() + "C" + fragmentAST.getPosition().getStartCharInLine();
		String stop = "L" + fragmentAST.getPosition().getStopLine() + "C" + fragmentAST.getPosition().getStopCharInLine();
		return "fragment=F" + start + stop;
	}

	public static URI fragmentUri(URI baseUri, IFragmentAST fragmentAST) throws URISyntaxException {

		String oldQuery = baseUri.getQuery();
		String newQuery = oldQuery == null ? fragmentQuery(fragmentAST) : oldQuery + "&" + fragmentQuery(fragmentAST);

		return new URI(baseUri.getScheme(), baseUri.getAuthority(), baseUri.getPath(), newQuery, baseUri.getFragment());
	}

	public static String readFragment(BufferedReader reader, IFragmentPosition position) throws IOException {
		String string = "";
		List<String> lines = reader.lines()
                .skip(position.getStartLine()-1)
                .limit(position.getStopLine()-position.getStartLine()+1)
                .collect(Collectors.toList());

		lines.set(0, lines.get(0).substring(position.getStartCharInLine(), lines.get(0).length()));
		lines.set(lines.size()-1, lines.get(lines.size()-1).substring(0, position.getStopCharInLine()));

//		for (String line : lines) {
//		    string += line + "\n";
//        }

        string = String.join("\n", lines);

//		for (int i=1; i < position.getStartLine(); i++) {
//			reader.readLine();
//		}
//		reader.skip(position.getStartCharInLine());
//		if (position.getStartLine() == position.getStopLine()) {
//		    for (int i=position.getStartCharInLine(); i < position.getStopCharInLine(); i++) {
//		        string += (char) reader.read();
//            }
//        }
//        else {
//            if (position.getStartCharInLine() > 0) {
//                reader.skip(position.getStartCharInLine());
//            }
//            for (int i=0; i <= position.getStopLine() - position.getStartLine(); i++) {
//                string += reader.readLine();
//            }
//            for (int i=0; i <= position.getStopCharInLine() - position.getStartCharInLine(); i++) {
//                string += (char) reader.read();
//            }
//        }
//
		System.out.println(string);
		return string;
	}

	public static void main(String[] args) throws IOException, ParserException, URISyntaxException {

		ICCRecoveryScenarios iccRecoveryScenarios = CCRecoveryScenarios.create();

		InputStream java8Artifact = new FileInputStream("./src/main/java/org/softlang/companies/model/Company.java");
		InputStream xmlArtifact = new FileInputStream("./artifacts/companies.xsd");
		InputStream sqlArtifact = new FileInputStream("./artifacts/companies.ddl.sql");


		IBinaryRelation<IFragmentAST> correspondences = iccRecoveryScenarios.getWeakHibernateJavaSqlCorrespondences(java8Artifact, sqlArtifact);

		File file = new File("./src/main/java/org/softlang/companies/model/Company.java");

		for (IPair<IFragmentAST, IFragmentAST> pair : correspondences) {
			System.out.println(fragmentUri(file.toURI(), pair.getFirst()));
			System.out.println(pair.getFirst().getText());
			String text = readFragment(new BufferedReader(new FileReader(file)), pair.getFirst().getPosition());
			System.out.println(text);
			System.out.println(text.endsWith(pair.getFirst().getText()));
		}
//
//		System.out.println(correspondences);
//		System.out.println(correspondences.size());

 	}

}
