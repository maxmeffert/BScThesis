package org.softlang.maxmeffert.bscthesis.mereologies.old;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mereology<T> {

	static private class Element<T> {
		
		private T value;
		private Set<Element<T>> wholes = new HashSet<Element<T>>();
		private Set<Element<T>> parts = new HashSet<Element<T>>();
		
		public Element(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}
		
		public void addWhole(Element<T> whole) {
			wholes.add(whole);
			for (Element<T> part : parts) {
				part.addWhole(whole);
			}
		}
		
		public Set<Element<T>> getWholes() {
			Set<Element<T>> result = new HashSet<Element<T>>();
			for (Element<T> whole : wholes) {
				result.add(whole);
				result.addAll(whole.getWholes());
			}
			return result;
		}
		
		public void addPart(Element<T> part) {
			parts.add(part);
			for (Element<T> whole : wholes) {
				whole.addPart(part);
			}
		}
		
		public Set<Element<T>> getParts() {
			Set<Element<T>> result = new HashSet<Element<T>>();
			for (Element<T> part : parts) {
				result.add(part);
				result.addAll(part.getParts());
			}
			return result;
		}
		
		public boolean isAtom() {
			return parts.size() == 0;
		}
		
		public boolean isFusion() {
			return !isAtom();
		}
		
		public boolean hasPart(T part) {
			return value == part || parts.contains(part);
		}
		
	}
	
	private Map<T,Element<T>> elements = new HashMap<T,Element<T>>();
	
	private void add(Element<T> element) {
		elements.put(element.getValue(), element);
	}
	
	private Element<T> get(T value) {
		return elements.get(value);
	}
	
	public boolean contains(T value) {
		return elements.containsKey(value);
	}
	
	public Element<T> add(T value) {
		if (!contains(value)) {
			add(new Element<T>(value));
		}
		return get(value);
	}
	
	public void partOf(T part, T whole) {
		Element<T> pElement = add(part);
		Element<T> wElement = add(whole);
		pElement.addWhole(wElement);
		wElement.addPart(pElement);
	}
	
	public boolean isAtom(T value) {
		if (contains(value)) {
			return get(value).isAtom();
		}
		return false;
	}
	
	public boolean isFusion(T value) {
		if (contains(value)) {
			return get(value).isFusion();
		}
		return false;
	}
	
	public boolean isPartOf(T p, T w) {
		if (contains(p) && contains(w)) {
			return get(w).hasPart(p);
		}
		return false;
	}
	
	private Set<T> getValues(Stream<Element<T>> stream) {
		return stream.map( e -> e.getValue() ).collect(Collectors.toSet());
	}
	
	private Set<T> getValues(Collection<Element<T>> collection) {
		return getValues(collection.stream());
	}
	
	public Set<T> getValues() {
		return getValues(elements.values());
	}
	
	public Set<T> getPartsOf(T value) {
		return getValues(get(value).getParts());
	}
	
	public Set<T> getWholesOf(T value) {
		return getValues(get(value).getWholes());
	}
	
	public Set<T> getAtoms() {
		return getValues(elements.values().stream().filter(e -> e.isAtom()));
	}
	
	public Set<T> getFusions() {
		return getValues(elements.values().stream().filter(e -> e.isFusion()));
	}
	
	
	
}
