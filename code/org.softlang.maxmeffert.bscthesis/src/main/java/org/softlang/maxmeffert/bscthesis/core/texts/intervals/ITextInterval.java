package org.softlang.maxmeffert.bscthesis.core.texts.intervals;

public interface ITextInterval extends Comparable<ITextInterval> {
    int getStartPosition();
    int getEndPosition();
    boolean startsBefore(ITextInterval iTextInterval);
    boolean startsAfter(ITextInterval iTextInterval);
    boolean endsBefore(ITextInterval iTextInterval);
    boolean endsAfter(ITextInterval iTextInterval);
    boolean contains(ITextInterval iTextInterval);
    boolean properlyContains(ITextInterval iTextInterval);
    boolean isDisjointTo(ITextInterval iTextInterval);
}
