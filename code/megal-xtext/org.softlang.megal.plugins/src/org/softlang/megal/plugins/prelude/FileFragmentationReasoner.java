package org.softlang.megal.plugins.prelude;

import org.softlang.megal.mi2.Entity;
import static com.google.common.collect.Iterables.filter;

import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;

import org.softlang.megal.plugins.api.FragmentizerPlugin;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.softlang.megal.plugins.api.IFragmentReasoner;

/**
 * 
 * Reasoner plugin for file fragmentation
 * 
 * @author maxmeffert
 *
 */
public class FileFragmentationReasoner extends GuidedReasonerPlugin {
	
	private class FragmentReasoner implements IFragmentReasoner {

		@Override
		public void addEntityType(String type, String superType) {
			FileFragmentationReasoner.this.entityType(type, superType);
		}

		@Override
		public void addEntity(String name, String type) {
			FileFragmentationReasoner.this.entity(name, type);
		}

		@Override
		public void addRelationshipType(String name, String leftType, String rightType) {
			FileFragmentationReasoner.this.relationshipType(leftType, rightType, name);
		}

		@Override
		public void addRelationship(String name, String left, String right) {
			FileFragmentationReasoner.this.relationship(left, right, name);			
		}
		
	}
	
	/**
	 * Derives fragments of an entity
	 */
	@Override
	protected void guidedDerive(Entity entity) throws Throwable {
		
		// For all partial fragmentation plugins
		for (FragmentizerPlugin plugin : filter(getParts(), FragmentizerPlugin.class)) {
			
			// WHAT TO DO IF plugin REALIZES MULTIPLE LANGUAGES ????
			
			for(Entity lang : plugin.getRealization()) {
				
				
				if (isElementOfLanguage(entity, lang)) {
					plugin.derive(new FragmentReasoner(), entity, artifactOf(entity));					
				}
				
			}
			
			
		}
		
		
	}
	
	public boolean isContextBased () {
		return true;
	}
	
	
	
}
