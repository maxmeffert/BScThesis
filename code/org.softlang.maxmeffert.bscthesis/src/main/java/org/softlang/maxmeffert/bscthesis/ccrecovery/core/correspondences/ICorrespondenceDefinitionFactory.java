package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;

public interface ICorrespondenceDefinitionFactory {
    ICorrespondenceDefinition newCorrespondenceDefinition(ILanguage language1, ILanguage language2, ISimilarity similarity);
}
