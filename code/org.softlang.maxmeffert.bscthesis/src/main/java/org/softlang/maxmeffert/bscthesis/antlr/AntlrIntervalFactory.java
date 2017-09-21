package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.misc.Interval;

public class AntlrIntervalFactory implements IAntlrIntervalFactory {
    @Override
    public Interval newInterval(int a, int b) {
        return Interval.of(a, b);
    }
}
