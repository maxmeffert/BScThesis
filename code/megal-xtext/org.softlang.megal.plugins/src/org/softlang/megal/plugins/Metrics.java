package org.softlang.megal.plugins;

import org.softlang.megal.mi2.KB;
import org.softlang.megal.plugins.util.Prelude;

public class Metrics {

	public static int getElementCount(KB kb) {
		return kb.getElements().size();
	}
	
	public static int getEntityTypeCount(KB kb) {
		return kb.getEntityTypes().size();
	}
	
	public static int getEntityCount(KB kb) {
		return kb.getEntities().size();
	}
	
	public static long getEntityCount(KB kb, String type) {
		return kb.getEntities().stream()
				.filter(e -> Prelude.isInstance(e, type))
				.count();
	}
	
	public static int getRelationshipTypeCount(KB kb) {
		return kb.getRelationshipTypes().size();
	}
	
	public static int getRelationshipCount(KB kb) {
		return kb.getRelationships().size();
	}
			
	public static long getRelationshipCount(KB kb, String relationship) {
		return kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship))
				.count();
	}
	
	public static long getRelationshipCount(KB kb, String relationship, String left, String right) {
		return kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship)
						&& (left == null || r.getLeft().getName().equals(left))
						&& (right == null || r.getRight().getName().equals(right)))
				.count();
	}
	
	public static long getRelationshipLeftCount(KB kb, String relationship, String right) {
		return kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship)
						&& (right == null || r.getRight().getName().equals(right)))
				.map(r -> r.getLeft())
				.distinct()
				.count();
	}
	
	public static long getRelationshipFragmentCount(KB kb, String relationship, String left, String right) {
		return kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship)
						&& kb.getRelationships().stream().anyMatch(rr -> rr.getTypeName().equals("fragmentOf")
								&& rr.getLeft().getName().equals(r.getLeft().getName())
								&& rr.getRight().getName().equals(left))
						&& kb.getRelationships().stream().anyMatch(rr -> rr.getTypeName().equals("fragmentOf")
								&& rr.getLeft().getName().equals(r.getRight().getName())
								&& rr.getRight().getName().equals(right)))
				.count();
	}
	
	public static long getRelationshipFragmentLeftCount(KB kb, String relationship, String right) {
		return kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship)
						&& kb.getRelationships().stream().anyMatch(rr -> rr.getTypeName().equals("fragmentOf")
								&& rr.getLeft().getName().equals(r.getRight().getName())
								&& rr.getRight().getName().equals(right)))
				.map(r -> r.getLeft())
				.distinct()
				.count();
	}
	
	public static long getRelationshipFragmentRightCount(KB kb, String relationship, String left) {
		return kb.getRelationships().stream()
				.filter(r -> r.getTypeName().equals(relationship)
						&& kb.getRelationships().stream().anyMatch(rr -> rr.getTypeName().equals("fragmentOf")
								&& rr.getLeft().getName().equals(r.getLeft().getName())
								&& rr.getRight().getName().equals(left)))
				.map(r -> r.getRight())
				.distinct()
				.count();
	}
	
}
