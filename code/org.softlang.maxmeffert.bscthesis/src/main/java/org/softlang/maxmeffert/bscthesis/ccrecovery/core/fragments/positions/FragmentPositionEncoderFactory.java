package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

import com.google.inject.Inject;

public class FragmentPositionEncoderFactory implements IFragmentPositionEncoderFactory {

    private final IFragmentPositionFactory fragmentPositionFactory;

    @Inject
    public FragmentPositionEncoderFactory(IFragmentPositionFactory fragmentPositionFactory) {
        this.fragmentPositionFactory = fragmentPositionFactory;
    }

    @Override
    public IFragmentPositionEncoder newFragmentPositionEncoder() {
        return new FragmentPositionEncoder(fragmentPositionFactory);
    }
}
