package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

public class FragmentPositionEncoderFactory implements IFragmentPositionEncoderFactory {
    @Override
    public IFragmentPositionEncoder newFragmentPositionEncoder() {
        return new FragmentPositionEncoder();
    }
}
