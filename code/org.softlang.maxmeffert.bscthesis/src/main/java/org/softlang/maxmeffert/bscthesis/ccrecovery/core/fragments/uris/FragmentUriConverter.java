package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionEncoder;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FragmentUriConverter implements IFragmentUriConverter {

    private static Map<String,String> getQueryParameters(URI uri) {
        return Arrays.stream(uri.getQuery().split(QueryArgumentSeparator))
                .map(str -> str.split(QueryAssignmentSeparator))
                .map(array -> new String[] {
                        array.length > 0 ? array[0] : null,
                        array.length > 1 ? array[1] : null
                })
                .collect(Collectors.toMap(a -> a[0], a -> a[1]));
    }

    public static final String QueryArgumentSeparator = "&";
    public static final String QueryAssignmentSeparator = "=";
    public static final String FragmentQueryKey = "fragment";
    public static final String FragmentQueryInterpolation = FragmentQueryKey + QueryAssignmentSeparator + "%s";

    private final IFragmentPositionFactory fragmentPositionFactory;
    private final IFragmentPositionEncoder fragmentPositionEncoder;

    public FragmentUriConverter(IFragmentPositionFactory fragmentPositionFactory, IFragmentPositionEncoder fragmentPositionEncoder) {
        this.fragmentPositionFactory = fragmentPositionFactory;
        this.fragmentPositionEncoder = fragmentPositionEncoder;
    }

    private String encode(IFragmentPosition fragmentPosition) {
        return fragmentPositionEncoder.encode(fragmentPosition);
    }

    private IFragmentPosition decode(String fragmentPosition) {
        return fragmentPositionEncoder.decode(fragmentPosition);
    }

    private String toFragmentQuery(IFragmentPosition fragmentPosition) {
        return String.format(FragmentQueryInterpolation, encode(fragmentPosition));
    }

    private URI appendQuery(URI uri, String query) throws URISyntaxException {
        String oldQuery = uri.getQuery();
        String newQuery = oldQuery == null ? query : oldQuery + QueryArgumentSeparator + query;
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment());
    }

    @Override
    public URI toFragmentUri(URI artifactUri, IFragmentPosition fragmentPosition) throws URISyntaxException {
        return appendQuery(artifactUri, toFragmentQuery(fragmentPosition));
    }

    @Override
    public URI toFragmentUri(URI artifactUri, IFragment fragment) throws URISyntaxException {
        return toFragmentUri(artifactUri, fragment.getPosition());
    }

    @Override
    public IFragmentPosition toFragmentPosition(URI fragmentUri) {
        Map<String,String> queryParameters = getQueryParameters(fragmentUri);
        if (queryParameters.containsKey(FragmentQueryKey)) {
            return decode(queryParameters.get(FragmentQueryKey));
        }
        return fragmentPositionFactory.newEmptyFragmentPosition();
    }


}
