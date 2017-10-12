package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.util.function.BiPredicate;

public class CorrespondenceDefinition implements ICorrespondenceDefinition {

    private final ILanguage language1;
    private final ILanguage language2;
    private final BiPredicate<IFragment, IFragment> predicate;

    public CorrespondenceDefinition(ILanguage language1, ILanguage language2, BiPredicate<IFragment, IFragment> predicate) {
        this.language1 = language1;
        this.language2 = language2;
        this.predicate = predicate;
    }

    @Override
    public ILanguage getLanguage1() {
        return language1;
    }

    @Override
    public ILanguage getLanguage2() {
        return language2;
    }

    @Override
    public BiPredicate<IFragment, IFragment> getPredicate() {
        return predicate;
    }

    @Override
    public boolean accept(IFragment fragment1, IFragment fragment2) {
        return predicate.test(fragment1, fragment2);
    }
}
