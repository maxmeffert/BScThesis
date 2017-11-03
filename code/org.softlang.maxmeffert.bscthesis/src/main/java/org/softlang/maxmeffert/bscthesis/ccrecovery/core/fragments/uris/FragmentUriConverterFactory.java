package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.uris;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionEncoderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionFactory;

public class FragmentUriConverterFactory implements IFragmentUriConverterFactory {

    private final IFragmentPositionFactory fragmentPositionFactory;
    private final IFragmentPositionEncoderFactory fragmentPositionEncoderFactory;

    @Inject
    public FragmentUriConverterFactory(IFragmentPositionFactory fragmentPositionFactory, IFragmentPositionEncoderFactory fragmentPositionEncoderFactory) {
        this.fragmentPositionFactory = fragmentPositionFactory;
        this.fragmentPositionEncoderFactory = fragmentPositionEncoderFactory;
    }

    @Override
    public IFragmentUriConverter newFragmentUriConverter() {
        return new FragmentUriConverter(fragmentPositionFactory, fragmentPositionEncoderFactory.newFragmentPositionEncoder());
    }
}
