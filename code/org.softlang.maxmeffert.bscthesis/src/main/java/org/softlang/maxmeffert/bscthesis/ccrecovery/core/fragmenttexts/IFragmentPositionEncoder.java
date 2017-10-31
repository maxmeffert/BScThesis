package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmenttexts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentPosition;

public interface IFragmentPositionEncoder {
    String encode(IFragmentPosition position);
    IFragmentPosition decode(String string);
}
