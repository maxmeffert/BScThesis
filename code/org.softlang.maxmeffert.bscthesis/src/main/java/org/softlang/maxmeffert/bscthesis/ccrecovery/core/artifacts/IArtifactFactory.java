package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import jdk.internal.util.xml.impl.Input;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

public interface IArtifactFactory {
    IArtifact newArtifact(ILanguage language, InputStream inputStream);
    IArtifact newArtifact(ILanguage language, String contents);
    IArtifact newArtifact(ILanguage language, URI location) throws IOException;
    IArtifact newArtifact(ILanguage language, File location) throws IOException;
}
