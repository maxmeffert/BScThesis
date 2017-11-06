package org.softlang.megal.plugins.api.recovery;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.AbstractPlugin;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.IGuidedReasonerProxy;

public abstract class FragmentRecoveryPlugin extends AbstractPlugin {
		
	abstract public void derive(IGuidedReasonerProxy reasoner, Entity entity, Artifact artifact);
	
}
