package org.softlang.megal.util;

import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
/**
 * <p>
 * A collection of methods that provide mutable unions of common <i>ADS</i>s by specifying data dominance for remove and
 * add operations.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class Union {
	/**
	 * <p>
	 * Applies the set union on the input.
	 * </p>
	 * 
	 * @param a
	 *            The left side
	 * @param b
	 *            The right side
	 * @return Returns the result
	 */
	public static <R, C, E> Multitable<R, C, E> union(Multitable<R, C, E> a, Multitable<R, C, E> b) {
		Multitable<R, C, E> result = HashMultitable.create();
		result.putAll(a);
		result.putAll(b);
		return result;
	}

	/**
	 * <p>
	 * Applies the set union on the input.
	 * </p>
	 * 
	 * @param a
	 *            The left side
	 * @param b
	 *            The right side
	 * @return Returns the result
	 */
	public static <R, C, V> Table<R, C, V> union(Table<R, C, V> a, Table<R, C, V> b) {
		ImmutableTable.Builder<R, C, V> builder = ImmutableTable.builder();

		builder.putAll(a);
		for (Cell<R, C, V> cell : b.cellSet())
			if (!a.contains(cell.getRowKey(), cell.getColumnKey()))
				builder.put(cell);

		return builder.build();
	}

	/**
	 * <p>
	 * Applies the set union on the input.
	 * </p>
	 * 
	 * @param a
	 *            The left side
	 * @param b
	 *            The right side
	 * @return Returns the result
	 */
	public static <K, V> ImmutableMultimap<K, V> union(Multimap<K, V> a, Multimap<K, V> b) {
		ImmutableMultimap.Builder<K, V> builder = ImmutableMultimap.builder();

		builder.putAll(a);
		builder.putAll(b);

		return builder.build();
	}

	/**
	 * <p>
	 * Applies the set union on the input.
	 * </p>
	 * 
	 * @param a
	 *            The left side
	 * @param b
	 *            The right side
	 * @return Returns the result
	 */
	public static <E> Set<E> union(Set<E> a, Set<E> b) {
		if (true)
			return Sets.union(a, b);
		return new UnionSet<>(a, b);
	}

	/**
	 * <p>
	 * Applies the set union on the input.
	 * </p>
	 * 
	 * @param a
	 *            The left side
	 * @param b
	 *            The right side
	 * @return Returns the result
	 */
	public static <K, V> Map<K, V> union(Map<K, V> a, Map<K, V> b) {
		if (true) {
			Map<K, V> r = Maps.newHashMap(a);
			r.putAll(Maps.filterKeys(b, not(in(a.keySet()))));
		}
		return new UnionMap<>(a, b);
	}

	/**
	 * <p>
	 * Applies the set union on the input.
	 * </p>
	 * 
	 * @param a
	 *            The left side
	 * @param b
	 *            The right side
	 * @return Returns the result
	 */
	public static <K, V> ImmutableSetMultimap<K, V> union(SetMultimap<K, V> a, SetMultimap<K, V> b) {
		ImmutableSetMultimap.Builder<K, V> builder = ImmutableSetMultimap.builder();

		builder.putAll(a);
		builder.putAll(b);

		return builder.build();
	}

	/**
	 * <p>
	 * Persistent concatenation of the collections.
	 * </p>
	 * 
	 * @param first
	 *            The first collection
	 * @param second
	 *            The second collection
	 * @return Returns an unmodifiable view on the collections
	 */
	public static <E> Collection<E> union(Collection<E> first, Collection<E> second) {
		return new UnionCollection<>(second, first);
	}

	/**
	 * <p>
	 * The sequenced mutable iterator returns the elements of <code>sequence</code>, delegating the remove operation to
	 * the <code>delegate</code>.
	 * </p>
	 * 
	 * @param delegate
	 *            The remove delegate
	 * @param sequence
	 *            The sequence of items
	 * @return Returns a mutable iterator
	 */
	public static <E> Iterator<E> sequencedMutableIterator(final Collection<E> delegate, Iterable<E> sequence) {
		Iterator<E> baseIterator = ImmutableList.copyOf(sequence).iterator();

		return new Iterator<E>() {
			private E at;

			@Override
			public boolean hasNext() {
				return baseIterator.hasNext();
			}

			@Override
			public E next() {
				return at = baseIterator.next();
			}

			@Override
			public void remove() {
				delegate.remove(at);
			}
		};
	}
}
