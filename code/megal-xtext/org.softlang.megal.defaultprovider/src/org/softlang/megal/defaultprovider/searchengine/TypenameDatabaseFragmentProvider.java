package org.softlang.megal.defaultprovider.searchengine;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.softlang.megal.defaultprovider.TypeFragmentProvider;

/**
 * <p>
 * Fragment provider for the initial items
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class TypenameDatabaseFragmentProvider extends
		TypeFragmentProvider<TypenameDatabase> {

	/**
	 * <p>
	 * Constructs the type name database fragment provider
	 * </p>
	 */
	public TypenameDatabaseFragmentProvider() {
		super(TypenameDatabase.class);
	}

	@Override
	protected List<? extends Object> navigateTyped(TypenameDatabase db,
			String segment) {
		// Navigate complete type names for the default package
		Stream<Typename> defs = db.getTypenames().stream()
				.filter(t -> t.size() == 1).filter(t -> t.isComplete())
				.filter(t -> segment.equals(t.getSegment(0)));

		// Navigate where head segment is equal
		Stream<TypenameInit> inits = db.getTypenames().stream()
				.filter(t -> t.size() > 1).filter(t -> t.isComplete())
				.filter(t -> segment.equals(t.getSegment(0)))
				.map(t -> new TypenameInit(t, 0));

		return Stream.concat(defs, inits).collect(Collectors.toList());
	}

	@Override
	protected Set<String> nextTyped(TypenameDatabase db) {
		// Propose complete type names for the default package
		Stream<String> defs = db.getTypenames().stream()
				.filter(t -> t.size() == 1).filter(t -> t.isComplete())
				.map(t -> t.getTypename());

		// Propose head segment
		Stream<String> inits = db.getTypenames().stream()
				.filter(t -> t.size() > 1).filter(t -> t.isComplete())
				.map(t -> t.getSegment(0));

		return Stream.concat(defs, inits).collect(Collectors.toSet());
	}

}
