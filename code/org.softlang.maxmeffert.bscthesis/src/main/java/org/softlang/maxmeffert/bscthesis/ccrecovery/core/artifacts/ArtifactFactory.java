package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;

public class ArtifactFactory implements IArtifactFactory {
    @Override
    public IArtifact newArtifact(ILanguage language, InputStream inputStream) {
        return new Artifact(language, inputStream);
    }

    @Override
    public IArtifact newArtifact(ILanguage language, String contents) {
        return newArtifact(language, new ByteArrayInputStream(contents.getBytes()));
    }

    @Override
    public IArtifact newArtifact(ILanguage language, URI location) throws IOException {
        return newArtifact(language, location.toURL().openStream());
    }

    @Override
    public IArtifact newArtifact(ILanguage language, File location) throws IOException {
        return newArtifact(language, new FileInputStream(location));
    }
}
