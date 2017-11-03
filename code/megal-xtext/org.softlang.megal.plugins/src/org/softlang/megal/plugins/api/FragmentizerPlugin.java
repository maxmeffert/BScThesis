package org.softlang.megal.plugins.api;

import java.util.Collection;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.AbstractPlugin;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;

public abstract class FragmentizerPlugin extends AbstractPlugin {
	
	abstract public Collection<Fragment> getFragments (Entity entity, Artifact artifact);
	
}
