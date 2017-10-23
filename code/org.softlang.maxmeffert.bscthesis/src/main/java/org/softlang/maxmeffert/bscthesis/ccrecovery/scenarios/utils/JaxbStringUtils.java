package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

public class JaxbStringUtils {

    private static final String XmlRootElementAnnotationName = XmlRootElement.class.getSimpleName();
    private static final String XmlElementAnnotationName = XmlElement.class.getSimpleName();
    private static final String XmlElementWrapperAnnotatinName = XmlElementWrapper.class.getSimpleName();
    private static final String XmlAttributeAnnotationName = XmlAttribute.class.getSimpleName();

    private static final String[] JaxbAnnotationNames = new String[] {
            XmlRootElementAnnotationName,
            XmlElementAnnotationName,
            XmlElementWrapperAnnotatinName,
            XmlAttributeAnnotationName
    };

    public static boolean equalsAnyJaxbAnnotationName(String string) {
        return StringUtils.equalsAny(string, JaxbAnnotationNames);
    }

}
