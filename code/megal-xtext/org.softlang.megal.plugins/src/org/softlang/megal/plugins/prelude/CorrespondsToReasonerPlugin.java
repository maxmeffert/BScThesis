package org.softlang.megal.plugins.prelude;

import static com.google.common.collect.Iterables.filter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.AbstractPlugin;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.ProxyableGuidedReasonerPlugin;
import org.softlang.megal.plugins.util.Prelude;

public class CorrespondsToReasonerPlugin extends ProxyableGuidedReasonerPlugin {

	public static abstract class CorrespondsToRecoveryPlugin extends AbstractPlugin {
		
		abstract public String getLeftLanguage();
		abstract public String getRightLanguage();
		abstract public Map<String,String> init(Artifact left, Artifact right);
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
		
	private boolean correspondsTo(Set<Map.Entry<String,String>> correspondences, Entity left, Entity right) {
		String leftFragmentText = left.getAnnotation("FragmentText");
		String rightFragmentText = right.getAnnotation("FragmentText");
		
		return correspondences.stream()
			.anyMatch(entry -> entry.getKey().equals(leftFragmentText) && entry.getValue().equals(rightFragmentText));
	}
	
	private void recoverFragmentCorrespondenes(Relationship relationship) {
		Entity left = relationship.getLeft();
		Entity right = relationship.getRight();
		for (CorrespondsToRecoveryPlugin plugin : filter(getParts(), CorrespondsToRecoveryPlugin.class)) {
			
			if (Prelude.isElementOfLanguage(left, plugin.getLeftLanguage())
					&& Prelude.isElementOfLanguage(right, plugin.getRightLanguage())) {
				
				Set<Map.Entry<String,String>> correspondences = plugin.init(artifactOf(left), artifactOf(right)).entrySet();
				
				for (Entity leftFragment : getFragmentsOf(left)) {
					
					for (Entity rightFragment : getFragmentsOf(right)) {
												
						if (correspondsTo(correspondences, leftFragment, rightFragment)) {
							this.relationship(leftFragment.getName(), rightFragment.getName(), "correspondsTo");
						}
						
					}
					
				}
			}
		}
	}
	
	@Override
	protected void guidedDerive(Relationship relationship) throws Throwable {
		when(relationship.getTypeName().equals("correspondsTo"));
		recoverFragmentCorrespondenes(relationship);		
	}
	
}
