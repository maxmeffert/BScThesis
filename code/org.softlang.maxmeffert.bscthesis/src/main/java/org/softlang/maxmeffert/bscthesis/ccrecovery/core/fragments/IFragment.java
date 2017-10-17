package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;


import java.util.List;

public interface IFragment extends Comparable<IFragment> {
    String getText();
    List<IFragment> getChildren();
}
