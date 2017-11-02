package org.softlang.megal.util;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Predicates.equalTo;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterators.filter;
import static com.google.common.collect.Iterators.unmodifiableIterator;
import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;
import static java.util.Collections.unmodifiableSet;

import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Persistent {
	public static <K, V> Multimap<K, V> composeMultimaps(Multimap<K, V> a, Multimap<K, V> b) {
		Multimap<K, V> result = HashMultimap.create(a);
		result.putAll(b);
		return result;
	}

	/**
	 * <p>
	 * Returns the head of the list or throws an {@link NoSuchElementException}.
	 * </p>
	 * 
	 * @param list
	 *            The list to find the head of
	 * @return The head of the list
	 */
	public static <E> E head(List<E> list) {
		checkNotNull(list);

		if (list.isEmpty())
			throw new NoSuchElementException();

		return list.get(0);
	}

	/**
	 * <p>
	 * Returns the tail of the list or throws an {@link NoSuchElementException}.
	 * </p>
	 * 
	 * @param list
	 *            The list to find the tail of
	 * @return The tail of the list
	 */
	public static <E> List<E> tail(List<E> list) {
		checkNotNull(list);

		if (list.isEmpty())
			throw new NoSuchElementException();

		return list.subList(1, list.size());
	}

	/**
	 * <p>
	 * Returns the last item of the list or throws an {@link NoSuchElementException}.
	 * </p>
	 * 
	 * @param list
	 *            The list to find the last item of
	 * @return The last item of the list
	 */
	public static <E> E last(List<E> list) {
		checkNotNull(list);

		if (list.isEmpty())
			throw new NoSuchElementException();

		return list.get(list.size() - 1);
	}

	/**
	 * <p>
	 * Returns the init of the list or throws an {@link NoSuchElementException}.
	 * </p>
	 * 
	 * @param list
	 *            The list to find the init of
	 * @return The init of the list
	 */
	public static <E> List<E> init(List<E> list) {
		checkNotNull(list);

		if (list.isEmpty())
			throw new NoSuchElementException();
		return list.subList(0, list.size() - 1);
	}

	/**
	 * <p>
	 * Prepends the head item before the tail list.
	 * </p>
	 * <p>
	 * The following fragment is always true: <code>x.equals(prepend(head(x),tail(x)))</code>
	 * </p>
	 * 
	 * @param head
	 *            The new first item
	 * @param tail
	 *            The tail after the first item
	 * @return Returns an unmodifiable view on the lists
	 */
	public static <E> List<E> prepend(final E head, final List<E> tail) {
		checkNotNull(tail);

		return new AbstractList<E>() {
			@Override
			public int size() {
				return 1 + tail.size();
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				if (equal(o, head))
					return true;

				return tail.contains(o);
			}

			@Override
			public Iterator<E> iterator() {
				return unmodifiableIterator(concat(singleton(head), tail).iterator());
			}

			@Override
			public E get(int index) {
				if (index == 0)
					return head;

				return tail.get(index - 1);
			}

			@Override
			public int indexOf(Object o) {
				if (equal(o, head))
					return 0;
				int p = tail.indexOf(o);
				if (p != -1)
					return p + 1;
				return -1;
			}

			@Override
			public int lastIndexOf(Object o) {
				int p = tail.lastIndexOf(o);
				if (p != -1)
					return p + 1;
				if (equal(o, head))
					return 0;
				return -1;
			}

			@Override
			public List<E> subList(int fromIndex, int toIndex) {
				if (fromIndex > 0)
					return tail.subList(fromIndex - 1, toIndex - 1);
				else
					return prepend(head, tail.subList(0, toIndex - 1));
			}
		};
	}

	/**
	 * <p>
	 * Appends the last item after the init list.
	 * </p>
	 * <p>
	 * The following fragment is always true: <code>x.equals(append(init(x),last(x)))</code>
	 * </p>
	 * 
	 * @param init
	 *            The init before the last item
	 * @param last
	 *            The new last item
	 * @return Returns an unmodifiable view on the lists
	 */
	public static <E> List<E> append(final List<E> init, final E last) {
		checkNotNull(init);

		return new AbstractList<E>() {
			@Override
			public int size() {
				return init.size() + 1;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				if (equal(o, last))
					return true;

				return init.contains(o);
			}

			@Override
			public Iterator<E> iterator() {
				return unmodifiableIterator(concat(init, singleton(last)).iterator());
			}

			@Override
			public E get(int index) {
				if (index == init.size())
					return last;

				return init.get(index);
			}

			@Override
			public int lastIndexOf(Object o) {
				if (equal(o, last))
					return init.size();
				int p = init.indexOf(o);

				return p;
			}

			@Override
			public int indexOf(Object o) {
				int p = init.indexOf(o);
				if (p != -1)
					return p;
				if (equal(o, last))
					return init.size();
				return -1;
			}

			@Override
			public List<E> subList(int fromIndex, int toIndex) {
				if (fromIndex > init.size())
					return emptyList();
				if (toIndex > init.size())
					return append(init.subList(fromIndex, init.size()), last);
				else
					return init.subList(fromIndex, toIndex);
			}
		};
	}

	/**
	 * <p>
	 * Persistent concatenation of the lists.
	 * </p>
	 * <p>
	 * The following fragment is always true: <code>x.equals(concatenate(x.subList(0,n),x.subList(n,x.size()))</code>
	 * </p>
	 * 
	 * @param first
	 *            The first list
	 * @param second
	 *            The second list
	 * @return Returns an unmodifiable view on the lists
	 */
	public static <E> List<E> concatenate(final List<? extends E> first, final List<? extends E> second) {
		return new AbstractList<E>() {
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
				return unmodifiableIterator(concat(first, second).iterator());
			}

			@Override
			public void clear() {
				first.clear();
				second.clear();
			}

			@Override
			public E get(int index) {
				if (index < first.size())
					return first.get(index);
				else
					return second.get(index - first.size());
			}

			@Override
			public int indexOf(Object o) {
				int p = first.indexOf(o);
				if (p != -1)
					return p;

				int q = second.indexOf(o);
				if (q != -1)
					return first.size() + q;

				return -1;
			}

			@Override
			public int lastIndexOf(Object o) {
				int q = second.lastIndexOf(o);
				if (q != -1)
					return first.size() + q;

				int p = first.lastIndexOf(o);
				if (p != -1)
					return p;

				return -1;
			}

			@Override
			public List<E> subList(int fromIndex, int toIndex) {
				// Unmixed
				if (toIndex <= first.size())
					return concatenate(first.subList(fromIndex, toIndex), emptyList());

				if (fromIndex >= first.size())
					return concatenate(emptyList(), second.subList(fromIndex - first.size(), toIndex - first.size()));

				// Mixed
				return concatenate(first.subList(fromIndex, first.size()), second.subList(0, toIndex - first.size()));
			}
		};
	}

	/**
	 * <p>
	 * Excludes the given item from the set if it is contained.
	 * </p>
	 * 
	 * @param item
	 *            The item to exclude
	 * @param set
	 *            The set from which to exclude the item
	 * 
	 * @return Returns a view that has the item excluded
	 */
	public static <E> Set<E> without(final E item, final Set<E> set) {
		if (!set.contains(item))
			return unmodifiableSet(set);

		return new AbstractSet<E>() {
			@Override
			public int size() {
				return set.size() - 1;
			}

			@Override
			public boolean isEmpty() {
				return set.size() == 1;
			}

			@Override
			public boolean contains(Object o) {
				return !equal(o, item) && set.contains(o);
			}

			@Override
			public Iterator<E> iterator() {
				return filter(set.iterator(), not(equalTo(item)));
			}
		};
	}

	/**
	 * <p>
	 * Includes the given item in the set if it is not already contained.
	 * </p>
	 * 
	 * @param item
	 *            The item to include
	 * @param set
	 *            The set in which to include the item
	 * 
	 * @return Returns a view that has the item included
	 */
	public static <E> Set<E> with(final E item, final Set<? extends E> set) {
		if (set.contains(item))
			return unmodifiableSet(set);

		return new AbstractSet<E>() {
			@Override
			public int size() {
				return set.size() + 1;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				return equal(o, item) && set.contains(o);
			}

			@Override
			public Iterator<E> iterator() {
				return unmodifiableIterator(concat(set, singleton(item)).iterator());
			}
		};
	}
}
