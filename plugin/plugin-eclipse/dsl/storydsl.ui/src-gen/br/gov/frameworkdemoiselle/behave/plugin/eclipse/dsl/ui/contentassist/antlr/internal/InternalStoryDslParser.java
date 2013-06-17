package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.ui.contentassist.antlr.internal; 

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
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.services.StoryDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_EXID", "RULE_NL", "RULE_INT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ID", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'@'", "'@ '", "'Dado '", "'Quando '", "'Ent\\u00E3o '", "'E '", "'Mas '", "'|'", "'| '", "' |'", "'Como um: '", "'Eu quero: '", "'De modo que: '", "'Funcionalidade: '", "'Cen\\u00E1rio: '", "' '", "'Meta:'"
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
    public static final int RULE_NL=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
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


        public InternalStoryDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStoryDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStoryDslParser.tokenNames; }
    public String getGrammarFileName() { return "../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g"; }


     
     	private StoryDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(StoryDslGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModel"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:61:1: ( ruleModel EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:76:1: ( rule__Model__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUsuarioMetaRazao"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:88:1: entryRuleUsuarioMetaRazao : ruleUsuarioMetaRazao EOF ;
    public final void entryRuleUsuarioMetaRazao() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:89:1: ( ruleUsuarioMetaRazao EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:90:1: ruleUsuarioMetaRazao EOF
            {
             before(grammarAccess.getUsuarioMetaRazaoRule()); 
            pushFollow(FOLLOW_ruleUsuarioMetaRazao_in_entryRuleUsuarioMetaRazao121);
            ruleUsuarioMetaRazao();

            state._fsp--;

             after(grammarAccess.getUsuarioMetaRazaoRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUsuarioMetaRazao128); 

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
    // $ANTLR end "entryRuleUsuarioMetaRazao"


    // $ANTLR start "ruleUsuarioMetaRazao"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:97:1: ruleUsuarioMetaRazao : ( ( rule__UsuarioMetaRazao__Group__0 ) ) ;
    public final void ruleUsuarioMetaRazao() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:101:2: ( ( ( rule__UsuarioMetaRazao__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:102:1: ( ( rule__UsuarioMetaRazao__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:102:1: ( ( rule__UsuarioMetaRazao__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:103:1: ( rule__UsuarioMetaRazao__Group__0 )
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:104:1: ( rule__UsuarioMetaRazao__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:104:2: rule__UsuarioMetaRazao__Group__0
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__0_in_ruleUsuarioMetaRazao154);
            rule__UsuarioMetaRazao__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUsuarioMetaRazaoAccess().getGroup()); 

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
    // $ANTLR end "ruleUsuarioMetaRazao"


    // $ANTLR start "entryRuleFuncionalidade"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:116:1: entryRuleFuncionalidade : ruleFuncionalidade EOF ;
    public final void entryRuleFuncionalidade() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:117:1: ( ruleFuncionalidade EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:118:1: ruleFuncionalidade EOF
            {
             before(grammarAccess.getFuncionalidadeRule()); 
            pushFollow(FOLLOW_ruleFuncionalidade_in_entryRuleFuncionalidade181);
            ruleFuncionalidade();

            state._fsp--;

             after(grammarAccess.getFuncionalidadeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFuncionalidade188); 

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
    // $ANTLR end "entryRuleFuncionalidade"


    // $ANTLR start "ruleFuncionalidade"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:125:1: ruleFuncionalidade : ( ( rule__Funcionalidade__Group__0 ) ) ;
    public final void ruleFuncionalidade() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:129:2: ( ( ( rule__Funcionalidade__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:130:1: ( ( rule__Funcionalidade__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:130:1: ( ( rule__Funcionalidade__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:131:1: ( rule__Funcionalidade__Group__0 )
            {
             before(grammarAccess.getFuncionalidadeAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:132:1: ( rule__Funcionalidade__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:132:2: rule__Funcionalidade__Group__0
            {
            pushFollow(FOLLOW_rule__Funcionalidade__Group__0_in_ruleFuncionalidade214);
            rule__Funcionalidade__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFuncionalidadeAccess().getGroup()); 

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
    // $ANTLR end "ruleFuncionalidade"


    // $ANTLR start "entryRuleCenario"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:144:1: entryRuleCenario : ruleCenario EOF ;
    public final void entryRuleCenario() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:145:1: ( ruleCenario EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:146:1: ruleCenario EOF
            {
             before(grammarAccess.getCenarioRule()); 
            pushFollow(FOLLOW_ruleCenario_in_entryRuleCenario241);
            ruleCenario();

            state._fsp--;

             after(grammarAccess.getCenarioRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCenario248); 

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
    // $ANTLR end "entryRuleCenario"


    // $ANTLR start "ruleCenario"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:153:1: ruleCenario : ( ( rule__Cenario__Group__0 ) ) ;
    public final void ruleCenario() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:157:2: ( ( ( rule__Cenario__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:158:1: ( ( rule__Cenario__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:158:1: ( ( rule__Cenario__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:159:1: ( rule__Cenario__Group__0 )
            {
             before(grammarAccess.getCenarioAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:160:1: ( rule__Cenario__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:160:2: rule__Cenario__Group__0
            {
            pushFollow(FOLLOW_rule__Cenario__Group__0_in_ruleCenario274);
            rule__Cenario__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCenarioAccess().getGroup()); 

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
    // $ANTLR end "ruleCenario"


    // $ANTLR start "entryRuleIdentificadorCenario"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:172:1: entryRuleIdentificadorCenario : ruleIdentificadorCenario EOF ;
    public final void entryRuleIdentificadorCenario() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:173:1: ( ruleIdentificadorCenario EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:174:1: ruleIdentificadorCenario EOF
            {
             before(grammarAccess.getIdentificadorCenarioRule()); 
            pushFollow(FOLLOW_ruleIdentificadorCenario_in_entryRuleIdentificadorCenario301);
            ruleIdentificadorCenario();

            state._fsp--;

             after(grammarAccess.getIdentificadorCenarioRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentificadorCenario308); 

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
    // $ANTLR end "entryRuleIdentificadorCenario"


    // $ANTLR start "ruleIdentificadorCenario"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:181:1: ruleIdentificadorCenario : ( ( rule__IdentificadorCenario__NameAssignment ) ) ;
    public final void ruleIdentificadorCenario() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:185:2: ( ( ( rule__IdentificadorCenario__NameAssignment ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:186:1: ( ( rule__IdentificadorCenario__NameAssignment ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:186:1: ( ( rule__IdentificadorCenario__NameAssignment ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:187:1: ( rule__IdentificadorCenario__NameAssignment )
            {
             before(grammarAccess.getIdentificadorCenarioAccess().getNameAssignment()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:188:1: ( rule__IdentificadorCenario__NameAssignment )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:188:2: rule__IdentificadorCenario__NameAssignment
            {
            pushFollow(FOLLOW_rule__IdentificadorCenario__NameAssignment_in_ruleIdentificadorCenario334);
            rule__IdentificadorCenario__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIdentificadorCenarioAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleIdentificadorCenario"


    // $ANTLR start "entryRuleSentencaQualite"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:200:1: entryRuleSentencaQualite : ruleSentencaQualite EOF ;
    public final void entryRuleSentencaQualite() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:201:1: ( ruleSentencaQualite EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:202:1: ruleSentencaQualite EOF
            {
             before(grammarAccess.getSentencaQualiteRule()); 
            pushFollow(FOLLOW_ruleSentencaQualite_in_entryRuleSentencaQualite361);
            ruleSentencaQualite();

            state._fsp--;

             after(grammarAccess.getSentencaQualiteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSentencaQualite368); 

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
    // $ANTLR end "entryRuleSentencaQualite"


    // $ANTLR start "ruleSentencaQualite"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:209:1: ruleSentencaQualite : ( ( rule__SentencaQualite__Alternatives ) ) ;
    public final void ruleSentencaQualite() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:213:2: ( ( ( rule__SentencaQualite__Alternatives ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:214:1: ( ( rule__SentencaQualite__Alternatives ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:214:1: ( ( rule__SentencaQualite__Alternatives ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:215:1: ( rule__SentencaQualite__Alternatives )
            {
             before(grammarAccess.getSentencaQualiteAccess().getAlternatives()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:216:1: ( rule__SentencaQualite__Alternatives )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:216:2: rule__SentencaQualite__Alternatives
            {
            pushFollow(FOLLOW_rule__SentencaQualite__Alternatives_in_ruleSentencaQualite394);
            rule__SentencaQualite__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSentencaQualiteAccess().getAlternatives()); 

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
    // $ANTLR end "ruleSentencaQualite"


    // $ANTLR start "entryRuleMeta"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:228:1: entryRuleMeta : ruleMeta EOF ;
    public final void entryRuleMeta() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:229:1: ( ruleMeta EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:230:1: ruleMeta EOF
            {
             before(grammarAccess.getMetaRule()); 
            pushFollow(FOLLOW_ruleMeta_in_entryRuleMeta421);
            ruleMeta();

            state._fsp--;

             after(grammarAccess.getMetaRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMeta428); 

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
    // $ANTLR end "entryRuleMeta"


    // $ANTLR start "ruleMeta"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:237:1: ruleMeta : ( ( rule__Meta__Group__0 ) ) ;
    public final void ruleMeta() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:241:2: ( ( ( rule__Meta__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:242:1: ( ( rule__Meta__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:242:1: ( ( rule__Meta__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:243:1: ( rule__Meta__Group__0 )
            {
             before(grammarAccess.getMetaAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:244:1: ( rule__Meta__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:244:2: rule__Meta__Group__0
            {
            pushFollow(FOLLOW_rule__Meta__Group__0_in_ruleMeta454);
            rule__Meta__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetaAccess().getGroup()); 

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
    // $ANTLR end "ruleMeta"


    // $ANTLR start "entryRuleListaMetas"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:256:1: entryRuleListaMetas : ruleListaMetas EOF ;
    public final void entryRuleListaMetas() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:257:1: ( ruleListaMetas EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:258:1: ruleListaMetas EOF
            {
             before(grammarAccess.getListaMetasRule()); 
            pushFollow(FOLLOW_ruleListaMetas_in_entryRuleListaMetas481);
            ruleListaMetas();

            state._fsp--;

             after(grammarAccess.getListaMetasRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListaMetas488); 

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
    // $ANTLR end "entryRuleListaMetas"


    // $ANTLR start "ruleListaMetas"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:265:1: ruleListaMetas : ( ( rule__ListaMetas__Group__0 ) ) ;
    public final void ruleListaMetas() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:269:2: ( ( ( rule__ListaMetas__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:270:1: ( ( rule__ListaMetas__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:270:1: ( ( rule__ListaMetas__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:271:1: ( rule__ListaMetas__Group__0 )
            {
             before(grammarAccess.getListaMetasAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:272:1: ( rule__ListaMetas__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:272:2: rule__ListaMetas__Group__0
            {
            pushFollow(FOLLOW_rule__ListaMetas__Group__0_in_ruleListaMetas514);
            rule__ListaMetas__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getListaMetasAccess().getGroup()); 

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
    // $ANTLR end "ruleListaMetas"


    // $ANTLR start "entryRuleExecutarCenario"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:284:1: entryRuleExecutarCenario : ruleExecutarCenario EOF ;
    public final void entryRuleExecutarCenario() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:285:1: ( ruleExecutarCenario EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:286:1: ruleExecutarCenario EOF
            {
             before(grammarAccess.getExecutarCenarioRule()); 
            pushFollow(FOLLOW_ruleExecutarCenario_in_entryRuleExecutarCenario541);
            ruleExecutarCenario();

            state._fsp--;

             after(grammarAccess.getExecutarCenarioRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutarCenario548); 

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
    // $ANTLR end "entryRuleExecutarCenario"


    // $ANTLR start "ruleExecutarCenario"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:293:1: ruleExecutarCenario : ( ( rule__ExecutarCenario__Group__0 ) ) ;
    public final void ruleExecutarCenario() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:297:2: ( ( ( rule__ExecutarCenario__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:298:1: ( ( rule__ExecutarCenario__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:298:1: ( ( rule__ExecutarCenario__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:299:1: ( rule__ExecutarCenario__Group__0 )
            {
             before(grammarAccess.getExecutarCenarioAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:300:1: ( rule__ExecutarCenario__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:300:2: rule__ExecutarCenario__Group__0
            {
            pushFollow(FOLLOW_rule__ExecutarCenario__Group__0_in_ruleExecutarCenario574);
            rule__ExecutarCenario__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExecutarCenarioAccess().getGroup()); 

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
    // $ANTLR end "ruleExecutarCenario"


    // $ANTLR start "entryRuleListaItens"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:312:1: entryRuleListaItens : ruleListaItens EOF ;
    public final void entryRuleListaItens() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:313:1: ( ruleListaItens EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:314:1: ruleListaItens EOF
            {
             before(grammarAccess.getListaItensRule()); 
            pushFollow(FOLLOW_ruleListaItens_in_entryRuleListaItens601);
            ruleListaItens();

            state._fsp--;

             after(grammarAccess.getListaItensRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListaItens608); 

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
    // $ANTLR end "entryRuleListaItens"


    // $ANTLR start "ruleListaItens"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:321:1: ruleListaItens : ( ( rule__ListaItens__Group__0 ) ) ;
    public final void ruleListaItens() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:325:2: ( ( ( rule__ListaItens__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:326:1: ( ( rule__ListaItens__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:326:1: ( ( rule__ListaItens__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:327:1: ( rule__ListaItens__Group__0 )
            {
             before(grammarAccess.getListaItensAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:328:1: ( rule__ListaItens__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:328:2: rule__ListaItens__Group__0
            {
            pushFollow(FOLLOW_rule__ListaItens__Group__0_in_ruleListaItens634);
            rule__ListaItens__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getListaItensAccess().getGroup()); 

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
    // $ANTLR end "ruleListaItens"


    // $ANTLR start "entryRuleIDENTIFICADOR_CENARIO"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:340:1: entryRuleIDENTIFICADOR_CENARIO : ruleIDENTIFICADOR_CENARIO EOF ;
    public final void entryRuleIDENTIFICADOR_CENARIO() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:341:1: ( ruleIDENTIFICADOR_CENARIO EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:342:1: ruleIDENTIFICADOR_CENARIO EOF
            {
             before(grammarAccess.getIDENTIFICADOR_CENARIORule()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_CENARIO_in_entryRuleIDENTIFICADOR_CENARIO661);
            ruleIDENTIFICADOR_CENARIO();

            state._fsp--;

             after(grammarAccess.getIDENTIFICADOR_CENARIORule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDENTIFICADOR_CENARIO668); 

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
    // $ANTLR end "entryRuleIDENTIFICADOR_CENARIO"


    // $ANTLR start "ruleIDENTIFICADOR_CENARIO"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:349:1: ruleIDENTIFICADOR_CENARIO : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void ruleIDENTIFICADOR_CENARIO() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:353:2: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:354:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:354:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:355:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getIDENTIFICADOR_CENARIOAccess().getIDENTIFICADOR_GERALParserRuleCall()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleIDENTIFICADOR_CENARIO694);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getIDENTIFICADOR_CENARIOAccess().getIDENTIFICADOR_GERALParserRuleCall()); 

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
    // $ANTLR end "ruleIDENTIFICADOR_CENARIO"


    // $ANTLR start "entryRuleIDENTIFICADOR_GERAL"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:368:1: entryRuleIDENTIFICADOR_GERAL : ruleIDENTIFICADOR_GERAL EOF ;
    public final void entryRuleIDENTIFICADOR_GERAL() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:369:1: ( ruleIDENTIFICADOR_GERAL EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:370:1: ruleIDENTIFICADOR_GERAL EOF
            {
             before(grammarAccess.getIDENTIFICADOR_GERALRule()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_entryRuleIDENTIFICADOR_GERAL720);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getIDENTIFICADOR_GERALRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDENTIFICADOR_GERAL727); 

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
    // $ANTLR end "entryRuleIDENTIFICADOR_GERAL"


    // $ANTLR start "ruleIDENTIFICADOR_GERAL"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:377:1: ruleIDENTIFICADOR_GERAL : ( ( rule__IDENTIFICADOR_GERAL__Group__0 ) ) ;
    public final void ruleIDENTIFICADOR_GERAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:381:2: ( ( ( rule__IDENTIFICADOR_GERAL__Group__0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:382:1: ( ( rule__IDENTIFICADOR_GERAL__Group__0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:382:1: ( ( rule__IDENTIFICADOR_GERAL__Group__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:383:1: ( rule__IDENTIFICADOR_GERAL__Group__0 )
            {
             before(grammarAccess.getIDENTIFICADOR_GERALAccess().getGroup()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:384:1: ( rule__IDENTIFICADOR_GERAL__Group__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:384:2: rule__IDENTIFICADOR_GERAL__Group__0
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group__0_in_ruleIDENTIFICADOR_GERAL753);
            rule__IDENTIFICADOR_GERAL__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIDENTIFICADOR_GERALAccess().getGroup()); 

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
    // $ANTLR end "ruleIDENTIFICADOR_GERAL"


    // $ANTLR start "entryRuleNOME_DO_ATOR"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:396:1: entryRuleNOME_DO_ATOR : ruleNOME_DO_ATOR EOF ;
    public final void entryRuleNOME_DO_ATOR() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:397:1: ( ruleNOME_DO_ATOR EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:398:1: ruleNOME_DO_ATOR EOF
            {
             before(grammarAccess.getNOME_DO_ATORRule()); 
            pushFollow(FOLLOW_ruleNOME_DO_ATOR_in_entryRuleNOME_DO_ATOR780);
            ruleNOME_DO_ATOR();

            state._fsp--;

             after(grammarAccess.getNOME_DO_ATORRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNOME_DO_ATOR787); 

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
    // $ANTLR end "entryRuleNOME_DO_ATOR"


    // $ANTLR start "ruleNOME_DO_ATOR"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:405:1: ruleNOME_DO_ATOR : ( ( rule__NOME_DO_ATOR__Nome_do_atorAssignment ) ) ;
    public final void ruleNOME_DO_ATOR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:409:2: ( ( ( rule__NOME_DO_ATOR__Nome_do_atorAssignment ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:410:1: ( ( rule__NOME_DO_ATOR__Nome_do_atorAssignment ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:410:1: ( ( rule__NOME_DO_ATOR__Nome_do_atorAssignment ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:411:1: ( rule__NOME_DO_ATOR__Nome_do_atorAssignment )
            {
             before(grammarAccess.getNOME_DO_ATORAccess().getNome_do_atorAssignment()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:412:1: ( rule__NOME_DO_ATOR__Nome_do_atorAssignment )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:412:2: rule__NOME_DO_ATOR__Nome_do_atorAssignment
            {
            pushFollow(FOLLOW_rule__NOME_DO_ATOR__Nome_do_atorAssignment_in_ruleNOME_DO_ATOR813);
            rule__NOME_DO_ATOR__Nome_do_atorAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNOME_DO_ATORAccess().getNome_do_atorAssignment()); 

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
    // $ANTLR end "ruleNOME_DO_ATOR"


    // $ANTLR start "entryRuleMETA_A_SER_ALCANCADA"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:424:1: entryRuleMETA_A_SER_ALCANCADA : ruleMETA_A_SER_ALCANCADA EOF ;
    public final void entryRuleMETA_A_SER_ALCANCADA() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:425:1: ( ruleMETA_A_SER_ALCANCADA EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:426:1: ruleMETA_A_SER_ALCANCADA EOF
            {
             before(grammarAccess.getMETA_A_SER_ALCANCADARule()); 
            pushFollow(FOLLOW_ruleMETA_A_SER_ALCANCADA_in_entryRuleMETA_A_SER_ALCANCADA840);
            ruleMETA_A_SER_ALCANCADA();

            state._fsp--;

             after(grammarAccess.getMETA_A_SER_ALCANCADARule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMETA_A_SER_ALCANCADA847); 

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
    // $ANTLR end "entryRuleMETA_A_SER_ALCANCADA"


    // $ANTLR start "ruleMETA_A_SER_ALCANCADA"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:433:1: ruleMETA_A_SER_ALCANCADA : ( ( rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment ) ) ;
    public final void ruleMETA_A_SER_ALCANCADA() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:437:2: ( ( ( rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:438:1: ( ( rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:438:1: ( ( rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:439:1: ( rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment )
            {
             before(grammarAccess.getMETA_A_SER_ALCANCADAAccess().getMeta_a_ser_alcancadaAssignment()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:440:1: ( rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:440:2: rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment
            {
            pushFollow(FOLLOW_rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment_in_ruleMETA_A_SER_ALCANCADA873);
            rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMETA_A_SER_ALCANCADAAccess().getMeta_a_ser_alcancadaAssignment()); 

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
    // $ANTLR end "ruleMETA_A_SER_ALCANCADA"


    // $ANTLR start "entryRuleRAZAO_PARA_ALCANCAR_A_META"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:452:1: entryRuleRAZAO_PARA_ALCANCAR_A_META : ruleRAZAO_PARA_ALCANCAR_A_META EOF ;
    public final void entryRuleRAZAO_PARA_ALCANCAR_A_META() throws RecognitionException {
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:453:1: ( ruleRAZAO_PARA_ALCANCAR_A_META EOF )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:454:1: ruleRAZAO_PARA_ALCANCAR_A_META EOF
            {
             before(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METARule()); 
            pushFollow(FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_entryRuleRAZAO_PARA_ALCANCAR_A_META900);
            ruleRAZAO_PARA_ALCANCAR_A_META();

            state._fsp--;

             after(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METARule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRAZAO_PARA_ALCANCAR_A_META907); 

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
    // $ANTLR end "entryRuleRAZAO_PARA_ALCANCAR_A_META"


    // $ANTLR start "ruleRAZAO_PARA_ALCANCAR_A_META"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:461:1: ruleRAZAO_PARA_ALCANCAR_A_META : ( ( rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment ) ) ;
    public final void ruleRAZAO_PARA_ALCANCAR_A_META() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:465:2: ( ( ( rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:466:1: ( ( rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:466:1: ( ( rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:467:1: ( rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment )
            {
             before(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METAAccess().getRazao_para_alcancar_a_metaAssignment()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:468:1: ( rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:468:2: rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment
            {
            pushFollow(FOLLOW_rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment_in_ruleRAZAO_PARA_ALCANCAR_A_META933);
            rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METAAccess().getRazao_para_alcancar_a_metaAssignment()); 

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
    // $ANTLR end "ruleRAZAO_PARA_ALCANCAR_A_META"


    // $ANTLR start "rule__SentencaQualite__Alternatives"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:480:1: rule__SentencaQualite__Alternatives : ( ( ruleExecutarCenario ) | ( ruleListaItens ) | ( ruleMeta ) );
    public final void rule__SentencaQualite__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:484:1: ( ( ruleExecutarCenario ) | ( ruleListaItens ) | ( ruleMeta ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                {
                alt1=1;
                }
                break;
            case 20:
            case 21:
                {
                alt1=2;
                }
                break;
            case 29:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:485:1: ( ruleExecutarCenario )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:485:1: ( ruleExecutarCenario )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:486:1: ruleExecutarCenario
                    {
                     before(grammarAccess.getSentencaQualiteAccess().getExecutarCenarioParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleExecutarCenario_in_rule__SentencaQualite__Alternatives969);
                    ruleExecutarCenario();

                    state._fsp--;

                     after(grammarAccess.getSentencaQualiteAccess().getExecutarCenarioParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:491:6: ( ruleListaItens )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:491:6: ( ruleListaItens )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:492:1: ruleListaItens
                    {
                     before(grammarAccess.getSentencaQualiteAccess().getListaItensParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleListaItens_in_rule__SentencaQualite__Alternatives986);
                    ruleListaItens();

                    state._fsp--;

                     after(grammarAccess.getSentencaQualiteAccess().getListaItensParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:497:6: ( ruleMeta )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:497:6: ( ruleMeta )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:498:1: ruleMeta
                    {
                     before(grammarAccess.getSentencaQualiteAccess().getMetaParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleMeta_in_rule__SentencaQualite__Alternatives1003);
                    ruleMeta();

                    state._fsp--;

                     after(grammarAccess.getSentencaQualiteAccess().getMetaParserRuleCall_2()); 

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
    // $ANTLR end "rule__SentencaQualite__Alternatives"


    // $ANTLR start "rule__ListaMetas__Alternatives_0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:508:1: rule__ListaMetas__Alternatives_0 : ( ( '@' ) | ( '@ ' ) );
    public final void rule__ListaMetas__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:512:1: ( ( '@' ) | ( '@ ' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:513:1: ( '@' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:513:1: ( '@' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:514:1: '@'
                    {
                     before(grammarAccess.getListaMetasAccess().getCommercialAtKeyword_0_0()); 
                    match(input,13,FOLLOW_13_in_rule__ListaMetas__Alternatives_01036); 
                     after(grammarAccess.getListaMetasAccess().getCommercialAtKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:521:6: ( '@ ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:521:6: ( '@ ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:522:1: '@ '
                    {
                     before(grammarAccess.getListaMetasAccess().getCommercialAtSpaceKeyword_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__ListaMetas__Alternatives_01056); 
                     after(grammarAccess.getListaMetasAccess().getCommercialAtSpaceKeyword_0_1()); 

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
    // $ANTLR end "rule__ListaMetas__Alternatives_0"


    // $ANTLR start "rule__ExecutarCenario__Alternatives_0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:534:1: rule__ExecutarCenario__Alternatives_0 : ( ( 'Dado ' ) | ( 'Quando ' ) | ( 'Ent\\u00E3o ' ) | ( 'E ' ) | ( 'Mas ' ) );
    public final void rule__ExecutarCenario__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:538:1: ( ( 'Dado ' ) | ( 'Quando ' ) | ( 'Ent\\u00E3o ' ) | ( 'E ' ) | ( 'Mas ' ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 18:
                {
                alt3=4;
                }
                break;
            case 19:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:539:1: ( 'Dado ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:539:1: ( 'Dado ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:540:1: 'Dado '
                    {
                     before(grammarAccess.getExecutarCenarioAccess().getDadoKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__ExecutarCenario__Alternatives_01091); 
                     after(grammarAccess.getExecutarCenarioAccess().getDadoKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:547:6: ( 'Quando ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:547:6: ( 'Quando ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:548:1: 'Quando '
                    {
                     before(grammarAccess.getExecutarCenarioAccess().getQuandoKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__ExecutarCenario__Alternatives_01111); 
                     after(grammarAccess.getExecutarCenarioAccess().getQuandoKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:555:6: ( 'Ent\\u00E3o ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:555:6: ( 'Ent\\u00E3o ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:556:1: 'Ent\\u00E3o '
                    {
                     before(grammarAccess.getExecutarCenarioAccess().getEntOKeyword_0_2()); 
                    match(input,17,FOLLOW_17_in_rule__ExecutarCenario__Alternatives_01131); 
                     after(grammarAccess.getExecutarCenarioAccess().getEntOKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:563:6: ( 'E ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:563:6: ( 'E ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:564:1: 'E '
                    {
                     before(grammarAccess.getExecutarCenarioAccess().getEKeyword_0_3()); 
                    match(input,18,FOLLOW_18_in_rule__ExecutarCenario__Alternatives_01151); 
                     after(grammarAccess.getExecutarCenarioAccess().getEKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:571:6: ( 'Mas ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:571:6: ( 'Mas ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:572:1: 'Mas '
                    {
                     before(grammarAccess.getExecutarCenarioAccess().getMasKeyword_0_4()); 
                    match(input,19,FOLLOW_19_in_rule__ExecutarCenario__Alternatives_01171); 
                     after(grammarAccess.getExecutarCenarioAccess().getMasKeyword_0_4()); 

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
    // $ANTLR end "rule__ExecutarCenario__Alternatives_0"


    // $ANTLR start "rule__ListaItens__Alternatives_0_0_0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:584:1: rule__ListaItens__Alternatives_0_0_0 : ( ( '|' ) | ( '| ' ) );
    public final void rule__ListaItens__Alternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:588:1: ( ( '|' ) | ( '| ' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:589:1: ( '|' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:589:1: ( '|' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:590:1: '|'
                    {
                     before(grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_0_0_0()); 
                    match(input,20,FOLLOW_20_in_rule__ListaItens__Alternatives_0_0_01206); 
                     after(grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:597:6: ( '| ' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:597:6: ( '| ' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:598:1: '| '
                    {
                     before(grammarAccess.getListaItensAccess().getVerticalLineSpaceKeyword_0_0_0_1()); 
                    match(input,21,FOLLOW_21_in_rule__ListaItens__Alternatives_0_0_01226); 
                     after(grammarAccess.getListaItensAccess().getVerticalLineSpaceKeyword_0_0_0_1()); 

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
    // $ANTLR end "rule__ListaItens__Alternatives_0_0_0"


    // $ANTLR start "rule__ListaItens__Alternatives_0_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:610:1: rule__ListaItens__Alternatives_0_1 : ( ( '|' ) | ( ' |' ) );
    public final void rule__ListaItens__Alternatives_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:614:1: ( ( '|' ) | ( ' |' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            else if ( (LA5_0==22) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:615:1: ( '|' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:615:1: ( '|' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:616:1: '|'
                    {
                     before(grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_1_0()); 
                    match(input,20,FOLLOW_20_in_rule__ListaItens__Alternatives_0_11261); 
                     after(grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:623:6: ( ' |' )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:623:6: ( ' |' )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:624:1: ' |'
                    {
                     before(grammarAccess.getListaItensAccess().getSpaceVerticalLineKeyword_0_1_1()); 
                    match(input,22,FOLLOW_22_in_rule__ListaItens__Alternatives_0_11281); 
                     after(grammarAccess.getListaItensAccess().getSpaceVerticalLineKeyword_0_1_1()); 

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
    // $ANTLR end "rule__ListaItens__Alternatives_0_1"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Alternatives_0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:636:1: rule__IDENTIFICADOR_GERAL__Alternatives_0 : ( ( RULE_STRING ) | ( RULE_EXID ) );
    public final void rule__IDENTIFICADOR_GERAL__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:640:1: ( ( RULE_STRING ) | ( RULE_EXID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_EXID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:641:1: ( RULE_STRING )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:641:1: ( RULE_STRING )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:642:1: RULE_STRING
                    {
                     before(grammarAccess.getIDENTIFICADOR_GERALAccess().getSTRINGTerminalRuleCall_0_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IDENTIFICADOR_GERAL__Alternatives_01315); 
                     after(grammarAccess.getIDENTIFICADOR_GERALAccess().getSTRINGTerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:647:6: ( RULE_EXID )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:647:6: ( RULE_EXID )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:648:1: RULE_EXID
                    {
                     before(grammarAccess.getIDENTIFICADOR_GERALAccess().getEXIDTerminalRuleCall_0_1()); 
                    match(input,RULE_EXID,FOLLOW_RULE_EXID_in_rule__IDENTIFICADOR_GERAL__Alternatives_01332); 
                     after(grammarAccess.getIDENTIFICADOR_GERALAccess().getEXIDTerminalRuleCall_0_1()); 

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Alternatives_0"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Alternatives_1_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:658:1: rule__IDENTIFICADOR_GERAL__Alternatives_1_1 : ( ( RULE_STRING ) | ( RULE_EXID ) );
    public final void rule__IDENTIFICADOR_GERAL__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:662:1: ( ( RULE_STRING ) | ( RULE_EXID ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_EXID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:663:1: ( RULE_STRING )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:663:1: ( RULE_STRING )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:664:1: RULE_STRING
                    {
                     before(grammarAccess.getIDENTIFICADOR_GERALAccess().getSTRINGTerminalRuleCall_1_1_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IDENTIFICADOR_GERAL__Alternatives_1_11364); 
                     after(grammarAccess.getIDENTIFICADOR_GERALAccess().getSTRINGTerminalRuleCall_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:669:6: ( RULE_EXID )
                    {
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:669:6: ( RULE_EXID )
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:670:1: RULE_EXID
                    {
                     before(grammarAccess.getIDENTIFICADOR_GERALAccess().getEXIDTerminalRuleCall_1_1_1()); 
                    match(input,RULE_EXID,FOLLOW_RULE_EXID_in_rule__IDENTIFICADOR_GERAL__Alternatives_1_11381); 
                     after(grammarAccess.getIDENTIFICADOR_GERALAccess().getEXIDTerminalRuleCall_1_1_1()); 

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Alternatives_1_1"


    // $ANTLR start "rule__Model__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:682:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:686:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:687:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01411);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01414);
            rule__Model__Group__1();

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
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:694:1: rule__Model__Group__0__Impl : ( ( RULE_NL )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:698:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:699:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:699:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:700:1: ( RULE_NL )*
            {
             before(grammarAccess.getModelAccess().getNLTerminalRuleCall_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:701:1: ( RULE_NL )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_NL) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:701:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__Model__Group__0__Impl1442); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getNLTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:711:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:715:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:716:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11473);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11476);
            rule__Model__Group__2();

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
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:723:1: rule__Model__Group__1__Impl : ( ( rule__Model__FuncionalidadeAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:727:1: ( ( ( rule__Model__FuncionalidadeAssignment_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:728:1: ( ( rule__Model__FuncionalidadeAssignment_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:728:1: ( ( rule__Model__FuncionalidadeAssignment_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:729:1: ( rule__Model__FuncionalidadeAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getFuncionalidadeAssignment_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:730:1: ( rule__Model__FuncionalidadeAssignment_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:730:2: rule__Model__FuncionalidadeAssignment_1
            {
            pushFollow(FOLLOW_rule__Model__FuncionalidadeAssignment_1_in_rule__Model__Group__1__Impl1503);
            rule__Model__FuncionalidadeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getFuncionalidadeAssignment_1()); 

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
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:740:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:744:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:745:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__21533);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__21536);
            rule__Model__Group__3();

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
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:752:1: rule__Model__Group__2__Impl : ( ( RULE_NL )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:756:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:757:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:757:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:758:1: ( RULE_NL )*
            {
             before(grammarAccess.getModelAccess().getNLTerminalRuleCall_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:759:1: ( RULE_NL )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_NL) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:759:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__Model__Group__2__Impl1564); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getNLTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:769:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:773:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:774:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__31595);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__31598);
            rule__Model__Group__4();

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
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:781:1: rule__Model__Group__3__Impl : ( ( rule__Model__UsuarioMetaRazaoAssignment_3 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:785:1: ( ( ( rule__Model__UsuarioMetaRazaoAssignment_3 )? ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:786:1: ( ( rule__Model__UsuarioMetaRazaoAssignment_3 )? )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:786:1: ( ( rule__Model__UsuarioMetaRazaoAssignment_3 )? )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:787:1: ( rule__Model__UsuarioMetaRazaoAssignment_3 )?
            {
             before(grammarAccess.getModelAccess().getUsuarioMetaRazaoAssignment_3()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:788:1: ( rule__Model__UsuarioMetaRazaoAssignment_3 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:788:2: rule__Model__UsuarioMetaRazaoAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Model__UsuarioMetaRazaoAssignment_3_in_rule__Model__Group__3__Impl1625);
                    rule__Model__UsuarioMetaRazaoAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getUsuarioMetaRazaoAssignment_3()); 

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
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:798:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:802:1: ( rule__Model__Group__4__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:803:2: rule__Model__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__41656);
            rule__Model__Group__4__Impl();

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
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:809:1: rule__Model__Group__4__Impl : ( ( ( rule__Model__CenariosAssignment_4 ) ) ( ( rule__Model__CenariosAssignment_4 )* ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:813:1: ( ( ( ( rule__Model__CenariosAssignment_4 ) ) ( ( rule__Model__CenariosAssignment_4 )* ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:814:1: ( ( ( rule__Model__CenariosAssignment_4 ) ) ( ( rule__Model__CenariosAssignment_4 )* ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:814:1: ( ( ( rule__Model__CenariosAssignment_4 ) ) ( ( rule__Model__CenariosAssignment_4 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:815:1: ( ( rule__Model__CenariosAssignment_4 ) ) ( ( rule__Model__CenariosAssignment_4 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:815:1: ( ( rule__Model__CenariosAssignment_4 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:816:1: ( rule__Model__CenariosAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getCenariosAssignment_4()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:817:1: ( rule__Model__CenariosAssignment_4 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:817:2: rule__Model__CenariosAssignment_4
            {
            pushFollow(FOLLOW_rule__Model__CenariosAssignment_4_in_rule__Model__Group__4__Impl1685);
            rule__Model__CenariosAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getCenariosAssignment_4()); 

            }

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:820:1: ( ( rule__Model__CenariosAssignment_4 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:821:1: ( rule__Model__CenariosAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getCenariosAssignment_4()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:822:1: ( rule__Model__CenariosAssignment_4 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:822:2: rule__Model__CenariosAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Model__CenariosAssignment_4_in_rule__Model__Group__4__Impl1697);
            	    rule__Model__CenariosAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getCenariosAssignment_4()); 

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
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:843:1: rule__UsuarioMetaRazao__Group__0 : rule__UsuarioMetaRazao__Group__0__Impl rule__UsuarioMetaRazao__Group__1 ;
    public final void rule__UsuarioMetaRazao__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:847:1: ( rule__UsuarioMetaRazao__Group__0__Impl rule__UsuarioMetaRazao__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:848:2: rule__UsuarioMetaRazao__Group__0__Impl rule__UsuarioMetaRazao__Group__1
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__0__Impl_in_rule__UsuarioMetaRazao__Group__01740);
            rule__UsuarioMetaRazao__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__1_in_rule__UsuarioMetaRazao__Group__01743);
            rule__UsuarioMetaRazao__Group__1();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__0"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:855:1: rule__UsuarioMetaRazao__Group__0__Impl : ( 'Como um: ' ) ;
    public final void rule__UsuarioMetaRazao__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:859:1: ( ( 'Como um: ' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:860:1: ( 'Como um: ' )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:860:1: ( 'Como um: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:861:1: 'Como um: '
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getComoUmKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__UsuarioMetaRazao__Group__0__Impl1771); 
             after(grammarAccess.getUsuarioMetaRazaoAccess().getComoUmKeyword_0()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__0__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:874:1: rule__UsuarioMetaRazao__Group__1 : rule__UsuarioMetaRazao__Group__1__Impl rule__UsuarioMetaRazao__Group__2 ;
    public final void rule__UsuarioMetaRazao__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:878:1: ( rule__UsuarioMetaRazao__Group__1__Impl rule__UsuarioMetaRazao__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:879:2: rule__UsuarioMetaRazao__Group__1__Impl rule__UsuarioMetaRazao__Group__2
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__1__Impl_in_rule__UsuarioMetaRazao__Group__11802);
            rule__UsuarioMetaRazao__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__2_in_rule__UsuarioMetaRazao__Group__11805);
            rule__UsuarioMetaRazao__Group__2();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__1"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:886:1: rule__UsuarioMetaRazao__Group__1__Impl : ( ( rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 ) ) ;
    public final void rule__UsuarioMetaRazao__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:890:1: ( ( ( rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:891:1: ( ( rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:891:1: ( ( rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:892:1: ( rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 )
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getNome_do_atorAssignment_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:893:1: ( rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:893:2: rule__UsuarioMetaRazao__Nome_do_atorAssignment_1
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Nome_do_atorAssignment_1_in_rule__UsuarioMetaRazao__Group__1__Impl1832);
            rule__UsuarioMetaRazao__Nome_do_atorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUsuarioMetaRazaoAccess().getNome_do_atorAssignment_1()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__1__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:903:1: rule__UsuarioMetaRazao__Group__2 : rule__UsuarioMetaRazao__Group__2__Impl rule__UsuarioMetaRazao__Group__3 ;
    public final void rule__UsuarioMetaRazao__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:907:1: ( rule__UsuarioMetaRazao__Group__2__Impl rule__UsuarioMetaRazao__Group__3 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:908:2: rule__UsuarioMetaRazao__Group__2__Impl rule__UsuarioMetaRazao__Group__3
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__2__Impl_in_rule__UsuarioMetaRazao__Group__21862);
            rule__UsuarioMetaRazao__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__3_in_rule__UsuarioMetaRazao__Group__21865);
            rule__UsuarioMetaRazao__Group__3();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__2"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:915:1: rule__UsuarioMetaRazao__Group__2__Impl : ( ( RULE_NL )* ) ;
    public final void rule__UsuarioMetaRazao__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:919:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:920:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:920:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:921:1: ( RULE_NL )*
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:922:1: ( RULE_NL )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:922:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__UsuarioMetaRazao__Group__2__Impl1893); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__2__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__3"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:932:1: rule__UsuarioMetaRazao__Group__3 : rule__UsuarioMetaRazao__Group__3__Impl rule__UsuarioMetaRazao__Group__4 ;
    public final void rule__UsuarioMetaRazao__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:936:1: ( rule__UsuarioMetaRazao__Group__3__Impl rule__UsuarioMetaRazao__Group__4 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:937:2: rule__UsuarioMetaRazao__Group__3__Impl rule__UsuarioMetaRazao__Group__4
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__3__Impl_in_rule__UsuarioMetaRazao__Group__31924);
            rule__UsuarioMetaRazao__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__4_in_rule__UsuarioMetaRazao__Group__31927);
            rule__UsuarioMetaRazao__Group__4();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__3"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__3__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:944:1: rule__UsuarioMetaRazao__Group__3__Impl : ( 'Eu quero: ' ) ;
    public final void rule__UsuarioMetaRazao__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:948:1: ( ( 'Eu quero: ' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:949:1: ( 'Eu quero: ' )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:949:1: ( 'Eu quero: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:950:1: 'Eu quero: '
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getEuQueroKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__UsuarioMetaRazao__Group__3__Impl1955); 
             after(grammarAccess.getUsuarioMetaRazaoAccess().getEuQueroKeyword_3()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__3__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__4"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:963:1: rule__UsuarioMetaRazao__Group__4 : rule__UsuarioMetaRazao__Group__4__Impl rule__UsuarioMetaRazao__Group__5 ;
    public final void rule__UsuarioMetaRazao__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:967:1: ( rule__UsuarioMetaRazao__Group__4__Impl rule__UsuarioMetaRazao__Group__5 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:968:2: rule__UsuarioMetaRazao__Group__4__Impl rule__UsuarioMetaRazao__Group__5
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__4__Impl_in_rule__UsuarioMetaRazao__Group__41986);
            rule__UsuarioMetaRazao__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__5_in_rule__UsuarioMetaRazao__Group__41989);
            rule__UsuarioMetaRazao__Group__5();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__4"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__4__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:975:1: rule__UsuarioMetaRazao__Group__4__Impl : ( ( rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 ) ) ;
    public final void rule__UsuarioMetaRazao__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:979:1: ( ( ( rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:980:1: ( ( rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:980:1: ( ( rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:981:1: ( rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 )
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getMeta_a_ser_alcancadaAssignment_4()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:982:1: ( rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:982:2: rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4_in_rule__UsuarioMetaRazao__Group__4__Impl2016);
            rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getUsuarioMetaRazaoAccess().getMeta_a_ser_alcancadaAssignment_4()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__4__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__5"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:992:1: rule__UsuarioMetaRazao__Group__5 : rule__UsuarioMetaRazao__Group__5__Impl rule__UsuarioMetaRazao__Group__6 ;
    public final void rule__UsuarioMetaRazao__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:996:1: ( rule__UsuarioMetaRazao__Group__5__Impl rule__UsuarioMetaRazao__Group__6 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:997:2: rule__UsuarioMetaRazao__Group__5__Impl rule__UsuarioMetaRazao__Group__6
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__5__Impl_in_rule__UsuarioMetaRazao__Group__52046);
            rule__UsuarioMetaRazao__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__6_in_rule__UsuarioMetaRazao__Group__52049);
            rule__UsuarioMetaRazao__Group__6();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__5"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__5__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1004:1: rule__UsuarioMetaRazao__Group__5__Impl : ( ( RULE_NL )* ) ;
    public final void rule__UsuarioMetaRazao__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1008:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1009:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1009:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1010:1: ( RULE_NL )*
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_5()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1011:1: ( RULE_NL )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NL) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1011:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__UsuarioMetaRazao__Group__5__Impl2077); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_5()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__5__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__6"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1021:1: rule__UsuarioMetaRazao__Group__6 : rule__UsuarioMetaRazao__Group__6__Impl rule__UsuarioMetaRazao__Group__7 ;
    public final void rule__UsuarioMetaRazao__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1025:1: ( rule__UsuarioMetaRazao__Group__6__Impl rule__UsuarioMetaRazao__Group__7 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1026:2: rule__UsuarioMetaRazao__Group__6__Impl rule__UsuarioMetaRazao__Group__7
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__6__Impl_in_rule__UsuarioMetaRazao__Group__62108);
            rule__UsuarioMetaRazao__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__7_in_rule__UsuarioMetaRazao__Group__62111);
            rule__UsuarioMetaRazao__Group__7();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__6"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__6__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1033:1: rule__UsuarioMetaRazao__Group__6__Impl : ( 'De modo que: ' ) ;
    public final void rule__UsuarioMetaRazao__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1037:1: ( ( 'De modo que: ' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1038:1: ( 'De modo que: ' )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1038:1: ( 'De modo que: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1039:1: 'De modo que: '
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getDeModoQueKeyword_6()); 
            match(input,25,FOLLOW_25_in_rule__UsuarioMetaRazao__Group__6__Impl2139); 
             after(grammarAccess.getUsuarioMetaRazaoAccess().getDeModoQueKeyword_6()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__6__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__7"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1052:1: rule__UsuarioMetaRazao__Group__7 : rule__UsuarioMetaRazao__Group__7__Impl rule__UsuarioMetaRazao__Group__8 ;
    public final void rule__UsuarioMetaRazao__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1056:1: ( rule__UsuarioMetaRazao__Group__7__Impl rule__UsuarioMetaRazao__Group__8 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1057:2: rule__UsuarioMetaRazao__Group__7__Impl rule__UsuarioMetaRazao__Group__8
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__7__Impl_in_rule__UsuarioMetaRazao__Group__72170);
            rule__UsuarioMetaRazao__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__8_in_rule__UsuarioMetaRazao__Group__72173);
            rule__UsuarioMetaRazao__Group__8();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__7"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__7__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1064:1: rule__UsuarioMetaRazao__Group__7__Impl : ( ( rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 ) ) ;
    public final void rule__UsuarioMetaRazao__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1068:1: ( ( ( rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1069:1: ( ( rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1069:1: ( ( rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1070:1: ( rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 )
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getRazao_para_alcancar_metaAssignment_7()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1071:1: ( rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1071:2: rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7_in_rule__UsuarioMetaRazao__Group__7__Impl2200);
            rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getUsuarioMetaRazaoAccess().getRazao_para_alcancar_metaAssignment_7()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__7__Impl"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__8"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1081:1: rule__UsuarioMetaRazao__Group__8 : rule__UsuarioMetaRazao__Group__8__Impl ;
    public final void rule__UsuarioMetaRazao__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1085:1: ( rule__UsuarioMetaRazao__Group__8__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1086:2: rule__UsuarioMetaRazao__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__UsuarioMetaRazao__Group__8__Impl_in_rule__UsuarioMetaRazao__Group__82230);
            rule__UsuarioMetaRazao__Group__8__Impl();

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__8"


    // $ANTLR start "rule__UsuarioMetaRazao__Group__8__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1092:1: rule__UsuarioMetaRazao__Group__8__Impl : ( ( RULE_NL )* ) ;
    public final void rule__UsuarioMetaRazao__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1096:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1097:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1097:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1098:1: ( RULE_NL )*
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_8()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1099:1: ( RULE_NL )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_NL) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1099:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__UsuarioMetaRazao__Group__8__Impl2258); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_8()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Group__8__Impl"


    // $ANTLR start "rule__Funcionalidade__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1127:1: rule__Funcionalidade__Group__0 : rule__Funcionalidade__Group__0__Impl rule__Funcionalidade__Group__1 ;
    public final void rule__Funcionalidade__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1131:1: ( rule__Funcionalidade__Group__0__Impl rule__Funcionalidade__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1132:2: rule__Funcionalidade__Group__0__Impl rule__Funcionalidade__Group__1
            {
            pushFollow(FOLLOW_rule__Funcionalidade__Group__0__Impl_in_rule__Funcionalidade__Group__02307);
            rule__Funcionalidade__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Funcionalidade__Group__1_in_rule__Funcionalidade__Group__02310);
            rule__Funcionalidade__Group__1();

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
    // $ANTLR end "rule__Funcionalidade__Group__0"


    // $ANTLR start "rule__Funcionalidade__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1139:1: rule__Funcionalidade__Group__0__Impl : ( 'Funcionalidade: ' ) ;
    public final void rule__Funcionalidade__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1143:1: ( ( 'Funcionalidade: ' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1144:1: ( 'Funcionalidade: ' )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1144:1: ( 'Funcionalidade: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1145:1: 'Funcionalidade: '
            {
             before(grammarAccess.getFuncionalidadeAccess().getFuncionalidadeKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__Funcionalidade__Group__0__Impl2338); 
             after(grammarAccess.getFuncionalidadeAccess().getFuncionalidadeKeyword_0()); 

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
    // $ANTLR end "rule__Funcionalidade__Group__0__Impl"


    // $ANTLR start "rule__Funcionalidade__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1158:1: rule__Funcionalidade__Group__1 : rule__Funcionalidade__Group__1__Impl rule__Funcionalidade__Group__2 ;
    public final void rule__Funcionalidade__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1162:1: ( rule__Funcionalidade__Group__1__Impl rule__Funcionalidade__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1163:2: rule__Funcionalidade__Group__1__Impl rule__Funcionalidade__Group__2
            {
            pushFollow(FOLLOW_rule__Funcionalidade__Group__1__Impl_in_rule__Funcionalidade__Group__12369);
            rule__Funcionalidade__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Funcionalidade__Group__2_in_rule__Funcionalidade__Group__12372);
            rule__Funcionalidade__Group__2();

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
    // $ANTLR end "rule__Funcionalidade__Group__1"


    // $ANTLR start "rule__Funcionalidade__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1170:1: rule__Funcionalidade__Group__1__Impl : ( ( rule__Funcionalidade__Nome_funcionadadeAssignment_1 ) ) ;
    public final void rule__Funcionalidade__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1174:1: ( ( ( rule__Funcionalidade__Nome_funcionadadeAssignment_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1175:1: ( ( rule__Funcionalidade__Nome_funcionadadeAssignment_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1175:1: ( ( rule__Funcionalidade__Nome_funcionadadeAssignment_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1176:1: ( rule__Funcionalidade__Nome_funcionadadeAssignment_1 )
            {
             before(grammarAccess.getFuncionalidadeAccess().getNome_funcionadadeAssignment_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1177:1: ( rule__Funcionalidade__Nome_funcionadadeAssignment_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1177:2: rule__Funcionalidade__Nome_funcionadadeAssignment_1
            {
            pushFollow(FOLLOW_rule__Funcionalidade__Nome_funcionadadeAssignment_1_in_rule__Funcionalidade__Group__1__Impl2399);
            rule__Funcionalidade__Nome_funcionadadeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFuncionalidadeAccess().getNome_funcionadadeAssignment_1()); 

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
    // $ANTLR end "rule__Funcionalidade__Group__1__Impl"


    // $ANTLR start "rule__Funcionalidade__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1187:1: rule__Funcionalidade__Group__2 : rule__Funcionalidade__Group__2__Impl ;
    public final void rule__Funcionalidade__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1191:1: ( rule__Funcionalidade__Group__2__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1192:2: rule__Funcionalidade__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Funcionalidade__Group__2__Impl_in_rule__Funcionalidade__Group__22429);
            rule__Funcionalidade__Group__2__Impl();

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
    // $ANTLR end "rule__Funcionalidade__Group__2"


    // $ANTLR start "rule__Funcionalidade__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1198:1: rule__Funcionalidade__Group__2__Impl : ( ( RULE_NL )* ) ;
    public final void rule__Funcionalidade__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1202:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1203:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1203:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1204:1: ( RULE_NL )*
            {
             before(grammarAccess.getFuncionalidadeAccess().getNLTerminalRuleCall_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1205:1: ( RULE_NL )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1205:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__Funcionalidade__Group__2__Impl2457); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getFuncionalidadeAccess().getNLTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__Funcionalidade__Group__2__Impl"


    // $ANTLR start "rule__Cenario__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1221:1: rule__Cenario__Group__0 : rule__Cenario__Group__0__Impl rule__Cenario__Group__1 ;
    public final void rule__Cenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1225:1: ( rule__Cenario__Group__0__Impl rule__Cenario__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1226:2: rule__Cenario__Group__0__Impl rule__Cenario__Group__1
            {
            pushFollow(FOLLOW_rule__Cenario__Group__0__Impl_in_rule__Cenario__Group__02494);
            rule__Cenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Cenario__Group__1_in_rule__Cenario__Group__02497);
            rule__Cenario__Group__1();

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
    // $ANTLR end "rule__Cenario__Group__0"


    // $ANTLR start "rule__Cenario__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1233:1: rule__Cenario__Group__0__Impl : ( 'Cen\\u00E1rio: ' ) ;
    public final void rule__Cenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1237:1: ( ( 'Cen\\u00E1rio: ' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1238:1: ( 'Cen\\u00E1rio: ' )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1238:1: ( 'Cen\\u00E1rio: ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1239:1: 'Cen\\u00E1rio: '
            {
             before(grammarAccess.getCenarioAccess().getCenRioKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__Cenario__Group__0__Impl2525); 
             after(grammarAccess.getCenarioAccess().getCenRioKeyword_0()); 

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
    // $ANTLR end "rule__Cenario__Group__0__Impl"


    // $ANTLR start "rule__Cenario__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1252:1: rule__Cenario__Group__1 : rule__Cenario__Group__1__Impl rule__Cenario__Group__2 ;
    public final void rule__Cenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1256:1: ( rule__Cenario__Group__1__Impl rule__Cenario__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1257:2: rule__Cenario__Group__1__Impl rule__Cenario__Group__2
            {
            pushFollow(FOLLOW_rule__Cenario__Group__1__Impl_in_rule__Cenario__Group__12556);
            rule__Cenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Cenario__Group__2_in_rule__Cenario__Group__12559);
            rule__Cenario__Group__2();

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
    // $ANTLR end "rule__Cenario__Group__1"


    // $ANTLR start "rule__Cenario__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1264:1: rule__Cenario__Group__1__Impl : ( ruleIdentificadorCenario ) ;
    public final void rule__Cenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1268:1: ( ( ruleIdentificadorCenario ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1269:1: ( ruleIdentificadorCenario )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1269:1: ( ruleIdentificadorCenario )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1270:1: ruleIdentificadorCenario
            {
             before(grammarAccess.getCenarioAccess().getIdentificadorCenarioParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleIdentificadorCenario_in_rule__Cenario__Group__1__Impl2586);
            ruleIdentificadorCenario();

            state._fsp--;

             after(grammarAccess.getCenarioAccess().getIdentificadorCenarioParserRuleCall_1()); 

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
    // $ANTLR end "rule__Cenario__Group__1__Impl"


    // $ANTLR start "rule__Cenario__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1281:1: rule__Cenario__Group__2 : rule__Cenario__Group__2__Impl rule__Cenario__Group__3 ;
    public final void rule__Cenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1285:1: ( rule__Cenario__Group__2__Impl rule__Cenario__Group__3 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1286:2: rule__Cenario__Group__2__Impl rule__Cenario__Group__3
            {
            pushFollow(FOLLOW_rule__Cenario__Group__2__Impl_in_rule__Cenario__Group__22615);
            rule__Cenario__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Cenario__Group__3_in_rule__Cenario__Group__22618);
            rule__Cenario__Group__3();

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
    // $ANTLR end "rule__Cenario__Group__2"


    // $ANTLR start "rule__Cenario__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1293:1: rule__Cenario__Group__2__Impl : ( ( rule__Cenario__XerAssignment_2 )* ) ;
    public final void rule__Cenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1297:1: ( ( ( rule__Cenario__XerAssignment_2 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1298:1: ( ( rule__Cenario__XerAssignment_2 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1298:1: ( ( rule__Cenario__XerAssignment_2 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1299:1: ( rule__Cenario__XerAssignment_2 )*
            {
             before(grammarAccess.getCenarioAccess().getXerAssignment_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1300:1: ( rule__Cenario__XerAssignment_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1300:2: rule__Cenario__XerAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Cenario__XerAssignment_2_in_rule__Cenario__Group__2__Impl2645);
            	    rule__Cenario__XerAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getCenarioAccess().getXerAssignment_2()); 

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
    // $ANTLR end "rule__Cenario__Group__2__Impl"


    // $ANTLR start "rule__Cenario__Group__3"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1310:1: rule__Cenario__Group__3 : rule__Cenario__Group__3__Impl ;
    public final void rule__Cenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1314:1: ( rule__Cenario__Group__3__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1315:2: rule__Cenario__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Cenario__Group__3__Impl_in_rule__Cenario__Group__32676);
            rule__Cenario__Group__3__Impl();

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
    // $ANTLR end "rule__Cenario__Group__3"


    // $ANTLR start "rule__Cenario__Group__3__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1321:1: rule__Cenario__Group__3__Impl : ( ( rule__Cenario__Sentencas_qualiteAssignment_3 )* ) ;
    public final void rule__Cenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1325:1: ( ( ( rule__Cenario__Sentencas_qualiteAssignment_3 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1326:1: ( ( rule__Cenario__Sentencas_qualiteAssignment_3 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1326:1: ( ( rule__Cenario__Sentencas_qualiteAssignment_3 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1327:1: ( rule__Cenario__Sentencas_qualiteAssignment_3 )*
            {
             before(grammarAccess.getCenarioAccess().getSentencas_qualiteAssignment_3()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1328:1: ( rule__Cenario__Sentencas_qualiteAssignment_3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=15 && LA17_0<=21)||LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1328:2: rule__Cenario__Sentencas_qualiteAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Cenario__Sentencas_qualiteAssignment_3_in_rule__Cenario__Group__3__Impl2703);
            	    rule__Cenario__Sentencas_qualiteAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getCenarioAccess().getSentencas_qualiteAssignment_3()); 

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
    // $ANTLR end "rule__Cenario__Group__3__Impl"


    // $ANTLR start "rule__Meta__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1346:1: rule__Meta__Group__0 : rule__Meta__Group__0__Impl rule__Meta__Group__1 ;
    public final void rule__Meta__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1350:1: ( rule__Meta__Group__0__Impl rule__Meta__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1351:2: rule__Meta__Group__0__Impl rule__Meta__Group__1
            {
            pushFollow(FOLLOW_rule__Meta__Group__0__Impl_in_rule__Meta__Group__02742);
            rule__Meta__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Meta__Group__1_in_rule__Meta__Group__02745);
            rule__Meta__Group__1();

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
    // $ANTLR end "rule__Meta__Group__0"


    // $ANTLR start "rule__Meta__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1358:1: rule__Meta__Group__0__Impl : ( ( rule__Meta__XAssignment_0 ) ) ;
    public final void rule__Meta__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1362:1: ( ( ( rule__Meta__XAssignment_0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1363:1: ( ( rule__Meta__XAssignment_0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1363:1: ( ( rule__Meta__XAssignment_0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1364:1: ( rule__Meta__XAssignment_0 )
            {
             before(grammarAccess.getMetaAccess().getXAssignment_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1365:1: ( rule__Meta__XAssignment_0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1365:2: rule__Meta__XAssignment_0
            {
            pushFollow(FOLLOW_rule__Meta__XAssignment_0_in_rule__Meta__Group__0__Impl2772);
            rule__Meta__XAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMetaAccess().getXAssignment_0()); 

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
    // $ANTLR end "rule__Meta__Group__0__Impl"


    // $ANTLR start "rule__Meta__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1375:1: rule__Meta__Group__1 : rule__Meta__Group__1__Impl rule__Meta__Group__2 ;
    public final void rule__Meta__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1379:1: ( rule__Meta__Group__1__Impl rule__Meta__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1380:2: rule__Meta__Group__1__Impl rule__Meta__Group__2
            {
            pushFollow(FOLLOW_rule__Meta__Group__1__Impl_in_rule__Meta__Group__12802);
            rule__Meta__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Meta__Group__2_in_rule__Meta__Group__12805);
            rule__Meta__Group__2();

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
    // $ANTLR end "rule__Meta__Group__1"


    // $ANTLR start "rule__Meta__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1387:1: rule__Meta__Group__1__Impl : ( ( RULE_NL )* ) ;
    public final void rule__Meta__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1391:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1392:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1392:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1393:1: ( RULE_NL )*
            {
             before(grammarAccess.getMetaAccess().getNLTerminalRuleCall_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1394:1: ( RULE_NL )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1394:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__Meta__Group__1__Impl2833); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getMetaAccess().getNLTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__Meta__Group__1__Impl"


    // $ANTLR start "rule__Meta__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1404:1: rule__Meta__Group__2 : rule__Meta__Group__2__Impl ;
    public final void rule__Meta__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1408:1: ( rule__Meta__Group__2__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1409:2: rule__Meta__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Meta__Group__2__Impl_in_rule__Meta__Group__22864);
            rule__Meta__Group__2__Impl();

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
    // $ANTLR end "rule__Meta__Group__2"


    // $ANTLR start "rule__Meta__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1415:1: rule__Meta__Group__2__Impl : ( ( ( rule__Meta__Lista_metasAssignment_2 ) ) ( ( rule__Meta__Lista_metasAssignment_2 )* ) ) ;
    public final void rule__Meta__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1419:1: ( ( ( ( rule__Meta__Lista_metasAssignment_2 ) ) ( ( rule__Meta__Lista_metasAssignment_2 )* ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1420:1: ( ( ( rule__Meta__Lista_metasAssignment_2 ) ) ( ( rule__Meta__Lista_metasAssignment_2 )* ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1420:1: ( ( ( rule__Meta__Lista_metasAssignment_2 ) ) ( ( rule__Meta__Lista_metasAssignment_2 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1421:1: ( ( rule__Meta__Lista_metasAssignment_2 ) ) ( ( rule__Meta__Lista_metasAssignment_2 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1421:1: ( ( rule__Meta__Lista_metasAssignment_2 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1422:1: ( rule__Meta__Lista_metasAssignment_2 )
            {
             before(grammarAccess.getMetaAccess().getLista_metasAssignment_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1423:1: ( rule__Meta__Lista_metasAssignment_2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1423:2: rule__Meta__Lista_metasAssignment_2
            {
            pushFollow(FOLLOW_rule__Meta__Lista_metasAssignment_2_in_rule__Meta__Group__2__Impl2893);
            rule__Meta__Lista_metasAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMetaAccess().getLista_metasAssignment_2()); 

            }

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1426:1: ( ( rule__Meta__Lista_metasAssignment_2 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1427:1: ( rule__Meta__Lista_metasAssignment_2 )*
            {
             before(grammarAccess.getMetaAccess().getLista_metasAssignment_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1428:1: ( rule__Meta__Lista_metasAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=13 && LA19_0<=14)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1428:2: rule__Meta__Lista_metasAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Meta__Lista_metasAssignment_2_in_rule__Meta__Group__2__Impl2905);
            	    rule__Meta__Lista_metasAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getMetaAccess().getLista_metasAssignment_2()); 

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
    // $ANTLR end "rule__Meta__Group__2__Impl"


    // $ANTLR start "rule__ListaMetas__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1445:1: rule__ListaMetas__Group__0 : rule__ListaMetas__Group__0__Impl rule__ListaMetas__Group__1 ;
    public final void rule__ListaMetas__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1449:1: ( rule__ListaMetas__Group__0__Impl rule__ListaMetas__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1450:2: rule__ListaMetas__Group__0__Impl rule__ListaMetas__Group__1
            {
            pushFollow(FOLLOW_rule__ListaMetas__Group__0__Impl_in_rule__ListaMetas__Group__02944);
            rule__ListaMetas__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListaMetas__Group__1_in_rule__ListaMetas__Group__02947);
            rule__ListaMetas__Group__1();

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
    // $ANTLR end "rule__ListaMetas__Group__0"


    // $ANTLR start "rule__ListaMetas__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1457:1: rule__ListaMetas__Group__0__Impl : ( ( rule__ListaMetas__Alternatives_0 ) ) ;
    public final void rule__ListaMetas__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1461:1: ( ( ( rule__ListaMetas__Alternatives_0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1462:1: ( ( rule__ListaMetas__Alternatives_0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1462:1: ( ( rule__ListaMetas__Alternatives_0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1463:1: ( rule__ListaMetas__Alternatives_0 )
            {
             before(grammarAccess.getListaMetasAccess().getAlternatives_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1464:1: ( rule__ListaMetas__Alternatives_0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1464:2: rule__ListaMetas__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ListaMetas__Alternatives_0_in_rule__ListaMetas__Group__0__Impl2974);
            rule__ListaMetas__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getListaMetasAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__ListaMetas__Group__0__Impl"


    // $ANTLR start "rule__ListaMetas__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1474:1: rule__ListaMetas__Group__1 : rule__ListaMetas__Group__1__Impl rule__ListaMetas__Group__2 ;
    public final void rule__ListaMetas__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1478:1: ( rule__ListaMetas__Group__1__Impl rule__ListaMetas__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1479:2: rule__ListaMetas__Group__1__Impl rule__ListaMetas__Group__2
            {
            pushFollow(FOLLOW_rule__ListaMetas__Group__1__Impl_in_rule__ListaMetas__Group__13004);
            rule__ListaMetas__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListaMetas__Group__2_in_rule__ListaMetas__Group__13007);
            rule__ListaMetas__Group__2();

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
    // $ANTLR end "rule__ListaMetas__Group__1"


    // $ANTLR start "rule__ListaMetas__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1486:1: rule__ListaMetas__Group__1__Impl : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void rule__ListaMetas__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1490:1: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1491:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1491:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1492:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getListaMetasAccess().getIDENTIFICADOR_GERALParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__ListaMetas__Group__1__Impl3034);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getListaMetasAccess().getIDENTIFICADOR_GERALParserRuleCall_1()); 

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
    // $ANTLR end "rule__ListaMetas__Group__1__Impl"


    // $ANTLR start "rule__ListaMetas__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1503:1: rule__ListaMetas__Group__2 : rule__ListaMetas__Group__2__Impl ;
    public final void rule__ListaMetas__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1507:1: ( rule__ListaMetas__Group__2__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1508:2: rule__ListaMetas__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ListaMetas__Group__2__Impl_in_rule__ListaMetas__Group__23063);
            rule__ListaMetas__Group__2__Impl();

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
    // $ANTLR end "rule__ListaMetas__Group__2"


    // $ANTLR start "rule__ListaMetas__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1514:1: rule__ListaMetas__Group__2__Impl : ( ( RULE_NL )* ) ;
    public final void rule__ListaMetas__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1518:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1519:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1519:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1520:1: ( RULE_NL )*
            {
             before(grammarAccess.getListaMetasAccess().getNLTerminalRuleCall_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1521:1: ( RULE_NL )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NL) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1521:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__ListaMetas__Group__2__Impl3091); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getListaMetasAccess().getNLTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__ListaMetas__Group__2__Impl"


    // $ANTLR start "rule__ExecutarCenario__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1537:1: rule__ExecutarCenario__Group__0 : rule__ExecutarCenario__Group__0__Impl rule__ExecutarCenario__Group__1 ;
    public final void rule__ExecutarCenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1541:1: ( rule__ExecutarCenario__Group__0__Impl rule__ExecutarCenario__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1542:2: rule__ExecutarCenario__Group__0__Impl rule__ExecutarCenario__Group__1
            {
            pushFollow(FOLLOW_rule__ExecutarCenario__Group__0__Impl_in_rule__ExecutarCenario__Group__03128);
            rule__ExecutarCenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutarCenario__Group__1_in_rule__ExecutarCenario__Group__03131);
            rule__ExecutarCenario__Group__1();

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
    // $ANTLR end "rule__ExecutarCenario__Group__0"


    // $ANTLR start "rule__ExecutarCenario__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1549:1: rule__ExecutarCenario__Group__0__Impl : ( ( rule__ExecutarCenario__Alternatives_0 ) ) ;
    public final void rule__ExecutarCenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1553:1: ( ( ( rule__ExecutarCenario__Alternatives_0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1554:1: ( ( rule__ExecutarCenario__Alternatives_0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1554:1: ( ( rule__ExecutarCenario__Alternatives_0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1555:1: ( rule__ExecutarCenario__Alternatives_0 )
            {
             before(grammarAccess.getExecutarCenarioAccess().getAlternatives_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1556:1: ( rule__ExecutarCenario__Alternatives_0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1556:2: rule__ExecutarCenario__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ExecutarCenario__Alternatives_0_in_rule__ExecutarCenario__Group__0__Impl3158);
            rule__ExecutarCenario__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getExecutarCenarioAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__ExecutarCenario__Group__0__Impl"


    // $ANTLR start "rule__ExecutarCenario__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1566:1: rule__ExecutarCenario__Group__1 : rule__ExecutarCenario__Group__1__Impl rule__ExecutarCenario__Group__2 ;
    public final void rule__ExecutarCenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1570:1: ( rule__ExecutarCenario__Group__1__Impl rule__ExecutarCenario__Group__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1571:2: rule__ExecutarCenario__Group__1__Impl rule__ExecutarCenario__Group__2
            {
            pushFollow(FOLLOW_rule__ExecutarCenario__Group__1__Impl_in_rule__ExecutarCenario__Group__13188);
            rule__ExecutarCenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutarCenario__Group__2_in_rule__ExecutarCenario__Group__13191);
            rule__ExecutarCenario__Group__2();

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
    // $ANTLR end "rule__ExecutarCenario__Group__1"


    // $ANTLR start "rule__ExecutarCenario__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1578:1: rule__ExecutarCenario__Group__1__Impl : ( ( rule__ExecutarCenario__Cenario_executar_refAssignment_1 ) ) ;
    public final void rule__ExecutarCenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1582:1: ( ( ( rule__ExecutarCenario__Cenario_executar_refAssignment_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1583:1: ( ( rule__ExecutarCenario__Cenario_executar_refAssignment_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1583:1: ( ( rule__ExecutarCenario__Cenario_executar_refAssignment_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1584:1: ( rule__ExecutarCenario__Cenario_executar_refAssignment_1 )
            {
             before(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refAssignment_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1585:1: ( rule__ExecutarCenario__Cenario_executar_refAssignment_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1585:2: rule__ExecutarCenario__Cenario_executar_refAssignment_1
            {
            pushFollow(FOLLOW_rule__ExecutarCenario__Cenario_executar_refAssignment_1_in_rule__ExecutarCenario__Group__1__Impl3218);
            rule__ExecutarCenario__Cenario_executar_refAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refAssignment_1()); 

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
    // $ANTLR end "rule__ExecutarCenario__Group__1__Impl"


    // $ANTLR start "rule__ExecutarCenario__Group__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1595:1: rule__ExecutarCenario__Group__2 : rule__ExecutarCenario__Group__2__Impl ;
    public final void rule__ExecutarCenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1599:1: ( rule__ExecutarCenario__Group__2__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1600:2: rule__ExecutarCenario__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ExecutarCenario__Group__2__Impl_in_rule__ExecutarCenario__Group__23248);
            rule__ExecutarCenario__Group__2__Impl();

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
    // $ANTLR end "rule__ExecutarCenario__Group__2"


    // $ANTLR start "rule__ExecutarCenario__Group__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1606:1: rule__ExecutarCenario__Group__2__Impl : ( ( RULE_NL )* ) ;
    public final void rule__ExecutarCenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1610:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1611:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1611:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1612:1: ( RULE_NL )*
            {
             before(grammarAccess.getExecutarCenarioAccess().getNLTerminalRuleCall_2()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1613:1: ( RULE_NL )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NL) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1613:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__ExecutarCenario__Group__2__Impl3276); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getExecutarCenarioAccess().getNLTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__ExecutarCenario__Group__2__Impl"


    // $ANTLR start "rule__ListaItens__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1629:1: rule__ListaItens__Group__0 : rule__ListaItens__Group__0__Impl rule__ListaItens__Group__1 ;
    public final void rule__ListaItens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1633:1: ( rule__ListaItens__Group__0__Impl rule__ListaItens__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1634:2: rule__ListaItens__Group__0__Impl rule__ListaItens__Group__1
            {
            pushFollow(FOLLOW_rule__ListaItens__Group__0__Impl_in_rule__ListaItens__Group__03313);
            rule__ListaItens__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListaItens__Group__1_in_rule__ListaItens__Group__03316);
            rule__ListaItens__Group__1();

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
    // $ANTLR end "rule__ListaItens__Group__0"


    // $ANTLR start "rule__ListaItens__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1641:1: rule__ListaItens__Group__0__Impl : ( ( ( rule__ListaItens__Group_0__0 ) ) ( ( rule__ListaItens__Group_0__0 )* ) ) ;
    public final void rule__ListaItens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1645:1: ( ( ( ( rule__ListaItens__Group_0__0 ) ) ( ( rule__ListaItens__Group_0__0 )* ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1646:1: ( ( ( rule__ListaItens__Group_0__0 ) ) ( ( rule__ListaItens__Group_0__0 )* ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1646:1: ( ( ( rule__ListaItens__Group_0__0 ) ) ( ( rule__ListaItens__Group_0__0 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1647:1: ( ( rule__ListaItens__Group_0__0 ) ) ( ( rule__ListaItens__Group_0__0 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1647:1: ( ( rule__ListaItens__Group_0__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1648:1: ( rule__ListaItens__Group_0__0 )
            {
             before(grammarAccess.getListaItensAccess().getGroup_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1649:1: ( rule__ListaItens__Group_0__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1649:2: rule__ListaItens__Group_0__0
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0__0_in_rule__ListaItens__Group__0__Impl3345);
            rule__ListaItens__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getListaItensAccess().getGroup_0()); 

            }

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1652:1: ( ( rule__ListaItens__Group_0__0 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1653:1: ( rule__ListaItens__Group_0__0 )*
            {
             before(grammarAccess.getListaItensAccess().getGroup_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1654:1: ( rule__ListaItens__Group_0__0 )*
            loop22:
            do {
                int alt22=2;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1654:2: rule__ListaItens__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__ListaItens__Group_0__0_in_rule__ListaItens__Group__0__Impl3357);
            	    rule__ListaItens__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getListaItensAccess().getGroup_0()); 

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
    // $ANTLR end "rule__ListaItens__Group__0__Impl"


    // $ANTLR start "rule__ListaItens__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1665:1: rule__ListaItens__Group__1 : rule__ListaItens__Group__1__Impl ;
    public final void rule__ListaItens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1669:1: ( rule__ListaItens__Group__1__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1670:2: rule__ListaItens__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListaItens__Group__1__Impl_in_rule__ListaItens__Group__13390);
            rule__ListaItens__Group__1__Impl();

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
    // $ANTLR end "rule__ListaItens__Group__1"


    // $ANTLR start "rule__ListaItens__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1676:1: rule__ListaItens__Group__1__Impl : ( ( RULE_NL )* ) ;
    public final void rule__ListaItens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1680:1: ( ( ( RULE_NL )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1681:1: ( ( RULE_NL )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1681:1: ( ( RULE_NL )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1682:1: ( RULE_NL )*
            {
             before(grammarAccess.getListaItensAccess().getNLTerminalRuleCall_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1683:1: ( RULE_NL )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_NL) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1683:3: RULE_NL
            	    {
            	    match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__ListaItens__Group__1__Impl3418); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getListaItensAccess().getNLTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__ListaItens__Group__1__Impl"


    // $ANTLR start "rule__ListaItens__Group_0__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1697:1: rule__ListaItens__Group_0__0 : rule__ListaItens__Group_0__0__Impl rule__ListaItens__Group_0__1 ;
    public final void rule__ListaItens__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1701:1: ( rule__ListaItens__Group_0__0__Impl rule__ListaItens__Group_0__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1702:2: rule__ListaItens__Group_0__0__Impl rule__ListaItens__Group_0__1
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0__0__Impl_in_rule__ListaItens__Group_0__03453);
            rule__ListaItens__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListaItens__Group_0__1_in_rule__ListaItens__Group_0__03456);
            rule__ListaItens__Group_0__1();

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
    // $ANTLR end "rule__ListaItens__Group_0__0"


    // $ANTLR start "rule__ListaItens__Group_0__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1709:1: rule__ListaItens__Group_0__0__Impl : ( ( ( rule__ListaItens__Group_0_0__0 ) ) ( ( rule__ListaItens__Group_0_0__0 )* ) ) ;
    public final void rule__ListaItens__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1713:1: ( ( ( ( rule__ListaItens__Group_0_0__0 ) ) ( ( rule__ListaItens__Group_0_0__0 )* ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1714:1: ( ( ( rule__ListaItens__Group_0_0__0 ) ) ( ( rule__ListaItens__Group_0_0__0 )* ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1714:1: ( ( ( rule__ListaItens__Group_0_0__0 ) ) ( ( rule__ListaItens__Group_0_0__0 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1715:1: ( ( rule__ListaItens__Group_0_0__0 ) ) ( ( rule__ListaItens__Group_0_0__0 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1715:1: ( ( rule__ListaItens__Group_0_0__0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1716:1: ( rule__ListaItens__Group_0_0__0 )
            {
             before(grammarAccess.getListaItensAccess().getGroup_0_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1717:1: ( rule__ListaItens__Group_0_0__0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1717:2: rule__ListaItens__Group_0_0__0
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0_0__0_in_rule__ListaItens__Group_0__0__Impl3485);
            rule__ListaItens__Group_0_0__0();

            state._fsp--;


            }

             after(grammarAccess.getListaItensAccess().getGroup_0_0()); 

            }

            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1720:1: ( ( rule__ListaItens__Group_0_0__0 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1721:1: ( rule__ListaItens__Group_0_0__0 )*
            {
             before(grammarAccess.getListaItensAccess().getGroup_0_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1722:1: ( rule__ListaItens__Group_0_0__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==20) ) {
                    int LA24_1 = input.LA(2);

                    if ( ((LA24_1>=RULE_STRING && LA24_1<=RULE_EXID)) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==21) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1722:2: rule__ListaItens__Group_0_0__0
            	    {
            	    pushFollow(FOLLOW_rule__ListaItens__Group_0_0__0_in_rule__ListaItens__Group_0__0__Impl3497);
            	    rule__ListaItens__Group_0_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getListaItensAccess().getGroup_0_0()); 

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
    // $ANTLR end "rule__ListaItens__Group_0__0__Impl"


    // $ANTLR start "rule__ListaItens__Group_0__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1733:1: rule__ListaItens__Group_0__1 : rule__ListaItens__Group_0__1__Impl rule__ListaItens__Group_0__2 ;
    public final void rule__ListaItens__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1737:1: ( rule__ListaItens__Group_0__1__Impl rule__ListaItens__Group_0__2 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1738:2: rule__ListaItens__Group_0__1__Impl rule__ListaItens__Group_0__2
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0__1__Impl_in_rule__ListaItens__Group_0__13530);
            rule__ListaItens__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListaItens__Group_0__2_in_rule__ListaItens__Group_0__13533);
            rule__ListaItens__Group_0__2();

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
    // $ANTLR end "rule__ListaItens__Group_0__1"


    // $ANTLR start "rule__ListaItens__Group_0__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1745:1: rule__ListaItens__Group_0__1__Impl : ( ( rule__ListaItens__Alternatives_0_1 ) ) ;
    public final void rule__ListaItens__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1749:1: ( ( ( rule__ListaItens__Alternatives_0_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1750:1: ( ( rule__ListaItens__Alternatives_0_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1750:1: ( ( rule__ListaItens__Alternatives_0_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1751:1: ( rule__ListaItens__Alternatives_0_1 )
            {
             before(grammarAccess.getListaItensAccess().getAlternatives_0_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1752:1: ( rule__ListaItens__Alternatives_0_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1752:2: rule__ListaItens__Alternatives_0_1
            {
            pushFollow(FOLLOW_rule__ListaItens__Alternatives_0_1_in_rule__ListaItens__Group_0__1__Impl3560);
            rule__ListaItens__Alternatives_0_1();

            state._fsp--;


            }

             after(grammarAccess.getListaItensAccess().getAlternatives_0_1()); 

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
    // $ANTLR end "rule__ListaItens__Group_0__1__Impl"


    // $ANTLR start "rule__ListaItens__Group_0__2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1762:1: rule__ListaItens__Group_0__2 : rule__ListaItens__Group_0__2__Impl ;
    public final void rule__ListaItens__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1766:1: ( rule__ListaItens__Group_0__2__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1767:2: rule__ListaItens__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0__2__Impl_in_rule__ListaItens__Group_0__23590);
            rule__ListaItens__Group_0__2__Impl();

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
    // $ANTLR end "rule__ListaItens__Group_0__2"


    // $ANTLR start "rule__ListaItens__Group_0__2__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1773:1: rule__ListaItens__Group_0__2__Impl : ( RULE_NL ) ;
    public final void rule__ListaItens__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1777:1: ( ( RULE_NL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1778:1: ( RULE_NL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1778:1: ( RULE_NL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1779:1: RULE_NL
            {
             before(grammarAccess.getListaItensAccess().getNLTerminalRuleCall_0_2()); 
            match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__ListaItens__Group_0__2__Impl3617); 
             after(grammarAccess.getListaItensAccess().getNLTerminalRuleCall_0_2()); 

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
    // $ANTLR end "rule__ListaItens__Group_0__2__Impl"


    // $ANTLR start "rule__ListaItens__Group_0_0__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1796:1: rule__ListaItens__Group_0_0__0 : rule__ListaItens__Group_0_0__0__Impl rule__ListaItens__Group_0_0__1 ;
    public final void rule__ListaItens__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1800:1: ( rule__ListaItens__Group_0_0__0__Impl rule__ListaItens__Group_0_0__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1801:2: rule__ListaItens__Group_0_0__0__Impl rule__ListaItens__Group_0_0__1
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0_0__0__Impl_in_rule__ListaItens__Group_0_0__03652);
            rule__ListaItens__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListaItens__Group_0_0__1_in_rule__ListaItens__Group_0_0__03655);
            rule__ListaItens__Group_0_0__1();

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
    // $ANTLR end "rule__ListaItens__Group_0_0__0"


    // $ANTLR start "rule__ListaItens__Group_0_0__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1808:1: rule__ListaItens__Group_0_0__0__Impl : ( ( rule__ListaItens__Alternatives_0_0_0 ) ) ;
    public final void rule__ListaItens__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1812:1: ( ( ( rule__ListaItens__Alternatives_0_0_0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1813:1: ( ( rule__ListaItens__Alternatives_0_0_0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1813:1: ( ( rule__ListaItens__Alternatives_0_0_0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1814:1: ( rule__ListaItens__Alternatives_0_0_0 )
            {
             before(grammarAccess.getListaItensAccess().getAlternatives_0_0_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1815:1: ( rule__ListaItens__Alternatives_0_0_0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1815:2: rule__ListaItens__Alternatives_0_0_0
            {
            pushFollow(FOLLOW_rule__ListaItens__Alternatives_0_0_0_in_rule__ListaItens__Group_0_0__0__Impl3682);
            rule__ListaItens__Alternatives_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getListaItensAccess().getAlternatives_0_0_0()); 

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
    // $ANTLR end "rule__ListaItens__Group_0_0__0__Impl"


    // $ANTLR start "rule__ListaItens__Group_0_0__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1825:1: rule__ListaItens__Group_0_0__1 : rule__ListaItens__Group_0_0__1__Impl ;
    public final void rule__ListaItens__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1829:1: ( rule__ListaItens__Group_0_0__1__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1830:2: rule__ListaItens__Group_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ListaItens__Group_0_0__1__Impl_in_rule__ListaItens__Group_0_0__13712);
            rule__ListaItens__Group_0_0__1__Impl();

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
    // $ANTLR end "rule__ListaItens__Group_0_0__1"


    // $ANTLR start "rule__ListaItens__Group_0_0__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1836:1: rule__ListaItens__Group_0_0__1__Impl : ( ( rule__ListaItens__ItemAssignment_0_0_1 ) ) ;
    public final void rule__ListaItens__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1840:1: ( ( ( rule__ListaItens__ItemAssignment_0_0_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1841:1: ( ( rule__ListaItens__ItemAssignment_0_0_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1841:1: ( ( rule__ListaItens__ItemAssignment_0_0_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1842:1: ( rule__ListaItens__ItemAssignment_0_0_1 )
            {
             before(grammarAccess.getListaItensAccess().getItemAssignment_0_0_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1843:1: ( rule__ListaItens__ItemAssignment_0_0_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1843:2: rule__ListaItens__ItemAssignment_0_0_1
            {
            pushFollow(FOLLOW_rule__ListaItens__ItemAssignment_0_0_1_in_rule__ListaItens__Group_0_0__1__Impl3739);
            rule__ListaItens__ItemAssignment_0_0_1();

            state._fsp--;


            }

             after(grammarAccess.getListaItensAccess().getItemAssignment_0_0_1()); 

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
    // $ANTLR end "rule__ListaItens__Group_0_0__1__Impl"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1857:1: rule__IDENTIFICADOR_GERAL__Group__0 : rule__IDENTIFICADOR_GERAL__Group__0__Impl rule__IDENTIFICADOR_GERAL__Group__1 ;
    public final void rule__IDENTIFICADOR_GERAL__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1861:1: ( rule__IDENTIFICADOR_GERAL__Group__0__Impl rule__IDENTIFICADOR_GERAL__Group__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1862:2: rule__IDENTIFICADOR_GERAL__Group__0__Impl rule__IDENTIFICADOR_GERAL__Group__1
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group__0__Impl_in_rule__IDENTIFICADOR_GERAL__Group__03773);
            rule__IDENTIFICADOR_GERAL__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group__1_in_rule__IDENTIFICADOR_GERAL__Group__03776);
            rule__IDENTIFICADOR_GERAL__Group__1();

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group__0"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1869:1: rule__IDENTIFICADOR_GERAL__Group__0__Impl : ( ( rule__IDENTIFICADOR_GERAL__Alternatives_0 ) ) ;
    public final void rule__IDENTIFICADOR_GERAL__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1873:1: ( ( ( rule__IDENTIFICADOR_GERAL__Alternatives_0 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1874:1: ( ( rule__IDENTIFICADOR_GERAL__Alternatives_0 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1874:1: ( ( rule__IDENTIFICADOR_GERAL__Alternatives_0 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1875:1: ( rule__IDENTIFICADOR_GERAL__Alternatives_0 )
            {
             before(grammarAccess.getIDENTIFICADOR_GERALAccess().getAlternatives_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1876:1: ( rule__IDENTIFICADOR_GERAL__Alternatives_0 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1876:2: rule__IDENTIFICADOR_GERAL__Alternatives_0
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Alternatives_0_in_rule__IDENTIFICADOR_GERAL__Group__0__Impl3803);
            rule__IDENTIFICADOR_GERAL__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIDENTIFICADOR_GERALAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group__0__Impl"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1886:1: rule__IDENTIFICADOR_GERAL__Group__1 : rule__IDENTIFICADOR_GERAL__Group__1__Impl ;
    public final void rule__IDENTIFICADOR_GERAL__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1890:1: ( rule__IDENTIFICADOR_GERAL__Group__1__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1891:2: rule__IDENTIFICADOR_GERAL__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group__1__Impl_in_rule__IDENTIFICADOR_GERAL__Group__13833);
            rule__IDENTIFICADOR_GERAL__Group__1__Impl();

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group__1"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1897:1: rule__IDENTIFICADOR_GERAL__Group__1__Impl : ( ( rule__IDENTIFICADOR_GERAL__Group_1__0 )* ) ;
    public final void rule__IDENTIFICADOR_GERAL__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1901:1: ( ( ( rule__IDENTIFICADOR_GERAL__Group_1__0 )* ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1902:1: ( ( rule__IDENTIFICADOR_GERAL__Group_1__0 )* )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1902:1: ( ( rule__IDENTIFICADOR_GERAL__Group_1__0 )* )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1903:1: ( rule__IDENTIFICADOR_GERAL__Group_1__0 )*
            {
             before(grammarAccess.getIDENTIFICADOR_GERALAccess().getGroup_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1904:1: ( rule__IDENTIFICADOR_GERAL__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==28) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1904:2: rule__IDENTIFICADOR_GERAL__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__0_in_rule__IDENTIFICADOR_GERAL__Group__1__Impl3860);
            	    rule__IDENTIFICADOR_GERAL__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getIDENTIFICADOR_GERALAccess().getGroup_1()); 

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group__1__Impl"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group_1__0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1918:1: rule__IDENTIFICADOR_GERAL__Group_1__0 : rule__IDENTIFICADOR_GERAL__Group_1__0__Impl rule__IDENTIFICADOR_GERAL__Group_1__1 ;
    public final void rule__IDENTIFICADOR_GERAL__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1922:1: ( rule__IDENTIFICADOR_GERAL__Group_1__0__Impl rule__IDENTIFICADOR_GERAL__Group_1__1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1923:2: rule__IDENTIFICADOR_GERAL__Group_1__0__Impl rule__IDENTIFICADOR_GERAL__Group_1__1
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__0__Impl_in_rule__IDENTIFICADOR_GERAL__Group_1__03895);
            rule__IDENTIFICADOR_GERAL__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__1_in_rule__IDENTIFICADOR_GERAL__Group_1__03898);
            rule__IDENTIFICADOR_GERAL__Group_1__1();

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group_1__0"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group_1__0__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1930:1: rule__IDENTIFICADOR_GERAL__Group_1__0__Impl : ( ' ' ) ;
    public final void rule__IDENTIFICADOR_GERAL__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1934:1: ( ( ' ' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1935:1: ( ' ' )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1935:1: ( ' ' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1936:1: ' '
            {
             before(grammarAccess.getIDENTIFICADOR_GERALAccess().getSpaceKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__IDENTIFICADOR_GERAL__Group_1__0__Impl3926); 
             after(grammarAccess.getIDENTIFICADOR_GERALAccess().getSpaceKeyword_1_0()); 

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group_1__0__Impl"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group_1__1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1949:1: rule__IDENTIFICADOR_GERAL__Group_1__1 : rule__IDENTIFICADOR_GERAL__Group_1__1__Impl ;
    public final void rule__IDENTIFICADOR_GERAL__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1953:1: ( rule__IDENTIFICADOR_GERAL__Group_1__1__Impl )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1954:2: rule__IDENTIFICADOR_GERAL__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__1__Impl_in_rule__IDENTIFICADOR_GERAL__Group_1__13957);
            rule__IDENTIFICADOR_GERAL__Group_1__1__Impl();

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group_1__1"


    // $ANTLR start "rule__IDENTIFICADOR_GERAL__Group_1__1__Impl"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1960:1: rule__IDENTIFICADOR_GERAL__Group_1__1__Impl : ( ( rule__IDENTIFICADOR_GERAL__Alternatives_1_1 ) ) ;
    public final void rule__IDENTIFICADOR_GERAL__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1964:1: ( ( ( rule__IDENTIFICADOR_GERAL__Alternatives_1_1 ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1965:1: ( ( rule__IDENTIFICADOR_GERAL__Alternatives_1_1 ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1965:1: ( ( rule__IDENTIFICADOR_GERAL__Alternatives_1_1 ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1966:1: ( rule__IDENTIFICADOR_GERAL__Alternatives_1_1 )
            {
             before(grammarAccess.getIDENTIFICADOR_GERALAccess().getAlternatives_1_1()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1967:1: ( rule__IDENTIFICADOR_GERAL__Alternatives_1_1 )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1967:2: rule__IDENTIFICADOR_GERAL__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__IDENTIFICADOR_GERAL__Alternatives_1_1_in_rule__IDENTIFICADOR_GERAL__Group_1__1__Impl3984);
            rule__IDENTIFICADOR_GERAL__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIDENTIFICADOR_GERALAccess().getAlternatives_1_1()); 

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
    // $ANTLR end "rule__IDENTIFICADOR_GERAL__Group_1__1__Impl"


    // $ANTLR start "rule__Model__FuncionalidadeAssignment_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1982:1: rule__Model__FuncionalidadeAssignment_1 : ( ruleFuncionalidade ) ;
    public final void rule__Model__FuncionalidadeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1986:1: ( ( ruleFuncionalidade ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1987:1: ( ruleFuncionalidade )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1987:1: ( ruleFuncionalidade )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1988:1: ruleFuncionalidade
            {
             before(grammarAccess.getModelAccess().getFuncionalidadeFuncionalidadeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFuncionalidade_in_rule__Model__FuncionalidadeAssignment_14023);
            ruleFuncionalidade();

            state._fsp--;

             after(grammarAccess.getModelAccess().getFuncionalidadeFuncionalidadeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Model__FuncionalidadeAssignment_1"


    // $ANTLR start "rule__Model__UsuarioMetaRazaoAssignment_3"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:1997:1: rule__Model__UsuarioMetaRazaoAssignment_3 : ( ruleUsuarioMetaRazao ) ;
    public final void rule__Model__UsuarioMetaRazaoAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2001:1: ( ( ruleUsuarioMetaRazao ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2002:1: ( ruleUsuarioMetaRazao )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2002:1: ( ruleUsuarioMetaRazao )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2003:1: ruleUsuarioMetaRazao
            {
             before(grammarAccess.getModelAccess().getUsuarioMetaRazaoUsuarioMetaRazaoParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleUsuarioMetaRazao_in_rule__Model__UsuarioMetaRazaoAssignment_34054);
            ruleUsuarioMetaRazao();

            state._fsp--;

             after(grammarAccess.getModelAccess().getUsuarioMetaRazaoUsuarioMetaRazaoParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Model__UsuarioMetaRazaoAssignment_3"


    // $ANTLR start "rule__Model__CenariosAssignment_4"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2012:1: rule__Model__CenariosAssignment_4 : ( ruleCenario ) ;
    public final void rule__Model__CenariosAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2016:1: ( ( ruleCenario ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2017:1: ( ruleCenario )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2017:1: ( ruleCenario )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2018:1: ruleCenario
            {
             before(grammarAccess.getModelAccess().getCenariosCenarioParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleCenario_in_rule__Model__CenariosAssignment_44085);
            ruleCenario();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCenariosCenarioParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__Model__CenariosAssignment_4"


    // $ANTLR start "rule__UsuarioMetaRazao__Nome_do_atorAssignment_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2027:1: rule__UsuarioMetaRazao__Nome_do_atorAssignment_1 : ( ruleNOME_DO_ATOR ) ;
    public final void rule__UsuarioMetaRazao__Nome_do_atorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2031:1: ( ( ruleNOME_DO_ATOR ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2032:1: ( ruleNOME_DO_ATOR )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2032:1: ( ruleNOME_DO_ATOR )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2033:1: ruleNOME_DO_ATOR
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getNome_do_atorNOME_DO_ATORParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleNOME_DO_ATOR_in_rule__UsuarioMetaRazao__Nome_do_atorAssignment_14116);
            ruleNOME_DO_ATOR();

            state._fsp--;

             after(grammarAccess.getUsuarioMetaRazaoAccess().getNome_do_atorNOME_DO_ATORParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Nome_do_atorAssignment_1"


    // $ANTLR start "rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2042:1: rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4 : ( ruleMETA_A_SER_ALCANCADA ) ;
    public final void rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2046:1: ( ( ruleMETA_A_SER_ALCANCADA ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2047:1: ( ruleMETA_A_SER_ALCANCADA )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2047:1: ( ruleMETA_A_SER_ALCANCADA )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2048:1: ruleMETA_A_SER_ALCANCADA
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getMeta_a_ser_alcancadaMETA_A_SER_ALCANCADAParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMETA_A_SER_ALCANCADA_in_rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_44147);
            ruleMETA_A_SER_ALCANCADA();

            state._fsp--;

             after(grammarAccess.getUsuarioMetaRazaoAccess().getMeta_a_ser_alcancadaMETA_A_SER_ALCANCADAParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4"


    // $ANTLR start "rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2057:1: rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7 : ( ruleRAZAO_PARA_ALCANCAR_A_META ) ;
    public final void rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2061:1: ( ( ruleRAZAO_PARA_ALCANCAR_A_META ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2062:1: ( ruleRAZAO_PARA_ALCANCAR_A_META )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2062:1: ( ruleRAZAO_PARA_ALCANCAR_A_META )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2063:1: ruleRAZAO_PARA_ALCANCAR_A_META
            {
             before(grammarAccess.getUsuarioMetaRazaoAccess().getRazao_para_alcancar_metaRAZAO_PARA_ALCANCAR_A_METAParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_74178);
            ruleRAZAO_PARA_ALCANCAR_A_META();

            state._fsp--;

             after(grammarAccess.getUsuarioMetaRazaoAccess().getRazao_para_alcancar_metaRAZAO_PARA_ALCANCAR_A_METAParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7"


    // $ANTLR start "rule__Funcionalidade__Nome_funcionadadeAssignment_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2072:1: rule__Funcionalidade__Nome_funcionadadeAssignment_1 : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void rule__Funcionalidade__Nome_funcionadadeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2076:1: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2077:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2077:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2078:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getFuncionalidadeAccess().getNome_funcionadadeIDENTIFICADOR_GERALParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__Funcionalidade__Nome_funcionadadeAssignment_14209);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getFuncionalidadeAccess().getNome_funcionadadeIDENTIFICADOR_GERALParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Funcionalidade__Nome_funcionadadeAssignment_1"


    // $ANTLR start "rule__Cenario__XerAssignment_2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2087:1: rule__Cenario__XerAssignment_2 : ( RULE_NL ) ;
    public final void rule__Cenario__XerAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2091:1: ( ( RULE_NL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2092:1: ( RULE_NL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2092:1: ( RULE_NL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2093:1: RULE_NL
            {
             before(grammarAccess.getCenarioAccess().getXerNLTerminalRuleCall_2_0()); 
            match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__Cenario__XerAssignment_24240); 
             after(grammarAccess.getCenarioAccess().getXerNLTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Cenario__XerAssignment_2"


    // $ANTLR start "rule__Cenario__Sentencas_qualiteAssignment_3"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2102:1: rule__Cenario__Sentencas_qualiteAssignment_3 : ( ruleSentencaQualite ) ;
    public final void rule__Cenario__Sentencas_qualiteAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2106:1: ( ( ruleSentencaQualite ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2107:1: ( ruleSentencaQualite )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2107:1: ( ruleSentencaQualite )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2108:1: ruleSentencaQualite
            {
             before(grammarAccess.getCenarioAccess().getSentencas_qualiteSentencaQualiteParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSentencaQualite_in_rule__Cenario__Sentencas_qualiteAssignment_34271);
            ruleSentencaQualite();

            state._fsp--;

             after(grammarAccess.getCenarioAccess().getSentencas_qualiteSentencaQualiteParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Cenario__Sentencas_qualiteAssignment_3"


    // $ANTLR start "rule__IdentificadorCenario__NameAssignment"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2117:1: rule__IdentificadorCenario__NameAssignment : ( ruleIDENTIFICADOR_CENARIO ) ;
    public final void rule__IdentificadorCenario__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2121:1: ( ( ruleIDENTIFICADOR_CENARIO ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2122:1: ( ruleIDENTIFICADOR_CENARIO )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2122:1: ( ruleIDENTIFICADOR_CENARIO )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2123:1: ruleIDENTIFICADOR_CENARIO
            {
             before(grammarAccess.getIdentificadorCenarioAccess().getNameIDENTIFICADOR_CENARIOParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_CENARIO_in_rule__IdentificadorCenario__NameAssignment4302);
            ruleIDENTIFICADOR_CENARIO();

            state._fsp--;

             after(grammarAccess.getIdentificadorCenarioAccess().getNameIDENTIFICADOR_CENARIOParserRuleCall_0()); 

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
    // $ANTLR end "rule__IdentificadorCenario__NameAssignment"


    // $ANTLR start "rule__Meta__XAssignment_0"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2132:1: rule__Meta__XAssignment_0 : ( ( 'Meta:' ) ) ;
    public final void rule__Meta__XAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2136:1: ( ( ( 'Meta:' ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2137:1: ( ( 'Meta:' ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2137:1: ( ( 'Meta:' ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2138:1: ( 'Meta:' )
            {
             before(grammarAccess.getMetaAccess().getXMetaKeyword_0_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2139:1: ( 'Meta:' )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2140:1: 'Meta:'
            {
             before(grammarAccess.getMetaAccess().getXMetaKeyword_0_0()); 
            match(input,29,FOLLOW_29_in_rule__Meta__XAssignment_04338); 
             after(grammarAccess.getMetaAccess().getXMetaKeyword_0_0()); 

            }

             after(grammarAccess.getMetaAccess().getXMetaKeyword_0_0()); 

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
    // $ANTLR end "rule__Meta__XAssignment_0"


    // $ANTLR start "rule__Meta__Lista_metasAssignment_2"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2155:1: rule__Meta__Lista_metasAssignment_2 : ( ruleListaMetas ) ;
    public final void rule__Meta__Lista_metasAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2159:1: ( ( ruleListaMetas ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2160:1: ( ruleListaMetas )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2160:1: ( ruleListaMetas )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2161:1: ruleListaMetas
            {
             before(grammarAccess.getMetaAccess().getLista_metasListaMetasParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleListaMetas_in_rule__Meta__Lista_metasAssignment_24377);
            ruleListaMetas();

            state._fsp--;

             after(grammarAccess.getMetaAccess().getLista_metasListaMetasParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Meta__Lista_metasAssignment_2"


    // $ANTLR start "rule__ExecutarCenario__Cenario_executar_refAssignment_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2170:1: rule__ExecutarCenario__Cenario_executar_refAssignment_1 : ( ( ruleIDENTIFICADOR_CENARIO ) ) ;
    public final void rule__ExecutarCenario__Cenario_executar_refAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2174:1: ( ( ( ruleIDENTIFICADOR_CENARIO ) ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2175:1: ( ( ruleIDENTIFICADOR_CENARIO ) )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2175:1: ( ( ruleIDENTIFICADOR_CENARIO ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2176:1: ( ruleIDENTIFICADOR_CENARIO )
            {
             before(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refCenarioCrossReference_1_0()); 
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2177:1: ( ruleIDENTIFICADOR_CENARIO )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2178:1: ruleIDENTIFICADOR_CENARIO
            {
             before(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refCenarioIDENTIFICADOR_CENARIOParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_CENARIO_in_rule__ExecutarCenario__Cenario_executar_refAssignment_14412);
            ruleIDENTIFICADOR_CENARIO();

            state._fsp--;

             after(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refCenarioIDENTIFICADOR_CENARIOParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refCenarioCrossReference_1_0()); 

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
    // $ANTLR end "rule__ExecutarCenario__Cenario_executar_refAssignment_1"


    // $ANTLR start "rule__ListaItens__ItemAssignment_0_0_1"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2189:1: rule__ListaItens__ItemAssignment_0_0_1 : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void rule__ListaItens__ItemAssignment_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2193:1: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2194:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2194:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2195:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getListaItensAccess().getItemIDENTIFICADOR_GERALParserRuleCall_0_0_1_0()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__ListaItens__ItemAssignment_0_0_14447);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getListaItensAccess().getItemIDENTIFICADOR_GERALParserRuleCall_0_0_1_0()); 

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
    // $ANTLR end "rule__ListaItens__ItemAssignment_0_0_1"


    // $ANTLR start "rule__NOME_DO_ATOR__Nome_do_atorAssignment"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2204:1: rule__NOME_DO_ATOR__Nome_do_atorAssignment : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void rule__NOME_DO_ATOR__Nome_do_atorAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2208:1: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2209:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2209:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2210:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getNOME_DO_ATORAccess().getNome_do_atorIDENTIFICADOR_GERALParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__NOME_DO_ATOR__Nome_do_atorAssignment4478);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getNOME_DO_ATORAccess().getNome_do_atorIDENTIFICADOR_GERALParserRuleCall_0()); 

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
    // $ANTLR end "rule__NOME_DO_ATOR__Nome_do_atorAssignment"


    // $ANTLR start "rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2219:1: rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2223:1: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2224:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2224:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2225:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getMETA_A_SER_ALCANCADAAccess().getMeta_a_ser_alcancadaIDENTIFICADOR_GERALParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment4509);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getMETA_A_SER_ALCANCADAAccess().getMeta_a_ser_alcancadaIDENTIFICADOR_GERALParserRuleCall_0()); 

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
    // $ANTLR end "rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment"


    // $ANTLR start "rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment"
    // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2234:1: rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment : ( ruleIDENTIFICADOR_GERAL ) ;
    public final void rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2238:1: ( ( ruleIDENTIFICADOR_GERAL ) )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2239:1: ( ruleIDENTIFICADOR_GERAL )
            {
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2239:1: ( ruleIDENTIFICADOR_GERAL )
            // ../storydsl.ui/src-gen/br/gov/frameworkdemoiselle/behave/plugin/eclipse/dsl/ui/contentassist/antlr/internal/InternalStoryDsl.g:2240:1: ruleIDENTIFICADOR_GERAL
            {
             before(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METAAccess().getRazao_para_alcancar_a_metaIDENTIFICADOR_GERALParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment4540);
            ruleIDENTIFICADOR_GERAL();

            state._fsp--;

             after(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METAAccess().getRazao_para_alcancar_a_metaIDENTIFICADOR_GERALParserRuleCall_0()); 

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
    // $ANTLR end "rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment"

    // Delegated rules


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\22\uffff";
    static final String DFA22_eofS =
        "\1\1\21\uffff";
    static final String DFA22_minS =
        "\1\6\1\uffff\2\4\2\24\3\4\1\6\2\24\1\uffff\2\24\1\4\2\24";
    static final String DFA22_maxS =
        "\1\35\1\uffff\2\5\2\34\1\5\1\6\1\5\1\6\2\34\1\uffff\2\34\1\5\2\34";
    static final String DFA22_acceptS =
        "\1\uffff\1\2\12\uffff\1\1\5\uffff";
    static final String DFA22_specialS =
        "\22\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\10\uffff\5\1\1\2\1\3\5\uffff\1\1\1\uffff\1\1",
            "",
            "\1\4\1\5",
            "\1\4\1\5",
            "\1\7\1\10\1\11\5\uffff\1\6",
            "\1\7\1\10\1\11\5\uffff\1\6",
            "\1\12\1\13",
            "\1\15\1\16\1\14",
            "\1\15\1\16",
            "\1\14",
            "\1\7\1\10\1\11\5\uffff\1\6",
            "\1\7\1\10\1\11\5\uffff\1\6",
            "",
            "\1\7\1\10\1\11\5\uffff\1\17",
            "\1\7\1\10\1\11\5\uffff\1\17",
            "\1\20\1\21",
            "\1\7\1\10\1\11\5\uffff\1\17",
            "\1\7\1\10\1\11\5\uffff\1\17"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "()* loopback of 1654:1: ( rule__ListaItens__Group_0__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsuarioMetaRazao_in_entryRuleUsuarioMetaRazao121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUsuarioMetaRazao128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__0_in_ruleUsuarioMetaRazao154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFuncionalidade_in_entryRuleFuncionalidade181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFuncionalidade188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Group__0_in_ruleFuncionalidade214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCenario_in_entryRuleCenario241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCenario248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cenario__Group__0_in_ruleCenario274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentificadorCenario_in_entryRuleIdentificadorCenario301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentificadorCenario308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IdentificadorCenario__NameAssignment_in_ruleIdentificadorCenario334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSentencaQualite_in_entryRuleSentencaQualite361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSentencaQualite368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SentencaQualite__Alternatives_in_ruleSentencaQualite394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMeta_in_entryRuleMeta421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMeta428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Meta__Group__0_in_ruleMeta454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListaMetas_in_entryRuleListaMetas481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListaMetas488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaMetas__Group__0_in_ruleListaMetas514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutarCenario_in_entryRuleExecutarCenario541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutarCenario548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Group__0_in_ruleExecutarCenario574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListaItens_in_entryRuleListaItens601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListaItens608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group__0_in_ruleListaItens634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_CENARIO_in_entryRuleIDENTIFICADOR_CENARIO661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDENTIFICADOR_CENARIO668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_ruleIDENTIFICADOR_CENARIO694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_entryRuleIDENTIFICADOR_GERAL720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDENTIFICADOR_GERAL727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group__0_in_ruleIDENTIFICADOR_GERAL753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNOME_DO_ATOR_in_entryRuleNOME_DO_ATOR780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNOME_DO_ATOR787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NOME_DO_ATOR__Nome_do_atorAssignment_in_ruleNOME_DO_ATOR813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMETA_A_SER_ALCANCADA_in_entryRuleMETA_A_SER_ALCANCADA840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMETA_A_SER_ALCANCADA847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment_in_ruleMETA_A_SER_ALCANCADA873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_entryRuleRAZAO_PARA_ALCANCAR_A_META900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRAZAO_PARA_ALCANCAR_A_META907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment_in_ruleRAZAO_PARA_ALCANCAR_A_META933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutarCenario_in_rule__SentencaQualite__Alternatives969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListaItens_in_rule__SentencaQualite__Alternatives986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMeta_in_rule__SentencaQualite__Alternatives1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ListaMetas__Alternatives_01036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ListaMetas__Alternatives_01056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExecutarCenario__Alternatives_01091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ExecutarCenario__Alternatives_01111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ExecutarCenario__Alternatives_01131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ExecutarCenario__Alternatives_01151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ExecutarCenario__Alternatives_01171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ListaItens__Alternatives_0_0_01206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ListaItens__Alternatives_0_0_01226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ListaItens__Alternatives_0_11261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ListaItens__Alternatives_0_11281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IDENTIFICADOR_GERAL__Alternatives_01315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXID_in_rule__IDENTIFICADOR_GERAL__Alternatives_01332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IDENTIFICADOR_GERAL__Alternatives_1_11364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXID_in_rule__IDENTIFICADOR_GERAL__Alternatives_1_11381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01411 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__Model__Group__0__Impl1442 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11473 = new BitSet(new long[]{0x0000000008800040L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__FuncionalidadeAssignment_1_in_rule__Model__Group__1__Impl1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__21533 = new BitSet(new long[]{0x0000000008800040L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__21536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__Model__Group__2__Impl1564 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__31595 = new BitSet(new long[]{0x0000000008800040L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__31598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__UsuarioMetaRazaoAssignment_3_in_rule__Model__Group__3__Impl1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__41656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CenariosAssignment_4_in_rule__Model__Group__4__Impl1685 = new BitSet(new long[]{0x0000000008800042L});
    public static final BitSet FOLLOW_rule__Model__CenariosAssignment_4_in_rule__Model__Group__4__Impl1697 = new BitSet(new long[]{0x0000000008800042L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__0__Impl_in_rule__UsuarioMetaRazao__Group__01740 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__1_in_rule__UsuarioMetaRazao__Group__01743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__UsuarioMetaRazao__Group__0__Impl1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__1__Impl_in_rule__UsuarioMetaRazao__Group__11802 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__2_in_rule__UsuarioMetaRazao__Group__11805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Nome_do_atorAssignment_1_in_rule__UsuarioMetaRazao__Group__1__Impl1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__2__Impl_in_rule__UsuarioMetaRazao__Group__21862 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__3_in_rule__UsuarioMetaRazao__Group__21865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__UsuarioMetaRazao__Group__2__Impl1893 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__3__Impl_in_rule__UsuarioMetaRazao__Group__31924 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__4_in_rule__UsuarioMetaRazao__Group__31927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__UsuarioMetaRazao__Group__3__Impl1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__4__Impl_in_rule__UsuarioMetaRazao__Group__41986 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__5_in_rule__UsuarioMetaRazao__Group__41989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_4_in_rule__UsuarioMetaRazao__Group__4__Impl2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__5__Impl_in_rule__UsuarioMetaRazao__Group__52046 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__6_in_rule__UsuarioMetaRazao__Group__52049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__UsuarioMetaRazao__Group__5__Impl2077 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__6__Impl_in_rule__UsuarioMetaRazao__Group__62108 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__7_in_rule__UsuarioMetaRazao__Group__62111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__UsuarioMetaRazao__Group__6__Impl2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__7__Impl_in_rule__UsuarioMetaRazao__Group__72170 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__8_in_rule__UsuarioMetaRazao__Group__72173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_7_in_rule__UsuarioMetaRazao__Group__7__Impl2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UsuarioMetaRazao__Group__8__Impl_in_rule__UsuarioMetaRazao__Group__82230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__UsuarioMetaRazao__Group__8__Impl2258 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Group__0__Impl_in_rule__Funcionalidade__Group__02307 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Group__1_in_rule__Funcionalidade__Group__02310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Funcionalidade__Group__0__Impl2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Group__1__Impl_in_rule__Funcionalidade__Group__12369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Group__2_in_rule__Funcionalidade__Group__12372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Nome_funcionadadeAssignment_1_in_rule__Funcionalidade__Group__1__Impl2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Funcionalidade__Group__2__Impl_in_rule__Funcionalidade__Group__22429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__Funcionalidade__Group__2__Impl2457 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Cenario__Group__0__Impl_in_rule__Cenario__Group__02494 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Cenario__Group__1_in_rule__Cenario__Group__02497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Cenario__Group__0__Impl2525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cenario__Group__1__Impl_in_rule__Cenario__Group__12556 = new BitSet(new long[]{0x00000000203F8040L});
    public static final BitSet FOLLOW_rule__Cenario__Group__2_in_rule__Cenario__Group__12559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentificadorCenario_in_rule__Cenario__Group__1__Impl2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cenario__Group__2__Impl_in_rule__Cenario__Group__22615 = new BitSet(new long[]{0x00000000203F8040L});
    public static final BitSet FOLLOW_rule__Cenario__Group__3_in_rule__Cenario__Group__22618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cenario__XerAssignment_2_in_rule__Cenario__Group__2__Impl2645 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Cenario__Group__3__Impl_in_rule__Cenario__Group__32676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cenario__Sentencas_qualiteAssignment_3_in_rule__Cenario__Group__3__Impl2703 = new BitSet(new long[]{0x00000000203F8002L});
    public static final BitSet FOLLOW_rule__Meta__Group__0__Impl_in_rule__Meta__Group__02742 = new BitSet(new long[]{0x0000000000006040L});
    public static final BitSet FOLLOW_rule__Meta__Group__1_in_rule__Meta__Group__02745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Meta__XAssignment_0_in_rule__Meta__Group__0__Impl2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Meta__Group__1__Impl_in_rule__Meta__Group__12802 = new BitSet(new long[]{0x0000000000006040L});
    public static final BitSet FOLLOW_rule__Meta__Group__2_in_rule__Meta__Group__12805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__Meta__Group__1__Impl2833 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Meta__Group__2__Impl_in_rule__Meta__Group__22864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Meta__Lista_metasAssignment_2_in_rule__Meta__Group__2__Impl2893 = new BitSet(new long[]{0x0000000000006042L});
    public static final BitSet FOLLOW_rule__Meta__Lista_metasAssignment_2_in_rule__Meta__Group__2__Impl2905 = new BitSet(new long[]{0x0000000000006042L});
    public static final BitSet FOLLOW_rule__ListaMetas__Group__0__Impl_in_rule__ListaMetas__Group__02944 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ListaMetas__Group__1_in_rule__ListaMetas__Group__02947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaMetas__Alternatives_0_in_rule__ListaMetas__Group__0__Impl2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaMetas__Group__1__Impl_in_rule__ListaMetas__Group__13004 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ListaMetas__Group__2_in_rule__ListaMetas__Group__13007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__ListaMetas__Group__1__Impl3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaMetas__Group__2__Impl_in_rule__ListaMetas__Group__23063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__ListaMetas__Group__2__Impl3091 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Group__0__Impl_in_rule__ExecutarCenario__Group__03128 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Group__1_in_rule__ExecutarCenario__Group__03131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Alternatives_0_in_rule__ExecutarCenario__Group__0__Impl3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Group__1__Impl_in_rule__ExecutarCenario__Group__13188 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Group__2_in_rule__ExecutarCenario__Group__13191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Cenario_executar_refAssignment_1_in_rule__ExecutarCenario__Group__1__Impl3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutarCenario__Group__2__Impl_in_rule__ExecutarCenario__Group__23248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__ExecutarCenario__Group__2__Impl3276 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__ListaItens__Group__0__Impl_in_rule__ListaItens__Group__03313 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ListaItens__Group__1_in_rule__ListaItens__Group__03316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__0_in_rule__ListaItens__Group__0__Impl3345 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__0_in_rule__ListaItens__Group__0__Impl3357 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group__1__Impl_in_rule__ListaItens__Group__13390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__ListaItens__Group__1__Impl3418 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__0__Impl_in_rule__ListaItens__Group_0__03453 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__1_in_rule__ListaItens__Group_0__03456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0_0__0_in_rule__ListaItens__Group_0__0__Impl3485 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0_0__0_in_rule__ListaItens__Group_0__0__Impl3497 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__1__Impl_in_rule__ListaItens__Group_0__13530 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__2_in_rule__ListaItens__Group_0__13533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Alternatives_0_1_in_rule__ListaItens__Group_0__1__Impl3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0__2__Impl_in_rule__ListaItens__Group_0__23590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__ListaItens__Group_0__2__Impl3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0_0__0__Impl_in_rule__ListaItens__Group_0_0__03652 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0_0__1_in_rule__ListaItens__Group_0_0__03655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Alternatives_0_0_0_in_rule__ListaItens__Group_0_0__0__Impl3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__Group_0_0__1__Impl_in_rule__ListaItens__Group_0_0__13712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListaItens__ItemAssignment_0_0_1_in_rule__ListaItens__Group_0_0__1__Impl3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group__0__Impl_in_rule__IDENTIFICADOR_GERAL__Group__03773 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group__1_in_rule__IDENTIFICADOR_GERAL__Group__03776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Alternatives_0_in_rule__IDENTIFICADOR_GERAL__Group__0__Impl3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group__1__Impl_in_rule__IDENTIFICADOR_GERAL__Group__13833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__0_in_rule__IDENTIFICADOR_GERAL__Group__1__Impl3860 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__0__Impl_in_rule__IDENTIFICADOR_GERAL__Group_1__03895 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__1_in_rule__IDENTIFICADOR_GERAL__Group_1__03898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__IDENTIFICADOR_GERAL__Group_1__0__Impl3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Group_1__1__Impl_in_rule__IDENTIFICADOR_GERAL__Group_1__13957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDENTIFICADOR_GERAL__Alternatives_1_1_in_rule__IDENTIFICADOR_GERAL__Group_1__1__Impl3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFuncionalidade_in_rule__Model__FuncionalidadeAssignment_14023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsuarioMetaRazao_in_rule__Model__UsuarioMetaRazaoAssignment_34054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCenario_in_rule__Model__CenariosAssignment_44085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNOME_DO_ATOR_in_rule__UsuarioMetaRazao__Nome_do_atorAssignment_14116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMETA_A_SER_ALCANCADA_in_rule__UsuarioMetaRazao__Meta_a_ser_alcancadaAssignment_44147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRAZAO_PARA_ALCANCAR_A_META_in_rule__UsuarioMetaRazao__Razao_para_alcancar_metaAssignment_74178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__Funcionalidade__Nome_funcionadadeAssignment_14209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__Cenario__XerAssignment_24240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSentencaQualite_in_rule__Cenario__Sentencas_qualiteAssignment_34271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_CENARIO_in_rule__IdentificadorCenario__NameAssignment4302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Meta__XAssignment_04338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListaMetas_in_rule__Meta__Lista_metasAssignment_24377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_CENARIO_in_rule__ExecutarCenario__Cenario_executar_refAssignment_14412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__ListaItens__ItemAssignment_0_0_14447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__NOME_DO_ATOR__Nome_do_atorAssignment4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__META_A_SER_ALCANCADA__Meta_a_ser_alcancadaAssignment4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDENTIFICADOR_GERAL_in_rule__RAZAO_PARA_ALCANCAR_A_META__Razao_para_alcancar_a_metaAssignment4540 = new BitSet(new long[]{0x0000000000000002L});

}