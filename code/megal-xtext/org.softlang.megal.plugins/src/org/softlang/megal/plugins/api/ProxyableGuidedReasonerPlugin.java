package org.softlang.megal.plugins.api;

public abstract class ProxyableGuidedReasonerPlugin extends GuidedReasonerPlugin {

	private class ReasonerProxy implements IGuidedReasonerProxy {

		@Override
		public void addEntityType(String type, String superType) {
			ProxyableGuidedReasonerPlugin.this.entityType(type, superType);
		}

		@Override
		public void addEntity(String name, String type) {
			ProxyableGuidedReasonerPlugin.this.entity(name, type);
		}

		@Override
		public void addRelationshipType(String name, String leftType, String rightType) {
			ProxyableGuidedReasonerPlugin.this.relationshipType(leftType, rightType, name);
		}

		@Override
		public void addRelationship(String name, String left, String right) {
			ProxyableGuidedReasonerPlugin.this.relationship(left, right, name);			
		}
		
	}
	
	protected final IGuidedReasonerProxy getReasonerProxy() {
		return new ReasonerProxy();
	}
	
}
