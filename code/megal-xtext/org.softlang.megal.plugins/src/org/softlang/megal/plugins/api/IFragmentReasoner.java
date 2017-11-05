package org.softlang.megal.plugins.api;

public interface IFragmentReasoner {
	void addEntityType(String type, String superType);
	void addEntity(String name, String type);
	void addRelationshipType(String name, String leftType, String rightType);
	void addRelationship(String name, String left, String right);
}
