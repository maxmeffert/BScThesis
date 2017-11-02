package org.softlang.megal.plugins.prelude;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.softlang.megal.plugins.util.Prelude;


/**
 * 
 * Derives the elementOf-Language relationship for bound entities by the file extension of the binding URI.
 * 
 * <p>
 * </p>
 * <pre>
 * &#x0040;FileExtension '.java'
 * Java : Langauge
 * 
 * aFile : File
 * aFile = '/path/to/some/java/file.java'
 * </pre>
 * 
 * @author maxmeffert
 *
 */
public class FileExtensionLanguageReasoner extends GuidedReasonerPlugin {
	
	/**
	 * The annotation name for file extensions
	 */
	static final private String ANNOTATION = "FileExtensions";
	
	/**
	 * 
	 * Gets the set of declared file extensions for a given language entity
	 * 
	 * @param language The given language entity
	 * @return The set of declared file extensions
	 */
	static private Set<String> extensions (Entity language) {
		
		if (Prelude.isLanguage(language) 
				&& language.hasAnnotation(ANNOTATION)) {
			
			return Arrays.asList(language.getAnnotation(ANNOTATION).split(",")).stream()
					.map( s -> s.trim() )
					.map( s -> s.startsWith(".") ? s : "." + s )
					.collect(Collectors.toSet());
			
		}
		
		return Collections.emptySet();
		
	}
	
	static private boolean endsWithExtension(File file, String extension) {
		
		return file.getPath().toLowerCase().endsWith(extension.toLowerCase());
		
	}
	
	/**
	 * 
	 */
	@Override
	protected void guidedDerive(Entity entity) {
		
		when(Prelude.isFile(entity) 
				&& entity.hasBinding()
				&& artifactOf(entity).toFile().isFile());
		
		try {
			
			File file = artifactOf(entity).toFile();			
			
			for (Entity language : Prelude.getLanguages(entity.getKB())) {
				
				for (String extension : extensions(language)) {
					
					if (endsWithExtension(file, extension)) {
						
						relationship(entity.getName(), language.getName(), "elementOf");
						
					}
					
				}
				
			}
			
			
			
		}
		catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		
	}

}
