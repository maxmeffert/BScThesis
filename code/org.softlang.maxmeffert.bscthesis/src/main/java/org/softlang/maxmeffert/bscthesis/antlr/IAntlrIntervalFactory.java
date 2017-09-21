package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.misc.Interval;

public interface IAntlrIntervalFactory {
    Interval newInterval(int a, int b);
}
