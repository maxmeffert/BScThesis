package org.softlang.megal.browsing.views.tables;

import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.softlang.megal.mi2.RelationshipType;

public class RelationshipTypeColumnAccessor implements IColumnAccessor<RelationshipType> {

	@Override
	public Object getDataValue(RelationshipType rowObject, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return rowObject.getName();
		case 1:
			return rowObject.getLeft().getName();
		case 2:
			return rowObject.getRight().getName();
		}
		return null;
	}

	@Override
	public void setDataValue(RelationshipType rowObject, int columnIndex, Object newValue) {
		// do nothing
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

}
