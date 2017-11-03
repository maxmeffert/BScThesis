package org.softlang.megal.defaultprovider.searchengine;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.softlang.megal.defaultprovider.TypeFragmentProvider;

import com.google.common.base.Objects;

/**
 * <p>
 * Fragment provider for the type name sublists
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class TypenameInitFragmentProvider extends
		TypeFragmentProvider<TypenameInit> {
	/**
	 * <p>
	 * Constructs the type name init fragment provider
	 * </p>
	 */
	public TypenameInitFragmentProvider() {
		super(TypenameInit.class);
	}

	@Override
	protected List<? extends Object> navigateTyped(TypenameInit i,
			String segment) {
		// If segment not equal to the segment we're at, return empty list
		if (i.hasNext() && Objects.equal(segment, i.nextSegment()))
			return Collections.singletonList(i.next());
		else
			return Collections.emptyList();
	}

	@Override
	protected Set<String> nextTyped(TypenameInit i) {
		// If we have another segment, return it as the only item
		if (i.hasNext())
			return Collections.singleton(i.nextSegment());
		else
			return Collections.emptySet();
	}

}
