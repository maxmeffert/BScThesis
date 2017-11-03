package org.softlang.megal.browsing.server;

import java.io.IOException;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.softlang.megal.mi2.KB;


public class MegamodelServer implements Runnable {

//	static public void main(String[] args) {
//		new Thread(new HttpServer()).start();
//	}
	
	static public int DEFAULT_PORT = 9999;
	static public String DEFAULT_STATIC_CONTENT_PATH = "./server";
	
	
	private int port;
	private String staticContentPath;
	private Server server;
	private ResourceConfig resourceConfig;
	private MegamodelProvider megamodelProvider;
	private MegamodelProviderFactory megamodelProviderFactory;
	
	public MegamodelServer() throws IOException {
		this(DEFAULT_PORT, DEFAULT_STATIC_CONTENT_PATH);
	}
	
	public MegamodelServer(int port, String staticContentPath) throws IOException {

		this.port = port;
		this.staticContentPath = staticContentPath;
		
	    server = new Server(port);
	    
	    megamodelProvider = new MegamodelProvider();
	    megamodelProviderFactory = new MegamodelProviderFactory(megamodelProvider);
	    
		resourceConfig = new ResourceConfig()
		.register(MegamodelService.class)
		.register(GsonMessageBodyHandler.class)
		.register(new AbstractBinder() {

			@Override
			protected void configure() {
				bindFactory(megamodelProviderFactory).to(MegamodelProvider.class);
			}
			
		});
		
		ServletHolder servletHolder = new ServletHolder(new ServletContainer(resourceConfig));
		
		ServletContextHandler restContextHandler = new ServletContextHandler(server, "/rest", ServletContextHandler.NO_SESSIONS);
		restContextHandler.addServlet(servletHolder, "/*");
		
		
		ResourceHandler resourceHandler = new ResourceHandler();
	    resourceHandler.setDirectoriesListed(true);
	    resourceHandler.setWelcomeFiles(new String[]{ "index.html" });
	    
	    Resource staticContents = Resource.newResource(getClass().getClassLoader().getResource(staticContentPath));
	    
//	    if (!staticContents.exists()) {
//	    	throw new IOException("'" + staticContentPath + "' does not exist!");
//	    }
	    		
	    resourceHandler.setBaseResource(staticContents);
	    
	    
	    ContextHandler staticContextHandler = new ContextHandler("/");
	    staticContextHandler.setHandler(resourceHandler);
	    
	    
	    HandlerList handlers = new HandlerList();
	    handlers.setHandlers(new Handler[] {  
	    		restContextHandler,
	    		staticContextHandler, 
//	    		new DefaultHandler()
	    		});
	    
	    
	    server.setHandler(handlers);
	    
	   
	}
	
	
	
	protected static int getDEFAULT_PORT() {
		return DEFAULT_PORT;
	}

	protected static String getDEFAULT_STATIC_CONTENT_PATH() {
		return DEFAULT_STATIC_CONTENT_PATH;
	}

	protected int getPort() {
		return port;
	}

	protected String getStaticContentPath() {
		return staticContentPath;
	}

	protected Server getServer() {
		return server;
	}

	protected ResourceConfig getResourceConfig() {
		return resourceConfig;
	}

	protected MegamodelProvider getMegamodelProvider() {
		return megamodelProvider;
	}

	public void setMegamodel(KB megamodel) {
		getMegamodelProvider().setMegamodel(megamodel);
	}
	
	public String getAddress() {
		return "http://localhost:" + port;
	}
	
	@Override
	public void run() {
		
		try {
			server.start();
			server.join();
		} catch (InterruptedException e1) {
//			server.destroy();
			e1.printStackTrace();
		} catch (Exception e1) {
//			server.destroy();
			e1.printStackTrace();
		} 
		
	}

}
