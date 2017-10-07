package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IGraphBuilders;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures.IGraphClosures;
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
