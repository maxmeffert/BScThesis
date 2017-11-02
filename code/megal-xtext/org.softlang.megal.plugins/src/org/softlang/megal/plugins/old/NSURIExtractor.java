package org.softlang.megal.plugins.old;

import java.net.URI;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.AbstractPlugin;
import org.softlang.megal.mi2.api.resolution.Resolution;

public abstract class NSURIExtractor extends AbstractPlugin {
	public abstract URI extractNSURI(Resolution resolution, Entity entity);
}
