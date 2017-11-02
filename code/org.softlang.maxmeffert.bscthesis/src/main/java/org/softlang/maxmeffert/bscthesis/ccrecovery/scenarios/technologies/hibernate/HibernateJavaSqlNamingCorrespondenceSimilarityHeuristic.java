package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentASTAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast.SqlColumnFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast.SqlCreateTableFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast.SqlDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

import java.util.List;

public class HibernateJavaSqlNamingCorrespondenceSimilarityHeuristic implements IFragmentASTAnalyzerHeuristic {

    private boolean areSimilar(JavaClassFragmentAST javaClassFragmentAST, SqlCreateTableFragment sqlCreateTableFragment) {
        return StringUtils.areLowerCaseEqual(javaClassFragmentAST.getIdentifier(), sqlCreateTableFragment.getTableName());
    }

    private boolean areSimilar(JavaFieldFragmentAST javaFieldFragmentAST, SqlColumnFragment sqlColumnFragment) {
        return StringUtils.areLowerCaseEqual(javaFieldFragmentAST.getIdentifier(), sqlColumnFragment.getColumnName());
    }

    private boolean areSimilar(JavaMethodFragmentAST javaMethodFragmentAST, SqlColumnFragment sqlColumnFragment) {
        return StringUtils.areLowerCaseEqual(JavaStringUtils.normalizeMethodName(javaMethodFragmentAST.getIdentifier()), sqlColumnFragment.getColumnName());
    }

    private void addSimilarities(IBinaryRelation<IFragmentAST> similarities, JavaFieldFragmentAST javaFieldFragmentAST, List<SqlColumnFragment> sqlColumnFragments) {
        for (SqlColumnFragment sqlColumnFragment : sqlColumnFragments) {
            if (areSimilar(javaFieldFragmentAST, sqlColumnFragment)) {
                similarities.add(javaFieldFragmentAST, sqlColumnFragment);
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragmentAST> similarities, JavaMethodFragmentAST javaMethodFragmentAST, List<SqlColumnFragment> sqlColumnFragments) {
        for (SqlColumnFragment sqlColumnFragment : sqlColumnFragments) {
            if (areSimilar(javaMethodFragmentAST, sqlColumnFragment)) {
                similarities.add(javaMethodFragmentAST, sqlColumnFragment);
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragmentAST> similarities, JavaClassFragmentAST javaClassFragmentAST, SqlCreateTableFragment sqlCreateTableFragment) {
        if (areSimilar(javaClassFragmentAST, sqlCreateTableFragment)) {
            similarities.add(javaClassFragmentAST, sqlCreateTableFragment);
            for (JavaFieldFragmentAST javaFieldFragmentAST : javaClassFragmentAST.getJavaFieldFragments()) {
                addSimilarities(similarities, javaFieldFragmentAST, sqlCreateTableFragment.getSqlColumnFragments());
            }
            for (JavaMethodFragmentAST javaMethodFragmentAST : javaClassFragmentAST.getJavaMethodFragments()) {
                addSimilarities(similarities, javaMethodFragmentAST, sqlCreateTableFragment.getSqlColumnFragments());
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaClassFragmentAST javaClassFragmentAST, SqlDocumentFragment sqlDocumentFragment) {
        for (SqlCreateTableFragment sqlCreateTableFragment : sqlDocumentFragment.getSqlCreateTableFragments()) {
            addSimilarities(similarity, javaClassFragmentAST, sqlCreateTableFragment);
        }
    }

    @Override
    public void analyze(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2) {
        if (fragment1 instanceof  JavaClassFragmentAST && fragment2 instanceof SqlDocumentFragment) {
            addSimilarities(similarity, (JavaClassFragmentAST) fragment1, (SqlDocumentFragment) fragment2);
        }
    }
}
