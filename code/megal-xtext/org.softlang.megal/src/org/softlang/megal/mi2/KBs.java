package org.softlang.megal.mi2;

import java.util.Map;
import java.util.Map.Entry;

import org.softlang.megal.util.HashMultitable;
import org.softlang.megal.util.ImmutableMultitable;
import org.softlang.megal.util.Multitable;
import org.softlang.megal.util.SetOperations;
import org.softlang.megal.util.Union;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Table.Cell;

public class KBs {

	/**
	 * <p>
	 * The builder class initializes a knowledge base on the given static return
	 * values. It may be supplied to other consumers, as every operation makes a
	 * copy of the builder.
	 * </p>
	 * 
	 * @author Pazuzu
	 *
	 */
	public static class Builder {
		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final String title;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final Multitable<String, String, String> relationships;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final Multitable<Ref, Ref, String> relationshipTypes;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> relationshipTypeAnnotations;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final SetMultimap<Cell<String, String, String>, Entry<String, String>> relationshipAnnotations;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final Map<String, String> entityTypes;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final SetMultimap<Entry<String, String>, Entry<String, String>> entityTypeAnnotations;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final SetMultimap<Entry<String, Ref>, Entry<String, String>> entityAnnotations;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final Map<String, Ref> entities;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final Map<String, Object> bindings;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final SetMultimap<String, String> annotations;

		/**
		 * <p>
		 * Internal backing field.
		 * </p>
		 */
		private final SetMultimap<String, String> theEntityTypeAnnotations;

		/**
		 * <p>
		 * Creates the builder on the given parameters
		 * </p>
		 * 
		 * @param title
		 *            The title
		 * @param relationships
		 *            The relationships
		 * @param relationshipTypes
		 *            The relationship types
		 * @param relationshipTypeAnnotations
		 *            The relationship type annotations
		 * @param relationshipAnnotations
		 *            The relationship annotations
		 * @param entityTypes
		 *            The entity types
		 * @param entityTypeAnnotations
		 *            The entity type annotations
		 * @param entityAnnotations
		 *            The entity annotations
		 * @param entities
		 *            The entities
		 * @param bindings
		 *            The bindings
		 * @param annotations
		 *            The annotations
		 */
		public Builder(String title, Multitable<String, String, String> relationships,
				Multitable<Ref, Ref, String> relationshipTypes,
				SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> relationshipTypeAnnotations,
				SetMultimap<Cell<String, String, String>, Entry<String, String>> relationshipAnnotations,
				Map<String, String> entityTypes,
				SetMultimap<Entry<String, String>, Entry<String, String>> entityTypeAnnotations,
				SetMultimap<Entry<String, Ref>, Entry<String, String>> entityAnnotations, Map<String, Ref> entities,
				Map<String, Object> bindings, SetMultimap<String, String> theEntityTypeAnnotations,
				SetMultimap<String, String> annotations) {
			this.title = title;
			this.relationships = relationships;
			this.relationshipTypes = relationshipTypes;
			this.relationshipTypeAnnotations = relationshipTypeAnnotations;
			this.relationshipAnnotations = relationshipAnnotations;
			this.entityTypes = entityTypes;
			this.entityTypeAnnotations = entityTypeAnnotations;
			this.entityAnnotations = entityAnnotations;
			this.entities = entities;
			this.bindings = bindings;
			this.theEntityTypeAnnotations = theEntityTypeAnnotations;
			this.annotations = annotations;
		}

