package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;

import java.io.IOException;
import java.io.InputStream;

public interface ICCRecoveryScenarios {

    IBinaryRelation<IFragment> getWeakJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getStrictJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getWeakHibernateJavaXmlCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getStrictHibernateJavaXmlCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getWeakHibernateJavaSqlCorrespondences(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragment> getStrictHibernateJavaSqlCorrespondences(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException;


}
