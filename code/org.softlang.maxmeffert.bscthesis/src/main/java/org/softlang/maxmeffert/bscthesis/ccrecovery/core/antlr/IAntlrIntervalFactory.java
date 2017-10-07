package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.misc.Interval;

public interface IAntlrIntervalFactory {
    Interval newInterval(int a, int b);
}
