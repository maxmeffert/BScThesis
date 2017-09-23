package org.softlang.maxmeffert.bscthesis.text.sources;

public class TextSourceBuilderFactory implements ITextSourceBuilderFactory {
    @Override
    public ITextSourceBuilder newSourceInfoBuilder() {
        return new TextSourceBuilder(null, null);
    }
}
