package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.net.URI;

public class Artifact implements IArtifact {

    private final ILanguage language;
    private final URI location;
    private String contents;

    public Artifact(ILanguage language, URI location) {
        this.language = language;
        this.location = location;
    }

    @Override
    public ILanguage getLanguage() {
        return language;
    }

    @Override
    public URI getLocation() {
        return location;
    }

}
