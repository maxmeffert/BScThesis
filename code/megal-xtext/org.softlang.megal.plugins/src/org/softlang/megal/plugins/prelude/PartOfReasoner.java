package org.softlang.megal.plugins.prelude;

import java.util.HashSet;
import java.util.Set;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

public class PartOfReasoner extends GuidedReasonerPlugin {
	
	private Set<String> cache = new HashSet<String>();
	
	@Override
	protected void guidedDerive(Entity entity) throws Throwable {
//		System.err.println("PartOF: " + entity.getName());
		when(entity.getName().contains(".") && !cache.contains(entity.getName()));
		
		cache.add(entity.getName());
		
		String name = entity.getName();
		
		while (name.contains(".")) {
			
			name = name.substring(0, name.lastIndexOf("."));
			
			boolean contains = entity.getKB().getRawEntities().containsKey(name);
			
			
			if (contains) {
				
				relationship(entity.getName(), name, "partOf");
				
			}
			
			
		}
		
		
		
		
	}
	
	public boolean isContextBased () {
		return false;
	}
}
