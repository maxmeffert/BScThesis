package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;

import java.util.Collection;

public interface ISimpleParseTreeBuilder {
    ISimpleParseTreeBuilder withSourceInterval(Interval interval);
    ISimpleParseTreeBuilder withSourceStream(TokenStream tokenStream);
    ISimpleParseTreeBuilder withChild(ISimpleParseTree parseTree);
    ISimpleParseTreeBuilder withChildren(Collection<ISimpleParseTree> parseTrees);
    ISimpleParseTree build();
}
