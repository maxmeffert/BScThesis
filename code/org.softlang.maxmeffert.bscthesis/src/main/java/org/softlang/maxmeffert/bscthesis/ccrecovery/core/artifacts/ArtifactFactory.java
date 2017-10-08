package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.net.URI;

public class ArtifactFactory implements IArtifactFactory {
    @Override
    public IArtifact newArtifact(ILanguage language, URI location) {
        return new Artifact(language, location);
    }
}
