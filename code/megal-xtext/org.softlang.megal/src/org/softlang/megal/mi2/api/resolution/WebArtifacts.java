package org.softlang.megal.mi2.api.resolution;

import java.net.URL;

import org.softlang.megal.mi2.api.Artifact;

public class WebArtifacts {
	public static Artifact toArtifact(URL url) {
		return new URLArtifact(url);
	}
}
