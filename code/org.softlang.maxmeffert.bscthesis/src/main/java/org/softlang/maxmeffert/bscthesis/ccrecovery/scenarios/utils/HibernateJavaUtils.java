package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaAnnotationFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.ModifiedJavaFragment;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Optional;

public class HibernateJavaUtils {

    private static final String TableAnnotationName = Table.class.getSimpleName();
    private static final String ColumnAnnotationName = Column.class.getSimpleName();

    public static boolean hasTableAnnotation(ModifiedJavaFragment modifiedJavaFragment) {
        return JavaFragmentUtils.hasAnnotation(modifiedJavaFragment, TableAnnotationName);
    }

    public static boolean hasTableAnnotation(ModifiedJavaFragment modifiedJavaFragment, String tableName) {
        return JavaFragmentUtils.hasAnnotation(
                modifiedJavaFragment,
                TableAnnotationName,
                a -> a.hasNamedParameter("name")
                    && StringUtils.areLowerCaseEqual(a.getNamedParamterValue("name"), tableName));
    }

    public static Optional<JavaAnnotationFragment> getTableAnnotation(ModifiedJavaFragment modifiedJavaFragment) {
        return JavaFragmentUtils.getAnnotation(modifiedJavaFragment, TableAnnotationName);
    }

    public static boolean hasColumnAnnotation(ModifiedJavaFragment modifiedJavaFragment) {
        return JavaFragmentUtils.hasAnnotation(modifiedJavaFragment, ColumnAnnotationName);
    }

    public static boolean hasColumnAnnotation(ModifiedJavaFragment modifiedJavaFragment, String columnName) {
        return JavaFragmentUtils.hasAnnotation(
                modifiedJavaFragment,
                ColumnAnnotationName,
                a -> a.hasNamedParameter("name")
                        && StringUtils.areLowerCaseEqual(a.getNamedParamterValue("name"), columnName));
    }

    public  static Optional<JavaAnnotationFragment> getColumnAnnotation(ModifiedJavaFragment modifiedJavaFragment) {
        return JavaFragmentUtils.getAnnotation(modifiedJavaFragment, ColumnAnnotationName);
    }

}
