package plugins.prelude;

import java.util.List;

import org.softlang.megal.mi2.Element;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.AbstractReasonerPlugin;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.mi2.api.context.Context;
import org.softlang.sourcesupport.SourceSupport;

public abstract class InjectedReasonerPlugin extends AbstractReasonerPlugin implements Context {
	private Context delegate;

	@Override
	public final KB derive(Context context, EntityType entityType) {
		delegate = context;
		return derive(entityType);
	}

	@Override
	public final KB derive(Context context, RelationshipType relationshipType) {
		delegate = context;
		return derive(relationshipType);
	}

	@Override
	public final KB derive(Context context, Entity entity) {
		delegate = context;
		return derive(entity);
	}

	@Override
	public final KB derive(Context context, Relationship relationship) {
		delegate = context;
		return derive(relationship);
	}

	protected KB derive(EntityType entityType) {
		return KBs.empty();
	}

	protected KB derive(RelationshipType relationshipType) {
		return KBs.empty();
	}

	protected KB derive(Entity entity) {
		return KBs.empty();
	}

	protected KB derive(Relationship relationship) {
		return KBs.empty();
	}

	@Override
	public SourceSupport getSourceSupport() {
		return delegate.getSourceSupport();
	}

	@Override
	public <T> Class<? extends T> getClass(Object binding, Class<T> deriving) {
		return delegate.getClass(binding, deriving);
	}

	@Override
	public <T> Class<? extends T> getClass(Object binding, Class<T> deriving, Class<?> nextTo) {
		return delegate.getClass(binding, deriving, nextTo);
	}

	@Override
	public List<Artifact> getArtifacts(Object binding) {
		return delegate.getArtifacts(binding);
	}

	@Override
	public Artifact getArtifact(Object binding) {
		return delegate.getArtifact(binding);
	}

	@Override
	public void valid() {
		delegate.valid();
	}

	@Override
	public void info(String message) {
		delegate.info(message);
	}

	@Override
	public void warning(String message) {
		delegate.warning(message);
	}

	@Override
	public void error(String message) {
		delegate.error(message);
	}

	@Override
	public void valid(Element x, Element... xs) {
		delegate.valid(x, xs);
	}

	@Override
	public void info(String message, Element x, Element... xs) {
		delegate.info(message, x, xs);
	}

	@Override
	public void warning(String message, Element x, Element... xs) {
		delegate.warning(message, x, xs);
	}

	@Override
	public void error(String message, Element x, Element... xs) {
		delegate.error(message, x, xs);
	}
}