		/**
		 * <p>
		 * Assigns the title, copies the builder
		 * </p>
		 * 
		 * @param title
		 *            The desired title
		 * @return Returns a copied builder
		 */
		public Builder setTitle(String title) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the relationships, copies the builder
		 * </p>
		 * 
		 * @param relationships
		 *            The desired relationships
		 * @return Returns a copied builder
		 */
		public Builder setRelationships(Multitable<String, String, String> relationships) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the relationship types, copies the builder
		 * </p>
		 * 
		 * @param relationshipTypes
		 *            The relationship types
		 * @return Returns a copied builder
		 */
		public Builder setRelationshipTypes(Multitable<Ref, Ref, String> relationshipTypes) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		public Builder setRelationshipTypeAnnotations(
				SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> relationshipTypeAnnotations) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the relationship type annotations, copies the builder
		 * </p>
		 * 
		 * @param relationshipAnnotations
		 *            The relationship type annotations
		 * @return Returns a copied builder
		 */
		public Builder setRelationshipAnnotations(
				SetMultimap<Cell<String, String, String>, Entry<String, String>> relationshipAnnotations) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the entity types, copies the builder
		 * </p>
		 * 
		 * @param entityTypes
		 *            The entity types
		 * @return Returns a copied builder
		 */
		public Builder setEntityTypes(Map<String, String> entityTypes) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the entity type annotations, copies the builder
		 * </p>
		 * 
		 * @param entityTypeAnnotations
		 *            The entity type annotations
		 * @return Returns a copied builder
		 */
		public Builder setEntityTypeAnnotations(
				SetMultimap<Entry<String, String>, Entry<String, String>> entityTypeAnnotations) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the entity annotations, copies the builder
		 * </p>
		 * 
		 * @param entityAnnotations
		 *            The entity annotations
		 * @return Returns a copied builder
		 */
		public Builder setEntityAnnotations(SetMultimap<Entry<String, Ref>, Entry<String, String>> entityAnnotations) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the entities, copies the builder
		 * </p>
		 * 
		 * @param entities
		 *            The entities
		 * @return Returns a copied builder
		 */
		public Builder setEntities(Map<String, Ref> entities) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the bindings, copies the builder
		 * </p>
		 * 
		 * @param bindings
		 *            The bindings
		 * @return Returns a copied builder
		 */
		public Builder setBindings(Map<String, Object> bindings) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the annotations, copies the builder
		 * </p>
		 * 
		 * @param annotations
		 *            The annotations
		 * @return Returns a copied builder
		 */
		public Builder setAnnotations(SetMultimap<String, String> annotations) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Assigns the entity type annotations, copies the builder
		 * </p>
		 * 
		 * @param annotations
		 *            The annotations
		 * @return Returns a copied builder
		 */
		public Builder setTheEntityTypeAnnotations(SetMultimap<String, String> theEntityTypeAnnotations) {
			return new Builder(title, relationships, relationshipTypes, relationshipTypeAnnotations,
					relationshipAnnotations, entityTypes, entityTypeAnnotations, entityAnnotations, entities, bindings,
					theEntityTypeAnnotations, annotations);
		}

		/**
		 * <p>
		 * Manifests the current builder into a knowledge base.
		 * </p>
		 * 
		 * @return Returns a knowledge base backed by the current state
		 */
		public KB build() {
			return new KB() {
				@Override
				public String getTitle() {
					return title;
				}

				@Override
				public Multitable<String, String, String> getRawRelationships() {
					return relationships;
				}

				@Override
				public Multitable<Ref, Ref, String> getRawRelationshipTypes() {
					return relationshipTypes;
				}

				@Override
				public SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> getRawRelationshipTypeAnnotations() {
					return relationshipTypeAnnotations;
				}

				@Override
				public SetMultimap<Cell<String, String, String>, Entry<String, String>> getRawRelationshipAnnotations() {
					return relationshipAnnotations;
				}

				@Override
				public Map<String, String> getRawEntityTypes() {
					return entityTypes;
				}

				@Override
				public SetMultimap<Entry<String, String>, Entry<String, String>> getRawEntityTypeAnnotations() {
					return entityTypeAnnotations;
				}

				@Override
				public SetMultimap<Entry<String, Ref>, Entry<String, String>> getRawEntityAnnotations() {
					return entityAnnotations;
				}

				@Override
				public Map<String, Ref> getRawEntities() {
					return entities;
				}

				@Override
				public Map<String, Object> getRawBindings() {
					return bindings;
				}

				@Override
				public SetMultimap<String, String> getRawTheEntityTypeAnnotations() {
					return theEntityTypeAnnotations;
				}

				@Override
				public SetMultimap<String, String> getRawAnnotations() {
					return annotations;
				}
			};
		}
	}

