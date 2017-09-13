package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.ParserRuleContext;

public interface IFragmentFactory {
    IFragment newFragmentFromParserRuleContext(ParserRuleContext parserRuleContext);
}
