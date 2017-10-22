package org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc;

import com.google.inject.AbstractModule;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.BinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.CorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.CorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.DiGraphFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraphFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.FragmentKBBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.FragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentKBFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.IMereologyBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies.MereologyBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserResultFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.ParserResultFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTAnalyzerFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.FragmentASTAnalyzerFactory;

public class IoCConfig extends AbstractModule {
    @Override
    protected void configure() {
        configureAntlr();
        configureCCRecovery();
        configureConformances();
        configureCorrespondences();
        configureFragments();
        configureGraphs();
        configureMereologies();
        configureParsers();
        configureSimilarities();
        bind(IBinaryRelationFactory.class).to(BinaryRelationFactory.class);
    }

    private void configureSimilarities() {
        bind(IFragmentASTAnalyzerFactory.class).to(FragmentASTAnalyzerFactory.class);
    }

    private void configureAntlr() {
        bind(IAntlrCharStreamFactory.class).to(AntlrCharStreamFactory.class);
        bind(IAntlrIntervalFactory.class).to(AntlrIntervalFactory.class);
        bind(IAntlrTokenStreamFactory.class).to(AntlrCommonTokenStreamFactory.class);
        bind(IAntlrParseTreeWalkerFactory.class).to(AntlrParseTreeWalkerFactory.class);
        bind(IAntlrParseTreeErrorNodeListenerFactory.class).to(AntlrParseTreeErrorNodeListerFactory.class);
    }

    private void configureCCRecovery() {
        bind(ICCRecovery.class).to(CCRecovery.class);
    }

    private void configureConformances() {

    }

    private void configureCorrespondences() {
        bind(ICorrespondenceAnalyzerFactory.class).to(CorrespondenceAnalyzerFactory.class);
        bind(ICorrespondenceFactory.class).to(CorrespondenceFactory.class);
    }

    private void configureFragments() {
        bind(IFragmentKBFactory.class).to(FragmentKBFactory.class);
        bind(IFragmentKBBuilderFactory.class).to(FragmentKBBuilderFactory.class);
    }

    private void configureGraphs() {
        bind(IDiGraphFactory.class).to(DiGraphFactory.class);
    }

    private void configureMereologies() {
        bind(IMereologyBuilderFactory.class).to(MereologyBuilderFactory.class);
    }

    private void configureParsers() {
        bind(IParserResultFactory.class).to(ParserResultFactory.class);
        bind(IParserFactory.class).to(ParserFactory.class);
    }


}
