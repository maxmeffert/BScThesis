package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLElementFragmentAST;

public class JaxbXmlCorrespondenceAnnotationSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {
    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        for (JavaModifierFragmentAST javaModifierFragment : javaClassFragment.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                JavaAnnotationFragmentAST javaAnnotationFragment = javaModifierFragment.getJavaAnnotationFragment();
                System.out.println(javaAnnotationFragment.getIdentifier());
                System.out.println(javaAnnotationFragment.getJavaAnnotationValueFragments());
            }
        }
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }
}
