package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;

public class FragmentAnalyzerFactory implements IFragmentAnalyzerFactory {

    private final IBinaryRelationFactory binaryRelationFactory;

    @Inject
    public FragmentAnalyzerFactory(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public IFragmentAnalyzer newFragmentAnalyzer() {
        return new FragmentAnalyzer(binaryRelationFactory);
    }
}
