package org.softlang.megal.language.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMegalLexer extends Lexer {
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

    public InternalMegalLexer() {;} 
    public InternalMegalLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMegalLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMegal.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:11:7: ( 'model' )
            // InternalMegal.g:11:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:12:7: ( 'import' )
            // InternalMegal.g:12:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:13:7: ( '(' )
            // InternalMegal.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:14:7: ( ')' )
            // InternalMegal.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:15:7: ( '|->' )
            // InternalMegal.g:15:9: '|->'
            {
            match("|->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:16:7: ( '=' )
            // InternalMegal.g:16:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:17:7: ( '<' )
            // InternalMegal.g:17:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:18:7: ( 'as' )
            // InternalMegal.g:18:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:19:7: ( 'entity' )
            // InternalMegal.g:19:9: 'entity'
            {
            match("entity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:20:7: ( '[' )
            // InternalMegal.g:20:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:21:7: ( '->' )
            // InternalMegal.g:21:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:22:7: ( ']' )
            // InternalMegal.g:22:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:23:7: ( '(+)' )
            // InternalMegal.g:23:9: '(+)'
            {
            match("(+)"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:24:7: ( '+' )
            // InternalMegal.g:24:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:25:7: ( '*' )
            // InternalMegal.g:25:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:26:7: ( ':' )
            // InternalMegal.g:26:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:27:7: ( ',' )
            // InternalMegal.g:27:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:28:7: ( 'from' )
            // InternalMegal.g:28:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:29:7: ( '{' )
            // InternalMegal.g:29:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:30:7: ( '}' )
            // InternalMegal.g:30:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1525:10: ( '1' .. '9' ( '0' .. '9' )* )
            // InternalMegal.g:1525:12: '1' .. '9' ( '0' .. '9' )*
            {
            matchRange('1','9'); 
            // InternalMegal.g:1525:21: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMegal.g:1525:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ANN_ID"
    public final void mRULE_ANN_ID() throws RecognitionException {
        try {
            int _type = RULE_ANN_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1527:13: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )* )
            // InternalMegal.g:1527:15: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )*
            {
            match('@'); 
            // InternalMegal.g:1527:19: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMegal.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalMegal.g:1527:53: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='.') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMegal.g:1527:54: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // InternalMegal.g:1527:58: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalMegal.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANN_ID"

    // $ANTLR start "RULE_VAR_ID"
    public final void mRULE_VAR_ID() throws RecognitionException {
        try {
            int _type = RULE_VAR_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1529:13: ( '?' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )* )
            // InternalMegal.g:1529:15: '?' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )*
            {
            match('?'); 
            // InternalMegal.g:1529:19: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMegal.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // InternalMegal.g:1529:53: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='.') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMegal.g:1529:54: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // InternalMegal.g:1529:58: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalMegal.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VAR_ID"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1531:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )* )
            // InternalMegal.g:1531:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )*
            {
            // InternalMegal.g:1531:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMegal.g:1531:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            // InternalMegal.g:1531:16: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMegal.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // InternalMegal.g:1531:50: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+ )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='.') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMegal.g:1531:51: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // InternalMegal.g:1531:55: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalMegal.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1533:13: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalMegal.g:1533:15: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalMegal.g:1533:20: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\\') ) {
                    alt12=1;
                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMegal.g:1533:21: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalMegal.g:1533:28: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_COMMENT"
    public final void mRULE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1535:14: ( ( '/*' ( options {greedy=false; } : . )* '*/' | '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? ) )
            // InternalMegal.g:1535:16: ( '/*' ( options {greedy=false; } : . )* '*/' | '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            {
            // InternalMegal.g:1535:16: ( '/*' ( options {greedy=false; } : . )* '*/' | '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='/') ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1=='*') ) {
                    alt17=1;
                }
                else if ( (LA17_1=='/') ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMegal.g:1535:17: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // InternalMegal.g:1535:22: ( options {greedy=false; } : . )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='*') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='/') ) {
                                alt13=2;
                            }
                            else if ( ((LA13_1>='\u0000' && LA13_1<='.')||(LA13_1>='0' && LA13_1<='\uFFFF')) ) {
                                alt13=1;
                            }


                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<=')')||(LA13_0>='+' && LA13_0<='\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMegal.g:1535:50: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match("*/"); 


                    }
                    break;
                case 2 :
                    // InternalMegal.g:1535:59: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
                    {
                    match("//"); 

                    // InternalMegal.g:1535:64: (~ ( ( '\\n' | '\\r' ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalMegal.g:1535:64: ~ ( ( '\\n' | '\\r' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // InternalMegal.g:1535:80: ( ( '\\r' )? '\\n' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\n'||LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalMegal.g:1535:81: ( '\\r' )? '\\n'
                            {
                            // InternalMegal.g:1535:81: ( '\\r' )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='\r') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // InternalMegal.g:1535:81: '\\r'
                                    {
                                    match('\r'); 

                                    }
                                    break;

                            }

                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMegal.g:1537:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMegal.g:1537:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMegal.g:1537:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMegal.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // InternalMegal.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | RULE_INT | RULE_ANN_ID | RULE_VAR_ID | RULE_ID | RULE_STRING | RULE_COMMENT | RULE_WS )
        int alt19=27;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // InternalMegal.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // InternalMegal.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // InternalMegal.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // InternalMegal.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // InternalMegal.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // InternalMegal.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // InternalMegal.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // InternalMegal.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // InternalMegal.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // InternalMegal.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // InternalMegal.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // InternalMegal.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // InternalMegal.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // InternalMegal.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // InternalMegal.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // InternalMegal.g:1:100: T__26
                {
                mT__26(); 

                }
                break;
            case 17 :
                // InternalMegal.g:1:106: T__27
                {
                mT__27(); 

                }
                break;
            case 18 :
                // InternalMegal.g:1:112: T__28
                {
                mT__28(); 

                }
                break;
            case 19 :
                // InternalMegal.g:1:118: T__29
                {
                mT__29(); 

                }
                break;
            case 20 :
                // InternalMegal.g:1:124: T__30
                {
                mT__30(); 

                }
                break;
            case 21 :
                // InternalMegal.g:1:130: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 22 :
                // InternalMegal.g:1:139: RULE_ANN_ID
                {
                mRULE_ANN_ID(); 

                }
                break;
            case 23 :
                // InternalMegal.g:1:151: RULE_VAR_ID
                {
                mRULE_VAR_ID(); 

                }
                break;
            case 24 :
                // InternalMegal.g:1:163: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // InternalMegal.g:1:171: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // InternalMegal.g:1:183: RULE_COMMENT
                {
                mRULE_COMMENT(); 

                }
                break;
            case 27 :
                // InternalMegal.g:1:196: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\2\27\1\36\4\uffff\2\27\7\uffff\1\27\2\uffff\1\42\6\uffff\2\27\2\uffff\1\46\2\27\1\uffff\1\42\2\27\1\uffff\5\27\1\60\1\61\2\27\2\uffff\1\64\1\65\2\uffff";
    static final String DFA19_eofS =
        "\66\uffff";
    static final String DFA19_minS =
        "\1\11\1\157\1\155\1\53\4\uffff\1\163\1\156\7\uffff\1\162\2\uffff\1\56\6\uffff\1\144\1\160\2\uffff\1\56\1\164\1\157\1\uffff\1\56\1\145\1\157\1\uffff\1\151\1\155\1\154\1\162\1\164\2\56\1\164\1\171\2\uffff\2\56\2\uffff";
    static final String DFA19_maxS =
        "\1\175\1\157\1\155\1\53\4\uffff\1\163\1\156\7\uffff\1\162\2\uffff\1\172\6\uffff\1\144\1\160\2\uffff\1\172\1\164\1\157\1\uffff\1\172\1\145\1\157\1\uffff\1\151\1\155\1\154\1\162\1\164\2\172\1\164\1\171\2\uffff\2\172\2\uffff";
    static final String DFA19_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\2\uffff\1\12\1\13\1\14\1\16\1\17\1\20\1\21\1\uffff\1\23\1\24\1\uffff\1\26\1\27\1\30\1\31\1\32\1\33\2\uffff\1\15\1\3\3\uffff\1\25\3\uffff\1\10\11\uffff\1\22\1\1\2\uffff\1\2\1\11";
    static final String DFA19_specialS =
        "\66\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\32\2\uffff\1\32\22\uffff\1\32\6\uffff\1\30\1\3\1\4\1\16\1\15\1\20\1\13\1\uffff\1\31\1\27\11\24\1\17\1\uffff\1\7\1\6\1\uffff\1\26\1\25\32\27\1\12\1\uffff\1\14\2\27\1\uffff\1\10\3\27\1\11\1\21\2\27\1\2\3\27\1\1\15\27\1\22\1\5\1\23",
            "\1\33",
            "\1\34",
            "\1\35",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41",
            "",
            "",
            "\1\27\1\uffff\12\43\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\44",
            "\1\45",
            "",
            "",
            "\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\47",
            "\1\50",
            "",
            "\1\27\1\uffff\12\43\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\51",
            "\1\52",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\62",
            "\1\63",
            "",
            "",
            "\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | RULE_INT | RULE_ANN_ID | RULE_VAR_ID | RULE_ID | RULE_STRING | RULE_COMMENT | RULE_WS );";
        }
    }
 

}