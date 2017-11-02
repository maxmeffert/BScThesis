package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionEncoder;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionEncoderFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FragmentUriFactory implements IFragmentUriFactory {

    public static final String QueryArgumentSeparator = "&";
    public static final String QueryAssignmentSeparator = "=";

    private final IFragmentPositionEncoderFactory fragmentPositionEncoderFactory;

    @Inject
    public FragmentUriFactory(IFragmentPositionEncoderFactory fragmentPositionEncoderFactory) {
        this.fragmentPositionEncoderFactory = fragmentPositionEncoderFactory;
    }

    private String encode(IFragment fragment) {
        return fragmentPositionEncoderFactory.newFragmentPositionEncoder().encode(fragment.getPosition());
    }

    private String toFragmentQuery(IFragment fragment) {
        return "fragment" + QueryAssignmentSeparator + encode(fragment);
    }

    private URI appendQuery(URI uri, String query) throws URISyntaxException {
        String oldQuery = uri.getQuery();
        String newQuery = oldQuery == null ? query : oldQuery + QueryArgumentSeparator + query;

        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment());
    }

    @Override
    public URI newFragmentUri(URI artifactUri, IFragment fragment) throws URISyntaxException {
        return appendQuery(artifactUri, toFragmentQuery(fragment));
    }

    public static void queryParameters(URI uri) {
        Map<String,String> map = Arrays.stream(uri.getQuery().split(QueryArgumentSeparator))
                .map(str -> str.split(QueryAssignmentSeparator))
                .map(array -> new String[] {
                        array.length > 0 ? array[0] : null,
                        array.length > 1 ? array[1] : null
                })
                .collect(Collectors.toMap(a -> a[0], a -> a[1]));
        System.out.println(map);
    }
}
