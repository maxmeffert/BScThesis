package org.softlang.megal.mi2.api.emission;

import org.softlang.megal.mi2.Element;

/**
 * <p>
 * Message emission context of a plugin.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public interface Emission {
	/**
	 * <p>
	 * Just validates the element.
	 * </p>
	 */
	void valid();

	/**
	 * <p>
	 * Emits an information.
	 * </p>
	 * 
	 * @param message
	 *            The message to emit
	 */
	void info(String message);

	/**
	 * <p>
	 * Emits a warning.
	 * </p>
	 * 
	 * @param message
	 *            The message to emit
	 */
	void warning(String message);

	/**
	 * <p>
	 * Emits an error.
	 * </p>
	 * 
	 * @param message
	 *            The message to emit
	 */
	void error(String message);

	/**
	 * <p>
	 * Just validates the element.
	 * </p>
	 */
	void valid(Element x, Element... xs);

	/**
	 * <p>
	 * Emits an information.
	 * </p>
	 * 
	 * @param message
	 *            The message to emit
	 */
	void info(String message, Element x, Element... xs);

	/**
	 * <p>
	 * Emits a warning.
	 * </p>
	 * 
	 * @param message
	 *            The message to emit
	 */
	void warning(String message, Element x, Element... xs);

	/**
	 * <p>
	 * Emits an error.
	 * </p>
	 * 
	 * @param message
	 *            The message to emit
	 */
	void error(String message, Element x, Element... xs);
}
