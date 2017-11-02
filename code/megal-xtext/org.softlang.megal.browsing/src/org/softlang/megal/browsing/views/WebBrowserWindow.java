package org.softlang.megal.browsing.views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;

import com.google.common.io.CharStreams;

import netscape.javascript.JSObject;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.eclipse.json.provisonnal.com.eclipsesource.json.JsonArray;
import org.eclipse.json.provisonnal.com.eclipsesource.json.JsonObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class WebBrowserWindow {

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			WebBrowserWindow window = new WebBrowserWindow("localhost");
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	protected Shell shlMegalTypesNetwork;
	private Browser webBrowser;

	static private class GetJSONMegamodelFunction extends BrowserFunction {

		static public final String NAME = "getJSONMegamodel";
		
		static public GetJSONMegamodelFunction register(Browser browser, KB megamodel) {
			return new GetJSONMegamodelFunction(browser, megamodel);
		}
		
		private KB megamodel;
		
		public GetJSONMegamodelFunction(Browser browser, KB megamodel) {
			super(browser, NAME);
			this.megamodel = megamodel;
		}
		
		private JsonArray entities() {
			
			JsonArray jsonEntities = new JsonArray();
			
			for(Entity entity : megamodel.getEntities()) {
				
				JsonObject jsonEntity = new JsonObject();
				jsonEntity.set("name", entity.getName());
				jsonEntity.set("type", entity.getType().getName());
				
				jsonEntities.add(jsonEntity);
				
			}
			
			return jsonEntities;
		}
		
		private JsonArray entityTypes() {
			
			JsonArray jsonEntityTypes = new JsonArray();
			
			for(EntityType entityType : megamodel.getEntityTypes()) {
				
				JsonObject jsonEntityType = new JsonObject();
				jsonEntityType.set("name", entityType.getName());
				jsonEntityType.set("supertype", entityType.getSupertype() != null ? entityType.getSupertype().getName() : "");
				
				jsonEntityTypes.add(jsonEntityType);
				
			}
			
			return jsonEntityTypes;
		}
		
		private JsonArray relationships() {
			
			JsonArray jsonRelationships = new JsonArray();
			
			for(Relationship rel : megamodel.getRelationships()) {
				
				JsonObject jsonRel = new JsonObject();
				jsonRel.set("name", rel.getTypeName());
				jsonRel.set("left", rel.getLeft().getName());
				jsonRel.set("right", rel.getRight().getName());
				
				jsonRelationships.add(jsonRel);
				
			}
			
			return jsonRelationships;
		}
		
		private JsonArray relationshipTypes() {
			
			JsonArray jsonRelationshipTypess = new JsonArray();
			
			for(RelationshipType relType : megamodel.getRelationshipTypes()) {
				
				if (relType.getName().equals("defines")) {
					System.err.println(relType);
				}
				
				JsonObject jsonRelType = new JsonObject();
				jsonRelType.set("name", relType.getName());
				jsonRelType.set("left", relType.getLeft().getName());
				jsonRelType.set("isLeftMany", relType.isLeftMany());
				jsonRelType.set("right", relType.getRight().getName());
				jsonRelType.set("isRightMany", relType.isRightMany());
				
				jsonRelationshipTypess.add(jsonRelType);
				
			}
			
			return jsonRelationshipTypess;
		}
		
		public Object function (Object[] args) {
			
			JsonObject result = new JsonObject();
			
			result.add("entities", entities());
			result.add("entityTypes", entityTypes());
			result.add("relationships", relationships());
			result.add("relationshipTypes", relationshipTypes());
			
//			File file = new File("./result.json");
//			
//			PrintStream out;
//			try {
//				out = new PrintStream(new FileOutputStream(file));
//				out.println(result.toString());
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			return result.toString();
			
		}
		
	}
	
	
	
	private String url;
	private KB megamodel;
	
	public WebBrowserWindow(String url, KB megamodel) {
		this.url = url;
		this.megamodel = megamodel;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMegalTypesNetwork.open();
		shlMegalTypesNetwork.layout();
		while (!shlMegalTypesNetwork.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlMegalTypesNetwork = new Shell();
		shlMegalTypesNetwork.setSize(450, 300);
		shlMegalTypesNetwork.setText("MegaL Types Network Graph");
		shlMegalTypesNetwork.setLayout(new GridLayout(1, false));
		
		webBrowser = new Browser(shlMegalTypesNetwork, SWT.NONE);
		webBrowser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		webBrowser.setUrl(url);
		
		GetJSONMegamodelFunction.register(webBrowser, megamodel);
		
	}
	
}
