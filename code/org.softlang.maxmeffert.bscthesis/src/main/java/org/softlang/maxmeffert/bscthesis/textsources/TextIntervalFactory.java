package org.softlang.maxmeffert.bscthesis.textsources;

public class TextIntervalFactory implements ITextIntervalFactory {

    @Override
    public ITextInterval newTextInterval(int startPosition, int stopPosition) {
        return new TextInterval(startPosition, stopPosition);
    }
}
