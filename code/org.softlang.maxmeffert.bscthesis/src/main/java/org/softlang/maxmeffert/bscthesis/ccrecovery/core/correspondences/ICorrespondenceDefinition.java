package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;

import java.util.function.BiPredicate;

public interface ICorrespondenceDefinition {
    ILanguage getLanguage1();
    ILanguage getLanguage2();
    boolean accept(IFragment fragment1, IFragment fragment2);
}
