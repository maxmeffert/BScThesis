package org.softlang.megal.plugins.api.fragmentation;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;

public abstract class GuidedFragmentReasonerPlugin extends GuidedReasonerPlugin {
	
	protected Optional<Fragment> fragmentOf (URI uri) {
		return Fragments.fragmentOf(uri);
	}
	
	protected Optional<Fragment> fragmentOf (Entity entity) {
		return Fragments.fragmentOf(entity);
	}
	
	protected List<Fragment> fragmentsOf (Entity entity) {
		return Fragments.fragmentsOf(entity);
	}
	
	protected List<Fragment> fragmentsOf (Artifact artifact) {
		return Fragments.fragmentsOf(artifact);
	}
	
}