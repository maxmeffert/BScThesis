package org.softlang.megal.browsing.views.tables;

import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.softlang.megal.mi2.EntityType;

public class EntityTypeColumnAccessor implements IColumnAccessor<EntityType> {

	public final int COLUMN_COUNT = 2;
	
	@Override
	public Object getDataValue(EntityType rowObject, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return rowObject.getName();
		case 1:
			return rowObject.getSupertype() != null ? rowObject.getSupertype().getName() : "";
		}
		return null;
	}

	@Override
	public void setDataValue(EntityType rowObject, int columnIndex, Object newValue) {
		// do nothing
	}

	@Override
	public int getColumnCount() {
		return COLUMN_COUNT;
	}

}
