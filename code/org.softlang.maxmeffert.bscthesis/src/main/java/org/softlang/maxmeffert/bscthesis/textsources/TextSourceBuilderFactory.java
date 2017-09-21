package org.softlang.maxmeffert.bscthesis.textsources;

public class TextSourceBuilderFactory implements ITextSourceBuilderFactory {
    @Override
    public ITextSourceBuilder newSourceInfoBuilder() {
        return new TextSourceBuilder(null, null);
    }
}
