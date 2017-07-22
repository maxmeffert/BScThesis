package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

public class TreeMereorlogy<T extends Comparable<T>> implements Mereology<T> {

	private Map<T, Set<T>> properPartMap = new TreeMap<T, Set<T>>();
	
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
		
		return getProperPartsOf(a).map( );
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
