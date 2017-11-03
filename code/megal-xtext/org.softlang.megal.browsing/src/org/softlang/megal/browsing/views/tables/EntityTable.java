package org.softlang.megal.browsing.views.tables;

import org.eclipse.swt.widgets.Composite;
import org.softlang.megal.mi2.Entity;

public class EntityTable extends AbstractTable<Entity> {

	static private final String[] HEADERS = { "Name", "Type", "Binding" };
	
	public EntityTable (Composite parent) {
		super(parent, HEADERS, new EntityColumnAccessor());
	}

}
