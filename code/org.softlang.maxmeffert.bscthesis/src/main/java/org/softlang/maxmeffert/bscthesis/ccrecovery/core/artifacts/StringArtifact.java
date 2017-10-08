package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

public class StringArtifact implements IArtifact {

    private final String contents;

    public StringArtifact(String contents) {
        this.contents = contents;
    }

    @Override
    public ILanguage getLanguage() {
        return null;
    }

    @Override
    public String getContents() {
        return contents;
    }
}
