package org.softlang.megal.defaultprovider.searchengine;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * <p>
 * Represents a database on type names
 * </p>
 * 
 * @author Pazuzu
 *
 */
public class TypenameDatabase {
	/**
	 * <p>
	 * Constant specifying the expected size of a type name database
	 * <p>
	 */
	private static final int EXPECTED_DATABASE_SIZE = 20000;

	/**
	 * <p>
	 * The database
	 * </p>
	 */
	private final List<Typename> typenames;

	/**
	 * <p>
	 * Constructs a new type name database
	 * </p>
	 */
	public TypenameDatabase() {
		this.typenames = Lists
				.newArrayListWithExpectedSize(EXPECTED_DATABASE_SIZE);
	}

	/**
	 * <p>
	 * Returns a mutable list of type names
	 * </p>
	 * 
	 * @return Returns the value of the backing field, is mutable
	 */
	public List<Typename> getTypenames() {
		return typenames;
	}
}
