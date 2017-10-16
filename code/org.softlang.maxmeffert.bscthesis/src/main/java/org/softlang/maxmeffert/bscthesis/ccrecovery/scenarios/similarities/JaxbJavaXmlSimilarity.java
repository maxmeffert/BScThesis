package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

public class JaxbJavaXmlSimilarity implements ISimilarity {

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

    @Override
    public boolean accept(IFragment javaFragment, IFragment xmlFragment) {
        return acceptJavaClassNameXMLElementNameSimilarity(javaFragment, xmlFragment);
    }
}
