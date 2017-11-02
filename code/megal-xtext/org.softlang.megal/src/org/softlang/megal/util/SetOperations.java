package org.softlang.megal.util;

import static com.google.common.collect.Multimaps.index;
import static com.google.common.collect.Multimaps.transformValues;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

/**
 * <p>
 * Set based operations, applied to set backed data structures.
 * </p>
 * TODO: Many of these may be implemented in a fast and persistent way, are not yet.
 * 
 * @author Pazuzu
 *
 */
public class SetOperations {
	public static void main(String[] args) {
		Map<Integer, Integer> x = Maps.newHashMap();
		x.put(1, 5);
		x.put(2, 6);
		x.put(3, 8);
		Map<Integer, Integer> y = Maps.newHashMap();
		y.put(2, 3);
		y.put(4, 10);
		y.put(5, 12);
		y.put(6, 13);

		Map<Integer, Integer> z = new UnionMap<>(x, y);

		System.out.println("X: " + x + "\nY: " + y + "\nZ: " + z + "\n");

		z.remove(2);
		System.out.println("X: " + x + "\nY: " + y + "\nZ: " + z + "\n");

		z.put(1, 1);
		System.out.println("X: " + x + "\nY: " + y + "\nZ: " + z + "\n");

		for (Iterator<Entry<Integer, Integer>> e = z.entrySet().iterator(); e.hasNext();) {
			Entry<Integer, Integer> entry = e.next();

			if (entry.getKey() % 2 == 0)
				e.remove();
		}
		System.out.println("X: " + x + "\nY: " + y + "\nZ: " + z + "\n");
	}

	/**
	 * <p>
	 * Translates the collection of entries to a multimap.
	 * </p>
	 * 
	 * @param entries
	 *            The entries to translate
	 * @return Returns a multimap
	 */
	public static <K, V> Multimap<K, V> translate(Collection<Entry<K, V>> entries) {
		// Index by map entry key and map the value by entry value
		return transformValues(index(entries, Entry::getKey), Entry::getValue);
	}

	public static <T, U> Set<U> transform(final Set<T> set, final Class<U> type, final Bijection<T, U> bijection) {
		return new AbstractSet<U>() {
			@Override
			public int size() {
				return set.size();
			}

			@Override
			public boolean isEmpty() {
				return set.isEmpty();
			}

			@Override
			public boolean contains(Object o) {
				if (set.isEmpty())
					return false;

				if (!type.isInstance(o))
					return false;

				return set.contains(bijection.inverse().apply(type.cast(o)));
			}

			@Override
			public Iterator<U> iterator() {
				return Iterators.transform(set.iterator(), bijection);
			}

			@Override
			public boolean add(U e) {
				return set.add(bijection.inverse().apply(e));
			}

			@Override
			public boolean remove(Object o) {
				if (set.isEmpty())
					return false;

				return set.remove(bijection.inverse().apply(type.cast(o)));
			}

			@Override
			public void clear() {
				set.clear();
			}
		};
	}

	public static <R, C, E> Multitable<R, C, E> intersection(Multitable<R, C, E> a, Multitable<R, C, E> b) {
		Multitable<R, C, E> result = HashMultitable.create();
		result.putAll(a);
		result.retainAll(b);
		return result;
	}

	public static <K, V> SetMultimap<K, V> intersection(SetMultimap<K, V> a, SetMultimap<K, V> b) {
		ImmutableSetMultimap.Builder<K, V> builder = ImmutableSetMultimap.builder();
		for (Entry<K, V> e : Sets.intersection(a.entries(), b.entries()))
			builder.put(e);
		return builder.build();
	}

	public static <K, V> Map<K, V> intersection(Map<K, V> a, Map<K, V> b) {
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		for (Entry<K, V> e : Sets.intersection(a.entrySet(), b.entrySet()))
			builder.put(e);
		return builder.build();
	}

	public static <R, C, E> Multitable<R, C, E> difference(Multitable<R, C, E> a, Multitable<R, C, E> b) {
		Multitable<R, C, E> result = HashMultitable.create();
		result.putAll(a);
		result.removeAll(b);
		return result;
	}

	public static <K, V> SetMultimap<K, V> difference(SetMultimap<K, V> a, SetMultimap<K, V> b) {
		ImmutableSetMultimap.Builder<K, V> builder = ImmutableSetMultimap.builder();
		for (Entry<K, V> e : Sets.difference(a.entries(), b.entries()))
			builder.put(e);
		return builder.build();
	}

	public static <K, V> Map<K, V> difference(Map<K, V> a, Map<K, V> b) {
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		for (Entry<K, V> e : Sets.difference(a.entrySet(), b.entrySet()))
			builder.put(e);
		return builder.build();
	}
}
