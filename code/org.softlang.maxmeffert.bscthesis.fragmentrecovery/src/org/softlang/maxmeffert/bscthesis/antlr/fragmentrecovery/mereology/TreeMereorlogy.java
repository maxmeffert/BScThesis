package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class TreeMereorlogy<T extends Comparable<T>> implements Mereology<T> {
	
	
	
	
	private static class Entry<T extends Comparable<T>> implements Comparable<Entry<T>> {
		
		public static <T extends Comparable<T>> Entry<T> of(T value) {
			return new Entry<T>(value);
		}
		
		private T value;
		private Set<Entry<T>> properParts = new TreeSet<>();
				
		private Entry(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}
			
		public void addPart(Entry<T> part) {
			if (compareTo(part) != 0) {
				properParts.add(part);
			}
		}
		
		private Set<Entry<T>> getProperPartEntries() {
			return ImmutableSet.copyOf(properParts);
		}
		
		private Set<Entry<T>> getPartEntries() {
			return (new ImmutableSet.Builder<Entry<T>>())
					.add(this)
					.addAll(getPartEntries())
					.build();
		}
		
		private Set<Entry<T>> getTransitiveEntries(Set<Entry<T>> entries) {
			Set<Entry<T>> result = entries;
			for (Entry<T> entry : entries) {
				result = Sets.union(result, getTransitiveEntries(entry.properParts));
			}
			return result;
		}
		
		private Set<Entry<T>> getTransitiveProperPartEntries() {
			return getTransitiveEntries(getProperPartEntries());
		}
		
		private Set<Entry<T>> getTransitivePartEntries() {
			return getTransitiveEntries(getPartEntries());
		}
		
		private Set<T> mapEntriesToValues(Set<Entry<T>> entries) {
			return entries.stream().map( entry -> entry.getValue() ).collect(ImmutableSet.toImmutableSet());
		}
		
		public Set<T> getParts() {
			return mapEntriesToValues(getPartEntries());
		}
		
		public Set<T> getProperParts() {
			return mapEntriesToValues(getProperPartEntries());
		}

		
		
		@Override
		public int compareTo(Entry<T> o) {
			return value.compareTo(o.value);
		}
		
		public boolean equals(Entry<T> o) {
			return compareTo(o) == 0;
		}
		
	}
	
	private Map<T, Set<T>> properPartMap = Maps.newTreeMap();
	
	public boolean containsElement(T element) {
		return properPartMap.containsKey(element);
	}
	
	@Override
	public Optional<Set<T>> getProperPartsOf(T a) {
		if (containsElement(a)) {
			return Optional.of(properPartMap.get(a));
		}
		return Optional.empty();
	}


	@Override
	public Optional<Set<T>> getPartsOf(T a) {
		return getProperPartsOf(a).map( properParts -> Sets.union(ImmutableSet.of(a), properParts) );
	}

	@Override
	public Optional<Set<T>> getAtomsOf(T a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void partOf(T a, T b) {
		if (!properPartMap.containsKey(b)) {
			
		}
	}
	
	@Override
	public boolean isPartOf(T a, T b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProperPartOf(T a, T b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAtomOf(T a, T b) {
		// TODO Auto-generated method stub
		return false;
	}




	

	

	

}
