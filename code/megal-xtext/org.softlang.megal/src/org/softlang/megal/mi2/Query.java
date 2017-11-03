package org.softlang.megal.mi2;

import java.util.List;
import java.util.Set;

public interface Query {
	/**
	 * <p>
	 * Number of positional parameters required for execution of the query.
	 * </p>
	 * 
	 * @return Returns the maximum position
	 */
	int symbols();

	/**
	 * <p>
	 * Executes the query given the positional parameters. The <i>params</i>
	 * need to have the same length as the {@link #symbols()} property.
	 * </p>
	 * 
	 * @param kb
	 *            The KB to execute in
	 * @param params
	 *            The parameters, must be the same length as {@link #symbols()}
	 * @return Returns a set of valid query rows.
	 */
	Set<List<Object>> execute(KB kb, Object... params);
}
