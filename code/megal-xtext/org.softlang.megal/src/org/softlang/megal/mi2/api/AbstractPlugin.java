package org.softlang.megal.mi2.api;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.softlang.megal.mi2.Entity;

public abstract class AbstractPlugin implements Plugin {
	private final Set<Plugin> parts;

	private final Set<Entity> realization;

	public AbstractPlugin() {
		this.parts = newHashSet();
		this.realization = newHashSet();
	}

	@Override
	public Set<Plugin> getParts() {
		return parts;
	}

	@Override
	public Set<Entity> getRealization() {
		return realization;
	}

}
