package org.softlang.maxmeffert.bscthesis.texts.sources;

public class TextSourceBuilderFactory implements ITextSourceBuilderFactory {
    @Override
    public ITextSourceBuilder newSourceInfoBuilder() {
        return new TextSourceBuilder(null, null);
    }
}
