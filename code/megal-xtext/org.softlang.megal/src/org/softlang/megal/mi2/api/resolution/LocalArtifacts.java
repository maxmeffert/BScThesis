package org.softlang.megal.mi2.api.resolution;

import java.io.File;

import org.softlang.megal.mi2.api.Artifact;

public class LocalArtifacts {
	public static Artifact toArtifact(File file) {
		return new FileArtifact(file);
	}
}
