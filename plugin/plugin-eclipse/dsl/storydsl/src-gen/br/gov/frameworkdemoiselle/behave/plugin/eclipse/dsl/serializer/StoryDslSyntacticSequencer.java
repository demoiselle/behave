package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.serializer;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.services.StoryDslGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class StoryDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected StoryDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ExecutarCenario_DadoKeyword_0_0_or_EKeyword_0_3_or_EntOKeyword_0_2_or_MasKeyword_0_4_or_QuandoKeyword_0_1;
	protected AbstractElementAlias match_ExecutarCenario_NLTerminalRuleCall_2_a;
	protected AbstractElementAlias match_Funcionalidade_NLTerminalRuleCall_2_a;
	protected AbstractElementAlias match_ListaItens_NLTerminalRuleCall_1_a;
	protected AbstractElementAlias match_ListaItens_SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0;
	protected AbstractElementAlias match_ListaItens_VerticalLineKeyword_0_0_0_0_or_VerticalLineSpaceKeyword_0_0_0_1;
	protected AbstractElementAlias match_ListaItens_____SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0___NLTerminalRuleCall_0_2__q;
	protected AbstractElementAlias match_Meta_NLTerminalRuleCall_1_a;
	protected AbstractElementAlias match_Model_NLTerminalRuleCall_0_a;
	protected AbstractElementAlias match_Model_NLTerminalRuleCall_2_a;
	protected AbstractElementAlias match_UsuarioMetaRazao_NLTerminalRuleCall_2_a;
	protected AbstractElementAlias match_UsuarioMetaRazao_NLTerminalRuleCall_5_a;
	protected AbstractElementAlias match_UsuarioMetaRazao_NLTerminalRuleCall_8_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (StoryDslGrammarAccess) access;
		match_ExecutarCenario_DadoKeyword_0_0_or_EKeyword_0_3_or_EntOKeyword_0_2_or_MasKeyword_0_4_or_QuandoKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExecutarCenarioAccess().getDadoKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getExecutarCenarioAccess().getEKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getExecutarCenarioAccess().getEntOKeyword_0_2()), new TokenAlias(false, false, grammarAccess.getExecutarCenarioAccess().getMasKeyword_0_4()), new TokenAlias(false, false, grammarAccess.getExecutarCenarioAccess().getQuandoKeyword_0_1()));
		match_ExecutarCenario_NLTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getExecutarCenarioAccess().getNLTerminalRuleCall_2());
		match_Funcionalidade_NLTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getFuncionalidadeAccess().getNLTerminalRuleCall_2());
		match_ListaItens_NLTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getListaItensAccess().getNLTerminalRuleCall_1());
		match_ListaItens_SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getListaItensAccess().getSpaceVerticalLineKeyword_0_1_1()), new TokenAlias(false, false, grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_1_0()));
		match_ListaItens_VerticalLineKeyword_0_0_0_0_or_VerticalLineSpaceKeyword_0_0_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_0_0_0()), new TokenAlias(false, false, grammarAccess.getListaItensAccess().getVerticalLineSpaceKeyword_0_0_0_1()));
		match_ListaItens_____SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0___NLTerminalRuleCall_0_2__q = new GroupAlias(false, true, new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getListaItensAccess().getSpaceVerticalLineKeyword_0_1_1()), new TokenAlias(false, false, grammarAccess.getListaItensAccess().getVerticalLineKeyword_0_1_0())), new TokenAlias(false, false, grammarAccess.getListaItensAccess().getNLTerminalRuleCall_0_2()));
		match_Meta_NLTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getMetaAccess().getNLTerminalRuleCall_1());
		match_Model_NLTerminalRuleCall_0_a = new TokenAlias(true, true, grammarAccess.getModelAccess().getNLTerminalRuleCall_0());
		match_Model_NLTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getModelAccess().getNLTerminalRuleCall_2());
		match_UsuarioMetaRazao_NLTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_2());
		match_UsuarioMetaRazao_NLTerminalRuleCall_5_a = new TokenAlias(true, true, grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_5());
		match_UsuarioMetaRazao_NLTerminalRuleCall_8_a = new TokenAlias(true, true, grammarAccess.getUsuarioMetaRazaoAccess().getNLTerminalRuleCall_8());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getNLRule())
			return getNLToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal NL: 
	 * 	('\n' | '\r')+ 
	 * ;
	 */
	protected String getNLToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\n";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ExecutarCenario_DadoKeyword_0_0_or_EKeyword_0_3_or_EntOKeyword_0_2_or_MasKeyword_0_4_or_QuandoKeyword_0_1.equals(syntax))
				emit_ExecutarCenario_DadoKeyword_0_0_or_EKeyword_0_3_or_EntOKeyword_0_2_or_MasKeyword_0_4_or_QuandoKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExecutarCenario_NLTerminalRuleCall_2_a.equals(syntax))
				emit_ExecutarCenario_NLTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Funcionalidade_NLTerminalRuleCall_2_a.equals(syntax))
				emit_Funcionalidade_NLTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ListaItens_NLTerminalRuleCall_1_a.equals(syntax))
				emit_ListaItens_NLTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ListaItens_SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0.equals(syntax))
				emit_ListaItens_SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ListaItens_VerticalLineKeyword_0_0_0_0_or_VerticalLineSpaceKeyword_0_0_0_1.equals(syntax))
				emit_ListaItens_VerticalLineKeyword_0_0_0_0_or_VerticalLineSpaceKeyword_0_0_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ListaItens_____SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0___NLTerminalRuleCall_0_2__q.equals(syntax))
				emit_ListaItens_____SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0___NLTerminalRuleCall_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Meta_NLTerminalRuleCall_1_a.equals(syntax))
				emit_Meta_NLTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Model_NLTerminalRuleCall_0_a.equals(syntax))
				emit_Model_NLTerminalRuleCall_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Model_NLTerminalRuleCall_2_a.equals(syntax))
				emit_Model_NLTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_UsuarioMetaRazao_NLTerminalRuleCall_2_a.equals(syntax))
				emit_UsuarioMetaRazao_NLTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_UsuarioMetaRazao_NLTerminalRuleCall_5_a.equals(syntax))
				emit_UsuarioMetaRazao_NLTerminalRuleCall_5_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_UsuarioMetaRazao_NLTerminalRuleCall_8_a.equals(syntax))
				emit_UsuarioMetaRazao_NLTerminalRuleCall_8_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'Quando ' | 'Dado ' | 'Então ' | 'E ' | 'Mas '
	 */
	protected void emit_ExecutarCenario_DadoKeyword_0_0_or_EKeyword_0_3_or_EntOKeyword_0_2_or_MasKeyword_0_4_or_QuandoKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_ExecutarCenario_NLTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_Funcionalidade_NLTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_ListaItens_NLTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '|' | ' |'
	 */
	protected void emit_ListaItens_SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '| ' | '|'
	 */
	protected void emit_ListaItens_VerticalLineKeyword_0_0_0_0_or_VerticalLineSpaceKeyword_0_0_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (('|' | ' |') NL)?
	 */
	protected void emit_ListaItens_____SpaceVerticalLineKeyword_0_1_1_or_VerticalLineKeyword_0_1_0___NLTerminalRuleCall_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_Meta_NLTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_Model_NLTerminalRuleCall_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_Model_NLTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_UsuarioMetaRazao_NLTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_UsuarioMetaRazao_NLTerminalRuleCall_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NL*
	 */
	protected void emit_UsuarioMetaRazao_NLTerminalRuleCall_8_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
