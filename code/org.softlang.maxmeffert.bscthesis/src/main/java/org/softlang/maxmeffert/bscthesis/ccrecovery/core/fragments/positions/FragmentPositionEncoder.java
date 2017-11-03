package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentPositionEncoder implements IFragmentPositionEncoder {

    private static final String StartLineGroupName = "startLine";
    private static final String StartCharInLineGroupName = "startCharInLine";
    private static final String StopLineGroupName = "stopLine";
    private static final String StopCharInLineGroupName = "stopCharInLine";

    private static final String StartLineGroupPattern = String.format("(?<%s>\\d+)", StartLineGroupName);
    private static final String StartCharInLineGroupPattern = String.format("(?<%s>\\d+)", StartCharInLineGroupName);
    private static final String StopLineGroupPattern = String.format("(?<%s>\\d+)", StopLineGroupName);
    private static final String StopCharInLineGroupPattern = String.format("(?<%s>\\d+)",StopCharInLineGroupName);

    private static final String EncodeFragmentPositionInterpolation = "L%sC%sL%sC%s";

    private static final String EncodedFragmentPositionPattern =
                    String.format(
                            EncodeFragmentPositionInterpolation,
                            StartLineGroupPattern,
                            StartCharInLineGroupPattern,
                            StopLineGroupPattern,
                            StopCharInLineGroupPattern);


    private final IFragmentPositionFactory fragmentPositionFactory;

    public FragmentPositionEncoder(IFragmentPositionFactory fragmentPositionFactory) {
        this.fragmentPositionFactory = fragmentPositionFactory;
    }

    private IFragmentPosition newFragmentPosition(int startLine, int startCharInLine, int stopLine, int stopCharInLine) {
        return fragmentPositionFactory.newFragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
    }

    private IFragmentPosition newEmptyFragmentPosition() {
        return fragmentPositionFactory.newEmptyFragmentPosition();
    }

    private Matcher newFragmentPositionPatternMatcher(String string) {
        Pattern pattern = Pattern.compile(EncodedFragmentPositionPattern);
        return pattern.matcher(string);
    }

    private int groupAsInteger(Matcher matcher, String groupName) {
        return Integer.parseInt(matcher.group(groupName));
    }

    @Override
    public String encode(IFragmentPosition position) {
        return String.format(
                EncodeFragmentPositionInterpolation,
                position.getStartLine(),
                position.getStartCharInLine(),
                position.getStopLine(),
                position.getStopCharInLine());
    }

    @Override
    public IFragmentPosition decode(String string) {
        Matcher matcher = newFragmentPositionPatternMatcher(string);
        if (matcher.matches()) {
            int startLine = groupAsInteger(matcher, StartLineGroupName);
            int startCharInLine = groupAsInteger(matcher, StartCharInLineGroupName);
            int stopLine = groupAsInteger(matcher, StopLineGroupName);
            int stopCharInLine = groupAsInteger(matcher, StopCharInLineGroupName);
            return newFragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
        }
        return newEmptyFragmentPosition();
    }
}
