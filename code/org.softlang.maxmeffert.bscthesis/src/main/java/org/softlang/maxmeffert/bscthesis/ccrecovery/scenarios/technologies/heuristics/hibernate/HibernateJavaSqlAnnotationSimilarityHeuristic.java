package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlCreateTableFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaSqlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.HibernateJavaUtils;

public class HibernateJavaSqlAnnotationSimilarityHeuristic extends BaseJavaSqlSimilarityHeuristic {
    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, SqlCreateTableFragment sqlCreateTableFragment) {
        return HibernateJavaUtils.hasTableAnnotation(javaClassFragment, sqlCreateTableFragment.getTableName());
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, SqlColumnFragment sqlColumnFragment) {
        return HibernateJavaUtils.hasColumnAnnotation(javaFieldFragment, sqlColumnFragment.getColumnName());
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, SqlColumnFragment sqlColumnFragment) {
        return HibernateJavaUtils.hasColumnAnnotation(javaMethodFragment, sqlColumnFragment.getColumnName());
    }
}
