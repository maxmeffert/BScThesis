package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.net.URI;
import java.net.URISyntaxException;

public interface IFragmentUriConverter {
    URI toFragmentUri(URI artifactUri, IFragment fragment) throws URISyntaxException;
    URI toFragmentUri(URI artifactUri, IFragmentPosition fragmentPosition) throws URISyntaxException;
    IFragmentPosition toFragmentPosition(URI fragmentUri);
}
