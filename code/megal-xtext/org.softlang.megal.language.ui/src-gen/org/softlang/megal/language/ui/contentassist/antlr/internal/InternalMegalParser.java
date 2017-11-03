package org.softlang.megal.language.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.softlang.megal.language.services.MegalGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMegalParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ANN_ID", "RULE_STRING", "RULE_VAR_ID", "RULE_INT", "RULE_COMMENT", "RULE_WS", "'model'", "'import'", "'='", "'('", "')'", "'|->'", "'<'", "'as'", "'entity'", "'*'", "'['", "']'", "'->'", "':'", "','", "'from'", "'{'", "'}'", "'(+)'", "'+'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_ANN_ID=5;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_VAR_ID=7;
    public static final int RULE_COMMENT=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMegalParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMegalParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMegalParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMegal.g"; }


     
     	private MegalGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MegalGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleMegalFile"
    // InternalMegal.g:60:1: entryRuleMegalFile : ruleMegalFile EOF ;
    public final void entryRuleMegalFile() throws RecognitionException {
        try {
            // InternalMegal.g:61:1: ( ruleMegalFile EOF )
            // InternalMegal.g:62:1: ruleMegalFile EOF
            {
             before(grammarAccess.getMegalFileRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalFile();

            state._fsp--;

             after(grammarAccess.getMegalFileRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalFile"


    // $ANTLR start "ruleMegalFile"
    // InternalMegal.g:69:1: ruleMegalFile : ( ( rule__MegalFile__Group__0 ) ) ;
    public final void ruleMegalFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:73:2: ( ( ( rule__MegalFile__Group__0 ) ) )
            // InternalMegal.g:74:1: ( ( rule__MegalFile__Group__0 ) )
            {
            // InternalMegal.g:74:1: ( ( rule__MegalFile__Group__0 ) )
            // InternalMegal.g:75:1: ( rule__MegalFile__Group__0 )
            {
             before(grammarAccess.getMegalFileAccess().getGroup()); 
            // InternalMegal.g:76:1: ( rule__MegalFile__Group__0 )
            // InternalMegal.g:76:2: rule__MegalFile__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalFileAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalFile"


    // $ANTLR start "entryRuleMegalAnnotation"
    // InternalMegal.g:88:1: entryRuleMegalAnnotation : ruleMegalAnnotation EOF ;
    public final void entryRuleMegalAnnotation() throws RecognitionException {
        try {
            // InternalMegal.g:89:1: ( ruleMegalAnnotation EOF )
            // InternalMegal.g:90:1: ruleMegalAnnotation EOF
            {
             before(grammarAccess.getMegalAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalAnnotationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalAnnotation"


    // $ANTLR start "ruleMegalAnnotation"
    // InternalMegal.g:97:1: ruleMegalAnnotation : ( ( rule__MegalAnnotation__Group__0 ) ) ;
    public final void ruleMegalAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:101:2: ( ( ( rule__MegalAnnotation__Group__0 ) ) )
            // InternalMegal.g:102:1: ( ( rule__MegalAnnotation__Group__0 ) )
            {
            // InternalMegal.g:102:1: ( ( rule__MegalAnnotation__Group__0 ) )
            // InternalMegal.g:103:1: ( rule__MegalAnnotation__Group__0 )
            {
             before(grammarAccess.getMegalAnnotationAccess().getGroup()); 
            // InternalMegal.g:104:1: ( rule__MegalAnnotation__Group__0 )
            // InternalMegal.g:104:2: rule__MegalAnnotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalAnnotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalAnnotation"


    // $ANTLR start "entryRuleMegalLink"
    // InternalMegal.g:116:1: entryRuleMegalLink : ruleMegalLink EOF ;
    public final void entryRuleMegalLink() throws RecognitionException {
        try {
            // InternalMegal.g:117:1: ( ruleMegalLink EOF )
            // InternalMegal.g:118:1: ruleMegalLink EOF
            {
             before(grammarAccess.getMegalLinkRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalLink();

            state._fsp--;

             after(grammarAccess.getMegalLinkRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalLink"


    // $ANTLR start "ruleMegalLink"
    // InternalMegal.g:125:1: ruleMegalLink : ( ( rule__MegalLink__Group__0 ) ) ;
    public final void ruleMegalLink() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:129:2: ( ( ( rule__MegalLink__Group__0 ) ) )
            // InternalMegal.g:130:1: ( ( rule__MegalLink__Group__0 ) )
            {
            // InternalMegal.g:130:1: ( ( rule__MegalLink__Group__0 ) )
            // InternalMegal.g:131:1: ( rule__MegalLink__Group__0 )
            {
             before(grammarAccess.getMegalLinkAccess().getGroup()); 
            // InternalMegal.g:132:1: ( rule__MegalLink__Group__0 )
            // InternalMegal.g:132:2: rule__MegalLink__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalLinkAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalLink"


    // $ANTLR start "entryRuleMegalEntityType"
    // InternalMegal.g:144:1: entryRuleMegalEntityType : ruleMegalEntityType EOF ;
    public final void entryRuleMegalEntityType() throws RecognitionException {
        try {
            // InternalMegal.g:145:1: ( ruleMegalEntityType EOF )
            // InternalMegal.g:146:1: ruleMegalEntityType EOF
            {
             before(grammarAccess.getMegalEntityTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalEntityType();

            state._fsp--;

             after(grammarAccess.getMegalEntityTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalEntityType"


    // $ANTLR start "ruleMegalEntityType"
    // InternalMegal.g:153:1: ruleMegalEntityType : ( ( rule__MegalEntityType__Group__0 ) ) ;
    public final void ruleMegalEntityType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:157:2: ( ( ( rule__MegalEntityType__Group__0 ) ) )
            // InternalMegal.g:158:1: ( ( rule__MegalEntityType__Group__0 ) )
            {
            // InternalMegal.g:158:1: ( ( rule__MegalEntityType__Group__0 ) )
            // InternalMegal.g:159:1: ( rule__MegalEntityType__Group__0 )
            {
             before(grammarAccess.getMegalEntityTypeAccess().getGroup()); 
            // InternalMegal.g:160:1: ( rule__MegalEntityType__Group__0 )
            // InternalMegal.g:160:2: rule__MegalEntityType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalEntityType"


    // $ANTLR start "entryRuleMegalRelationshipType"
    // InternalMegal.g:172:1: entryRuleMegalRelationshipType : ruleMegalRelationshipType EOF ;
    public final void entryRuleMegalRelationshipType() throws RecognitionException {
        try {
            // InternalMegal.g:173:1: ( ruleMegalRelationshipType EOF )
            // InternalMegal.g:174:1: ruleMegalRelationshipType EOF
            {
             before(grammarAccess.getMegalRelationshipTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalRelationshipType();

            state._fsp--;

             after(grammarAccess.getMegalRelationshipTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalRelationshipType"


    // $ANTLR start "ruleMegalRelationshipType"
    // InternalMegal.g:181:1: ruleMegalRelationshipType : ( ( rule__MegalRelationshipType__Group__0 ) ) ;
    public final void ruleMegalRelationshipType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:185:2: ( ( ( rule__MegalRelationshipType__Group__0 ) ) )
            // InternalMegal.g:186:1: ( ( rule__MegalRelationshipType__Group__0 ) )
            {
            // InternalMegal.g:186:1: ( ( rule__MegalRelationshipType__Group__0 ) )
            // InternalMegal.g:187:1: ( rule__MegalRelationshipType__Group__0 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getGroup()); 
            // InternalMegal.g:188:1: ( rule__MegalRelationshipType__Group__0 )
            // InternalMegal.g:188:2: rule__MegalRelationshipType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalRelationshipType"


    // $ANTLR start "entryRuleMegalEntity"
    // InternalMegal.g:200:1: entryRuleMegalEntity : ruleMegalEntity EOF ;
    public final void entryRuleMegalEntity() throws RecognitionException {
        try {
            // InternalMegal.g:201:1: ( ruleMegalEntity EOF )
            // InternalMegal.g:202:1: ruleMegalEntity EOF
            {
             before(grammarAccess.getMegalEntityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalEntity();

            state._fsp--;

             after(grammarAccess.getMegalEntityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalEntity"


    // $ANTLR start "ruleMegalEntity"
    // InternalMegal.g:209:1: ruleMegalEntity : ( ( rule__MegalEntity__Group__0 ) ) ;
    public final void ruleMegalEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:213:2: ( ( ( rule__MegalEntity__Group__0 ) ) )
            // InternalMegal.g:214:1: ( ( rule__MegalEntity__Group__0 ) )
            {
            // InternalMegal.g:214:1: ( ( rule__MegalEntity__Group__0 ) )
            // InternalMegal.g:215:1: ( rule__MegalEntity__Group__0 )
            {
             before(grammarAccess.getMegalEntityAccess().getGroup()); 
            // InternalMegal.g:216:1: ( rule__MegalEntity__Group__0 )
            // InternalMegal.g:216:2: rule__MegalEntity__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalEntity"


    // $ANTLR start "entryRuleMegalRelationship"
    // InternalMegal.g:228:1: entryRuleMegalRelationship : ruleMegalRelationship EOF ;
    public final void entryRuleMegalRelationship() throws RecognitionException {
        try {
            // InternalMegal.g:229:1: ( ruleMegalRelationship EOF )
            // InternalMegal.g:230:1: ruleMegalRelationship EOF
            {
             before(grammarAccess.getMegalRelationshipRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalRelationship();

            state._fsp--;

             after(grammarAccess.getMegalRelationshipRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalRelationship"


    // $ANTLR start "ruleMegalRelationship"
    // InternalMegal.g:237:1: ruleMegalRelationship : ( ( rule__MegalRelationship__Group__0 ) ) ;
    public final void ruleMegalRelationship() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:241:2: ( ( ( rule__MegalRelationship__Group__0 ) ) )
            // InternalMegal.g:242:1: ( ( rule__MegalRelationship__Group__0 ) )
            {
            // InternalMegal.g:242:1: ( ( rule__MegalRelationship__Group__0 ) )
            // InternalMegal.g:243:1: ( rule__MegalRelationship__Group__0 )
            {
             before(grammarAccess.getMegalRelationshipAccess().getGroup()); 
            // InternalMegal.g:244:1: ( rule__MegalRelationship__Group__0 )
            // InternalMegal.g:244:2: rule__MegalRelationship__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalRelationship"


    // $ANTLR start "entryRuleMegalPair"
    // InternalMegal.g:256:1: entryRuleMegalPair : ruleMegalPair EOF ;
    public final void entryRuleMegalPair() throws RecognitionException {
        try {
            // InternalMegal.g:257:1: ( ruleMegalPair EOF )
            // InternalMegal.g:258:1: ruleMegalPair EOF
            {
             before(grammarAccess.getMegalPairRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMegalPair();

            state._fsp--;

             after(grammarAccess.getMegalPairRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMegalPair"


    // $ANTLR start "ruleMegalPair"
    // InternalMegal.g:265:1: ruleMegalPair : ( ( rule__MegalPair__Group__0 ) ) ;
    public final void ruleMegalPair() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:269:2: ( ( ( rule__MegalPair__Group__0 ) ) )
            // InternalMegal.g:270:1: ( ( rule__MegalPair__Group__0 ) )
            {
            // InternalMegal.g:270:1: ( ( rule__MegalPair__Group__0 ) )
            // InternalMegal.g:271:1: ( rule__MegalPair__Group__0 )
            {
             before(grammarAccess.getMegalPairAccess().getGroup()); 
            // InternalMegal.g:272:1: ( rule__MegalPair__Group__0 )
            // InternalMegal.g:272:2: rule__MegalPair__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMegalPairAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMegalPair"


    // $ANTLR start "entryRuleSelection"
    // InternalMegal.g:284:1: entryRuleSelection : ruleSelection EOF ;
    public final void entryRuleSelection() throws RecognitionException {
        try {
            // InternalMegal.g:285:1: ( ruleSelection EOF )
            // InternalMegal.g:286:1: ruleSelection EOF
            {
             before(grammarAccess.getSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSelection();

            state._fsp--;

             after(grammarAccess.getSelectionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelection"


    // $ANTLR start "ruleSelection"
    // InternalMegal.g:293:1: ruleSelection : ( ( rule__Selection__Group__0 ) ) ;
    public final void ruleSelection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:297:2: ( ( ( rule__Selection__Group__0 ) ) )
            // InternalMegal.g:298:1: ( ( rule__Selection__Group__0 ) )
            {
            // InternalMegal.g:298:1: ( ( rule__Selection__Group__0 ) )
            // InternalMegal.g:299:1: ( rule__Selection__Group__0 )
            {
             before(grammarAccess.getSelectionAccess().getGroup()); 
            // InternalMegal.g:300:1: ( rule__Selection__Group__0 )
            // InternalMegal.g:300:2: rule__Selection__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelection"


    // $ANTLR start "entryRuleQueryStatement"
    // InternalMegal.g:312:1: entryRuleQueryStatement : ruleQueryStatement EOF ;
    public final void entryRuleQueryStatement() throws RecognitionException {
        try {
            // InternalMegal.g:313:1: ( ruleQueryStatement EOF )
            // InternalMegal.g:314:1: ruleQueryStatement EOF
            {
             before(grammarAccess.getQueryStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryStatement();

            state._fsp--;

             after(grammarAccess.getQueryStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryStatement"


    // $ANTLR start "ruleQueryStatement"
    // InternalMegal.g:321:1: ruleQueryStatement : ( ( rule__QueryStatement__Group__0 ) ) ;
    public final void ruleQueryStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:325:2: ( ( ( rule__QueryStatement__Group__0 ) ) )
            // InternalMegal.g:326:1: ( ( rule__QueryStatement__Group__0 ) )
            {
            // InternalMegal.g:326:1: ( ( rule__QueryStatement__Group__0 ) )
            // InternalMegal.g:327:1: ( rule__QueryStatement__Group__0 )
            {
             before(grammarAccess.getQueryStatementAccess().getGroup()); 
            // InternalMegal.g:328:1: ( rule__QueryStatement__Group__0 )
            // InternalMegal.g:328:2: rule__QueryStatement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQueryStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryStatement"


    // $ANTLR start "entryRuleQueryDefEntry"
    // InternalMegal.g:340:1: entryRuleQueryDefEntry : ruleQueryDefEntry EOF ;
    public final void entryRuleQueryDefEntry() throws RecognitionException {
        try {
            // InternalMegal.g:341:1: ( ruleQueryDefEntry EOF )
            // InternalMegal.g:342:1: ruleQueryDefEntry EOF
            {
             before(grammarAccess.getQueryDefEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryDefEntry();

            state._fsp--;

             after(grammarAccess.getQueryDefEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryDefEntry"


    // $ANTLR start "ruleQueryDefEntry"
    // InternalMegal.g:349:1: ruleQueryDefEntry : ( ( rule__QueryDefEntry__Alternatives ) ) ;
    public final void ruleQueryDefEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:353:2: ( ( ( rule__QueryDefEntry__Alternatives ) ) )
            // InternalMegal.g:354:1: ( ( rule__QueryDefEntry__Alternatives ) )
            {
            // InternalMegal.g:354:1: ( ( rule__QueryDefEntry__Alternatives ) )
            // InternalMegal.g:355:1: ( rule__QueryDefEntry__Alternatives )
            {
             before(grammarAccess.getQueryDefEntryAccess().getAlternatives()); 
            // InternalMegal.g:356:1: ( rule__QueryDefEntry__Alternatives )
            // InternalMegal.g:356:2: rule__QueryDefEntry__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryDefEntry__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQueryDefEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryDefEntry"


    // $ANTLR start "entryRuleQueryRefEntry"
    // InternalMegal.g:368:1: entryRuleQueryRefEntry : ruleQueryRefEntry EOF ;
    public final void entryRuleQueryRefEntry() throws RecognitionException {
        try {
            // InternalMegal.g:369:1: ( ruleQueryRefEntry EOF )
            // InternalMegal.g:370:1: ruleQueryRefEntry EOF
            {
             before(grammarAccess.getQueryRefEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryRefEntry();

            state._fsp--;

             after(grammarAccess.getQueryRefEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryRefEntry"


    // $ANTLR start "ruleQueryRefEntry"
    // InternalMegal.g:377:1: ruleQueryRefEntry : ( ( rule__QueryRefEntry__Alternatives ) ) ;
    public final void ruleQueryRefEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:381:2: ( ( ( rule__QueryRefEntry__Alternatives ) ) )
            // InternalMegal.g:382:1: ( ( rule__QueryRefEntry__Alternatives ) )
            {
            // InternalMegal.g:382:1: ( ( rule__QueryRefEntry__Alternatives ) )
            // InternalMegal.g:383:1: ( rule__QueryRefEntry__Alternatives )
            {
             before(grammarAccess.getQueryRefEntryAccess().getAlternatives()); 
            // InternalMegal.g:384:1: ( rule__QueryRefEntry__Alternatives )
            // InternalMegal.g:384:2: rule__QueryRefEntry__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryRefEntry__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQueryRefEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryRefEntry"


    // $ANTLR start "entryRuleQueryParam"
    // InternalMegal.g:396:1: entryRuleQueryParam : ruleQueryParam EOF ;
    public final void entryRuleQueryParam() throws RecognitionException {
        try {
            // InternalMegal.g:397:1: ( ruleQueryParam EOF )
            // InternalMegal.g:398:1: ruleQueryParam EOF
            {
             before(grammarAccess.getQueryParamRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryParam();

            state._fsp--;

             after(grammarAccess.getQueryParamRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryParam"


    // $ANTLR start "ruleQueryParam"
    // InternalMegal.g:405:1: ruleQueryParam : ( ( rule__QueryParam__Group__0 ) ) ;
    public final void ruleQueryParam() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:409:2: ( ( ( rule__QueryParam__Group__0 ) ) )
            // InternalMegal.g:410:1: ( ( rule__QueryParam__Group__0 ) )
            {
            // InternalMegal.g:410:1: ( ( rule__QueryParam__Group__0 ) )
            // InternalMegal.g:411:1: ( rule__QueryParam__Group__0 )
            {
             before(grammarAccess.getQueryParamAccess().getGroup()); 
            // InternalMegal.g:412:1: ( rule__QueryParam__Group__0 )
            // InternalMegal.g:412:2: rule__QueryParam__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQueryParamAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryParam"


    // $ANTLR start "entryRuleQueryReference"
    // InternalMegal.g:424:1: entryRuleQueryReference : ruleQueryReference EOF ;
    public final void entryRuleQueryReference() throws RecognitionException {
        try {
            // InternalMegal.g:425:1: ( ruleQueryReference EOF )
            // InternalMegal.g:426:1: ruleQueryReference EOF
            {
             before(grammarAccess.getQueryReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryReference();

            state._fsp--;

             after(grammarAccess.getQueryReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryReference"


    // $ANTLR start "ruleQueryReference"
    // InternalMegal.g:433:1: ruleQueryReference : ( ( rule__QueryReference__RefAssignment ) ) ;
    public final void ruleQueryReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:437:2: ( ( ( rule__QueryReference__RefAssignment ) ) )
            // InternalMegal.g:438:1: ( ( rule__QueryReference__RefAssignment ) )
            {
            // InternalMegal.g:438:1: ( ( rule__QueryReference__RefAssignment ) )
            // InternalMegal.g:439:1: ( rule__QueryReference__RefAssignment )
            {
             before(grammarAccess.getQueryReferenceAccess().getRefAssignment()); 
            // InternalMegal.g:440:1: ( rule__QueryReference__RefAssignment )
            // InternalMegal.g:440:2: rule__QueryReference__RefAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryReference__RefAssignment();

            state._fsp--;


            }

             after(grammarAccess.getQueryReferenceAccess().getRefAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryReference"


    // $ANTLR start "entryRuleQueryString"
    // InternalMegal.g:452:1: entryRuleQueryString : ruleQueryString EOF ;
    public final void entryRuleQueryString() throws RecognitionException {
        try {
            // InternalMegal.g:453:1: ( ruleQueryString EOF )
            // InternalMegal.g:454:1: ruleQueryString EOF
            {
             before(grammarAccess.getQueryStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryString();

            state._fsp--;

             after(grammarAccess.getQueryStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryString"


    // $ANTLR start "ruleQueryString"
    // InternalMegal.g:461:1: ruleQueryString : ( ( rule__QueryString__ValueAssignment ) ) ;
    public final void ruleQueryString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:465:2: ( ( ( rule__QueryString__ValueAssignment ) ) )
            // InternalMegal.g:466:1: ( ( rule__QueryString__ValueAssignment ) )
            {
            // InternalMegal.g:466:1: ( ( rule__QueryString__ValueAssignment ) )
            // InternalMegal.g:467:1: ( rule__QueryString__ValueAssignment )
            {
             before(grammarAccess.getQueryStringAccess().getValueAssignment()); 
            // InternalMegal.g:468:1: ( rule__QueryString__ValueAssignment )
            // InternalMegal.g:468:2: rule__QueryString__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryString__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getQueryStringAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryString"


    // $ANTLR start "entryRuleQueryEntity"
    // InternalMegal.g:480:1: entryRuleQueryEntity : ruleQueryEntity EOF ;
    public final void entryRuleQueryEntity() throws RecognitionException {
        try {
            // InternalMegal.g:481:1: ( ruleQueryEntity EOF )
            // InternalMegal.g:482:1: ruleQueryEntity EOF
            {
             before(grammarAccess.getQueryEntityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryEntity();

            state._fsp--;

             after(grammarAccess.getQueryEntityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryEntity"


    // $ANTLR start "ruleQueryEntity"
    // InternalMegal.g:489:1: ruleQueryEntity : ( ( rule__QueryEntity__EntityAssignment ) ) ;
    public final void ruleQueryEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:493:2: ( ( ( rule__QueryEntity__EntityAssignment ) ) )
            // InternalMegal.g:494:1: ( ( rule__QueryEntity__EntityAssignment ) )
            {
            // InternalMegal.g:494:1: ( ( rule__QueryEntity__EntityAssignment ) )
            // InternalMegal.g:495:1: ( rule__QueryEntity__EntityAssignment )
            {
             before(grammarAccess.getQueryEntityAccess().getEntityAssignment()); 
            // InternalMegal.g:496:1: ( rule__QueryEntity__EntityAssignment )
            // InternalMegal.g:496:2: rule__QueryEntity__EntityAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryEntity__EntityAssignment();

            state._fsp--;


            }

             after(grammarAccess.getQueryEntityAccess().getEntityAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryEntity"


    // $ANTLR start "entryRuleQueryPos"
    // InternalMegal.g:508:1: entryRuleQueryPos : ruleQueryPos EOF ;
    public final void entryRuleQueryPos() throws RecognitionException {
        try {
            // InternalMegal.g:509:1: ( ruleQueryPos EOF )
            // InternalMegal.g:510:1: ruleQueryPos EOF
            {
             before(grammarAccess.getQueryPosRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQueryPos();

            state._fsp--;

             after(grammarAccess.getQueryPosRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryPos"


    // $ANTLR start "ruleQueryPos"
    // InternalMegal.g:517:1: ruleQueryPos : ( ( rule__QueryPos__Group__0 ) ) ;
    public final void ruleQueryPos() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:521:2: ( ( ( rule__QueryPos__Group__0 ) ) )
            // InternalMegal.g:522:1: ( ( rule__QueryPos__Group__0 ) )
            {
            // InternalMegal.g:522:1: ( ( rule__QueryPos__Group__0 ) )
            // InternalMegal.g:523:1: ( rule__QueryPos__Group__0 )
            {
             before(grammarAccess.getQueryPosAccess().getGroup()); 
            // InternalMegal.g:524:1: ( rule__QueryPos__Group__0 )
            // InternalMegal.g:524:2: rule__QueryPos__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryPos__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQueryPosAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryPos"


    // $ANTLR start "rule__MegalFile__Alternatives_3"
    // InternalMegal.g:536:1: rule__MegalFile__Alternatives_3 : ( ( ( rule__MegalFile__Group_3_0__0 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_1 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_2 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_3 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_4 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_5 ) ) | ( ( rule__MegalFile__BindingsAssignment_3_6 ) ) );
    public final void rule__MegalFile__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:540:1: ( ( ( rule__MegalFile__Group_3_0__0 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_1 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_2 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_3 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_4 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_5 ) ) | ( ( rule__MegalFile__BindingsAssignment_3_6 ) ) )
            int alt1=7;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalMegal.g:541:1: ( ( rule__MegalFile__Group_3_0__0 ) )
                    {
                    // InternalMegal.g:541:1: ( ( rule__MegalFile__Group_3_0__0 ) )
                    // InternalMegal.g:542:1: ( rule__MegalFile__Group_3_0__0 )
                    {
                     before(grammarAccess.getMegalFileAccess().getGroup_3_0()); 
                    // InternalMegal.g:543:1: ( rule__MegalFile__Group_3_0__0 )
                    // InternalMegal.g:543:2: rule__MegalFile__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:547:6: ( ( rule__MegalFile__DeclarationsAssignment_3_1 ) )
                    {
                    // InternalMegal.g:547:6: ( ( rule__MegalFile__DeclarationsAssignment_3_1 ) )
                    // InternalMegal.g:548:1: ( rule__MegalFile__DeclarationsAssignment_3_1 )
                    {
                     before(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_1()); 
                    // InternalMegal.g:549:1: ( rule__MegalFile__DeclarationsAssignment_3_1 )
                    // InternalMegal.g:549:2: rule__MegalFile__DeclarationsAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__DeclarationsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMegal.g:553:6: ( ( rule__MegalFile__DeclarationsAssignment_3_2 ) )
                    {
                    // InternalMegal.g:553:6: ( ( rule__MegalFile__DeclarationsAssignment_3_2 ) )
                    // InternalMegal.g:554:1: ( rule__MegalFile__DeclarationsAssignment_3_2 )
                    {
                     before(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_2()); 
                    // InternalMegal.g:555:1: ( rule__MegalFile__DeclarationsAssignment_3_2 )
                    // InternalMegal.g:555:2: rule__MegalFile__DeclarationsAssignment_3_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__DeclarationsAssignment_3_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMegal.g:559:6: ( ( rule__MegalFile__DeclarationsAssignment_3_3 ) )
                    {
                    // InternalMegal.g:559:6: ( ( rule__MegalFile__DeclarationsAssignment_3_3 ) )
                    // InternalMegal.g:560:1: ( rule__MegalFile__DeclarationsAssignment_3_3 )
                    {
                     before(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_3()); 
                    // InternalMegal.g:561:1: ( rule__MegalFile__DeclarationsAssignment_3_3 )
                    // InternalMegal.g:561:2: rule__MegalFile__DeclarationsAssignment_3_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__DeclarationsAssignment_3_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMegal.g:565:6: ( ( rule__MegalFile__DeclarationsAssignment_3_4 ) )
                    {
                    // InternalMegal.g:565:6: ( ( rule__MegalFile__DeclarationsAssignment_3_4 ) )
                    // InternalMegal.g:566:1: ( rule__MegalFile__DeclarationsAssignment_3_4 )
                    {
                     before(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_4()); 
                    // InternalMegal.g:567:1: ( rule__MegalFile__DeclarationsAssignment_3_4 )
                    // InternalMegal.g:567:2: rule__MegalFile__DeclarationsAssignment_3_4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__DeclarationsAssignment_3_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMegal.g:571:6: ( ( rule__MegalFile__DeclarationsAssignment_3_5 ) )
                    {
                    // InternalMegal.g:571:6: ( ( rule__MegalFile__DeclarationsAssignment_3_5 ) )
                    // InternalMegal.g:572:1: ( rule__MegalFile__DeclarationsAssignment_3_5 )
                    {
                     before(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_5()); 
                    // InternalMegal.g:573:1: ( rule__MegalFile__DeclarationsAssignment_3_5 )
                    // InternalMegal.g:573:2: rule__MegalFile__DeclarationsAssignment_3_5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__DeclarationsAssignment_3_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getDeclarationsAssignment_3_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMegal.g:577:6: ( ( rule__MegalFile__BindingsAssignment_3_6 ) )
                    {
                    // InternalMegal.g:577:6: ( ( rule__MegalFile__BindingsAssignment_3_6 ) )
                    // InternalMegal.g:578:1: ( rule__MegalFile__BindingsAssignment_3_6 )
                    {
                     before(grammarAccess.getMegalFileAccess().getBindingsAssignment_3_6()); 
                    // InternalMegal.g:579:1: ( rule__MegalFile__BindingsAssignment_3_6 )
                    // InternalMegal.g:579:2: rule__MegalFile__BindingsAssignment_3_6
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalFile__BindingsAssignment_3_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalFileAccess().getBindingsAssignment_3_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Alternatives_3"


    // $ANTLR start "rule__MegalEntityType__Alternatives_2"
    // InternalMegal.g:588:1: rule__MegalEntityType__Alternatives_2 : ( ( ( rule__MegalEntityType__Group_2_0__0 ) ) | ( ( rule__MegalEntityType__Group_2_1__0 ) ) );
    public final void rule__MegalEntityType__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:592:1: ( ( ( rule__MegalEntityType__Group_2_0__0 ) ) | ( ( rule__MegalEntityType__Group_2_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMegal.g:593:1: ( ( rule__MegalEntityType__Group_2_0__0 ) )
                    {
                    // InternalMegal.g:593:1: ( ( rule__MegalEntityType__Group_2_0__0 ) )
                    // InternalMegal.g:594:1: ( rule__MegalEntityType__Group_2_0__0 )
                    {
                     before(grammarAccess.getMegalEntityTypeAccess().getGroup_2_0()); 
                    // InternalMegal.g:595:1: ( rule__MegalEntityType__Group_2_0__0 )
                    // InternalMegal.g:595:2: rule__MegalEntityType__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalEntityType__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalEntityTypeAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:599:6: ( ( rule__MegalEntityType__Group_2_1__0 ) )
                    {
                    // InternalMegal.g:599:6: ( ( rule__MegalEntityType__Group_2_1__0 ) )
                    // InternalMegal.g:600:1: ( rule__MegalEntityType__Group_2_1__0 )
                    {
                     before(grammarAccess.getMegalEntityTypeAccess().getGroup_2_1()); 
                    // InternalMegal.g:601:1: ( rule__MegalEntityType__Group_2_1__0 )
                    // InternalMegal.g:601:2: rule__MegalEntityType__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalEntityType__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalEntityTypeAccess().getGroup_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Alternatives_2"


    // $ANTLR start "rule__MegalRelationshipType__Alternatives_5"
    // InternalMegal.g:610:1: rule__MegalRelationshipType__Alternatives_5 : ( ( ( rule__MegalRelationshipType__LeftBothAssignment_5_0 ) ) | ( ( rule__MegalRelationshipType__LeftManyAssignment_5_1 ) ) );
    public final void rule__MegalRelationshipType__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:614:1: ( ( ( rule__MegalRelationshipType__LeftBothAssignment_5_0 ) ) | ( ( rule__MegalRelationshipType__LeftManyAssignment_5_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==29) ) {
                alt3=1;
            }
            else if ( (LA3_0==30) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMegal.g:615:1: ( ( rule__MegalRelationshipType__LeftBothAssignment_5_0 ) )
                    {
                    // InternalMegal.g:615:1: ( ( rule__MegalRelationshipType__LeftBothAssignment_5_0 ) )
                    // InternalMegal.g:616:1: ( rule__MegalRelationshipType__LeftBothAssignment_5_0 )
                    {
                     before(grammarAccess.getMegalRelationshipTypeAccess().getLeftBothAssignment_5_0()); 
                    // InternalMegal.g:617:1: ( rule__MegalRelationshipType__LeftBothAssignment_5_0 )
                    // InternalMegal.g:617:2: rule__MegalRelationshipType__LeftBothAssignment_5_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__LeftBothAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalRelationshipTypeAccess().getLeftBothAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:621:6: ( ( rule__MegalRelationshipType__LeftManyAssignment_5_1 ) )
                    {
                    // InternalMegal.g:621:6: ( ( rule__MegalRelationshipType__LeftManyAssignment_5_1 ) )
                    // InternalMegal.g:622:1: ( rule__MegalRelationshipType__LeftManyAssignment_5_1 )
                    {
                     before(grammarAccess.getMegalRelationshipTypeAccess().getLeftManyAssignment_5_1()); 
                    // InternalMegal.g:623:1: ( rule__MegalRelationshipType__LeftManyAssignment_5_1 )
                    // InternalMegal.g:623:2: rule__MegalRelationshipType__LeftManyAssignment_5_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__LeftManyAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalRelationshipTypeAccess().getLeftManyAssignment_5_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Alternatives_5"


    // $ANTLR start "rule__MegalRelationshipType__Alternatives_9"
    // InternalMegal.g:632:1: rule__MegalRelationshipType__Alternatives_9 : ( ( ( rule__MegalRelationshipType__RightBothAssignment_9_0 ) ) | ( ( rule__MegalRelationshipType__RightManyAssignment_9_1 ) ) );
    public final void rule__MegalRelationshipType__Alternatives_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:636:1: ( ( ( rule__MegalRelationshipType__RightBothAssignment_9_0 ) ) | ( ( rule__MegalRelationshipType__RightManyAssignment_9_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMegal.g:637:1: ( ( rule__MegalRelationshipType__RightBothAssignment_9_0 ) )
                    {
                    // InternalMegal.g:637:1: ( ( rule__MegalRelationshipType__RightBothAssignment_9_0 ) )
                    // InternalMegal.g:638:1: ( rule__MegalRelationshipType__RightBothAssignment_9_0 )
                    {
                     before(grammarAccess.getMegalRelationshipTypeAccess().getRightBothAssignment_9_0()); 
                    // InternalMegal.g:639:1: ( rule__MegalRelationshipType__RightBothAssignment_9_0 )
                    // InternalMegal.g:639:2: rule__MegalRelationshipType__RightBothAssignment_9_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__RightBothAssignment_9_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalRelationshipTypeAccess().getRightBothAssignment_9_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:643:6: ( ( rule__MegalRelationshipType__RightManyAssignment_9_1 ) )
                    {
                    // InternalMegal.g:643:6: ( ( rule__MegalRelationshipType__RightManyAssignment_9_1 ) )
                    // InternalMegal.g:644:1: ( rule__MegalRelationshipType__RightManyAssignment_9_1 )
                    {
                     before(grammarAccess.getMegalRelationshipTypeAccess().getRightManyAssignment_9_1()); 
                    // InternalMegal.g:645:1: ( rule__MegalRelationshipType__RightManyAssignment_9_1 )
                    // InternalMegal.g:645:2: rule__MegalRelationshipType__RightManyAssignment_9_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__RightManyAssignment_9_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMegalRelationshipTypeAccess().getRightManyAssignment_9_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Alternatives_9"


    // $ANTLR start "rule__QueryDefEntry__Alternatives"
    // InternalMegal.g:654:1: rule__QueryDefEntry__Alternatives : ( ( ruleQueryParam ) | ( ruleQueryString ) | ( ruleQueryEntity ) | ( ruleQueryPos ) );
    public final void rule__QueryDefEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:658:1: ( ( ruleQueryParam ) | ( ruleQueryString ) | ( ruleQueryEntity ) | ( ruleQueryPos ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_VAR_ID:
                {
                alt5=1;
                }
                break;
            case RULE_STRING:
                {
                alt5=2;
                }
                break;
            case RULE_ID:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMegal.g:659:1: ( ruleQueryParam )
                    {
                    // InternalMegal.g:659:1: ( ruleQueryParam )
                    // InternalMegal.g:660:1: ruleQueryParam
                    {
                     before(grammarAccess.getQueryDefEntryAccess().getQueryParamParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryParam();

                    state._fsp--;

                     after(grammarAccess.getQueryDefEntryAccess().getQueryParamParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:665:6: ( ruleQueryString )
                    {
                    // InternalMegal.g:665:6: ( ruleQueryString )
                    // InternalMegal.g:666:1: ruleQueryString
                    {
                     before(grammarAccess.getQueryDefEntryAccess().getQueryStringParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryString();

                    state._fsp--;

                     after(grammarAccess.getQueryDefEntryAccess().getQueryStringParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMegal.g:671:6: ( ruleQueryEntity )
                    {
                    // InternalMegal.g:671:6: ( ruleQueryEntity )
                    // InternalMegal.g:672:1: ruleQueryEntity
                    {
                     before(grammarAccess.getQueryDefEntryAccess().getQueryEntityParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryEntity();

                    state._fsp--;

                     after(grammarAccess.getQueryDefEntryAccess().getQueryEntityParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMegal.g:677:6: ( ruleQueryPos )
                    {
                    // InternalMegal.g:677:6: ( ruleQueryPos )
                    // InternalMegal.g:678:1: ruleQueryPos
                    {
                     before(grammarAccess.getQueryDefEntryAccess().getQueryPosParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryPos();

                    state._fsp--;

                     after(grammarAccess.getQueryDefEntryAccess().getQueryPosParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryDefEntry__Alternatives"


    // $ANTLR start "rule__QueryRefEntry__Alternatives"
    // InternalMegal.g:688:1: rule__QueryRefEntry__Alternatives : ( ( ruleQueryReference ) | ( ruleQueryString ) | ( ruleQueryEntity ) | ( ruleQueryPos ) );
    public final void rule__QueryRefEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:692:1: ( ( ruleQueryReference ) | ( ruleQueryString ) | ( ruleQueryEntity ) | ( ruleQueryPos ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case RULE_VAR_ID:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMegal.g:693:1: ( ruleQueryReference )
                    {
                    // InternalMegal.g:693:1: ( ruleQueryReference )
                    // InternalMegal.g:694:1: ruleQueryReference
                    {
                     before(grammarAccess.getQueryRefEntryAccess().getQueryReferenceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryReference();

                    state._fsp--;

                     after(grammarAccess.getQueryRefEntryAccess().getQueryReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:699:6: ( ruleQueryString )
                    {
                    // InternalMegal.g:699:6: ( ruleQueryString )
                    // InternalMegal.g:700:1: ruleQueryString
                    {
                     before(grammarAccess.getQueryRefEntryAccess().getQueryStringParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryString();

                    state._fsp--;

                     after(grammarAccess.getQueryRefEntryAccess().getQueryStringParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMegal.g:705:6: ( ruleQueryEntity )
                    {
                    // InternalMegal.g:705:6: ( ruleQueryEntity )
                    // InternalMegal.g:706:1: ruleQueryEntity
                    {
                     before(grammarAccess.getQueryRefEntryAccess().getQueryEntityParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryEntity();

                    state._fsp--;

                     after(grammarAccess.getQueryRefEntryAccess().getQueryEntityParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMegal.g:711:6: ( ruleQueryPos )
                    {
                    // InternalMegal.g:711:6: ( ruleQueryPos )
                    // InternalMegal.g:712:1: ruleQueryPos
                    {
                     before(grammarAccess.getQueryRefEntryAccess().getQueryPosParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQueryPos();

                    state._fsp--;

                     after(grammarAccess.getQueryRefEntryAccess().getQueryPosParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryRefEntry__Alternatives"


    // $ANTLR start "rule__MegalFile__Group__0"
    // InternalMegal.g:724:1: rule__MegalFile__Group__0 : rule__MegalFile__Group__0__Impl rule__MegalFile__Group__1 ;
    public final void rule__MegalFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:728:1: ( rule__MegalFile__Group__0__Impl rule__MegalFile__Group__1 )
            // InternalMegal.g:729:2: rule__MegalFile__Group__0__Impl rule__MegalFile__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__MegalFile__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__0"


    // $ANTLR start "rule__MegalFile__Group__0__Impl"
    // InternalMegal.g:736:1: rule__MegalFile__Group__0__Impl : ( ( rule__MegalFile__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:740:1: ( ( ( rule__MegalFile__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:741:1: ( ( rule__MegalFile__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:741:1: ( ( rule__MegalFile__AnnotationsAssignment_0 )* )
            // InternalMegal.g:742:1: ( rule__MegalFile__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalFileAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:743:1: ( rule__MegalFile__AnnotationsAssignment_0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ANN_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMegal.g:743:2: rule__MegalFile__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalFile__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getMegalFileAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__0__Impl"


    // $ANTLR start "rule__MegalFile__Group__1"
    // InternalMegal.g:753:1: rule__MegalFile__Group__1 : rule__MegalFile__Group__1__Impl rule__MegalFile__Group__2 ;
    public final void rule__MegalFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:757:1: ( rule__MegalFile__Group__1__Impl rule__MegalFile__Group__2 )
            // InternalMegal.g:758:2: rule__MegalFile__Group__1__Impl rule__MegalFile__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalFile__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__1"


    // $ANTLR start "rule__MegalFile__Group__1__Impl"
    // InternalMegal.g:765:1: rule__MegalFile__Group__1__Impl : ( 'model' ) ;
    public final void rule__MegalFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:769:1: ( ( 'model' ) )
            // InternalMegal.g:770:1: ( 'model' )
            {
            // InternalMegal.g:770:1: ( 'model' )
            // InternalMegal.g:771:1: 'model'
            {
             before(grammarAccess.getMegalFileAccess().getModelKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalFileAccess().getModelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__1__Impl"


    // $ANTLR start "rule__MegalFile__Group__2"
    // InternalMegal.g:784:1: rule__MegalFile__Group__2 : rule__MegalFile__Group__2__Impl rule__MegalFile__Group__3 ;
    public final void rule__MegalFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:788:1: ( rule__MegalFile__Group__2__Impl rule__MegalFile__Group__3 )
            // InternalMegal.g:789:2: rule__MegalFile__Group__2__Impl rule__MegalFile__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__MegalFile__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__2"


    // $ANTLR start "rule__MegalFile__Group__2__Impl"
    // InternalMegal.g:796:1: rule__MegalFile__Group__2__Impl : ( ( rule__MegalFile__NameAssignment_2 ) ) ;
    public final void rule__MegalFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:800:1: ( ( ( rule__MegalFile__NameAssignment_2 ) ) )
            // InternalMegal.g:801:1: ( ( rule__MegalFile__NameAssignment_2 ) )
            {
            // InternalMegal.g:801:1: ( ( rule__MegalFile__NameAssignment_2 ) )
            // InternalMegal.g:802:1: ( rule__MegalFile__NameAssignment_2 )
            {
             before(grammarAccess.getMegalFileAccess().getNameAssignment_2()); 
            // InternalMegal.g:803:1: ( rule__MegalFile__NameAssignment_2 )
            // InternalMegal.g:803:2: rule__MegalFile__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMegalFileAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__2__Impl"


    // $ANTLR start "rule__MegalFile__Group__3"
    // InternalMegal.g:813:1: rule__MegalFile__Group__3 : rule__MegalFile__Group__3__Impl ;
    public final void rule__MegalFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:817:1: ( rule__MegalFile__Group__3__Impl )
            // InternalMegal.g:818:2: rule__MegalFile__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__3"


    // $ANTLR start "rule__MegalFile__Group__3__Impl"
    // InternalMegal.g:824:1: rule__MegalFile__Group__3__Impl : ( ( rule__MegalFile__Alternatives_3 )* ) ;
    public final void rule__MegalFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:828:1: ( ( ( rule__MegalFile__Alternatives_3 )* ) )
            // InternalMegal.g:829:1: ( ( rule__MegalFile__Alternatives_3 )* )
            {
            // InternalMegal.g:829:1: ( ( rule__MegalFile__Alternatives_3 )* )
            // InternalMegal.g:830:1: ( rule__MegalFile__Alternatives_3 )*
            {
             before(grammarAccess.getMegalFileAccess().getAlternatives_3()); 
            // InternalMegal.g:831:1: ( rule__MegalFile__Alternatives_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_ANN_ID)||LA8_0==12) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMegal.g:831:2: rule__MegalFile__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__MegalFile__Alternatives_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getMegalFileAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group__3__Impl"


    // $ANTLR start "rule__MegalFile__Group_3_0__0"
    // InternalMegal.g:849:1: rule__MegalFile__Group_3_0__0 : rule__MegalFile__Group_3_0__0__Impl rule__MegalFile__Group_3_0__1 ;
    public final void rule__MegalFile__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:853:1: ( rule__MegalFile__Group_3_0__0__Impl rule__MegalFile__Group_3_0__1 )
            // InternalMegal.g:854:2: rule__MegalFile__Group_3_0__0__Impl rule__MegalFile__Group_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalFile__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group_3_0__0"


    // $ANTLR start "rule__MegalFile__Group_3_0__0__Impl"
    // InternalMegal.g:861:1: rule__MegalFile__Group_3_0__0__Impl : ( 'import' ) ;
    public final void rule__MegalFile__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:865:1: ( ( 'import' ) )
            // InternalMegal.g:866:1: ( 'import' )
            {
            // InternalMegal.g:866:1: ( 'import' )
            // InternalMegal.g:867:1: 'import'
            {
             before(grammarAccess.getMegalFileAccess().getImportKeyword_3_0_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalFileAccess().getImportKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group_3_0__0__Impl"


    // $ANTLR start "rule__MegalFile__Group_3_0__1"
    // InternalMegal.g:880:1: rule__MegalFile__Group_3_0__1 : rule__MegalFile__Group_3_0__1__Impl ;
    public final void rule__MegalFile__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:884:1: ( rule__MegalFile__Group_3_0__1__Impl )
            // InternalMegal.g:885:2: rule__MegalFile__Group_3_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__Group_3_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group_3_0__1"


    // $ANTLR start "rule__MegalFile__Group_3_0__1__Impl"
    // InternalMegal.g:891:1: rule__MegalFile__Group_3_0__1__Impl : ( ( rule__MegalFile__ImportsAssignment_3_0_1 ) ) ;
    public final void rule__MegalFile__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:895:1: ( ( ( rule__MegalFile__ImportsAssignment_3_0_1 ) ) )
            // InternalMegal.g:896:1: ( ( rule__MegalFile__ImportsAssignment_3_0_1 ) )
            {
            // InternalMegal.g:896:1: ( ( rule__MegalFile__ImportsAssignment_3_0_1 ) )
            // InternalMegal.g:897:1: ( rule__MegalFile__ImportsAssignment_3_0_1 )
            {
             before(grammarAccess.getMegalFileAccess().getImportsAssignment_3_0_1()); 
            // InternalMegal.g:898:1: ( rule__MegalFile__ImportsAssignment_3_0_1 )
            // InternalMegal.g:898:2: rule__MegalFile__ImportsAssignment_3_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalFile__ImportsAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalFileAccess().getImportsAssignment_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__Group_3_0__1__Impl"


    // $ANTLR start "rule__MegalAnnotation__Group__0"
    // InternalMegal.g:912:1: rule__MegalAnnotation__Group__0 : rule__MegalAnnotation__Group__0__Impl rule__MegalAnnotation__Group__1 ;
    public final void rule__MegalAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:916:1: ( rule__MegalAnnotation__Group__0__Impl rule__MegalAnnotation__Group__1 )
            // InternalMegal.g:917:2: rule__MegalAnnotation__Group__0__Impl rule__MegalAnnotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MegalAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalAnnotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalAnnotation__Group__0"


    // $ANTLR start "rule__MegalAnnotation__Group__0__Impl"
    // InternalMegal.g:924:1: rule__MegalAnnotation__Group__0__Impl : ( ( rule__MegalAnnotation__KeyAssignment_0 ) ) ;
    public final void rule__MegalAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:928:1: ( ( ( rule__MegalAnnotation__KeyAssignment_0 ) ) )
            // InternalMegal.g:929:1: ( ( rule__MegalAnnotation__KeyAssignment_0 ) )
            {
            // InternalMegal.g:929:1: ( ( rule__MegalAnnotation__KeyAssignment_0 ) )
            // InternalMegal.g:930:1: ( rule__MegalAnnotation__KeyAssignment_0 )
            {
             before(grammarAccess.getMegalAnnotationAccess().getKeyAssignment_0()); 
            // InternalMegal.g:931:1: ( rule__MegalAnnotation__KeyAssignment_0 )
            // InternalMegal.g:931:2: rule__MegalAnnotation__KeyAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalAnnotation__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMegalAnnotationAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalAnnotation__Group__0__Impl"


    // $ANTLR start "rule__MegalAnnotation__Group__1"
    // InternalMegal.g:941:1: rule__MegalAnnotation__Group__1 : rule__MegalAnnotation__Group__1__Impl ;
    public final void rule__MegalAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:945:1: ( rule__MegalAnnotation__Group__1__Impl )
            // InternalMegal.g:946:2: rule__MegalAnnotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalAnnotation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalAnnotation__Group__1"


    // $ANTLR start "rule__MegalAnnotation__Group__1__Impl"
    // InternalMegal.g:952:1: rule__MegalAnnotation__Group__1__Impl : ( ( rule__MegalAnnotation__SelectionAssignment_1 )? ) ;
    public final void rule__MegalAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:956:1: ( ( ( rule__MegalAnnotation__SelectionAssignment_1 )? ) )
            // InternalMegal.g:957:1: ( ( rule__MegalAnnotation__SelectionAssignment_1 )? )
            {
            // InternalMegal.g:957:1: ( ( rule__MegalAnnotation__SelectionAssignment_1 )? )
            // InternalMegal.g:958:1: ( rule__MegalAnnotation__SelectionAssignment_1 )?
            {
             before(grammarAccess.getMegalAnnotationAccess().getSelectionAssignment_1()); 
            // InternalMegal.g:959:1: ( rule__MegalAnnotation__SelectionAssignment_1 )?
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalMegal.g:959:2: rule__MegalAnnotation__SelectionAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalAnnotation__SelectionAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalAnnotationAccess().getSelectionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalAnnotation__Group__1__Impl"


    // $ANTLR start "rule__MegalLink__Group__0"
    // InternalMegal.g:973:1: rule__MegalLink__Group__0 : rule__MegalLink__Group__0__Impl rule__MegalLink__Group__1 ;
    public final void rule__MegalLink__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:977:1: ( rule__MegalLink__Group__0__Impl rule__MegalLink__Group__1 )
            // InternalMegal.g:978:2: rule__MegalLink__Group__0__Impl rule__MegalLink__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__MegalLink__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__0"


    // $ANTLR start "rule__MegalLink__Group__0__Impl"
    // InternalMegal.g:985:1: rule__MegalLink__Group__0__Impl : ( ( rule__MegalLink__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalLink__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:989:1: ( ( ( rule__MegalLink__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:990:1: ( ( rule__MegalLink__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:990:1: ( ( rule__MegalLink__AnnotationsAssignment_0 )* )
            // InternalMegal.g:991:1: ( rule__MegalLink__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalLinkAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:992:1: ( rule__MegalLink__AnnotationsAssignment_0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ANN_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMegal.g:992:2: rule__MegalLink__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalLink__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMegalLinkAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__0__Impl"


    // $ANTLR start "rule__MegalLink__Group__1"
    // InternalMegal.g:1002:1: rule__MegalLink__Group__1 : rule__MegalLink__Group__1__Impl rule__MegalLink__Group__2 ;
    public final void rule__MegalLink__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1006:1: ( rule__MegalLink__Group__1__Impl rule__MegalLink__Group__2 )
            // InternalMegal.g:1007:2: rule__MegalLink__Group__1__Impl rule__MegalLink__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MegalLink__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__1"


    // $ANTLR start "rule__MegalLink__Group__1__Impl"
    // InternalMegal.g:1014:1: rule__MegalLink__Group__1__Impl : ( ( rule__MegalLink__LinkAssignment_1 ) ) ;
    public final void rule__MegalLink__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1018:1: ( ( ( rule__MegalLink__LinkAssignment_1 ) ) )
            // InternalMegal.g:1019:1: ( ( rule__MegalLink__LinkAssignment_1 ) )
            {
            // InternalMegal.g:1019:1: ( ( rule__MegalLink__LinkAssignment_1 ) )
            // InternalMegal.g:1020:1: ( rule__MegalLink__LinkAssignment_1 )
            {
             before(grammarAccess.getMegalLinkAccess().getLinkAssignment_1()); 
            // InternalMegal.g:1021:1: ( rule__MegalLink__LinkAssignment_1 )
            // InternalMegal.g:1021:2: rule__MegalLink__LinkAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__LinkAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalLinkAccess().getLinkAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__1__Impl"


    // $ANTLR start "rule__MegalLink__Group__2"
    // InternalMegal.g:1031:1: rule__MegalLink__Group__2 : rule__MegalLink__Group__2__Impl rule__MegalLink__Group__3 ;
    public final void rule__MegalLink__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1035:1: ( rule__MegalLink__Group__2__Impl rule__MegalLink__Group__3 )
            // InternalMegal.g:1036:2: rule__MegalLink__Group__2__Impl rule__MegalLink__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MegalLink__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__2"


    // $ANTLR start "rule__MegalLink__Group__2__Impl"
    // InternalMegal.g:1043:1: rule__MegalLink__Group__2__Impl : ( ( rule__MegalLink__Group_2__0 )? ) ;
    public final void rule__MegalLink__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1047:1: ( ( ( rule__MegalLink__Group_2__0 )? ) )
            // InternalMegal.g:1048:1: ( ( rule__MegalLink__Group_2__0 )? )
            {
            // InternalMegal.g:1048:1: ( ( rule__MegalLink__Group_2__0 )? )
            // InternalMegal.g:1049:1: ( rule__MegalLink__Group_2__0 )?
            {
             before(grammarAccess.getMegalLinkAccess().getGroup_2()); 
            // InternalMegal.g:1050:1: ( rule__MegalLink__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==14) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMegal.g:1050:2: rule__MegalLink__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalLink__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalLinkAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__2__Impl"


    // $ANTLR start "rule__MegalLink__Group__3"
    // InternalMegal.g:1060:1: rule__MegalLink__Group__3 : rule__MegalLink__Group__3__Impl rule__MegalLink__Group__4 ;
    public final void rule__MegalLink__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1064:1: ( rule__MegalLink__Group__3__Impl rule__MegalLink__Group__4 )
            // InternalMegal.g:1065:2: rule__MegalLink__Group__3__Impl rule__MegalLink__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MegalLink__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__3"


    // $ANTLR start "rule__MegalLink__Group__3__Impl"
    // InternalMegal.g:1072:1: rule__MegalLink__Group__3__Impl : ( '=' ) ;
    public final void rule__MegalLink__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1076:1: ( ( '=' ) )
            // InternalMegal.g:1077:1: ( '=' )
            {
            // InternalMegal.g:1077:1: ( '=' )
            // InternalMegal.g:1078:1: '='
            {
             before(grammarAccess.getMegalLinkAccess().getEqualsSignKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getEqualsSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__3__Impl"


    // $ANTLR start "rule__MegalLink__Group__4"
    // InternalMegal.g:1091:1: rule__MegalLink__Group__4 : rule__MegalLink__Group__4__Impl ;
    public final void rule__MegalLink__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1095:1: ( rule__MegalLink__Group__4__Impl )
            // InternalMegal.g:1096:2: rule__MegalLink__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__4"


    // $ANTLR start "rule__MegalLink__Group__4__Impl"
    // InternalMegal.g:1102:1: rule__MegalLink__Group__4__Impl : ( ( rule__MegalLink__ToAssignment_4 ) ) ;
    public final void rule__MegalLink__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1106:1: ( ( ( rule__MegalLink__ToAssignment_4 ) ) )
            // InternalMegal.g:1107:1: ( ( rule__MegalLink__ToAssignment_4 ) )
            {
            // InternalMegal.g:1107:1: ( ( rule__MegalLink__ToAssignment_4 ) )
            // InternalMegal.g:1108:1: ( rule__MegalLink__ToAssignment_4 )
            {
             before(grammarAccess.getMegalLinkAccess().getToAssignment_4()); 
            // InternalMegal.g:1109:1: ( rule__MegalLink__ToAssignment_4 )
            // InternalMegal.g:1109:2: rule__MegalLink__ToAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__ToAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMegalLinkAccess().getToAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group__4__Impl"


    // $ANTLR start "rule__MegalLink__Group_2__0"
    // InternalMegal.g:1129:1: rule__MegalLink__Group_2__0 : rule__MegalLink__Group_2__0__Impl rule__MegalLink__Group_2__1 ;
    public final void rule__MegalLink__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1133:1: ( rule__MegalLink__Group_2__0__Impl rule__MegalLink__Group_2__1 )
            // InternalMegal.g:1134:2: rule__MegalLink__Group_2__0__Impl rule__MegalLink__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalLink__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__0"


    // $ANTLR start "rule__MegalLink__Group_2__0__Impl"
    // InternalMegal.g:1141:1: rule__MegalLink__Group_2__0__Impl : ( '(' ) ;
    public final void rule__MegalLink__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1145:1: ( ( '(' ) )
            // InternalMegal.g:1146:1: ( '(' )
            {
            // InternalMegal.g:1146:1: ( '(' )
            // InternalMegal.g:1147:1: '('
            {
             before(grammarAccess.getMegalLinkAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__0__Impl"


    // $ANTLR start "rule__MegalLink__Group_2__1"
    // InternalMegal.g:1160:1: rule__MegalLink__Group_2__1 : rule__MegalLink__Group_2__1__Impl rule__MegalLink__Group_2__2 ;
    public final void rule__MegalLink__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1164:1: ( rule__MegalLink__Group_2__1__Impl rule__MegalLink__Group_2__2 )
            // InternalMegal.g:1165:2: rule__MegalLink__Group_2__1__Impl rule__MegalLink__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__MegalLink__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__1"


    // $ANTLR start "rule__MegalLink__Group_2__1__Impl"
    // InternalMegal.g:1172:1: rule__MegalLink__Group_2__1__Impl : ( ( rule__MegalLink__FirstAssignment_2_1 ) ) ;
    public final void rule__MegalLink__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1176:1: ( ( ( rule__MegalLink__FirstAssignment_2_1 ) ) )
            // InternalMegal.g:1177:1: ( ( rule__MegalLink__FirstAssignment_2_1 ) )
            {
            // InternalMegal.g:1177:1: ( ( rule__MegalLink__FirstAssignment_2_1 ) )
            // InternalMegal.g:1178:1: ( rule__MegalLink__FirstAssignment_2_1 )
            {
             before(grammarAccess.getMegalLinkAccess().getFirstAssignment_2_1()); 
            // InternalMegal.g:1179:1: ( rule__MegalLink__FirstAssignment_2_1 )
            // InternalMegal.g:1179:2: rule__MegalLink__FirstAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__FirstAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalLinkAccess().getFirstAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__1__Impl"


    // $ANTLR start "rule__MegalLink__Group_2__2"
    // InternalMegal.g:1189:1: rule__MegalLink__Group_2__2 : rule__MegalLink__Group_2__2__Impl rule__MegalLink__Group_2__3 ;
    public final void rule__MegalLink__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1193:1: ( rule__MegalLink__Group_2__2__Impl rule__MegalLink__Group_2__3 )
            // InternalMegal.g:1194:2: rule__MegalLink__Group_2__2__Impl rule__MegalLink__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__MegalLink__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__2"


    // $ANTLR start "rule__MegalLink__Group_2__2__Impl"
    // InternalMegal.g:1201:1: rule__MegalLink__Group_2__2__Impl : ( ')' ) ;
    public final void rule__MegalLink__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1205:1: ( ( ')' ) )
            // InternalMegal.g:1206:1: ( ')' )
            {
            // InternalMegal.g:1206:1: ( ')' )
            // InternalMegal.g:1207:1: ')'
            {
             before(grammarAccess.getMegalLinkAccess().getRightParenthesisKeyword_2_2()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getRightParenthesisKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__2__Impl"


    // $ANTLR start "rule__MegalLink__Group_2__3"
    // InternalMegal.g:1220:1: rule__MegalLink__Group_2__3 : rule__MegalLink__Group_2__3__Impl rule__MegalLink__Group_2__4 ;
    public final void rule__MegalLink__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1224:1: ( rule__MegalLink__Group_2__3__Impl rule__MegalLink__Group_2__4 )
            // InternalMegal.g:1225:2: rule__MegalLink__Group_2__3__Impl rule__MegalLink__Group_2__4
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalLink__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__3"


    // $ANTLR start "rule__MegalLink__Group_2__3__Impl"
    // InternalMegal.g:1232:1: rule__MegalLink__Group_2__3__Impl : ( '|->' ) ;
    public final void rule__MegalLink__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1236:1: ( ( '|->' ) )
            // InternalMegal.g:1237:1: ( '|->' )
            {
            // InternalMegal.g:1237:1: ( '|->' )
            // InternalMegal.g:1238:1: '|->'
            {
             before(grammarAccess.getMegalLinkAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_2_3()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__3__Impl"


    // $ANTLR start "rule__MegalLink__Group_2__4"
    // InternalMegal.g:1251:1: rule__MegalLink__Group_2__4 : rule__MegalLink__Group_2__4__Impl ;
    public final void rule__MegalLink__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1255:1: ( rule__MegalLink__Group_2__4__Impl )
            // InternalMegal.g:1256:2: rule__MegalLink__Group_2__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__Group_2__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__4"


    // $ANTLR start "rule__MegalLink__Group_2__4__Impl"
    // InternalMegal.g:1262:1: rule__MegalLink__Group_2__4__Impl : ( ( rule__MegalLink__SecondAssignment_2_4 ) ) ;
    public final void rule__MegalLink__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1266:1: ( ( ( rule__MegalLink__SecondAssignment_2_4 ) ) )
            // InternalMegal.g:1267:1: ( ( rule__MegalLink__SecondAssignment_2_4 ) )
            {
            // InternalMegal.g:1267:1: ( ( rule__MegalLink__SecondAssignment_2_4 ) )
            // InternalMegal.g:1268:1: ( rule__MegalLink__SecondAssignment_2_4 )
            {
             before(grammarAccess.getMegalLinkAccess().getSecondAssignment_2_4()); 
            // InternalMegal.g:1269:1: ( rule__MegalLink__SecondAssignment_2_4 )
            // InternalMegal.g:1269:2: rule__MegalLink__SecondAssignment_2_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalLink__SecondAssignment_2_4();

            state._fsp--;


            }

             after(grammarAccess.getMegalLinkAccess().getSecondAssignment_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__Group_2__4__Impl"


    // $ANTLR start "rule__MegalEntityType__Group__0"
    // InternalMegal.g:1289:1: rule__MegalEntityType__Group__0 : rule__MegalEntityType__Group__0__Impl rule__MegalEntityType__Group__1 ;
    public final void rule__MegalEntityType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1293:1: ( rule__MegalEntityType__Group__0__Impl rule__MegalEntityType__Group__1 )
            // InternalMegal.g:1294:2: rule__MegalEntityType__Group__0__Impl rule__MegalEntityType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MegalEntityType__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group__0"


    // $ANTLR start "rule__MegalEntityType__Group__0__Impl"
    // InternalMegal.g:1301:1: rule__MegalEntityType__Group__0__Impl : ( ( rule__MegalEntityType__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalEntityType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1305:1: ( ( ( rule__MegalEntityType__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:1306:1: ( ( rule__MegalEntityType__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:1306:1: ( ( rule__MegalEntityType__AnnotationsAssignment_0 )* )
            // InternalMegal.g:1307:1: ( rule__MegalEntityType__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalEntityTypeAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:1308:1: ( rule__MegalEntityType__AnnotationsAssignment_0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ANN_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMegal.g:1308:2: rule__MegalEntityType__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalEntityType__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getMegalEntityTypeAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group__0__Impl"


    // $ANTLR start "rule__MegalEntityType__Group__1"
    // InternalMegal.g:1318:1: rule__MegalEntityType__Group__1 : rule__MegalEntityType__Group__1__Impl rule__MegalEntityType__Group__2 ;
    public final void rule__MegalEntityType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1322:1: ( rule__MegalEntityType__Group__1__Impl rule__MegalEntityType__Group__2 )
            // InternalMegal.g:1323:2: rule__MegalEntityType__Group__1__Impl rule__MegalEntityType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__MegalEntityType__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group__1"


    // $ANTLR start "rule__MegalEntityType__Group__1__Impl"
    // InternalMegal.g:1330:1: rule__MegalEntityType__Group__1__Impl : ( ( rule__MegalEntityType__NameAssignment_1 ) ) ;
    public final void rule__MegalEntityType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1334:1: ( ( ( rule__MegalEntityType__NameAssignment_1 ) ) )
            // InternalMegal.g:1335:1: ( ( rule__MegalEntityType__NameAssignment_1 ) )
            {
            // InternalMegal.g:1335:1: ( ( rule__MegalEntityType__NameAssignment_1 ) )
            // InternalMegal.g:1336:1: ( rule__MegalEntityType__NameAssignment_1 )
            {
             before(grammarAccess.getMegalEntityTypeAccess().getNameAssignment_1()); 
            // InternalMegal.g:1337:1: ( rule__MegalEntityType__NameAssignment_1 )
            // InternalMegal.g:1337:2: rule__MegalEntityType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group__1__Impl"


    // $ANTLR start "rule__MegalEntityType__Group__2"
    // InternalMegal.g:1347:1: rule__MegalEntityType__Group__2 : rule__MegalEntityType__Group__2__Impl ;
    public final void rule__MegalEntityType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1351:1: ( rule__MegalEntityType__Group__2__Impl )
            // InternalMegal.g:1352:2: rule__MegalEntityType__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group__2"


    // $ANTLR start "rule__MegalEntityType__Group__2__Impl"
    // InternalMegal.g:1358:1: rule__MegalEntityType__Group__2__Impl : ( ( rule__MegalEntityType__Alternatives_2 ) ) ;
    public final void rule__MegalEntityType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1362:1: ( ( ( rule__MegalEntityType__Alternatives_2 ) ) )
            // InternalMegal.g:1363:1: ( ( rule__MegalEntityType__Alternatives_2 ) )
            {
            // InternalMegal.g:1363:1: ( ( rule__MegalEntityType__Alternatives_2 ) )
            // InternalMegal.g:1364:1: ( rule__MegalEntityType__Alternatives_2 )
            {
             before(grammarAccess.getMegalEntityTypeAccess().getAlternatives_2()); 
            // InternalMegal.g:1365:1: ( rule__MegalEntityType__Alternatives_2 )
            // InternalMegal.g:1365:2: rule__MegalEntityType__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityTypeAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group__2__Impl"


    // $ANTLR start "rule__MegalEntityType__Group_2_0__0"
    // InternalMegal.g:1381:1: rule__MegalEntityType__Group_2_0__0 : rule__MegalEntityType__Group_2_0__0__Impl rule__MegalEntityType__Group_2_0__1 ;
    public final void rule__MegalEntityType__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1385:1: ( rule__MegalEntityType__Group_2_0__0__Impl rule__MegalEntityType__Group_2_0__1 )
            // InternalMegal.g:1386:2: rule__MegalEntityType__Group_2_0__0__Impl rule__MegalEntityType__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalEntityType__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_0__0"


    // $ANTLR start "rule__MegalEntityType__Group_2_0__0__Impl"
    // InternalMegal.g:1393:1: rule__MegalEntityType__Group_2_0__0__Impl : ( '<' ) ;
    public final void rule__MegalEntityType__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1397:1: ( ( '<' ) )
            // InternalMegal.g:1398:1: ( '<' )
            {
            // InternalMegal.g:1398:1: ( '<' )
            // InternalMegal.g:1399:1: '<'
            {
             before(grammarAccess.getMegalEntityTypeAccess().getLessThanSignKeyword_2_0_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityTypeAccess().getLessThanSignKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_0__0__Impl"


    // $ANTLR start "rule__MegalEntityType__Group_2_0__1"
    // InternalMegal.g:1412:1: rule__MegalEntityType__Group_2_0__1 : rule__MegalEntityType__Group_2_0__1__Impl ;
    public final void rule__MegalEntityType__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1416:1: ( rule__MegalEntityType__Group_2_0__1__Impl )
            // InternalMegal.g:1417:2: rule__MegalEntityType__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_0__1"


    // $ANTLR start "rule__MegalEntityType__Group_2_0__1__Impl"
    // InternalMegal.g:1423:1: rule__MegalEntityType__Group_2_0__1__Impl : ( ( rule__MegalEntityType__SupertypeAssignment_2_0_1 ) ) ;
    public final void rule__MegalEntityType__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1427:1: ( ( ( rule__MegalEntityType__SupertypeAssignment_2_0_1 ) ) )
            // InternalMegal.g:1428:1: ( ( rule__MegalEntityType__SupertypeAssignment_2_0_1 ) )
            {
            // InternalMegal.g:1428:1: ( ( rule__MegalEntityType__SupertypeAssignment_2_0_1 ) )
            // InternalMegal.g:1429:1: ( rule__MegalEntityType__SupertypeAssignment_2_0_1 )
            {
             before(grammarAccess.getMegalEntityTypeAccess().getSupertypeAssignment_2_0_1()); 
            // InternalMegal.g:1430:1: ( rule__MegalEntityType__SupertypeAssignment_2_0_1 )
            // InternalMegal.g:1430:2: rule__MegalEntityType__SupertypeAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__SupertypeAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityTypeAccess().getSupertypeAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_0__1__Impl"


    // $ANTLR start "rule__MegalEntityType__Group_2_1__0"
    // InternalMegal.g:1444:1: rule__MegalEntityType__Group_2_1__0 : rule__MegalEntityType__Group_2_1__0__Impl rule__MegalEntityType__Group_2_1__1 ;
    public final void rule__MegalEntityType__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1448:1: ( rule__MegalEntityType__Group_2_1__0__Impl rule__MegalEntityType__Group_2_1__1 )
            // InternalMegal.g:1449:2: rule__MegalEntityType__Group_2_1__0__Impl rule__MegalEntityType__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__MegalEntityType__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_1__0"


    // $ANTLR start "rule__MegalEntityType__Group_2_1__0__Impl"
    // InternalMegal.g:1456:1: rule__MegalEntityType__Group_2_1__0__Impl : ( 'as' ) ;
    public final void rule__MegalEntityType__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1460:1: ( ( 'as' ) )
            // InternalMegal.g:1461:1: ( 'as' )
            {
            // InternalMegal.g:1461:1: ( 'as' )
            // InternalMegal.g:1462:1: 'as'
            {
             before(grammarAccess.getMegalEntityTypeAccess().getAsKeyword_2_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityTypeAccess().getAsKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_1__0__Impl"


    // $ANTLR start "rule__MegalEntityType__Group_2_1__1"
    // InternalMegal.g:1475:1: rule__MegalEntityType__Group_2_1__1 : rule__MegalEntityType__Group_2_1__1__Impl ;
    public final void rule__MegalEntityType__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1479:1: ( rule__MegalEntityType__Group_2_1__1__Impl )
            // InternalMegal.g:1480:2: rule__MegalEntityType__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntityType__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_1__1"


    // $ANTLR start "rule__MegalEntityType__Group_2_1__1__Impl"
    // InternalMegal.g:1486:1: rule__MegalEntityType__Group_2_1__1__Impl : ( 'entity' ) ;
    public final void rule__MegalEntityType__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1490:1: ( ( 'entity' ) )
            // InternalMegal.g:1491:1: ( 'entity' )
            {
            // InternalMegal.g:1491:1: ( 'entity' )
            // InternalMegal.g:1492:1: 'entity'
            {
             before(grammarAccess.getMegalEntityTypeAccess().getEntityKeyword_2_1_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityTypeAccess().getEntityKeyword_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__Group_2_1__1__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__0"
    // InternalMegal.g:1509:1: rule__MegalRelationshipType__Group__0 : rule__MegalRelationshipType__Group__0__Impl rule__MegalRelationshipType__Group__1 ;
    public final void rule__MegalRelationshipType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1513:1: ( rule__MegalRelationshipType__Group__0__Impl rule__MegalRelationshipType__Group__1 )
            // InternalMegal.g:1514:2: rule__MegalRelationshipType__Group__0__Impl rule__MegalRelationshipType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MegalRelationshipType__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__0"


    // $ANTLR start "rule__MegalRelationshipType__Group__0__Impl"
    // InternalMegal.g:1521:1: rule__MegalRelationshipType__Group__0__Impl : ( ( rule__MegalRelationshipType__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalRelationshipType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1525:1: ( ( ( rule__MegalRelationshipType__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:1526:1: ( ( rule__MegalRelationshipType__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:1526:1: ( ( rule__MegalRelationshipType__AnnotationsAssignment_0 )* )
            // InternalMegal.g:1527:1: ( rule__MegalRelationshipType__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:1528:1: ( rule__MegalRelationshipType__AnnotationsAssignment_0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ANN_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMegal.g:1528:2: rule__MegalRelationshipType__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalRelationshipType__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getMegalRelationshipTypeAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__0__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__1"
    // InternalMegal.g:1538:1: rule__MegalRelationshipType__Group__1 : rule__MegalRelationshipType__Group__1__Impl rule__MegalRelationshipType__Group__2 ;
    public final void rule__MegalRelationshipType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1542:1: ( rule__MegalRelationshipType__Group__1__Impl rule__MegalRelationshipType__Group__2 )
            // InternalMegal.g:1543:2: rule__MegalRelationshipType__Group__1__Impl rule__MegalRelationshipType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__MegalRelationshipType__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__1"


    // $ANTLR start "rule__MegalRelationshipType__Group__1__Impl"
    // InternalMegal.g:1550:1: rule__MegalRelationshipType__Group__1__Impl : ( ( rule__MegalRelationshipType__NameAssignment_1 ) ) ;
    public final void rule__MegalRelationshipType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1554:1: ( ( ( rule__MegalRelationshipType__NameAssignment_1 ) ) )
            // InternalMegal.g:1555:1: ( ( rule__MegalRelationshipType__NameAssignment_1 ) )
            {
            // InternalMegal.g:1555:1: ( ( rule__MegalRelationshipType__NameAssignment_1 ) )
            // InternalMegal.g:1556:1: ( rule__MegalRelationshipType__NameAssignment_1 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getNameAssignment_1()); 
            // InternalMegal.g:1557:1: ( rule__MegalRelationshipType__NameAssignment_1 )
            // InternalMegal.g:1557:2: rule__MegalRelationshipType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__1__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__2"
    // InternalMegal.g:1567:1: rule__MegalRelationshipType__Group__2 : rule__MegalRelationshipType__Group__2__Impl rule__MegalRelationshipType__Group__3 ;
    public final void rule__MegalRelationshipType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1571:1: ( rule__MegalRelationshipType__Group__2__Impl rule__MegalRelationshipType__Group__3 )
            // InternalMegal.g:1572:2: rule__MegalRelationshipType__Group__2__Impl rule__MegalRelationshipType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationshipType__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__2"


    // $ANTLR start "rule__MegalRelationshipType__Group__2__Impl"
    // InternalMegal.g:1579:1: rule__MegalRelationshipType__Group__2__Impl : ( '<' ) ;
    public final void rule__MegalRelationshipType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1583:1: ( ( '<' ) )
            // InternalMegal.g:1584:1: ( '<' )
            {
            // InternalMegal.g:1584:1: ( '<' )
            // InternalMegal.g:1585:1: '<'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLessThanSignKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLessThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__2__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__3"
    // InternalMegal.g:1598:1: rule__MegalRelationshipType__Group__3 : rule__MegalRelationshipType__Group__3__Impl rule__MegalRelationshipType__Group__4 ;
    public final void rule__MegalRelationshipType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1602:1: ( rule__MegalRelationshipType__Group__3__Impl rule__MegalRelationshipType__Group__4 )
            // InternalMegal.g:1603:2: rule__MegalRelationshipType__Group__3__Impl rule__MegalRelationshipType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MegalRelationshipType__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__3"


    // $ANTLR start "rule__MegalRelationshipType__Group__3__Impl"
    // InternalMegal.g:1610:1: rule__MegalRelationshipType__Group__3__Impl : ( ( rule__MegalRelationshipType__LeftAssignment_3 ) ) ;
    public final void rule__MegalRelationshipType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1614:1: ( ( ( rule__MegalRelationshipType__LeftAssignment_3 ) ) )
            // InternalMegal.g:1615:1: ( ( rule__MegalRelationshipType__LeftAssignment_3 ) )
            {
            // InternalMegal.g:1615:1: ( ( rule__MegalRelationshipType__LeftAssignment_3 ) )
            // InternalMegal.g:1616:1: ( rule__MegalRelationshipType__LeftAssignment_3 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftAssignment_3()); 
            // InternalMegal.g:1617:1: ( rule__MegalRelationshipType__LeftAssignment_3 )
            // InternalMegal.g:1617:2: rule__MegalRelationshipType__LeftAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__LeftAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__3__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__4"
    // InternalMegal.g:1627:1: rule__MegalRelationshipType__Group__4 : rule__MegalRelationshipType__Group__4__Impl rule__MegalRelationshipType__Group__5 ;
    public final void rule__MegalRelationshipType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1631:1: ( rule__MegalRelationshipType__Group__4__Impl rule__MegalRelationshipType__Group__5 )
            // InternalMegal.g:1632:2: rule__MegalRelationshipType__Group__4__Impl rule__MegalRelationshipType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MegalRelationshipType__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__4"


    // $ANTLR start "rule__MegalRelationshipType__Group__4__Impl"
    // InternalMegal.g:1639:1: rule__MegalRelationshipType__Group__4__Impl : ( ( rule__MegalRelationshipType__Group_4__0 )? ) ;
    public final void rule__MegalRelationshipType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1643:1: ( ( ( rule__MegalRelationshipType__Group_4__0 )? ) )
            // InternalMegal.g:1644:1: ( ( rule__MegalRelationshipType__Group_4__0 )? )
            {
            // InternalMegal.g:1644:1: ( ( rule__MegalRelationshipType__Group_4__0 )? )
            // InternalMegal.g:1645:1: ( rule__MegalRelationshipType__Group_4__0 )?
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getGroup_4()); 
            // InternalMegal.g:1646:1: ( rule__MegalRelationshipType__Group_4__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMegal.g:1646:2: rule__MegalRelationshipType__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__4__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__5"
    // InternalMegal.g:1656:1: rule__MegalRelationshipType__Group__5 : rule__MegalRelationshipType__Group__5__Impl rule__MegalRelationshipType__Group__6 ;
    public final void rule__MegalRelationshipType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1660:1: ( rule__MegalRelationshipType__Group__5__Impl rule__MegalRelationshipType__Group__6 )
            // InternalMegal.g:1661:2: rule__MegalRelationshipType__Group__5__Impl rule__MegalRelationshipType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MegalRelationshipType__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__5"


    // $ANTLR start "rule__MegalRelationshipType__Group__5__Impl"
    // InternalMegal.g:1668:1: rule__MegalRelationshipType__Group__5__Impl : ( ( rule__MegalRelationshipType__Alternatives_5 )? ) ;
    public final void rule__MegalRelationshipType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1672:1: ( ( ( rule__MegalRelationshipType__Alternatives_5 )? ) )
            // InternalMegal.g:1673:1: ( ( rule__MegalRelationshipType__Alternatives_5 )? )
            {
            // InternalMegal.g:1673:1: ( ( rule__MegalRelationshipType__Alternatives_5 )? )
            // InternalMegal.g:1674:1: ( rule__MegalRelationshipType__Alternatives_5 )?
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getAlternatives_5()); 
            // InternalMegal.g:1675:1: ( rule__MegalRelationshipType__Alternatives_5 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=29 && LA15_0<=30)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMegal.g:1675:2: rule__MegalRelationshipType__Alternatives_5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__Alternatives_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__5__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__6"
    // InternalMegal.g:1685:1: rule__MegalRelationshipType__Group__6 : rule__MegalRelationshipType__Group__6__Impl rule__MegalRelationshipType__Group__7 ;
    public final void rule__MegalRelationshipType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1689:1: ( rule__MegalRelationshipType__Group__6__Impl rule__MegalRelationshipType__Group__7 )
            // InternalMegal.g:1690:2: rule__MegalRelationshipType__Group__6__Impl rule__MegalRelationshipType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationshipType__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__6"


    // $ANTLR start "rule__MegalRelationshipType__Group__6__Impl"
    // InternalMegal.g:1697:1: rule__MegalRelationshipType__Group__6__Impl : ( '*' ) ;
    public final void rule__MegalRelationshipType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1701:1: ( ( '*' ) )
            // InternalMegal.g:1702:1: ( '*' )
            {
            // InternalMegal.g:1702:1: ( '*' )
            // InternalMegal.g:1703:1: '*'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getAsteriskKeyword_6()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getAsteriskKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__6__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__7"
    // InternalMegal.g:1716:1: rule__MegalRelationshipType__Group__7 : rule__MegalRelationshipType__Group__7__Impl rule__MegalRelationshipType__Group__8 ;
    public final void rule__MegalRelationshipType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1720:1: ( rule__MegalRelationshipType__Group__7__Impl rule__MegalRelationshipType__Group__8 )
            // InternalMegal.g:1721:2: rule__MegalRelationshipType__Group__7__Impl rule__MegalRelationshipType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__MegalRelationshipType__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__7"


    // $ANTLR start "rule__MegalRelationshipType__Group__7__Impl"
    // InternalMegal.g:1728:1: rule__MegalRelationshipType__Group__7__Impl : ( ( rule__MegalRelationshipType__RightAssignment_7 ) ) ;
    public final void rule__MegalRelationshipType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1732:1: ( ( ( rule__MegalRelationshipType__RightAssignment_7 ) ) )
            // InternalMegal.g:1733:1: ( ( rule__MegalRelationshipType__RightAssignment_7 ) )
            {
            // InternalMegal.g:1733:1: ( ( rule__MegalRelationshipType__RightAssignment_7 ) )
            // InternalMegal.g:1734:1: ( rule__MegalRelationshipType__RightAssignment_7 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightAssignment_7()); 
            // InternalMegal.g:1735:1: ( rule__MegalRelationshipType__RightAssignment_7 )
            // InternalMegal.g:1735:2: rule__MegalRelationshipType__RightAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__RightAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__7__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__8"
    // InternalMegal.g:1745:1: rule__MegalRelationshipType__Group__8 : rule__MegalRelationshipType__Group__8__Impl rule__MegalRelationshipType__Group__9 ;
    public final void rule__MegalRelationshipType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1749:1: ( rule__MegalRelationshipType__Group__8__Impl rule__MegalRelationshipType__Group__9 )
            // InternalMegal.g:1750:2: rule__MegalRelationshipType__Group__8__Impl rule__MegalRelationshipType__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__MegalRelationshipType__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__8"


    // $ANTLR start "rule__MegalRelationshipType__Group__8__Impl"
    // InternalMegal.g:1757:1: rule__MegalRelationshipType__Group__8__Impl : ( ( rule__MegalRelationshipType__Group_8__0 )? ) ;
    public final void rule__MegalRelationshipType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1761:1: ( ( ( rule__MegalRelationshipType__Group_8__0 )? ) )
            // InternalMegal.g:1762:1: ( ( rule__MegalRelationshipType__Group_8__0 )? )
            {
            // InternalMegal.g:1762:1: ( ( rule__MegalRelationshipType__Group_8__0 )? )
            // InternalMegal.g:1763:1: ( rule__MegalRelationshipType__Group_8__0 )?
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getGroup_8()); 
            // InternalMegal.g:1764:1: ( rule__MegalRelationshipType__Group_8__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMegal.g:1764:2: rule__MegalRelationshipType__Group_8__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__8__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group__9"
    // InternalMegal.g:1774:1: rule__MegalRelationshipType__Group__9 : rule__MegalRelationshipType__Group__9__Impl ;
    public final void rule__MegalRelationshipType__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1778:1: ( rule__MegalRelationshipType__Group__9__Impl )
            // InternalMegal.g:1779:2: rule__MegalRelationshipType__Group__9__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__9"


    // $ANTLR start "rule__MegalRelationshipType__Group__9__Impl"
    // InternalMegal.g:1785:1: rule__MegalRelationshipType__Group__9__Impl : ( ( rule__MegalRelationshipType__Alternatives_9 )? ) ;
    public final void rule__MegalRelationshipType__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1789:1: ( ( ( rule__MegalRelationshipType__Alternatives_9 )? ) )
            // InternalMegal.g:1790:1: ( ( rule__MegalRelationshipType__Alternatives_9 )? )
            {
            // InternalMegal.g:1790:1: ( ( rule__MegalRelationshipType__Alternatives_9 )? )
            // InternalMegal.g:1791:1: ( rule__MegalRelationshipType__Alternatives_9 )?
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getAlternatives_9()); 
            // InternalMegal.g:1792:1: ( rule__MegalRelationshipType__Alternatives_9 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=29 && LA17_0<=30)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMegal.g:1792:2: rule__MegalRelationshipType__Alternatives_9
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalRelationshipType__Alternatives_9();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getAlternatives_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group__9__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__0"
    // InternalMegal.g:1822:1: rule__MegalRelationshipType__Group_4__0 : rule__MegalRelationshipType__Group_4__0__Impl rule__MegalRelationshipType__Group_4__1 ;
    public final void rule__MegalRelationshipType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1826:1: ( rule__MegalRelationshipType__Group_4__0__Impl rule__MegalRelationshipType__Group_4__1 )
            // InternalMegal.g:1827:2: rule__MegalRelationshipType__Group_4__0__Impl rule__MegalRelationshipType__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationshipType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__0"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__0__Impl"
    // InternalMegal.g:1834:1: rule__MegalRelationshipType__Group_4__0__Impl : ( '[' ) ;
    public final void rule__MegalRelationshipType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1838:1: ( ( '[' ) )
            // InternalMegal.g:1839:1: ( '[' )
            {
            // InternalMegal.g:1839:1: ( '[' )
            // InternalMegal.g:1840:1: '['
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftSquareBracketKeyword_4_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__0__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__1"
    // InternalMegal.g:1853:1: rule__MegalRelationshipType__Group_4__1 : rule__MegalRelationshipType__Group_4__1__Impl rule__MegalRelationshipType__Group_4__2 ;
    public final void rule__MegalRelationshipType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1857:1: ( rule__MegalRelationshipType__Group_4__1__Impl rule__MegalRelationshipType__Group_4__2 )
            // InternalMegal.g:1858:2: rule__MegalRelationshipType__Group_4__1__Impl rule__MegalRelationshipType__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MegalRelationshipType__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__1"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__1__Impl"
    // InternalMegal.g:1865:1: rule__MegalRelationshipType__Group_4__1__Impl : ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_1 ) ) ;
    public final void rule__MegalRelationshipType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1869:1: ( ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_1 ) ) )
            // InternalMegal.g:1870:1: ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_1 ) )
            {
            // InternalMegal.g:1870:1: ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_1 ) )
            // InternalMegal.g:1871:1: ( rule__MegalRelationshipType__LeftParamsAssignment_4_1 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsAssignment_4_1()); 
            // InternalMegal.g:1872:1: ( rule__MegalRelationshipType__LeftParamsAssignment_4_1 )
            // InternalMegal.g:1872:2: rule__MegalRelationshipType__LeftParamsAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__LeftParamsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__1__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__2"
    // InternalMegal.g:1882:1: rule__MegalRelationshipType__Group_4__2 : rule__MegalRelationshipType__Group_4__2__Impl rule__MegalRelationshipType__Group_4__3 ;
    public final void rule__MegalRelationshipType__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1886:1: ( rule__MegalRelationshipType__Group_4__2__Impl rule__MegalRelationshipType__Group_4__3 )
            // InternalMegal.g:1887:2: rule__MegalRelationshipType__Group_4__2__Impl rule__MegalRelationshipType__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MegalRelationshipType__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__2"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__2__Impl"
    // InternalMegal.g:1894:1: rule__MegalRelationshipType__Group_4__2__Impl : ( ( rule__MegalRelationshipType__Group_4_2__0 )* ) ;
    public final void rule__MegalRelationshipType__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1898:1: ( ( ( rule__MegalRelationshipType__Group_4_2__0 )* ) )
            // InternalMegal.g:1899:1: ( ( rule__MegalRelationshipType__Group_4_2__0 )* )
            {
            // InternalMegal.g:1899:1: ( ( rule__MegalRelationshipType__Group_4_2__0 )* )
            // InternalMegal.g:1900:1: ( rule__MegalRelationshipType__Group_4_2__0 )*
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getGroup_4_2()); 
            // InternalMegal.g:1901:1: ( rule__MegalRelationshipType__Group_4_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMegal.g:1901:2: rule__MegalRelationshipType__Group_4_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__MegalRelationshipType__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getMegalRelationshipTypeAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__2__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__3"
    // InternalMegal.g:1911:1: rule__MegalRelationshipType__Group_4__3 : rule__MegalRelationshipType__Group_4__3__Impl ;
    public final void rule__MegalRelationshipType__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1915:1: ( rule__MegalRelationshipType__Group_4__3__Impl )
            // InternalMegal.g:1916:2: rule__MegalRelationshipType__Group_4__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__3"


    // $ANTLR start "rule__MegalRelationshipType__Group_4__3__Impl"
    // InternalMegal.g:1922:1: rule__MegalRelationshipType__Group_4__3__Impl : ( ']' ) ;
    public final void rule__MegalRelationshipType__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1926:1: ( ( ']' ) )
            // InternalMegal.g:1927:1: ( ']' )
            {
            // InternalMegal.g:1927:1: ( ']' )
            // InternalMegal.g:1928:1: ']'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightSquareBracketKeyword_4_3()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightSquareBracketKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4__3__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_4_2__0"
    // InternalMegal.g:1949:1: rule__MegalRelationshipType__Group_4_2__0 : rule__MegalRelationshipType__Group_4_2__0__Impl rule__MegalRelationshipType__Group_4_2__1 ;
    public final void rule__MegalRelationshipType__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1953:1: ( rule__MegalRelationshipType__Group_4_2__0__Impl rule__MegalRelationshipType__Group_4_2__1 )
            // InternalMegal.g:1954:2: rule__MegalRelationshipType__Group_4_2__0__Impl rule__MegalRelationshipType__Group_4_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationshipType__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4_2__0"


    // $ANTLR start "rule__MegalRelationshipType__Group_4_2__0__Impl"
    // InternalMegal.g:1961:1: rule__MegalRelationshipType__Group_4_2__0__Impl : ( '->' ) ;
    public final void rule__MegalRelationshipType__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1965:1: ( ( '->' ) )
            // InternalMegal.g:1966:1: ( '->' )
            {
            // InternalMegal.g:1966:1: ( '->' )
            // InternalMegal.g:1967:1: '->'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4_2__0__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_4_2__1"
    // InternalMegal.g:1980:1: rule__MegalRelationshipType__Group_4_2__1 : rule__MegalRelationshipType__Group_4_2__1__Impl ;
    public final void rule__MegalRelationshipType__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1984:1: ( rule__MegalRelationshipType__Group_4_2__1__Impl )
            // InternalMegal.g:1985:2: rule__MegalRelationshipType__Group_4_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4_2__1"


    // $ANTLR start "rule__MegalRelationshipType__Group_4_2__1__Impl"
    // InternalMegal.g:1991:1: rule__MegalRelationshipType__Group_4_2__1__Impl : ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 ) ) ;
    public final void rule__MegalRelationshipType__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:1995:1: ( ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 ) ) )
            // InternalMegal.g:1996:1: ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 ) )
            {
            // InternalMegal.g:1996:1: ( ( rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 ) )
            // InternalMegal.g:1997:1: ( rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsAssignment_4_2_1()); 
            // InternalMegal.g:1998:1: ( rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 )
            // InternalMegal.g:1998:2: rule__MegalRelationshipType__LeftParamsAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__LeftParamsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_4_2__1__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__0"
    // InternalMegal.g:2012:1: rule__MegalRelationshipType__Group_8__0 : rule__MegalRelationshipType__Group_8__0__Impl rule__MegalRelationshipType__Group_8__1 ;
    public final void rule__MegalRelationshipType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2016:1: ( rule__MegalRelationshipType__Group_8__0__Impl rule__MegalRelationshipType__Group_8__1 )
            // InternalMegal.g:2017:2: rule__MegalRelationshipType__Group_8__0__Impl rule__MegalRelationshipType__Group_8__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationshipType__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__0"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__0__Impl"
    // InternalMegal.g:2024:1: rule__MegalRelationshipType__Group_8__0__Impl : ( '[' ) ;
    public final void rule__MegalRelationshipType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2028:1: ( ( '[' ) )
            // InternalMegal.g:2029:1: ( '[' )
            {
            // InternalMegal.g:2029:1: ( '[' )
            // InternalMegal.g:2030:1: '['
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftSquareBracketKeyword_8_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftSquareBracketKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__0__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__1"
    // InternalMegal.g:2043:1: rule__MegalRelationshipType__Group_8__1 : rule__MegalRelationshipType__Group_8__1__Impl rule__MegalRelationshipType__Group_8__2 ;
    public final void rule__MegalRelationshipType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2047:1: ( rule__MegalRelationshipType__Group_8__1__Impl rule__MegalRelationshipType__Group_8__2 )
            // InternalMegal.g:2048:2: rule__MegalRelationshipType__Group_8__1__Impl rule__MegalRelationshipType__Group_8__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MegalRelationshipType__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__1"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__1__Impl"
    // InternalMegal.g:2055:1: rule__MegalRelationshipType__Group_8__1__Impl : ( ( rule__MegalRelationshipType__RightParamsAssignment_8_1 ) ) ;
    public final void rule__MegalRelationshipType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2059:1: ( ( ( rule__MegalRelationshipType__RightParamsAssignment_8_1 ) ) )
            // InternalMegal.g:2060:1: ( ( rule__MegalRelationshipType__RightParamsAssignment_8_1 ) )
            {
            // InternalMegal.g:2060:1: ( ( rule__MegalRelationshipType__RightParamsAssignment_8_1 ) )
            // InternalMegal.g:2061:1: ( rule__MegalRelationshipType__RightParamsAssignment_8_1 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsAssignment_8_1()); 
            // InternalMegal.g:2062:1: ( rule__MegalRelationshipType__RightParamsAssignment_8_1 )
            // InternalMegal.g:2062:2: rule__MegalRelationshipType__RightParamsAssignment_8_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__RightParamsAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__1__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__2"
    // InternalMegal.g:2072:1: rule__MegalRelationshipType__Group_8__2 : rule__MegalRelationshipType__Group_8__2__Impl rule__MegalRelationshipType__Group_8__3 ;
    public final void rule__MegalRelationshipType__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2076:1: ( rule__MegalRelationshipType__Group_8__2__Impl rule__MegalRelationshipType__Group_8__3 )
            // InternalMegal.g:2077:2: rule__MegalRelationshipType__Group_8__2__Impl rule__MegalRelationshipType__Group_8__3
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MegalRelationshipType__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__2"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__2__Impl"
    // InternalMegal.g:2084:1: rule__MegalRelationshipType__Group_8__2__Impl : ( ( rule__MegalRelationshipType__Group_8_2__0 )* ) ;
    public final void rule__MegalRelationshipType__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2088:1: ( ( ( rule__MegalRelationshipType__Group_8_2__0 )* ) )
            // InternalMegal.g:2089:1: ( ( rule__MegalRelationshipType__Group_8_2__0 )* )
            {
            // InternalMegal.g:2089:1: ( ( rule__MegalRelationshipType__Group_8_2__0 )* )
            // InternalMegal.g:2090:1: ( rule__MegalRelationshipType__Group_8_2__0 )*
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getGroup_8_2()); 
            // InternalMegal.g:2091:1: ( rule__MegalRelationshipType__Group_8_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==23) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMegal.g:2091:2: rule__MegalRelationshipType__Group_8_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__MegalRelationshipType__Group_8_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getMegalRelationshipTypeAccess().getGroup_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__2__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__3"
    // InternalMegal.g:2101:1: rule__MegalRelationshipType__Group_8__3 : rule__MegalRelationshipType__Group_8__3__Impl ;
    public final void rule__MegalRelationshipType__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2105:1: ( rule__MegalRelationshipType__Group_8__3__Impl )
            // InternalMegal.g:2106:2: rule__MegalRelationshipType__Group_8__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__3"


    // $ANTLR start "rule__MegalRelationshipType__Group_8__3__Impl"
    // InternalMegal.g:2112:1: rule__MegalRelationshipType__Group_8__3__Impl : ( ']' ) ;
    public final void rule__MegalRelationshipType__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2116:1: ( ( ']' ) )
            // InternalMegal.g:2117:1: ( ']' )
            {
            // InternalMegal.g:2117:1: ( ']' )
            // InternalMegal.g:2118:1: ']'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightSquareBracketKeyword_8_3()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightSquareBracketKeyword_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8__3__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_8_2__0"
    // InternalMegal.g:2139:1: rule__MegalRelationshipType__Group_8_2__0 : rule__MegalRelationshipType__Group_8_2__0__Impl rule__MegalRelationshipType__Group_8_2__1 ;
    public final void rule__MegalRelationshipType__Group_8_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2143:1: ( rule__MegalRelationshipType__Group_8_2__0__Impl rule__MegalRelationshipType__Group_8_2__1 )
            // InternalMegal.g:2144:2: rule__MegalRelationshipType__Group_8_2__0__Impl rule__MegalRelationshipType__Group_8_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationshipType__Group_8_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_8_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8_2__0"


    // $ANTLR start "rule__MegalRelationshipType__Group_8_2__0__Impl"
    // InternalMegal.g:2151:1: rule__MegalRelationshipType__Group_8_2__0__Impl : ( '->' ) ;
    public final void rule__MegalRelationshipType__Group_8_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2155:1: ( ( '->' ) )
            // InternalMegal.g:2156:1: ( '->' )
            {
            // InternalMegal.g:2156:1: ( '->' )
            // InternalMegal.g:2157:1: '->'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getHyphenMinusGreaterThanSignKeyword_8_2_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getHyphenMinusGreaterThanSignKeyword_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8_2__0__Impl"


    // $ANTLR start "rule__MegalRelationshipType__Group_8_2__1"
    // InternalMegal.g:2170:1: rule__MegalRelationshipType__Group_8_2__1 : rule__MegalRelationshipType__Group_8_2__1__Impl ;
    public final void rule__MegalRelationshipType__Group_8_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2174:1: ( rule__MegalRelationshipType__Group_8_2__1__Impl )
            // InternalMegal.g:2175:2: rule__MegalRelationshipType__Group_8_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__Group_8_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8_2__1"


    // $ANTLR start "rule__MegalRelationshipType__Group_8_2__1__Impl"
    // InternalMegal.g:2181:1: rule__MegalRelationshipType__Group_8_2__1__Impl : ( ( rule__MegalRelationshipType__RightParamsAssignment_8_2_1 ) ) ;
    public final void rule__MegalRelationshipType__Group_8_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2185:1: ( ( ( rule__MegalRelationshipType__RightParamsAssignment_8_2_1 ) ) )
            // InternalMegal.g:2186:1: ( ( rule__MegalRelationshipType__RightParamsAssignment_8_2_1 ) )
            {
            // InternalMegal.g:2186:1: ( ( rule__MegalRelationshipType__RightParamsAssignment_8_2_1 ) )
            // InternalMegal.g:2187:1: ( rule__MegalRelationshipType__RightParamsAssignment_8_2_1 )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsAssignment_8_2_1()); 
            // InternalMegal.g:2188:1: ( rule__MegalRelationshipType__RightParamsAssignment_8_2_1 )
            // InternalMegal.g:2188:2: rule__MegalRelationshipType__RightParamsAssignment_8_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationshipType__RightParamsAssignment_8_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsAssignment_8_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__Group_8_2__1__Impl"


    // $ANTLR start "rule__MegalEntity__Group__0"
    // InternalMegal.g:2202:1: rule__MegalEntity__Group__0 : rule__MegalEntity__Group__0__Impl rule__MegalEntity__Group__1 ;
    public final void rule__MegalEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2206:1: ( rule__MegalEntity__Group__0__Impl rule__MegalEntity__Group__1 )
            // InternalMegal.g:2207:2: rule__MegalEntity__Group__0__Impl rule__MegalEntity__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MegalEntity__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__0"


    // $ANTLR start "rule__MegalEntity__Group__0__Impl"
    // InternalMegal.g:2214:1: rule__MegalEntity__Group__0__Impl : ( ( rule__MegalEntity__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2218:1: ( ( ( rule__MegalEntity__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:2219:1: ( ( rule__MegalEntity__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:2219:1: ( ( rule__MegalEntity__AnnotationsAssignment_0 )* )
            // InternalMegal.g:2220:1: ( rule__MegalEntity__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalEntityAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:2221:1: ( rule__MegalEntity__AnnotationsAssignment_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ANN_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMegal.g:2221:2: rule__MegalEntity__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalEntity__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMegalEntityAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__0__Impl"


    // $ANTLR start "rule__MegalEntity__Group__1"
    // InternalMegal.g:2231:1: rule__MegalEntity__Group__1 : rule__MegalEntity__Group__1__Impl rule__MegalEntity__Group__2 ;
    public final void rule__MegalEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2235:1: ( rule__MegalEntity__Group__1__Impl rule__MegalEntity__Group__2 )
            // InternalMegal.g:2236:2: rule__MegalEntity__Group__1__Impl rule__MegalEntity__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__MegalEntity__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__1"


    // $ANTLR start "rule__MegalEntity__Group__1__Impl"
    // InternalMegal.g:2243:1: rule__MegalEntity__Group__1__Impl : ( ( rule__MegalEntity__NameAssignment_1 ) ) ;
    public final void rule__MegalEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2247:1: ( ( ( rule__MegalEntity__NameAssignment_1 ) ) )
            // InternalMegal.g:2248:1: ( ( rule__MegalEntity__NameAssignment_1 ) )
            {
            // InternalMegal.g:2248:1: ( ( rule__MegalEntity__NameAssignment_1 ) )
            // InternalMegal.g:2249:1: ( rule__MegalEntity__NameAssignment_1 )
            {
             before(grammarAccess.getMegalEntityAccess().getNameAssignment_1()); 
            // InternalMegal.g:2250:1: ( rule__MegalEntity__NameAssignment_1 )
            // InternalMegal.g:2250:2: rule__MegalEntity__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__1__Impl"


    // $ANTLR start "rule__MegalEntity__Group__2"
    // InternalMegal.g:2260:1: rule__MegalEntity__Group__2 : rule__MegalEntity__Group__2__Impl rule__MegalEntity__Group__3 ;
    public final void rule__MegalEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2264:1: ( rule__MegalEntity__Group__2__Impl rule__MegalEntity__Group__3 )
            // InternalMegal.g:2265:2: rule__MegalEntity__Group__2__Impl rule__MegalEntity__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalEntity__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__2"


    // $ANTLR start "rule__MegalEntity__Group__2__Impl"
    // InternalMegal.g:2272:1: rule__MegalEntity__Group__2__Impl : ( ':' ) ;
    public final void rule__MegalEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2276:1: ( ( ':' ) )
            // InternalMegal.g:2277:1: ( ':' )
            {
            // InternalMegal.g:2277:1: ( ':' )
            // InternalMegal.g:2278:1: ':'
            {
             before(grammarAccess.getMegalEntityAccess().getColonKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__2__Impl"


    // $ANTLR start "rule__MegalEntity__Group__3"
    // InternalMegal.g:2291:1: rule__MegalEntity__Group__3 : rule__MegalEntity__Group__3__Impl rule__MegalEntity__Group__4 ;
    public final void rule__MegalEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2295:1: ( rule__MegalEntity__Group__3__Impl rule__MegalEntity__Group__4 )
            // InternalMegal.g:2296:2: rule__MegalEntity__Group__3__Impl rule__MegalEntity__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__MegalEntity__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__3"


    // $ANTLR start "rule__MegalEntity__Group__3__Impl"
    // InternalMegal.g:2303:1: rule__MegalEntity__Group__3__Impl : ( ( rule__MegalEntity__TypeAssignment_3 ) ) ;
    public final void rule__MegalEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2307:1: ( ( ( rule__MegalEntity__TypeAssignment_3 ) ) )
            // InternalMegal.g:2308:1: ( ( rule__MegalEntity__TypeAssignment_3 ) )
            {
            // InternalMegal.g:2308:1: ( ( rule__MegalEntity__TypeAssignment_3 ) )
            // InternalMegal.g:2309:1: ( rule__MegalEntity__TypeAssignment_3 )
            {
             before(grammarAccess.getMegalEntityAccess().getTypeAssignment_3()); 
            // InternalMegal.g:2310:1: ( rule__MegalEntity__TypeAssignment_3 )
            // InternalMegal.g:2310:2: rule__MegalEntity__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__3__Impl"


    // $ANTLR start "rule__MegalEntity__Group__4"
    // InternalMegal.g:2320:1: rule__MegalEntity__Group__4 : rule__MegalEntity__Group__4__Impl rule__MegalEntity__Group__5 ;
    public final void rule__MegalEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2324:1: ( rule__MegalEntity__Group__4__Impl rule__MegalEntity__Group__5 )
            // InternalMegal.g:2325:2: rule__MegalEntity__Group__4__Impl rule__MegalEntity__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__MegalEntity__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__4"


    // $ANTLR start "rule__MegalEntity__Group__4__Impl"
    // InternalMegal.g:2332:1: rule__MegalEntity__Group__4__Impl : ( ( rule__MegalEntity__Group_4__0 )? ) ;
    public final void rule__MegalEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2336:1: ( ( ( rule__MegalEntity__Group_4__0 )? ) )
            // InternalMegal.g:2337:1: ( ( rule__MegalEntity__Group_4__0 )? )
            {
            // InternalMegal.g:2337:1: ( ( rule__MegalEntity__Group_4__0 )? )
            // InternalMegal.g:2338:1: ( rule__MegalEntity__Group_4__0 )?
            {
             before(grammarAccess.getMegalEntityAccess().getGroup_4()); 
            // InternalMegal.g:2339:1: ( rule__MegalEntity__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==21) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMegal.g:2339:2: rule__MegalEntity__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalEntity__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalEntityAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__4__Impl"


    // $ANTLR start "rule__MegalEntity__Group__5"
    // InternalMegal.g:2349:1: rule__MegalEntity__Group__5 : rule__MegalEntity__Group__5__Impl ;
    public final void rule__MegalEntity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2353:1: ( rule__MegalEntity__Group__5__Impl )
            // InternalMegal.g:2354:2: rule__MegalEntity__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__5"


    // $ANTLR start "rule__MegalEntity__Group__5__Impl"
    // InternalMegal.g:2360:1: rule__MegalEntity__Group__5__Impl : ( ( rule__MegalEntity__ManyAssignment_5 )? ) ;
    public final void rule__MegalEntity__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2364:1: ( ( ( rule__MegalEntity__ManyAssignment_5 )? ) )
            // InternalMegal.g:2365:1: ( ( rule__MegalEntity__ManyAssignment_5 )? )
            {
            // InternalMegal.g:2365:1: ( ( rule__MegalEntity__ManyAssignment_5 )? )
            // InternalMegal.g:2366:1: ( rule__MegalEntity__ManyAssignment_5 )?
            {
             before(grammarAccess.getMegalEntityAccess().getManyAssignment_5()); 
            // InternalMegal.g:2367:1: ( rule__MegalEntity__ManyAssignment_5 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMegal.g:2367:2: rule__MegalEntity__ManyAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MegalEntity__ManyAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMegalEntityAccess().getManyAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group__5__Impl"


    // $ANTLR start "rule__MegalEntity__Group_4__0"
    // InternalMegal.g:2389:1: rule__MegalEntity__Group_4__0 : rule__MegalEntity__Group_4__0__Impl rule__MegalEntity__Group_4__1 ;
    public final void rule__MegalEntity__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2393:1: ( rule__MegalEntity__Group_4__0__Impl rule__MegalEntity__Group_4__1 )
            // InternalMegal.g:2394:2: rule__MegalEntity__Group_4__0__Impl rule__MegalEntity__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalEntity__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__0"


    // $ANTLR start "rule__MegalEntity__Group_4__0__Impl"
    // InternalMegal.g:2401:1: rule__MegalEntity__Group_4__0__Impl : ( '[' ) ;
    public final void rule__MegalEntity__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2405:1: ( ( '[' ) )
            // InternalMegal.g:2406:1: ( '[' )
            {
            // InternalMegal.g:2406:1: ( '[' )
            // InternalMegal.g:2407:1: '['
            {
             before(grammarAccess.getMegalEntityAccess().getLeftSquareBracketKeyword_4_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getLeftSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__0__Impl"


    // $ANTLR start "rule__MegalEntity__Group_4__1"
    // InternalMegal.g:2420:1: rule__MegalEntity__Group_4__1 : rule__MegalEntity__Group_4__1__Impl rule__MegalEntity__Group_4__2 ;
    public final void rule__MegalEntity__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2424:1: ( rule__MegalEntity__Group_4__1__Impl rule__MegalEntity__Group_4__2 )
            // InternalMegal.g:2425:2: rule__MegalEntity__Group_4__1__Impl rule__MegalEntity__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MegalEntity__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__1"


    // $ANTLR start "rule__MegalEntity__Group_4__1__Impl"
    // InternalMegal.g:2432:1: rule__MegalEntity__Group_4__1__Impl : ( ( rule__MegalEntity__ParamsAssignment_4_1 ) ) ;
    public final void rule__MegalEntity__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2436:1: ( ( ( rule__MegalEntity__ParamsAssignment_4_1 ) ) )
            // InternalMegal.g:2437:1: ( ( rule__MegalEntity__ParamsAssignment_4_1 ) )
            {
            // InternalMegal.g:2437:1: ( ( rule__MegalEntity__ParamsAssignment_4_1 ) )
            // InternalMegal.g:2438:1: ( rule__MegalEntity__ParamsAssignment_4_1 )
            {
             before(grammarAccess.getMegalEntityAccess().getParamsAssignment_4_1()); 
            // InternalMegal.g:2439:1: ( rule__MegalEntity__ParamsAssignment_4_1 )
            // InternalMegal.g:2439:2: rule__MegalEntity__ParamsAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__ParamsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityAccess().getParamsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__1__Impl"


    // $ANTLR start "rule__MegalEntity__Group_4__2"
    // InternalMegal.g:2449:1: rule__MegalEntity__Group_4__2 : rule__MegalEntity__Group_4__2__Impl rule__MegalEntity__Group_4__3 ;
    public final void rule__MegalEntity__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2453:1: ( rule__MegalEntity__Group_4__2__Impl rule__MegalEntity__Group_4__3 )
            // InternalMegal.g:2454:2: rule__MegalEntity__Group_4__2__Impl rule__MegalEntity__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MegalEntity__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__2"


    // $ANTLR start "rule__MegalEntity__Group_4__2__Impl"
    // InternalMegal.g:2461:1: rule__MegalEntity__Group_4__2__Impl : ( ( rule__MegalEntity__Group_4_2__0 )* ) ;
    public final void rule__MegalEntity__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2465:1: ( ( ( rule__MegalEntity__Group_4_2__0 )* ) )
            // InternalMegal.g:2466:1: ( ( rule__MegalEntity__Group_4_2__0 )* )
            {
            // InternalMegal.g:2466:1: ( ( rule__MegalEntity__Group_4_2__0 )* )
            // InternalMegal.g:2467:1: ( rule__MegalEntity__Group_4_2__0 )*
            {
             before(grammarAccess.getMegalEntityAccess().getGroup_4_2()); 
            // InternalMegal.g:2468:1: ( rule__MegalEntity__Group_4_2__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==23) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMegal.g:2468:2: rule__MegalEntity__Group_4_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__MegalEntity__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getMegalEntityAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__2__Impl"


    // $ANTLR start "rule__MegalEntity__Group_4__3"
    // InternalMegal.g:2478:1: rule__MegalEntity__Group_4__3 : rule__MegalEntity__Group_4__3__Impl ;
    public final void rule__MegalEntity__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2482:1: ( rule__MegalEntity__Group_4__3__Impl )
            // InternalMegal.g:2483:2: rule__MegalEntity__Group_4__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__3"


    // $ANTLR start "rule__MegalEntity__Group_4__3__Impl"
    // InternalMegal.g:2489:1: rule__MegalEntity__Group_4__3__Impl : ( ']' ) ;
    public final void rule__MegalEntity__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2493:1: ( ( ']' ) )
            // InternalMegal.g:2494:1: ( ']' )
            {
            // InternalMegal.g:2494:1: ( ']' )
            // InternalMegal.g:2495:1: ']'
            {
             before(grammarAccess.getMegalEntityAccess().getRightSquareBracketKeyword_4_3()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getRightSquareBracketKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4__3__Impl"


    // $ANTLR start "rule__MegalEntity__Group_4_2__0"
    // InternalMegal.g:2516:1: rule__MegalEntity__Group_4_2__0 : rule__MegalEntity__Group_4_2__0__Impl rule__MegalEntity__Group_4_2__1 ;
    public final void rule__MegalEntity__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2520:1: ( rule__MegalEntity__Group_4_2__0__Impl rule__MegalEntity__Group_4_2__1 )
            // InternalMegal.g:2521:2: rule__MegalEntity__Group_4_2__0__Impl rule__MegalEntity__Group_4_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalEntity__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4_2__0"


    // $ANTLR start "rule__MegalEntity__Group_4_2__0__Impl"
    // InternalMegal.g:2528:1: rule__MegalEntity__Group_4_2__0__Impl : ( '->' ) ;
    public final void rule__MegalEntity__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2532:1: ( ( '->' ) )
            // InternalMegal.g:2533:1: ( '->' )
            {
            // InternalMegal.g:2533:1: ( '->' )
            // InternalMegal.g:2534:1: '->'
            {
             before(grammarAccess.getMegalEntityAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4_2__0__Impl"


    // $ANTLR start "rule__MegalEntity__Group_4_2__1"
    // InternalMegal.g:2547:1: rule__MegalEntity__Group_4_2__1 : rule__MegalEntity__Group_4_2__1__Impl ;
    public final void rule__MegalEntity__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2551:1: ( rule__MegalEntity__Group_4_2__1__Impl )
            // InternalMegal.g:2552:2: rule__MegalEntity__Group_4_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4_2__1"


    // $ANTLR start "rule__MegalEntity__Group_4_2__1__Impl"
    // InternalMegal.g:2558:1: rule__MegalEntity__Group_4_2__1__Impl : ( ( rule__MegalEntity__ParamsAssignment_4_2_1 ) ) ;
    public final void rule__MegalEntity__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2562:1: ( ( ( rule__MegalEntity__ParamsAssignment_4_2_1 ) ) )
            // InternalMegal.g:2563:1: ( ( rule__MegalEntity__ParamsAssignment_4_2_1 ) )
            {
            // InternalMegal.g:2563:1: ( ( rule__MegalEntity__ParamsAssignment_4_2_1 ) )
            // InternalMegal.g:2564:1: ( rule__MegalEntity__ParamsAssignment_4_2_1 )
            {
             before(grammarAccess.getMegalEntityAccess().getParamsAssignment_4_2_1()); 
            // InternalMegal.g:2565:1: ( rule__MegalEntity__ParamsAssignment_4_2_1 )
            // InternalMegal.g:2565:2: rule__MegalEntity__ParamsAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalEntity__ParamsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalEntityAccess().getParamsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__Group_4_2__1__Impl"


    // $ANTLR start "rule__MegalRelationship__Group__0"
    // InternalMegal.g:2579:1: rule__MegalRelationship__Group__0 : rule__MegalRelationship__Group__0__Impl rule__MegalRelationship__Group__1 ;
    public final void rule__MegalRelationship__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2583:1: ( rule__MegalRelationship__Group__0__Impl rule__MegalRelationship__Group__1 )
            // InternalMegal.g:2584:2: rule__MegalRelationship__Group__0__Impl rule__MegalRelationship__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MegalRelationship__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__0"


    // $ANTLR start "rule__MegalRelationship__Group__0__Impl"
    // InternalMegal.g:2591:1: rule__MegalRelationship__Group__0__Impl : ( ( rule__MegalRelationship__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalRelationship__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2595:1: ( ( ( rule__MegalRelationship__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:2596:1: ( ( rule__MegalRelationship__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:2596:1: ( ( rule__MegalRelationship__AnnotationsAssignment_0 )* )
            // InternalMegal.g:2597:1: ( rule__MegalRelationship__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalRelationshipAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:2598:1: ( rule__MegalRelationship__AnnotationsAssignment_0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ANN_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMegal.g:2598:2: rule__MegalRelationship__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalRelationship__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getMegalRelationshipAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__0__Impl"


    // $ANTLR start "rule__MegalRelationship__Group__1"
    // InternalMegal.g:2608:1: rule__MegalRelationship__Group__1 : rule__MegalRelationship__Group__1__Impl rule__MegalRelationship__Group__2 ;
    public final void rule__MegalRelationship__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2612:1: ( rule__MegalRelationship__Group__1__Impl rule__MegalRelationship__Group__2 )
            // InternalMegal.g:2613:2: rule__MegalRelationship__Group__1__Impl rule__MegalRelationship__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationship__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__1"


    // $ANTLR start "rule__MegalRelationship__Group__1__Impl"
    // InternalMegal.g:2620:1: rule__MegalRelationship__Group__1__Impl : ( ( rule__MegalRelationship__LeftAssignment_1 ) ) ;
    public final void rule__MegalRelationship__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2624:1: ( ( ( rule__MegalRelationship__LeftAssignment_1 ) ) )
            // InternalMegal.g:2625:1: ( ( rule__MegalRelationship__LeftAssignment_1 ) )
            {
            // InternalMegal.g:2625:1: ( ( rule__MegalRelationship__LeftAssignment_1 ) )
            // InternalMegal.g:2626:1: ( rule__MegalRelationship__LeftAssignment_1 )
            {
             before(grammarAccess.getMegalRelationshipAccess().getLeftAssignment_1()); 
            // InternalMegal.g:2627:1: ( rule__MegalRelationship__LeftAssignment_1 )
            // InternalMegal.g:2627:2: rule__MegalRelationship__LeftAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__1__Impl"


    // $ANTLR start "rule__MegalRelationship__Group__2"
    // InternalMegal.g:2637:1: rule__MegalRelationship__Group__2 : rule__MegalRelationship__Group__2__Impl rule__MegalRelationship__Group__3 ;
    public final void rule__MegalRelationship__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2641:1: ( rule__MegalRelationship__Group__2__Impl rule__MegalRelationship__Group__3 )
            // InternalMegal.g:2642:2: rule__MegalRelationship__Group__2__Impl rule__MegalRelationship__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalRelationship__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__2"


    // $ANTLR start "rule__MegalRelationship__Group__2__Impl"
    // InternalMegal.g:2649:1: rule__MegalRelationship__Group__2__Impl : ( ( rule__MegalRelationship__TypeAssignment_2 ) ) ;
    public final void rule__MegalRelationship__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2653:1: ( ( ( rule__MegalRelationship__TypeAssignment_2 ) ) )
            // InternalMegal.g:2654:1: ( ( rule__MegalRelationship__TypeAssignment_2 ) )
            {
            // InternalMegal.g:2654:1: ( ( rule__MegalRelationship__TypeAssignment_2 ) )
            // InternalMegal.g:2655:1: ( rule__MegalRelationship__TypeAssignment_2 )
            {
             before(grammarAccess.getMegalRelationshipAccess().getTypeAssignment_2()); 
            // InternalMegal.g:2656:1: ( rule__MegalRelationship__TypeAssignment_2 )
            // InternalMegal.g:2656:2: rule__MegalRelationship__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__2__Impl"


    // $ANTLR start "rule__MegalRelationship__Group__3"
    // InternalMegal.g:2666:1: rule__MegalRelationship__Group__3 : rule__MegalRelationship__Group__3__Impl ;
    public final void rule__MegalRelationship__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2670:1: ( rule__MegalRelationship__Group__3__Impl )
            // InternalMegal.g:2671:2: rule__MegalRelationship__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__3"


    // $ANTLR start "rule__MegalRelationship__Group__3__Impl"
    // InternalMegal.g:2677:1: rule__MegalRelationship__Group__3__Impl : ( ( rule__MegalRelationship__RightAssignment_3 ) ) ;
    public final void rule__MegalRelationship__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2681:1: ( ( ( rule__MegalRelationship__RightAssignment_3 ) ) )
            // InternalMegal.g:2682:1: ( ( rule__MegalRelationship__RightAssignment_3 ) )
            {
            // InternalMegal.g:2682:1: ( ( rule__MegalRelationship__RightAssignment_3 ) )
            // InternalMegal.g:2683:1: ( rule__MegalRelationship__RightAssignment_3 )
            {
             before(grammarAccess.getMegalRelationshipAccess().getRightAssignment_3()); 
            // InternalMegal.g:2684:1: ( rule__MegalRelationship__RightAssignment_3 )
            // InternalMegal.g:2684:2: rule__MegalRelationship__RightAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalRelationship__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMegalRelationshipAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__Group__3__Impl"


    // $ANTLR start "rule__MegalPair__Group__0"
    // InternalMegal.g:2702:1: rule__MegalPair__Group__0 : rule__MegalPair__Group__0__Impl rule__MegalPair__Group__1 ;
    public final void rule__MegalPair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2706:1: ( rule__MegalPair__Group__0__Impl rule__MegalPair__Group__1 )
            // InternalMegal.g:2707:2: rule__MegalPair__Group__0__Impl rule__MegalPair__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MegalPair__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__0"


    // $ANTLR start "rule__MegalPair__Group__0__Impl"
    // InternalMegal.g:2714:1: rule__MegalPair__Group__0__Impl : ( ( rule__MegalPair__AnnotationsAssignment_0 )* ) ;
    public final void rule__MegalPair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2718:1: ( ( ( rule__MegalPair__AnnotationsAssignment_0 )* ) )
            // InternalMegal.g:2719:1: ( ( rule__MegalPair__AnnotationsAssignment_0 )* )
            {
            // InternalMegal.g:2719:1: ( ( rule__MegalPair__AnnotationsAssignment_0 )* )
            // InternalMegal.g:2720:1: ( rule__MegalPair__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getMegalPairAccess().getAnnotationsAssignment_0()); 
            // InternalMegal.g:2721:1: ( rule__MegalPair__AnnotationsAssignment_0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ANN_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMegal.g:2721:2: rule__MegalPair__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__MegalPair__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getMegalPairAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__0__Impl"


    // $ANTLR start "rule__MegalPair__Group__1"
    // InternalMegal.g:2731:1: rule__MegalPair__Group__1 : rule__MegalPair__Group__1__Impl rule__MegalPair__Group__2 ;
    public final void rule__MegalPair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2735:1: ( rule__MegalPair__Group__1__Impl rule__MegalPair__Group__2 )
            // InternalMegal.g:2736:2: rule__MegalPair__Group__1__Impl rule__MegalPair__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__MegalPair__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__1"


    // $ANTLR start "rule__MegalPair__Group__1__Impl"
    // InternalMegal.g:2743:1: rule__MegalPair__Group__1__Impl : ( ( rule__MegalPair__SetAssignment_1 ) ) ;
    public final void rule__MegalPair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2747:1: ( ( ( rule__MegalPair__SetAssignment_1 ) ) )
            // InternalMegal.g:2748:1: ( ( rule__MegalPair__SetAssignment_1 ) )
            {
            // InternalMegal.g:2748:1: ( ( rule__MegalPair__SetAssignment_1 ) )
            // InternalMegal.g:2749:1: ( rule__MegalPair__SetAssignment_1 )
            {
             before(grammarAccess.getMegalPairAccess().getSetAssignment_1()); 
            // InternalMegal.g:2750:1: ( rule__MegalPair__SetAssignment_1 )
            // InternalMegal.g:2750:2: rule__MegalPair__SetAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__SetAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMegalPairAccess().getSetAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__1__Impl"


    // $ANTLR start "rule__MegalPair__Group__2"
    // InternalMegal.g:2760:1: rule__MegalPair__Group__2 : rule__MegalPair__Group__2__Impl rule__MegalPair__Group__3 ;
    public final void rule__MegalPair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2764:1: ( rule__MegalPair__Group__2__Impl rule__MegalPair__Group__3 )
            // InternalMegal.g:2765:2: rule__MegalPair__Group__2__Impl rule__MegalPair__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalPair__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__2"


    // $ANTLR start "rule__MegalPair__Group__2__Impl"
    // InternalMegal.g:2772:1: rule__MegalPair__Group__2__Impl : ( '(' ) ;
    public final void rule__MegalPair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2776:1: ( ( '(' ) )
            // InternalMegal.g:2777:1: ( '(' )
            {
            // InternalMegal.g:2777:1: ( '(' )
            // InternalMegal.g:2778:1: '('
            {
             before(grammarAccess.getMegalPairAccess().getLeftParenthesisKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalPairAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__2__Impl"


    // $ANTLR start "rule__MegalPair__Group__3"
    // InternalMegal.g:2791:1: rule__MegalPair__Group__3 : rule__MegalPair__Group__3__Impl rule__MegalPair__Group__4 ;
    public final void rule__MegalPair__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2795:1: ( rule__MegalPair__Group__3__Impl rule__MegalPair__Group__4 )
            // InternalMegal.g:2796:2: rule__MegalPair__Group__3__Impl rule__MegalPair__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__MegalPair__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__3"


    // $ANTLR start "rule__MegalPair__Group__3__Impl"
    // InternalMegal.g:2803:1: rule__MegalPair__Group__3__Impl : ( ( rule__MegalPair__FirstAssignment_3 ) ) ;
    public final void rule__MegalPair__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2807:1: ( ( ( rule__MegalPair__FirstAssignment_3 ) ) )
            // InternalMegal.g:2808:1: ( ( rule__MegalPair__FirstAssignment_3 ) )
            {
            // InternalMegal.g:2808:1: ( ( rule__MegalPair__FirstAssignment_3 ) )
            // InternalMegal.g:2809:1: ( rule__MegalPair__FirstAssignment_3 )
            {
             before(grammarAccess.getMegalPairAccess().getFirstAssignment_3()); 
            // InternalMegal.g:2810:1: ( rule__MegalPair__FirstAssignment_3 )
            // InternalMegal.g:2810:2: rule__MegalPair__FirstAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__FirstAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMegalPairAccess().getFirstAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__3__Impl"


    // $ANTLR start "rule__MegalPair__Group__4"
    // InternalMegal.g:2820:1: rule__MegalPair__Group__4 : rule__MegalPair__Group__4__Impl rule__MegalPair__Group__5 ;
    public final void rule__MegalPair__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2824:1: ( rule__MegalPair__Group__4__Impl rule__MegalPair__Group__5 )
            // InternalMegal.g:2825:2: rule__MegalPair__Group__4__Impl rule__MegalPair__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__MegalPair__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__4"


    // $ANTLR start "rule__MegalPair__Group__4__Impl"
    // InternalMegal.g:2832:1: rule__MegalPair__Group__4__Impl : ( ')' ) ;
    public final void rule__MegalPair__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2836:1: ( ( ')' ) )
            // InternalMegal.g:2837:1: ( ')' )
            {
            // InternalMegal.g:2837:1: ( ')' )
            // InternalMegal.g:2838:1: ')'
            {
             before(grammarAccess.getMegalPairAccess().getRightParenthesisKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalPairAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__4__Impl"


    // $ANTLR start "rule__MegalPair__Group__5"
    // InternalMegal.g:2851:1: rule__MegalPair__Group__5 : rule__MegalPair__Group__5__Impl rule__MegalPair__Group__6 ;
    public final void rule__MegalPair__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2855:1: ( rule__MegalPair__Group__5__Impl rule__MegalPair__Group__6 )
            // InternalMegal.g:2856:2: rule__MegalPair__Group__5__Impl rule__MegalPair__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MegalPair__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__5"


    // $ANTLR start "rule__MegalPair__Group__5__Impl"
    // InternalMegal.g:2863:1: rule__MegalPair__Group__5__Impl : ( '|->' ) ;
    public final void rule__MegalPair__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2867:1: ( ( '|->' ) )
            // InternalMegal.g:2868:1: ( '|->' )
            {
            // InternalMegal.g:2868:1: ( '|->' )
            // InternalMegal.g:2869:1: '|->'
            {
             before(grammarAccess.getMegalPairAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalPairAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__5__Impl"


    // $ANTLR start "rule__MegalPair__Group__6"
    // InternalMegal.g:2882:1: rule__MegalPair__Group__6 : rule__MegalPair__Group__6__Impl ;
    public final void rule__MegalPair__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2886:1: ( rule__MegalPair__Group__6__Impl )
            // InternalMegal.g:2887:2: rule__MegalPair__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__6"


    // $ANTLR start "rule__MegalPair__Group__6__Impl"
    // InternalMegal.g:2893:1: rule__MegalPair__Group__6__Impl : ( ( rule__MegalPair__SecondAssignment_6 ) ) ;
    public final void rule__MegalPair__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2897:1: ( ( ( rule__MegalPair__SecondAssignment_6 ) ) )
            // InternalMegal.g:2898:1: ( ( rule__MegalPair__SecondAssignment_6 ) )
            {
            // InternalMegal.g:2898:1: ( ( rule__MegalPair__SecondAssignment_6 ) )
            // InternalMegal.g:2899:1: ( rule__MegalPair__SecondAssignment_6 )
            {
             before(grammarAccess.getMegalPairAccess().getSecondAssignment_6()); 
            // InternalMegal.g:2900:1: ( rule__MegalPair__SecondAssignment_6 )
            // InternalMegal.g:2900:2: rule__MegalPair__SecondAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MegalPair__SecondAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMegalPairAccess().getSecondAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__Group__6__Impl"


    // $ANTLR start "rule__Selection__Group__0"
    // InternalMegal.g:2924:1: rule__Selection__Group__0 : rule__Selection__Group__0__Impl rule__Selection__Group__1 ;
    public final void rule__Selection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2928:1: ( rule__Selection__Group__0__Impl rule__Selection__Group__1 )
            // InternalMegal.g:2929:2: rule__Selection__Group__0__Impl rule__Selection__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__Selection__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__0"


    // $ANTLR start "rule__Selection__Group__0__Impl"
    // InternalMegal.g:2936:1: rule__Selection__Group__0__Impl : ( ( rule__Selection__SelectAssignment_0 ) ) ;
    public final void rule__Selection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2940:1: ( ( ( rule__Selection__SelectAssignment_0 ) ) )
            // InternalMegal.g:2941:1: ( ( rule__Selection__SelectAssignment_0 ) )
            {
            // InternalMegal.g:2941:1: ( ( rule__Selection__SelectAssignment_0 ) )
            // InternalMegal.g:2942:1: ( rule__Selection__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectionAccess().getSelectAssignment_0()); 
            // InternalMegal.g:2943:1: ( rule__Selection__SelectAssignment_0 )
            // InternalMegal.g:2943:2: rule__Selection__SelectAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__SelectAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSelectionAccess().getSelectAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__0__Impl"


    // $ANTLR start "rule__Selection__Group__1"
    // InternalMegal.g:2953:1: rule__Selection__Group__1 : rule__Selection__Group__1__Impl rule__Selection__Group__2 ;
    public final void rule__Selection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2957:1: ( rule__Selection__Group__1__Impl rule__Selection__Group__2 )
            // InternalMegal.g:2958:2: rule__Selection__Group__1__Impl rule__Selection__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__Selection__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__1"


    // $ANTLR start "rule__Selection__Group__1__Impl"
    // InternalMegal.g:2965:1: rule__Selection__Group__1__Impl : ( ( rule__Selection__Group_1__0 )* ) ;
    public final void rule__Selection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2969:1: ( ( ( rule__Selection__Group_1__0 )* ) )
            // InternalMegal.g:2970:1: ( ( rule__Selection__Group_1__0 )* )
            {
            // InternalMegal.g:2970:1: ( ( rule__Selection__Group_1__0 )* )
            // InternalMegal.g:2971:1: ( rule__Selection__Group_1__0 )*
            {
             before(grammarAccess.getSelectionAccess().getGroup_1()); 
            // InternalMegal.g:2972:1: ( rule__Selection__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==25) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMegal.g:2972:2: rule__Selection__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_25);
            	    rule__Selection__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getSelectionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__1__Impl"


    // $ANTLR start "rule__Selection__Group__2"
    // InternalMegal.g:2982:1: rule__Selection__Group__2 : rule__Selection__Group__2__Impl ;
    public final void rule__Selection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2986:1: ( rule__Selection__Group__2__Impl )
            // InternalMegal.g:2987:2: rule__Selection__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__2"


    // $ANTLR start "rule__Selection__Group__2__Impl"
    // InternalMegal.g:2993:1: rule__Selection__Group__2__Impl : ( ( rule__Selection__Group_2__0 )? ) ;
    public final void rule__Selection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:2997:1: ( ( ( rule__Selection__Group_2__0 )? ) )
            // InternalMegal.g:2998:1: ( ( rule__Selection__Group_2__0 )? )
            {
            // InternalMegal.g:2998:1: ( ( rule__Selection__Group_2__0 )? )
            // InternalMegal.g:2999:1: ( rule__Selection__Group_2__0 )?
            {
             before(grammarAccess.getSelectionAccess().getGroup_2()); 
            // InternalMegal.g:3000:1: ( rule__Selection__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMegal.g:3000:2: rule__Selection__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Selection__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__2__Impl"


    // $ANTLR start "rule__Selection__Group_1__0"
    // InternalMegal.g:3016:1: rule__Selection__Group_1__0 : rule__Selection__Group_1__0__Impl rule__Selection__Group_1__1 ;
    public final void rule__Selection__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3020:1: ( rule__Selection__Group_1__0__Impl rule__Selection__Group_1__1 )
            // InternalMegal.g:3021:2: rule__Selection__Group_1__0__Impl rule__Selection__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Selection__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_1__0"


    // $ANTLR start "rule__Selection__Group_1__0__Impl"
    // InternalMegal.g:3028:1: rule__Selection__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Selection__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3032:1: ( ( ',' ) )
            // InternalMegal.g:3033:1: ( ',' )
            {
            // InternalMegal.g:3033:1: ( ',' )
            // InternalMegal.g:3034:1: ','
            {
             before(grammarAccess.getSelectionAccess().getCommaKeyword_1_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSelectionAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_1__0__Impl"


    // $ANTLR start "rule__Selection__Group_1__1"
    // InternalMegal.g:3047:1: rule__Selection__Group_1__1 : rule__Selection__Group_1__1__Impl ;
    public final void rule__Selection__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3051:1: ( rule__Selection__Group_1__1__Impl )
            // InternalMegal.g:3052:2: rule__Selection__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_1__1"


    // $ANTLR start "rule__Selection__Group_1__1__Impl"
    // InternalMegal.g:3058:1: rule__Selection__Group_1__1__Impl : ( ( rule__Selection__SelectAssignment_1_1 ) ) ;
    public final void rule__Selection__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3062:1: ( ( ( rule__Selection__SelectAssignment_1_1 ) ) )
            // InternalMegal.g:3063:1: ( ( rule__Selection__SelectAssignment_1_1 ) )
            {
            // InternalMegal.g:3063:1: ( ( rule__Selection__SelectAssignment_1_1 ) )
            // InternalMegal.g:3064:1: ( rule__Selection__SelectAssignment_1_1 )
            {
             before(grammarAccess.getSelectionAccess().getSelectAssignment_1_1()); 
            // InternalMegal.g:3065:1: ( rule__Selection__SelectAssignment_1_1 )
            // InternalMegal.g:3065:2: rule__Selection__SelectAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__SelectAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSelectionAccess().getSelectAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_1__1__Impl"


    // $ANTLR start "rule__Selection__Group_2__0"
    // InternalMegal.g:3079:1: rule__Selection__Group_2__0 : rule__Selection__Group_2__0__Impl rule__Selection__Group_2__1 ;
    public final void rule__Selection__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3083:1: ( rule__Selection__Group_2__0__Impl rule__Selection__Group_2__1 )
            // InternalMegal.g:3084:2: rule__Selection__Group_2__0__Impl rule__Selection__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__Selection__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__0"


    // $ANTLR start "rule__Selection__Group_2__0__Impl"
    // InternalMegal.g:3091:1: rule__Selection__Group_2__0__Impl : ( 'from' ) ;
    public final void rule__Selection__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3095:1: ( ( 'from' ) )
            // InternalMegal.g:3096:1: ( 'from' )
            {
            // InternalMegal.g:3096:1: ( 'from' )
            // InternalMegal.g:3097:1: 'from'
            {
             before(grammarAccess.getSelectionAccess().getFromKeyword_2_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSelectionAccess().getFromKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__0__Impl"


    // $ANTLR start "rule__Selection__Group_2__1"
    // InternalMegal.g:3110:1: rule__Selection__Group_2__1 : rule__Selection__Group_2__1__Impl rule__Selection__Group_2__2 ;
    public final void rule__Selection__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3114:1: ( rule__Selection__Group_2__1__Impl rule__Selection__Group_2__2 )
            // InternalMegal.g:3115:2: rule__Selection__Group_2__1__Impl rule__Selection__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Selection__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__1"


    // $ANTLR start "rule__Selection__Group_2__1__Impl"
    // InternalMegal.g:3122:1: rule__Selection__Group_2__1__Impl : ( '{' ) ;
    public final void rule__Selection__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3126:1: ( ( '{' ) )
            // InternalMegal.g:3127:1: ( '{' )
            {
            // InternalMegal.g:3127:1: ( '{' )
            // InternalMegal.g:3128:1: '{'
            {
             before(grammarAccess.getSelectionAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSelectionAccess().getLeftCurlyBracketKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__1__Impl"


    // $ANTLR start "rule__Selection__Group_2__2"
    // InternalMegal.g:3141:1: rule__Selection__Group_2__2 : rule__Selection__Group_2__2__Impl rule__Selection__Group_2__3 ;
    public final void rule__Selection__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3145:1: ( rule__Selection__Group_2__2__Impl rule__Selection__Group_2__3 )
            // InternalMegal.g:3146:2: rule__Selection__Group_2__2__Impl rule__Selection__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Selection__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__2"


    // $ANTLR start "rule__Selection__Group_2__2__Impl"
    // InternalMegal.g:3153:1: rule__Selection__Group_2__2__Impl : ( ( ( rule__Selection__QueryAssignment_2_2 ) ) ( ( rule__Selection__QueryAssignment_2_2 )* ) ) ;
    public final void rule__Selection__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3157:1: ( ( ( ( rule__Selection__QueryAssignment_2_2 ) ) ( ( rule__Selection__QueryAssignment_2_2 )* ) ) )
            // InternalMegal.g:3158:1: ( ( ( rule__Selection__QueryAssignment_2_2 ) ) ( ( rule__Selection__QueryAssignment_2_2 )* ) )
            {
            // InternalMegal.g:3158:1: ( ( ( rule__Selection__QueryAssignment_2_2 ) ) ( ( rule__Selection__QueryAssignment_2_2 )* ) )
            // InternalMegal.g:3159:1: ( ( rule__Selection__QueryAssignment_2_2 ) ) ( ( rule__Selection__QueryAssignment_2_2 )* )
            {
            // InternalMegal.g:3159:1: ( ( rule__Selection__QueryAssignment_2_2 ) )
            // InternalMegal.g:3160:1: ( rule__Selection__QueryAssignment_2_2 )
            {
             before(grammarAccess.getSelectionAccess().getQueryAssignment_2_2()); 
            // InternalMegal.g:3161:1: ( rule__Selection__QueryAssignment_2_2 )
            // InternalMegal.g:3161:2: rule__Selection__QueryAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__Selection__QueryAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getSelectionAccess().getQueryAssignment_2_2()); 

            }

            // InternalMegal.g:3164:1: ( ( rule__Selection__QueryAssignment_2_2 )* )
            // InternalMegal.g:3165:1: ( rule__Selection__QueryAssignment_2_2 )*
            {
             before(grammarAccess.getSelectionAccess().getQueryAssignment_2_2()); 
            // InternalMegal.g:3166:1: ( rule__Selection__QueryAssignment_2_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID||(LA28_0>=RULE_STRING && LA28_0<=RULE_VAR_ID)||LA28_0==14) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMegal.g:3166:2: rule__Selection__QueryAssignment_2_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_28);
            	    rule__Selection__QueryAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getSelectionAccess().getQueryAssignment_2_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__2__Impl"


    // $ANTLR start "rule__Selection__Group_2__3"
    // InternalMegal.g:3177:1: rule__Selection__Group_2__3 : rule__Selection__Group_2__3__Impl ;
    public final void rule__Selection__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3181:1: ( rule__Selection__Group_2__3__Impl )
            // InternalMegal.g:3182:2: rule__Selection__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Selection__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__3"


    // $ANTLR start "rule__Selection__Group_2__3__Impl"
    // InternalMegal.g:3188:1: rule__Selection__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Selection__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3192:1: ( ( '}' ) )
            // InternalMegal.g:3193:1: ( '}' )
            {
            // InternalMegal.g:3193:1: ( '}' )
            // InternalMegal.g:3194:1: '}'
            {
             before(grammarAccess.getSelectionAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSelectionAccess().getRightCurlyBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_2__3__Impl"


    // $ANTLR start "rule__QueryStatement__Group__0"
    // InternalMegal.g:3215:1: rule__QueryStatement__Group__0 : rule__QueryStatement__Group__0__Impl rule__QueryStatement__Group__1 ;
    public final void rule__QueryStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3219:1: ( rule__QueryStatement__Group__0__Impl rule__QueryStatement__Group__1 )
            // InternalMegal.g:3220:2: rule__QueryStatement__Group__0__Impl rule__QueryStatement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__QueryStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__Group__0"


    // $ANTLR start "rule__QueryStatement__Group__0__Impl"
    // InternalMegal.g:3227:1: rule__QueryStatement__Group__0__Impl : ( ( rule__QueryStatement__SubjectAssignment_0 ) ) ;
    public final void rule__QueryStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3231:1: ( ( ( rule__QueryStatement__SubjectAssignment_0 ) ) )
            // InternalMegal.g:3232:1: ( ( rule__QueryStatement__SubjectAssignment_0 ) )
            {
            // InternalMegal.g:3232:1: ( ( rule__QueryStatement__SubjectAssignment_0 ) )
            // InternalMegal.g:3233:1: ( rule__QueryStatement__SubjectAssignment_0 )
            {
             before(grammarAccess.getQueryStatementAccess().getSubjectAssignment_0()); 
            // InternalMegal.g:3234:1: ( rule__QueryStatement__SubjectAssignment_0 )
            // InternalMegal.g:3234:2: rule__QueryStatement__SubjectAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__SubjectAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQueryStatementAccess().getSubjectAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__Group__0__Impl"


    // $ANTLR start "rule__QueryStatement__Group__1"
    // InternalMegal.g:3244:1: rule__QueryStatement__Group__1 : rule__QueryStatement__Group__1__Impl rule__QueryStatement__Group__2 ;
    public final void rule__QueryStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3248:1: ( rule__QueryStatement__Group__1__Impl rule__QueryStatement__Group__2 )
            // InternalMegal.g:3249:2: rule__QueryStatement__Group__1__Impl rule__QueryStatement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__QueryStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__Group__1"


    // $ANTLR start "rule__QueryStatement__Group__1__Impl"
    // InternalMegal.g:3256:1: rule__QueryStatement__Group__1__Impl : ( ( rule__QueryStatement__PredicateAssignment_1 ) ) ;
    public final void rule__QueryStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3260:1: ( ( ( rule__QueryStatement__PredicateAssignment_1 ) ) )
            // InternalMegal.g:3261:1: ( ( rule__QueryStatement__PredicateAssignment_1 ) )
            {
            // InternalMegal.g:3261:1: ( ( rule__QueryStatement__PredicateAssignment_1 ) )
            // InternalMegal.g:3262:1: ( rule__QueryStatement__PredicateAssignment_1 )
            {
             before(grammarAccess.getQueryStatementAccess().getPredicateAssignment_1()); 
            // InternalMegal.g:3263:1: ( rule__QueryStatement__PredicateAssignment_1 )
            // InternalMegal.g:3263:2: rule__QueryStatement__PredicateAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__PredicateAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQueryStatementAccess().getPredicateAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__Group__1__Impl"


    // $ANTLR start "rule__QueryStatement__Group__2"
    // InternalMegal.g:3273:1: rule__QueryStatement__Group__2 : rule__QueryStatement__Group__2__Impl ;
    public final void rule__QueryStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3277:1: ( rule__QueryStatement__Group__2__Impl )
            // InternalMegal.g:3278:2: rule__QueryStatement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__Group__2"


    // $ANTLR start "rule__QueryStatement__Group__2__Impl"
    // InternalMegal.g:3284:1: rule__QueryStatement__Group__2__Impl : ( ( rule__QueryStatement__ObjectAssignment_2 ) ) ;
    public final void rule__QueryStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3288:1: ( ( ( rule__QueryStatement__ObjectAssignment_2 ) ) )
            // InternalMegal.g:3289:1: ( ( rule__QueryStatement__ObjectAssignment_2 ) )
            {
            // InternalMegal.g:3289:1: ( ( rule__QueryStatement__ObjectAssignment_2 ) )
            // InternalMegal.g:3290:1: ( rule__QueryStatement__ObjectAssignment_2 )
            {
             before(grammarAccess.getQueryStatementAccess().getObjectAssignment_2()); 
            // InternalMegal.g:3291:1: ( rule__QueryStatement__ObjectAssignment_2 )
            // InternalMegal.g:3291:2: rule__QueryStatement__ObjectAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryStatement__ObjectAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getQueryStatementAccess().getObjectAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__Group__2__Impl"


    // $ANTLR start "rule__QueryParam__Group__0"
    // InternalMegal.g:3307:1: rule__QueryParam__Group__0 : rule__QueryParam__Group__0__Impl rule__QueryParam__Group__1 ;
    public final void rule__QueryParam__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3311:1: ( rule__QueryParam__Group__0__Impl rule__QueryParam__Group__1 )
            // InternalMegal.g:3312:2: rule__QueryParam__Group__0__Impl rule__QueryParam__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__QueryParam__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group__0"


    // $ANTLR start "rule__QueryParam__Group__0__Impl"
    // InternalMegal.g:3319:1: rule__QueryParam__Group__0__Impl : ( ( rule__QueryParam__NameAssignment_0 ) ) ;
    public final void rule__QueryParam__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3323:1: ( ( ( rule__QueryParam__NameAssignment_0 ) ) )
            // InternalMegal.g:3324:1: ( ( rule__QueryParam__NameAssignment_0 ) )
            {
            // InternalMegal.g:3324:1: ( ( rule__QueryParam__NameAssignment_0 ) )
            // InternalMegal.g:3325:1: ( rule__QueryParam__NameAssignment_0 )
            {
             before(grammarAccess.getQueryParamAccess().getNameAssignment_0()); 
            // InternalMegal.g:3326:1: ( rule__QueryParam__NameAssignment_0 )
            // InternalMegal.g:3326:2: rule__QueryParam__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQueryParamAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group__0__Impl"


    // $ANTLR start "rule__QueryParam__Group__1"
    // InternalMegal.g:3336:1: rule__QueryParam__Group__1 : rule__QueryParam__Group__1__Impl ;
    public final void rule__QueryParam__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3340:1: ( rule__QueryParam__Group__1__Impl )
            // InternalMegal.g:3341:2: rule__QueryParam__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group__1"


    // $ANTLR start "rule__QueryParam__Group__1__Impl"
    // InternalMegal.g:3347:1: rule__QueryParam__Group__1__Impl : ( ( rule__QueryParam__Group_1__0 )? ) ;
    public final void rule__QueryParam__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3351:1: ( ( ( rule__QueryParam__Group_1__0 )? ) )
            // InternalMegal.g:3352:1: ( ( rule__QueryParam__Group_1__0 )? )
            {
            // InternalMegal.g:3352:1: ( ( rule__QueryParam__Group_1__0 )? )
            // InternalMegal.g:3353:1: ( rule__QueryParam__Group_1__0 )?
            {
             before(grammarAccess.getQueryParamAccess().getGroup_1()); 
            // InternalMegal.g:3354:1: ( rule__QueryParam__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==24) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMegal.g:3354:2: rule__QueryParam__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__QueryParam__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQueryParamAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group__1__Impl"


    // $ANTLR start "rule__QueryParam__Group_1__0"
    // InternalMegal.g:3368:1: rule__QueryParam__Group_1__0 : rule__QueryParam__Group_1__0__Impl rule__QueryParam__Group_1__1 ;
    public final void rule__QueryParam__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3372:1: ( rule__QueryParam__Group_1__0__Impl rule__QueryParam__Group_1__1 )
            // InternalMegal.g:3373:2: rule__QueryParam__Group_1__0__Impl rule__QueryParam__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__QueryParam__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group_1__0"


    // $ANTLR start "rule__QueryParam__Group_1__0__Impl"
    // InternalMegal.g:3380:1: rule__QueryParam__Group_1__0__Impl : ( ':' ) ;
    public final void rule__QueryParam__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3384:1: ( ( ':' ) )
            // InternalMegal.g:3385:1: ( ':' )
            {
            // InternalMegal.g:3385:1: ( ':' )
            // InternalMegal.g:3386:1: ':'
            {
             before(grammarAccess.getQueryParamAccess().getColonKeyword_1_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryParamAccess().getColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group_1__0__Impl"


    // $ANTLR start "rule__QueryParam__Group_1__1"
    // InternalMegal.g:3399:1: rule__QueryParam__Group_1__1 : rule__QueryParam__Group_1__1__Impl ;
    public final void rule__QueryParam__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3403:1: ( rule__QueryParam__Group_1__1__Impl )
            // InternalMegal.g:3404:2: rule__QueryParam__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group_1__1"


    // $ANTLR start "rule__QueryParam__Group_1__1__Impl"
    // InternalMegal.g:3410:1: rule__QueryParam__Group_1__1__Impl : ( ( rule__QueryParam__TypeAssignment_1_1 ) ) ;
    public final void rule__QueryParam__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3414:1: ( ( ( rule__QueryParam__TypeAssignment_1_1 ) ) )
            // InternalMegal.g:3415:1: ( ( rule__QueryParam__TypeAssignment_1_1 ) )
            {
            // InternalMegal.g:3415:1: ( ( rule__QueryParam__TypeAssignment_1_1 ) )
            // InternalMegal.g:3416:1: ( rule__QueryParam__TypeAssignment_1_1 )
            {
             before(grammarAccess.getQueryParamAccess().getTypeAssignment_1_1()); 
            // InternalMegal.g:3417:1: ( rule__QueryParam__TypeAssignment_1_1 )
            // InternalMegal.g:3417:2: rule__QueryParam__TypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryParam__TypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getQueryParamAccess().getTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__Group_1__1__Impl"


    // $ANTLR start "rule__QueryPos__Group__0"
    // InternalMegal.g:3431:1: rule__QueryPos__Group__0 : rule__QueryPos__Group__0__Impl rule__QueryPos__Group__1 ;
    public final void rule__QueryPos__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3435:1: ( rule__QueryPos__Group__0__Impl rule__QueryPos__Group__1 )
            // InternalMegal.g:3436:2: rule__QueryPos__Group__0__Impl rule__QueryPos__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__QueryPos__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryPos__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__Group__0"


    // $ANTLR start "rule__QueryPos__Group__0__Impl"
    // InternalMegal.g:3443:1: rule__QueryPos__Group__0__Impl : ( '(' ) ;
    public final void rule__QueryPos__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3447:1: ( ( '(' ) )
            // InternalMegal.g:3448:1: ( '(' )
            {
            // InternalMegal.g:3448:1: ( '(' )
            // InternalMegal.g:3449:1: '('
            {
             before(grammarAccess.getQueryPosAccess().getLeftParenthesisKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryPosAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__Group__0__Impl"


    // $ANTLR start "rule__QueryPos__Group__1"
    // InternalMegal.g:3462:1: rule__QueryPos__Group__1 : rule__QueryPos__Group__1__Impl rule__QueryPos__Group__2 ;
    public final void rule__QueryPos__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3466:1: ( rule__QueryPos__Group__1__Impl rule__QueryPos__Group__2 )
            // InternalMegal.g:3467:2: rule__QueryPos__Group__1__Impl rule__QueryPos__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__QueryPos__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryPos__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__Group__1"


    // $ANTLR start "rule__QueryPos__Group__1__Impl"
    // InternalMegal.g:3474:1: rule__QueryPos__Group__1__Impl : ( ( rule__QueryPos__ValueAssignment_1 ) ) ;
    public final void rule__QueryPos__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3478:1: ( ( ( rule__QueryPos__ValueAssignment_1 ) ) )
            // InternalMegal.g:3479:1: ( ( rule__QueryPos__ValueAssignment_1 ) )
            {
            // InternalMegal.g:3479:1: ( ( rule__QueryPos__ValueAssignment_1 ) )
            // InternalMegal.g:3480:1: ( rule__QueryPos__ValueAssignment_1 )
            {
             before(grammarAccess.getQueryPosAccess().getValueAssignment_1()); 
            // InternalMegal.g:3481:1: ( rule__QueryPos__ValueAssignment_1 )
            // InternalMegal.g:3481:2: rule__QueryPos__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryPos__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQueryPosAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__Group__1__Impl"


    // $ANTLR start "rule__QueryPos__Group__2"
    // InternalMegal.g:3491:1: rule__QueryPos__Group__2 : rule__QueryPos__Group__2__Impl ;
    public final void rule__QueryPos__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3495:1: ( rule__QueryPos__Group__2__Impl )
            // InternalMegal.g:3496:2: rule__QueryPos__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QueryPos__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__Group__2"


    // $ANTLR start "rule__QueryPos__Group__2__Impl"
    // InternalMegal.g:3502:1: rule__QueryPos__Group__2__Impl : ( ')' ) ;
    public final void rule__QueryPos__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3506:1: ( ( ')' ) )
            // InternalMegal.g:3507:1: ( ')' )
            {
            // InternalMegal.g:3507:1: ( ')' )
            // InternalMegal.g:3508:1: ')'
            {
             before(grammarAccess.getQueryPosAccess().getRightParenthesisKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryPosAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__Group__2__Impl"


    // $ANTLR start "rule__MegalFile__AnnotationsAssignment_0"
    // InternalMegal.g:3528:1: rule__MegalFile__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalFile__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3532:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:3533:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:3533:1: ( ruleMegalAnnotation )
            // InternalMegal.g:3534:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalFileAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalFile__NameAssignment_2"
    // InternalMegal.g:3543:1: rule__MegalFile__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__MegalFile__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3547:1: ( ( RULE_ID ) )
            // InternalMegal.g:3548:1: ( RULE_ID )
            {
            // InternalMegal.g:3548:1: ( RULE_ID )
            // InternalMegal.g:3549:1: RULE_ID
            {
             before(grammarAccess.getMegalFileAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalFileAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__NameAssignment_2"


    // $ANTLR start "rule__MegalFile__ImportsAssignment_3_0_1"
    // InternalMegal.g:3558:1: rule__MegalFile__ImportsAssignment_3_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalFile__ImportsAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3562:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3563:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3563:1: ( ( RULE_ID ) )
            // InternalMegal.g:3564:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalFileAccess().getImportsMegalFileCrossReference_3_0_1_0()); 
            // InternalMegal.g:3565:1: ( RULE_ID )
            // InternalMegal.g:3566:1: RULE_ID
            {
             before(grammarAccess.getMegalFileAccess().getImportsMegalFileIDTerminalRuleCall_3_0_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalFileAccess().getImportsMegalFileIDTerminalRuleCall_3_0_1_0_1()); 

            }

             after(grammarAccess.getMegalFileAccess().getImportsMegalFileCrossReference_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__ImportsAssignment_3_0_1"


    // $ANTLR start "rule__MegalFile__DeclarationsAssignment_3_1"
    // InternalMegal.g:3577:1: rule__MegalFile__DeclarationsAssignment_3_1 : ( ruleMegalEntityType ) ;
    public final void rule__MegalFile__DeclarationsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3581:1: ( ( ruleMegalEntityType ) )
            // InternalMegal.g:3582:1: ( ruleMegalEntityType )
            {
            // InternalMegal.g:3582:1: ( ruleMegalEntityType )
            // InternalMegal.g:3583:1: ruleMegalEntityType
            {
             before(grammarAccess.getMegalFileAccess().getDeclarationsMegalEntityTypeParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalEntityType();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getDeclarationsMegalEntityTypeParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__DeclarationsAssignment_3_1"


    // $ANTLR start "rule__MegalFile__DeclarationsAssignment_3_2"
    // InternalMegal.g:3592:1: rule__MegalFile__DeclarationsAssignment_3_2 : ( ruleMegalRelationshipType ) ;
    public final void rule__MegalFile__DeclarationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3596:1: ( ( ruleMegalRelationshipType ) )
            // InternalMegal.g:3597:1: ( ruleMegalRelationshipType )
            {
            // InternalMegal.g:3597:1: ( ruleMegalRelationshipType )
            // InternalMegal.g:3598:1: ruleMegalRelationshipType
            {
             before(grammarAccess.getMegalFileAccess().getDeclarationsMegalRelationshipTypeParserRuleCall_3_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalRelationshipType();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getDeclarationsMegalRelationshipTypeParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__DeclarationsAssignment_3_2"


    // $ANTLR start "rule__MegalFile__DeclarationsAssignment_3_3"
    // InternalMegal.g:3607:1: rule__MegalFile__DeclarationsAssignment_3_3 : ( ruleMegalEntity ) ;
    public final void rule__MegalFile__DeclarationsAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3611:1: ( ( ruleMegalEntity ) )
            // InternalMegal.g:3612:1: ( ruleMegalEntity )
            {
            // InternalMegal.g:3612:1: ( ruleMegalEntity )
            // InternalMegal.g:3613:1: ruleMegalEntity
            {
             before(grammarAccess.getMegalFileAccess().getDeclarationsMegalEntityParserRuleCall_3_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalEntity();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getDeclarationsMegalEntityParserRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__DeclarationsAssignment_3_3"


    // $ANTLR start "rule__MegalFile__DeclarationsAssignment_3_4"
    // InternalMegal.g:3622:1: rule__MegalFile__DeclarationsAssignment_3_4 : ( ruleMegalRelationship ) ;
    public final void rule__MegalFile__DeclarationsAssignment_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3626:1: ( ( ruleMegalRelationship ) )
            // InternalMegal.g:3627:1: ( ruleMegalRelationship )
            {
            // InternalMegal.g:3627:1: ( ruleMegalRelationship )
            // InternalMegal.g:3628:1: ruleMegalRelationship
            {
             before(grammarAccess.getMegalFileAccess().getDeclarationsMegalRelationshipParserRuleCall_3_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalRelationship();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getDeclarationsMegalRelationshipParserRuleCall_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__DeclarationsAssignment_3_4"


    // $ANTLR start "rule__MegalFile__DeclarationsAssignment_3_5"
    // InternalMegal.g:3637:1: rule__MegalFile__DeclarationsAssignment_3_5 : ( ruleMegalPair ) ;
    public final void rule__MegalFile__DeclarationsAssignment_3_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3641:1: ( ( ruleMegalPair ) )
            // InternalMegal.g:3642:1: ( ruleMegalPair )
            {
            // InternalMegal.g:3642:1: ( ruleMegalPair )
            // InternalMegal.g:3643:1: ruleMegalPair
            {
             before(grammarAccess.getMegalFileAccess().getDeclarationsMegalPairParserRuleCall_3_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalPair();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getDeclarationsMegalPairParserRuleCall_3_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__DeclarationsAssignment_3_5"


    // $ANTLR start "rule__MegalFile__BindingsAssignment_3_6"
    // InternalMegal.g:3652:1: rule__MegalFile__BindingsAssignment_3_6 : ( ruleMegalLink ) ;
    public final void rule__MegalFile__BindingsAssignment_3_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3656:1: ( ( ruleMegalLink ) )
            // InternalMegal.g:3657:1: ( ruleMegalLink )
            {
            // InternalMegal.g:3657:1: ( ruleMegalLink )
            // InternalMegal.g:3658:1: ruleMegalLink
            {
             before(grammarAccess.getMegalFileAccess().getBindingsMegalLinkParserRuleCall_3_6_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalLink();

            state._fsp--;

             after(grammarAccess.getMegalFileAccess().getBindingsMegalLinkParserRuleCall_3_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalFile__BindingsAssignment_3_6"


    // $ANTLR start "rule__MegalAnnotation__KeyAssignment_0"
    // InternalMegal.g:3667:1: rule__MegalAnnotation__KeyAssignment_0 : ( RULE_ANN_ID ) ;
    public final void rule__MegalAnnotation__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3671:1: ( ( RULE_ANN_ID ) )
            // InternalMegal.g:3672:1: ( RULE_ANN_ID )
            {
            // InternalMegal.g:3672:1: ( RULE_ANN_ID )
            // InternalMegal.g:3673:1: RULE_ANN_ID
            {
             before(grammarAccess.getMegalAnnotationAccess().getKeyANN_IDTerminalRuleCall_0_0()); 
            match(input,RULE_ANN_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalAnnotationAccess().getKeyANN_IDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalAnnotation__KeyAssignment_0"


    // $ANTLR start "rule__MegalAnnotation__SelectionAssignment_1"
    // InternalMegal.g:3682:1: rule__MegalAnnotation__SelectionAssignment_1 : ( ruleSelection ) ;
    public final void rule__MegalAnnotation__SelectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3686:1: ( ( ruleSelection ) )
            // InternalMegal.g:3687:1: ( ruleSelection )
            {
            // InternalMegal.g:3687:1: ( ruleSelection )
            // InternalMegal.g:3688:1: ruleSelection
            {
             before(grammarAccess.getMegalAnnotationAccess().getSelectionSelectionParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSelection();

            state._fsp--;

             after(grammarAccess.getMegalAnnotationAccess().getSelectionSelectionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalAnnotation__SelectionAssignment_1"


    // $ANTLR start "rule__MegalLink__AnnotationsAssignment_0"
    // InternalMegal.g:3697:1: rule__MegalLink__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalLink__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3701:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:3702:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:3702:1: ( ruleMegalAnnotation )
            // InternalMegal.g:3703:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalLinkAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalLinkAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalLink__LinkAssignment_1"
    // InternalMegal.g:3712:1: rule__MegalLink__LinkAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalLink__LinkAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3716:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3717:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3717:1: ( ( RULE_ID ) )
            // InternalMegal.g:3718:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalLinkAccess().getLinkMegalEntityCrossReference_1_0()); 
            // InternalMegal.g:3719:1: ( RULE_ID )
            // InternalMegal.g:3720:1: RULE_ID
            {
             before(grammarAccess.getMegalLinkAccess().getLinkMegalEntityIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getLinkMegalEntityIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMegalLinkAccess().getLinkMegalEntityCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__LinkAssignment_1"


    // $ANTLR start "rule__MegalLink__FirstAssignment_2_1"
    // InternalMegal.g:3731:1: rule__MegalLink__FirstAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalLink__FirstAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3735:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3736:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3736:1: ( ( RULE_ID ) )
            // InternalMegal.g:3737:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalLinkAccess().getFirstMegalEntityCrossReference_2_1_0()); 
            // InternalMegal.g:3738:1: ( RULE_ID )
            // InternalMegal.g:3739:1: RULE_ID
            {
             before(grammarAccess.getMegalLinkAccess().getFirstMegalEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getFirstMegalEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getMegalLinkAccess().getFirstMegalEntityCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__FirstAssignment_2_1"


    // $ANTLR start "rule__MegalLink__SecondAssignment_2_4"
    // InternalMegal.g:3750:1: rule__MegalLink__SecondAssignment_2_4 : ( ( RULE_ID ) ) ;
    public final void rule__MegalLink__SecondAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3754:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3755:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3755:1: ( ( RULE_ID ) )
            // InternalMegal.g:3756:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalLinkAccess().getSecondMegalEntityCrossReference_2_4_0()); 
            // InternalMegal.g:3757:1: ( RULE_ID )
            // InternalMegal.g:3758:1: RULE_ID
            {
             before(grammarAccess.getMegalLinkAccess().getSecondMegalEntityIDTerminalRuleCall_2_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getSecondMegalEntityIDTerminalRuleCall_2_4_0_1()); 

            }

             after(grammarAccess.getMegalLinkAccess().getSecondMegalEntityCrossReference_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__SecondAssignment_2_4"


    // $ANTLR start "rule__MegalLink__ToAssignment_4"
    // InternalMegal.g:3769:1: rule__MegalLink__ToAssignment_4 : ( RULE_STRING ) ;
    public final void rule__MegalLink__ToAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3773:1: ( ( RULE_STRING ) )
            // InternalMegal.g:3774:1: ( RULE_STRING )
            {
            // InternalMegal.g:3774:1: ( RULE_STRING )
            // InternalMegal.g:3775:1: RULE_STRING
            {
             before(grammarAccess.getMegalLinkAccess().getToSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalLinkAccess().getToSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalLink__ToAssignment_4"


    // $ANTLR start "rule__MegalEntityType__AnnotationsAssignment_0"
    // InternalMegal.g:3784:1: rule__MegalEntityType__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalEntityType__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3788:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:3789:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:3789:1: ( ruleMegalAnnotation )
            // InternalMegal.g:3790:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalEntityTypeAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalEntityTypeAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalEntityType__NameAssignment_1"
    // InternalMegal.g:3799:1: rule__MegalEntityType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MegalEntityType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3803:1: ( ( RULE_ID ) )
            // InternalMegal.g:3804:1: ( RULE_ID )
            {
            // InternalMegal.g:3804:1: ( RULE_ID )
            // InternalMegal.g:3805:1: RULE_ID
            {
             before(grammarAccess.getMegalEntityTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__NameAssignment_1"


    // $ANTLR start "rule__MegalEntityType__SupertypeAssignment_2_0_1"
    // InternalMegal.g:3814:1: rule__MegalEntityType__SupertypeAssignment_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalEntityType__SupertypeAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3818:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3819:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3819:1: ( ( RULE_ID ) )
            // InternalMegal.g:3820:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalEntityTypeAccess().getSupertypeMegalEntityTypeCrossReference_2_0_1_0()); 
            // InternalMegal.g:3821:1: ( RULE_ID )
            // InternalMegal.g:3822:1: RULE_ID
            {
             before(grammarAccess.getMegalEntityTypeAccess().getSupertypeMegalEntityTypeIDTerminalRuleCall_2_0_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityTypeAccess().getSupertypeMegalEntityTypeIDTerminalRuleCall_2_0_1_0_1()); 

            }

             after(grammarAccess.getMegalEntityTypeAccess().getSupertypeMegalEntityTypeCrossReference_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntityType__SupertypeAssignment_2_0_1"


    // $ANTLR start "rule__MegalRelationshipType__AnnotationsAssignment_0"
    // InternalMegal.g:3833:1: rule__MegalRelationshipType__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalRelationshipType__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3837:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:3838:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:3838:1: ( ruleMegalAnnotation )
            // InternalMegal.g:3839:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalRelationshipTypeAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalRelationshipType__NameAssignment_1"
    // InternalMegal.g:3848:1: rule__MegalRelationshipType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MegalRelationshipType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3852:1: ( ( RULE_ID ) )
            // InternalMegal.g:3853:1: ( RULE_ID )
            {
            // InternalMegal.g:3853:1: ( RULE_ID )
            // InternalMegal.g:3854:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__NameAssignment_1"


    // $ANTLR start "rule__MegalRelationshipType__LeftAssignment_3"
    // InternalMegal.g:3863:1: rule__MegalRelationshipType__LeftAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationshipType__LeftAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3867:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3868:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3868:1: ( ( RULE_ID ) )
            // InternalMegal.g:3869:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftMegalEntityTypeCrossReference_3_0()); 
            // InternalMegal.g:3870:1: ( RULE_ID )
            // InternalMegal.g:3871:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftMegalEntityTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftMegalEntityTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftMegalEntityTypeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__LeftAssignment_3"


    // $ANTLR start "rule__MegalRelationshipType__LeftParamsAssignment_4_1"
    // InternalMegal.g:3882:1: rule__MegalRelationshipType__LeftParamsAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationshipType__LeftParamsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3886:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3887:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3887:1: ( ( RULE_ID ) )
            // InternalMegal.g:3888:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityCrossReference_4_1_0()); 
            // InternalMegal.g:3889:1: ( RULE_ID )
            // InternalMegal.g:3890:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__LeftParamsAssignment_4_1"


    // $ANTLR start "rule__MegalRelationshipType__LeftParamsAssignment_4_2_1"
    // InternalMegal.g:3901:1: rule__MegalRelationshipType__LeftParamsAssignment_4_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationshipType__LeftParamsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3905:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3906:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3906:1: ( ( RULE_ID ) )
            // InternalMegal.g:3907:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityCrossReference_4_2_1_0()); 
            // InternalMegal.g:3908:1: ( RULE_ID )
            // InternalMegal.g:3909:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityIDTerminalRuleCall_4_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityIDTerminalRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__LeftParamsAssignment_4_2_1"


    // $ANTLR start "rule__MegalRelationshipType__LeftBothAssignment_5_0"
    // InternalMegal.g:3920:1: rule__MegalRelationshipType__LeftBothAssignment_5_0 : ( ( '(+)' ) ) ;
    public final void rule__MegalRelationshipType__LeftBothAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3924:1: ( ( ( '(+)' ) ) )
            // InternalMegal.g:3925:1: ( ( '(+)' ) )
            {
            // InternalMegal.g:3925:1: ( ( '(+)' ) )
            // InternalMegal.g:3926:1: ( '(+)' )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftBothLeftParenthesisPlusSignRightParenthesisKeyword_5_0_0()); 
            // InternalMegal.g:3927:1: ( '(+)' )
            // InternalMegal.g:3928:1: '(+)'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftBothLeftParenthesisPlusSignRightParenthesisKeyword_5_0_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftBothLeftParenthesisPlusSignRightParenthesisKeyword_5_0_0()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftBothLeftParenthesisPlusSignRightParenthesisKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__LeftBothAssignment_5_0"


    // $ANTLR start "rule__MegalRelationshipType__LeftManyAssignment_5_1"
    // InternalMegal.g:3943:1: rule__MegalRelationshipType__LeftManyAssignment_5_1 : ( ( '+' ) ) ;
    public final void rule__MegalRelationshipType__LeftManyAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3947:1: ( ( ( '+' ) ) )
            // InternalMegal.g:3948:1: ( ( '+' ) )
            {
            // InternalMegal.g:3948:1: ( ( '+' ) )
            // InternalMegal.g:3949:1: ( '+' )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftManyPlusSignKeyword_5_1_0()); 
            // InternalMegal.g:3950:1: ( '+' )
            // InternalMegal.g:3951:1: '+'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getLeftManyPlusSignKeyword_5_1_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftManyPlusSignKeyword_5_1_0()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getLeftManyPlusSignKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__LeftManyAssignment_5_1"


    // $ANTLR start "rule__MegalRelationshipType__RightAssignment_7"
    // InternalMegal.g:3966:1: rule__MegalRelationshipType__RightAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationshipType__RightAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3970:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3971:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3971:1: ( ( RULE_ID ) )
            // InternalMegal.g:3972:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightMegalEntityTypeCrossReference_7_0()); 
            // InternalMegal.g:3973:1: ( RULE_ID )
            // InternalMegal.g:3974:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightMegalEntityTypeIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightMegalEntityTypeIDTerminalRuleCall_7_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightMegalEntityTypeCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__RightAssignment_7"


    // $ANTLR start "rule__MegalRelationshipType__RightParamsAssignment_8_1"
    // InternalMegal.g:3985:1: rule__MegalRelationshipType__RightParamsAssignment_8_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationshipType__RightParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:3989:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:3990:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:3990:1: ( ( RULE_ID ) )
            // InternalMegal.g:3991:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityCrossReference_8_1_0()); 
            // InternalMegal.g:3992:1: ( RULE_ID )
            // InternalMegal.g:3993:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityIDTerminalRuleCall_8_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityIDTerminalRuleCall_8_1_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityCrossReference_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__RightParamsAssignment_8_1"


    // $ANTLR start "rule__MegalRelationshipType__RightParamsAssignment_8_2_1"
    // InternalMegal.g:4004:1: rule__MegalRelationshipType__RightParamsAssignment_8_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationshipType__RightParamsAssignment_8_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4008:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4009:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4009:1: ( ( RULE_ID ) )
            // InternalMegal.g:4010:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityCrossReference_8_2_1_0()); 
            // InternalMegal.g:4011:1: ( RULE_ID )
            // InternalMegal.g:4012:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityIDTerminalRuleCall_8_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityIDTerminalRuleCall_8_2_1_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityCrossReference_8_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__RightParamsAssignment_8_2_1"


    // $ANTLR start "rule__MegalRelationshipType__RightBothAssignment_9_0"
    // InternalMegal.g:4023:1: rule__MegalRelationshipType__RightBothAssignment_9_0 : ( ( '(+)' ) ) ;
    public final void rule__MegalRelationshipType__RightBothAssignment_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4027:1: ( ( ( '(+)' ) ) )
            // InternalMegal.g:4028:1: ( ( '(+)' ) )
            {
            // InternalMegal.g:4028:1: ( ( '(+)' ) )
            // InternalMegal.g:4029:1: ( '(+)' )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightBothLeftParenthesisPlusSignRightParenthesisKeyword_9_0_0()); 
            // InternalMegal.g:4030:1: ( '(+)' )
            // InternalMegal.g:4031:1: '(+)'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightBothLeftParenthesisPlusSignRightParenthesisKeyword_9_0_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightBothLeftParenthesisPlusSignRightParenthesisKeyword_9_0_0()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightBothLeftParenthesisPlusSignRightParenthesisKeyword_9_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__RightBothAssignment_9_0"


    // $ANTLR start "rule__MegalRelationshipType__RightManyAssignment_9_1"
    // InternalMegal.g:4046:1: rule__MegalRelationshipType__RightManyAssignment_9_1 : ( ( '+' ) ) ;
    public final void rule__MegalRelationshipType__RightManyAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4050:1: ( ( ( '+' ) ) )
            // InternalMegal.g:4051:1: ( ( '+' ) )
            {
            // InternalMegal.g:4051:1: ( ( '+' ) )
            // InternalMegal.g:4052:1: ( '+' )
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightManyPlusSignKeyword_9_1_0()); 
            // InternalMegal.g:4053:1: ( '+' )
            // InternalMegal.g:4054:1: '+'
            {
             before(grammarAccess.getMegalRelationshipTypeAccess().getRightManyPlusSignKeyword_9_1_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipTypeAccess().getRightManyPlusSignKeyword_9_1_0()); 

            }

             after(grammarAccess.getMegalRelationshipTypeAccess().getRightManyPlusSignKeyword_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationshipType__RightManyAssignment_9_1"


    // $ANTLR start "rule__MegalEntity__AnnotationsAssignment_0"
    // InternalMegal.g:4069:1: rule__MegalEntity__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalEntity__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4073:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:4074:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:4074:1: ( ruleMegalAnnotation )
            // InternalMegal.g:4075:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalEntityAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalEntityAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalEntity__NameAssignment_1"
    // InternalMegal.g:4084:1: rule__MegalEntity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MegalEntity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4088:1: ( ( RULE_ID ) )
            // InternalMegal.g:4089:1: ( RULE_ID )
            {
            // InternalMegal.g:4089:1: ( RULE_ID )
            // InternalMegal.g:4090:1: RULE_ID
            {
             before(grammarAccess.getMegalEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__NameAssignment_1"


    // $ANTLR start "rule__MegalEntity__TypeAssignment_3"
    // InternalMegal.g:4099:1: rule__MegalEntity__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MegalEntity__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4103:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4104:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4104:1: ( ( RULE_ID ) )
            // InternalMegal.g:4105:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalEntityAccess().getTypeMegalEntityTypeCrossReference_3_0()); 
            // InternalMegal.g:4106:1: ( RULE_ID )
            // InternalMegal.g:4107:1: RULE_ID
            {
             before(grammarAccess.getMegalEntityAccess().getTypeMegalEntityTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getTypeMegalEntityTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMegalEntityAccess().getTypeMegalEntityTypeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__TypeAssignment_3"


    // $ANTLR start "rule__MegalEntity__ParamsAssignment_4_1"
    // InternalMegal.g:4118:1: rule__MegalEntity__ParamsAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalEntity__ParamsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4122:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4123:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4123:1: ( ( RULE_ID ) )
            // InternalMegal.g:4124:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalEntityAccess().getParamsMegalEntityCrossReference_4_1_0()); 
            // InternalMegal.g:4125:1: ( RULE_ID )
            // InternalMegal.g:4126:1: RULE_ID
            {
             before(grammarAccess.getMegalEntityAccess().getParamsMegalEntityIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getParamsMegalEntityIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getMegalEntityAccess().getParamsMegalEntityCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__ParamsAssignment_4_1"


    // $ANTLR start "rule__MegalEntity__ParamsAssignment_4_2_1"
    // InternalMegal.g:4137:1: rule__MegalEntity__ParamsAssignment_4_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalEntity__ParamsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4141:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4142:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4142:1: ( ( RULE_ID ) )
            // InternalMegal.g:4143:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalEntityAccess().getParamsMegalEntityCrossReference_4_2_1_0()); 
            // InternalMegal.g:4144:1: ( RULE_ID )
            // InternalMegal.g:4145:1: RULE_ID
            {
             before(grammarAccess.getMegalEntityAccess().getParamsMegalEntityIDTerminalRuleCall_4_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getParamsMegalEntityIDTerminalRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getMegalEntityAccess().getParamsMegalEntityCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__ParamsAssignment_4_2_1"


    // $ANTLR start "rule__MegalEntity__ManyAssignment_5"
    // InternalMegal.g:4156:1: rule__MegalEntity__ManyAssignment_5 : ( ( '+' ) ) ;
    public final void rule__MegalEntity__ManyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4160:1: ( ( ( '+' ) ) )
            // InternalMegal.g:4161:1: ( ( '+' ) )
            {
            // InternalMegal.g:4161:1: ( ( '+' ) )
            // InternalMegal.g:4162:1: ( '+' )
            {
             before(grammarAccess.getMegalEntityAccess().getManyPlusSignKeyword_5_0()); 
            // InternalMegal.g:4163:1: ( '+' )
            // InternalMegal.g:4164:1: '+'
            {
             before(grammarAccess.getMegalEntityAccess().getManyPlusSignKeyword_5_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalEntityAccess().getManyPlusSignKeyword_5_0()); 

            }

             after(grammarAccess.getMegalEntityAccess().getManyPlusSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalEntity__ManyAssignment_5"


    // $ANTLR start "rule__MegalRelationship__AnnotationsAssignment_0"
    // InternalMegal.g:4179:1: rule__MegalRelationship__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalRelationship__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4183:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:4184:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:4184:1: ( ruleMegalAnnotation )
            // InternalMegal.g:4185:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalRelationshipAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalRelationshipAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalRelationship__LeftAssignment_1"
    // InternalMegal.g:4194:1: rule__MegalRelationship__LeftAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationship__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4198:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4199:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4199:1: ( ( RULE_ID ) )
            // InternalMegal.g:4200:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipAccess().getLeftMegalEntityCrossReference_1_0()); 
            // InternalMegal.g:4201:1: ( RULE_ID )
            // InternalMegal.g:4202:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipAccess().getLeftMegalEntityIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipAccess().getLeftMegalEntityIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipAccess().getLeftMegalEntityCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__LeftAssignment_1"


    // $ANTLR start "rule__MegalRelationship__TypeAssignment_2"
    // InternalMegal.g:4213:1: rule__MegalRelationship__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationship__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4217:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4218:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4218:1: ( ( RULE_ID ) )
            // InternalMegal.g:4219:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipAccess().getTypeMegalRelationshipTypeCrossReference_2_0()); 
            // InternalMegal.g:4220:1: ( RULE_ID )
            // InternalMegal.g:4221:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipAccess().getTypeMegalRelationshipTypeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipAccess().getTypeMegalRelationshipTypeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipAccess().getTypeMegalRelationshipTypeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__TypeAssignment_2"


    // $ANTLR start "rule__MegalRelationship__RightAssignment_3"
    // InternalMegal.g:4232:1: rule__MegalRelationship__RightAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MegalRelationship__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4236:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4237:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4237:1: ( ( RULE_ID ) )
            // InternalMegal.g:4238:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalRelationshipAccess().getRightMegalEntityCrossReference_3_0()); 
            // InternalMegal.g:4239:1: ( RULE_ID )
            // InternalMegal.g:4240:1: RULE_ID
            {
             before(grammarAccess.getMegalRelationshipAccess().getRightMegalEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalRelationshipAccess().getRightMegalEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMegalRelationshipAccess().getRightMegalEntityCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalRelationship__RightAssignment_3"


    // $ANTLR start "rule__MegalPair__AnnotationsAssignment_0"
    // InternalMegal.g:4251:1: rule__MegalPair__AnnotationsAssignment_0 : ( ruleMegalAnnotation ) ;
    public final void rule__MegalPair__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4255:1: ( ( ruleMegalAnnotation ) )
            // InternalMegal.g:4256:1: ( ruleMegalAnnotation )
            {
            // InternalMegal.g:4256:1: ( ruleMegalAnnotation )
            // InternalMegal.g:4257:1: ruleMegalAnnotation
            {
             before(grammarAccess.getMegalPairAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMegalAnnotation();

            state._fsp--;

             after(grammarAccess.getMegalPairAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__AnnotationsAssignment_0"


    // $ANTLR start "rule__MegalPair__SetAssignment_1"
    // InternalMegal.g:4266:1: rule__MegalPair__SetAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MegalPair__SetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4270:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4271:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4271:1: ( ( RULE_ID ) )
            // InternalMegal.g:4272:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalPairAccess().getSetMegalEntityCrossReference_1_0()); 
            // InternalMegal.g:4273:1: ( RULE_ID )
            // InternalMegal.g:4274:1: RULE_ID
            {
             before(grammarAccess.getMegalPairAccess().getSetMegalEntityIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalPairAccess().getSetMegalEntityIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMegalPairAccess().getSetMegalEntityCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__SetAssignment_1"


    // $ANTLR start "rule__MegalPair__FirstAssignment_3"
    // InternalMegal.g:4285:1: rule__MegalPair__FirstAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MegalPair__FirstAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4289:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4290:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4290:1: ( ( RULE_ID ) )
            // InternalMegal.g:4291:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalPairAccess().getFirstMegalEntityCrossReference_3_0()); 
            // InternalMegal.g:4292:1: ( RULE_ID )
            // InternalMegal.g:4293:1: RULE_ID
            {
             before(grammarAccess.getMegalPairAccess().getFirstMegalEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalPairAccess().getFirstMegalEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMegalPairAccess().getFirstMegalEntityCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__FirstAssignment_3"


    // $ANTLR start "rule__MegalPair__SecondAssignment_6"
    // InternalMegal.g:4304:1: rule__MegalPair__SecondAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__MegalPair__SecondAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4308:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4309:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4309:1: ( ( RULE_ID ) )
            // InternalMegal.g:4310:1: ( RULE_ID )
            {
             before(grammarAccess.getMegalPairAccess().getSecondMegalEntityCrossReference_6_0()); 
            // InternalMegal.g:4311:1: ( RULE_ID )
            // InternalMegal.g:4312:1: RULE_ID
            {
             before(grammarAccess.getMegalPairAccess().getSecondMegalEntityIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMegalPairAccess().getSecondMegalEntityIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getMegalPairAccess().getSecondMegalEntityCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MegalPair__SecondAssignment_6"


    // $ANTLR start "rule__Selection__SelectAssignment_0"
    // InternalMegal.g:4323:1: rule__Selection__SelectAssignment_0 : ( ruleQueryDefEntry ) ;
    public final void rule__Selection__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4327:1: ( ( ruleQueryDefEntry ) )
            // InternalMegal.g:4328:1: ( ruleQueryDefEntry )
            {
            // InternalMegal.g:4328:1: ( ruleQueryDefEntry )
            // InternalMegal.g:4329:1: ruleQueryDefEntry
            {
             before(grammarAccess.getSelectionAccess().getSelectQueryDefEntryParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQueryDefEntry();

            state._fsp--;

             after(grammarAccess.getSelectionAccess().getSelectQueryDefEntryParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__SelectAssignment_0"


    // $ANTLR start "rule__Selection__SelectAssignment_1_1"
    // InternalMegal.g:4338:1: rule__Selection__SelectAssignment_1_1 : ( ruleQueryDefEntry ) ;
    public final void rule__Selection__SelectAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4342:1: ( ( ruleQueryDefEntry ) )
            // InternalMegal.g:4343:1: ( ruleQueryDefEntry )
            {
            // InternalMegal.g:4343:1: ( ruleQueryDefEntry )
            // InternalMegal.g:4344:1: ruleQueryDefEntry
            {
             before(grammarAccess.getSelectionAccess().getSelectQueryDefEntryParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQueryDefEntry();

            state._fsp--;

             after(grammarAccess.getSelectionAccess().getSelectQueryDefEntryParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__SelectAssignment_1_1"


    // $ANTLR start "rule__Selection__QueryAssignment_2_2"
    // InternalMegal.g:4353:1: rule__Selection__QueryAssignment_2_2 : ( ruleQueryStatement ) ;
    public final void rule__Selection__QueryAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4357:1: ( ( ruleQueryStatement ) )
            // InternalMegal.g:4358:1: ( ruleQueryStatement )
            {
            // InternalMegal.g:4358:1: ( ruleQueryStatement )
            // InternalMegal.g:4359:1: ruleQueryStatement
            {
             before(grammarAccess.getSelectionAccess().getQueryQueryStatementParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQueryStatement();

            state._fsp--;

             after(grammarAccess.getSelectionAccess().getQueryQueryStatementParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__QueryAssignment_2_2"


    // $ANTLR start "rule__QueryStatement__SubjectAssignment_0"
    // InternalMegal.g:4368:1: rule__QueryStatement__SubjectAssignment_0 : ( ruleQueryRefEntry ) ;
    public final void rule__QueryStatement__SubjectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4372:1: ( ( ruleQueryRefEntry ) )
            // InternalMegal.g:4373:1: ( ruleQueryRefEntry )
            {
            // InternalMegal.g:4373:1: ( ruleQueryRefEntry )
            // InternalMegal.g:4374:1: ruleQueryRefEntry
            {
             before(grammarAccess.getQueryStatementAccess().getSubjectQueryRefEntryParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQueryRefEntry();

            state._fsp--;

             after(grammarAccess.getQueryStatementAccess().getSubjectQueryRefEntryParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__SubjectAssignment_0"


    // $ANTLR start "rule__QueryStatement__PredicateAssignment_1"
    // InternalMegal.g:4383:1: rule__QueryStatement__PredicateAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__QueryStatement__PredicateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4387:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4388:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4388:1: ( ( RULE_ID ) )
            // InternalMegal.g:4389:1: ( RULE_ID )
            {
             before(grammarAccess.getQueryStatementAccess().getPredicateMegalRelationshipTypeCrossReference_1_0()); 
            // InternalMegal.g:4390:1: ( RULE_ID )
            // InternalMegal.g:4391:1: RULE_ID
            {
             before(grammarAccess.getQueryStatementAccess().getPredicateMegalRelationshipTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryStatementAccess().getPredicateMegalRelationshipTypeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getQueryStatementAccess().getPredicateMegalRelationshipTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__PredicateAssignment_1"


    // $ANTLR start "rule__QueryStatement__ObjectAssignment_2"
    // InternalMegal.g:4402:1: rule__QueryStatement__ObjectAssignment_2 : ( ruleQueryRefEntry ) ;
    public final void rule__QueryStatement__ObjectAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4406:1: ( ( ruleQueryRefEntry ) )
            // InternalMegal.g:4407:1: ( ruleQueryRefEntry )
            {
            // InternalMegal.g:4407:1: ( ruleQueryRefEntry )
            // InternalMegal.g:4408:1: ruleQueryRefEntry
            {
             before(grammarAccess.getQueryStatementAccess().getObjectQueryRefEntryParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQueryRefEntry();

            state._fsp--;

             after(grammarAccess.getQueryStatementAccess().getObjectQueryRefEntryParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryStatement__ObjectAssignment_2"


    // $ANTLR start "rule__QueryParam__NameAssignment_0"
    // InternalMegal.g:4417:1: rule__QueryParam__NameAssignment_0 : ( RULE_VAR_ID ) ;
    public final void rule__QueryParam__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4421:1: ( ( RULE_VAR_ID ) )
            // InternalMegal.g:4422:1: ( RULE_VAR_ID )
            {
            // InternalMegal.g:4422:1: ( RULE_VAR_ID )
            // InternalMegal.g:4423:1: RULE_VAR_ID
            {
             before(grammarAccess.getQueryParamAccess().getNameVAR_IDTerminalRuleCall_0_0()); 
            match(input,RULE_VAR_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryParamAccess().getNameVAR_IDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__NameAssignment_0"


    // $ANTLR start "rule__QueryParam__TypeAssignment_1_1"
    // InternalMegal.g:4432:1: rule__QueryParam__TypeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__QueryParam__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4436:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4437:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4437:1: ( ( RULE_ID ) )
            // InternalMegal.g:4438:1: ( RULE_ID )
            {
             before(grammarAccess.getQueryParamAccess().getTypeMegalEntityTypeCrossReference_1_1_0()); 
            // InternalMegal.g:4439:1: ( RULE_ID )
            // InternalMegal.g:4440:1: RULE_ID
            {
             before(grammarAccess.getQueryParamAccess().getTypeMegalEntityTypeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryParamAccess().getTypeMegalEntityTypeIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getQueryParamAccess().getTypeMegalEntityTypeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryParam__TypeAssignment_1_1"


    // $ANTLR start "rule__QueryReference__RefAssignment"
    // InternalMegal.g:4451:1: rule__QueryReference__RefAssignment : ( ( RULE_VAR_ID ) ) ;
    public final void rule__QueryReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4455:1: ( ( ( RULE_VAR_ID ) ) )
            // InternalMegal.g:4456:1: ( ( RULE_VAR_ID ) )
            {
            // InternalMegal.g:4456:1: ( ( RULE_VAR_ID ) )
            // InternalMegal.g:4457:1: ( RULE_VAR_ID )
            {
             before(grammarAccess.getQueryReferenceAccess().getRefQueryParamCrossReference_0()); 
            // InternalMegal.g:4458:1: ( RULE_VAR_ID )
            // InternalMegal.g:4459:1: RULE_VAR_ID
            {
             before(grammarAccess.getQueryReferenceAccess().getRefQueryParamVAR_IDTerminalRuleCall_0_1()); 
            match(input,RULE_VAR_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryReferenceAccess().getRefQueryParamVAR_IDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getQueryReferenceAccess().getRefQueryParamCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryReference__RefAssignment"


    // $ANTLR start "rule__QueryString__ValueAssignment"
    // InternalMegal.g:4470:1: rule__QueryString__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__QueryString__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4474:1: ( ( RULE_STRING ) )
            // InternalMegal.g:4475:1: ( RULE_STRING )
            {
            // InternalMegal.g:4475:1: ( RULE_STRING )
            // InternalMegal.g:4476:1: RULE_STRING
            {
             before(grammarAccess.getQueryStringAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryStringAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryString__ValueAssignment"


    // $ANTLR start "rule__QueryEntity__EntityAssignment"
    // InternalMegal.g:4485:1: rule__QueryEntity__EntityAssignment : ( ( RULE_ID ) ) ;
    public final void rule__QueryEntity__EntityAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4489:1: ( ( ( RULE_ID ) ) )
            // InternalMegal.g:4490:1: ( ( RULE_ID ) )
            {
            // InternalMegal.g:4490:1: ( ( RULE_ID ) )
            // InternalMegal.g:4491:1: ( RULE_ID )
            {
             before(grammarAccess.getQueryEntityAccess().getEntityMegalEntityCrossReference_0()); 
            // InternalMegal.g:4492:1: ( RULE_ID )
            // InternalMegal.g:4493:1: RULE_ID
            {
             before(grammarAccess.getQueryEntityAccess().getEntityMegalEntityIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryEntityAccess().getEntityMegalEntityIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getQueryEntityAccess().getEntityMegalEntityCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryEntity__EntityAssignment"


    // $ANTLR start "rule__QueryPos__ValueAssignment_1"
    // InternalMegal.g:4504:1: rule__QueryPos__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__QueryPos__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalMegal.g:4508:1: ( ( RULE_INT ) )
            // InternalMegal.g:4509:1: ( RULE_INT )
            {
            // InternalMegal.g:4509:1: ( RULE_INT )
            // InternalMegal.g:4510:1: RULE_INT
            {
             before(grammarAccess.getQueryPosAccess().getValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQueryPosAccess().getValueINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryPos__ValueAssignment_1"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String dfa_1s = "\100\uffff";
    static final String dfa_2s = "\23\uffff\1\11\25\uffff\1\57\26\uffff";
    static final String dfa_3s = "\1\4\1\uffff\5\4\1\10\1\4\2\uffff\1\4\2\uffff\2\4\1\33\1\4\1\17\1\4\1\17\4\4\1\10\2\4\1\uffff\1\20\1\4\1\17\3\4\1\10\4\4\1\17\4\4\1\10\1\4\1\uffff\3\4\1\10\1\4\1\17\1\4\1\17\4\4\1\10\1\4\1\17\1\4";
    static final String dfa_4s = "\1\14\1\uffff\1\16\1\30\3\32\1\10\1\4\2\uffff\1\4\2\uffff\1\4\1\16\1\33\1\30\1\17\1\36\1\17\4\32\1\10\1\16\1\32\1\uffff\1\20\1\4\1\17\3\4\1\10\1\4\2\32\1\16\1\17\1\15\3\34\1\10\1\4\1\uffff\3\4\1\10\1\5\1\17\1\16\1\17\4\34\1\10\1\4\1\17\1\34";
    static final String dfa_5s = "\1\uffff\1\1\7\uffff\1\2\1\4\1\uffff\1\7\1\5\16\uffff\1\3\22\uffff\1\6\20\uffff";
    static final String dfa_6s = "\100\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\1\2\6\uffff\1\1",
            "",
            "\1\6\1\2\1\5\1\4\6\uffff\1\7",
            "\1\15\10\uffff\1\14\1\13\2\uffff\1\10\1\11\5\uffff\1\12",
            "\1\3\1\2\22\uffff\1\16\1\17\1\20",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "\1\21\1\2\7\uffff\1\14\1\13\2\uffff\1\10\1\11\5\uffff\1\12\1\17\1\20",
            "\1\22",
            "\1\23",
            "",
            "",
            "\1\24",
            "",
            "",
            "\1\25",
            "\1\30\1\uffff\1\27\1\26\6\uffff\1\31",
            "\1\32",
            "\1\15\10\uffff\1\14\1\13\2\uffff\1\10\1\11\5\uffff\1\12",
            "\1\33",
            "\2\11\6\uffff\1\11\7\uffff\2\34\7\uffff\2\34",
            "\1\35",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "\1\3\1\2\22\uffff\1\36\1\17\1\20",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "\1\37",
            "\1\42\1\uffff\1\41\1\40\6\uffff\1\43",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "\1\3\1\2\23\uffff\1\17\1\20",
            "\1\54\1\uffff\1\53\1\52\6\uffff\1\55",
            "\1\56",
            "\2\57\6\uffff\1\57\1\14",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\65",
            "\1\47",
            "",
            "\1\66",
            "\1\66",
            "\1\66",
            "\1\67",
            "\1\3\1\2",
            "\1\70",
            "\1\73\1\uffff\1\72\1\71\6\uffff\1\74",
            "\1\75",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64",
            "\1\76",
            "\1\66",
            "\1\77",
            "\1\62\1\uffff\1\61\1\60\6\uffff\1\63\15\uffff\1\64"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "536:1: rule__MegalFile__Alternatives_3 : ( ( ( rule__MegalFile__Group_3_0__0 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_1 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_2 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_3 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_4 ) ) | ( ( rule__MegalFile__DeclarationsAssignment_3_5 ) ) | ( ( rule__MegalFile__BindingsAssignment_3_6 ) ) );";
        }
    }
    static final String dfa_8s = "\12\uffff";
    static final String dfa_9s = "\1\3\1\uffff\1\1\2\uffff\1\3\1\1\1\uffff\1\3\1\1";
    static final String dfa_10s = "\1\4\1\uffff\1\4\1\uffff\6\4";
    static final String dfa_11s = "\1\16\1\uffff\1\32\1\uffff\1\30\1\14\2\30\1\14\1\30";
    static final String dfa_12s = "\1\uffff\1\1\1\uffff\1\2\6\uffff";
    static final String dfa_13s = "\12\uffff}>";
    static final String[] dfa_14s = {
            "\1\2\1\3\2\1\3\uffff\1\3\2\uffff\1\1",
            "",
            "\1\4\1\1\5\uffff\1\1\1\uffff\2\3\2\uffff\2\3\5\uffff\1\3\2\1",
            "",
            "\1\5\10\uffff\2\1\2\uffff\2\1\5\uffff\1\1",
            "\1\6\1\3\6\uffff\1\3",
            "\1\7\1\1\6\uffff\1\1\2\3\2\uffff\2\3\5\uffff\1\3",
            "\1\10\10\uffff\2\1\2\uffff\2\1\5\uffff\1\1",
            "\1\11\1\3\6\uffff\1\3",
            "\1\7\1\1\6\uffff\1\1\2\3\2\uffff\2\3\5\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "959:1: ( rule__MegalAnnotation__SelectionAssignment_1 )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001032L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000040D0L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000060300000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000060200000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040200000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00000000000040D2L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000100L});
    }


}