package plugins.jaxb;

import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Iterables.getFirst;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathFactory;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.common.base.Splitter;

import plugins.prelude.InjectedEvaluatorPlugin;
import plugins.util.Nodes;

public class FindBuildScriptAsElementOfEvidence extends InjectedEvaluatorPlugin {
	private static String getIn(Project project, String potentialVariable) {
		if (potentialVariable.startsWith("${") && potentialVariable.endsWith("}"))
			return project.getProperty(potentialVariable.substring(2, potentialVariable.length() - 1));

		return potentialVariable;
	}

	private static boolean corresponds(Artifact artifactXSD, Artifact artifactPackage, Artifact schema,
			Artifact destination, String packageName) {

		for (String item : Splitter.on('.').split(packageName))
			if (destination == null)
				return false;
			else
				destination = destination.getChild(item);

		return equal(artifactXSD, schema) && equal(artifactPackage, destination);
	}

	private static String suffix(int n) {
		switch (n % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";

		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 9:
			return "th";
		default:
			return null;
		}
	}

	@Override
	public void evaluate(Relationship relationship) {
		// Get pair
		Entity pair = relationship.getLeft();

		// If pair not bound, there's no build script to validate in
		if (!pair.hasBinding())
			return;

		Artifact artifactBuildscript = getArtifact(pair.getBinding());

		// Get relationships to the parameters
		Relationship firstOf = getFirst(pair.incoming("firstOf"), null);
		Relationship secondOf = getFirst(pair.incoming("secondOf"), null);

		// If any of them does not exist, return
		if (firstOf == null || secondOf == null)
			return;

		// Get the parameter items
		Entity first = firstOf.getLeft();
		Entity second = secondOf.getLeft();

		// If any of them is not bound, can not evaluate
		if (!first.hasBinding())
			return;
		if (!second.hasBinding())
			return;

		Artifact artifactXSD = getArtifact(first.getBinding());
		Artifact artifactPackage = getArtifact(second.getBinding());

		// If any of them is not resolvable, exit
		if (artifactXSD == null || artifactPackage == null)
			return;

		// Open the build script
		try (InputStream stream = artifactBuildscript.getBytes().openStream()) {

			URI buildscript = artifactBuildscript.getLocation();

			// Configure with ANT for file resolution
			Project project = new Project();
			ProjectHelper.configureProject(project, new File(buildscript));

			// Evaluate to all execute statements
			XPath xpath = XPathFactory.newInstance().newXPath();

			// Make field for all executes and properties
			List<Node> executes = Nodes.asList(
					(NodeList) xpath.evaluate("/project/target/exec", new InputSource(stream), XPathConstants.NODESET));

			boolean hasEvidence = false;

			// Check all execute statements for evidence
			for (Node node : executes) {
				List<Node> args = Nodes.asList((NodeList) xpath.evaluate("arg", node, XPathConstants.NODESET));
				// If no argument, continue
				if (args.size() == 0)
					continue;

				// Get schema value
				Node schemaArgValue = args.get(0).getAttributes().getNamedItem("value");

				// If not present skip
				if (schemaArgValue == null)
					continue;

				// Store values for schema, folder and target
				String schemaArg = schemaArgValue.getTextContent();
				String destinationArg = null;
				String packageArg = null;

				// Find associated mappings
				for (int i = 1; i < args.size() - 1; i++) {
					// Get argument name
					Node argName = args.get(i).getAttributes().getNamedItem("value");

					// If no argument name, skip
					if (argName == null)
						continue;

					// If argument name is 'd', set folder
					if ("-d".equals(argName.getTextContent())) {
						// Get value
						Node argValue = args.get(i + 1).getAttributes().getNamedItem("path");

						// If present, assign
						if (argValue != null)
							destinationArg = argValue.getTextContent();
					}

					// If argument name is 'p', set package
					if ("-p".equals(argName.getTextContent())) {
						// Get value
						Node argValue = args.get(i + 1).getAttributes().getNamedItem("value");

						// If present, assign
						if (argValue != null)
							packageArg = argValue.getTextContent();
					}
				}

				// Do resolution
				Artifact schema = getArtifact(getIn(project, schemaArg));
				Artifact destination = getArtifact(getIn(project, destinationArg));
				String packageName = getIn(project, packageArg);

				if (corresponds(artifactXSD, artifactPackage, schema, destination, packageName)) {

					int index = 1 + executes.indexOf(node);
					info("Evidence for pair element found in build script at the " + index + suffix(index)
							+ " <exec>.");
					hasEvidence = true;
					break;
				}
			}

			if (hasEvidence)
				valid(relationship, pair, firstOf, secondOf);
			else
				error("No evidence for pair element relationship found in build script");
		} catch (IOException | XPathException e) {
			throw new RuntimeException(e);
		}
	}
}
