package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaAnnotationFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaModifierFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.ModifiedJavaFragment;

import java.util.function.Predicate;

public class JavaFragmentUtils {

    public static boolean hasAnnotation(ModifiedJavaFragment modifiedJavaFragment, Predicate<JavaAnnotationFragment> predicate) {
        return modifiedJavaFragment.getJavaModifierFragments().stream()
                .filter(JavaModifierFragment::isAnnotation)
                .map(JavaModifierFragment::getJavaAnnotationFragment)
                .anyMatch(predicate);
    }

    public static boolean hasAnnotation(ModifiedJavaFragment modifiedJavaFragment, String annotationName) {
        return modifiedJavaFragment.getJavaModifierFragments().stream()
                .filter(JavaModifierFragment::isAnnotation)
                .map(JavaModifierFragment::getJavaAnnotationFragment)
                .anyMatch(a -> StringUtils.areLowerCaseEqual(a.getIdentifier(), annotationName));
    }

    public static boolean hasAnnotation(ModifiedJavaFragment modifiedJavaFragment, String annotationName, Predicate<JavaAnnotationFragment> predicate) {
        return modifiedJavaFragment.getJavaModifierFragments().stream()
                .filter(JavaModifierFragment::isAnnotation)
                .map(JavaModifierFragment::getJavaAnnotationFragment)
                .filter(a -> StringUtils.areLowerCaseEqual(a.getIdentifier(), annotationName))
                .anyMatch(predicate);
    }

}
