package org.softlang.megal.util;

import java.util.Set;

import com.google.common.collect.ImmutableTable;

public class ImmutableMultitable<R, C, E> extends AbstractMultitable<R, C, E> {
	private ImmutableTable<R, C, Set<E>> table;

	private ImmutableMultitable(ImmutableTable<R, C, Set<E>> table) {
		this.table = table;
	}

	@Override
	public ImmutableTable<R, C, Set<E>> asTable() {
		return table;
	}

	public static <R, C, E> ImmutableMultitable<R, C, E> of() {
		return new ImmutableMultitable<R, C, E>(ImmutableTable.of());
	}

	public static <R, C, E> ImmutableMultitable<R, C, E> of(R rowKey, C columnKey, Set<E> values) {
		return new ImmutableMultitable<R, C, E>(ImmutableTable.of(rowKey, columnKey, values));
	}
}
