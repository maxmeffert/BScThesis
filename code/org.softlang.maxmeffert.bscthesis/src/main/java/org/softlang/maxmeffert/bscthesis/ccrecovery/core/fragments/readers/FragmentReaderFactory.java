package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris.IFragmentUriConverterFactory;

public class FragmentReaderFactory implements IFragmentReaderFactory {

    private final IFragmentUriConverterFactory fragmentUriConverterFactory;

    @Inject
    public FragmentReaderFactory(IFragmentUriConverterFactory fragmentUriConverterFactory) {
        this.fragmentUriConverterFactory = fragmentUriConverterFactory;
    }

    @Override
    public IFragmentReader newFragmentReader() {
        return new FragmentReader(fragmentUriConverterFactory.newFragmentUriConverter());
    }
}
