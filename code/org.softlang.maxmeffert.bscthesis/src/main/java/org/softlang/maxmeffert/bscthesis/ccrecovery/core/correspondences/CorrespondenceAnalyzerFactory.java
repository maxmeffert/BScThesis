package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.kbs.IFragmentKBFactory;

public class CorrespondenceAnalyzerFactory implements ICorrespondenceAnalyzerFactory {

    private final IBinaryRelationFactory binaryRelationFactory;
    private final IFragmentKBFactory fragmentKBFactory;

    @Inject
    public CorrespondenceAnalyzerFactory(IBinaryRelationFactory binaryRelationFactory, IFragmentKBFactory fragmentKBFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
        this.fragmentKBFactory = fragmentKBFactory;
    }

    @Override
    public ICorrespondenceAnalyzer newCorrespondenceAnalyzer() {
        return new CorrespondenceAnalyzer(binaryRelationFactory, fragmentKBFactory);
    }
}
