package org.softlang.megal.plugins.impl.java;

import java.io.IOException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.CCRecoveryScenarios;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.ICCRecoveryScenarios;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.acceptors.AcceptorPlugin;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

public class JavaAcceptorPlugin extends AcceptorPlugin {
	
	private final ICCRecoveryScenarios recovery = CCRecoveryScenarios.create();
	
	private void parseArtifact(Artifact artifact) throws IOException, ParserException {
		recovery.getJava8Parser().parse(artifact.getBytes().openStream());
	}
	
	private Optional<String> getErrorMessage(Artifact artifact, Throwable throwable) {
		return Optional.of("The artifact " + artifact.getName() + " is not an element of Java, reason: " + throwable.getMessage());
	}
	
	@Override
	public Optional<String> accept(Artifact artifact) {
		try {
			parseArtifact(artifact);
			return Optional.absent();
		} catch (IOException e) {
			return Optional.of(Throwables.getStackTraceAsString(e));
		} catch (ParserException e) {
			return getErrorMessage(artifact, e);
		}
	}

}
