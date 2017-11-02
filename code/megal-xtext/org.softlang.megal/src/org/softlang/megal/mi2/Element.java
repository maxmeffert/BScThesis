package org.softlang.megal.mi2;

import static com.google.common.collect.Iterables.getFirst;

import java.util.Collection;

import com.google.common.collect.Multimap;

/**
 * <p>
 * Base class for annotated model elements.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public abstract class Element {
	/**
	 * <p>
	 * Gets the knowledge base this element is located in. The knowledge base is not part of the equivalence.
	 * </p>
	 * 
	 * @return Returns the knowledge base
	 */
	public abstract KB getKB();

	/**
	 * <p>
	 * Gets all annotations of this element.
	 * </p>
	 * 
	 * @return Returns a map from the keys to their values
	 */
	public abstract Multimap<String, String> getAnnotations();

	/**
	 * <p>
	 * Returns true if the annotation is present.
	 * </p>
	 * 
	 * @param name
	 *            The name of the annotation
	 * @return True if annotated with the annotation
	 */
	public boolean hasAnnotation(String name) {
		
		/*
		 * Use .containsKey instead of .containsEntry!
		 * 
		 * .containsEntry checks for the exact pair of arguments.
		 * So .containsEntry(name, null) makes no sense for the notion of hasAnnotation,
		 * since elements should also to be considered to have an annotation for non-null values.
		 * 
		 * Regards
		 * Max
		 * 
		 */
		
		return getAnnotations().containsKey(name);
//		return getAnnotations().containsEntry(name, null);
	}

	/**
	 * <p>
	 * Returns true if the annotation is present.
	 * </p>
	 * 
	 * @param name
	 *            The name of the annotation
	 * @param value
	 *            The value of the annotation
	 * @return True if annotated with the annotation
	 */
	public boolean hasAnnotation(String name, String value) {
		return getAnnotations().containsEntry(name, value);
	}

	/**
	 * <p>
	 * Gets all annotations of this element.
	 * </p>
	 * 
	 * @param name
	 *            The key to evaluate
	 * 
	 * @return Returns a collection of values
	 */
	public Collection<String> getAnnotations(String name) {
		return getAnnotations().get(name);
	}

	/**
	 * <p>
	 * Gets the only annotation of this element.
	 * </p>
	 * 
	 * @param name
	 *            The key to evaluate
	 * 
	 * @return Returns the only annotation
	 */
	public String getAnnotation(String name) {
		return getFirst(getAnnotations(name), null);
	}

	/**
	 * <p>
	 * Gets the only annotation of this element.
	 * </p>
	 * 
	 * @param name
	 *            The key to evaluate
	 * @param defaultValue
	 *            The value to default to
	 * @return Returns the only annotation
	 */
	public String getAnnotation(String name, String defaultValue) {
		return getFirst(getAnnotations(name), defaultValue);
	}
}