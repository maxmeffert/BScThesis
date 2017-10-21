package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import java.util.LinkedList;
import java.util.List;

public abstract class ModifiedJavaFragment extends IdentifiedJavaFragment {

    private List<JavaModifierFragment> java8ModifierFragments = new LinkedList<>();

    public List<JavaModifierFragment> getJava8ModifierFragments() {
        return java8ModifierFragments;
    }

    public void addJava8ModifierFragment(JavaModifierFragment java8ModifierFragment) {
        java8ModifierFragments.add(java8ModifierFragment);
        addChild(java8ModifierFragment);
    }
}
