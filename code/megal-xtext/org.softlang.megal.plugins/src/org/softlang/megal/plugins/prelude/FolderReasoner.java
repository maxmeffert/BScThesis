package org.softlang.megal.plugins.prelude;

import java.io.File;
import java.net.URI;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.softlang.megal.plugins.util.Prelude;

/**
 * Derives elements of a folder to the model, bound to their respective location
 * 
 * @author maxmeffert
 *
 */
public class FolderReasoner extends GuidedReasonerPlugin {
	
	/**
	 * Derives elements of a folder, bound to their respective location
	 */
	@Override
	protected void guidedDerive(Entity entity) {
		
		// Check whether the given entity is declared as Folder and bound to a directory
		when(Prelude.isFolder(entity)
				&& entity.hasBinding()
				&& artifactOf(entity).toFile().isDirectory());
		
		try {
			
			// For all elements of the folder
			for (File element : artifactOf(entity).toFile().listFiles()) {
				
				// Get the normalized entity name of the element
				String name = entity.getName() + "." + element.getName().replace(".", "_");
				
				// Get the entity type of the element
				// The FOLDER type will trigger derivation, so sub-folders will also be derived
				String type = element.isDirectory() ? Prelude.FOLDER : Prelude.FILE;
				
				// Insert a new entity for the element
				entity(name, type);
				
				// Bind the entity to it element location
				binding(name, new URI("file:"+element.getAbsolutePath()));
				
			}
			
		} catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		
	}

}
