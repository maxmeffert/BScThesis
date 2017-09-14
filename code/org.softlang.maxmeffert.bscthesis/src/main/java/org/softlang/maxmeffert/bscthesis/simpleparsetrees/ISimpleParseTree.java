package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;

import java.util.Collection;

public interface ISimpleParseTree {
    Collection<ISimpleParseTree> getChildren();
    Interval getSourceInterval();
    TokenStream getSourceStream();
    String getText();
}
