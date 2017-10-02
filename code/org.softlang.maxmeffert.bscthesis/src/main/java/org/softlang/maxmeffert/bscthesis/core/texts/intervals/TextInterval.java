package org.softlang.maxmeffert.bscthesis.core.texts.intervals;

public class TextInterval implements ITextInterval {

    private final int startPosition;
    private final int endPosition;

    public TextInterval(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    @Override
    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public int getEndPosition() {
        return endPosition;
    }

    @Override
    public boolean startsBefore(ITextInterval iTextInterval) {
        return getStartPosition() < iTextInterval.getStartPosition();
    }

    @Override
    public boolean startsAfter(ITextInterval iTextInterval) {
        return getStartPosition() > iTextInterval.getStartPosition();
    }

    @Override
    public boolean endsBefore(ITextInterval iTextInterval) {
        return getEndPosition() < iTextInterval.getEndPosition();
    }

    @Override
    public boolean endsAfter(ITextInterval iTextInterval) {
        return getEndPosition() > iTextInterval.getEndPosition();
    }

    @Override
    public boolean contains(ITextInterval iTextInterval) {
        return getStartPosition() <= iTextInterval.getStartPosition()
                && iTextInterval.getEndPosition() <= getEndPosition();
    }

    @Override
    public boolean properlyContains(ITextInterval iTextInterval) {
        return getStartPosition() < iTextInterval.getStartPosition()
                && iTextInterval.getEndPosition() < getEndPosition();
    }

    @Override
    public boolean isDisjointTo(ITextInterval iTextInterval) {
        return !contains(iTextInterval) && !iTextInterval.contains(this);
    }

    @Override
    public String toString() {
        return "("+startPosition+","+ endPosition +")";
    }

    @Override
    public int compareTo(ITextInterval iTextInterval) {
        int result = getStartPosition() - iTextInterval.getStartPosition();
        if (result == 0) {
            result = getEndPosition() - iTextInterval.getEndPosition();
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ITextInterval) {
            return compareTo((ITextInterval) object) == 0;
        }
        return false;
    }
}
