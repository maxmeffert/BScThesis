package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaAnnotationFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.HibernateJavaUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.HibernateXmlUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

import java.util.Optional;

public class HibernateJavaXmlAnnotationSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean isMemberTag(XmlElementFragment xmlElementFragment) {
        return HibernateXmlUtils.isHbmIdTag(xmlElementFragment) || HibernateXmlUtils.isHbmPropertyTag(xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        Optional<JavaAnnotationFragment> tableAnnotation = HibernateJavaUtils.getTableAnnotation(javaClassFragment);
        return HibernateXmlUtils.isHbmClassTag(xmlElementFragment)
                && tableAnnotation.isPresent()
                && tableAnnotation.get().hasNamedParameter("name")
                && XmlFragmentUtils.hasAttribute(xmlElementFragment,"table", tableAnnotation.get().getNamedParamterValue("name"));
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        Optional<JavaAnnotationFragment> columnAnnotation = HibernateJavaUtils.getColumnAnnotation(javaFieldFragment);
        return isMemberTag(xmlElementFragment)
                && columnAnnotation.isPresent()
                && columnAnnotation.get().hasNamedParameter("name")
                && HibernateXmlUtils.hasHbmColumnTag(xmlElementFragment, e -> XmlFragmentUtils.hasAttribute(e,"name", columnAnnotation.get().getNamedParamterValue("name")));
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
