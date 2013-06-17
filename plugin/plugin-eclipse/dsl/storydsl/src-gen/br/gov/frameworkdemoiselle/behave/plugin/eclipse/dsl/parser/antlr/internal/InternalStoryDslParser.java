package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.services.StoryDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_STRING", "RULE_EXID", "RULE_INT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ID", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'Como um: '", "'Eu quero: '", "'De modo que: '", "'Funcionalidade: '", "'Cen\\u00E1rio: '", "'Meta:'", "'@'", "'@ '", "'Dado '", "'Quando '", "'Ent\\u00E3o '", "'E '", "'Mas '", "'|'", "'| '", "' |'", "' '"
    };
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
    public static final int RULE_NL=4;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_EXID=6;
    public static final int RULE_INT=7;
    public static final int RULE_WS=8;

    // delegates
    // delegators


        public InternalStoryDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStoryDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStoryDslParser.tokenNames; }
    public String getGrammarFileName() { return "../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g"; }



     	private StoryDslGrammarAccess grammarAccess;
     	
        public InternalStoryDslParser(TokenStream input, StoryDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected StoryDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:76:1: ruleModel returns [EObject current=null] : ( (this_NL_0= RULE_NL )* ( (lv_funcionalidade_1_0= ruleFuncionalidade ) ) (this_NL_2= RULE_NL )* ( (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao ) )? ( (lv_cenarios_4_0= ruleCenario ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_NL_0=null;
        Token this_NL_2=null;
        EObject lv_funcionalidade_1_0 = null;

        EObject lv_usuarioMetaRazao_3_0 = null;

        EObject lv_cenarios_4_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:79:28: ( ( (this_NL_0= RULE_NL )* ( (lv_funcionalidade_1_0= ruleFuncionalidade ) ) (this_NL_2= RULE_NL )* ( (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao ) )? ( (lv_cenarios_4_0= ruleCenario ) )+ ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:80:1: ( (this_NL_0= RULE_NL )* ( (lv_funcionalidade_1_0= ruleFuncionalidade ) ) (this_NL_2= RULE_NL )* ( (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao ) )? ( (lv_cenarios_4_0= ruleCenario ) )+ )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:80:1: ( (this_NL_0= RULE_NL )* ( (lv_funcionalidade_1_0= ruleFuncionalidade ) ) (this_NL_2= RULE_NL )* ( (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao ) )? ( (lv_cenarios_4_0= ruleCenario ) )+ )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:80:2: (this_NL_0= RULE_NL )* ( (lv_funcionalidade_1_0= ruleFuncionalidade ) ) (this_NL_2= RULE_NL )* ( (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao ) )? ( (lv_cenarios_4_0= ruleCenario ) )+
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:80:2: (this_NL_0= RULE_NL )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:80:3: this_NL_0= RULE_NL
            	    {
            	    this_NL_0=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleModel122); 
            	     
            	        newLeafNode(this_NL_0, grammarAccess.getModelAccess().getNLTerminalRuleCall_0()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:84:3: ( (lv_funcionalidade_1_0= ruleFuncionalidade ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:85:1: (lv_funcionalidade_1_0= ruleFuncionalidade )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:85:1: (lv_funcionalidade_1_0= ruleFuncionalidade )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:86:3: lv_funcionalidade_1_0= ruleFuncionalidade
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getFuncionalidadeFuncionalidadeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFuncionalidade_in_ruleModel144);
            lv_funcionalidade_1_0=ruleFuncionalidade();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"funcionalidade",
                    		lv_funcionalidade_1_0, 
                    		"Funcionalidade");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:102:2: (this_NL_2= RULE_NL )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_NL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:102:3: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleModel156); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getModelAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:106:3: ( (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:107:1: (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao )
                    {
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:107:1: (lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao )
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:108:3: lv_usuarioMetaRazao_3_0= ruleUsuarioMetaRazao
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getUsuarioMetaRazaoUsuarioMetaRazaoParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUsuarioMetaRazao_in_ruleModel178);
                    lv_usuarioMetaRazao_3_0=ruleUsuarioMetaRazao();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		add(
                           			current, 
                           			"usuarioMetaRazao",
                            		lv_usuarioMetaRazao_3_0, 
                            		"UsuarioMetaRazao");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:124:3: ( (lv_cenarios_4_0= ruleCenario ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:125:1: (lv_cenarios_4_0= ruleCenario )
            	    {
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:125:1: (lv_cenarios_4_0= ruleCenario )
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:126:3: lv_cenarios_4_0= ruleCenario
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getCenariosCenarioParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCenario_in_ruleModel200);
            	    lv_cenarios_4_0=ruleCenario();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"cenarios",
            	            		lv_cenarios_4_0, 
            	            		"Cenario");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUsuarioMetaRazao"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:150:1: entryRuleUsuarioMetaRazao returns [EObject current=null] : iv_ruleUsuarioMetaRazao= ruleUsuarioMetaRazao EOF ;
    public final EObject entryRuleUsuarioMetaRazao() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUsuarioMetaRazao = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:151:2: (iv_ruleUsuarioMetaRazao= ruleUsuarioMetaRazao EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:152:2: iv_ruleUsuarioMetaRazao= ruleUsuarioMetaRazao EOF
            {
             newCompositeNode(grammarAccess.getUsuarioMetaRazaoRule()); 
            pushFollow(FOLLOW_ruleUsuarioMetaRazao_in_entryRuleUsuarioMetaRazao237);
            iv_ruleUsuarioMetaRazao=ruleUsuarioMetaRazao();

            state._fsp--;

             current =iv_ruleUsuarioMetaRazao; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUsuarioMetaRazao247); 

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
    // $ANTLR end "entryRuleUsuarioMetaRazao"


    // $ANTLR start "ruleUsuarioMetaRazao"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:159:1: ruleUsuarioMetaRazao returns [EObject current=null] : (otherlv_0= 'Como um: ' ( (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR ) ) (this_NL_2= RULE_NL )* otherlv_3= 'Eu quero: ' ( (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA ) ) (this_NL_5= RULE_NL )* otherlv_6= 'De modo que: ' ( (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META ) ) (this_NL_8= RULE_NL )* ) ;
    public final EObject ruleUsuarioMetaRazao() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NL_2=null;
        Token otherlv_3=null;
        Token this_NL_5=null;
        Token otherlv_6=null;
        Token this_NL_8=null;
        EObject lv_nome_do_ator_1_0 = null;

        EObject lv_meta_a_ser_alcancada_4_0 = null;

        EObject lv_razao_para_alcancar_meta_7_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:162:28: ( (otherlv_0= 'Como um: ' ( (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR ) ) (this_NL_2= RULE_NL )* otherlv_3= 'Eu quero: ' ( (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA ) ) (this_NL_5= RULE_NL )* otherlv_6= 'De modo que: ' ( (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META ) ) (this_NL_8= RULE_NL )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:163:1: (otherlv_0= 'Como um: ' ( (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR ) ) (this_NL_2= RULE_NL )* otherlv_3= 'Eu quero: ' ( (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA ) ) (this_NL_5= RULE_NL )* otherlv_6= 'De modo que: ' ( (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META ) ) (this_NL_8= RULE_NL )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:163:1: (otherlv_0= 'Como um: ' ( (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR ) ) (this_NL_2= RULE_NL )* otherlv_3= 'Eu quero: ' ( (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA ) ) (this_NL_5= RULE_NL )* otherlv_6= 'De modo que: ' ( (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META ) ) (this_NL_8= RULE_NL )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:163:3: otherlv_0= 'Como um: ' ( (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR ) ) (this_NL_2= RULE_NL )* otherlv_3= 'Eu quero: ' ( (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA ) ) (this_NL_5= RULE_NL )* otherlv_6= 'De modo que: ' ( (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META ) ) (this_NL_8= RULE_NL )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleUsuarioMetaRazao284); 

                	newLeafNode(otherlv_0, grammarAccess.getUsuarioMetaRazaoAccess().getComoUmKeyword_0());
                
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:167:1: ( (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:168:1: (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:168:1: (lv_nome_do_ator_1_0= ruleNOME_DO_ATOR )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:169:3: lv_nome_do_ator_1_0= ruleNOME_DO_ATOR
            {
             
            	        newCompositeNode(grammarAccess.getUsuarioMetaRazaoAccess().getNome_do_atorNOME_DO_ATORParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleNOME_DO_ATOR_in_ruleUsuarioMetaRazao305);
            lv_nome_do_ator_1_0=ruleNOME_DO_ATOR();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUsuarioMetaRazaoRule());
            	        }
                   		set(
                   			current, 
                   			"nome_do_ator",
                    		lv_nome_do_ator_1_0, 
                    		"NOME_DO_ATOR");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:185:2: (this_NL_2= RULE_NL )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_NL) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:185:3: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleUsuarioMetaRazao317); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleUsuarioMetaRazao330); 

                	newLeafNode(otherlv_3, grammarAccess.getUsuarioMetaRazaoAccess().getEuQueroKeyword_3());
                
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:193:1: ( (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:194:1: (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:194:1: (lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:195:3: lv_meta_a_ser_alcancada_4_0= ruleMETA_A_SER_ALCANCADA
            {
             
            	        newCompositeNode(grammarAccess.getUsuarioMetaRazaoAccess().getMeta_a_ser_alcancadaMETA_A_SER_ALCANCADAParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleMETA_A_SER_ALCANCADA_in_ruleUsuarioMetaRazao351);
            lv_meta_a_ser_alcancada_4_0=ruleMETA_A_SER_ALCANCADA();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUsuarioMetaRazaoRule());
            	        }
                   		set(
                   			current, 
                   			"meta_a_ser_alcancada",
                    		lv_meta_a_ser_alcancada_4_0, 
                    		"META_A_SER_ALCANCADA");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:211:2: (this_NL_5= RULE_NL )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_NL) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:211:3: this_NL_5= RULE_NL
            	    {
            	    this_NL_5=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleUsuarioMetaRazao363); 
            	     
            	        newLeafNode(this_NL_5, grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleUsuarioMetaRazao376); 

                	newLeafNode(otherlv_6, grammarAccess.getUsuarioMetaRazaoAccess().getDeModoQueKeyword_6());
                
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:219:1: ( (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:220:1: (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:220:1: (lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:221:3: lv_razao_para_alcancar_meta_7_0= ruleRAZAO_PARA_ALCANCAR_A_META
            {
             
            	        newCompositeNode(grammarAccess.getUsuarioMetaRazaoAccess().getRazao_para_alcancar_metaRAZAO_PARA_ALCANCAR_A_METAParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_ruleUsuarioMetaRazao397);
            lv_razao_para_alcancar_meta_7_0=ruleRAZAO_PARA_ALCANCAR_A_META();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUsuarioMetaRazaoRule());
            	        }
                   		set(
                   			current, 
                   			"razao_para_alcancar_meta",
                    		lv_razao_para_alcancar_meta_7_0, 
                    		"RAZAO_PARA_ALCANCAR_A_META");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:237:2: (this_NL_8= RULE_NL )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_NL) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:237:3: this_NL_8= RULE_NL
            	    {
            	    this_NL_8=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleUsuarioMetaRazao409); 
            	     
            	        newLeafNode(this_NL_8, grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_8()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleUsuarioMetaRazao"


    // $ANTLR start "entryRuleFuncionalidade"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:249:1: entryRuleFuncionalidade returns [EObject current=null] : iv_ruleFuncionalidade= ruleFuncionalidade EOF ;
    public final EObject entryRuleFuncionalidade() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFuncionalidade = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:250:2: (iv_ruleFuncionalidade= ruleFuncionalidade EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:251:2: iv_ruleFuncionalidade= ruleFuncionalidade EOF
            {
             newCompositeNode(grammarAccess.getFuncionalidadeRule()); 
            pushFollow(FOLLOW_ruleFuncionalidade_in_entryRuleFuncionalidade446);
            iv_ruleFuncionalidade=ruleFuncionalidade();

            state._fsp--;

             current =iv_ruleFuncionalidade; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFuncionalidade456); 

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
    // $ANTLR end "entryRuleFuncionalidade"


    // $ANTLR start "ruleFuncionalidade"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:258:1: ruleFuncionalidade returns [EObject current=null] : (otherlv_0= 'Funcionalidade: ' ( (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL ) ) (this_NL_2= RULE_NL )* ) ;
    public final EObject ruleFuncionalidade() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NL_2=null;
        AntlrDatatypeRuleToken lv_nome_funcionadade_1_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:261:28: ( (otherlv_0= 'Funcionalidade: ' ( (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL ) ) (this_NL_2= RULE_NL )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:262:1: (otherlv_0= 'Funcionalidade: ' ( (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL ) ) (this_NL_2= RULE_NL )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:262:1: (otherlv_0= 'Funcionalidade: ' ( (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL ) ) (this_NL_2= RULE_NL )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:262:3: otherlv_0= 'Funcionalidade: ' ( (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL ) ) (this_NL_2= RULE_NL )*
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleFuncionalidade493); 

                	newLeafNode(otherlv_0, grammarAccess.getFuncionalidadeAccess().getFuncionalidadeKeyword_0());
                
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:266:1: ( (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:267:1: (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:267:1: (lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:268:3: lv_nome_funcionadade_1_0= ruleIDENTIFICADOR_GERAL
            {
             
            	        newCompositeNode(grammarAccess.getFuncionalidadeAccess().getNome_funcionadadeIDENTIFICADOR_GERALParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleFuncionalidade514);
            lv_nome_funcionadade_1_0=ruleIDENTIFICADOR_GERAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFuncionalidadeRule());
            	        }
                   		set(
                   			current, 
                   			"nome_funcionadade",
                    		lv_nome_funcionadade_1_0, 
                    		"IDENTIFICADOR_GERAL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:284:2: (this_NL_2= RULE_NL )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_NL) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:284:3: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleFuncionalidade526); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getFuncionalidadeAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleFuncionalidade"


    // $ANTLR start "entryRuleCenario"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:296:1: entryRuleCenario returns [EObject current=null] : iv_ruleCenario= ruleCenario EOF ;
    public final EObject entryRuleCenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCenario = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:297:2: (iv_ruleCenario= ruleCenario EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:298:2: iv_ruleCenario= ruleCenario EOF
            {
             newCompositeNode(grammarAccess.getCenarioRule()); 
            pushFollow(FOLLOW_ruleCenario_in_entryRuleCenario563);
            iv_ruleCenario=ruleCenario();

            state._fsp--;

             current =iv_ruleCenario; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCenario573); 

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
    // $ANTLR end "entryRuleCenario"


    // $ANTLR start "ruleCenario"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:305:1: ruleCenario returns [EObject current=null] : (otherlv_0= 'Cen\\u00E1rio: ' this_IdentificadorCenario_1= ruleIdentificadorCenario ( (lv_xer_2_0= RULE_NL ) )* ( (lv_sentencas_qualite_3_0= ruleSentencaQualite ) )* ) ;
    public final EObject ruleCenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_xer_2_0=null;
        EObject this_IdentificadorCenario_1 = null;

        EObject lv_sentencas_qualite_3_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:308:28: ( (otherlv_0= 'Cen\\u00E1rio: ' this_IdentificadorCenario_1= ruleIdentificadorCenario ( (lv_xer_2_0= RULE_NL ) )* ( (lv_sentencas_qualite_3_0= ruleSentencaQualite ) )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:309:1: (otherlv_0= 'Cen\\u00E1rio: ' this_IdentificadorCenario_1= ruleIdentificadorCenario ( (lv_xer_2_0= RULE_NL ) )* ( (lv_sentencas_qualite_3_0= ruleSentencaQualite ) )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:309:1: (otherlv_0= 'Cen\\u00E1rio: ' this_IdentificadorCenario_1= ruleIdentificadorCenario ( (lv_xer_2_0= RULE_NL ) )* ( (lv_sentencas_qualite_3_0= ruleSentencaQualite ) )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:309:3: otherlv_0= 'Cen\\u00E1rio: ' this_IdentificadorCenario_1= ruleIdentificadorCenario ( (lv_xer_2_0= RULE_NL ) )* ( (lv_sentencas_qualite_3_0= ruleSentencaQualite ) )*
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleCenario610); 

                	newLeafNode(otherlv_0, grammarAccess.getCenarioAccess().getCenRioKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCenarioAccess().getIdentificadorCenarioParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleIdentificadorCenario_in_ruleCenario632);
            this_IdentificadorCenario_1=ruleIdentificadorCenario();

            state._fsp--;

             
                    current = this_IdentificadorCenario_1; 
                    afterParserOrEnumRuleCall();
                
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:322:1: ( (lv_xer_2_0= RULE_NL ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_NL) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:323:1: (lv_xer_2_0= RULE_NL )
            	    {
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:323:1: (lv_xer_2_0= RULE_NL )
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:324:3: lv_xer_2_0= RULE_NL
            	    {
            	    lv_xer_2_0=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleCenario648); 

            	    			newLeafNode(lv_xer_2_0, grammarAccess.getCenarioAccess().getXerNLTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCenarioRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"xer",
            	            		lv_xer_2_0, 
            	            		"NL");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:340:3: ( (lv_sentencas_qualite_3_0= ruleSentencaQualite ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==18||(LA10_0>=21 && LA10_0<=27)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:341:1: (lv_sentencas_qualite_3_0= ruleSentencaQualite )
            	    {
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:341:1: (lv_sentencas_qualite_3_0= ruleSentencaQualite )
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:342:3: lv_sentencas_qualite_3_0= ruleSentencaQualite
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCenarioAccess().getSentencas_qualiteSentencaQualiteParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSentencaQualite_in_ruleCenario675);
            	    lv_sentencas_qualite_3_0=ruleSentencaQualite();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCenarioRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sentencas_qualite",
            	            		lv_sentencas_qualite_3_0, 
            	            		"SentencaQualite");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end "ruleCenario"


    // $ANTLR start "entryRuleIdentificadorCenario"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:366:1: entryRuleIdentificadorCenario returns [EObject current=null] : iv_ruleIdentificadorCenario= ruleIdentificadorCenario EOF ;
    public final EObject entryRuleIdentificadorCenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentificadorCenario = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:367:2: (iv_ruleIdentificadorCenario= ruleIdentificadorCenario EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:368:2: iv_ruleIdentificadorCenario= ruleIdentificadorCenario EOF
            {
             newCompositeNode(grammarAccess.getIdentificadorCenarioRule()); 
            pushFollow(FOLLOW_ruleIdentificadorCenario_in_entryRuleIdentificadorCenario712);
            iv_ruleIdentificadorCenario=ruleIdentificadorCenario();

            state._fsp--;

             current =iv_ruleIdentificadorCenario; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentificadorCenario722); 

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
    // $ANTLR end "entryRuleIdentificadorCenario"


    // $ANTLR start "ruleIdentificadorCenario"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:375:1: ruleIdentificadorCenario returns [EObject current=null] : ( (lv_name_0_0= ruleIDENTIFICADOR_CENARIO ) ) ;
    public final EObject ruleIdentificadorCenario() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:378:28: ( ( (lv_name_0_0= ruleIDENTIFICADOR_CENARIO ) ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:379:1: ( (lv_name_0_0= ruleIDENTIFICADOR_CENARIO ) )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:379:1: ( (lv_name_0_0= ruleIDENTIFICADOR_CENARIO ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:380:1: (lv_name_0_0= ruleIDENTIFICADOR_CENARIO )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:380:1: (lv_name_0_0= ruleIDENTIFICADOR_CENARIO )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:381:3: lv_name_0_0= ruleIDENTIFICADOR_CENARIO
            {
             
            	        newCompositeNode(grammarAccess.getIdentificadorCenarioAccess().getNameIDENTIFICADOR_CENARIOParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleIDENTIFICADOR_CENARIO_in_ruleIdentificadorCenario767);
            lv_name_0_0=ruleIDENTIFICADOR_CENARIO();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIdentificadorCenarioRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"IDENTIFICADOR_CENARIO");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleIdentificadorCenario"


    // $ANTLR start "entryRuleSentencaQualite"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:405:1: entryRuleSentencaQualite returns [EObject current=null] : iv_ruleSentencaQualite= ruleSentencaQualite EOF ;
    public final EObject entryRuleSentencaQualite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSentencaQualite = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:406:2: (iv_ruleSentencaQualite= ruleSentencaQualite EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:407:2: iv_ruleSentencaQualite= ruleSentencaQualite EOF
            {
             newCompositeNode(grammarAccess.getSentencaQualiteRule()); 
            pushFollow(FOLLOW_ruleSentencaQualite_in_entryRuleSentencaQualite802);
            iv_ruleSentencaQualite=ruleSentencaQualite();

            state._fsp--;

             current =iv_ruleSentencaQualite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSentencaQualite812); 

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
    // $ANTLR end "entryRuleSentencaQualite"


    // $ANTLR start "ruleSentencaQualite"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:414:1: ruleSentencaQualite returns [EObject current=null] : (this_ExecutarCenario_0= ruleExecutarCenario | this_ListaItens_1= ruleListaItens | this_Meta_2= ruleMeta ) ;
    public final EObject ruleSentencaQualite() throws RecognitionException {
        EObject current = null;

        EObject this_ExecutarCenario_0 = null;

        EObject this_ListaItens_1 = null;

        EObject this_Meta_2 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:417:28: ( (this_ExecutarCenario_0= ruleExecutarCenario | this_ListaItens_1= ruleListaItens | this_Meta_2= ruleMeta ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:418:1: (this_ExecutarCenario_0= ruleExecutarCenario | this_ListaItens_1= ruleListaItens | this_Meta_2= ruleMeta )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:418:1: (this_ExecutarCenario_0= ruleExecutarCenario | this_ListaItens_1= ruleListaItens | this_Meta_2= ruleMeta )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                {
                alt11=1;
                }
                break;
            case 26:
            case 27:
                {
                alt11=2;
                }
                break;
            case 18:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:419:5: this_ExecutarCenario_0= ruleExecutarCenario
                    {
                     
                            newCompositeNode(grammarAccess.getSentencaQualiteAccess().getExecutarCenarioParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleExecutarCenario_in_ruleSentencaQualite859);
                    this_ExecutarCenario_0=ruleExecutarCenario();

                    state._fsp--;

                     
                            current = this_ExecutarCenario_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:429:5: this_ListaItens_1= ruleListaItens
                    {
                     
                            newCompositeNode(grammarAccess.getSentencaQualiteAccess().getListaItensParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleListaItens_in_ruleSentencaQualite886);
                    this_ListaItens_1=ruleListaItens();

                    state._fsp--;

                     
                            current = this_ListaItens_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:439:5: this_Meta_2= ruleMeta
                    {
                     
                            newCompositeNode(grammarAccess.getSentencaQualiteAccess().getMetaParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleMeta_in_ruleSentencaQualite913);
                    this_Meta_2=ruleMeta();

                    state._fsp--;

                     
                            current = this_Meta_2; 
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
    // $ANTLR end "ruleSentencaQualite"


    // $ANTLR start "entryRuleMeta"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:455:1: entryRuleMeta returns [EObject current=null] : iv_ruleMeta= ruleMeta EOF ;
    public final EObject entryRuleMeta() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMeta = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:456:2: (iv_ruleMeta= ruleMeta EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:457:2: iv_ruleMeta= ruleMeta EOF
            {
             newCompositeNode(grammarAccess.getMetaRule()); 
            pushFollow(FOLLOW_ruleMeta_in_entryRuleMeta948);
            iv_ruleMeta=ruleMeta();

            state._fsp--;

             current =iv_ruleMeta; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMeta958); 

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
    // $ANTLR end "entryRuleMeta"


    // $ANTLR start "ruleMeta"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:464:1: ruleMeta returns [EObject current=null] : ( ( (lv_x_0_0= 'Meta:' ) ) (this_NL_1= RULE_NL )* ( (lv_lista_metas_2_0= ruleListaMetas ) )+ ) ;
    public final EObject ruleMeta() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token this_NL_1=null;
        AntlrDatatypeRuleToken lv_lista_metas_2_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:467:28: ( ( ( (lv_x_0_0= 'Meta:' ) ) (this_NL_1= RULE_NL )* ( (lv_lista_metas_2_0= ruleListaMetas ) )+ ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:468:1: ( ( (lv_x_0_0= 'Meta:' ) ) (this_NL_1= RULE_NL )* ( (lv_lista_metas_2_0= ruleListaMetas ) )+ )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:468:1: ( ( (lv_x_0_0= 'Meta:' ) ) (this_NL_1= RULE_NL )* ( (lv_lista_metas_2_0= ruleListaMetas ) )+ )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:468:2: ( (lv_x_0_0= 'Meta:' ) ) (this_NL_1= RULE_NL )* ( (lv_lista_metas_2_0= ruleListaMetas ) )+
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:468:2: ( (lv_x_0_0= 'Meta:' ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:469:1: (lv_x_0_0= 'Meta:' )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:469:1: (lv_x_0_0= 'Meta:' )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:470:3: lv_x_0_0= 'Meta:'
            {
            lv_x_0_0=(Token)match(input,18,FOLLOW_18_in_ruleMeta1001); 

                    newLeafNode(lv_x_0_0, grammarAccess.getMetaAccess().getXMetaKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMetaRule());
            	        }
                   		setWithLastConsumed(current, "x", lv_x_0_0, "Meta:");
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:483:2: (this_NL_1= RULE_NL )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:483:3: this_NL_1= RULE_NL
            	    {
            	    this_NL_1=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleMeta1026); 
            	     
            	        newLeafNode(this_NL_1, grammarAccess.getMetaAccess().getNLTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:487:3: ( (lv_lista_metas_2_0= ruleListaMetas ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=19 && LA13_0<=20)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:488:1: (lv_lista_metas_2_0= ruleListaMetas )
            	    {
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:488:1: (lv_lista_metas_2_0= ruleListaMetas )
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:489:3: lv_lista_metas_2_0= ruleListaMetas
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMetaAccess().getLista_metasListaMetasParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleListaMetas_in_ruleMeta1048);
            	    lv_lista_metas_2_0=ruleListaMetas();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMetaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lista_metas",
            	            		lv_lista_metas_2_0, 
            	            		"ListaMetas");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
    // $ANTLR end "ruleMeta"


    // $ANTLR start "entryRuleListaMetas"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:513:1: entryRuleListaMetas returns [String current=null] : iv_ruleListaMetas= ruleListaMetas EOF ;
    public final String entryRuleListaMetas() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleListaMetas = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:514:2: (iv_ruleListaMetas= ruleListaMetas EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:515:2: iv_ruleListaMetas= ruleListaMetas EOF
            {
             newCompositeNode(grammarAccess.getListaMetasRule()); 
            pushFollow(FOLLOW_ruleListaMetas_in_entryRuleListaMetas1086);
            iv_ruleListaMetas=ruleListaMetas();

            state._fsp--;

             current =iv_ruleListaMetas.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListaMetas1097); 

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
    // $ANTLR end "entryRuleListaMetas"


    // $ANTLR start "ruleListaMetas"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:522:1: ruleListaMetas returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '@' | kw= '@ ' ) this_IDENTIFICADOR_GERAL_2= ruleIDENTIFICADOR_GERAL (this_NL_3= RULE_NL )* ) ;
    public final AntlrDatatypeRuleToken ruleListaMetas() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NL_3=null;
        AntlrDatatypeRuleToken this_IDENTIFICADOR_GERAL_2 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:525:28: ( ( (kw= '@' | kw= '@ ' ) this_IDENTIFICADOR_GERAL_2= ruleIDENTIFICADOR_GERAL (this_NL_3= RULE_NL )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:526:1: ( (kw= '@' | kw= '@ ' ) this_IDENTIFICADOR_GERAL_2= ruleIDENTIFICADOR_GERAL (this_NL_3= RULE_NL )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:526:1: ( (kw= '@' | kw= '@ ' ) this_IDENTIFICADOR_GERAL_2= ruleIDENTIFICADOR_GERAL (this_NL_3= RULE_NL )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:526:2: (kw= '@' | kw= '@ ' ) this_IDENTIFICADOR_GERAL_2= ruleIDENTIFICADOR_GERAL (this_NL_3= RULE_NL )*
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:526:2: (kw= '@' | kw= '@ ' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            else if ( (LA14_0==20) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:527:2: kw= '@'
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleListaMetas1136); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getListaMetasAccess().getCommercialAtKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:534:2: kw= '@ '
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleListaMetas1155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getListaMetasAccess().getCommercialAtSpaceKeyword_0_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getListaMetasAccess().getIDENTIFICADOR_GERALParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleListaMetas1178);
            this_IDENTIFICADOR_GERAL_2=ruleIDENTIFICADOR_GERAL();

            state._fsp--;


            		current.merge(this_IDENTIFICADOR_GERAL_2);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:550:1: (this_NL_3= RULE_NL )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:550:6: this_NL_3= RULE_NL
            	    {
            	    this_NL_3=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleListaMetas1199); 

            	    		current.merge(this_NL_3);
            	        
            	     
            	        newLeafNode(this_NL_3, grammarAccess.getListaMetasAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleListaMetas"


    // $ANTLR start "entryRuleExecutarCenario"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:565:1: entryRuleExecutarCenario returns [EObject current=null] : iv_ruleExecutarCenario= ruleExecutarCenario EOF ;
    public final EObject entryRuleExecutarCenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutarCenario = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:566:2: (iv_ruleExecutarCenario= ruleExecutarCenario EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:567:2: iv_ruleExecutarCenario= ruleExecutarCenario EOF
            {
             newCompositeNode(grammarAccess.getExecutarCenarioRule()); 
            pushFollow(FOLLOW_ruleExecutarCenario_in_entryRuleExecutarCenario1246);
            iv_ruleExecutarCenario=ruleExecutarCenario();

            state._fsp--;

             current =iv_ruleExecutarCenario; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutarCenario1256); 

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
    // $ANTLR end "entryRuleExecutarCenario"


    // $ANTLR start "ruleExecutarCenario"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:574:1: ruleExecutarCenario returns [EObject current=null] : ( (otherlv_0= 'Dado ' | otherlv_1= 'Quando ' | otherlv_2= 'Ent\\u00E3o ' | otherlv_3= 'E ' | otherlv_4= 'Mas ' ) ( ( ruleIDENTIFICADOR_CENARIO ) ) (this_NL_6= RULE_NL )* ) ;
    public final EObject ruleExecutarCenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_NL_6=null;

         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:577:28: ( ( (otherlv_0= 'Dado ' | otherlv_1= 'Quando ' | otherlv_2= 'Ent\\u00E3o ' | otherlv_3= 'E ' | otherlv_4= 'Mas ' ) ( ( ruleIDENTIFICADOR_CENARIO ) ) (this_NL_6= RULE_NL )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:578:1: ( (otherlv_0= 'Dado ' | otherlv_1= 'Quando ' | otherlv_2= 'Ent\\u00E3o ' | otherlv_3= 'E ' | otherlv_4= 'Mas ' ) ( ( ruleIDENTIFICADOR_CENARIO ) ) (this_NL_6= RULE_NL )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:578:1: ( (otherlv_0= 'Dado ' | otherlv_1= 'Quando ' | otherlv_2= 'Ent\\u00E3o ' | otherlv_3= 'E ' | otherlv_4= 'Mas ' ) ( ( ruleIDENTIFICADOR_CENARIO ) ) (this_NL_6= RULE_NL )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:578:2: (otherlv_0= 'Dado ' | otherlv_1= 'Quando ' | otherlv_2= 'Ent\\u00E3o ' | otherlv_3= 'E ' | otherlv_4= 'Mas ' ) ( ( ruleIDENTIFICADOR_CENARIO ) ) (this_NL_6= RULE_NL )*
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:578:2: (otherlv_0= 'Dado ' | otherlv_1= 'Quando ' | otherlv_2= 'Ent\\u00E3o ' | otherlv_3= 'E ' | otherlv_4= 'Mas ' )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt16=1;
                }
                break;
            case 22:
                {
                alt16=2;
                }
                break;
            case 23:
                {
                alt16=3;
                }
                break;
            case 24:
                {
                alt16=4;
                }
                break;
            case 25:
                {
                alt16=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:578:4: otherlv_0= 'Dado '
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleExecutarCenario1294); 

                        	newLeafNode(otherlv_0, grammarAccess.getExecutarCenarioAccess().getDadoKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:583:7: otherlv_1= 'Quando '
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleExecutarCenario1312); 

                        	newLeafNode(otherlv_1, grammarAccess.getExecutarCenarioAccess().getQuandoKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:588:7: otherlv_2= 'Ent\\u00E3o '
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleExecutarCenario1330); 

                        	newLeafNode(otherlv_2, grammarAccess.getExecutarCenarioAccess().getEntOKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:593:7: otherlv_3= 'E '
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleExecutarCenario1348); 

                        	newLeafNode(otherlv_3, grammarAccess.getExecutarCenarioAccess().getEKeyword_0_3());
                        

                    }
                    break;
                case 5 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:598:7: otherlv_4= 'Mas '
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleExecutarCenario1366); 

                        	newLeafNode(otherlv_4, grammarAccess.getExecutarCenarioAccess().getMasKeyword_0_4());
                        

                    }
                    break;

            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:602:2: ( ( ruleIDENTIFICADOR_CENARIO ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:603:1: ( ruleIDENTIFICADOR_CENARIO )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:603:1: ( ruleIDENTIFICADOR_CENARIO )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:604:3: ruleIDENTIFICADOR_CENARIO
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExecutarCenarioRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refCenarioCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleIDENTIFICADOR_CENARIO_in_ruleExecutarCenario1390);
            ruleIDENTIFICADOR_CENARIO();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:617:2: (this_NL_6= RULE_NL )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_NL) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:617:3: this_NL_6= RULE_NL
            	    {
            	    this_NL_6=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleExecutarCenario1402); 
            	     
            	        newLeafNode(this_NL_6, grammarAccess.getExecutarCenarioAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "ruleExecutarCenario"


    // $ANTLR start "entryRuleListaItens"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:629:1: entryRuleListaItens returns [EObject current=null] : iv_ruleListaItens= ruleListaItens EOF ;
    public final EObject entryRuleListaItens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListaItens = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:630:2: (iv_ruleListaItens= ruleListaItens EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:631:2: iv_ruleListaItens= ruleListaItens EOF
            {
             newCompositeNode(grammarAccess.getListaItensRule()); 
            pushFollow(FOLLOW_ruleListaItens_in_entryRuleListaItens1439);
            iv_ruleListaItens=ruleListaItens();

            state._fsp--;

             current =iv_ruleListaItens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListaItens1449); 

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
    // $ANTLR end "entryRuleListaItens"


    // $ANTLR start "ruleListaItens"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:638:1: ruleListaItens returns [EObject current=null] : ( ( ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL )+ (this_NL_6= RULE_NL )* ) ;
    public final EObject ruleListaItens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_NL_5=null;
        Token this_NL_6=null;
        AntlrDatatypeRuleToken lv_item_2_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:641:28: ( ( ( ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL )+ (this_NL_6= RULE_NL )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:1: ( ( ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL )+ (this_NL_6= RULE_NL )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:1: ( ( ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL )+ (this_NL_6= RULE_NL )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:2: ( ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL )+ (this_NL_6= RULE_NL )*
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:2: ( ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==26) ) {
                    alt21=1;
                }
                else if ( (LA21_0==27) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:3: ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+ (otherlv_3= '|' | otherlv_4= ' |' ) this_NL_5= RULE_NL
            	    {
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:3: ( (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) ) )+
            	    int cnt19=0;
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==26) ) {
            	            int LA19_1 = input.LA(2);

            	            if ( ((LA19_1>=RULE_STRING && LA19_1<=RULE_EXID)) ) {
            	                alt19=1;
            	            }


            	        }
            	        else if ( (LA19_0==27) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:4: (otherlv_0= '|' | otherlv_1= '| ' ) ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) )
            	    	    {
            	    	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:4: (otherlv_0= '|' | otherlv_1= '| ' )
            	    	    int alt18=2;
            	    	    int LA18_0 = input.LA(1);

            	    	    if ( (LA18_0==26) ) {
            	    	        alt18=1;
            	    	    }
            	    	    else if ( (LA18_0==27) ) {
            	    	        alt18=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 18, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt18) {
            	    	        case 1 :
            	    	            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:642:6: otherlv_0= '|'
            	    	            {
            	    	            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleListaItens1489); 

            	    	                	newLeafNode(otherlv_0, grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_0_0_0());
            	    	                

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:647:7: otherlv_1= '| '
            	    	            {
            	    	            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleListaItens1507); 

            	    	                	newLeafNode(otherlv_1, grammarAccess.getListaItensAccess().getVerticalLineSpaceKeyword_0_0_0_1());
            	    	                

            	    	            }
            	    	            break;

            	    	    }

            	    	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:651:2: ( (lv_item_2_0= ruleIDENTIFICADOR_GERAL ) )
            	    	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:652:1: (lv_item_2_0= ruleIDENTIFICADOR_GERAL )
            	    	    {
            	    	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:652:1: (lv_item_2_0= ruleIDENTIFICADOR_GERAL )
            	    	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:653:3: lv_item_2_0= ruleIDENTIFICADOR_GERAL
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getListaItensAccess().getItemIDENTIFICADOR_GERALParserRuleCall_0_0_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleListaItens1529);
            	    	    lv_item_2_0=ruleIDENTIFICADOR_GERAL();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getListaItensRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"item",
            	    	            		lv_item_2_0, 
            	    	            		"IDENTIFICADOR_GERAL");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt19 >= 1 ) break loop19;
            	                EarlyExitException eee =
            	                    new EarlyExitException(19, input);
            	                throw eee;
            	        }
            	        cnt19++;
            	    } while (true);

            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:669:4: (otherlv_3= '|' | otherlv_4= ' |' )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==26) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==28) ) {
            	        alt20=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:669:6: otherlv_3= '|'
            	            {
            	            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleListaItens1544); 

            	                	newLeafNode(otherlv_3, grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:674:7: otherlv_4= ' |'
            	            {
            	            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleListaItens1562); 

            	                	newLeafNode(otherlv_4, grammarAccess.getListaItensAccess().getSpaceVerticalLineKeyword_0_1_1());
            	                

            	            }
            	            break;

            	    }

            	    this_NL_5=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleListaItens1574); 
            	     
            	        newLeafNode(this_NL_5, grammarAccess.getListaItensAccess().getNLTerminalRuleCall_0_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:682:3: (this_NL_6= RULE_NL )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_NL) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:682:4: this_NL_6= RULE_NL
            	    {
            	    this_NL_6=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleListaItens1587); 
            	     
            	        newLeafNode(this_NL_6, grammarAccess.getListaItensAccess().getNLTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end "ruleListaItens"


    // $ANTLR start "entryRuleIDENTIFICADOR_CENARIO"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:694:1: entryRuleIDENTIFICADOR_CENARIO returns [String current=null] : iv_ruleIDENTIFICADOR_CENARIO= ruleIDENTIFICADOR_CENARIO EOF ;
    public final String entryRuleIDENTIFICADOR_CENARIO() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDENTIFICADOR_CENARIO = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:695:2: (iv_ruleIDENTIFICADOR_CENARIO= ruleIDENTIFICADOR_CENARIO EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:696:2: iv_ruleIDENTIFICADOR_CENARIO= ruleIDENTIFICADOR_CENARIO EOF
            {
             newCompositeNode(grammarAccess.getIDENTIFICADOR_CENARIORule()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_CENARIO_in_entryRuleIDENTIFICADOR_CENARIO1625);
            iv_ruleIDENTIFICADOR_CENARIO=ruleIDENTIFICADOR_CENARIO();

            state._fsp--;

             current =iv_ruleIDENTIFICADOR_CENARIO.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDENTIFICADOR_CENARIO1636); 

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
    // $ANTLR end "entryRuleIDENTIFICADOR_CENARIO"


    // $ANTLR start "ruleIDENTIFICADOR_CENARIO"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:703:1: ruleIDENTIFICADOR_CENARIO returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IDENTIFICADOR_GERAL_0= ruleIDENTIFICADOR_GERAL ;
    public final AntlrDatatypeRuleToken ruleIDENTIFICADOR_CENARIO() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_IDENTIFICADOR_GERAL_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:706:28: (this_IDENTIFICADOR_GERAL_0= ruleIDENTIFICADOR_GERAL )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:708:5: this_IDENTIFICADOR_GERAL_0= ruleIDENTIFICADOR_GERAL
            {
             
                    newCompositeNode(grammarAccess.getIDENTIFICADOR_CENARIOAccess().getIDENTIFICADOR_GERALParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleIDENTIFICADOR_CENARIO1682);
            this_IDENTIFICADOR_GERAL_0=ruleIDENTIFICADOR_GERAL();

            state._fsp--;


            		current.merge(this_IDENTIFICADOR_GERAL_0);
                
             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleIDENTIFICADOR_CENARIO"


    // $ANTLR start "entryRuleIDENTIFICADOR_GERAL"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:726:1: entryRuleIDENTIFICADOR_GERAL returns [String current=null] : iv_ruleIDENTIFICADOR_GERAL= ruleIDENTIFICADOR_GERAL EOF ;
    public final String entryRuleIDENTIFICADOR_GERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDENTIFICADOR_GERAL = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:727:2: (iv_ruleIDENTIFICADOR_GERAL= ruleIDENTIFICADOR_GERAL EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:728:2: iv_ruleIDENTIFICADOR_GERAL= ruleIDENTIFICADOR_GERAL EOF
            {
             newCompositeNode(grammarAccess.getIDENTIFICADOR_GERALRule()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_entryRuleIDENTIFICADOR_GERAL1727);
            iv_ruleIDENTIFICADOR_GERAL=ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             current =iv_ruleIDENTIFICADOR_GERAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDENTIFICADOR_GERAL1738); 

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
    // $ANTLR end "entryRuleIDENTIFICADOR_GERAL"


    // $ANTLR start "ruleIDENTIFICADOR_GERAL"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:735:1: ruleIDENTIFICADOR_GERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_STRING_0= RULE_STRING | this_EXID_1= RULE_EXID ) (kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID ) )* ) ;
    public final AntlrDatatypeRuleToken ruleIDENTIFICADOR_GERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_EXID_1=null;
        Token kw=null;
        Token this_STRING_3=null;
        Token this_EXID_4=null;

         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:738:28: ( ( (this_STRING_0= RULE_STRING | this_EXID_1= RULE_EXID ) (kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID ) )* ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:739:1: ( (this_STRING_0= RULE_STRING | this_EXID_1= RULE_EXID ) (kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID ) )* )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:739:1: ( (this_STRING_0= RULE_STRING | this_EXID_1= RULE_EXID ) (kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID ) )* )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:739:2: (this_STRING_0= RULE_STRING | this_EXID_1= RULE_EXID ) (kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID ) )*
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:739:2: (this_STRING_0= RULE_STRING | this_EXID_1= RULE_EXID )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_STRING) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_EXID) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:739:7: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIDENTIFICADOR_GERAL1779); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getIDENTIFICADOR_GERALAccess().getSTRINGTerminalRuleCall_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:747:10: this_EXID_1= RULE_EXID
                    {
                    this_EXID_1=(Token)match(input,RULE_EXID,FOLLOW_RULE_EXID_in_ruleIDENTIFICADOR_GERAL1805); 

                    		current.merge(this_EXID_1);
                        
                     
                        newLeafNode(this_EXID_1, grammarAccess.getIDENTIFICADOR_GERALAccess().getEXIDTerminalRuleCall_0_1()); 
                        

                    }
                    break;

            }

            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:754:2: (kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:755:2: kw= ' ' (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID )
            	    {
            	    kw=(Token)match(input,29,FOLLOW_29_in_ruleIDENTIFICADOR_GERAL1825); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getIDENTIFICADOR_GERALAccess().getSpaceKeyword_1_0()); 
            	        
            	    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:760:1: (this_STRING_3= RULE_STRING | this_EXID_4= RULE_EXID )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RULE_STRING) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==RULE_EXID) ) {
            	        alt24=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:760:6: this_STRING_3= RULE_STRING
            	            {
            	            this_STRING_3=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIDENTIFICADOR_GERAL1841); 

            	            		current.merge(this_STRING_3);
            	                
            	             
            	                newLeafNode(this_STRING_3, grammarAccess.getIDENTIFICADOR_GERALAccess().getSTRINGTerminalRuleCall_1_1_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:768:10: this_EXID_4= RULE_EXID
            	            {
            	            this_EXID_4=(Token)match(input,RULE_EXID,FOLLOW_RULE_EXID_in_ruleIDENTIFICADOR_GERAL1867); 

            	            		current.merge(this_EXID_4);
            	                
            	             
            	                newLeafNode(this_EXID_4, grammarAccess.getIDENTIFICADOR_GERALAccess().getEXIDTerminalRuleCall_1_1_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // $ANTLR end "ruleIDENTIFICADOR_GERAL"


    // $ANTLR start "entryRuleNOME_DO_ATOR"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:783:1: entryRuleNOME_DO_ATOR returns [EObject current=null] : iv_ruleNOME_DO_ATOR= ruleNOME_DO_ATOR EOF ;
    public final EObject entryRuleNOME_DO_ATOR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNOME_DO_ATOR = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:784:2: (iv_ruleNOME_DO_ATOR= ruleNOME_DO_ATOR EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:785:2: iv_ruleNOME_DO_ATOR= ruleNOME_DO_ATOR EOF
            {
             newCompositeNode(grammarAccess.getNOME_DO_ATORRule()); 
            pushFollow(FOLLOW_ruleNOME_DO_ATOR_in_entryRuleNOME_DO_ATOR1915);
            iv_ruleNOME_DO_ATOR=ruleNOME_DO_ATOR();

            state._fsp--;

             current =iv_ruleNOME_DO_ATOR; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNOME_DO_ATOR1925); 

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
    // $ANTLR end "entryRuleNOME_DO_ATOR"


    // $ANTLR start "ruleNOME_DO_ATOR"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:792:1: ruleNOME_DO_ATOR returns [EObject current=null] : ( (lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL ) ) ;
    public final EObject ruleNOME_DO_ATOR() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_nome_do_ator_0_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:795:28: ( ( (lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL ) ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:796:1: ( (lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL ) )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:796:1: ( (lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:797:1: (lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:797:1: (lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:798:3: lv_nome_do_ator_0_0= ruleIDENTIFICADOR_GERAL
            {
             
            	        newCompositeNode(grammarAccess.getNOME_DO_ATORAccess().getNome_do_atorIDENTIFICADOR_GERALParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleNOME_DO_ATOR1970);
            lv_nome_do_ator_0_0=ruleIDENTIFICADOR_GERAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNOME_DO_ATORRule());
            	        }
                   		set(
                   			current, 
                   			"nome_do_ator",
                    		lv_nome_do_ator_0_0, 
                    		"IDENTIFICADOR_GERAL");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleNOME_DO_ATOR"


    // $ANTLR start "entryRuleMETA_A_SER_ALCANCADA"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:822:1: entryRuleMETA_A_SER_ALCANCADA returns [EObject current=null] : iv_ruleMETA_A_SER_ALCANCADA= ruleMETA_A_SER_ALCANCADA EOF ;
    public final EObject entryRuleMETA_A_SER_ALCANCADA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMETA_A_SER_ALCANCADA = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:823:2: (iv_ruleMETA_A_SER_ALCANCADA= ruleMETA_A_SER_ALCANCADA EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:824:2: iv_ruleMETA_A_SER_ALCANCADA= ruleMETA_A_SER_ALCANCADA EOF
            {
             newCompositeNode(grammarAccess.getMETA_A_SER_ALCANCADARule()); 
            pushFollow(FOLLOW_ruleMETA_A_SER_ALCANCADA_in_entryRuleMETA_A_SER_ALCANCADA2005);
            iv_ruleMETA_A_SER_ALCANCADA=ruleMETA_A_SER_ALCANCADA();

            state._fsp--;

             current =iv_ruleMETA_A_SER_ALCANCADA; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMETA_A_SER_ALCANCADA2015); 

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
    // $ANTLR end "entryRuleMETA_A_SER_ALCANCADA"


    // $ANTLR start "ruleMETA_A_SER_ALCANCADA"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:831:1: ruleMETA_A_SER_ALCANCADA returns [EObject current=null] : ( (lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL ) ) ;
    public final EObject ruleMETA_A_SER_ALCANCADA() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_meta_a_ser_alcancada_0_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:834:28: ( ( (lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL ) ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:835:1: ( (lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL ) )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:835:1: ( (lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:836:1: (lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:836:1: (lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:837:3: lv_meta_a_ser_alcancada_0_0= ruleIDENTIFICADOR_GERAL
            {
             
            	        newCompositeNode(grammarAccess.getMETA_A_SER_ALCANCADAAccess().getMeta_a_ser_alcancadaIDENTIFICADOR_GERALParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleMETA_A_SER_ALCANCADA2060);
            lv_meta_a_ser_alcancada_0_0=ruleIDENTIFICADOR_GERAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMETA_A_SER_ALCANCADARule());
            	        }
                   		set(
                   			current, 
                   			"meta_a_ser_alcancada",
                    		lv_meta_a_ser_alcancada_0_0, 
                    		"IDENTIFICADOR_GERAL");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleMETA_A_SER_ALCANCADA"


    // $ANTLR start "entryRuleRAZAO_PARA_ALCANCAR_A_META"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:861:1: entryRuleRAZAO_PARA_ALCANCAR_A_META returns [EObject current=null] : iv_ruleRAZAO_PARA_ALCANCAR_A_META= ruleRAZAO_PARA_ALCANCAR_A_META EOF ;
    public final EObject entryRuleRAZAO_PARA_ALCANCAR_A_META() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRAZAO_PARA_ALCANCAR_A_META = null;


        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:862:2: (iv_ruleRAZAO_PARA_ALCANCAR_A_META= ruleRAZAO_PARA_ALCANCAR_A_META EOF )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:863:2: iv_ruleRAZAO_PARA_ALCANCAR_A_META= ruleRAZAO_PARA_ALCANCAR_A_META EOF
            {
             newCompositeNode(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METARule()); 
            pushFollow(FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_entryRuleRAZAO_PARA_ALCANCAR_A_META2095);
            iv_ruleRAZAO_PARA_ALCANCAR_A_META=ruleRAZAO_PARA_ALCANCAR_A_META();

            state._fsp--;

             current =iv_ruleRAZAO_PARA_ALCANCAR_A_META; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRAZAO_PARA_ALCANCAR_A_META2105); 

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
    // $ANTLR end "entryRuleRAZAO_PARA_ALCANCAR_A_META"


    // $ANTLR start "ruleRAZAO_PARA_ALCANCAR_A_META"
    // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:870:1: ruleRAZAO_PARA_ALCANCAR_A_META returns [EObject current=null] : ( (lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL ) ) ;
    public final EObject ruleRAZAO_PARA_ALCANCAR_A_META() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_razao_para_alcancar_a_meta_0_0 = null;


         enterRule(); 
            
        try {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:873:28: ( ( (lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL ) ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:874:1: ( (lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL ) )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:874:1: ( (lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:875:1: (lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:875:1: (lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL )
            // ../storydsl/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/parser/antlr/internal/InternalStoryDsl.g:876:3: lv_razao_para_alcancar_a_meta_0_0= ruleIDENTIFICADOR_GERAL
            {
             
            	        newCompositeNode(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METAAccess().getRazao_para_alcancar_a_metaIDENTIFICADOR_GERALParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleRAZAO_PARA_ALCANCAR_A_META2150);
            lv_razao_para_alcancar_a_meta_0_0=ruleIDENTIFICADOR_GERAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METARule());
            	        }
                   		set(
                   			current, 
                   			"razao_para_alcancar_a_meta",
                    		lv_razao_para_alcancar_a_meta_0_0, 
                    		"IDENTIFICADOR_GERAL");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleRAZAO_PARA_ALCANCAR_A_META"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleModel122 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleFuncionalidade_in_ruleModel144 = new BitSet(new long[]{0x0000000000022010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleModel156 = new BitSet(new long[]{0x0000000000022010L});
    public static final BitSet FOLLOW_ruleUsuarioMetaRazao_in_ruleModel178 = new BitSet(new long[]{0x0000000000022010L});
    public static final BitSet FOLLOW_ruleCenario_in_ruleModel200 = new BitSet(new long[]{0x0000000000022012L});
    public static final BitSet FOLLOW_ruleUsuarioMetaRazao_in_entryRuleUsuarioMetaRazao237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUsuarioMetaRazao247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleUsuarioMetaRazao284 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleNOME_DO_ATOR_in_ruleUsuarioMetaRazao305 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleUsuarioMetaRazao317 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleUsuarioMetaRazao330 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleMETA_A_SER_ALCANCADA_in_ruleUsuarioMetaRazao351 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleUsuarioMetaRazao363 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleUsuarioMetaRazao376 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_ruleUsuarioMetaRazao397 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleUsuarioMetaRazao409 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFuncionalidade_in_entryRuleFuncionalidade446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFuncionalidade456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleFuncionalidade493 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleFuncionalidade514 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleFuncionalidade526 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleCenario_in_entryRuleCenario563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCenario573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleCenario610 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleIdentificadorCenario_in_ruleCenario632 = new BitSet(new long[]{0x000000000FE40012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleCenario648 = new BitSet(new long[]{0x000000000FE40012L});
    public static final BitSet FOLLOW_ruleSentencaQualite_in_ruleCenario675 = new BitSet(new long[]{0x000000000FE40002L});
    public static final BitSet FOLLOW_ruleIdentificadorCenario_in_entryRuleIdentificadorCenario712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentificadorCenario722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_CENARIO_in_ruleIdentificadorCenario767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSentencaQualite_in_entryRuleSentencaQualite802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSentencaQualite812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutarCenario_in_ruleSentencaQualite859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListaItens_in_ruleSentencaQualite886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMeta_in_ruleSentencaQualite913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMeta_in_entryRuleMeta948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMeta958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleMeta1001 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleMeta1026 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_ruleListaMetas_in_ruleMeta1048 = new BitSet(new long[]{0x0000000000180012L});
    public static final BitSet FOLLOW_ruleListaMetas_in_entryRuleListaMetas1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListaMetas1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleListaMetas1136 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_20_in_ruleListaMetas1155 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleListaMetas1178 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleListaMetas1199 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExecutarCenario_in_entryRuleExecutarCenario1246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutarCenario1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleExecutarCenario1294 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_22_in_ruleExecutarCenario1312 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_23_in_ruleExecutarCenario1330 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_24_in_ruleExecutarCenario1348 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_25_in_ruleExecutarCenario1366 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_CENARIO_in_ruleExecutarCenario1390 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleExecutarCenario1402 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleListaItens_in_entryRuleListaItens1439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListaItens1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleListaItens1489 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_27_in_ruleListaItens1507 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleListaItens1529 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_26_in_ruleListaItens1544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_28_in_ruleListaItens1562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleListaItens1574 = new BitSet(new long[]{0x000000000C000012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleListaItens1587 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_CENARIO_in_entryRuleIDENTIFICADOR_CENARIO1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDENTIFICADOR_CENARIO1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleIDENTIFICADOR_CENARIO1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_entryRuleIDENTIFICADOR_GERAL1727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDENTIFICADOR_GERAL1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIDENTIFICADOR_GERAL1779 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_RULE_EXID_in_ruleIDENTIFICADOR_GERAL1805 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleIDENTIFICADOR_GERAL1825 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIDENTIFICADOR_GERAL1841 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_RULE_EXID_in_ruleIDENTIFICADOR_GERAL1867 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleNOME_DO_ATOR_in_entryRuleNOME_DO_ATOR1915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNOME_DO_ATOR1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleNOME_DO_ATOR1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMETA_A_SER_ALCANCADA_in_entryRuleMETA_A_SER_ALCANCADA2005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMETA_A_SER_ALCANCADA2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleMETA_A_SER_ALCANCADA2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_entryRuleRAZAO_PARA_ALCANCAR_A_META2095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRAZAO_PARA_ALCANCAR_A_META2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleRAZAO_PARA_ALCANCAR_A_META2150 = new BitSet(new long[]{0x0000000000000002L});

}