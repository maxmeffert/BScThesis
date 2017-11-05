package org.softlang.megal.plugins.impl.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.FragmentizerPlugin;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;

public class JavaFragmentizer3 extends FragmentizerPlugin {

	@Override
	public Collection<Fragment> getFragments(Entity entity, Artifact artifact) {
		ICCRecoveryScenarios recovery = CCRecoveryScenarios.create();
		try {
			IFragment fragment = recovery.getJava8Parser().parse(artifact.getBytes().openStream());
			
		} catch (IOException e) {
			System.err.print(e);
		} catch (ParserException e) {
			System.err.print(e);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Fragment>();
	}

}
