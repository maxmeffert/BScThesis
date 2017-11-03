package org.softlang.megal.util;

import static com.google.common.collect.Lists.reverse;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

public class UnionSet<E> extends AbstractSet<E> {
	private final Set<E> first;

	private final Set<E> second;

	public UnionSet(Set<E> first, Set<E> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int size() {
		return Iterators.size(iterator());
	}

	@Override
	public boolean isEmpty() {
		return first.isEmpty() && second.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return Union.sequencedMutableIterator(this, Sets.union(first, second));
	}

	@Override
	public boolean contains(Object o) {
		return first.contains(o) || second.contains(o);
	}

	private List<Set<E>> select(Object element) {
		boolean firstContains = first.contains(element);
		boolean secondContains = second.contains(element);

		if (firstContains && secondContains)
			return ImmutableList.of(first, second);

		if (firstContains)
			return ImmutableList.of(first);

		if (secondContains)
			return ImmutableList.of(second);

		return ImmutableList.of();
	}

	@Override
	public boolean add(E e) {
		for (Set<E> container : select(e))
			return container.add(e);

		return first.add(e);
	}

	@Override
	public boolean remove(Object o) {
		boolean result = false;
		for (Set<E> container : reverse(select(o)))
			result = container.remove(o);

		return result;
	}

	@Override
	public void clear() {
		first.clear();
		second.clear();
	}
}