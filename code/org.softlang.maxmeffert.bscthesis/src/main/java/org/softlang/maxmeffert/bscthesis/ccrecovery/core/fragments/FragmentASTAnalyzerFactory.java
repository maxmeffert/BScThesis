package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;

public class FragmentASTAnalyzerFactory implements IFragmentASTAnalyzerFactory {

    private final IBinaryRelationFactory binaryRelationFactory;

    @Inject
    public FragmentASTAnalyzerFactory(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public IFragmentASTAnalyzer newFragmentASTAnalyzer() {
        return new FragmentASTAnalyzer(binaryRelationFactory);
    }
}
