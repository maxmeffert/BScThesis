package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments;

import java.util.LinkedList;
import java.util.List;

public abstract class ModifiedJava8Fragment extends IdentifiedJava8Fragment {

    private List<Java8ModifierFragment> java8ModifierFragments = new LinkedList<>();

    public List<Java8ModifierFragment> getJava8ModifierFragments() {
        return java8ModifierFragments;
    }

    public void addJava8ModifierFragment(Java8ModifierFragment java8ModifierFragment) {
        java8ModifierFragments.add(java8ModifierFragment);
        addChild(java8ModifierFragment);
    }
}
