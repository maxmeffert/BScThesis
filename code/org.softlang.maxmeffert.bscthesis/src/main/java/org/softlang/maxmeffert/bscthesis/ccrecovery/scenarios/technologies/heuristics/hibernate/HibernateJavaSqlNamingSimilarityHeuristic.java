package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlCreateTableFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaSqlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class HibernateJavaSqlNamingSimilarityHeuristic extends BaseJavaSqlSimilarityHeuristic {

    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, SqlCreateTableFragment sqlCreateTableFragment) {
        return StringUtils.areLowerCaseEqual(javaClassFragment.getIdentifier(), sqlCreateTableFragment.getTableName());
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, SqlColumnFragment sqlColumnFragment) {
        return StringUtils.areLowerCaseEqual(javaFieldFragment.getIdentifier(), sqlColumnFragment.getColumnName());
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, SqlColumnFragment sqlColumnFragment) {
        return StringUtils.areLowerCaseEqual(JavaStringUtils.normalizeMethodName(javaMethodFragment.getIdentifier()), sqlColumnFragment.getColumnName());
    }

}
