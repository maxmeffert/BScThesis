package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts;

public class FragmentPosition implements IFragmentPosition {

    private final int startLine;
    private final int startInLine;
    private final int stopLine;
    private final int stopInLine;

    public FragmentPosition(int startLine, int startInLine, int stopLine, int stopInLine) {
        this.startLine = startLine;
        this.startInLine = startInLine;
        this.stopLine = stopLine;
        this.stopInLine = stopInLine;
    }

    @Override
    public int getStartLine() {
        return startLine;
    }

    @Override
    public int getStartCharInLine() {
        return startInLine;
    }

    @Override
    public int getStopLine() {
        return stopLine;
    }

    @Override
    public int getStopCharInLine() {
        return stopInLine;
    }

    @Override
    public String toString() {
        return "(" + getStartLine() + ":" + getStartCharInLine() + "," + getStopLine() + ":" + getStopCharInLine() + ")";
    }
}