	// TODO: more of these single element builders
	public static KB bindingsKB(Map<String, Object> bindings) {
		return builder().setBindings(bindings).build();
	}

	public static KB clone(KB current) {
		return KBs.union(current, KBs.empty());
	}

	/**
	 * <p>
	 * Applies the union on the values of <code>a</code> and <code>b</code>.
	 * Uses the first knowledge bases title.
	 * </p>
	 * 
	 * @param a
	 *            The first knowledge base
	 * @param b
	 *            The second knowledge base
	 * @return Returns a new knowledge base
	 */
	public static KB union(KB a, KB b) {
		return KBs.builder().setTitle(a.getTitle())
				.setRelationships(Union.union(a.getRawRelationships(), b.getRawRelationships()))
				.setRelationshipTypes(Union.union(a.getRawRelationshipTypes(), b.getRawRelationshipTypes()))
				.setRelationshipTypeAnnotations(
						Union.union(a.getRawRelationshipTypeAnnotations(), b.getRawRelationshipTypeAnnotations()))
				.setRelationshipAnnotations(
						Union.union(a.getRawRelationshipAnnotations(), b.getRawRelationshipAnnotations()))
				.setEntityTypes(Union.union(a.getRawEntityTypes(), b.getRawEntityTypes()))
				.setEntityTypeAnnotations(Union.union(a.getRawEntityTypeAnnotations(), b.getRawEntityTypeAnnotations()))
				.setEntityAnnotations(Union.union(a.getRawEntityAnnotations(), b.getRawEntityAnnotations()))
				.setEntities(Union.union(a.getRawEntities(), b.getRawEntities()))
				.setBindings(Union.union(a.getRawBindings(), b.getRawBindings()))
				.setTheEntityTypeAnnotations(
						Union.union(a.getRawTheEntityTypeAnnotations(), b.getRawTheEntityTypeAnnotations()))
				.setAnnotations(Union.union(a.getRawAnnotations(), b.getRawAnnotations())).build();
	}

	/**
	 * <p>
	 * Applies the intersection on the values of <code>a</code> and
	 * <code>b</code>. Uses the first knowledge bases title.
	 * </p>
	 * 
	 * @param a
	 *            The first knowledge base
	 * @param b
	 *            The second knowledge base
	 * @return Returns a new knowledge base
	 */
	public static KB intersection(KB a, KB b) {
		return KBs.builder().setTitle(a.getTitle())
				.setRelationships(SetOperations.intersection(a.getRawRelationships(), b.getRawRelationships()))
				.setRelationshipTypes(
						SetOperations.intersection(a.getRawRelationshipTypes(), b.getRawRelationshipTypes()))
				.setRelationshipTypeAnnotations(SetOperations.intersection(a.getRawRelationshipTypeAnnotations(),
						b.getRawRelationshipTypeAnnotations()))
				.setRelationshipAnnotations(SetOperations.intersection(a.getRawRelationshipAnnotations(),
						b.getRawRelationshipAnnotations()))
				.setEntityTypes(SetOperations.intersection(a.getRawEntityTypes(), b.getRawEntityTypes()))
				.setEntityTypeAnnotations(
						SetOperations.intersection(a.getRawEntityTypeAnnotations(), b.getRawEntityTypeAnnotations()))
				.setEntityAnnotations(
						SetOperations.intersection(a.getRawEntityAnnotations(), b.getRawEntityAnnotations()))
				.setEntities(SetOperations.intersection(a.getRawEntities(), b.getRawEntities()))
				.setBindings(SetOperations.intersection(a.getRawBindings(), b.getRawBindings()))
				.setTheEntityTypeAnnotations(SetOperations.intersection(a.getRawTheEntityTypeAnnotations(),
						b.getRawTheEntityTypeAnnotations()))
				.setAnnotations(SetOperations.intersection(a.getRawAnnotations(), b.getRawAnnotations())).build();
	}

