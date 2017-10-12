package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.util.Collection;
import java.util.function.BiPredicate;

public class CorrespondenceDefinition implements ICorrespondenceDefinition {

    private final ILanguage language1;
    private final ILanguage language2;
    private final Collection<BiPredicate<IFragment, IFragment>> predicates;

    public CorrespondenceDefinition(ILanguage language1, ILanguage language2, Collection<BiPredicate<IFragment, IFragment>> predicates) {
        this.language1 = language1;
        this.language2 = language2;
        this.predicates = predicates;
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
    public boolean accept(ILanguage language1, ILanguage language2) {
        return getLanguage1().equals(language1) && getLanguage2().equals(language2);
    }

    @Override
    public boolean accept(IFragment fragment1, IFragment fragment2) {
        return predicates.stream().anyMatch(predicate -> predicate.test(fragment1,fragment2));
    }
}
