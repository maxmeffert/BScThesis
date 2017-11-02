package org.softlang.megal.browsing.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MegaLBrowserComposite extends Composite {
	private TabFolder tabsMegamodelBrowser;
	private Text textMegamodelURI;
	private Composite tbtmEntitiesComposite;
	private Composite tbtmEnctityTypesComposite;
	private Composite tbtmRelationshipsComposite;
	private Composite tbtmRelationshipTypesComposite;
	private Button btnEvaluate;
	private ProgressBar progressBar;
	private Label lblNewLabel;
	private Composite entityTableComposite;
	private ToolBar toolBar;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MegaLBrowserComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(4, false));
		
		toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
		
		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.setText("New Item");
		
		ToolItem tltmDropdownItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmDropdownItem.setText("DropDown Item");
		new Label(this, SWT.NONE);
		
		lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Megamodel:");
		
		textMegamodelURI = new Text(this, SWT.BORDER);
		textMegamodelURI.setEditable(false);
		textMegamodelURI.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnEvaluate = new Button(this, SWT.NONE);
		btnEvaluate.setText("Evaluate");
		new Label(this, SWT.NONE);
		
		progressBar = new ProgressBar(this, SWT.NONE);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		tabsMegamodelBrowser = new TabFolder(this, SWT.NONE);
		GridData gd_tabsMegamodelBrowser = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
		gd_tabsMegamodelBrowser.heightHint = 259;
		gd_tabsMegamodelBrowser.widthHint = 436;
		tabsMegamodelBrowser.setLayoutData(gd_tabsMegamodelBrowser);
		
		TabItem tbtmEntities = new TabItem(tabsMegamodelBrowser, SWT.NONE);
		tbtmEntities.setImage(null);
		tbtmEntities.setText("Entities");
		
		tbtmEntitiesComposite = new Composite(tabsMegamodelBrowser, SWT.NONE);
		tbtmEntities.setControl(tbtmEntitiesComposite);
		tbtmEntitiesComposite.setLayout(new GridLayout(1, false));
		
		entityTableComposite = new Composite(tbtmEntitiesComposite, SWT.NONE);
		entityTableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		
		
		TabItem tbtmEntityTypes = new TabItem(tabsMegamodelBrowser, SWT.NONE);
		tbtmEntityTypes.setText("EntityTypes");
		
		tbtmEnctityTypesComposite = new Composite(tabsMegamodelBrowser, SWT.NONE);
		tbtmEntityTypes.setControl(tbtmEnctityTypesComposite);
		
		TabItem tbtmRelationships = new TabItem(tabsMegamodelBrowser, SWT.NONE);
		tbtmRelationships.setText("Relationships");
		
		tbtmRelationshipsComposite = new Composite(tabsMegamodelBrowser, SWT.NONE);
		tbtmRelationships.setControl(tbtmRelationshipsComposite);
		
		TabItem tbtmRelationshipTypes = new TabItem(tabsMegamodelBrowser, SWT.NONE);
		tbtmRelationshipTypes.setText("RelationshipTypes");
		
		tbtmRelationshipTypesComposite = new Composite(tabsMegamodelBrowser, SWT.NONE);
		tbtmRelationshipTypes.setControl(tbtmRelationshipTypesComposite);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public TabFolder getTabFolder() {
		return tabsMegamodelBrowser;
	}
	public Text getTextMegamodelURI() {
		return textMegamodelURI;
	}
	public Composite getTbtmEntitiesComposite() {
		return tbtmEntitiesComposite;
	}
	public Composite getTbtmEnctityTypesComposite() {
		return tbtmEnctityTypesComposite;
	}
	public Composite getTbtmRelationshipsComposite() {
		return tbtmRelationshipsComposite;
	}
	public Composite getTbtmRelationshipTypesComposite() {
		return tbtmRelationshipTypesComposite;
	}
	public Button getBtnEvaluate() {
		return btnEvaluate;
	}
	public ProgressBar getProgressBar() {
		return progressBar;
	}
	public Composite getEntityTableComposite() {
		return entityTableComposite;
	}
	public ToolBar getToolBar() {
		return toolBar;
	}
}
