package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.ParserRuleContext;

public class FragmentFactory implements IFragmentFactory {

    private final IFragmentBuilderFactory fragmentBuilderFactory;

    public FragmentFactory(IFragmentBuilderFactory fragmentBuilderFactory) {
        this.fragmentBuilderFactory = fragmentBuilderFactory;
    }

    @Override
    public IFragment newFragmentFromParserRuleContext(ParserRuleContext parserRuleContext) {
        IFragmentBuilder fragmentBuilder = fragmentBuilderFactory.newFragmentBuilder();
        return fragmentBuilder.build();
    }
}
