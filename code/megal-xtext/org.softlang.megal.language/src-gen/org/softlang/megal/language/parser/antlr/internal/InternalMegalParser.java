package org.softlang.megal.language.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.softlang.megal.language.services.MegalGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMegalParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ANN_ID", "RULE_STRING", "RULE_VAR_ID", "RULE_INT", "RULE_COMMENT", "RULE_WS", "'model'", "'import'", "'('", "')'", "'|->'", "'='", "'<'", "'as'", "'entity'", "'['", "'->'", "']'", "'(+)'", "'+'", "'*'", "':'", "','", "'from'", "'{'", "'}'"
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
     	
        public InternalMegalParser(TokenStream input, MegalGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MegalFile";	
       	}
       	
       	@Override
       	protected MegalGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMegalFile"
    // InternalMegal.g:67:1: entryRuleMegalFile returns [EObject current=null] : iv_ruleMegalFile= ruleMegalFile EOF ;
    public final EObject entryRuleMegalFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalFile = null;


        try {
            // InternalMegal.g:68:2: (iv_ruleMegalFile= ruleMegalFile EOF )
            // InternalMegal.g:69:2: iv_ruleMegalFile= ruleMegalFile EOF
            {
             newCompositeNode(grammarAccess.getMegalFileRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalFile=ruleMegalFile();

            state._fsp--;

             current =iv_ruleMegalFile; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalFile"


    // $ANTLR start "ruleMegalFile"
    // InternalMegal.g:76:1: ruleMegalFile returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )* ) ;
    public final EObject ruleMegalFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_declarations_5_0 = null;

        EObject lv_declarations_6_0 = null;

        EObject lv_declarations_7_0 = null;

        EObject lv_declarations_8_0 = null;

        EObject lv_declarations_9_0 = null;

        EObject lv_bindings_10_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:79:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )* ) )
            // InternalMegal.g:80:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )* )
            {
            // InternalMegal.g:80:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )* )
            // InternalMegal.g:80:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )*
            {
            // InternalMegal.g:80:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ANN_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMegal.g:81:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:81:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:82:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getMegalFileAccess().getModelKeyword_1());
                
            // InternalMegal.g:102:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalMegal.g:103:1: (lv_name_2_0= RULE_ID )
            {
            // InternalMegal.g:103:1: (lv_name_2_0= RULE_ID )
            // InternalMegal.g:104:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_name_2_0, grammarAccess.getMegalFileAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalFileRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.softlang.megal.language.Megal.ID");
            	    

            }


            }

            // InternalMegal.g:120:2: ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )*
            loop2:
            do {
                int alt2=8;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalMegal.g:120:3: (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) )
            	    {
            	    // InternalMegal.g:120:3: (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) )
            	    // InternalMegal.g:120:5: otherlv_3= 'import' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	        	newLeafNode(otherlv_3, grammarAccess.getMegalFileAccess().getImportKeyword_3_0_0());
            	        
            	    // InternalMegal.g:124:1: ( (otherlv_4= RULE_ID ) )
            	    // InternalMegal.g:125:1: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMegal.g:125:1: (otherlv_4= RULE_ID )
            	    // InternalMegal.g:126:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMegalFileRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            	    		newLeafNode(otherlv_4, grammarAccess.getMegalFileAccess().getImportsMegalFileCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMegal.g:138:6: ( (lv_declarations_5_0= ruleMegalEntityType ) )
            	    {
            	    // InternalMegal.g:138:6: ( (lv_declarations_5_0= ruleMegalEntityType ) )
            	    // InternalMegal.g:139:1: (lv_declarations_5_0= ruleMegalEntityType )
            	    {
            	    // InternalMegal.g:139:1: (lv_declarations_5_0= ruleMegalEntityType )
            	    // InternalMegal.g:140:3: lv_declarations_5_0= ruleMegalEntityType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getDeclarationsMegalEntityTypeParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_declarations_5_0=ruleMegalEntityType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_5_0, 
            	            		"org.softlang.megal.language.Megal.MegalEntityType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMegal.g:157:6: ( (lv_declarations_6_0= ruleMegalRelationshipType ) )
            	    {
            	    // InternalMegal.g:157:6: ( (lv_declarations_6_0= ruleMegalRelationshipType ) )
            	    // InternalMegal.g:158:1: (lv_declarations_6_0= ruleMegalRelationshipType )
            	    {
            	    // InternalMegal.g:158:1: (lv_declarations_6_0= ruleMegalRelationshipType )
            	    // InternalMegal.g:159:3: lv_declarations_6_0= ruleMegalRelationshipType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getDeclarationsMegalRelationshipTypeParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_declarations_6_0=ruleMegalRelationshipType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_6_0, 
            	            		"org.softlang.megal.language.Megal.MegalRelationshipType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalMegal.g:176:6: ( (lv_declarations_7_0= ruleMegalEntity ) )
            	    {
            	    // InternalMegal.g:176:6: ( (lv_declarations_7_0= ruleMegalEntity ) )
            	    // InternalMegal.g:177:1: (lv_declarations_7_0= ruleMegalEntity )
            	    {
            	    // InternalMegal.g:177:1: (lv_declarations_7_0= ruleMegalEntity )
            	    // InternalMegal.g:178:3: lv_declarations_7_0= ruleMegalEntity
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getDeclarationsMegalEntityParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_declarations_7_0=ruleMegalEntity();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_7_0, 
            	            		"org.softlang.megal.language.Megal.MegalEntity");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalMegal.g:195:6: ( (lv_declarations_8_0= ruleMegalRelationship ) )
            	    {
            	    // InternalMegal.g:195:6: ( (lv_declarations_8_0= ruleMegalRelationship ) )
            	    // InternalMegal.g:196:1: (lv_declarations_8_0= ruleMegalRelationship )
            	    {
            	    // InternalMegal.g:196:1: (lv_declarations_8_0= ruleMegalRelationship )
            	    // InternalMegal.g:197:3: lv_declarations_8_0= ruleMegalRelationship
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getDeclarationsMegalRelationshipParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_declarations_8_0=ruleMegalRelationship();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_8_0, 
            	            		"org.softlang.megal.language.Megal.MegalRelationship");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalMegal.g:214:6: ( (lv_declarations_9_0= ruleMegalPair ) )
            	    {
            	    // InternalMegal.g:214:6: ( (lv_declarations_9_0= ruleMegalPair ) )
            	    // InternalMegal.g:215:1: (lv_declarations_9_0= ruleMegalPair )
            	    {
            	    // InternalMegal.g:215:1: (lv_declarations_9_0= ruleMegalPair )
            	    // InternalMegal.g:216:3: lv_declarations_9_0= ruleMegalPair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getDeclarationsMegalPairParserRuleCall_3_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_declarations_9_0=ruleMegalPair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_9_0, 
            	            		"org.softlang.megal.language.Megal.MegalPair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalMegal.g:233:6: ( (lv_bindings_10_0= ruleMegalLink ) )
            	    {
            	    // InternalMegal.g:233:6: ( (lv_bindings_10_0= ruleMegalLink ) )
            	    // InternalMegal.g:234:1: (lv_bindings_10_0= ruleMegalLink )
            	    {
            	    // InternalMegal.g:234:1: (lv_bindings_10_0= ruleMegalLink )
            	    // InternalMegal.g:235:3: lv_bindings_10_0= ruleMegalLink
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalFileAccess().getBindingsMegalLinkParserRuleCall_3_6_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_bindings_10_0=ruleMegalLink();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_10_0, 
            	            		"org.softlang.megal.language.Megal.MegalLink");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalFile"


    // $ANTLR start "entryRuleMegalAnnotation"
    // InternalMegal.g:259:1: entryRuleMegalAnnotation returns [EObject current=null] : iv_ruleMegalAnnotation= ruleMegalAnnotation EOF ;
    public final EObject entryRuleMegalAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalAnnotation = null;


        try {
            // InternalMegal.g:260:2: (iv_ruleMegalAnnotation= ruleMegalAnnotation EOF )
            // InternalMegal.g:261:2: iv_ruleMegalAnnotation= ruleMegalAnnotation EOF
            {
             newCompositeNode(grammarAccess.getMegalAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalAnnotation=ruleMegalAnnotation();

            state._fsp--;

             current =iv_ruleMegalAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalAnnotation"


    // $ANTLR start "ruleMegalAnnotation"
    // InternalMegal.g:268:1: ruleMegalAnnotation returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ANN_ID ) ) ( (lv_selection_1_0= ruleSelection ) )? ) ;
    public final EObject ruleMegalAnnotation() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        EObject lv_selection_1_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:271:28: ( ( ( (lv_key_0_0= RULE_ANN_ID ) ) ( (lv_selection_1_0= ruleSelection ) )? ) )
            // InternalMegal.g:272:1: ( ( (lv_key_0_0= RULE_ANN_ID ) ) ( (lv_selection_1_0= ruleSelection ) )? )
            {
            // InternalMegal.g:272:1: ( ( (lv_key_0_0= RULE_ANN_ID ) ) ( (lv_selection_1_0= ruleSelection ) )? )
            // InternalMegal.g:272:2: ( (lv_key_0_0= RULE_ANN_ID ) ) ( (lv_selection_1_0= ruleSelection ) )?
            {
            // InternalMegal.g:272:2: ( (lv_key_0_0= RULE_ANN_ID ) )
            // InternalMegal.g:273:1: (lv_key_0_0= RULE_ANN_ID )
            {
            // InternalMegal.g:273:1: (lv_key_0_0= RULE_ANN_ID )
            // InternalMegal.g:274:3: lv_key_0_0= RULE_ANN_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ANN_ID,FollowSets000.FOLLOW_6); 

            			newLeafNode(lv_key_0_0, grammarAccess.getMegalAnnotationAccess().getKeyANN_IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalAnnotationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"org.softlang.megal.language.Megal.ANN_ID");
            	    

            }


            }

            // InternalMegal.g:290:2: ( (lv_selection_1_0= ruleSelection ) )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalMegal.g:291:1: (lv_selection_1_0= ruleSelection )
                    {
                    // InternalMegal.g:291:1: (lv_selection_1_0= ruleSelection )
                    // InternalMegal.g:292:3: lv_selection_1_0= ruleSelection
                    {
                     
                    	        newCompositeNode(grammarAccess.getMegalAnnotationAccess().getSelectionSelectionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_selection_1_0=ruleSelection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMegalAnnotationRule());
                    	        }
                           		set(
                           			current, 
                           			"selection",
                            		lv_selection_1_0, 
                            		"org.softlang.megal.language.Megal.Selection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalAnnotation"


    // $ANTLR start "entryRuleMegalLink"
    // InternalMegal.g:316:1: entryRuleMegalLink returns [EObject current=null] : iv_ruleMegalLink= ruleMegalLink EOF ;
    public final EObject entryRuleMegalLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalLink = null;


        try {
            // InternalMegal.g:317:2: (iv_ruleMegalLink= ruleMegalLink EOF )
            // InternalMegal.g:318:2: iv_ruleMegalLink= ruleMegalLink EOF
            {
             newCompositeNode(grammarAccess.getMegalLinkRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalLink=ruleMegalLink();

            state._fsp--;

             current =iv_ruleMegalLink; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalLink"


    // $ANTLR start "ruleMegalLink"
    // InternalMegal.g:325:1: ruleMegalLink returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '=' ( (lv_to_8_0= RULE_STRING ) ) ) ;
    public final EObject ruleMegalLink() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_to_8_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:328:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '=' ( (lv_to_8_0= RULE_STRING ) ) ) )
            // InternalMegal.g:329:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '=' ( (lv_to_8_0= RULE_STRING ) ) )
            {
            // InternalMegal.g:329:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '=' ( (lv_to_8_0= RULE_STRING ) ) )
            // InternalMegal.g:329:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '=' ( (lv_to_8_0= RULE_STRING ) )
            {
            // InternalMegal.g:329:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ANN_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMegal.g:330:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:330:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:331:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalLinkAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalLinkRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalMegal.g:347:3: ( (otherlv_1= RULE_ID ) )
            // InternalMegal.g:348:1: (otherlv_1= RULE_ID )
            {
            // InternalMegal.g:348:1: (otherlv_1= RULE_ID )
            // InternalMegal.g:349:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalLinkRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            		newLeafNode(otherlv_1, grammarAccess.getMegalLinkAccess().getLinkMegalEntityCrossReference_1_0()); 
            	

            }


            }

            // InternalMegal.g:360:2: (otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMegal.g:360:4: otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_2, grammarAccess.getMegalLinkAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalMegal.g:364:1: ( (otherlv_3= RULE_ID ) )
                    // InternalMegal.g:365:1: (otherlv_3= RULE_ID )
                    {
                    // InternalMegal.g:365:1: (otherlv_3= RULE_ID )
                    // InternalMegal.g:366:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalLinkRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    		newLeafNode(otherlv_3, grammarAccess.getMegalLinkAccess().getFirstMegalEntityCrossReference_2_1_0()); 
                    	

                    }


                    }

                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_4, grammarAccess.getMegalLinkAccess().getRightParenthesisKeyword_2_2());
                        
                    otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_5, grammarAccess.getMegalLinkAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_2_3());
                        
                    // InternalMegal.g:385:1: ( (otherlv_6= RULE_ID ) )
                    // InternalMegal.g:386:1: (otherlv_6= RULE_ID )
                    {
                    // InternalMegal.g:386:1: (otherlv_6= RULE_ID )
                    // InternalMegal.g:387:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalLinkRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

                    		newLeafNode(otherlv_6, grammarAccess.getMegalLinkAccess().getSecondMegalEntityCrossReference_2_4_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_12); 

                	newLeafNode(otherlv_7, grammarAccess.getMegalLinkAccess().getEqualsSignKeyword_3());
                
            // InternalMegal.g:402:1: ( (lv_to_8_0= RULE_STRING ) )
            // InternalMegal.g:403:1: (lv_to_8_0= RULE_STRING )
            {
            // InternalMegal.g:403:1: (lv_to_8_0= RULE_STRING )
            // InternalMegal.g:404:3: lv_to_8_0= RULE_STRING
            {
            lv_to_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_to_8_0, grammarAccess.getMegalLinkAccess().getToSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalLinkRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"to",
                    		lv_to_8_0, 
                    		"org.softlang.megal.language.Megal.STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalLink"


    // $ANTLR start "entryRuleMegalEntityType"
    // InternalMegal.g:428:1: entryRuleMegalEntityType returns [EObject current=null] : iv_ruleMegalEntityType= ruleMegalEntityType EOF ;
    public final EObject entryRuleMegalEntityType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalEntityType = null;


        try {
            // InternalMegal.g:429:2: (iv_ruleMegalEntityType= ruleMegalEntityType EOF )
            // InternalMegal.g:430:2: iv_ruleMegalEntityType= ruleMegalEntityType EOF
            {
             newCompositeNode(grammarAccess.getMegalEntityTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalEntityType=ruleMegalEntityType();

            state._fsp--;

             current =iv_ruleMegalEntityType; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalEntityType"


    // $ANTLR start "ruleMegalEntityType"
    // InternalMegal.g:437:1: ruleMegalEntityType returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'as' otherlv_5= 'entity' ) ) ) ;
    public final EObject ruleMegalEntityType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:440:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'as' otherlv_5= 'entity' ) ) ) )
            // InternalMegal.g:441:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'as' otherlv_5= 'entity' ) ) )
            {
            // InternalMegal.g:441:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'as' otherlv_5= 'entity' ) ) )
            // InternalMegal.g:441:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'as' otherlv_5= 'entity' ) )
            {
            // InternalMegal.g:441:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ANN_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMegal.g:442:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:442:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:443:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalEntityTypeAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalEntityTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalMegal.g:459:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMegal.g:460:1: (lv_name_1_0= RULE_ID )
            {
            // InternalMegal.g:460:1: (lv_name_1_0= RULE_ID )
            // InternalMegal.g:461:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMegalEntityTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalEntityTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.softlang.megal.language.Megal.ID");
            	    

            }


            }

            // InternalMegal.g:477:2: ( (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'as' otherlv_5= 'entity' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==18) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMegal.g:477:3: (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalMegal.g:477:3: (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )
                    // InternalMegal.g:477:5: otherlv_2= '<' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_2, grammarAccess.getMegalEntityTypeAccess().getLessThanSignKeyword_2_0_0());
                        
                    // InternalMegal.g:481:1: ( (otherlv_3= RULE_ID ) )
                    // InternalMegal.g:482:1: (otherlv_3= RULE_ID )
                    {
                    // InternalMegal.g:482:1: (otherlv_3= RULE_ID )
                    // InternalMegal.g:483:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalEntityTypeRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_3, grammarAccess.getMegalEntityTypeAccess().getSupertypeMegalEntityTypeCrossReference_2_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:495:6: (otherlv_4= 'as' otherlv_5= 'entity' )
                    {
                    // InternalMegal.g:495:6: (otherlv_4= 'as' otherlv_5= 'entity' )
                    // InternalMegal.g:495:8: otherlv_4= 'as' otherlv_5= 'entity'
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_14); 

                        	newLeafNode(otherlv_4, grammarAccess.getMegalEntityTypeAccess().getAsKeyword_2_1_0());
                        
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getMegalEntityTypeAccess().getEntityKeyword_2_1_1());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalEntityType"


    // $ANTLR start "entryRuleMegalRelationshipType"
    // InternalMegal.g:511:1: entryRuleMegalRelationshipType returns [EObject current=null] : iv_ruleMegalRelationshipType= ruleMegalRelationshipType EOF ;
    public final EObject entryRuleMegalRelationshipType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalRelationshipType = null;


        try {
            // InternalMegal.g:512:2: (iv_ruleMegalRelationshipType= ruleMegalRelationshipType EOF )
            // InternalMegal.g:513:2: iv_ruleMegalRelationshipType= ruleMegalRelationshipType EOF
            {
             newCompositeNode(grammarAccess.getMegalRelationshipTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalRelationshipType=ruleMegalRelationshipType();

            state._fsp--;

             current =iv_ruleMegalRelationshipType; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalRelationshipType"


    // $ANTLR start "ruleMegalRelationshipType"
    // InternalMegal.g:520:1: ruleMegalRelationshipType returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( ( (lv_leftBoth_9_0= '(+)' ) ) | ( (lv_leftMany_10_0= '+' ) ) )? otherlv_11= '*' ( (otherlv_12= RULE_ID ) ) (otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']' )? ( ( (lv_rightBoth_18_0= '(+)' ) ) | ( (lv_rightMany_19_0= '+' ) ) )? ) ;
    public final EObject ruleMegalRelationshipType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_leftBoth_9_0=null;
        Token lv_leftMany_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_rightBoth_18_0=null;
        Token lv_rightMany_19_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:523:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( ( (lv_leftBoth_9_0= '(+)' ) ) | ( (lv_leftMany_10_0= '+' ) ) )? otherlv_11= '*' ( (otherlv_12= RULE_ID ) ) (otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']' )? ( ( (lv_rightBoth_18_0= '(+)' ) ) | ( (lv_rightMany_19_0= '+' ) ) )? ) )
            // InternalMegal.g:524:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( ( (lv_leftBoth_9_0= '(+)' ) ) | ( (lv_leftMany_10_0= '+' ) ) )? otherlv_11= '*' ( (otherlv_12= RULE_ID ) ) (otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']' )? ( ( (lv_rightBoth_18_0= '(+)' ) ) | ( (lv_rightMany_19_0= '+' ) ) )? )
            {
            // InternalMegal.g:524:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( ( (lv_leftBoth_9_0= '(+)' ) ) | ( (lv_leftMany_10_0= '+' ) ) )? otherlv_11= '*' ( (otherlv_12= RULE_ID ) ) (otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']' )? ( ( (lv_rightBoth_18_0= '(+)' ) ) | ( (lv_rightMany_19_0= '+' ) ) )? )
            // InternalMegal.g:524:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( ( (lv_leftBoth_9_0= '(+)' ) ) | ( (lv_leftMany_10_0= '+' ) ) )? otherlv_11= '*' ( (otherlv_12= RULE_ID ) ) (otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']' )? ( ( (lv_rightBoth_18_0= '(+)' ) ) | ( (lv_rightMany_19_0= '+' ) ) )?
            {
            // InternalMegal.g:524:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ANN_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMegal.g:525:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:525:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:526:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalRelationshipTypeAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalRelationshipTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalMegal.g:542:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMegal.g:543:1: (lv_name_1_0= RULE_ID )
            {
            // InternalMegal.g:543:1: (lv_name_1_0= RULE_ID )
            // InternalMegal.g:544:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMegalRelationshipTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.softlang.megal.language.Megal.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getMegalRelationshipTypeAccess().getLessThanSignKeyword_2());
                
            // InternalMegal.g:564:1: ( (otherlv_3= RULE_ID ) )
            // InternalMegal.g:565:1: (otherlv_3= RULE_ID )
            {
            // InternalMegal.g:565:1: (otherlv_3= RULE_ID )
            // InternalMegal.g:566:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_16); 

            		newLeafNode(otherlv_3, grammarAccess.getMegalRelationshipTypeAccess().getLeftMegalEntityTypeCrossReference_3_0()); 
            	

            }


            }

            // InternalMegal.g:577:2: (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMegal.g:577:4: otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']'
                    {
                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_4, grammarAccess.getMegalRelationshipTypeAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // InternalMegal.g:581:1: ( (otherlv_5= RULE_ID ) )
                    // InternalMegal.g:582:1: (otherlv_5= RULE_ID )
                    {
                    // InternalMegal.g:582:1: (otherlv_5= RULE_ID )
                    // InternalMegal.g:583:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    		newLeafNode(otherlv_5, grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // InternalMegal.g:594:2: (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMegal.g:594:4: otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_4); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getMegalRelationshipTypeAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0());
                    	        
                    	    // InternalMegal.g:598:1: ( (otherlv_7= RULE_ID ) )
                    	    // InternalMegal.g:599:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalMegal.g:599:1: (otherlv_7= RULE_ID )
                    	    // InternalMegal.g:600:3: otherlv_7= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	    	        }
                    	            
                    	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    	    		newLeafNode(otherlv_7, grammarAccess.getMegalRelationshipTypeAccess().getLeftParamsMegalEntityCrossReference_4_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_18); 

                        	newLeafNode(otherlv_8, grammarAccess.getMegalRelationshipTypeAccess().getRightSquareBracketKeyword_4_3());
                        

                    }
                    break;

            }

            // InternalMegal.g:615:3: ( ( (lv_leftBoth_9_0= '(+)' ) ) | ( (lv_leftMany_10_0= '+' ) ) )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            switch (alt11) {
                case 1 :
                    // InternalMegal.g:615:4: ( (lv_leftBoth_9_0= '(+)' ) )
                    {
                    // InternalMegal.g:615:4: ( (lv_leftBoth_9_0= '(+)' ) )
                    // InternalMegal.g:616:1: (lv_leftBoth_9_0= '(+)' )
                    {
                    // InternalMegal.g:616:1: (lv_leftBoth_9_0= '(+)' )
                    // InternalMegal.g:617:3: lv_leftBoth_9_0= '(+)'
                    {
                    lv_leftBoth_9_0=(Token)match(input,23,FollowSets000.FOLLOW_19); 

                            newLeafNode(lv_leftBoth_9_0, grammarAccess.getMegalRelationshipTypeAccess().getLeftBothLeftParenthesisPlusSignRightParenthesisKeyword_5_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	        }
                           		setWithLastConsumed(current, "leftBoth", true, "(+)");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:631:6: ( (lv_leftMany_10_0= '+' ) )
                    {
                    // InternalMegal.g:631:6: ( (lv_leftMany_10_0= '+' ) )
                    // InternalMegal.g:632:1: (lv_leftMany_10_0= '+' )
                    {
                    // InternalMegal.g:632:1: (lv_leftMany_10_0= '+' )
                    // InternalMegal.g:633:3: lv_leftMany_10_0= '+'
                    {
                    lv_leftMany_10_0=(Token)match(input,24,FollowSets000.FOLLOW_19); 

                            newLeafNode(lv_leftMany_10_0, grammarAccess.getMegalRelationshipTypeAccess().getLeftManyPlusSignKeyword_5_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	        }
                           		setWithLastConsumed(current, "leftMany", true, "+");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_11, grammarAccess.getMegalRelationshipTypeAccess().getAsteriskKeyword_6());
                
            // InternalMegal.g:650:1: ( (otherlv_12= RULE_ID ) )
            // InternalMegal.g:651:1: (otherlv_12= RULE_ID )
            {
            // InternalMegal.g:651:1: (otherlv_12= RULE_ID )
            // InternalMegal.g:652:3: otherlv_12= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
            	        }
                    
            otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

            		newLeafNode(otherlv_12, grammarAccess.getMegalRelationshipTypeAccess().getRightMegalEntityTypeCrossReference_7_0()); 
            	

            }


            }

            // InternalMegal.g:663:2: (otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMegal.g:663:4: otherlv_13= '[' ( (otherlv_14= RULE_ID ) ) (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )* otherlv_17= ']'
                    {
                    otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_13, grammarAccess.getMegalRelationshipTypeAccess().getLeftSquareBracketKeyword_8_0());
                        
                    // InternalMegal.g:667:1: ( (otherlv_14= RULE_ID ) )
                    // InternalMegal.g:668:1: (otherlv_14= RULE_ID )
                    {
                    // InternalMegal.g:668:1: (otherlv_14= RULE_ID )
                    // InternalMegal.g:669:3: otherlv_14= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	        }
                            
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    		newLeafNode(otherlv_14, grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityCrossReference_8_1_0()); 
                    	

                    }


                    }

                    // InternalMegal.g:680:2: (otherlv_15= '->' ( (otherlv_16= RULE_ID ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalMegal.g:680:4: otherlv_15= '->' ( (otherlv_16= RULE_ID ) )
                    	    {
                    	    otherlv_15=(Token)match(input,21,FollowSets000.FOLLOW_4); 

                    	        	newLeafNode(otherlv_15, grammarAccess.getMegalRelationshipTypeAccess().getHyphenMinusGreaterThanSignKeyword_8_2_0());
                    	        
                    	    // InternalMegal.g:684:1: ( (otherlv_16= RULE_ID ) )
                    	    // InternalMegal.g:685:1: (otherlv_16= RULE_ID )
                    	    {
                    	    // InternalMegal.g:685:1: (otherlv_16= RULE_ID )
                    	    // InternalMegal.g:686:3: otherlv_16= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	    	        }
                    	            
                    	    otherlv_16=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    	    		newLeafNode(otherlv_16, grammarAccess.getMegalRelationshipTypeAccess().getRightParamsMegalEntityCrossReference_8_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,22,FollowSets000.FOLLOW_21); 

                        	newLeafNode(otherlv_17, grammarAccess.getMegalRelationshipTypeAccess().getRightSquareBracketKeyword_8_3());
                        

                    }
                    break;

            }

            // InternalMegal.g:701:3: ( ( (lv_rightBoth_18_0= '(+)' ) ) | ( (lv_rightMany_19_0= '+' ) ) )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            else if ( (LA14_0==24) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // InternalMegal.g:701:4: ( (lv_rightBoth_18_0= '(+)' ) )
                    {
                    // InternalMegal.g:701:4: ( (lv_rightBoth_18_0= '(+)' ) )
                    // InternalMegal.g:702:1: (lv_rightBoth_18_0= '(+)' )
                    {
                    // InternalMegal.g:702:1: (lv_rightBoth_18_0= '(+)' )
                    // InternalMegal.g:703:3: lv_rightBoth_18_0= '(+)'
                    {
                    lv_rightBoth_18_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_rightBoth_18_0, grammarAccess.getMegalRelationshipTypeAccess().getRightBothLeftParenthesisPlusSignRightParenthesisKeyword_9_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	        }
                           		setWithLastConsumed(current, "rightBoth", true, "(+)");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMegal.g:717:6: ( (lv_rightMany_19_0= '+' ) )
                    {
                    // InternalMegal.g:717:6: ( (lv_rightMany_19_0= '+' ) )
                    // InternalMegal.g:718:1: (lv_rightMany_19_0= '+' )
                    {
                    // InternalMegal.g:718:1: (lv_rightMany_19_0= '+' )
                    // InternalMegal.g:719:3: lv_rightMany_19_0= '+'
                    {
                    lv_rightMany_19_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_rightMany_19_0, grammarAccess.getMegalRelationshipTypeAccess().getRightManyPlusSignKeyword_9_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalRelationshipTypeRule());
                    	        }
                           		setWithLastConsumed(current, "rightMany", true, "+");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalRelationshipType"


    // $ANTLR start "entryRuleMegalEntity"
    // InternalMegal.g:740:1: entryRuleMegalEntity returns [EObject current=null] : iv_ruleMegalEntity= ruleMegalEntity EOF ;
    public final EObject entryRuleMegalEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalEntity = null;


        try {
            // InternalMegal.g:741:2: (iv_ruleMegalEntity= ruleMegalEntity EOF )
            // InternalMegal.g:742:2: iv_ruleMegalEntity= ruleMegalEntity EOF
            {
             newCompositeNode(grammarAccess.getMegalEntityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalEntity=ruleMegalEntity();

            state._fsp--;

             current =iv_ruleMegalEntity; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalEntity"


    // $ANTLR start "ruleMegalEntity"
    // InternalMegal.g:749:1: ruleMegalEntity returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( (lv_many_9_0= '+' ) )? ) ;
    public final EObject ruleMegalEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_many_9_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:752:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( (lv_many_9_0= '+' ) )? ) )
            // InternalMegal.g:753:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( (lv_many_9_0= '+' ) )? )
            {
            // InternalMegal.g:753:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( (lv_many_9_0= '+' ) )? )
            // InternalMegal.g:753:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )? ( (lv_many_9_0= '+' ) )?
            {
            // InternalMegal.g:753:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ANN_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMegal.g:754:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:754:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:755:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalEntityAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalEntityRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalMegal.g:771:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMegal.g:772:1: (lv_name_1_0= RULE_ID )
            {
            // InternalMegal.g:772:1: (lv_name_1_0= RULE_ID )
            // InternalMegal.g:773:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMegalEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalEntityRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.softlang.megal.language.Megal.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getMegalEntityAccess().getColonKeyword_2());
                
            // InternalMegal.g:793:1: ( (otherlv_3= RULE_ID ) )
            // InternalMegal.g:794:1: (otherlv_3= RULE_ID )
            {
            // InternalMegal.g:794:1: (otherlv_3= RULE_ID )
            // InternalMegal.g:795:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalEntityRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

            		newLeafNode(otherlv_3, grammarAccess.getMegalEntityAccess().getTypeMegalEntityTypeCrossReference_3_0()); 
            	

            }


            }

            // InternalMegal.g:806:2: (otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMegal.g:806:4: otherlv_4= '[' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ']'
                    {
                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_4, grammarAccess.getMegalEntityAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // InternalMegal.g:810:1: ( (otherlv_5= RULE_ID ) )
                    // InternalMegal.g:811:1: (otherlv_5= RULE_ID )
                    {
                    // InternalMegal.g:811:1: (otherlv_5= RULE_ID )
                    // InternalMegal.g:812:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalEntityRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    		newLeafNode(otherlv_5, grammarAccess.getMegalEntityAccess().getParamsMegalEntityCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // InternalMegal.g:823:2: (otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==21) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalMegal.g:823:4: otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_4); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getMegalEntityAccess().getHyphenMinusGreaterThanSignKeyword_4_2_0());
                    	        
                    	    // InternalMegal.g:827:1: ( (otherlv_7= RULE_ID ) )
                    	    // InternalMegal.g:828:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalMegal.g:828:1: (otherlv_7= RULE_ID )
                    	    // InternalMegal.g:829:3: otherlv_7= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getMegalEntityRule());
                    	    	        }
                    	            
                    	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

                    	    		newLeafNode(otherlv_7, grammarAccess.getMegalEntityAccess().getParamsMegalEntityCrossReference_4_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_24); 

                        	newLeafNode(otherlv_8, grammarAccess.getMegalEntityAccess().getRightSquareBracketKeyword_4_3());
                        

                    }
                    break;

            }

            // InternalMegal.g:844:3: ( (lv_many_9_0= '+' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMegal.g:845:1: (lv_many_9_0= '+' )
                    {
                    // InternalMegal.g:845:1: (lv_many_9_0= '+' )
                    // InternalMegal.g:846:3: lv_many_9_0= '+'
                    {
                    lv_many_9_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_many_9_0, grammarAccess.getMegalEntityAccess().getManyPlusSignKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMegalEntityRule());
                    	        }
                           		setWithLastConsumed(current, "many", true, "+");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalEntity"


    // $ANTLR start "entryRuleMegalRelationship"
    // InternalMegal.g:867:1: entryRuleMegalRelationship returns [EObject current=null] : iv_ruleMegalRelationship= ruleMegalRelationship EOF ;
    public final EObject entryRuleMegalRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalRelationship = null;


        try {
            // InternalMegal.g:868:2: (iv_ruleMegalRelationship= ruleMegalRelationship EOF )
            // InternalMegal.g:869:2: iv_ruleMegalRelationship= ruleMegalRelationship EOF
            {
             newCompositeNode(grammarAccess.getMegalRelationshipRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalRelationship=ruleMegalRelationship();

            state._fsp--;

             current =iv_ruleMegalRelationship; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalRelationship"


    // $ANTLR start "ruleMegalRelationship"
    // InternalMegal.g:876:1: ruleMegalRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleMegalRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:879:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) ) )
            // InternalMegal.g:880:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalMegal.g:880:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) )
            // InternalMegal.g:880:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ( (otherlv_3= RULE_ID ) )
            {
            // InternalMegal.g:880:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ANN_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMegal.g:881:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:881:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:882:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalRelationshipAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalRelationshipRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalMegal.g:898:3: ( (otherlv_1= RULE_ID ) )
            // InternalMegal.g:899:1: (otherlv_1= RULE_ID )
            {
            // InternalMegal.g:899:1: (otherlv_1= RULE_ID )
            // InternalMegal.g:900:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalRelationshipRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            		newLeafNode(otherlv_1, grammarAccess.getMegalRelationshipAccess().getLeftMegalEntityCrossReference_1_0()); 
            	

            }


            }

            // InternalMegal.g:911:2: ( (otherlv_2= RULE_ID ) )
            // InternalMegal.g:912:1: (otherlv_2= RULE_ID )
            {
            // InternalMegal.g:912:1: (otherlv_2= RULE_ID )
            // InternalMegal.g:913:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalRelationshipRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            		newLeafNode(otherlv_2, grammarAccess.getMegalRelationshipAccess().getTypeMegalRelationshipTypeCrossReference_2_0()); 
            	

            }


            }

            // InternalMegal.g:924:2: ( (otherlv_3= RULE_ID ) )
            // InternalMegal.g:925:1: (otherlv_3= RULE_ID )
            {
            // InternalMegal.g:925:1: (otherlv_3= RULE_ID )
            // InternalMegal.g:926:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalRelationshipRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getMegalRelationshipAccess().getRightMegalEntityCrossReference_3_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalRelationship"


    // $ANTLR start "entryRuleMegalPair"
    // InternalMegal.g:945:1: entryRuleMegalPair returns [EObject current=null] : iv_ruleMegalPair= ruleMegalPair EOF ;
    public final EObject entryRuleMegalPair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMegalPair = null;


        try {
            // InternalMegal.g:946:2: (iv_ruleMegalPair= ruleMegalPair EOF )
            // InternalMegal.g:947:2: iv_ruleMegalPair= ruleMegalPair EOF
            {
             newCompositeNode(grammarAccess.getMegalPairRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMegalPair=ruleMegalPair();

            state._fsp--;

             current =iv_ruleMegalPair; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMegalPair"


    // $ANTLR start "ruleMegalPair"
    // InternalMegal.g:954:1: ruleMegalPair returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleMegalPair() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:957:28: ( ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalMegal.g:958:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalMegal.g:958:1: ( ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) ) )
            // InternalMegal.g:958:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )* ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' otherlv_5= '|->' ( (otherlv_6= RULE_ID ) )
            {
            // InternalMegal.g:958:2: ( (lv_annotations_0_0= ruleMegalAnnotation ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ANN_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMegal.g:959:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    {
            	    // InternalMegal.g:959:1: (lv_annotations_0_0= ruleMegalAnnotation )
            	    // InternalMegal.g:960:3: lv_annotations_0_0= ruleMegalAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMegalPairAccess().getAnnotationsMegalAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_annotations_0_0=ruleMegalAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMegalPairRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.softlang.megal.language.Megal.MegalAnnotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalMegal.g:976:3: ( (otherlv_1= RULE_ID ) )
            // InternalMegal.g:977:1: (otherlv_1= RULE_ID )
            {
            // InternalMegal.g:977:1: (otherlv_1= RULE_ID )
            // InternalMegal.g:978:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalPairRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_25); 

            		newLeafNode(otherlv_1, grammarAccess.getMegalPairAccess().getSetMegalEntityCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getMegalPairAccess().getLeftParenthesisKeyword_2());
                
            // InternalMegal.g:993:1: ( (otherlv_3= RULE_ID ) )
            // InternalMegal.g:994:1: (otherlv_3= RULE_ID )
            {
            // InternalMegal.g:994:1: (otherlv_3= RULE_ID )
            // InternalMegal.g:995:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalPairRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		newLeafNode(otherlv_3, grammarAccess.getMegalPairAccess().getFirstMegalEntityCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_4, grammarAccess.getMegalPairAccess().getRightParenthesisKeyword_4());
                
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_5, grammarAccess.getMegalPairAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_5());
                
            // InternalMegal.g:1014:1: ( (otherlv_6= RULE_ID ) )
            // InternalMegal.g:1015:1: (otherlv_6= RULE_ID )
            {
            // InternalMegal.g:1015:1: (otherlv_6= RULE_ID )
            // InternalMegal.g:1016:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMegalPairRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_6, grammarAccess.getMegalPairAccess().getSecondMegalEntityCrossReference_6_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMegalPair"


    // $ANTLR start "entryRuleSelection"
    // InternalMegal.g:1035:1: entryRuleSelection returns [EObject current=null] : iv_ruleSelection= ruleSelection EOF ;
    public final EObject entryRuleSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelection = null;


        try {
            // InternalMegal.g:1036:2: (iv_ruleSelection= ruleSelection EOF )
            // InternalMegal.g:1037:2: iv_ruleSelection= ruleSelection EOF
            {
             newCompositeNode(grammarAccess.getSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelection=ruleSelection();

            state._fsp--;

             current =iv_ruleSelection; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelection"


    // $ANTLR start "ruleSelection"
    // InternalMegal.g:1044:1: ruleSelection returns [EObject current=null] : ( ( (lv_select_0_0= ruleQueryDefEntry ) ) (otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) ) )* (otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}' )? ) ;
    public final EObject ruleSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_select_0_0 = null;

        EObject lv_select_2_0 = null;

        EObject lv_query_5_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:1047:28: ( ( ( (lv_select_0_0= ruleQueryDefEntry ) ) (otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) ) )* (otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}' )? ) )
            // InternalMegal.g:1048:1: ( ( (lv_select_0_0= ruleQueryDefEntry ) ) (otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) ) )* (otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}' )? )
            {
            // InternalMegal.g:1048:1: ( ( (lv_select_0_0= ruleQueryDefEntry ) ) (otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) ) )* (otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}' )? )
            // InternalMegal.g:1048:2: ( (lv_select_0_0= ruleQueryDefEntry ) ) (otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) ) )* (otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}' )?
            {
            // InternalMegal.g:1048:2: ( (lv_select_0_0= ruleQueryDefEntry ) )
            // InternalMegal.g:1049:1: (lv_select_0_0= ruleQueryDefEntry )
            {
            // InternalMegal.g:1049:1: (lv_select_0_0= ruleQueryDefEntry )
            // InternalMegal.g:1050:3: lv_select_0_0= ruleQueryDefEntry
            {
             
            	        newCompositeNode(grammarAccess.getSelectionAccess().getSelectQueryDefEntryParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_26);
            lv_select_0_0=ruleQueryDefEntry();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectionRule());
            	        }
                   		add(
                   			current, 
                   			"select",
                    		lv_select_0_0, 
                    		"org.softlang.megal.language.Megal.QueryDefEntry");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalMegal.g:1066:2: (otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==27) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMegal.g:1066:4: otherlv_1= ',' ( (lv_select_2_0= ruleQueryDefEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27); 

            	        	newLeafNode(otherlv_1, grammarAccess.getSelectionAccess().getCommaKeyword_1_0());
            	        
            	    // InternalMegal.g:1070:1: ( (lv_select_2_0= ruleQueryDefEntry ) )
            	    // InternalMegal.g:1071:1: (lv_select_2_0= ruleQueryDefEntry )
            	    {
            	    // InternalMegal.g:1071:1: (lv_select_2_0= ruleQueryDefEntry )
            	    // InternalMegal.g:1072:3: lv_select_2_0= ruleQueryDefEntry
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectionAccess().getSelectQueryDefEntryParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    lv_select_2_0=ruleQueryDefEntry();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSelectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"select",
            	            		lv_select_2_0, 
            	            		"org.softlang.megal.language.Megal.QueryDefEntry");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalMegal.g:1088:4: (otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMegal.g:1088:6: otherlv_3= 'from' otherlv_4= '{' ( (lv_query_5_0= ruleQueryStatement ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28); 

                        	newLeafNode(otherlv_3, grammarAccess.getSelectionAccess().getFromKeyword_2_0());
                        
                    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_27); 

                        	newLeafNode(otherlv_4, grammarAccess.getSelectionAccess().getLeftCurlyBracketKeyword_2_1());
                        
                    // InternalMegal.g:1096:1: ( (lv_query_5_0= ruleQueryStatement ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID||(LA22_0>=RULE_STRING && LA22_0<=RULE_VAR_ID)||LA22_0==13) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalMegal.g:1097:1: (lv_query_5_0= ruleQueryStatement )
                    	    {
                    	    // InternalMegal.g:1097:1: (lv_query_5_0= ruleQueryStatement )
                    	    // InternalMegal.g:1098:3: lv_query_5_0= ruleQueryStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSelectionAccess().getQueryQueryStatementParserRuleCall_2_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_29);
                    	    lv_query_5_0=ruleQueryStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSelectionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"query",
                    	            		lv_query_5_0, 
                    	            		"org.softlang.megal.language.Megal.QueryStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    otherlv_6=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_6, grammarAccess.getSelectionAccess().getRightCurlyBracketKeyword_2_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelection"


    // $ANTLR start "entryRuleQueryStatement"
    // InternalMegal.g:1126:1: entryRuleQueryStatement returns [EObject current=null] : iv_ruleQueryStatement= ruleQueryStatement EOF ;
    public final EObject entryRuleQueryStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryStatement = null;


        try {
            // InternalMegal.g:1127:2: (iv_ruleQueryStatement= ruleQueryStatement EOF )
            // InternalMegal.g:1128:2: iv_ruleQueryStatement= ruleQueryStatement EOF
            {
             newCompositeNode(grammarAccess.getQueryStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryStatement=ruleQueryStatement();

            state._fsp--;

             current =iv_ruleQueryStatement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryStatement"


    // $ANTLR start "ruleQueryStatement"
    // InternalMegal.g:1135:1: ruleQueryStatement returns [EObject current=null] : ( ( (lv_subject_0_0= ruleQueryRefEntry ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_object_2_0= ruleQueryRefEntry ) ) ) ;
    public final EObject ruleQueryStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subject_0_0 = null;

        EObject lv_object_2_0 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:1138:28: ( ( ( (lv_subject_0_0= ruleQueryRefEntry ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_object_2_0= ruleQueryRefEntry ) ) ) )
            // InternalMegal.g:1139:1: ( ( (lv_subject_0_0= ruleQueryRefEntry ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_object_2_0= ruleQueryRefEntry ) ) )
            {
            // InternalMegal.g:1139:1: ( ( (lv_subject_0_0= ruleQueryRefEntry ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_object_2_0= ruleQueryRefEntry ) ) )
            // InternalMegal.g:1139:2: ( (lv_subject_0_0= ruleQueryRefEntry ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_object_2_0= ruleQueryRefEntry ) )
            {
            // InternalMegal.g:1139:2: ( (lv_subject_0_0= ruleQueryRefEntry ) )
            // InternalMegal.g:1140:1: (lv_subject_0_0= ruleQueryRefEntry )
            {
            // InternalMegal.g:1140:1: (lv_subject_0_0= ruleQueryRefEntry )
            // InternalMegal.g:1141:3: lv_subject_0_0= ruleQueryRefEntry
            {
             
            	        newCompositeNode(grammarAccess.getQueryStatementAccess().getSubjectQueryRefEntryParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_subject_0_0=ruleQueryRefEntry();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryStatementRule());
            	        }
                   		set(
                   			current, 
                   			"subject",
                    		lv_subject_0_0, 
                    		"org.softlang.megal.language.Megal.QueryRefEntry");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalMegal.g:1157:2: ( (otherlv_1= RULE_ID ) )
            // InternalMegal.g:1158:1: (otherlv_1= RULE_ID )
            {
            // InternalMegal.g:1158:1: (otherlv_1= RULE_ID )
            // InternalMegal.g:1159:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryStatementRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

            		newLeafNode(otherlv_1, grammarAccess.getQueryStatementAccess().getPredicateMegalRelationshipTypeCrossReference_1_0()); 
            	

            }


            }

            // InternalMegal.g:1170:2: ( (lv_object_2_0= ruleQueryRefEntry ) )
            // InternalMegal.g:1171:1: (lv_object_2_0= ruleQueryRefEntry )
            {
            // InternalMegal.g:1171:1: (lv_object_2_0= ruleQueryRefEntry )
            // InternalMegal.g:1172:3: lv_object_2_0= ruleQueryRefEntry
            {
             
            	        newCompositeNode(grammarAccess.getQueryStatementAccess().getObjectQueryRefEntryParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_object_2_0=ruleQueryRefEntry();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryStatementRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_2_0, 
                    		"org.softlang.megal.language.Megal.QueryRefEntry");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryStatement"


    // $ANTLR start "entryRuleQueryDefEntry"
    // InternalMegal.g:1196:1: entryRuleQueryDefEntry returns [EObject current=null] : iv_ruleQueryDefEntry= ruleQueryDefEntry EOF ;
    public final EObject entryRuleQueryDefEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDefEntry = null;


        try {
            // InternalMegal.g:1197:2: (iv_ruleQueryDefEntry= ruleQueryDefEntry EOF )
            // InternalMegal.g:1198:2: iv_ruleQueryDefEntry= ruleQueryDefEntry EOF
            {
             newCompositeNode(grammarAccess.getQueryDefEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryDefEntry=ruleQueryDefEntry();

            state._fsp--;

             current =iv_ruleQueryDefEntry; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryDefEntry"


    // $ANTLR start "ruleQueryDefEntry"
    // InternalMegal.g:1205:1: ruleQueryDefEntry returns [EObject current=null] : (this_QueryParam_0= ruleQueryParam | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos ) ;
    public final EObject ruleQueryDefEntry() throws RecognitionException {
        EObject current = null;

        EObject this_QueryParam_0 = null;

        EObject this_QueryString_1 = null;

        EObject this_QueryEntity_2 = null;

        EObject this_QueryPos_3 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:1208:28: ( (this_QueryParam_0= ruleQueryParam | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos ) )
            // InternalMegal.g:1209:1: (this_QueryParam_0= ruleQueryParam | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos )
            {
            // InternalMegal.g:1209:1: (this_QueryParam_0= ruleQueryParam | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos )
            int alt24=4;
            switch ( input.LA(1) ) {
            case RULE_VAR_ID:
                {
                alt24=1;
                }
                break;
            case RULE_STRING:
                {
                alt24=2;
                }
                break;
            case RULE_ID:
                {
                alt24=3;
                }
                break;
            case 13:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalMegal.g:1210:5: this_QueryParam_0= ruleQueryParam
                    {
                     
                            newCompositeNode(grammarAccess.getQueryDefEntryAccess().getQueryParamParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryParam_0=ruleQueryParam();

                    state._fsp--;

                     
                            current = this_QueryParam_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalMegal.g:1220:5: this_QueryString_1= ruleQueryString
                    {
                     
                            newCompositeNode(grammarAccess.getQueryDefEntryAccess().getQueryStringParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryString_1=ruleQueryString();

                    state._fsp--;

                     
                            current = this_QueryString_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalMegal.g:1230:5: this_QueryEntity_2= ruleQueryEntity
                    {
                     
                            newCompositeNode(grammarAccess.getQueryDefEntryAccess().getQueryEntityParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryEntity_2=ruleQueryEntity();

                    state._fsp--;

                     
                            current = this_QueryEntity_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalMegal.g:1240:5: this_QueryPos_3= ruleQueryPos
                    {
                     
                            newCompositeNode(grammarAccess.getQueryDefEntryAccess().getQueryPosParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryPos_3=ruleQueryPos();

                    state._fsp--;

                     
                            current = this_QueryPos_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryDefEntry"


    // $ANTLR start "entryRuleQueryRefEntry"
    // InternalMegal.g:1256:1: entryRuleQueryRefEntry returns [EObject current=null] : iv_ruleQueryRefEntry= ruleQueryRefEntry EOF ;
    public final EObject entryRuleQueryRefEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryRefEntry = null;


        try {
            // InternalMegal.g:1257:2: (iv_ruleQueryRefEntry= ruleQueryRefEntry EOF )
            // InternalMegal.g:1258:2: iv_ruleQueryRefEntry= ruleQueryRefEntry EOF
            {
             newCompositeNode(grammarAccess.getQueryRefEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryRefEntry=ruleQueryRefEntry();

            state._fsp--;

             current =iv_ruleQueryRefEntry; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryRefEntry"


    // $ANTLR start "ruleQueryRefEntry"
    // InternalMegal.g:1265:1: ruleQueryRefEntry returns [EObject current=null] : (this_QueryReference_0= ruleQueryReference | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos ) ;
    public final EObject ruleQueryRefEntry() throws RecognitionException {
        EObject current = null;

        EObject this_QueryReference_0 = null;

        EObject this_QueryString_1 = null;

        EObject this_QueryEntity_2 = null;

        EObject this_QueryPos_3 = null;


         enterRule(); 
            
        try {
            // InternalMegal.g:1268:28: ( (this_QueryReference_0= ruleQueryReference | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos ) )
            // InternalMegal.g:1269:1: (this_QueryReference_0= ruleQueryReference | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos )
            {
            // InternalMegal.g:1269:1: (this_QueryReference_0= ruleQueryReference | this_QueryString_1= ruleQueryString | this_QueryEntity_2= ruleQueryEntity | this_QueryPos_3= ruleQueryPos )
            int alt25=4;
            switch ( input.LA(1) ) {
            case RULE_VAR_ID:
                {
                alt25=1;
                }
                break;
            case RULE_STRING:
                {
                alt25=2;
                }
                break;
            case RULE_ID:
                {
                alt25=3;
                }
                break;
            case 13:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalMegal.g:1270:5: this_QueryReference_0= ruleQueryReference
                    {
                     
                            newCompositeNode(grammarAccess.getQueryRefEntryAccess().getQueryReferenceParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryReference_0=ruleQueryReference();

                    state._fsp--;

                     
                            current = this_QueryReference_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalMegal.g:1280:5: this_QueryString_1= ruleQueryString
                    {
                     
                            newCompositeNode(grammarAccess.getQueryRefEntryAccess().getQueryStringParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryString_1=ruleQueryString();

                    state._fsp--;

                     
                            current = this_QueryString_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalMegal.g:1290:5: this_QueryEntity_2= ruleQueryEntity
                    {
                     
                            newCompositeNode(grammarAccess.getQueryRefEntryAccess().getQueryEntityParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryEntity_2=ruleQueryEntity();

                    state._fsp--;

                     
                            current = this_QueryEntity_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalMegal.g:1300:5: this_QueryPos_3= ruleQueryPos
                    {
                     
                            newCompositeNode(grammarAccess.getQueryRefEntryAccess().getQueryPosParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QueryPos_3=ruleQueryPos();

                    state._fsp--;

                     
                            current = this_QueryPos_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryRefEntry"


    // $ANTLR start "entryRuleQueryParam"
    // InternalMegal.g:1316:1: entryRuleQueryParam returns [EObject current=null] : iv_ruleQueryParam= ruleQueryParam EOF ;
    public final EObject entryRuleQueryParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryParam = null;


        try {
            // InternalMegal.g:1317:2: (iv_ruleQueryParam= ruleQueryParam EOF )
            // InternalMegal.g:1318:2: iv_ruleQueryParam= ruleQueryParam EOF
            {
             newCompositeNode(grammarAccess.getQueryParamRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryParam=ruleQueryParam();

            state._fsp--;

             current =iv_ruleQueryParam; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryParam"


    // $ANTLR start "ruleQueryParam"
    // InternalMegal.g:1325:1: ruleQueryParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_VAR_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleQueryParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalMegal.g:1328:28: ( ( ( (lv_name_0_0= RULE_VAR_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )? ) )
            // InternalMegal.g:1329:1: ( ( (lv_name_0_0= RULE_VAR_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // InternalMegal.g:1329:1: ( ( (lv_name_0_0= RULE_VAR_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )? )
            // InternalMegal.g:1329:2: ( (lv_name_0_0= RULE_VAR_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )?
            {
            // InternalMegal.g:1329:2: ( (lv_name_0_0= RULE_VAR_ID ) )
            // InternalMegal.g:1330:1: (lv_name_0_0= RULE_VAR_ID )
            {
            // InternalMegal.g:1330:1: (lv_name_0_0= RULE_VAR_ID )
            // InternalMegal.g:1331:3: lv_name_0_0= RULE_VAR_ID
            {
            lv_name_0_0=(Token)match(input,RULE_VAR_ID,FollowSets000.FOLLOW_30); 

            			newLeafNode(lv_name_0_0, grammarAccess.getQueryParamAccess().getNameVAR_IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryParamRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.softlang.megal.language.Megal.VAR_ID");
            	    

            }


            }

            // InternalMegal.g:1347:2: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMegal.g:1347:4: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_1, grammarAccess.getQueryParamAccess().getColonKeyword_1_0());
                        
                    // InternalMegal.g:1351:1: ( (otherlv_2= RULE_ID ) )
                    // InternalMegal.g:1352:1: (otherlv_2= RULE_ID )
                    {
                    // InternalMegal.g:1352:1: (otherlv_2= RULE_ID )
                    // InternalMegal.g:1353:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryParamRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_2, grammarAccess.getQueryParamAccess().getTypeMegalEntityTypeCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryParam"


    // $ANTLR start "entryRuleQueryReference"
    // InternalMegal.g:1372:1: entryRuleQueryReference returns [EObject current=null] : iv_ruleQueryReference= ruleQueryReference EOF ;
    public final EObject entryRuleQueryReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryReference = null;


        try {
            // InternalMegal.g:1373:2: (iv_ruleQueryReference= ruleQueryReference EOF )
            // InternalMegal.g:1374:2: iv_ruleQueryReference= ruleQueryReference EOF
            {
             newCompositeNode(grammarAccess.getQueryReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryReference=ruleQueryReference();

            state._fsp--;

             current =iv_ruleQueryReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryReference"


    // $ANTLR start "ruleQueryReference"
    // InternalMegal.g:1381:1: ruleQueryReference returns [EObject current=null] : ( (otherlv_0= RULE_VAR_ID ) ) ;
    public final EObject ruleQueryReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalMegal.g:1384:28: ( ( (otherlv_0= RULE_VAR_ID ) ) )
            // InternalMegal.g:1385:1: ( (otherlv_0= RULE_VAR_ID ) )
            {
            // InternalMegal.g:1385:1: ( (otherlv_0= RULE_VAR_ID ) )
            // InternalMegal.g:1386:1: (otherlv_0= RULE_VAR_ID )
            {
            // InternalMegal.g:1386:1: (otherlv_0= RULE_VAR_ID )
            // InternalMegal.g:1387:3: otherlv_0= RULE_VAR_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryReferenceRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_VAR_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getQueryReferenceAccess().getRefQueryParamCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryReference"


    // $ANTLR start "entryRuleQueryString"
    // InternalMegal.g:1406:1: entryRuleQueryString returns [EObject current=null] : iv_ruleQueryString= ruleQueryString EOF ;
    public final EObject entryRuleQueryString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryString = null;


        try {
            // InternalMegal.g:1407:2: (iv_ruleQueryString= ruleQueryString EOF )
            // InternalMegal.g:1408:2: iv_ruleQueryString= ruleQueryString EOF
            {
             newCompositeNode(grammarAccess.getQueryStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryString=ruleQueryString();

            state._fsp--;

             current =iv_ruleQueryString; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryString"


    // $ANTLR start "ruleQueryString"
    // InternalMegal.g:1415:1: ruleQueryString returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleQueryString() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalMegal.g:1418:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalMegal.g:1419:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalMegal.g:1419:1: ( (lv_value_0_0= RULE_STRING ) )
            // InternalMegal.g:1420:1: (lv_value_0_0= RULE_STRING )
            {
            // InternalMegal.g:1420:1: (lv_value_0_0= RULE_STRING )
            // InternalMegal.g:1421:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getQueryStringAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryStringRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.softlang.megal.language.Megal.STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryString"


    // $ANTLR start "entryRuleQueryEntity"
    // InternalMegal.g:1445:1: entryRuleQueryEntity returns [EObject current=null] : iv_ruleQueryEntity= ruleQueryEntity EOF ;
    public final EObject entryRuleQueryEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryEntity = null;


        try {
            // InternalMegal.g:1446:2: (iv_ruleQueryEntity= ruleQueryEntity EOF )
            // InternalMegal.g:1447:2: iv_ruleQueryEntity= ruleQueryEntity EOF
            {
             newCompositeNode(grammarAccess.getQueryEntityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryEntity=ruleQueryEntity();

            state._fsp--;

             current =iv_ruleQueryEntity; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryEntity"


    // $ANTLR start "ruleQueryEntity"
    // InternalMegal.g:1454:1: ruleQueryEntity returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleQueryEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalMegal.g:1457:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalMegal.g:1458:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalMegal.g:1458:1: ( (otherlv_0= RULE_ID ) )
            // InternalMegal.g:1459:1: (otherlv_0= RULE_ID )
            {
            // InternalMegal.g:1459:1: (otherlv_0= RULE_ID )
            // InternalMegal.g:1460:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryEntityRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getQueryEntityAccess().getEntityMegalEntityCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryEntity"


    // $ANTLR start "entryRuleQueryPos"
    // InternalMegal.g:1479:1: entryRuleQueryPos returns [EObject current=null] : iv_ruleQueryPos= ruleQueryPos EOF ;
    public final EObject entryRuleQueryPos() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryPos = null;


        try {
            // InternalMegal.g:1480:2: (iv_ruleQueryPos= ruleQueryPos EOF )
            // InternalMegal.g:1481:2: iv_ruleQueryPos= ruleQueryPos EOF
            {
             newCompositeNode(grammarAccess.getQueryPosRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryPos=ruleQueryPos();

            state._fsp--;

             current =iv_ruleQueryPos; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryPos"


    // $ANTLR start "ruleQueryPos"
    // InternalMegal.g:1488:1: ruleQueryPos returns [EObject current=null] : (otherlv_0= '(' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= ')' ) ;
    public final EObject ruleQueryPos() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalMegal.g:1491:28: ( (otherlv_0= '(' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= ')' ) )
            // InternalMegal.g:1492:1: (otherlv_0= '(' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= ')' )
            {
            // InternalMegal.g:1492:1: (otherlv_0= '(' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= ')' )
            // InternalMegal.g:1492:3: otherlv_0= '(' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_31); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryPosAccess().getLeftParenthesisKeyword_0());
                
            // InternalMegal.g:1496:1: ( (lv_value_1_0= RULE_INT ) )
            // InternalMegal.g:1497:1: (lv_value_1_0= RULE_INT )
            {
            // InternalMegal.g:1497:1: (lv_value_1_0= RULE_INT )
            // InternalMegal.g:1498:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_value_1_0, grammarAccess.getQueryPosAccess().getValueINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryPosRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.softlang.megal.language.Megal.INT");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryPosAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryPos"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\64\uffff";
    static final String dfa_2s = "\1\1\24\uffff\1\13\24\uffff\1\60\11\uffff";
    static final String dfa_3s = "\1\4\2\uffff\5\4\1\10\2\4\4\uffff\2\4\1\35\1\4\2\16\5\4\1\10\2\4\1\17\1\uffff\1\4\1\16\3\4\1\10\4\4\1\16\4\4\1\10\1\4\1\uffff\1\4\1\16\1\4";
    static final String dfa_4s = "\1\14\2\uffff\1\15\1\32\3\34\1\10\2\4\4\uffff\1\4\1\15\1\35\1\32\2\16\1\31\4\34\1\10\1\15\1\34\1\17\1\uffff\1\4\1\16\3\4\1\10\1\4\2\34\1\15\1\16\1\20\3\36\1\10\1\4\1\uffff\1\5\1\16\1\36";
    static final String dfa_5s = "\1\uffff\1\10\1\1\10\uffff\1\2\1\4\1\7\1\5\17\uffff\1\3\21\uffff\1\6\3\uffff";
    static final String dfa_6s = "\64\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\1\3\6\uffff\1\2",
            "",
            "",
            "\1\7\1\3\1\6\1\5\5\uffff\1\10",
            "\1\16\10\uffff\1\11\2\uffff\1\15\1\12\1\13\7\uffff\1\14",
            "\1\4\1\3\24\uffff\1\17\1\20\1\21",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\22\1\3\7\uffff\1\11\2\uffff\1\15\1\12\1\13\7\uffff\1\14\1\20\1\21",
            "\1\23",
            "\1\24",
            "\1\25",
            "",
            "",
            "",
            "",
            "\1\26",
            "\1\31\1\uffff\1\30\1\27\5\uffff\1\32",
            "\1\33",
            "\1\16\10\uffff\1\11\2\uffff\1\15\1\12\1\13\7\uffff\1\14",
            "\1\34",
            "\1\35",
            "\2\13\6\uffff\1\13\7\uffff\1\36\2\uffff\3\36",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\4\1\3\24\uffff\1\37\1\20\1\21",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\40",
            "\1\43\1\uffff\1\42\1\41\5\uffff\1\44",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\45",
            "",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\50",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\4\1\3\25\uffff\1\20\1\21",
            "\1\55\1\uffff\1\54\1\53\5\uffff\1\56",
            "\1\57",
            "\2\60\6\uffff\1\60\3\uffff\1\15",
            "\1\43\1\uffff\1\42\1\41\5\uffff\1\44\20\uffff\1\61",
            "\1\43\1\uffff\1\42\1\41\5\uffff\1\44\20\uffff\1\61",
            "\1\43\1\uffff\1\42\1\41\5\uffff\1\44\20\uffff\1\61",
            "\1\62",
            "\1\50",
            "",
            "\1\4\1\3",
            "\1\63",
            "\1\43\1\uffff\1\42\1\41\5\uffff\1\44\20\uffff\1\61"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 120:2: ( (otherlv_3= 'import' ( (otherlv_4= RULE_ID ) ) ) | ( (lv_declarations_5_0= ruleMegalEntityType ) ) | ( (lv_declarations_6_0= ruleMegalRelationshipType ) ) | ( (lv_declarations_7_0= ruleMegalEntity ) ) | ( (lv_declarations_8_0= ruleMegalRelationship ) ) | ( (lv_declarations_9_0= ruleMegalPair ) ) | ( (lv_bindings_10_0= ruleMegalLink ) ) )*";
        }
    }
    static final String dfa_8s = "\12\uffff";
    static final String dfa_9s = "\1\3\1\uffff\1\1\2\uffff\1\3\1\1\1\uffff\1\3\1\1";
    static final String dfa_10s = "\1\4\1\uffff\1\4\1\uffff\6\4";
    static final String dfa_11s = "\1\15\1\uffff\1\34\1\uffff\1\32\1\14\2\32\1\14\1\32";
    static final String dfa_12s = "\1\uffff\1\1\1\uffff\1\2\6\uffff";
    static final String dfa_13s = "\12\uffff}>";
    static final String[] dfa_14s = {
            "\1\2\1\3\2\1\3\uffff\1\3\1\uffff\1\1",
            "",
            "\1\4\1\1\5\uffff\1\1\1\uffff\1\3\2\uffff\3\3\7\uffff\1\3\2\1",
            "",
            "\1\5\10\uffff\1\1\2\uffff\3\1\7\uffff\1\1",
            "\1\6\1\3\6\uffff\1\3",
            "\1\7\1\1\6\uffff\1\1\1\3\2\uffff\3\3\7\uffff\1\3",
            "\1\10\10\uffff\1\1\2\uffff\3\1\7\uffff\1\1",
            "\1\11\1\3\6\uffff\1\3",
            "\1\7\1\1\6\uffff\1\1\1\3\2\uffff\3\3\7\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "290:2: ( (lv_selection_1_0= ruleSelection ) )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001832L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000020D2L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000830L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003900000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000003800000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001900002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001800002L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001100002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000018000002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000000000020D0L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000400020D0L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000100L});
    }


}