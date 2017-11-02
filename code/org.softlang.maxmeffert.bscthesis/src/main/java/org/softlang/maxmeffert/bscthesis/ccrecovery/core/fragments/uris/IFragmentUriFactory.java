package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.net.URI;
import java.net.URISyntaxException;

public interface IFragmentUriFactory {
    URI newFragmentUri(URI artifactUri, IFragment fragment) throws URISyntaxException;
}
