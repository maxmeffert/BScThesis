package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmenttexts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.FragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentPosition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentPositionEncoder implements IFragmentPositionEncoder {
    @Override
    public String encode(IFragmentPosition position) {
        String start = "L" + position.getStartLine() + "C" + position.getStartCharInLine();
        String stop = "L" + position.getStopLine() + "C" + position.getStopCharInLine();
        return "F" + start + stop;
    }

    @Override
    public IFragmentPosition decode(String string) {
        Pattern pattern = Pattern.compile("FL(?<startLine>\\d+)C(?<startCharInLine>\\d+)L(?<stopLine>\\d+)C(?<stopCharInLine>\\d+)");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int startLine = Integer.parseInt(matcher.group("startLine"));
            int startCharInLine = Integer.parseInt(matcher.group("startCharInLine"));
            int stopLine = Integer.parseInt(matcher.group("stopLine"));
            int stopCharInLine = Integer.parseInt(matcher.group("stopCharInLine"));
            return new FragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
        }
        return null;
    }
}
