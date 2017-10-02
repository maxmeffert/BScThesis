package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrIntervalFactory;

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
