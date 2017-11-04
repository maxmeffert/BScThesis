package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlCreateTableFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragments.SqlDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

import java.util.List;

public class HibernateJavaSqlNamingCorrespondenceSimilarityHeuristic implements IFragmentAnalyzerHeuristic {

    private boolean areSimilar(JavaClassFragment javaClassFragmentAST, SqlCreateTableFragment sqlCreateTableFragment) {
        return StringUtils.areLowerCaseEqual(javaClassFragmentAST.getIdentifier(), sqlCreateTableFragment.getTableName());
    }

    private boolean areSimilar(JavaFieldFragment javaFieldFragmentAST, SqlColumnFragment sqlColumnFragment) {
        return StringUtils.areLowerCaseEqual(javaFieldFragmentAST.getIdentifier(), sqlColumnFragment.getColumnName());
    }

    private boolean areSimilar(JavaMethodFragment javaMethodFragmentAST, SqlColumnFragment sqlColumnFragment) {
        return StringUtils.areLowerCaseEqual(JavaStringUtils.normalizeMethodName(javaMethodFragmentAST.getIdentifier()), sqlColumnFragment.getColumnName());
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, JavaFieldFragment javaFieldFragmentAST, List<SqlColumnFragment> sqlColumnFragments) {
        for (SqlColumnFragment sqlColumnFragment : sqlColumnFragments) {
            if (areSimilar(javaFieldFragmentAST, sqlColumnFragment)) {
                similarities.add(javaFieldFragmentAST, sqlColumnFragment);
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, JavaMethodFragment javaMethodFragmentAST, List<SqlColumnFragment> sqlColumnFragments) {
        for (SqlColumnFragment sqlColumnFragment : sqlColumnFragments) {
            if (areSimilar(javaMethodFragmentAST, sqlColumnFragment)) {
                similarities.add(javaMethodFragmentAST, sqlColumnFragment);
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, JavaClassFragment javaClassFragmentAST, SqlCreateTableFragment sqlCreateTableFragment) {
        if (areSimilar(javaClassFragmentAST, sqlCreateTableFragment)) {
            similarities.add(javaClassFragmentAST, sqlCreateTableFragment);
            for (JavaFieldFragment javaFieldFragmentAST : javaClassFragmentAST.getJavaFieldFragments()) {
                addSimilarities(similarities, javaFieldFragmentAST, sqlCreateTableFragment.getSqlColumnFragments());
            }
            for (JavaMethodFragment javaMethodFragmentAST : javaClassFragmentAST.getJavaMethodFragments()) {
                addSimilarities(similarities, javaMethodFragmentAST, sqlCreateTableFragment.getSqlColumnFragments());
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragmentAST, SqlDocumentFragment sqlDocumentFragment) {
        for (SqlCreateTableFragment sqlCreateTableFragment : sqlDocumentFragment.getSqlCreateTableFragments()) {
            addSimilarities(similarity, javaClassFragmentAST, sqlCreateTableFragment);
        }
    }

    @Override
    public void analyze(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof JavaClassFragment && fragment2 instanceof SqlDocumentFragment) {
            addSimilarities(similarity, (JavaClassFragment) fragment1, (SqlDocumentFragment) fragment2);
        }
    }
}
