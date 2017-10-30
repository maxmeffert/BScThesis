package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;

import java.io.IOException;
import java.io.InputStream;

public interface ICCRecoveryScenarios {

    IBinaryRelation<IFragmentAST> getWeakJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragmentAST> getStrictJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragmentAST> getWeakHibernateJavaXmlCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragmentAST> getStrictHibernateJavaXmlCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragmentAST> getWeakHibernateJavaSqlCorrespondences(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException;

    IBinaryRelation<IFragmentAST> getStrictHibernateJavaSqlCorrespondences(InputStream javaInputStream, InputStream sqlInputStream) throws IOException, ParserException;


}
