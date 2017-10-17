package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JaxbJavaXmlSimilarity implements ISimilarity {

    private JavaFragmentMatcher javaFragmentMatcher = new JavaFragmentMatcher();

    private <T> Optional<T> getFirstAfterMatch(Iterator<T> iterator, Predicate<T> predicate) {
        while(iterator.hasNext()) {
            if (predicate.test(iterator.next()) && iterator.hasNext()) {
                return Optional.of(iterator.next());
            }
        }
        return Optional.empty();
    }

    private <T> Optional<T> getFirstAfterMatch(Iterable<T> iterable, Predicate<T> predicate) {
        return getFirstAfterMatch(iterable.iterator(), predicate);
    }

    private Optional<String> getFirstAfterLowerCaseMatch(Iterable<String> iterable, String string) {
        return getFirstAfterMatch(iterable, str -> str.toLowerCase().equals(string.toLowerCase()));
    }

    private Optional<String> getJavaClassName(IFragment fragment) {
        Optional<Integer> index = fragment.getTokens().tryGetFirstIndexOf("class");
        if (index.isPresent()) {
            return fragment.getTokens().tryGet(index.get()+1);
        }
        return Optional.empty();
    }

    private Optional<String> getXMLElementName(IFragment fragment) {
        int index = fragment.getTokens().getFirstIndexOf("<");
        if (index == -1 || index+1 >= fragment.getTokens().size()) {
            return Optional.empty();
        }
        return Optional.of(fragment.getTokens().get(index+1));
//        return getFirstAfterLowerCaseMatch(fragment.getTokens(), "<");
    }

    private boolean acceptJavaClassNameXMLElementNameSimilarity(IFragment javaFragment, IFragment xmlFragment) {
        Optional<String> javaClassName = getJavaClassName(javaFragment);
        Optional<String> xmlElementName = getXMLElementName(xmlFragment);
        return javaClassName.isPresent()
                && xmlElementName.isPresent()
                && javaClassName.get().toLowerCase().equals(xmlElementName.get().toLowerCase());
    }

    private boolean isClassDeclaration(String text) {
//        System.out.println(text);
        Pattern pattern = Pattern.compile("class(?<ClassIdentifier>\\w+)\\{\\S+}");
        Matcher matcher = pattern.matcher(text);

        boolean found = matcher.find();
        if (found) {
            System.out.println(matcher.group("ClassIdentifier"));
        }

        return found;
    }

    private Pattern pattern = Pattern.compile("^public\\s(?<ResultType>\\w+)\\s(?<MethodIdentifier>\\w+)\\s\\(\\s(\\S*\\s)*\\)\\s\\{\\s(\\S*\\s)*}");

    private boolean isMethodDeclaration(String text) {
        Matcher matcher = pattern.matcher(text);
        boolean found = matcher.find();
        if (found) {
            System.out.println(matcher.group("ResultType"));
            System.out.println(matcher.group("MethodIdentifier"));
        }

        return found;
    }

    @Override
    public boolean accept(IFragment javaFragment, IFragment xmlFragment) {
        javaFragmentMatcher.newJavaFragment(javaFragment);
//        if (javaFragment.getTokens().matches("public","\\w+","\\w+","\\(","\\)")) {
//        String text = Joiner.on(" ").join(javaFragment.getTokens().toArray());
//        if (isMethodDeclaration(text)) {
//            System.out.println(text);
////            System.out.println(pattern.matcher(text).matches());
//        }

//        if (javaFragment.getParseTree().getAntlrType().equals(Java8Parser.NormalClassDeclarationContext.class)) {
//            System.out.println("asdf");
//            return false;
//        }
        return false; //acceptJavaClassNameXMLElementNameSimilarity(javaFragment, xmlFragment);
    }
}
