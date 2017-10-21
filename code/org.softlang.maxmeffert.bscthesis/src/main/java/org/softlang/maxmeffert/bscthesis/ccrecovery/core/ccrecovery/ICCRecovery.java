package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrLexerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondence;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerStrategy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface ICCRecovery {
    InputStream getInputStream(String string);
    InputStream getInputStream(File file) throws IOException;
    <TLexer extends Lexer, TParser extends Parser> ILanguage defineLanguage(String name, IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory, IFragmentBuildingListener fragmentBuildingListener);

    IFragment getFragmentAST(ILanguage language, InputStream inputStream) throws IOException, ParserException;

    ISimilarity analyzeSimilarities(IFragment fragment1, IFragment fragment2, ISimilarityAnalyzerStrategy similarityAnalyzerStrategy);

    @Deprecated
    ICorrespondenceDefinition defineCorrespondence(ILanguage language1, ILanguage language2, ISimilarity similarity);
    @Deprecated
    Set<ICorrespondence> findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String string1, String string2) throws Exception;
    @Deprecated
    Set<ICorrespondence> findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws Exception;
}
