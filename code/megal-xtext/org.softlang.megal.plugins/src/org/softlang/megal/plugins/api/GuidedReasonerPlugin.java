package org.softlang.megal.plugins.api;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.MutableKB;
import org.softlang.megal.mi2.Ref;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedExitException.Level;

//TODO: Loads of duplication because of problems with multiple aspects

/**
 * Abstract base class for guided reasoner plugins. 
 * 
 * @author lukashaertel
 * @author maxmeffert
 *
 */
public abstract class GuidedReasonerPlugin extends InjectedReasonerPlugin {
	
	/**
	 * A collection of closable objects  
	 */
	private final List<Closeable> closables = new ArrayList<Closeable>();;

	/**
	 * The model extension aka the result.
	 */
	private MutableKB result;
	
	/* ========================================================================
	 * Utility methods
	 * ========================================================================
	 */
	
	/**
	 * Closes all collected closable objects.
	 * Clears the collection afterwards.
	 * 
	 * @throws IOException
	 */
	private void closeAll() throws IOException {
		
		for (Closeable c : closables) {
			c.close();
		}
			
		closables.clear();
		
	}

	/**
	 * Resets the model extension aka the result.
	 */
	private void resetResult() {
		result = new MutableKB();
	}
	
	/* ========================================================================
	 * Conditional exit methods
	 * ========================================================================
	 */
	
	/**
	 * Checks a given condition.
	 * 
	 * <p>
	 * If the condition is not satisfied, a GuidedExitException will be thrown, which will end the plugin evaluation.
	 * As a rule of thumb: DO NOT put when-calls inside try-catch-blocks or make sure that GuidedExitException are not caught.
	 * <p>
	 * 
	 * @param condition
	 */
	protected void when(boolean condition) {
		
		if (!condition) {
			throw new GuidedExitException(Level.NOT_RESPONSIBLE, "Condition not satisfied");
		}
		
	}

	/* ========================================================================
	 * IO utility methods
	 * ========================================================================
	 */
	
	/**
	 * Gets the bind of a given entity.
	 * 
	 * @param entity The given entity.
	 * @return The binding.
	 */
	protected URI bindingOf(Entity entity) {
		
		if (!entity.hasBinding()) {
			throw new GuidedExitException(Level.NOT_RESPONSIBLE, "Binding of the entity " + entity + " is required");
		}
		
		try {
		
			Object binding = entity.getBinding();
			
			if (binding instanceof URI) {
				
				return (URI) entity.getBinding();
				
			}
			else if (binding instanceof String) {
				
				return new URI((String)binding);
				
			}
		
		} catch (URISyntaxException e) {
			// do nothing!
		}

		throw new IllegalStateException("Binding is not a valid URI!");
		
	}

	/**
	 * Gets the bound artifact of a given entity.
	 * 
	 * @param entity The given entity.
	 * @return The bound artifact.
	 */
	protected Artifact artifactOf(Entity entity) {
		if (!entity.hasBinding())
			throw new GuidedExitException(Level.NOT_RESPONSIBLE,
					"Binding of the entity " + entity + " is required");

		return getArtifact(entity.getBinding());
	}

	/**
	 * Gets the list of bound artifacts of a given entity.
	 * 
	 * @param entity The given entity.
	 * @return The list of bound artifacts.
	 * @deprecated
	 */
	protected List<Artifact> artifactsOf(Entity entity) {
		if (!entity.hasBinding())
			throw new GuidedExitException(Level.NOT_RESPONSIBLE,
					"Binding of the entity " + entity + " is required");

		return getArtifacts(entity.getBinding());
	}

	/**
	 * Gets the bytes in form of an InputStream of a given artifact.
	 * 
	 * @param artifact The given artifact.
	 * @return The bytes in form of an InputStream
	 * @throws IOException
	 */
	protected InputStream bytesFor(Artifact artifact) throws IOException {
		
		InputStream stream = artifact.getBytes().openStream();
		
		closables.add(stream);
		
		return stream;
		
	}
	
	/**
	 * Gets the bytes in form of an InputStream of a given entity.
	 * 
	 * @param entity The given entity.
	 * @return The bytes in form of an InputStream.
	 * @throws IOException
	 */
	protected InputStream bytesFor (Entity entity) throws IOException {
		
		return bytesFor(artifactOf(entity));
		
	}
	
	/**
	 * Gets the chars in form of a Reader of a given artifact.
	 * 
	 * @param artifact The given artifact.
	 * @return The chars in form of a Reader.
	 * @throws IOException
	 */
	protected Reader charsFor(Artifact artifact) throws IOException {
		
		Reader stream = artifact.getChars().openStream();
		
		closables.add(stream);
		
		return stream;
		
	}
	
