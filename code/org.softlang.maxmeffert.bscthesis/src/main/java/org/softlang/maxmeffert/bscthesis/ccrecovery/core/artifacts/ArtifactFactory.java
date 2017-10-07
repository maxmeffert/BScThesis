package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

public class ArtifactFactory implements IArtifactFactory {
    @Override
    public IArtifact newStringArtifact(String string) {
        return new StringArtifact(string);
    }
}
