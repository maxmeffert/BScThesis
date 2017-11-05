package org.softlang.megal.plugins.prelude;

import org.softlang.megal.mi2.Entity;
import static com.google.common.collect.Iterables.filter;

import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;

import org.softlang.megal.plugins.api.FragmentRecoveryPlugin;
import org.softlang.megal.plugins.api.ProxyableGuidedReasonerPlugin;

/**
 * 
 * Reasoner plugin for file fragmentation
 * 
 * @author maxmeffert
 *
 */
public class FileFragmentRecoveryReasoner extends ProxyableGuidedReasonerPlugin {
	
	/**
	 * Derives fragments of an entity
	 */
	@Override
	protected void guidedDerive(Entity entity) throws Throwable {
		
		// For all partial fragmentation plugins
		for (FragmentRecoveryPlugin plugin : filter(getParts(), FragmentRecoveryPlugin.class)) {
			
			// WHAT TO DO IF plugin REALIZES MULTIPLE LANGUAGES ????
			
			for(Entity lang : plugin.getRealization()) {
								
				if (isElementOfLanguage(entity, lang)) {
					plugin.derive(this.getReasonerProxy(), entity, artifactOf(entity));					
				}
				
			}
						
		}
				
	}
	
	public boolean isContextBased () {
		return true;
	}
	
	
	
}
