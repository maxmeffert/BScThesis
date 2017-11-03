package org.softlang.megal.browsing.views.tables;

import org.eclipse.swt.widgets.Composite;
import org.softlang.megal.mi2.RelationshipType;

public class RelationshipTypeTable extends AbstractTable<RelationshipType> {

	static private final String[] HEADERS = { "Name", "Domain", "Range" };
	
	public RelationshipTypeTable(Composite parent) {
		super(parent, HEADERS, new RelationshipTypeColumnAccessor());
	}

}