	/**
	 * Gets the chars in form of a Reader of a given entity.
	 * 
	 * @param entity The given entity.
	 * @return The chars in form of a Reader.
	 * @throws IOException
	 */
	protected Reader charsFor (Entity entity) throws IOException {
	
		return charsFor(artifactOf(entity));
		
	}
	
	/* ========================================================================
	 * Result mutators and queries
	 * ========================================================================
	 */
	
	/**
	 * Sets the title of the model extension.
	 * @param title The title string.
	 */
	protected void title(String title) {
		result.setTitle(title);
	}

	/**
	 * Creates an new entity type as specialization of a given super-type name.
	 * @param type The name of the new entity type.
	 * @param supertype The name of the super-type.
	 * @return The new entity type.
	 */
	protected EntityType entityType(String type, String supertype) {
		
		result.getRawEntityTypes().put(type, supertype);
		
		return result.getEntityType(type);
		
	}

	/**
	 * Creates a new relationship type.
	 * @param left The reference to the left entity type.
	 * @param right The reference to the right entity type.
	 * @param name The name of the new relationship type.
	 * @return The new relationship type.
	 */
	protected RelationshipType relationshipType(Ref left, Ref right, String name) {
		
		result.getRawRelationshipTypes().put(left, right, name);
		
		return result.getRelationshipType(name, left.getType(), left.isMany(), right.getType(), right.isMany());
		
	}

	/**
	 * Creates a new relationship type.
	 * <p>
	 * Defaults multiplicity to single!
	 * </p>
	 * 
	 * @param left The name of the left entity type.
	 * @param right The name of the right entity type.
	 * @param name The name of the new relationship type.
	 * @return The new relationship type.
	 */
	protected RelationshipType relationshipType(String left, String right, String name) {
		
		result.getRawRelationshipTypes().put(Ref.to(left, false), Ref.to(right, false), name);
		
		return result.getRelationshipType(name, left, right);
		
	}

	/**
	 * Creates a new entity of a given entity type.
	 * @param name The name of the new entity.
	 * @param type The reference to the entity type.
	 * @return The new entity.
	 */
	protected Entity entity(String name, Ref type) {
		
		result.getRawEntities().put(name, type);
		
		return result.getEntity(name);
		
	}

	/**
	 * Creates a new entity of a given entity type.
	 * @param name The name of the new entity.
	 * @param type The name of the entity type.
	 * @return The new entity.
	 */
	protected Entity entity(String name, String type) {
		
		result.getRawEntities().put(name, Ref.to(type, false));
		
		return result.getEntity(name);
		
	}

	/**
	 * Creates a new relationship between two entities.
	 * @param left The name of the left entity.
	 * @param right The name of the right entity.
	 * @param relationshipType name of the relationship type.
	 * @return The new relationship.
	 */
	protected Relationship relationship(String left, String right, String relationshipType) {
		
		result.getRawRelationships().put(left, right, relationshipType);
		
		return result.getRelationship(left, relationshipType, right);
		
	}

	/**
	 * Binds an entity to an URI.
	 * @param entity The entity.
	 * @param binding The URI
	 */
	protected void binding(String entity, URI binding) {
		
		result.getRawBindings().put(entity, binding);
		
	}
	
	/**
	 * Binds an entity to an URI.
	 * @param entity The entity.
	 * @param binding The URI
	 */
	protected void binding(String entity, String binding) throws URISyntaxException {
		
		binding(entity, new URI(binding));
		
	}

	/* ========================================================================
	 * Implementations for injected derive methods
	 * ========================================================================
	 */
	
	@Override
	protected KB derive(EntityType entityType) {
		try {
			resetResult();
			guidedDerive(entityType);
			closeAll();
			return result;
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
			return KBs.empty();
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
			return KBs.empty();
		}
	}

	@Override
	protected KB derive(RelationshipType relationshipType) {
		try {
			resetResult();
			guidedDerive(relationshipType);
			closeAll();
			return result;
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
			return KBs.empty();
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
			return KBs.empty();
		}
	}

	@Override
	protected KB derive(Entity entity) {
		try {
			resetResult();
			guidedDerive(entity);
			closeAll();
//			System.err.println(entity.getName());
//			System.err.println(result.getRawEntities().size());
			return result;
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
			return KBs.empty();
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
			return KBs.empty();
		}
	}

	@Override
	protected KB derive(Relationship relationship) {
		try {
			resetResult();
			guidedDerive(relationship);
			closeAll();
			return result;
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
			return KBs.empty();
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
			return KBs.empty();
		}
	}

	/* ========================================================================
	 * Base implementations for guided derive methods
	 * ========================================================================
	 */
	
	protected void guidedDerive(EntityType entityType) throws Throwable {
	}

	protected void guidedDerive(RelationshipType relationshipType)
			throws Throwable {
	}

	protected void guidedDerive(Entity entity) throws Throwable {
	}

	protected void guidedDerive(Relationship relationship) throws Throwable {
	}
}
