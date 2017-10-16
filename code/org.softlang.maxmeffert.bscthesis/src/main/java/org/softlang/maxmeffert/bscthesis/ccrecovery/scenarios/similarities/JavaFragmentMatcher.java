package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import com.google.common.base.Joiner;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaFragmentMatcher {

    private static String VisibilityModifierPattern = "(?<VisibilityModifier>public)";
    private static String TypePattern = "(?<Type>\\w+)";
    private static String IdentifierPattern = "(?<Identifier>\\w+)";
    private static String ParameterPattern = "\\(\\s(\\S*\\s)*\\)";
    private static String BodyPattern = "\\{\\s(\\S*\\s)*}";


    private static String join(String separator, String... strings) {
        return Joiner.on(separator).join(strings);
    }

    private static Matcher matcher(IFragment fragment, String... patterns) {
        Pattern pattern = Pattern.compile(join("\\s", patterns));
        return pattern.matcher(join(" ", fragment.getTokens().toArray()));
    }

    public Optional<IJavaFragment> newJavaFragment(IFragment fragment) {
//        Pattern pattern = Pattern.compile("^public\\s(?<ResultType>\\w+)\\s(?<MethodIdentifier>\\w+)"); // \\s\\(\\s(\\S*\\s)*\\)\\s\\{\\s(\\S*\\s)*}");
//        Matcher matcher = pattern.matcher(join(" ", fragment.getTokens().toArray()));
//        Matcher matcher = matcher(fragment, "^"+VisibilityModifierPattern,  IdentifierPattern, ParameterPattern, BodyPattern);
//        if (matcher.matches()) {
//            System.out.println(matcher.group("VisibilityModifier"));
////            System.out.println(matcher.group("Type"));
//            System.out.println(matcher.group("Identifier"));
//        }
        return Optional.empty();
    }

}
