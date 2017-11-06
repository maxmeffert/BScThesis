package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

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

    @Override
    public int compareTo(IFragmentPosition fragmentPosition) {
        int result = getStartLine() - fragmentPosition.getStartLine();
        if (result == 0) {
            result = getStartCharInLine() - fragmentPosition.getStartCharInLine();
        }
        if (result == 0) {
            result = getStopLine() - fragmentPosition.getStopLine();
        }
        if (result == 0) {
            result = getStopCharInLine() - fragmentPosition.getStopCharInLine();
        }
        return result;
    }
}
