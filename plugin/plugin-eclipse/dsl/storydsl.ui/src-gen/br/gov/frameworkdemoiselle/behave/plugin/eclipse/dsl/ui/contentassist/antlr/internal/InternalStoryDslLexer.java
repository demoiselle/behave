package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryDslLexer extends Lexer {
    public static final int RULE_ID=10;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_NL=6;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_EXID=5;
    public static final int RULE_INT=7;
    public static final int RULE_WS=8;

    // delegates
    // delegators

    public InternalStoryDslLexer() {;} 
    public InternalStoryDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalStoryDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:11:7: ( '@' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:11:9: '@'
            {
            match('@'); 

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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:12:7: ( '@ ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:12:9: '@ '
            {
            match("@ "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:13:7: ( 'Dado ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:13:9: 'Dado '
            {
            match("Dado "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:14:7: ( 'Quando ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:14:9: 'Quando '
            {
            match("Quando "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:15:7: ( 'Ent\\u00E3o ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:15:9: 'Ent\\u00E3o '
            {
            match("Ent\u00E3o "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:16:7: ( 'E ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:16:9: 'E '
            {
            match("E "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:17:7: ( 'Mas ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:17:9: 'Mas '
            {
            match("Mas "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:18:7: ( '|' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:18:9: '|'
            {
            match('|'); 

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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:19:7: ( '| ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:19:9: '| '
            {
            match("| "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:20:7: ( ' |' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:20:9: ' |'
            {
            match(" |"); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:21:7: ( 'Como um: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:21:9: 'Como um: '
            {
            match("Como um: "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:22:7: ( 'Eu quero: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:22:9: 'Eu quero: '
            {
            match("Eu quero: "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:23:7: ( 'De modo que: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:23:9: 'De modo que: '
            {
            match("De modo que: "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:24:7: ( 'Funcionalidade: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:24:9: 'Funcionalidade: '
            {
            match("Funcionalidade: "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:25:7: ( 'Cen\\u00E1rio: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:25:9: 'Cen\\u00E1rio: '
            {
            match("Cen\u00E1rio: "); 


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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:26:7: ( ' ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:26:9: ' '
            {
            match(' '); 

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
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:27:7: ( 'Meta:' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:27:9: 'Meta:'
            {
            match("Meta:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' | '\",' | '\".' | '\\';' ) | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | '\\',' | '\\'.' | '\\';' ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' | '\",' | '\".' | '\\';' ) | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | '\\',' | '\\'.' | '\\';' ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' | '\",' | '\".' | '\\';' ) | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | '\\',' | '\\'.' | '\\';' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' | '\",' | '\".' | '\\';' )
                    {
                    match('\"'); 
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop1:
                    do {
                        int alt1=3;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='\'') ) {
                            int LA1_2 = input.LA(2);

                            if ( (LA1_2==';') ) {
                                int LA1_5 = input.LA(3);

                                if ( ((LA1_5>='\u0000' && LA1_5<='\uFFFF')) ) {
                                    alt1=2;
                                }


                            }
                            else if ( ((LA1_2>='\u0000' && LA1_2<=':')||(LA1_2>='<' && LA1_2<='\uFFFF')) ) {
                                alt1=2;
                            }


                        }
                        else if ( (LA1_0=='\\') ) {
                            alt1=1;
                        }
                        else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                            alt1=2;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:82: ( '\"' | '\",' | '\".' | '\\';' )
                    int alt2=4;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\"') ) {
                        switch ( input.LA(2) ) {
                        case ',':
                            {
                            alt2=2;
                            }
                            break;
                        case '.':
                            {
                            alt2=3;
                            }
                            break;
                        default:
                            alt2=1;}

                    }
                    else if ( (LA2_0=='\'') ) {
                        alt2=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:83: '\"'
                            {
                            match('\"'); 

                            }
                            break;
                        case 2 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:87: '\",'
                            {
                            match("\","); 


                            }
                            break;
                        case 3 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:92: '\".'
                            {
                            match("\"."); 


                            }
                            break;
                        case 4 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:97: '\\';'
                            {
                            match("';"); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:104: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | '\\',' | '\\'.' | '\\';' )
                    {
                    match('\''); 
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:109: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:110: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:155: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop3;
                        }
                    } while (true);

                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:172: ( '\\'' | '\\',' | '\\'.' | '\\';' )
                    int alt4=4;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\'') ) {
                        switch ( input.LA(2) ) {
                        case ',':
                            {
                            alt4=2;
                            }
                            break;
                        case '.':
                            {
                            alt4=3;
                            }
                            break;
                        case ';':
                            {
                            alt4=4;
                            }
                            break;
                        default:
                            alt4=1;}

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:173: '\\''
                            {
                            match('\''); 

                            }
                            break;
                        case 2 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:178: '\\','
                            {
                            match("',"); 


                            }
                            break;
                        case 3 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:184: '\\'.'
                            {
                            match("'."); 


                            }
                            break;
                        case 4 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2250:190: '\\';'
                            {
                            match("';"); 


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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2252:10: ( '\\u00B3' '0' .. '9' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2252:12: '\\u00B3' '0' .. '9'
            {
            match('\u00B3'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_EXID"
    public final void mRULE_EXID() throws RecognitionException {
        try {
            int _type = RULE_EXID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2254:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | ',' | '(' | ')' | '-' | '/' | '_' | ':' | '\\u00B2' | '\\u00B3' | '\\u00E0' | '\\u00E1' | '\\u00E2' | '\\u00E3' | '\\u00E9' | '\\u00EA' | '\\u00ED' | '\\u00F3' | '\\u00F4' | '\\u00F5' | '\\u00FA' | '\\u00FC' | '\\u00E7' | '\\u00C0' | '\\u00C1' | '\\u00C2' | '\\u00C3' | '\\u00C9' | '\\u00CA' | '\\u00CD' | '\\u00D3' | '\\u00D4' | '\\u00D5' | '\\u00DA' | '\\u00DC' | '\\u00C7' )+ )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2254:13: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | ',' | '(' | ')' | '-' | '/' | '_' | ':' | '\\u00B2' | '\\u00B3' | '\\u00E0' | '\\u00E1' | '\\u00E2' | '\\u00E3' | '\\u00E9' | '\\u00EA' | '\\u00ED' | '\\u00F3' | '\\u00F4' | '\\u00F5' | '\\u00FA' | '\\u00FC' | '\\u00E7' | '\\u00C0' | '\\u00C1' | '\\u00C2' | '\\u00C3' | '\\u00C9' | '\\u00CA' | '\\u00CD' | '\\u00D3' | '\\u00D4' | '\\u00D5' | '\\u00DA' | '\\u00DC' | '\\u00C7' )+
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2254:13: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | ',' | '(' | ')' | '-' | '/' | '_' | ':' | '\\u00B2' | '\\u00B3' | '\\u00E0' | '\\u00E1' | '\\u00E2' | '\\u00E3' | '\\u00E9' | '\\u00EA' | '\\u00ED' | '\\u00F3' | '\\u00F4' | '\\u00F5' | '\\u00FA' | '\\u00FC' | '\\u00E7' | '\\u00C0' | '\\u00C1' | '\\u00C2' | '\\u00C3' | '\\u00C9' | '\\u00CA' | '\\u00CD' | '\\u00D3' | '\\u00D4' | '\\u00D5' | '\\u00DA' | '\\u00DC' | '\\u00C7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='(' && LA6_0<=')')||(LA6_0>=',' && LA6_0<=':')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00B2' && LA6_0<='\u00B3')||(LA6_0>='\u00C0' && LA6_0<='\u00C3')||LA6_0=='\u00C7'||(LA6_0>='\u00C9' && LA6_0<='\u00CA')||LA6_0=='\u00CD'||(LA6_0>='\u00D3' && LA6_0<='\u00D5')||LA6_0=='\u00DA'||LA6_0=='\u00DC'||(LA6_0>='\u00E0' && LA6_0<='\u00E3')||LA6_0=='\u00E7'||(LA6_0>='\u00E9' && LA6_0<='\u00EA')||LA6_0=='\u00ED'||(LA6_0>='\u00F3' && LA6_0<='\u00F5')||LA6_0=='\u00FA'||LA6_0=='\u00FC') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:
            	    {
            	    if ( (input.LA(1)>='(' && input.LA(1)<=')')||(input.LA(1)>=',' && input.LA(1)<=':')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00B2' && input.LA(1)<='\u00B3')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00C3')||input.LA(1)=='\u00C7'||(input.LA(1)>='\u00C9' && input.LA(1)<='\u00CA')||input.LA(1)=='\u00CD'||(input.LA(1)>='\u00D3' && input.LA(1)<='\u00D5')||input.LA(1)=='\u00DA'||input.LA(1)=='\u00DC'||(input.LA(1)>='\u00E0' && input.LA(1)<='\u00E3')||input.LA(1)=='\u00E7'||(input.LA(1)>='\u00E9' && input.LA(1)<='\u00EA')||input.LA(1)=='\u00ED'||(input.LA(1)>='\u00F3' && input.LA(1)<='\u00F5')||input.LA(1)=='\u00FA'||input.LA(1)=='\u00FC' ) {
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXID"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2256:9: ( ( '\\n' | '\\r' )+ )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2256:11: ( '\\n' | '\\r' )+
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2256:11: ( '\\n' | '\\r' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2258:9: ( ( '\\t' | ' ' )+ )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2258:11: ( '\\t' | ' ' )+
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2258:11: ( '\\t' | ' ' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2260:17: ( '/**/' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2260:19: '/**/'
            {
            match("/**/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2262:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2262:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2262:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2262:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2262:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:
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
            	    break loop10;
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

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop11;
                }
            } while (true);

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:41: ( '\\r' )? '\\n'
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2264:41: '\\r'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2266:16: ( . )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2266:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | RULE_STRING | RULE_INT | RULE_EXID | RULE_NL | RULE_WS | RULE_ML_COMMENT | RULE_ID | RULE_SL_COMMENT | RULE_ANY_OTHER )
        int alt14=26;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:112: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 19 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:124: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 20 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:133: RULE_EXID
                {
                mRULE_EXID(); 

                }
                break;
            case 21 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:143: RULE_NL
                {
                mRULE_NL(); 

                }
                break;
            case 22 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:151: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 23 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:159: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 24 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:175: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:183: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 26 :
                // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1:199: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\25\4\31\1\41\1\43\2\31\2\23\2\31\2\uffff\1\31\1\23\4"+
        "\uffff\3\31\1\uffff\2\31\1\uffff\3\31\5\uffff\3\31\1\uffff\1\70"+
        "\1\uffff\1\31\2\uffff\1\31\1\uffff\2\31\1\uffff\5\31\1\uffff\1\31"+
        "\1\uffff\3\31\1\uffff\4\31\1\uffff\2\31\1\114\1\uffff\3\31\2\uffff"+
        "\2\31\1\uffff\4\31\1\uffff\7\31\1\uffff";
    static final String DFA14_eofS =
        "\135\uffff";
    static final String DFA14_minS =
        "\1\0\1\40\2\60\1\40\1\60\1\40\1\11\2\60\2\0\1\60\1\52\2\uffff\1"+
        "\60\1\101\4\uffff\1\60\1\40\1\60\1\uffff\2\60\1\uffff\1\40\2\60"+
        "\5\uffff\3\60\1\uffff\1\50\1\uffff\1\0\2\uffff\1\60\1\uffff\2\60"+
        "\1\uffff\1\40\4\60\1\uffff\1\0\1\uffff\1\40\1\60\1\157\1\uffff\1"+
        "\60\1\40\1\162\1\60\1\uffff\1\60\1\40\1\50\1\uffff\1\151\1\60\1"+
        "\40\2\uffff\1\157\1\60\1\uffff\1\72\1\60\1\40\1\60\1\uffff\6\60"+
        "\1\40\1\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\40\4\172\1\40\1\174\2\172\2\uffff\1\71\1\57\2\uffff\2"+
        "\172\4\uffff\3\172\1\uffff\2\172\1\uffff\3\172\5\uffff\3\172\1\uffff"+
        "\1\u00fc\1\uffff\1\uffff\2\uffff\1\172\1\uffff\1\172\1\u00e3\1\uffff"+
        "\3\172\1\u00e1\1\172\1\uffff\1\uffff\1\uffff\2\172\1\157\1\uffff"+
        "\2\172\1\162\1\172\1\uffff\1\172\1\40\1\u00fc\1\uffff\1\151\2\172"+
        "\2\uffff\1\157\1\172\1\uffff\1\72\1\172\1\40\1\172\1\uffff\6\172"+
        "\1\40\1\uffff";
    static final String DFA14_acceptS =
        "\16\uffff\1\25\1\26\2\uffff\1\24\1\32\1\2\1\1\3\uffff\1\24\2\uffff"+
        "\1\6\3\uffff\1\11\1\10\1\12\1\20\1\26\3\uffff\1\22\1\uffff\1\27"+
        "\1\uffff\1\25\1\30\1\uffff\1\15\2\uffff\1\14\5\uffff\1\23\1\uffff"+
        "\1\31\3\uffff\1\7\4\uffff\1\3\3\uffff\1\13\3\uffff\1\5\1\21\2\uffff"+
        "\1\4\4\uffff\1\17\7\uffff\1\16";
    static final String DFA14_specialS =
        "\1\4\11\uffff\1\3\1\0\37\uffff\1\2\15\uffff\1\1\43\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\23\1\17\1\16\2\23\1\16\22\23\1\7\1\23\1\12\4\23\1\13\2\22"+
            "\2\23\3\22\1\15\13\22\5\23\1\1\2\20\1\10\1\2\1\4\1\11\6\20\1"+
            "\5\3\20\1\3\11\20\3\23\1\21\1\20\1\23\32\20\1\23\1\6\65\23\1"+
            "\22\1\14\14\23\4\22\3\23\1\22\1\23\2\22\2\23\1\22\5\23\3\22"+
            "\4\23\1\22\1\23\1\22\3\23\4\22\3\23\1\22\1\23\2\22\2\23\1\22"+
            "\5\23\3\22\4\23\1\22\1\23\1\22\uff03\23",
            "\1\24",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\1\26\3\30\1\27\25"+
            "\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\24\30\1\32\5\30",
            "\1\34\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\15"+
            "\30\1\33\6\30\1\35\5\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\1\36\3\30\1\37\25"+
            "\30",
            "\1\40",
            "\1\44\26\uffff\1\44\133\uffff\1\42",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\4\30\1\46\11\30\1"+
            "\45\13\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\24\30\1\47\5\30",
            "\0\50",
            "\0\50",
            "\12\51",
            "\1\52\4\uffff\1\53",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\3\30\1\56\26\30",
            "\1\57\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\1\60\31\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\23\30\1\61\6\30",
            "",
            "\1\62\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\22\30\1\63\7\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\23\30\1\64\6\30",
            "",
            "",
            "",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\14\30\1\65\15\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\15\30\1\66\14\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\15\30\1\67\14\30",
            "",
            "\2\31\2\uffff\17\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31"+
            "\67\uffff\2\31\14\uffff\4\31\3\uffff\1\31\1\uffff\2\31\2\uffff"+
            "\1\31\5\uffff\3\31\4\uffff\1\31\1\uffff\1\31\3\uffff\4\31\3"+
            "\uffff\1\31\1\uffff\2\31\2\uffff\1\31\5\uffff\3\31\4\uffff\1"+
            "\31\1\uffff\1\31",
            "",
            "\50\72\2\71\2\72\17\71\6\72\32\71\4\72\1\71\1\72\32\71\67\72"+
            "\2\71\14\72\4\71\3\72\1\71\1\72\2\71\2\72\1\71\5\72\3\71\4\72"+
            "\1\71\1\72\1\71\3\72\4\71\3\72\1\71\1\72\2\71\2\72\1\71\5\72"+
            "\3\71\4\72\1\71\1\72\1\71\uff03\72",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\16\30\1\73\13\30",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\15\30\1\74\14\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30\150\uffff\1"+
            "\75",
            "",
            "\1\76\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\1\77\31\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\16\30\1\100\13\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30\146\uffff\1"+
            "\101",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\2\30\1\102\27\30",
            "",
            "\50\72\2\71\2\72\17\71\6\72\32\71\4\72\1\71\1\72\32\71\67\72"+
            "\2\71\14\72\4\71\3\72\1\71\1\72\2\71\2\72\1\71\5\72\3\71\4\72"+
            "\1\71\1\72\1\71\3\72\4\71\3\72\1\71\1\72\2\71\2\72\1\71\5\72"+
            "\3\71\4\72\1\71\1\72\1\71\uff03\72",
            "",
            "\1\103\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\3\30\1\104\26\30",
            "\1\105",
            "",
            "\12\30\1\106\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\107\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\110",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\10\30\1\111\21\30",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\16\30\1\112\13\30",
            "\1\113",
            "\2\31\2\uffff\17\31\6\uffff\32\31\4\uffff\1\31\1\uffff\32\31"+
            "\67\uffff\2\31\14\uffff\4\31\3\uffff\1\31\1\uffff\2\31\2\uffff"+
            "\1\31\5\uffff\3\31\4\uffff\1\31\1\uffff\1\31\3\uffff\4\31\3"+
            "\uffff\1\31\1\uffff\2\31\2\uffff\1\31\5\uffff\3\31\4\uffff\1"+
            "\31\1\uffff\1\31",
            "",
            "\1\115",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\16\30\1\116\13\30",
            "\1\117\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "",
            "",
            "\1\120",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\15\30\1\121\14\30",
            "",
            "\1\122",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\1\123\31\30",
            "\1\124",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\13\30\1\125\16\30",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\10\30\1\126\21\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\3\30\1\127\26\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\1\130\31\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\3\30\1\131\26\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\4\30\1\132\25\30",
            "\12\30\1\133\6\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\134",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | RULE_STRING | RULE_INT | RULE_EXID | RULE_NL | RULE_WS | RULE_ML_COMMENT | RULE_ID | RULE_SL_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_11 = input.LA(1);

                        s = -1;
                        if ( ((LA14_11>='\u0000' && LA14_11<='\uFFFF')) ) {s = 40;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_57 = input.LA(1);

                        s = -1;
                        if ( ((LA14_57>='(' && LA14_57<=')')||(LA14_57>=',' && LA14_57<=':')||(LA14_57>='A' && LA14_57<='Z')||LA14_57=='_'||(LA14_57>='a' && LA14_57<='z')||(LA14_57>='\u00B2' && LA14_57<='\u00B3')||(LA14_57>='\u00C0' && LA14_57<='\u00C3')||LA14_57=='\u00C7'||(LA14_57>='\u00C9' && LA14_57<='\u00CA')||LA14_57=='\u00CD'||(LA14_57>='\u00D3' && LA14_57<='\u00D5')||LA14_57=='\u00DA'||LA14_57=='\u00DC'||(LA14_57>='\u00E0' && LA14_57<='\u00E3')||LA14_57=='\u00E7'||(LA14_57>='\u00E9' && LA14_57<='\u00EA')||LA14_57=='\u00ED'||(LA14_57>='\u00F3' && LA14_57<='\u00F5')||LA14_57=='\u00FA'||LA14_57=='\u00FC') ) {s = 57;}

                        else if ( ((LA14_57>='\u0000' && LA14_57<='\'')||(LA14_57>='*' && LA14_57<='+')||(LA14_57>=';' && LA14_57<='@')||(LA14_57>='[' && LA14_57<='^')||LA14_57=='`'||(LA14_57>='{' && LA14_57<='\u00B1')||(LA14_57>='\u00B4' && LA14_57<='\u00BF')||(LA14_57>='\u00C4' && LA14_57<='\u00C6')||LA14_57=='\u00C8'||(LA14_57>='\u00CB' && LA14_57<='\u00CC')||(LA14_57>='\u00CE' && LA14_57<='\u00D2')||(LA14_57>='\u00D6' && LA14_57<='\u00D9')||LA14_57=='\u00DB'||(LA14_57>='\u00DD' && LA14_57<='\u00DF')||(LA14_57>='\u00E4' && LA14_57<='\u00E6')||LA14_57=='\u00E8'||(LA14_57>='\u00EB' && LA14_57<='\u00EC')||(LA14_57>='\u00EE' && LA14_57<='\u00F2')||(LA14_57>='\u00F6' && LA14_57<='\u00F9')||LA14_57=='\u00FB'||(LA14_57>='\u00FD' && LA14_57<='\uFFFF')) ) {s = 58;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_43 = input.LA(1);

                        s = -1;
                        if ( ((LA14_43>='(' && LA14_43<=')')||(LA14_43>=',' && LA14_43<=':')||(LA14_43>='A' && LA14_43<='Z')||LA14_43=='_'||(LA14_43>='a' && LA14_43<='z')||(LA14_43>='\u00B2' && LA14_43<='\u00B3')||(LA14_43>='\u00C0' && LA14_43<='\u00C3')||LA14_43=='\u00C7'||(LA14_43>='\u00C9' && LA14_43<='\u00CA')||LA14_43=='\u00CD'||(LA14_43>='\u00D3' && LA14_43<='\u00D5')||LA14_43=='\u00DA'||LA14_43=='\u00DC'||(LA14_43>='\u00E0' && LA14_43<='\u00E3')||LA14_43=='\u00E7'||(LA14_43>='\u00E9' && LA14_43<='\u00EA')||LA14_43=='\u00ED'||(LA14_43>='\u00F3' && LA14_43<='\u00F5')||LA14_43=='\u00FA'||LA14_43=='\u00FC') ) {s = 57;}

                        else if ( ((LA14_43>='\u0000' && LA14_43<='\'')||(LA14_43>='*' && LA14_43<='+')||(LA14_43>=';' && LA14_43<='@')||(LA14_43>='[' && LA14_43<='^')||LA14_43=='`'||(LA14_43>='{' && LA14_43<='\u00B1')||(LA14_43>='\u00B4' && LA14_43<='\u00BF')||(LA14_43>='\u00C4' && LA14_43<='\u00C6')||LA14_43=='\u00C8'||(LA14_43>='\u00CB' && LA14_43<='\u00CC')||(LA14_43>='\u00CE' && LA14_43<='\u00D2')||(LA14_43>='\u00D6' && LA14_43<='\u00D9')||LA14_43=='\u00DB'||(LA14_43>='\u00DD' && LA14_43<='\u00DF')||(LA14_43>='\u00E4' && LA14_43<='\u00E6')||LA14_43=='\u00E8'||(LA14_43>='\u00EB' && LA14_43<='\u00EC')||(LA14_43>='\u00EE' && LA14_43<='\u00F2')||(LA14_43>='\u00F6' && LA14_43<='\u00F9')||LA14_43=='\u00FB'||(LA14_43>='\u00FD' && LA14_43<='\uFFFF')) ) {s = 58;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_10 = input.LA(1);

                        s = -1;
                        if ( ((LA14_10>='\u0000' && LA14_10<='\uFFFF')) ) {s = 40;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='@') ) {s = 1;}

                        else if ( (LA14_0=='D') ) {s = 2;}

                        else if ( (LA14_0=='Q') ) {s = 3;}

                        else if ( (LA14_0=='E') ) {s = 4;}

                        else if ( (LA14_0=='M') ) {s = 5;}

                        else if ( (LA14_0=='|') ) {s = 6;}

                        else if ( (LA14_0==' ') ) {s = 7;}

                        else if ( (LA14_0=='C') ) {s = 8;}

                        else if ( (LA14_0=='F') ) {s = 9;}

                        else if ( (LA14_0=='\"') ) {s = 10;}

                        else if ( (LA14_0=='\'') ) {s = 11;}

                        else if ( (LA14_0=='\u00B3') ) {s = 12;}

                        else if ( (LA14_0=='/') ) {s = 13;}

                        else if ( (LA14_0=='\n'||LA14_0=='\r') ) {s = 14;}

                        else if ( (LA14_0=='\t') ) {s = 15;}

                        else if ( ((LA14_0>='A' && LA14_0<='B')||(LA14_0>='G' && LA14_0<='L')||(LA14_0>='N' && LA14_0<='P')||(LA14_0>='R' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {s = 16;}

                        else if ( (LA14_0=='^') ) {s = 17;}

                        else if ( ((LA14_0>='(' && LA14_0<=')')||(LA14_0>=',' && LA14_0<='.')||(LA14_0>='0' && LA14_0<=':')||LA14_0=='\u00B2'||(LA14_0>='\u00C0' && LA14_0<='\u00C3')||LA14_0=='\u00C7'||(LA14_0>='\u00C9' && LA14_0<='\u00CA')||LA14_0=='\u00CD'||(LA14_0>='\u00D3' && LA14_0<='\u00D5')||LA14_0=='\u00DA'||LA14_0=='\u00DC'||(LA14_0>='\u00E0' && LA14_0<='\u00E3')||LA14_0=='\u00E7'||(LA14_0>='\u00E9' && LA14_0<='\u00EA')||LA14_0=='\u00ED'||(LA14_0>='\u00F3' && LA14_0<='\u00F5')||LA14_0=='\u00FA'||LA14_0=='\u00FC') ) {s = 18;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='*' && LA14_0<='+')||(LA14_0>=';' && LA14_0<='?')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||LA14_0=='{'||(LA14_0>='}' && LA14_0<='\u00B1')||(LA14_0>='\u00B4' && LA14_0<='\u00BF')||(LA14_0>='\u00C4' && LA14_0<='\u00C6')||LA14_0=='\u00C8'||(LA14_0>='\u00CB' && LA14_0<='\u00CC')||(LA14_0>='\u00CE' && LA14_0<='\u00D2')||(LA14_0>='\u00D6' && LA14_0<='\u00D9')||LA14_0=='\u00DB'||(LA14_0>='\u00DD' && LA14_0<='\u00DF')||(LA14_0>='\u00E4' && LA14_0<='\u00E6')||LA14_0=='\u00E8'||(LA14_0>='\u00EB' && LA14_0<='\u00EC')||(LA14_0>='\u00EE' && LA14_0<='\u00F2')||(LA14_0>='\u00F6' && LA14_0<='\u00F9')||LA14_0=='\u00FB'||(LA14_0>='\u00FD' && LA14_0<='\uFFFF')) ) {s = 19;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}