package org.softlang.megal.browsing.views.tables;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.DefaultNatTableStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.CompositeLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.style.HorizontalAlignmentEnum;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.widgets.Composite;

public class AbstractTable<T> {
	
	private List<T> data;
	private String[] headers;
	
	private IDataProvider headerDataProvider;
	private IDataProvider bodyDataProvider;
	
	private DataLayer headerDataLayer;
	private DataLayer bodyDataLayer;
	private SelectionLayer selectionLayer;
	private ViewportLayer viewportLayer;
	private ColumnHeaderLayer columnHeaderLayer;
	private CompositeLayer compositeLayer;
	

	private NatTable natTable;
	
	public AbstractTable (Composite parent, String[] headerTitles, IColumnAccessor<T> columnAccessor) {
		
		data = new LinkedList<T>();
		
		headers = headerTitles;
		
		headerDataProvider = new ArrayHeaderDataProvider<String>(headerTitles);
		
		bodyDataProvider = new ListDataProvider<T>(data,columnAccessor);
		
        headerDataLayer = new DataLayer(headerDataProvider);
        headerDataLayer.setColumnPercentageSizing(true);
        for (int i=0; i<headerTitles.length; i++) {
        	headerDataLayer.setColumnWidthPercentageByPosition(i, 100/headerTitles.length);
        }
		
		bodyDataLayer = new DataLayer(bodyDataProvider);
		bodyDataLayer.setColumnPercentageSizing(true);
		       
		
		selectionLayer = new SelectionLayer(bodyDataLayer);
        
		viewportLayer = new ViewportLayer(selectionLayer);
        viewportLayer.setRegionName(GridRegion.BODY);
        
        
        columnHeaderLayer = new ColumnHeaderLayer(headerDataLayer, viewportLayer, selectionLayer);
        
        compositeLayer = new CompositeLayer(1, 2);
        compositeLayer.setChildLayer(GridRegion.COLUMN_HEADER, columnHeaderLayer, 0, 0);
        compositeLayer.setChildLayer(GridRegion.BODY, viewportLayer, 0, 1);
        
		natTable = new NatTable(parent, compositeLayer, false);
		
		DefaultNatTableStyleConfiguration config = new DefaultNatTableStyleConfiguration();
		config.hAlign = HorizontalAlignmentEnum.LEFT;
		
		natTable.addConfiguration(config);
		natTable.configure();
		
		GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).spacing(0, 0).applyTo(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
		
	}

	public List<T> getData() {
		return data;
	}
	
	public AbstractTable<T> addData(Collection<T> data) {
		this.data.addAll(data);
		natTable.refresh();
		return this;
	}
	
	public AbstractTable<T> setData(Collection<T> data) {
		this.data.clear();
		return addData(data);
	}

	protected String[] getHeaders() {
		return headers;
	}

	protected IDataProvider getHeaderDataProvider() {
		return headerDataProvider;
	}

	protected IDataProvider getBodyDataProvider() {
		return bodyDataProvider;
	}

	protected DataLayer getHeaderDataLayer() {
		return headerDataLayer;
	}

	protected DataLayer getBodyDataLayer() {
		return bodyDataLayer;
	}

	protected SelectionLayer getSelectionLayer() {
		return selectionLayer;
	}

	protected ViewportLayer getViewportLayer() {
		return viewportLayer;
	}

	protected ColumnHeaderLayer getColumnHeaderLayer() {
		return columnHeaderLayer;
	}

	protected CompositeLayer getCompositeLayer() {
		return compositeLayer;
	}

	protected NatTable getNatTable() {
		return natTable;
	}
	
	
	
	
}
