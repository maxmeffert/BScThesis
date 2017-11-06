package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

public interface IFragmentPosition extends Comparable<IFragmentPosition>{
    int getStartLine();
    int getStartCharInLine();
    int getStopLine();
    int getStopCharInLine();
}
