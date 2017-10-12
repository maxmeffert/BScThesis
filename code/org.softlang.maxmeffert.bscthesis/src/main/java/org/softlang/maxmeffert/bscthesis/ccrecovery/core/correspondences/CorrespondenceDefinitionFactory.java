package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.util.function.BiPredicate;

public class CorrespondenceDefinitionFactory implements ICorrespondenceDefinitionFactory {
    @Override
    public ICorrespondenceDefinition newCorrespondenceDefinition(ILanguage language1, ILanguage language2, BiPredicate<IFragment, IFragment> predicate) {
        return new CorrespondenceDefinition(language1, language2, predicate);
    }
}
