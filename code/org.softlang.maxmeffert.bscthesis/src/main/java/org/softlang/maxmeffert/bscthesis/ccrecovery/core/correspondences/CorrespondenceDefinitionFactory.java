package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;

public class CorrespondenceDefinitionFactory implements ICorrespondenceDefinitionFactory {

    @Override
    public ICorrespondenceDefinition newCorrespondenceDefinition(ILanguage language1, ILanguage language2, ISimilarity similarity) {
        return new CorrespondenceDefinition(language1, language2, similarity);
    }
}
