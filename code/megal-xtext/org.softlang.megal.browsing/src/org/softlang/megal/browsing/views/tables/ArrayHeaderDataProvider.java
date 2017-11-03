package org.softlang.megal.browsing.views.tables;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;

public class ArrayHeaderDataProvider<T> implements IDataProvider {

	private T[] headers;
	
	public ArrayHeaderDataProvider(T[] headers) {
		this.headers = headers;
	}
	
	@Override
	public Object getDataValue(int columnIndex, int rowIndex) {
		return headers[columnIndex];
	}

	@Override
	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		// do nothing
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public int getRowCount() {
		return 1;
	}
	
}
