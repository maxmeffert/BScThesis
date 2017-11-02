package org.softlang.megal.browsing.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.PlatformUI;
import org.softlang.megal.browsing.eval.MegalEvaluator;
import org.softlang.megal.browsing.server.MegamodelServer;
import org.softlang.megal.browsing.views.tables.EntityTable;
import org.softlang.megal.browsing.views.tables.EntityTypeTable;
import org.softlang.megal.browsing.views.tables.RelationshipTable;
import org.softlang.megal.browsing.views.tables.RelationshipTypeTable;
import org.softlang.megal.language.Megals;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.ModelExecutor;
import org.softlang.megal.mi2.api.resolution.ProjectResolution;

import com.google.common.io.CharStreams;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class MegalBrowserView extends AbstractMegalAwareView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "testplugin.views.SampleView";
	
	private IFile file;
	
	private MegaLBrowserComposite browser;
	private EntityTable entityTable;
	private EntityTypeTable entityTypeTable;
	private RelationshipTable relationshipTable;
	private RelationshipTypeTable relationshipTypeTable;

	private MegamodelServer httpServer;
	
	private KB megamodel;
	
	/**
	 * The constructor.
	 */
	public MegalBrowserView() {
		try {
			httpServer = new MegamodelServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread server = new Thread(httpServer);
		server.start();
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		browser = new MegaLBrowserComposite(parent,SWT.NONE);
		entityTable = new EntityTable(browser.getEntityTableComposite());
		entityTypeTable = new EntityTypeTable(browser.getTbtmEnctityTypesComposite());
		relationshipTable = new RelationshipTable(browser.getTbtmRelationshipsComposite());
		relationshipTypeTable = new RelationshipTypeTable(browser.getTbtmRelationshipTypesComposite());
		
//		Browser webbrowser = new Browser(browser.getEntityTableComposite(), SWT.WEBKIT);
//		webbrowser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		
//		String html;
//		try {
//			html = CharStreams.toString(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("/html/test.html")));
//			webbrowser.setText(html);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		browser.getBtnEvaluate().addMouseListener(new MouseAdapter(){
			
			@Override
			public void mouseDown(MouseEvent e) {
				evaluate();
			}
			
		});
		
		
		browser.getToolBar().getItem(0).addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WebBrowserWindow win = new WebBrowserWindow(httpServer.getAddress() + "/index.html", megamodel);
				win.open();
			}
		});
		
		
		
	}
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		browser.setFocus();
	}

	private void evaluate() {
		
		MegalEvaluator ev = new MegalEvaluator(file);
		final Thread worker = new Thread(ev);
		final ProgressBar bar = browser.getProgressBar();
		final Display display = browser.getDisplay();
		
		bar.setSelection(0);
		
		display.timerExec(100, new Runnable() {
			int i = 0;
			@Override
			public void run() {
				if (bar.isDisposed() || !worker.isAlive()) {
					KB kb = ev.getResult().getOutput();
					
					megamodel = kb;
					
					List<Entity> entities = kb.getEntities().stream()
							.sorted( (a,b) -> a.getName().compareToIgnoreCase(b.getName()) )
							.collect(Collectors.toList());
					
					List<EntityType> entityTypes = kb.getEntityTypes().stream()
							.sorted( (a,b) -> a.getName().compareToIgnoreCase(b.getName()) )
							.collect(Collectors.toList());
					
					List<Relationship> relationships = kb.getRelationships().stream()
							.sorted( (a,b) -> a.getType().getName().compareToIgnoreCase(b.getType().getName()) )
							.collect(Collectors.toList());

					List<RelationshipType> relationshipTypes = kb.getRelationshipTypes().stream()
							.sorted( (a,b) -> a.getName().compareToIgnoreCase(b.getName()) )
							.collect(Collectors.toList());
					
					entityTable.setData(entities);
					entityTypeTable.setData(entityTypes);
					relationshipTable.setData(relationships);
					relationshipTypeTable.setData(relationshipTypes);
					bar.setSelection(bar.getMaximum());
					return;
				}
				bar.setSelection(i++);
				if (i <= bar.getMaximum()) display.timerExec(100, this);
			}
		});
		
		worker.start();
		
		
		
		
		
//		File megalFile = new File(file.getRawLocationURI());
//				
//		try {
//			
//			KB kb =  MegamodelKB.loadAll(Megals.load(megalFile, megalFile.getParentFile().listFiles()));
//			ModelExecutor ex = new ModelExecutor();
//			
//			kb = ex.evaluate(new ProjectResolution(){
//
//				@Override
//				protected IProject getProject() {
//					return file.getProject();
//				} 
//
//			}, kb).getOutput();
//			
			
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	
	
	@Override
	void megalFileChanged(IFile file) {
		
		browser.getTextMegamodelURI().setText(file.getLocationURI().toString());
		this.file = file;
		
	}
}
