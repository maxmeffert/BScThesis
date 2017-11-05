package org.softlang.megal.plugins.prelude;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Ref;

import static com.google.common.collect.Maps.immutableEntry;
import static com.google.common.collect.Iterables.filter;

import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;

import java.util.stream.Collectors;

import org.softlang.megal.plugins.api.FragmentizerPlugin;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.softlang.megal.plugins.api.IFragmentReasoner;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;

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
	
	private void entityAnnotation(Entity e, String name, String value) {
		
		KB kb = e.getKB();
		Ref ref = kb.getRawEntities().get(e.getName());
		
		kb.getRawEntityAnnotations().put(immutableEntry(e.getName(), ref), immutableEntry(name, value));
		
	}
	
	/**
	 * Inserts a bag of fragments into the KB
	 * @param fs
	 */
	private void deriveFragments (Iterable<Fragment> fs, String lang) {
		
		for (Fragment f : fs) {
			deriveFragments(f, lang);
			
		}
		
	}
	
	/**
	 * Inserts a fragment into the KB
	 * @param f
	 */
	private void deriveFragments (Fragment f, String lang) {
		
		// Create an entity for the fragment with its qualified name
		entityType(f.getType(), "Fragment");
		Entity e = entity(f.getQualifiedName(), f.getType());
//		System.err.println(e);
		entityAnnotation(e, "FragmentText", f.getText());
		relationship(e.getName(), lang, "elementOf");
		
		// Bind the fragment entity to the fragment's URI
		binding(f.getQualifiedName(), f.getURI());
		
		// Insert the parts of the fragments into the KB
		deriveFragments(f.getParts(), lang);
		
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
//					deriveFragments(plugin.getFragments(entity, artifactOf(entity)), lang.getName());
					
				}
				
			}
			
			
		}
		
		
	}
	
	public boolean isContextBased () {
		return true;
	}
	
	
	
}
