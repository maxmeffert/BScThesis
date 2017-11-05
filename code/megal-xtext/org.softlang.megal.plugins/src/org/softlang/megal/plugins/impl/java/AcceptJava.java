package org.softlang.megal.plugins.impl.java;

import java.io.IOException;
import java.io.Reader;

import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.AcceptorPlugin;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.google.common.base.Optional;
import com.google.common.base.Throwables;

public class AcceptJava extends AcceptorPlugin {
	@Override
	public Optional<String> accept(Artifact artifact) {
		try (Reader s = artifact.getChars().openStream()) {
			JavaParser.parse(s, false);
			return Optional.absent();
		} catch (ParseException e) {
			return Optional.of("The artifact " + artifact.getName()
					+ " is not an element of Java, reason: " + e.getMessage());
		} catch (IOException e) {
			return Optional.of(Throwables.getStackTraceAsString(e));
		}
	}

}
