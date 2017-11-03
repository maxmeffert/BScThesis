package org.softlang.megal.browsing.views.tables;

import org.eclipse.swt.widgets.Composite;
import org.softlang.megal.mi2.EntityType;

public class EntityTypeTable extends AbstractTable<EntityType> {

	static private final String[] HEADERS = { "Name", "SuperType" };
	
	public EntityTypeTable(Composite parent) {
		super(parent, HEADERS, new EntityTypeColumnAccessor());
	}

}
