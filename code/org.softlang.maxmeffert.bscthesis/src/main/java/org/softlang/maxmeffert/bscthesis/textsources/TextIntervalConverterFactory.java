package org.softlang.maxmeffert.bscthesis.textsources;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrIntervalFactory;

public class TextIntervalConverterFactory implements ITextIntervalConverterFactory {

    private final ITextIntervalFactory textIntervalFactory;
    private final IAntlrIntervalFactory antlrIntervalFactory;

    @Inject
    public TextIntervalConverterFactory(ITextIntervalFactory textIntervalFactory, IAntlrIntervalFactory antlrIntervalFactory) {
        this.textIntervalFactory = textIntervalFactory;
        this.antlrIntervalFactory = antlrIntervalFactory;
    }

    @Override
    public ITextIntervalConverter newTextIntervalConverter() {
        return new TextIntervalConverter(textIntervalFactory, antlrIntervalFactory);
    }
}
