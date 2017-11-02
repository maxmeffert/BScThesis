package org.softlang.megal.browsing.views.tables;

import org.eclipse.swt.widgets.Composite;
import org.softlang.megal.mi2.Relationship;

public class RelationshipTable extends AbstractTable<Relationship> {

	static private final String[] HEADERS = { "Name", "Left", "Right" };
	
	public RelationshipTable(Composite parent) {
		super(parent, HEADERS, new RelationshipColumnAccessor());
	}

}
