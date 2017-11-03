package org.softlang.megal.plugins.old;

import static org.softlang.megal.plugins.util.Nodes.asContext;
import static org.softlang.megal.plugins.util.Nodes.asList;
import static org.softlang.megal.plugins.util.Nodes.locationAndValue;
import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Maps;

public class XSDJavaCorrespondence extends GuidedReasonerPlugin {

	@Override
	public void guidedDerive(Relationship relationship) throws IOException, XPathExpressionException {
		when(isElementOfLanguage(relationship.getLeft(), "XSD"));
		when(isElementOfLanguage(relationship.getRight(), "Java"));

		Artifact left = artifactOf(relationship.getLeft());
		Artifact right = artifactOf(relationship.getRight());

		// Evaluate to all execute statements
		XPath xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(asContext(ImmutableBiMap.of("xs", "http://www.w3.org/2001/XMLSchema")));

		// Open the schema
		try (InputStream stream = left.getBytes().openStream()) {
			List<Node> elements = asList(
					(NodeList) xpath.evaluate("/xs:schema/xs:element/xs:complexType/..|/xs:schema/xs:complexType",
							new InputSource(stream), XPathConstants.NODESET));

			Map<Node, Artifact> matched = Maps.newHashMap();

			boolean hasInvalidation = false;
			for (Node node : elements) {
				String name = node.getAttributes().getNamedItem("name").getTextContent();
				String className = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, name);

				Artifact artifact = right.getChild(className + ".java");
				if (artifact == null || !artifact.exists()) {
					hasInvalidation = true;
					error("The class with the name " + className + ", corresponding to the element <"
							+ node.getNodeName() + " ... name=\"" + name + "\" ... /> does not exist.");
				} else {
					matched.put(node, artifact);
				}
			}

			if (!hasInvalidation) {
				valid();
				//TODO Really nesting partOf stuff things
				for (Entry<Node, Artifact> match : matched.entrySet()) {
					Entity eleft = entity(locationAndValue(match.getKey()), "Transient");
					Entity eright = entity(match.getValue().toString(), "Transient");

					relationship(eleft.getName(), eright.getName(), "correspondsTo");

					relationship(eleft.getName(), relationship.getLeft().getName(), "partOf");
					relationship(eright.getName(), relationship.getRight().getName(), "partOf");
				}
			}
		}
	}
}
