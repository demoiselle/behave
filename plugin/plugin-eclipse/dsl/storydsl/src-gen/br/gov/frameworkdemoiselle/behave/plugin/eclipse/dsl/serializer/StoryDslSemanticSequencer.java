package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.serializer;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.services.StoryDslGrammarAccess;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class StoryDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private StoryDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == StoryDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case StoryDslPackage.EXECUTAR_CENARIO:
				if(context == grammarAccess.getExecutarCenarioRule() ||
				   context == grammarAccess.getSentencaQualiteRule()) {
					sequence_ExecutarCenario(context, (ExecutarCenario) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.FUNCIONALIDADE:
				if(context == grammarAccess.getFuncionalidadeRule()) {
					sequence_Funcionalidade(context, (Funcionalidade) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.IDENTIFICADOR_CENARIO:
				if(context == grammarAccess.getCenarioRule()) {
					sequence_Cenario_IdentificadorCenario(context, (IdentificadorCenario) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getIdentificadorCenarioRule()) {
					sequence_IdentificadorCenario(context, (IdentificadorCenario) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.LISTA_ITENS:
				if(context == grammarAccess.getListaItensRule() ||
				   context == grammarAccess.getSentencaQualiteRule()) {
					sequence_ListaItens(context, (ListaItens) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.META_ASER_ALCANCADA:
				if(context == grammarAccess.getMETA_A_SER_ALCANCADARule()) {
					sequence_META_A_SER_ALCANCADA(context, (META_A_SER_ALCANCADA) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.META:
				if(context == grammarAccess.getMetaRule() ||
				   context == grammarAccess.getSentencaQualiteRule()) {
					sequence_Meta(context, (Meta) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.NOME_DO_ATOR:
				if(context == grammarAccess.getNOME_DO_ATORRule()) {
					sequence_NOME_DO_ATOR(context, (NOME_DO_ATOR) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA:
				if(context == grammarAccess.getRAZAO_PARA_ALCANCAR_A_METARule()) {
					sequence_RAZAO_PARA_ALCANCAR_A_META(context, (RAZAO_PARA_ALCANCAR_A_META) semanticObject); 
					return; 
				}
				else break;
			case StoryDslPackage.USUARIO_META_RAZAO:
				if(context == grammarAccess.getUsuarioMetaRazaoRule()) {
					sequence_UsuarioMetaRazao(context, (UsuarioMetaRazao) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=IDENTIFICADOR_CENARIO xer+=NL* sentencas_qualite+=SentencaQualite*)
	 */
	protected void sequence_Cenario_IdentificadorCenario(EObject context, IdentificadorCenario semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     cenario_executar_ref=[Cenario|IDENTIFICADOR_CENARIO]
	 */
	protected void sequence_ExecutarCenario(EObject context, ExecutarCenario semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExecutarCenarioAccess().getCenario_executar_refCenarioIDENTIFICADOR_CENARIOParserRuleCall_1_0_1(), semanticObject.getCenario_executar_ref());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     nome_funcionadade=IDENTIFICADOR_GERAL
	 */
	protected void sequence_Funcionalidade(EObject context, Funcionalidade semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.FUNCIONALIDADE__NOME_FUNCIONADADE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.FUNCIONALIDADE__NOME_FUNCIONADADE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFuncionalidadeAccess().getNome_funcionadadeIDENTIFICADOR_GERALParserRuleCall_1_0(), semanticObject.getNome_funcionadade());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=IDENTIFICADOR_CENARIO
	 */
	protected void sequence_IdentificadorCenario(EObject context, IdentificadorCenario semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     item+=IDENTIFICADOR_GERAL+
	 */
	protected void sequence_ListaItens(EObject context, ListaItens semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     meta_a_ser_alcancada=IDENTIFICADOR_GERAL
	 */
	protected void sequence_META_A_SER_ALCANCADA(EObject context, META_A_SER_ALCANCADA semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.META_ASER_ALCANCADA__META_ASER_ALCANCADA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.META_ASER_ALCANCADA__META_ASER_ALCANCADA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMETA_A_SER_ALCANCADAAccess().getMeta_a_ser_alcancadaIDENTIFICADOR_GERALParserRuleCall_0(), semanticObject.getMeta_a_ser_alcancada());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (x='Meta:' lista_metas+=ListaMetas+)
	 */
	protected void sequence_Meta(EObject context, Meta semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (funcionalidade=Funcionalidade usuarioMetaRazao+=UsuarioMetaRazao? cenarios+=Cenario+)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     nome_do_ator=IDENTIFICADOR_GERAL
	 */
	protected void sequence_NOME_DO_ATOR(EObject context, NOME_DO_ATOR semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.NOME_DO_ATOR__NOME_DO_ATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.NOME_DO_ATOR__NOME_DO_ATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNOME_DO_ATORAccess().getNome_do_atorIDENTIFICADOR_GERALParserRuleCall_0(), semanticObject.getNome_do_ator());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     razao_para_alcancar_a_meta=IDENTIFICADOR_GERAL
	 */
	protected void sequence_RAZAO_PARA_ALCANCAR_A_META(EObject context, RAZAO_PARA_ALCANCAR_A_META semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRAZAO_PARA_ALCANCAR_A_METAAccess().getRazao_para_alcancar_a_metaIDENTIFICADOR_GERALParserRuleCall_0(), semanticObject.getRazao_para_alcancar_a_meta());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (nome_do_ator=NOME_DO_ATOR meta_a_ser_alcancada=META_A_SER_ALCANCADA razao_para_alcancar_meta=RAZAO_PARA_ALCANCAR_A_META)
	 */
	protected void sequence_UsuarioMetaRazao(EObject context, UsuarioMetaRazao semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.USUARIO_META_RAZAO__NOME_DO_ATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.USUARIO_META_RAZAO__NOME_DO_ATOR));
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.USUARIO_META_RAZAO__META_ASER_ALCANCADA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.USUARIO_META_RAZAO__META_ASER_ALCANCADA));
			if(transientValues.isValueTransient(semanticObject, StoryDslPackage.Literals.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StoryDslPackage.Literals.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUsuarioMetaRazaoAccess().getNome_do_atorNOME_DO_ATORParserRuleCall_1_0(), semanticObject.getNome_do_ator());
		feeder.accept(grammarAccess.getUsuarioMetaRazaoAccess().getMeta_a_ser_alcancadaMETA_A_SER_ALCANCADAParserRuleCall_4_0(), semanticObject.getMeta_a_ser_alcancada());
		feeder.accept(grammarAccess.getUsuarioMetaRazaoAccess().getRazao_para_alcancar_metaRAZAO_PARA_ALCANCAR_A_METAParserRuleCall_7_0(), semanticObject.getRazao_para_alcancar_meta());
		feeder.finish();
	}
}
