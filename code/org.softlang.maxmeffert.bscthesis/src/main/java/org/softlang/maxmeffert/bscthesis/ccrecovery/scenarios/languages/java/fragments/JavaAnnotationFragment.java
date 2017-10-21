package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

import java.util.LinkedList;
import java.util.List;

public class JavaAnnotationFragment extends IdentifiedJavaFragment {

    private List<JavaAnnotationValueFragment> javaAnnotationValueFragments = new LinkedList<>();

    public List<JavaAnnotationValueFragment> getJavaAnnotationValueFragments() {
        return javaAnnotationValueFragments;
    }

    public void addValue(JavaAnnotationValueFragment javaAnnotationValueFragment) {
        javaAnnotationValueFragments.add(javaAnnotationValueFragment);
    }
}
