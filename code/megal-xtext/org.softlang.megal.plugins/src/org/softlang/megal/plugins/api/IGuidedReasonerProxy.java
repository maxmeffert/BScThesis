package org.softlang.megal.plugins.api;

import java.net.URI;

public interface IGuidedReasonerProxy {
	void addEntityType(String type, String superType);
	void addEntity(String name, String type);
	void addRelationshipType(String name, String leftType, String rightType);
	void addRelationship(String name, String left, String right);
	void addBinding(String entityName, URI binding);
}
