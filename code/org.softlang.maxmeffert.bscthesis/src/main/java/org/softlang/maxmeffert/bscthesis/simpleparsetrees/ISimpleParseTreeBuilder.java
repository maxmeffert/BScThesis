package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

public interface ISimpleParseTreeBuilder {
    ISimpleParseTreeBuilder withChild(ITextSource parent, ITextSource child);
    ISimpleParseTree build();
}
