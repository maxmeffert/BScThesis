package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.net.URI;

public interface IArtifact {
    ILanguage getLanguage();
    URI getLocation();
}
