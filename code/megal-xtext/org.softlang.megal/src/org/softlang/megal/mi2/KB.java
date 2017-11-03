package org.softlang.megal.mi2;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;
import static com.google.common.base.Predicates.equalTo;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Maps.immutableEntry;
import static com.google.common.collect.Tables.immutableCell;
import static org.softlang.megal.util.Persistent.with;
import static org.softlang.megal.util.SetOperations.transform;
import static org.softlang.megal.util.SetOperations.translate;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.softlang.megal.util.Bijection;
import org.softlang.megal.util.Bijections;
import org.softlang.megal.util.Multitable;

import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Table.Cell;

/**
 * <p>
 * Class of knowledge bases on entity and typed relationships.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public abstract class KB {
	/**
	 * <p>
	 * This is the name of the top level entity. This entity has itself as a supertype. A {@link KB} is invalid, if it
	 * assigns a new type to this name.
	 * </p>
	 */
	public static final String ENTITY = "Entity";

	private final class ConvertedEntityType extends EntityType {
		private final Entry<String, String> from;

		public ConvertedEntityType(Entry<String, String> from) {
			this.from = from;
		}

		@Override
		public KB getKB() {
			return KB.this;
		}

		@Override
		public Multimap<String, String> getAnnotations() {
			// Translate the unstructured annotations
			return translate(getRawEntityTypeAnnotations().get(from));
		}

		@Override
		public Set<Entity> getInstances() {
			// All entities that are of this type or thats type is a
			// specialization of this type
			return Sets.filter(getEntities(), x -> equal(x.getType(), this) || x.getType().isSpecializationOf(this));
		}

		@Override
		public String getName() {
			// Name is specified by key
			return from.getKey();
		}

		@Override
		public Set<EntityType> getSpecializations() {
			// All entity types that are specializations of this type
			return Sets.filter(getEntityTypes(), x -> x.isSpecializationOf(this));
		}

		@Override
		public EntityType getSupertype() {
			// Entity type is specified by the value
			return getEntityType(from.getValue());
		}

		@Override
		public int hashCode() {
			return from.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			if (obj instanceof ConvertedEntityType)
				return equal(from, ((ConvertedEntityType) obj).from);

			return super.equals(obj);
		}

		@Override
		public String toString() {
			return from.getKey() + " < " + from.getValue();
		}
	}

	private final class ConvertedRelationshipType extends RelationshipType {
		private final Cell<Ref, Ref, String> from;

		public ConvertedRelationshipType(Cell<Ref, Ref, String> from) {
			this.from = from;
		}

		@Override
		public KB getKB() {
			return KB.this;
		}

		@Override
		public Multimap<String, String> getAnnotations() {
			// Translate the unstructured annotations
			return translate(getRawRelationshipTypeAnnotations().get(from));
		}

		@Override
		public Set<Relationship> getInstances() {
			// All relationships that are of this type or thats type is a
			// specialization of this type
			return Sets.filter(getRelationships(), x -> equal(x.getType(), this)
					|| x.getType().isSpecializationOf(this));
		}

		@Override
		public EntityType getLeft() {
			// Left type is specified values key
			return getEntityType(from.getRowKey().getType());
		}

		@Override
		public String getName() {
			// Name is specified by key
			return from.getValue();
		}

		@Override
		public EntityType getRight() {
			// Right type is specified values key
			return getEntityType(from.getColumnKey().getType());
		}

		@Override
		public Set<RelationshipType> getSpecializations() {
			// All relationship types that are specializations of this type
			return Sets.filter(getRelationshipTypes(from.getValue()), x -> x.isSpecializationOf(this));
		}

		@Override
		public int hashCode() {
			return from.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			if (obj instanceof ConvertedRelationshipType)
				return equal(from, ((ConvertedRelationshipType) obj).from);

			return super.equals(obj);
		}

		@Override
		public boolean isLeftMany() {
			// Left many is specified values key
			return from.getRowKey().isMany();
		}

		@Override
		public boolean isRightMany() {
			// Right many is specified values key
			return from.getColumnKey().isMany();
		}

		@Override
		public String toString() {
			return from.getValue() + "< " + from.getRowKey() + " * " + from.getColumnKey();
		}
	}

	private final class ConvertedEntity extends Entity {
		private final Entry<String, Ref> from;

		public ConvertedEntity(Entry<String, Ref> from) {
			this.from = from;
		}

		@Override
		public KB getKB() {
			return KB.this;
		}

		@Override
		public Multimap<String, String> getAnnotations() {
			// Translate the unstructured annotations
			return translate(getRawEntityAnnotations().get(from));
		}

		@Override
		public boolean hasBinding() {
			return getRawBindings().containsKey(from.getKey());
		}

		@Override
		public Object getBinding() {
			// Bindings are mapped from the key
			return getRawBindings().get(from.getKey());
		}

		@Override
		public String getName() {
			// Name is specified by key
			return from.getKey();
		}

		@Override
		public EntityType getType() {
			// Type is specified by value
			return getEntityType(from.getValue().getType());
		}

		@Override
		public int hashCode() {
			return from.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			if (obj instanceof ConvertedEntity)
				return equal(from, ((ConvertedEntity) obj).from);

			return super.equals(obj);
		}

		@Override
		public Set<Relationship> incoming() {
			// Incoming are in the relationship column of this entity
			return transform(getRawRelationships().whereColumn(from.getKey()), Relationship.class,
					relationshipBijection);
		}

		@Override
		public boolean isTypeMany() {
			// Many is specified by value
			return from.getValue().isMany();
		}

		@Override
		public Set<Relationship> outgoing() {
			// Outgoing are in the relationship column of this entity
			return transform(getRawRelationships().whereRow(from.getKey()), Relationship.class, relationshipBijection);
		}

		@Override
		public String toString() {
			return from.getKey() + ": " + from.getValue();
		}
	}

	private final class ConvertedRelationship extends Relationship {
		private final Cell<String, String, String> from;

		private ConvertedRelationship(Cell<String, String, String> from) {
			this.from = from;
		}

		@Override
		public KB getKB() {
			return KB.this;
		}

		/**
		 * <p>
		 * Loads by substitution.
		 * </p>
		 * 
		 * @param fromType
		 *            The from type
		 * @param toType
		 *            The to type
		 * @param candidates
		 *            The candidate relationships
		 * @return Returns the found relationship or absent if failed
		 */
		private Optional<RelationshipType> loadOrSubstitute(Ref fromType, Ref toType) {
			// If candidates contains an entry for the given pair, use it
			if (getRawRelationshipTypes().contains(fromType, toType, from.getValue()))
				return Optional.of(relationshipType(immutableCell(fromType, toType, from.getValue())));

			// Make supertype for the left side
			Ref fromTypeSupertype = Ref.to(getRawEntityTypes().get(fromType.getType()), fromType.isMany());

			// Make supertype for the right side
			Ref toTypeSupertype = Ref.to(getRawEntityTypes().get(toType.getType()), toType.isMany());

			// If left was not Entity
			if (fromTypeSupertype.getType() != null) {
				// Try left supertype
				Optional<RelationshipType> potential = loadOrSubstitute(fromTypeSupertype, toType);
				if (potential.isPresent())
					return potential;
			}

			// If right was not Entity
			if (toTypeSupertype.getType() != null) {
				// Try right supertype
				Optional<RelationshipType> potential = loadOrSubstitute(fromType, toTypeSupertype);
				if (potential.isPresent())
					return potential;
			}

			// If both were not Entity
			if (fromTypeSupertype.getType() != null && toTypeSupertype.getType() != null) {
				// Try both supertypes
				Optional<RelationshipType> potential = loadOrSubstitute(fromTypeSupertype, toTypeSupertype);
				if (potential.isPresent())
					return potential;
			}

			// Else, no chance to substitute
			return Optional.absent();
		}

		@Override
		public Multimap<String, String> getAnnotations() {
			// Translate the unstructured annotations
			return translate(getRawRelationshipAnnotations().get(from));
		}

		@Override
		public Entity getLeft() {
			// Left entity is specified in row key
			return getEntity(from.getRowKey());
		}

		@Override
		public Entity getRight() {
			// Left entity is specified in column key
			return getEntity(from.getColumnKey());
		}

		@Override
		public String getTypeName() {
			return from.getValue();
		}

		@Override
		public RelationshipType getType() {
			// Type is obtained by substitution lookup
			Ref fe = getRawEntities().get(from.getRowKey());
			Ref te = getRawEntities().get(from.getColumnKey());

			// Find an applicable relationship type
			return loadOrSubstitute(fe, te).orNull();
		}

		@Override
		public int hashCode() {
			return from.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			if (obj instanceof ConvertedRelationship)
				return equal(from, ((ConvertedRelationship) obj).from);

			return super.equals(obj);
		}

		@Override
		public String toString() {
			return from.getRowKey() + " " + from.getValue() + " " + from.getColumnKey();
		}
	}

	/**
	 * <p>
	 * Bijection object on the methods {@link #entity(Entry)} and {@link #entityInverse(Entity)}.
	 * </p>
	 */
	private final Bijection<Entry<String, Ref>, Entity> entityBijection = Bijections.of(this::entity,
			this::entityInverse);

	/**
	 * <p>
	 * Bijection object on the methods {@link #entityType(Entry)} and {@link #entityTypeInverse(EntityType)}.
	 * </p>
	 */
	private final Bijection<Entry<String, String>, EntityType> entityTypeBijection = Bijections.of(this::entityType,
			this::entityTypeInverse);

	/**
	 * <p>
	 * Bijection object on the methods {@link #relationship(Cell)} and {@link #relationshipInverse(Relationship)}.
	 * </p>
	 */
	private final Bijection<Cell<String, String, String>, Relationship> relationshipBijection = Bijections.of(
			this::relationship, this::relationshipInverse);

	/**
	 * <p>
	 * Bijection object on the methods {@link #relationshipType(Cell)} and
	 * {@link #relationshipTypeInverse(RelationshipType)}.
	 * </p>
	 */
	private final Bijection<Cell<Ref, Ref, String>, RelationshipType> relationshipTypeBijection = Bijections.of(
			this::relationshipType, this::relationshipTypeInverse);

	/*
	 * INTERFACE ========================================================================
	 */
	/**
	 * <p>
	 * Gets the title of this knowledge base.
	 * </p>
	 * 
	 * @return Returns the title
	 */
	public abstract String getTitle();

	/**
	 * <p>
	 * Gets the top level annotations, applied directly to the knowledge base.
	 * </p>
	 * 
	 * @return Returns the annotations
	 */
	public abstract SetMultimap<String, String> getRawAnnotations();

	/**
	 * <p>
	 * Gets the annotations to the root entity type.
	 * </p>
	 * 
	 * @return Returns the annotations
	 */
	public abstract SetMultimap<String, String> getRawTheEntityTypeAnnotations();

	/**
	 * <p>
	 * Maps the entity type name to their supertype.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract Map<String, String> getRawEntityTypes();

	/**
	 * <p>
	 * Maps from relationship type name to all their applicable type pairs.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract Multitable<Ref, Ref, String> getRawRelationshipTypes();

	/**
	 * <p>
	 * Maps the entity name to their type.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract Map<String, Ref> getRawEntities();

	/**
	 * <p>
	 * Maps from entity name to all their bindings.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract Map<String, Object> getRawBindings();

	/**
	 * <p>
	 * Maps from relationship name to all their instances.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract Multitable<String, String, String> getRawRelationships();

	/**
	 * <p>
	 * Gets a map from entity type entry to all annotations.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract SetMultimap<Entry<String, String>, Entry<String, String>> getRawEntityTypeAnnotations();

	/**
	 * <p>
	 * Gets a map from relationship type entry to all annotations.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> getRawRelationshipTypeAnnotations();

	/**
	 * <p>
	 * Gets a map from entity entry to all annotations.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract SetMultimap<Entry<String, Ref>, Entry<String, String>> getRawEntityAnnotations();

	/**
	 * <p>
	 * Gets a map from relationship entry to all annotations.
	 * </p>
	 * 
	 * @return Returns the data
	 */
	public abstract SetMultimap<Cell<String, String, String>, Entry<String, String>> getRawRelationshipAnnotations();

	/**
	 * <p>
	 * Maps an entry.
	 * </p>
	 * 
	 * @param from
	 *            The entry to map
	 * @return Returns the corresponding high level element
	 */
	private Entity entity(Entry<String, Ref> from) {
		return new ConvertedEntity(from);
	}

	private Entry<String, Ref> entityInverse(Entity entity) {
		return immutableEntry(entity.getName(), Ref.to(entity.getType().getName(), entity.isTypeMany()));
	}

	/**
	 * <p>
	 * Maps an entry.
	 * </p>
	 * 
	 * @param from
	 *            The entry to map
	 * @return Returns the corresponding high level element
	 */
	private EntityType entityType(Entry<String, String> from) {
		return new ConvertedEntityType(from);
	}

	private Entry<String, String> entityTypeInverse(EntityType entityType) {
		return immutableEntry(entityType.getName(), entityType.getSupertype() != null ? entityType.getSupertype()
				.getName() : null);
	}

	/**
	 * <p>
	 * Maps a cell.
	 * </p>
	 * 
	 * @param from
	 *            The cell to map
	 * @return Returns the corresponding high level element
	 */
	private Relationship relationship(final Cell<String, String, String> from) {
		return new ConvertedRelationship(from);
	}

	private Cell<String, String, String> relationshipInverse(Relationship relationship) {
		return immutableCell(relationship.getLeft().getName(), relationship.getRight().getName(),
				relationship.getTypeName());
	}

	/**
	 * <p>
	 * Maps an entry.
	 * </p>
	 * 
	 * @param from
	 *            The entry to map
	 * @return Returns the corresponding high level element
	 */
	private RelationshipType relationshipType(Cell<Ref, Ref, String> from) {
		return new ConvertedRelationshipType(from);
	}

	private Cell<Ref, Ref, String> relationshipTypeInverse(RelationshipType relationshipType) {
		return immutableCell(Ref.to(relationshipType.getLeft().getName(), relationshipType.isLeftMany()),
				Ref.to(relationshipType.getRight().getName(), relationshipType.isRightMany()),
				relationshipType.getName());
	}

	/**
	 * <p>
	 * Gets all elements defined in this knowledge base.
	 * </p>
	 * 
	 * @return Returns a set of all elements
	 */
	public Set<Element> getElements() {
		return Sets.union(Sets.union(Sets.union(getEntityTypes(), getRelationshipTypes()), getEntities()),
				getRelationships());
	}

	/**
	 * <p>
	 * Gets the top level annotations of the model.
	 * </p>
	 * 
	 * @return Returns the annotations
	 */
	public Multimap<String, String> getAnnotations() {
		// Annotations are carried in the KB
		return getRawAnnotations();
	}

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
		return getAnnotations().containsEntry(name, null);
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

	/**
	 * <p>
	 * Gets all entities.
	 * </p>
	 * 
	 * @return Iterates over all entities
	 */
	public Set<Entity> getEntities() {
		// Transform all entries of the entities in the KB
		return transform(getRawEntities().entrySet(), Entity.class, entityBijection);
	}

	/**
	 * <p>
	 * Gets the entity for the name.
	 * </p>
	 * 
	 * @param name
	 *            The name of the entity
	 * @return Returns the entity
	 */
	public Entity getEntity(String name) {
		// Get the type by KB lookup
		Ref type = getRawEntities().get(name);

		// If null, then there was no mapping
		if (type == null)
			return null;

		// Wrap the pair
		return entity(immutableEntry(name, type));
	}

	/**
	 * <p>
	 * Gets the entity type for the name.
	 * </p>
	 * 
	 * @param name
	 *            The name of the entity type
	 * @return Returns the entity type
	 */
	public EntityType getEntityType(String name) {
		// If name is Entity as defined by KB constants, return the Entity type
		if (KB.ENTITY.equals(name))
			return getTheEntityType();

		// Get the supertype by KB lookup
		String supertype = getRawEntityTypes().get(name);

		// If null, then there was no mapping
		if (supertype == null)
			return null;

		// Wrap the pair
		return entityType(immutableEntry(name, supertype));
	}

	/**
	 * <p>
	 * Gets all entity types.
	 * </p>
	 * 
	 * @return Iterates over all entity types
	 */
	public Set<EntityType> getEntityTypes() {
		// Get all newly defined entity types after the Entity type
		return with(getTheEntityType(),
				transform(getRawEntityTypes().entrySet(), EntityType.class, entityTypeBijection));
	}

	/**
	 * <p>
	 * Gets the relationship for the names.
	 * </p>
	 * 
	 * @param left
	 *            The name of the left entity
	 * 
	 * @param relationship
	 *            The name of the relationship
	 * 
	 * @param right
	 *            The name of the right entity
	 * @return Returns the entity
	 */
	public Relationship getRelationship(String left, String relationship, String right) {
		if (!getRawRelationships().contains(left, right, relationship))
			return null;

		return relationship(immutableCell(left, right, relationship));
	}

	/**
	 * <p>
	 * Gets all relationships.
	 * </p>
	 * 
	 * @return Iterates over all relationships
	 */
	public Set<Relationship> getRelationships() {
		// Transform all entries of the relationships in the KB
		return transform(getRawRelationships().cells(), Relationship.class, relationshipBijection);
	}

	/**
	 * <p>
	 * Gets the relationship type for the name. Uses empty parameters.
	 * </p>
	 * 
	 * @param name
	 *            The name of the relationship type
	 * @param left
	 *            The definition of the left side
	 * @param leftMany
	 *            True if left is many
	 * @param right
	 *            The definition of the right side
	 * @param rightMany
	 *            True if right is many
	 * 
	 * @return Returns the relationship type
	 */
	public RelationshipType getRelationshipType(String name, String left, boolean leftMany, String right,
			boolean rightMany) {
		Ref leftType = Ref.to(left, leftMany);
		Ref rightType = Ref.to(right, rightMany);
		Set<String> names = getRawRelationshipTypes().get(leftType, rightType);

		if (names.contains(name))
			return relationshipType(immutableCell(leftType, rightType, name));

		return null;
	}

	/**
	 * <p>
	 * Gets the relationship type for the name. Uses false for many and empty parameters.
	 * </p>
	 * 
	 * @param name
	 *            The name of the relationship type
	 * @param left
	 *            The definition of the left side
	 * @param right
	 *            The definition of the right side
	 * 
	 * @return Returns the relationship type
	 */
	public RelationshipType getRelationshipType(String name, String left, String right) {
		return getRelationshipType(name, left, false, right, false);
	}

	/**
	 * <p>
	 * Gets all relationship types.
	 * </p>
	 * 
	 * @return Iterates over all relationship types
	 */
	public Set<RelationshipType> getRelationshipTypes() {
		// Transform all entries of the relationship types in the KB
		return transform(getRawRelationshipTypes().cells(), RelationshipType.class, relationshipTypeBijection);
	}

	/**
	 * <p>
	 * Gets all relationships for the given name.
	 * </p>
	 * 
	 * @param name
	 *            The name to find
	 * @return Returns an iterable on the relationship types
	 */
	public Set<RelationshipType> getRelationshipTypes(String name) {
		// Lookup relationship type multimap by name and wrap the triples
		return transform(getRawRelationshipTypes().whereValue(name), RelationshipType.class, relationshipTypeBijection);
	}

	/**
	 * <p>
	 * Gets the one entity type that is {@link KB#ENTITY}.
	 * </p>
	 * 
	 * @return Returns the entity type
	 */
	public EntityType getTheEntityType() {
		return new EntityType() {
			@Override
			public KB getKB() {
				return KB.this;
			}

			@Override
			public Multimap<String, String> getAnnotations() {
				// Annotations are carried in the KB
				return getRawTheEntityTypeAnnotations();
			}

			@Override
			public Set<Entity> getInstances() {
				// All entities are instances of Entity
				return getEntities();
			}

			@Override
			public String getName() {
				// Name is the name given in the KB constants
				return KB.ENTITY;
			}

			@Override
			public Set<EntityType> getSpecializations() {
				// All entity types that are not Entity itself are
				// specializations of Entity
				return Sets.filter(getEntityTypes(), not(equalTo(this)));
			}

			@Override
			public EntityType getSupertype() {
				// Entity has no supertype (same as for
				// Object.class.getSuperclass())
				return null;
			}

			@Override
			public int hashCode() {
				return KB.ENTITY.hashCode();
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;

				if (!(obj instanceof EntityType))
					return false;

				EntityType other = (EntityType) obj;

				return equal(getName(), other.getName());
			}

			@Override
			public String toString() {
				return KB.ENTITY;
			}
		};
	}

	public boolean isEmpty() {
		return getRawAnnotations().isEmpty() && getRawBindings().isEmpty() && getRawEntities().isEmpty()
				&& getRawEntityAnnotations().isEmpty() && getRawEntityTypeAnnotations().isEmpty()
				&& getRawEntityTypes().isEmpty() && getRawRelationshipAnnotations().isEmpty()
				&& getRawRelationships().isEmpty() && getRawRelationshipTypeAnnotations().isEmpty()
				&& getRawRelationshipTypes().isEmpty() && getRawTheEntityTypeAnnotations().isEmpty();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getRawAnnotations(), getRawTheEntityTypeAnnotations(), getRawBindings(),
				getRawEntities(), getRawEntityAnnotations(), getRawEntityTypeAnnotations(), getRawEntityTypes(),
				getRawRelationshipAnnotations(), getRawRelationshipTypeAnnotations(), getRawRelationshipTypes(),
				getRawRelationships(), getTitle());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		KB other = (KB) obj;

		return equal(getRawAnnotations(), other.getRawAnnotations())
				&& equal(getRawTheEntityTypeAnnotations(), other.getRawTheEntityTypeAnnotations())
				&& equal(getRawBindings(), other.getRawBindings()) && equal(getRawEntities(), other.getRawEntities())
				&& equal(getRawEntityAnnotations(), other.getRawEntityAnnotations())
				&& equal(getRawEntityTypeAnnotations(), other.getRawEntityTypeAnnotations())
				&& equal(getRawEntityTypes(), other.getRawEntityTypes())
				&& equal(getRawRelationshipAnnotations(), other.getRawRelationshipAnnotations())
				&& equal(getRawRelationshipTypeAnnotations(), other.getRawRelationshipTypeAnnotations())
				&& equal(getRawRelationshipTypes(), other.getRawRelationshipTypes())
				&& equal(getRawRelationships(), other.getRawRelationships()) && equal(getTitle(), other.getTitle());
	}

	@Override
	public String toString() {
		return toStringHelper(this).add("title", getTitle()).add("entityTypes", getRawEntityTypes())
				.add("relationshipTypes", getRawRelationshipTypes()).add("entities", getRawEntities())
				.add("relationships", getRawRelationships()).add("bindings", getRawBindings())
				.add("annotations", getRawAnnotations())
				.add("theEntityTypeAnnotations", getRawTheEntityTypeAnnotations())
				.add("entityTypeAnnotations", getRawEntityTypeAnnotations())
				.add("relationshipTypeAnnotations", getRawRelationshipTypeAnnotations())
				.add("entityAnnotations", getRawEntityAnnotations())
				.add("relationshipAnnotations", getRawRelationshipAnnotations()).toString();
	}
}
