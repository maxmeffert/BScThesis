package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

public interface IFragmentPositionEncoder {
    String encode(IFragmentPosition position);
    IFragmentPosition decode(String string);
}
