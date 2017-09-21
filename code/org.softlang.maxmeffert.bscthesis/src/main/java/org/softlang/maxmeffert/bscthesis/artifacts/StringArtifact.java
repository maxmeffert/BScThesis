package org.softlang.maxmeffert.bscthesis.artifacts;

public class StringArtifact implements IArtifact {

    private final String contents;

    public StringArtifact(String contents) {
        this.contents = contents;
    }

    @Override
    public String getContents() {
        return contents;
    }
}
