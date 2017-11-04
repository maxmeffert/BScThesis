package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlCreateTableFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaSqlSimilarityHeuristic;

public class HibernateJavaSqlAnnotationCorrespondenceSimilarityHeuristic extends BaseJavaSqlSimilarityHeuristic {
    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, SqlCreateTableFragment sqlCreateTableFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, SqlColumnFragment sqlColumnFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, SqlColumnFragment sqlColumnFragment) {
        return false;
    }
}
