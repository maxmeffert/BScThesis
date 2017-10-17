package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserResult;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;

public class CorrespondenceAnalyzer implements ICorrespondenceAnalyzer {

    private final ICorrespondenceFactory correspondenceFactory;
    private final IFragmentKBFactory fragmentKBFactory;

    public CorrespondenceAnalyzer(ICorrespondenceFactory correspondenceFactory, IFragmentKBFactory fragmentKBFactory) {
        this.correspondenceFactory = correspondenceFactory;
        this.fragmentKBFactory = fragmentKBFactory;
    }

    private IFragmentKB newFragmentKB(IParserResult parserResult) throws Exception {
        if (parserResult.hasNotAcceptedInput()) {
            throw parserResult.getParserException();
        }
        return fragmentKBFactory.newFragmentKB(parserResult.getFragmentAST());
    }

    private IFragmentKB newFragmentKB(ILanguage language, InputStream artifact) throws Exception {
        return newFragmentKB(language.getParser().tryParse(artifact));
    }

    @Override
    public Set<ICorrespondence> analyze(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws Exception {
        Set<ICorrespondence> correspondences = new TreeSet<>();
        IFragmentKB fragmentKB1 = newFragmentKB(correspondenceDefinition.getLanguage1(), artifact1);
        IFragmentKB fragmentKB2 = newFragmentKB(correspondenceDefinition.getLanguage2(), artifact2);
        for(IFragment fragment1 : fragmentKB1.getFragments()) {
//            System.out.println(fragment1);

            for (IFragment fragment2 : fragmentKB2.getFragments()) {
                if (correspondenceDefinition.accept(fragment1, fragment2)) {
                    correspondences.add(correspondenceFactory.newCorrespondence(correspondenceDefinition, fragment1, fragment2));
                }
            }
        }
        return correspondences;
    }

    @Override
    public Set<ICorrespondence> analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2) {
        Set<ICorrespondence> correspondences = new TreeSet<>();
        IFragmentKB fragmentKB1 = fragmentKBFactory.newFragmentKB(fragment1);
        IFragmentKB fragmentKB2 = fragmentKBFactory.newFragmentKB(fragment2);
        for (IFragment f1 : fragmentKB1.getFragments()) {
            for (IFragment f2 : fragmentKB2.getFragments()) {
                if (similarity.contains(f1, f2)) {
                    IView<IFragment> fragmentsOfF1 = fragmentKB1.getFragmentsOf(f1);
                    IView<IFragment> fragmentsOfF2 = fragmentKB2.getFragmentsOf(f2);
                    boolean correspondsTo = fragmentsOfF1.all( ff1 -> fragmentsOfF2.any( ff2 -> similarity.contains(ff1,ff2)));
                    if (correspondsTo) {
                        // add correspondence
                    }
                }
            }
        }
        return correspondences;
    }
}
