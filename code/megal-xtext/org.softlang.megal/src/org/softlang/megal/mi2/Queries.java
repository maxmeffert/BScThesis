package org.softlang.megal.mi2;

import static com.google.common.base.Objects.equal;
import static org.eclipse.xtext.EcoreUtil2.eAllOfType;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.softlang.megal.MegalAnnotation;
import org.softlang.megal.QueryEntity;
import org.softlang.megal.QueryEntry;
import org.softlang.megal.QueryParam;
import org.softlang.megal.QueryPos;
import org.softlang.megal.QueryReference;
import org.softlang.megal.QueryStatement;
import org.softlang.megal.QueryString;
import org.softlang.megal.Selection;
import org.softlang.megal.util.MegalSwitch;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
/**
 * <p>
 * Converts a notational query in the form of a selection into an executable
 * query.
 * </p>
 * TODO: Work this out, the current implementation is basically shit
 * 
 * @author Pazuzu
 *
 */
public class Queries {
	// TODO, implicit binding via name
	public static Object executeStaticEntry(QueryEntry entry, KB kb, Object... params) {
		return new MegalSwitch<Object>() {
			@Override
			public Object caseQueryEntity(QueryEntity object) {
				return kb.getEntity(object.getEntity().getName());
			}

			@Override
			public Object caseQueryParam(QueryParam object) {
				throw new IllegalStateException("Dynamic request in static body");
			}

			@Override
			public Object caseQueryPos(QueryPos object) {
				return params[object.getValue()];
			}

			@Override
			public Object caseQueryString(QueryString object) {
				return object.getValue();
			}
		}.doSwitch(entry);
	}

	public static List<Object> executeStaticEntries(List<? extends QueryEntry> entires, KB kb, Object... params) {
		return Lists.transform(entires, x -> executeStaticEntry(x, kb, params));
	}

	public static Object executeDynamicEntry(QueryEntry entry, Map<String, Object> assignments, KB kb,
			Object... params) {
		return new MegalSwitch<Object>() {
			@Override
			public Object caseQueryEntity(QueryEntity object) {
				return kb.getEntity(object.getEntity().getName());
			}

			@Override
			public Object caseQueryParam(QueryParam object) {
				return assignments.get(object.getName());
			}

			@Override
			public Object caseQueryPos(QueryPos object) {
				return params[object.getValue() - 1];
			}

			@Override
			public Object caseQueryString(QueryString object) {
				return object.getValue();
			}
		}.doSwitch(entry);
	}

	public static List<Object> executeDynamicEntries(List<? extends QueryEntry> entries,
			Map<String, Object> assignments, KB kb, Object... params) {
		return Lists.transform(entries, x -> executeDynamicEntry(x, assignments, kb, params));
	}

	/**
	 * <p>
	 * Returns true if the given selection is independent of a query. It might
	 * not be constant, as a positional parameter might be dependent of an input
	 * parameter.
	 * </p>
	 * 
	 * @param sel
	 *            The selection to test
	 * @return Returns true if query-independent
	 */
	public static boolean isStatic(Selection sel) {
		return sel.getQuery().isEmpty();
	}

	/**
	 * <p>
	 * Converts a notational query in form of a selection into an actual KB
	 * based query.
	 * </p>
	 * 
	 * @param sel
	 *            The selection to convert
	 * @return Returns the query
	 */
	public static Query convert(Selection sel) {
		int max = 0;
		for (QueryPos pos : eAllOfType(sel, QueryPos.class))
			max = Ints.max(max, pos.getValue());

		if (sel.getQuery().isEmpty())
			return convertStatic(sel, max);
		else
			return convertDynamic(sel, max);

	}

	private static Query convertStatic(Selection sel, int symbols) {
		return new Query() {
			@Override
			public int symbols() {
				return symbols;
			}

			@Override
			public Set<List<Object>> execute(KB kb, Object... params) {
				return Collections.singleton(executeStaticEntries(sel.getSelect(), kb, params));
			}
		};
	}

	private static <K, V> Set<Map<K, V>> combineMergable(Set<Map<K, V>> lefts, Set<Map<K, V>> rights) {
		ImmutableSet.Builder<Map<K, V>> result = ImmutableSet.builder();
		// Iterate all combinations
		for (Map<K, V> left : lefts)
			outer: for (Map<K, V> right : rights) {
				// Track the row
				ImmutableMap.Builder<K, V> row = ImmutableMap.builder();
				for (Entry<K, V> entry : left.entrySet())
					// If right shares a mapping with left
					if (right.containsKey(entry.getKey())) {
						// If this mapping differs, they are not mergable
						if (!equal(right.get(entry.getKey()), entry.getValue()))
							continue outer;
					} else
						// If right does not map the key, add it to the row
						row.put(entry);

				// Add all remaining mappings from right and the build
				row.putAll(right);
				result.add(row.build());
			}

		return result.build();
	}

	private static Query convertDynamic(Selection sel, int symbols) {
		return new Query() {
			@Override
			public int symbols() {
				return symbols;
			}

			private Map<String, Object> execute(QueryEntry request, Entity model, Object... params) {
				if (request instanceof QueryEntity) {
					QueryEntity queryEntity = (QueryEntity) request;
					if (model.getName() != queryEntity.getEntity().getName())
						return null;

					return Collections.emptyMap();
				}

				if (request instanceof QueryPos) {
					QueryPos queryPos = (QueryPos) request;
					if (!equal(params[queryPos.getValue() - 1], model))
						return null;

					return Collections.emptyMap();
				}

				if (request instanceof QueryReference) {
					QueryReference queryReference = (QueryReference) request;

					if (queryReference.getRef().getType() != null)
						if (!equal(model.getType().getName(), queryReference.getRef().getType().getName()))
							return null;

					return ImmutableMap.of(queryReference.getRef().getName(), model);
				}

				throw new IllegalArgumentException("Type of request is not satisfiable: " + request.eClass().getName());
			}

			private Set<Map<String, Object>> execute(QueryStatement statement, KB kb, Object... params) {
				ImmutableSet.Builder<Map<String, Object>> result = ImmutableSet.builder();

				for (Relationship rel : kb.getRelationships()) {
					// Not a relationship for this query
					if (!equal(rel.getTypeName(), statement.getPredicate().getName()))
						continue;

					// Get model for left side -- if there is no model, skip
					Map<String, Object> left = execute(statement.getSubject(), rel.getLeft());
					if (left == null)
						continue;

					// Get model for right side -- if there is no model, skip
					Map<String, Object> right = execute(statement.getObject(), rel.getRight());
					if (right == null)
						continue;

					// If models not unifiable, skip
					for (Entry<String, Object> entry : left.entrySet())
						if (right.containsKey(entry.getKey()) && !equal(right.get(entry.getKey()), entry.getValue()))
							continue;

					// Add the model into the result set
					result.add(ImmutableMap.<String, Object> builder().putAll(left).putAll(right).build());
				}

				return result.build();
			}

			@Override
			public Set<List<Object>> execute(KB kb, Object... params) {
				// Hypothetical universal set
				Set<Map<String, Object>> assignments = null;

				for (QueryStatement statement : sel.getQuery())
					// Intersect with the current statements result vectorF
					assignments = assignments == null ? execute(statement, kb, params)
							: combineMergable(assignments, execute(statement, kb, params));

				// Map by reading the the selection
				ImmutableSet.Builder<List<Object>> results = ImmutableSet.builder();
				for (Map<String, Object> assignment : assignments)
					results.add(executeDynamicEntries(sel.getSelect(), assignment, kb, params));

				return results.build();
			}
		};
	}

}
