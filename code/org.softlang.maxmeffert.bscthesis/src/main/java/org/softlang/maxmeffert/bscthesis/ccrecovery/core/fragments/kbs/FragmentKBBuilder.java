package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereology;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereologyBuilder;

public class FragmentKBBuilder implements IFragmentKBBuilder {

    private final IMereologyBuilder<IFragment> mereologyBuilder;

    public FragmentKBBuilder(IMereologyBuilder<IFragment> mereologyBuilder) {
        this.mereologyBuilder = mereologyBuilder;
    }

    @Override
    public IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite) {
//        System.out.println(component + " isFragmentOf " + composite);
        return new FragmentKBBuilder(mereologyBuilder.partOf(component, composite));
    }

    private IMereology<IFragment> buildMereology() {
        return mereologyBuilder.build();
    }

    @Override
    public IFragmentKB build() {
        return new FragmentKB(buildMereology());
    }
}
