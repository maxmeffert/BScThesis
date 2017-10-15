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
        return getFirstAfterLowerCaseMatch(fragment.getTokens(), "class");
    }

    private Optional<String> getXMLElementName(IFragment fragment) {
        return getFirstAfterLowerCaseMatch(fragment.getTokens(), "<");
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
