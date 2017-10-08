package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.net.URI;

public interface IArtifactFactory {
    IArtifact newArtifact(ILanguage language, URI location);
}
