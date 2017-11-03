package org.softlang.megal.browsing.editors;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.softlang.megal.browsing.eval.MegalEvaluator;
import org.softlang.megal.browsing.server.MegamodelServer;
import org.softlang.megal.browsing.views.MegaLBrowserComposite;
import org.softlang.megal.browsing.views.WebBrowserWindow;
import org.softlang.megal.browsing.views.tables.EntityTable;
import org.softlang.megal.browsing.views.tables.EntityTypeTable;
import org.softlang.megal.browsing.views.tables.RelationshipTable;
import org.softlang.megal.browsing.views.tables.RelationshipTypeTable;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;

public class MegalExplorer extends EditorPart  {

	private IEditorSite site;
	private IEditorInput input;
	
	private MegaLBrowserComposite browser;
	private EntityTable entityTable;
	private EntityTypeTable entityTypeTable;
	private RelationshipTable relationshipTable;
	private RelationshipTypeTable relationshipTypeTable;

	private MegamodelServer httpServer;
	
	private KB megamodel;
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// do nothing
	}

	@Override
	public void doSaveAs() {
		// do nothing
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
		browser.setFocus();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		this.setSite(site);
		this.setInput(input);
		
	}

	@Override
	public void createPartControl(Composite parent) {
		
		browser = new MegaLBrowserComposite(parent,SWT.NONE);
		entityTable = new EntityTable(browser.getEntityTableComposite());
		entityTypeTable = new EntityTypeTable(browser.getTbtmEnctityTypesComposite());
		relationshipTable = new RelationshipTable(browser.getTbtmRelationshipsComposite());
		relationshipTypeTable = new RelationshipTypeTable(browser.getTbtmRelationshipTypesComposite());
	
		browser.getTextMegamodelURI().setText(getEditorInput().getAdapter(IFile.class).getLocationURI().toString());
		
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
		
		try {
			httpServer = new MegamodelServer();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread server = new Thread(httpServer);
		server.start();
		
	}

	private void evaluate() {
		IFile file = this.getEditorInput().getAdapter(IFile.class);

		System.out.println(file.getLocationURI());
		MegalEvaluator ev = new MegalEvaluator(file);
		final Thread worker = new Thread(ev);
		final ProgressBar bar = browser.getProgressBar();
		final Display display = browser.getDisplay();
		
		bar.setSelection(0);
		
		display.timerExec(100, new Runnable() {
			int i = 0;
			@Override
			public void run() {
				System.out.println(worker.isAlive());
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
					
					httpServer.setMegamodel(megamodel);
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
		
		
	}

	

	

	

}
