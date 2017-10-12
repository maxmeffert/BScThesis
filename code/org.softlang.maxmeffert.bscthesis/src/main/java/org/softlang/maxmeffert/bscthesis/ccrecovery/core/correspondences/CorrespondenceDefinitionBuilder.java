package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.util.Collection;
import java.util.function.BiPredicate;

public class CorrespondenceDefinitionBuilder implements ICorrespondenceDefinitionBuilder {

    private final ILanguage language1;
    private final ILanguage language2;
    private final Collection<BiPredicate<IFragment,IFragment>> predicates;

    public CorrespondenceDefinitionBuilder(ILanguage language1, ILanguage language2, Collection<BiPredicate<IFragment, IFragment>> predicates) {
        this.language1 = language1;
        this.language2 = language2;
        this.predicates = predicates;
    }

    @Override
    public ICorrespondenceDefinitionBuilder withDomain(ILanguage language1, ILanguage language2) {
        return new CorrespondenceDefinitionBuilder(language1, language2, predicates);
    }

    @Override
    public ICorrespondenceDefinitionBuilder iff(BiPredicate<IFragment, IFragment> predicate) {
        predicates.add(predicate);
        return new CorrespondenceDefinitionBuilder(language1,language2,predicates);
    }

    @Override
    public ICorrespondenceDefinition build() {
        return new CorrespondenceDefinition(language1,language2, predicates);
    }
}
