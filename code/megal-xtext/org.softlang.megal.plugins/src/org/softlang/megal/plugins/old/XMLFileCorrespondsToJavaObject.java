package org.softlang.megal.plugins.old;

import static com.google.common.collect.Sets.newHashSet;
import static org.softlang.megal.plugins.util.Nodes.asList;
import static org.softlang.megal.plugins.util.Nodes.getValue;
import static org.softlang.megal.plugins.util.Nodes.locationAndValue;
import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;
import static org.softlang.megal.plugins.util.Prelude.isInstance;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.softlang.megal.plugins.util.Utils;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

public class XMLFileCorrespondsToJavaObject extends GuidedReasonerPlugin {

	private boolean isMatchable(Node node) {
		switch (node.getNodeType()) {
		case Node.ATTRIBUTE_NODE:
		case Node.ELEMENT_NODE:
		case Node.DOCUMENT_NODE:
			break;

		default:
			return false;
		}

		if (node.getNodeName().startsWith("xmlns"))
			return false;

		// More stop criteria can go here
		return true;
	}

	private boolean matchValue(String source, Object target) {
		if (target == null)
			return "null".equalsIgnoreCase(source);

		if (target instanceof Number)
			return target.equals(Long.valueOf(source))
					|| target.equals(Double.valueOf(source));

		if (target instanceof Boolean)
			return target.equals(Boolean.valueOf(source));

		return String.valueOf(target).equals(source);
	}

	/**
	 * <p>
	 * Matches the XML node with the given object, if not matching,
	 * <code>null</code> is returned, else a map of corresponding elements.
	 * </p>
	 * 
	 * @param file
	 *            The XML node to match
	 * @param object
	 *            The object to match with
	 * @param errors
	 *            A result-set of errors or <code>null</code>
	 * @return Returns the matches or <code>null</code>
	 */
	private Map<Node, Object> match(Node file, Object object, Set<String> errors) {
		ImmutableMap.Builder<Node, Object> builder = ImmutableMap.builder();

		// Track if there were matchable children
		boolean hasMatchableChildren = false;

		next: for (Node child : asList(file.getChildNodes())) {
			// Skip special or unmatchable nodes
			if (!isMatchable(child))
				continue next;

			// There is a child that passed the matchable mark
			hasMatchableChildren = true;

			Optional<Object> value = Utils.getForXML(object,
					child.getNodeName());

			// No corresponding field, structural error
			if (!value.isPresent()) {
				if (errors != null)
					errors.add("No corresponding field for "
							+ child.getNodeName());
				return null;
			}

			// If direct match
			Map<Node, Object> direct = match(child, value.get(), errors);

			if (direct != null) {
				builder.put(child, value.get());
				builder.putAll(direct);
				continue next;
			}

			// If not matching, different values
			if (matchValue(getValue(child), value.get())) {
				builder.put(child, value.get());
				continue next;
			}

			// Child match
			if (value.get() instanceof Collection<?>) {
				Collection<?> items = (Collection<?>) value.get();
				for (Object item : items) {
					Map<Node, Object> potential = match(child, item, errors);
					if (potential != null) {
						builder.put(child, item);
						builder.putAll(potential);
						continue next;
					}
				}
			}

			if (errors != null)
				errors.add("No corresponding element for child "
						+ child.getNodeName());

			// No match at all
			return null;
		}

		// No child nodes, not the current call's responsibility to match,
		// should be done above where name lookup is possible
		if (!hasMatchableChildren)
			return null;

		// All matched
		return builder.build();
	}

	@Override
	public boolean isContextBased() {
		// Context based, as the binding is provided by another reasoner
		return true;
	}

	@Override
	public void guidedDerive(Relationship relationship) throws IOException,
			ParserConfigurationException, SAXException {
		when(isElementOfLanguage(relationship.getLeft(), "XML"));
		when(isInstance(relationship.getRight(), "Transient"));

		Artifact file = artifactOf(relationship.getLeft());
		Object object = bindingOf(relationship.getRight());

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(bytesFor(file));
		document.getDocumentElement().normalize();

		// Optional<String> matchMessage = isMatch(
		// document.getDocumentElement(), object);
		Set<String> errors = newHashSet();
		Map<Node, Object> matches = match(document.getDocumentElement(),
				object, errors);

		if (matches == null)
			error("Does not correspond: " + Joiner.on("\r\n").join(errors));
		else {

			//TODO Really nesting partOf stuff things
			for (Entry<Node, Object> trace : matches.entrySet()) {
				Entity left = entity(locationAndValue(trace.getKey()),
						"Transient");
				Entity right = entity(trace.getValue().toString(), "Transient");

				relationship(left.getName(), right.getName(), "correspondsTo");

				relationship(left.getName(), relationship.getLeft().getName(),
						"partOf");
				relationship(right.getName(),
						relationship.getRight().getName(), "partOf");
			}
			valid();
		}
	}
}
