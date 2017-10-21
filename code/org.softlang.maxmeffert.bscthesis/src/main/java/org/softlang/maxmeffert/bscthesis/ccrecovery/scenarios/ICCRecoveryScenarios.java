package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;

import java.io.IOException;
import java.io.InputStream;

public interface ICCRecoveryScenarios {

    void getJaxbCorrespondences(InputStream javaInputStream, InputStream xmlInputStream) throws IOException, ParserException;

}
