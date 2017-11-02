package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentPositionEncoder implements IFragmentPositionEncoder {

    private static final String LinePrefix = "L";
    private static final String CharPrefix = "C";
    private static final String StartLinePattern = "(?<startLine>\\d+)";
    private static final String StartCharInLinePattern = "(?<startCharInLine>\\d+)";
    private static final String StopLinePattern = "(?<stopLine>\\d+)";
    private static final String StopCharInLinePattern = "(?<stopCharInLine>\\d+)";

    private static final String FragmentPositionPattern =
                    LinePrefix + StartLinePattern + CharPrefix + StartCharInLinePattern +
                    LinePrefix + StopLinePattern + CharPrefix + StopCharInLinePattern;

    private final IFragmentPositionFactory fragmentPositionFactory;

    public FragmentPositionEncoder(IFragmentPositionFactory fragmentPositionFactory) {
        this.fragmentPositionFactory = fragmentPositionFactory;
    }


    private String encodeStart(IFragmentPosition position) {
        return LinePrefix + position.getStartLine() + CharPrefix + position.getStartCharInLine();
    }

    private String encodeStop(IFragmentPosition position) {
        return LinePrefix + position.getStopLine() + CharPrefix + position.getStopCharInLine();
    }

    @Override
    public String encode(IFragmentPosition position) {
        return encodeStart(position) + encodeStop(position);
    }

    private IFragmentPosition newFragmentPosition(int startLine, int startCharInLine, int stopLine, int stopCharInLine) {
        return fragmentPositionFactory.newFragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
    }

    private IFragmentPosition newEmptyFragmentPosition() {
        return newFragmentPosition(0,0,0,0);
    }

    @Override
    public IFragmentPosition decode(String string) {
        Pattern pattern = Pattern.compile(FragmentPositionPattern);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int startLine = Integer.parseInt(matcher.group("startLine"));
            int startCharInLine = Integer.parseInt(matcher.group("startCharInLine"));
            int stopLine = Integer.parseInt(matcher.group("stopLine"));
            int stopCharInLine = Integer.parseInt(matcher.group("stopCharInLine"));
            return newFragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
        }
        return newEmptyFragmentPosition();
    }




}
