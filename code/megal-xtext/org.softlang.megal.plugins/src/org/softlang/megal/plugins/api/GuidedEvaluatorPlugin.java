package org.softlang.megal.plugins.api;

import static com.google.common.collect.Lists.newArrayList;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedExitException.Level;

public abstract class GuidedEvaluatorPlugin extends InjectedEvaluatorPlugin {
	
	private final List<Closeable> closables;

	public GuidedEvaluatorPlugin() {
		closables = newArrayList();
	}

	protected void when(boolean condition) {
		if (!condition)
			throw new GuidedExitException(Level.NOT_RESPONSIBLE,
					"Condition not satisfied");
	}

	protected Object bindingOf(Entity entity) {
		if (!entity.hasBinding())
			throw new GuidedExitException(Level.NOT_RESPONSIBLE,
					"Binding of the entity " + entity + " is required");

		return entity.getBinding();
	}

	protected Artifact artifactOf(Entity entity) {
		if (!entity.hasBinding())
			throw new GuidedExitException(Level.NOT_RESPONSIBLE,
					"Binding of the entity " + entity + " is required");

		return getArtifact(entity.getBinding());
	}

	protected List<Artifact> artifactsOf(Entity entity) {
		if (!entity.hasBinding())
			throw new GuidedExitException(Level.NOT_RESPONSIBLE,
					"Binding of the entity " + entity + " is required");

		return getArtifacts(entity.getBinding());
	}

	protected InputStream bytesFor(Artifact artifact) throws IOException {
		InputStream stream = artifact.getBytes().openStream();
		closables.add(stream);
		return stream;
	}

	protected Reader charsFor(Artifact artifact) throws IOException {
		Reader stream = artifact.getChars().openStream();
		closables.add(stream);
		return stream;
	}

	private void closeAll() throws IOException {
		for (Closeable c : closables)
			c.close();
		closables.clear();
	}

	@Override
	protected final void evaluate(EntityType entityType) {
		try {
			guidedEvaluate(entityType);
			closeAll();
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
		}
	}

	@Override
	protected final void evaluate(RelationshipType relationshipType) {
		try {
			guidedEvaluate(relationshipType);
			closeAll();
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
		}
	}

	@Override
	protected final void evaluate(Entity entity) {
		try {
			guidedEvaluate(entity);
			closeAll();
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
		}
	}

	@Override
	protected final void evaluate(Relationship relationship) {
		try {
			guidedEvaluate(relationship);
			closeAll();
		} catch (GuidedExitException e) {
			GuidedExitException.handleGuideException(this, e);
		} catch (Throwable e) {
			GuidedExitException.handleOtherException(this, e);
		}
	}

	protected void guidedEvaluate(EntityType entityType) throws Throwable {
	}

	protected void guidedEvaluate(RelationshipType relationshipType)
			throws Throwable {
	}

	protected void guidedEvaluate(Entity entity) throws Throwable {
	}

	protected void guidedEvaluate(Relationship relationship) throws Throwable {
	}

}
