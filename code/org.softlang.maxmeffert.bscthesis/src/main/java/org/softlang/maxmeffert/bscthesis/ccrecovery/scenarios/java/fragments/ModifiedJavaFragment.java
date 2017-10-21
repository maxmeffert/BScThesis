package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import java.util.LinkedList;
import java.util.List;

public abstract class ModifiedJavaFragment extends IdentifiedJavaFragment {

    private List<JavaModifierFragment> javaModifierFragments = new LinkedList<>();

    public List<JavaModifierFragment> getJavaModifierFragments() {
        return javaModifierFragments;
    }

    public void addJavaModifierFragment(JavaModifierFragment java8ModifierFragment) {
        javaModifierFragments.add(java8ModifierFragment);
        addChild(java8ModifierFragment);
    }
}
