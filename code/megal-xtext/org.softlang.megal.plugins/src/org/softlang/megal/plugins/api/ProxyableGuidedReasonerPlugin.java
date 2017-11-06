package org.softlang.megal.plugins.api;

import java.net.URI;

public abstract class ProxyableGuidedReasonerPlugin extends GuidedReasonerPlugin {

	private class ReasonerProxy implements IGuidedReasonerProxy {

		private final GuidedReasonerPlugin reasoner = ProxyableGuidedReasonerPlugin.this;
		
		@Override
		public void addEntityType(String type, String superType) {
			reasoner.entityType(type, superType);
		}

		@Override
		public void addEntity(String name, String type) {
			reasoner.entity(name, type);
		}

		@Override
		public void addRelationshipType(String name, String leftType, String rightType) {
			reasoner.relationshipType(leftType, rightType, name);
		}

		@Override
		public void addRelationship(String name, String left, String right) {
			reasoner.relationship(left, right, name);			
		}

		@Override
		public void addBinding(String entityName, URI binding) {
			reasoner.binding(entityName, binding);
			
		}

		@Override
		public void addEntityAnnotation(String entity, String annotationName, String annotationValue) {
			reasoner.entityAnnotation(entity, annotationName, annotationValue);
		}
		
	}
	
	protected final IGuidedReasonerProxy getReasonerProxy() {
		return new ReasonerProxy();
	}
	
}
