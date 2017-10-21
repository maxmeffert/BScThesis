package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

import java.util.LinkedList;
import java.util.List;

public class JavaAnnotationFragmentAST extends IdentifiedJavaFragmentAST {

    private List<JavaAnnotationValueFragmentAST> javaAnnotationValueFragments = new LinkedList<>();

    public List<JavaAnnotationValueFragmentAST> getJavaAnnotationValueFragments() {
        return javaAnnotationValueFragments;
    }

    public void addValue(JavaAnnotationValueFragmentAST javaAnnotationValueFragment) {
        javaAnnotationValueFragments.add(javaAnnotationValueFragment);
    }
}
