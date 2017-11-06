package org.softlang.megal.plugins.api.recovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.megal.mi2.Entity;

public class QualifiedFragmentNameProvider {

	private static final String FragmentNamePrefix = "F";
	private static final String IndexNameSeparator = "$";
	private static final String PartOfNameSeparator = ".";
	
	private final IFragmentNameProvider fragmentNameProvider;
	
	public QualifiedFragmentNameProvider(IFragmentNameProvider fragmentNameProvider) {
		this.fragmentNameProvider = fragmentNameProvider;
	}
	
	private boolean hasName(IFragment fragment) {
		return fragmentNameProvider.hasName(fragment);
	}
	
	private String getName(IFragment fragment) {
		return fragmentNameProvider.getName(fragment);
	}
	
	private int getIndex(IFragment fragment) {
		if (fragment.hasParent()) {
			return fragment.getParent().getChildren().indexOf(fragment);
		}
		return -1;
	}
	
	private String getIndexedName(IFragment fragment) {
		int index = getIndex(fragment);
		String name = getName(fragment);
		if (index < 0) {
			return name;
		}
		return FragmentNamePrefix + index + IndexNameSeparator + name;
	}
	
	private String prependAncestorNames(String qualifiedName, IFragment parent) {
		while (parent != null && hasName(parent)) {
			qualifiedName = getIndexedName(parent) + PartOfNameSeparator + qualifiedName;
			parent = parent.getParent();
		}
		return qualifiedName;
	}
	
	public String getQualifiedName(IFragment fragment, Entity entity) {
		String qualifiedName = getIndexedName(fragment);
		if (fragment.hasParent()) {
			qualifiedName = prependAncestorNames(qualifiedName, fragment.getParent());
		}
		return entity.getName() + PartOfNameSeparator + qualifiedName;
	}
	
}
