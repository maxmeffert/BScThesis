package org.softlang.megal.browsing.views.tables;

import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.softlang.megal.mi2.Entity;

public class EntityColumnAccessor implements IColumnAccessor<Entity> {

	public Object getDataValue(Entity rowObject, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return rowObject.getName();
		case 1:
			return rowObject.getType().getName();
		case 2:
			return rowObject.hasBinding() ? rowObject.getBinding().toString() : "";
		}
		return null;
	}

	@Override
	public void setDataValue(Entity rowObject, int columnIndex, Object newValue) {
		// do nothing
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
}
