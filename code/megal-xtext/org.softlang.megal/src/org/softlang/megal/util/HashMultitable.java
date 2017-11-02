package org.softlang.megal.util;

import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class HashMultitable<R, C, E> extends AbstractMultitable<R, C, E> {
	final Table<R, C, Set<E>> table;

	public HashMultitable() {
		this.table = HashBasedTable.create();
	}

	@Override
	public Table<R, C, Set<E>> asTable() {
		return table;
	}

	public static <R, C, E> HashMultitable<R, C, E> create() {
		return new HashMultitable<R, C, E>();
	}
}
