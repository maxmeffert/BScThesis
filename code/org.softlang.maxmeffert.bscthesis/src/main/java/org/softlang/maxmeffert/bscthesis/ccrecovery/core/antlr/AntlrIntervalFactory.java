package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.misc.Interval;

public class AntlrIntervalFactory implements IAntlrIntervalFactory {
    @Override
    public Interval newInterval(int a, int b) {
        return Interval.of(a, b);
    }
}
