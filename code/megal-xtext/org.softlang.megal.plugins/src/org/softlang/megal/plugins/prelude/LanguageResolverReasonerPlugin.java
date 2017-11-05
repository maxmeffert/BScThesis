package org.softlang.megal.plugins.prelude;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

/**
 * 
 * @author lukashaertel, maxmeffert
 *
 */
public class LanguageResolverReasonerPlugin extends GuidedReasonerPlugin {

	/**
	 * Checks whether the host of a given uri is reachable
	 * @param uri
	 * @return
	 */
	private boolean isReachable (URI uri) {
		
		Socket socket = new Socket();
		
		try {
			
			socket.connect(new InetSocketAddress(uri.getHost(),80));
			socket.close();
			
		} catch (IOException e) {
			
			System.err.println("LanguageResolver: '" + uri.getHost() + "' is not reachable!");
			System.err.println(e);
			
			return false;
			
		}
		
		return true;
		
	}
	
	private String dbpdiaURL (Entity entity) {
		
		return "http://dbpedia.org/page/" + entity.getName() + "_(programming_language)";
		
	}
	
	/**
	 * Binds a page from dbpedia.org to a given language entity
	 * @throws URISyntaxException 
	 */
	@Override
	protected void guidedDerive(Entity entity) {
		
		when(!entity.hasBinding());
		
		String url = dbpdiaURL(entity);
		
		try {
			
			URI binding = new URI(url);
			
			if (isReachable(binding) && getArtifact(binding).exists()) {
				
				binding(entity.getName(), binding);
				
			}
			
		} catch (URISyntaxException e) {
			
			System.err.println("LanguageResolver: '" + url + "' is malformed!");
			System.err.println(e);
			
		}
		
	}
}
