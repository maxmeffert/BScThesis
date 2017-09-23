package org.softlang.maxmeffert.bscthesis.text.intervals;

import org.softlang.maxmeffert.bscthesis.text.intervals.ITextInterval;

public class TextInterval implements ITextInterval {

    private final int startPosition;
    private final int stopPosition;

    public TextInterval(int startPosition, int stopPosition) {
        this.startPosition = startPosition;
        this.stopPosition = stopPosition;
    }

    @Override
    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public int getStopPosition() {
        return stopPosition;
    }

    @Override
    public String toString() {
        return "("+startPosition+","+stopPosition+")";
    }
}
