package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereologyBuilder;

public class FragmentKBBuilder implements IFragmentKBBuilder {

    private final IMereologyBuilder<IFragmentAST> mereologyBuilder;

    public FragmentKBBuilder(IMereologyBuilder<IFragmentAST> mereologyBuilder) {
        this.mereologyBuilder = mereologyBuilder;
    }

    @Override
    public IFragmentKBBuilder fragmentOf(IFragmentAST component, IFragmentAST composite) {
//        System.out.println(component + " isFragmentOf " + composite);
        return new FragmentKBBuilder(mereologyBuilder.partOf(component, composite));
    }

    private IMereology<IFragmentAST> buildMereology() {
        return mereologyBuilder.build();
    }

    @Override
    public IFragmentKB build() {
        return new FragmentKB(buildMereology());
    }
}
