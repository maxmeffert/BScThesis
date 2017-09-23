package org.softlang.maxmeffert.bscthesis.text.intervals;

public interface ITextIntervalFactory {
    ITextInterval newTextInterval(int startPosition, int stopPosition);
}
