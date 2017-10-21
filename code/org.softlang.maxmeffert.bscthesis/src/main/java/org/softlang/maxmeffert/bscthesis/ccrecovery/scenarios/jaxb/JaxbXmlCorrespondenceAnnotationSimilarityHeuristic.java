package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLElementFragment;

public class JaxbXmlCorrespondenceAnnotationSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {
    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        for (JavaModifierFragment javaModifierFragment : javaClassFragment.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                JavaAnnotationFragment javaAnnotationFragment = javaModifierFragment.getJavaAnnotationFragment();
                System.out.println(javaAnnotationFragment.getIdentifier());
                System.out.println(javaAnnotationFragment.getJavaAnnotationValueFragments());
            }
        }
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
