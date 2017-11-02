package org.softlang.megal.mi2.api;

import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Multimaps.filterKeys;
import static com.google.common.collect.Sets.difference;
import static com.google.common.collect.Sets.union;

import java.util.Map;
import java.util.Set;

import org.softlang.megal.mi2.Element;
import org.softlang.megal.mi2.KB;

import com.google.common.collect.SetMultimap;

public final class Result {
	private final KB input;

	private final KB output;

	private final Map<Element, Element> origin;

	private final Set<Element> valid;
	private final SetMultimap<Element, String> infos;
	private final SetMultimap<Element, String> warnings;
	private final SetMultimap<Element, String> errors;

	private Result(KB input, KB output, Map<Element, Element> origin, Set<Element> valid,
			SetMultimap<Element, String> infos, SetMultimap<Element, String> warnings,
			SetMultimap<Element, String> errors) {
		this.input = input;
		this.output = output;
		this.origin = origin;
		this.valid = valid;
		this.infos = infos;
		this.warnings = warnings;
		this.errors = errors;
	}

	public static Result of(KB input, KB output, Map<Element, Element> origin, Set<Element> valid,
			SetMultimap<Element, String> infos, SetMultimap<Element, String> warnings,
			SetMultimap<Element, String> errors) {
		return new Result(input, output, origin, valid, infos, warnings, errors);
	}

	/**
	 * <p>
	 * The input knowledge base
	 * </p>
	 * 
	 * @return Returns the evaluations input
	 */
	public KB getInput() {
		return input;
	}

	/**
	 * <p>
	 * The output knowledge base
	 * </p>
	 * 
	 * @return Returns the evaluations output with reasoned knowledge
	 */
	public KB getOutput() {
		return output;
	}

	public Map<Element, Element> getOrigin() {
		return origin;
	}

	/**
	 * <p>
	 * The valid elements
	 * </p>
	 * 
	 * @return All elements validated by valid emission
	 */
	public Set<Element> getValid() {
		return valid;
	}

	/**
	 * <p>
	 * The information messages.
	 * </p>
	 * 
	 * @return Returns the info
	 */
	public SetMultimap<Element, String> getInfos() {
		return infos;
	}

	/**
	 * <p>
	 * The warning messages.
	 * </p>
	 * 
	 * @return Returns the warnings
	 */
	public SetMultimap<Element, String> getWarnings() {
		return warnings;
	}

	/**
	 * <p>
	 * The error messages.
	 * </p>
	 * 
	 * @return Returns the errors
	 */
	public SetMultimap<Element, String> getErrors() {
		return errors;
	}

	/**
	 * <p>
	 * Gets the warning messages, filters messages that are validated on other locations if desired.
	 * </p>
	 * 
	 * @param withRevoked
	 *            True if validated elements should also be considered
	 * @return Returns the warnings
	 */
	public SetMultimap<Element, String> getWarnings(boolean withRevoked) {
		if (withRevoked)
			return getWarnings();

		return filterKeys(getWarnings(), not(in(getValid())));
	}

	/**
	 * <p>
	 * Gets the error messages, filters messages that are validated on other locations if desired.
	 * </p>
	 * 
	 * @param withRevoked
	 *            True if validated elements should also be considered
	 * @return Returns the errors
	 */
	public SetMultimap<Element, String> getErrors(boolean withRevoked) {
		if (withRevoked)
			return getErrors();

		return filterKeys(getErrors(), not(in(getValid())));
	}

	/**
	 * <p>
	 * Gets all elements visited by any of the fields.
	 * </p>
	 * 
	 * @return Returns a set of elements
	 */
	public Set<Element> visited() {
		return union(getValid(), union(getInfos().keySet(), union(getWarnings().keySet(), getErrors().keySet())));
	}

	/**
	 * <p>
	 * Gets the elements in the input that have not been visited.
	 * </p>
	 * 
	 * @return Returns a set of elements
	 */
	public Set<Element> notVisited() {
		return difference(getInput().getElements(), visited());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + input.hashCode();
		result = prime * result + output.hashCode();
		result = prime * result + valid.hashCode();
		result = prime * result + infos.hashCode();
		result = prime * result + warnings.hashCode();
		result = prime * result + errors.hashCode();

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;

		if (!input.equals(other.input))
			return false;
		if (!output.equals(other.output))
			return false;
		if (!valid.equals(other.valid))
			return false;
		if (!infos.equals(other.infos))
			return false;
		if (!warnings.equals(other.warnings))
			return false;
		if (!errors.equals(other.errors))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [input=" + input + ", output=" + output + ", valid=" + valid + ", infos=" + infos
				+ ", warnings=" + warnings + ", errors=" + errors + "]";
	}

}
