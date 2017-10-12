package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer.IAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifact;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifactFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinitionBuilder;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinitionBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;

import java.io.IOException;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final IAnalyzerFactory analyzerFactory;
    private final ILanguageFactory languageFactory;
    private final IParserFactory parserFactory;
    private final IAntlrConfigurationFactory antlrConfigurationFactory;
    private final IArtifactFactory artifactFactory;
    private final ICorrespondenceDefinitionBuilderFactory correspondenceDefinitionBuilderFactory;

    @Inject
    public CCRecovery(IAnalyzerFactory analyzerFactory, ILanguageFactory languageFactory, IParserFactory parserFactory, IAntlrConfigurationFactory antlrConfigurationFactory, IArtifactFactory artifactFactory, ICorrespondenceDefinitionBuilderFactory correspondenceDefinitionBuilderFactory) {
        this.analyzerFactory = analyzerFactory;
        this.languageFactory = languageFactory;
        this.parserFactory = parserFactory;
        this.antlrConfigurationFactory = antlrConfigurationFactory;
        this.artifactFactory = artifactFactory;
        this.correspondenceDefinitionBuilderFactory = correspondenceDefinitionBuilderFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> ILanguage defineLanguage(String name, IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory) {
        IAntlrConfiguration antlrConfiguration = antlrConfigurationFactory.newAntlrConfiguration(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory);
        IParser parser = parserFactory.newParser(antlrConfiguration);
        return languageFactory.newLanguate(name, parser);
    }

    @Override
    public ICorrespondenceDefinitionBuilder defineCorrespondence() {
        return correspondenceDefinitionBuilderFactory.newCorrespondenceDefinitionBuilder();
    }

    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String string1, String string2) throws IOException {
        IArtifact artifact1 = artifactFactory.newArtifact(correspondenceDefinition.getLanguage1(), string1);
        IArtifact artifact2 = artifactFactory.newArtifact(correspondenceDefinition.getLanguage2(), string2);
        analyzerFactory.newAnalyzer().findCorrespondences(correspondenceDefinition, artifact1, artifact2);
    }
}
