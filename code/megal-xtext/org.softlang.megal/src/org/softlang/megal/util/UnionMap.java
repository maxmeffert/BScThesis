package org.softlang.megal.util;

import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Lists.reverse;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class UnionMap<K, V> extends AbstractMap<K, V> {
	private final Map<K, V> first;

	private final Map<K, V> second;

	public UnionMap(Map<K, V> first, Map<K, V> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int size() {
		int firstSize = first.size();
		int secondSize = Sets.difference(second.keySet(), first.keySet()).size();
		return firstSize + secondSize;
	}

	@Override
	public boolean isEmpty() {
		return first.isEmpty() && second.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return first.containsKey(key) || second.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return first.containsValue(value) || second.containsValue(value);
	}

	private List<Map<K, V>> select(Object element) {
		boolean firstContains = first.containsKey(element);
		boolean secondContains = second.containsKey(element);

		if (firstContains && secondContains)
			return ImmutableList.of(first, second);

		if (firstContains)
			return ImmutableList.of(first);

		if (secondContains)
			return ImmutableList.of(second);

		return ImmutableList.of();
	}

	@Override
	public V get(Object key) {
		for (Map<K, V> container : select(key))
			return container.get(key);

		return null;
	}

	@Override
	public V put(K key, V value) {
		for (Map<K, V> container : select(key))
			return container.put(key, value);

		return first.put(key, value);
	}

	@Override
	public V remove(Object key) {
		V result = null;
		for (Map<K, V> container : reverse(select(key)))
			result = container.remove(key);

		return result;
	}

	@Override
	public void clear() {
		first.clear();
		second.clear();
	}

	@Override
	public Set<K> keySet() {
		return Union.union(first.keySet(), second.keySet());
	}

	@Override
	public Collection<V> values() {
		Collection<V> firstValues = first.values();
		Collection<V> secondValues = Maps.filterKeys(second, not(in(first.keySet()))).values();

		return Union.union(firstValues, secondValues);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> firstEntries = first.entrySet();
		Set<Entry<K, V>> secondEntries = Maps.filterKeys(second, not(in(first.keySet()))).entrySet();

		return Union.union(firstEntries, secondEntries);
	}
}