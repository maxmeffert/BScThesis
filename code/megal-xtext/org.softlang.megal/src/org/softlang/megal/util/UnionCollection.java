package org.softlang.megal.util;

import static com.google.common.collect.Lists.reverse;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

final class UnionCollection<E> extends AbstractCollection<E> {
	private final Collection<E> second;

	private final Collection<E> first;

	UnionCollection(Collection<E> second, Collection<E> first) {
		this.second = second;
		this.first = first;
	}

	@Override
	public int size() {
		return first.size() + second.size();
	}

	@Override
	public boolean isEmpty() {
		return first.isEmpty() && second.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return first.contains(o) || second.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return Union.sequencedMutableIterator(this, Iterables.concat(first, second));
	}

	private List<Collection<E>> select(Object element) {
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
		for (Collection<E> container : select(e))
			return container.add(e);

		return first.add(e);
	}

	@Override
	public boolean remove(Object o) {
		boolean result = false;
		for (Collection<E> container : reverse(select(o)))
			result = container.remove(o);

		return result;
	}

	@Override
	public void clear() {
		first.clear();
		second.clear();
	}
}