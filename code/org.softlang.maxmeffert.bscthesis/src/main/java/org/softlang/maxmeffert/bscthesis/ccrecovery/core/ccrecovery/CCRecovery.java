package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.analyzer.IAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinitionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;

import java.io.IOException;
import java.util.function.BiPredicate;

public class CCRecovery implements ICCRecovery {

    public static ICCRecovery create() {
        return IoC.get(ICCRecovery.class);
    }

    private final IAnalyzerFactory analyzerFactory;
    private final ILanguageFactory languageFactory;
    private final IParserFactory parserFactory;
    private final IAntlrConfigurationFactory antlrConfigurationFactory;
    private final ICorrespondenceDefinitionFactory correspondenceDefinitionFactory;

    @Inject
    public CCRecovery(IAnalyzerFactory analyzerFactory, ILanguageFactory languageFactory, IParserFactory parserFactory, IAntlrConfigurationFactory antlrConfigurationFactory, ICorrespondenceDefinitionFactory correspondenceDefinitionFactory) {
        this.analyzerFactory = analyzerFactory;
        this.languageFactory = languageFactory;
        this.parserFactory = parserFactory;
        this.antlrConfigurationFactory = antlrConfigurationFactory;
        this.correspondenceDefinitionFactory = correspondenceDefinitionFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> ILanguage defineLanguage(String name, IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory) {
        IAntlrConfiguration antlrConfiguration = antlrConfigurationFactory.newAntlrConfiguration(antlrLexerFactory, antlrParserFactory, antlrParseTreeFactory);
        IParser parser = parserFactory.newParser(antlrConfiguration);
        return languageFactory.newLanguage(name, parser);
    }

    @Override
    public ICorrespondenceDefinition defineCorrespondence(ILanguage language1, ILanguage language2, BiPredicate<IFragment, IFragment> predicate) {
        return correspondenceDefinitionFactory.newCorrespondenceDefinition(language1,language2, predicate);
    }


    @Override
    public void findCorrespondences(ICorrespondenceDefinition correspondenceDefinition, String artifact1, String artifact2) throws IOException {
        analyzerFactory.newAnalyzer().findCorrespondences(correspondenceDefinition, artifact1, artifact2);
    }
}