	/**
	 * <p>
	 * Applies the difference on the values of <code>a</code> and <code>b</code>
	 * . Uses the first knowledge bases title.
	 * </p>
	 * 
	 * @param a
	 *            The first knowledge base
	 * @param b
	 *            The second knowledge base
	 * @return Returns a new knowledge base
	 */
	public static KB difference(KB a, KB b) {
		return KBs.builder().setTitle(a.getTitle())
				.setRelationships(SetOperations.difference(a.getRawRelationships(), b.getRawRelationships()))
				.setRelationshipTypes(
						SetOperations.difference(a.getRawRelationshipTypes(), b.getRawRelationshipTypes()))
				.setRelationshipTypeAnnotations(SetOperations.difference(a.getRawRelationshipTypeAnnotations(),
						b.getRawRelationshipTypeAnnotations()))
				.setRelationshipAnnotations(
						SetOperations.difference(a.getRawRelationshipAnnotations(), b.getRawRelationshipAnnotations()))
				.setEntityTypes(SetOperations.difference(a.getRawEntityTypes(), b.getRawEntityTypes()))
				.setEntityTypeAnnotations(
						SetOperations.difference(a.getRawEntityTypeAnnotations(), b.getRawEntityTypeAnnotations()))
				.setEntityAnnotations(
						SetOperations.difference(a.getRawEntityAnnotations(), b.getRawEntityAnnotations()))
				.setEntities(SetOperations.difference(a.getRawEntities(), b.getRawEntities()))
				.setBindings(SetOperations.difference(a.getRawBindings(), b.getRawBindings()))
				.setTheEntityTypeAnnotations(SetOperations.difference(a.getRawTheEntityTypeAnnotations(),
						b.getRawTheEntityTypeAnnotations()))
				.setAnnotations(SetOperations.difference(a.getRawAnnotations(), b.getRawAnnotations())).build();
	}

	/**
	 * <p>
	 * Constructs an empty immutable KB.
	 * </p>
	 * 
	 * @return Returns an empty KB
	 */
	public static KB empty() {
		return KBs.builder().build();
	}

	/**
	 * <p>
	 * Starts a builder on empty values.
	 * </p>
	 * 
	 * @return Returns a builder
	 */
	public static Builder builder() {
		return new Builder(null, ImmutableMultitable.of(), ImmutableMultitable.of(), ImmutableSetMultimap.of(),
				ImmutableSetMultimap.of(), ImmutableMap.of(), ImmutableSetMultimap.of(), ImmutableSetMultimap.of(),
				ImmutableMap.of(), ImmutableMap.of(), ImmutableSetMultimap.of(), ImmutableSetMultimap.of());
	}

	/**
	 * <p>
	 * Constructs a mutable KB.
	 * </p>
	 * 
	 * @return Returns a mutable KB
	 */
	public static MutableKB mutable() {
		return new MutableKB();
	}

	public static boolean add(KB target, KB source) {
		boolean modflag = target.getRawRelationships().putAll(source.getRawRelationships());
		modflag |= target.getRawRelationshipTypes().putAll(source.getRawRelationshipTypes());
		modflag |= target.getRawRelationshipTypeAnnotations().putAll(source.getRawRelationshipTypeAnnotations());
		modflag |= target.getRawRelationshipAnnotations().putAll(source.getRawRelationshipAnnotations());

		int modcount = target.getRawEntityTypes().size();
		target.getRawEntityTypes().putAll(source.getRawEntityTypes());
		modflag |= modcount != target.getRawEntityTypes().size();

		modflag |= target.getRawEntityTypeAnnotations().putAll(source.getRawEntityTypeAnnotations());
		modflag |= target.getRawEntityAnnotations().putAll(source.getRawEntityAnnotations());

		modcount = target.getRawEntities().size();
		target.getRawEntities().putAll(source.getRawEntities());
		modflag |= modcount != target.getRawEntities().size();

		modcount = target.getRawBindings().size();
		target.getRawBindings().putAll(source.getRawBindings());
		modflag |= modcount != target.getRawBindings().size();

		modflag |= target.getRawTheEntityTypeAnnotations().putAll(source.getRawTheEntityTypeAnnotations());
		modflag |= target.getRawAnnotations().putAll(source.getRawAnnotations());
		return modflag;
	}
}
