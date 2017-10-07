package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

public class TextSourceBuilderFactory implements ITextSourceBuilderFactory {
    @Override
    public ITextSourceBuilder newSourceInfoBuilder() {
        return new TextSourceBuilder(null, null);
    }
}
