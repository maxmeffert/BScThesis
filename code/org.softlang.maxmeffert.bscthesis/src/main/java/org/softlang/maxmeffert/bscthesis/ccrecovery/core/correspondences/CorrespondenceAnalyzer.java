package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKB;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserResult;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;

import java.io.IOException;
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

    private IFragmentKB newFragmentKB(IParserResult parserResult) throws ParserException {
        if (parserResult.hasNotAcceptedInput()) {
            throw parserResult.getParserException();
        }
        return fragmentKBFactory.newFragmentKB(parserResult.getParseTree());
    }

    private IFragmentKB newFragmentKB(ILanguage language, InputStream artifact) throws IOException, ParserException {
        return newFragmentKB(language.getParser().tryParse(artifact));
    }

    @Override
    public Set<ICorrespondence> analyze(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws IOException, ParserException {
        Set<ICorrespondence> correspondences = new TreeSet<>();
        IFragmentKB fragmentKB1 = newFragmentKB(correspondenceDefinition.getLanguage1(), artifact1);
        IFragmentKB fragmentKB2 = newFragmentKB(correspondenceDefinition.getLanguage2(), artifact2);
        for(IFragment fragment1 : fragmentKB1.getFragments()) {
            for (IFragment fragment2 : fragmentKB2.getFragments()) {
                if (correspondenceDefinition.accept(fragment1, fragment2)) {
                    correspondences.add(correspondenceFactory.newCorrespondence(correspondenceDefinition, fragment1, fragment2));
                }
            }
        }
        return null;
    }
}
