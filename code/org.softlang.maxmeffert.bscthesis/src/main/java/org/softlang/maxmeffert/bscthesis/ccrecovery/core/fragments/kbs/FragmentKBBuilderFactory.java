package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereologyBuilderFactory;

public class FragmentKBBuilderFactory implements IFragmentKBBuilderFactory {

    private final IMereologyBuilderFactory mereologyBuilderFactory;

    @Inject
    public FragmentKBBuilderFactory(IMereologyBuilderFactory mereologyBuilderFactory) {
        this.mereologyBuilderFactory = mereologyBuilderFactory;
    }

    @Override
    public IFragmentKBBuilder newFragmentKBBuilder() {
        return new FragmentKBBuilder(mereologyBuilderFactory.newMereologyBuilder());
    }
}
