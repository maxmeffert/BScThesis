package org.softlang.megal.plugins.prelude;

import static com.google.common.collect.Iterables.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.AbstractPlugin;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.ProxyableGuidedReasonerPlugin;

public class ConformsToReasonerPlugin extends ProxyableGuidedReasonerPlugin {
	
	public static abstract class ConformsToRecoveryPlugin extends AbstractPlugin {
		abstract public boolean canBeAppliedTo(Entity leftEntity, Entity rightEntity);
		abstract public IBinaryRelation<String> init(Entity leftEntity, Artifact leftArtifact, Entity rightEntity, Artifact rightArtifact);
	}
	
	@Override
	public boolean isContextBased () {
		return true;
	}
	
	private List<Entity> getFragmentsOf(Entity entity) {
		return entity.getKB().getRelationships().stream()
				.filter(r -> r.getTypeName().equals("fragmentOf"))
				.filter(r -> r.getRight().getName().equals(entity.getName()))
				.map(r -> r.getLeft())
				.collect(Collectors.toList());
	}
		
	private boolean conformsTo(IBinaryRelation<String> conformances, Entity left, Entity right) {
		return conformances.stream()
			.anyMatch(entry -> entry.getFirst().equals(left.getName()) 
					&& entry.getSecond().equals(right.getName()));
	}
	
	private void recoverFragmentConformances(Relationship relationship) {
		Entity left = relationship.getLeft();
		Entity right = relationship.getRight();
		for (ConformsToRecoveryPlugin plugin : filter(getParts(), ConformsToRecoveryPlugin.class)) {
			
			if (plugin.canBeAppliedTo(left, right)) {
				
				IBinaryRelation<String> conformances = plugin.init(left, artifactOf(left), right, artifactOf(right));
								
				for (Entity leftFragment : getFragmentsOf(left)) {
					
					for (Entity rightFragment : getFragmentsOf(right)) {
												
						if (conformsTo(conformances, leftFragment, rightFragment)) {
							this.relationship(leftFragment.getName(), rightFragment.getName(), "conformsTo");
						}
						
					}
					
				}
			}
		}
	}
	
	@Override
	protected void guidedDerive(Relationship relationship) throws Throwable {
		when(relationship.getTypeName().equals("conformsTo"));
		recoverFragmentConformances(relationship);		
	}
	
}
