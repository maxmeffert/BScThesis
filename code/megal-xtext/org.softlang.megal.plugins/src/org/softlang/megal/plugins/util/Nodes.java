package org.softlang.megal.plugins.util;

import static com.google.common.collect.Iterators.emptyIterator;
import static com.google.common.collect.Iterators.singletonIterator;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.BiMap;
import com.google.common.collect.Maps;

public class Nodes {
	public static String locationAndValue(Node node) {
		String value = getValue(node);

		return value == null ? location(node) : location(node) + ": " + value;
	}

	public static String location(Node node) {
		if (node.getParentNode() == null)
			return "";

		int index = 0;
		boolean overlap = false;
		Node other = node;
		while ((other = other.getPreviousSibling()) != null)
			if (other.getNodeName().equalsIgnoreCase(node.getNodeName())) {
				index++;
				overlap = true;
			}

		other = node;
		while ((other = other.getNextSibling()) != null)
			if (other.getNodeName().equalsIgnoreCase(node.getNodeName())) {
				overlap = true;
				break;
			}

		if (overlap)
			return location(node.getParentNode()) + "/" + node.getNodeName()
					+ "#" + index;
		else
			return location(node.getParentNode()) + "/" + node.getNodeName();
	}

	public static String getValue(Node node) {
		if (node.getNodeType() != Node.ELEMENT_NODE)
			return node.getNodeValue();

		for (Node childNode : asList(node.getChildNodes()))
			if (childNode.getNodeType() == Node.ELEMENT_NODE)
				return null;

		return node.getTextContent();
	}

	public static List<Node> asList(final NodeList n) {
		return new AbstractList<Node>() {
			@Override
			public Node get(int index) {
				return n.item(index);
			}

			@Override
			public int size() {
				return n.getLength();
			}
		};
	}

	public static List<Node> asList(final NamedNodeMap n) {
		return new AbstractList<Node>() {
			@Override
			public Node get(int index) {
				return n.item(index);
			}

			@Override
			public int size() {
				return n.getLength();
			}
		};
	}

	public static Map<String, Node> asMap(final NamedNodeMap n) {
		return Maps.uniqueIndex(asList(n), Node::getNodeName);
	}

	public static NamespaceContext asContext(BiMap<String, String> mapping) {
		return asContext(null, mapping);
	}

	public static NamespaceContext asContext(final String defaultNSRURI,
			final BiMap<String, String> mapping) {
		return new NamespaceContext() {

			@Override
			public Iterator<String> getPrefixes(String namespaceURI) {
				if (namespaceURI == null)
					throw new IllegalArgumentException();

				if (defaultNSRURI.equals(namespaceURI))
					return singletonIterator(XMLConstants.DEFAULT_NS_PREFIX);

				if (XMLConstants.XML_NS_URI.equals(namespaceURI))
					return singletonIterator(XMLConstants.XML_NS_PREFIX);
				if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(namespaceURI))
					return singletonIterator(XMLConstants.XMLNS_ATTRIBUTE);

				if (!mapping.inverse().containsKey(namespaceURI))
					return emptyIterator();

				return singletonIterator(mapping.inverse().get(namespaceURI));
			}

			@Override
			public String getPrefix(String namespaceURI) {
				if (namespaceURI == null)
					throw new IllegalArgumentException();

				if (defaultNSRURI.equals(namespaceURI))
					return XMLConstants.DEFAULT_NS_PREFIX;

				if (XMLConstants.XML_NS_URI.equals(namespaceURI))
					return XMLConstants.XML_NS_PREFIX;
				if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(namespaceURI))
					return XMLConstants.XMLNS_ATTRIBUTE;

				return mapping.inverse().get(namespaceURI);
			}

			@Override
			public String getNamespaceURI(String prefix) {
				if (prefix == null)
					throw new IllegalArgumentException();

				if (XMLConstants.DEFAULT_NS_PREFIX.equals(prefix))
					return defaultNSRURI;

				if (XMLConstants.XML_NS_PREFIX.equals(prefix))
					return XMLConstants.XML_NS_URI;
				if (XMLConstants.XMLNS_ATTRIBUTE.equals(prefix))
					return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;

				if (!mapping.containsKey(prefix))
					return XMLConstants.NULL_NS_URI;

				return mapping.get(prefix);
			}
		};
	}
}
