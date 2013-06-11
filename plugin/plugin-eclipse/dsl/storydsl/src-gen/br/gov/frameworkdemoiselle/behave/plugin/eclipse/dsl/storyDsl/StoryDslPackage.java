/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslFactory
 * @model kind="package"
 * @generated
 */
public interface StoryDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "storyDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.gov.br/frameworkdemoiselle/behave/plugin/eclipse/dsl/StoryDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "storyDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StoryDslPackage eINSTANCE = br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl.init();

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Funcionalidade</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FUNCIONALIDADE = 0;

  /**
   * The feature id for the '<em><b>Usuario Meta Razao</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__USUARIO_META_RAZAO = 1;

  /**
   * The feature id for the '<em><b>Cenarios</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CENARIOS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl <em>Usuario Meta Razao</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getUsuarioMetaRazao()
   * @generated
   */
  int USUARIO_META_RAZAO = 1;

  /**
   * The feature id for the '<em><b>Nome do ator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USUARIO_META_RAZAO__NOME_DO_ATOR = 0;

  /**
   * The feature id for the '<em><b>Meta aser alcancada</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USUARIO_META_RAZAO__META_ASER_ALCANCADA = 1;

  /**
   * The feature id for the '<em><b>Razao para alcancar meta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META = 2;

  /**
   * The number of structural features of the '<em>Usuario Meta Razao</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USUARIO_META_RAZAO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.FuncionalidadeImpl <em>Funcionalidade</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.FuncionalidadeImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getFuncionalidade()
   * @generated
   */
  int FUNCIONALIDADE = 2;

  /**
   * The feature id for the '<em><b>Nome funcionadade</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCIONALIDADE__NOME_FUNCIONADADE = 0;

  /**
   * The number of structural features of the '<em>Funcionalidade</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCIONALIDADE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.CenarioImpl <em>Cenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.CenarioImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getCenario()
   * @generated
   */
  int CENARIO = 3;

  /**
   * The number of structural features of the '<em>Cenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CENARIO_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl <em>Identificador Cenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getIdentificadorCenario()
   * @generated
   */
  int IDENTIFICADOR_CENARIO = 4;

  /**
   * The feature id for the '<em><b>Xer</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFICADOR_CENARIO__XER = CENARIO_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sentencas qualite</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE = CENARIO_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFICADOR_CENARIO__NAME = CENARIO_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Identificador Cenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFICADOR_CENARIO_FEATURE_COUNT = CENARIO_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.SentencaQualiteImpl <em>Sentenca Qualite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.SentencaQualiteImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getSentencaQualite()
   * @generated
   */
  int SENTENCA_QUALITE = 5;

  /**
   * The number of structural features of the '<em>Sentenca Qualite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SENTENCA_QUALITE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.MetaImpl <em>Meta</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.MetaImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getMeta()
   * @generated
   */
  int META = 6;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META__X = SENTENCA_QUALITE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Lista metas</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META__LISTA_METAS = SENTENCA_QUALITE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Meta</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_FEATURE_COUNT = SENTENCA_QUALITE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ExecutarCenarioImpl <em>Executar Cenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ExecutarCenarioImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getExecutarCenario()
   * @generated
   */
  int EXECUTAR_CENARIO = 7;

  /**
   * The feature id for the '<em><b>Cenario executar ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF = SENTENCA_QUALITE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Executar Cenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTAR_CENARIO_FEATURE_COUNT = SENTENCA_QUALITE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ListaItensImpl <em>Lista Itens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ListaItensImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getListaItens()
   * @generated
   */
  int LISTA_ITENS = 8;

  /**
   * The feature id for the '<em><b>Item</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA_ITENS__ITEM = SENTENCA_QUALITE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Lista Itens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA_ITENS_FEATURE_COUNT = SENTENCA_QUALITE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.NOME_DO_ATORImpl <em>NOME DO ATOR</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.NOME_DO_ATORImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getNOME_DO_ATOR()
   * @generated
   */
  int NOME_DO_ATOR = 9;

  /**
   * The feature id for the '<em><b>Nome do ator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOME_DO_ATOR__NOME_DO_ATOR = 0;

  /**
   * The number of structural features of the '<em>NOME DO ATOR</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOME_DO_ATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.META_A_SER_ALCANCADAImpl <em>META ASER ALCANCADA</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.META_A_SER_ALCANCADAImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getMETA_A_SER_ALCANCADA()
   * @generated
   */
  int META_ASER_ALCANCADA = 10;

  /**
   * The feature id for the '<em><b>Meta aser alcancada</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_ASER_ALCANCADA__META_ASER_ALCANCADA = 0;

  /**
   * The number of structural features of the '<em>META ASER ALCANCADA</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_ASER_ALCANCADA_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.RAZAO_PARA_ALCANCAR_A_METAImpl <em>RAZAO PARA ALCANCAR AMETA</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.RAZAO_PARA_ALCANCAR_A_METAImpl
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getRAZAO_PARA_ALCANCAR_A_META()
   * @generated
   */
  int RAZAO_PARA_ALCANCAR_AMETA = 11;

  /**
   * The feature id for the '<em><b>Razao para alcancar ameta</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA = 0;

  /**
   * The number of structural features of the '<em>RAZAO PARA ALCANCAR AMETA</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RAZAO_PARA_ALCANCAR_AMETA_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getFuncionalidade <em>Funcionalidade</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Funcionalidade</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getFuncionalidade()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Funcionalidade();

  /**
   * Returns the meta object for the containment reference list '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getUsuarioMetaRazao <em>Usuario Meta Razao</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Usuario Meta Razao</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getUsuarioMetaRazao()
   * @see #getModel()
   * @generated
   */
  EReference getModel_UsuarioMetaRazao();

  /**
   * Returns the meta object for the containment reference list '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getCenarios <em>Cenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cenarios</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getCenarios()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Cenarios();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao <em>Usuario Meta Razao</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Usuario Meta Razao</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao
   * @generated
   */
  EClass getUsuarioMetaRazao();

  /**
   * Returns the meta object for the containment reference '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao#getNome_do_ator <em>Nome do ator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nome do ator</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao#getNome_do_ator()
   * @see #getUsuarioMetaRazao()
   * @generated
   */
  EReference getUsuarioMetaRazao_Nome_do_ator();

  /**
   * Returns the meta object for the containment reference '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao#getMeta_a_ser_alcancada <em>Meta aser alcancada</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Meta aser alcancada</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao#getMeta_a_ser_alcancada()
   * @see #getUsuarioMetaRazao()
   * @generated
   */
  EReference getUsuarioMetaRazao_Meta_a_ser_alcancada();

  /**
   * Returns the meta object for the containment reference '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao#getRazao_para_alcancar_meta <em>Razao para alcancar meta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Razao para alcancar meta</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao#getRazao_para_alcancar_meta()
   * @see #getUsuarioMetaRazao()
   * @generated
   */
  EReference getUsuarioMetaRazao_Razao_para_alcancar_meta();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade <em>Funcionalidade</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Funcionalidade</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade
   * @generated
   */
  EClass getFuncionalidade();

  /**
   * Returns the meta object for the attribute '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade#getNome_funcionadade <em>Nome funcionadade</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Nome funcionadade</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade#getNome_funcionadade()
   * @see #getFuncionalidade()
   * @generated
   */
  EAttribute getFuncionalidade_Nome_funcionadade();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario <em>Cenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cenario</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario
   * @generated
   */
  EClass getCenario();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario <em>Identificador Cenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identificador Cenario</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario
   * @generated
   */
  EClass getIdentificadorCenario();

  /**
   * Returns the meta object for the attribute list '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getXer <em>Xer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Xer</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getXer()
   * @see #getIdentificadorCenario()
   * @generated
   */
  EAttribute getIdentificadorCenario_Xer();

  /**
   * Returns the meta object for the containment reference list '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getSentencas_qualite <em>Sentencas qualite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sentencas qualite</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getSentencas_qualite()
   * @see #getIdentificadorCenario()
   * @generated
   */
  EReference getIdentificadorCenario_Sentencas_qualite();

  /**
   * Returns the meta object for the attribute '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getName()
   * @see #getIdentificadorCenario()
   * @generated
   */
  EAttribute getIdentificadorCenario_Name();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite <em>Sentenca Qualite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sentenca Qualite</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite
   * @generated
   */
  EClass getSentencaQualite();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta <em>Meta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meta</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta
   * @generated
   */
  EClass getMeta();

  /**
   * Returns the meta object for the attribute '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getX()
   * @see #getMeta()
   * @generated
   */
  EAttribute getMeta_X();

  /**
   * Returns the meta object for the attribute list '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getLista_metas <em>Lista metas</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Lista metas</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getLista_metas()
   * @see #getMeta()
   * @generated
   */
  EAttribute getMeta_Lista_metas();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario <em>Executar Cenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Executar Cenario</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario
   * @generated
   */
  EClass getExecutarCenario();

  /**
   * Returns the meta object for the reference '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario#getCenario_executar_ref <em>Cenario executar ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Cenario executar ref</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario#getCenario_executar_ref()
   * @see #getExecutarCenario()
   * @generated
   */
  EReference getExecutarCenario_Cenario_executar_ref();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens <em>Lista Itens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lista Itens</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens
   * @generated
   */
  EClass getListaItens();

  /**
   * Returns the meta object for the attribute list '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens#getItem <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Item</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens#getItem()
   * @see #getListaItens()
   * @generated
   */
  EAttribute getListaItens_Item();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR <em>NOME DO ATOR</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>NOME DO ATOR</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR
   * @generated
   */
  EClass getNOME_DO_ATOR();

  /**
   * Returns the meta object for the attribute '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR#getNome_do_ator <em>Nome do ator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Nome do ator</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR#getNome_do_ator()
   * @see #getNOME_DO_ATOR()
   * @generated
   */
  EAttribute getNOME_DO_ATOR_Nome_do_ator();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA <em>META ASER ALCANCADA</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>META ASER ALCANCADA</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA
   * @generated
   */
  EClass getMETA_A_SER_ALCANCADA();

  /**
   * Returns the meta object for the attribute '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA#getMeta_a_ser_alcancada <em>Meta aser alcancada</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Meta aser alcancada</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA#getMeta_a_ser_alcancada()
   * @see #getMETA_A_SER_ALCANCADA()
   * @generated
   */
  EAttribute getMETA_A_SER_ALCANCADA_Meta_a_ser_alcancada();

  /**
   * Returns the meta object for class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META <em>RAZAO PARA ALCANCAR AMETA</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RAZAO PARA ALCANCAR AMETA</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META
   * @generated
   */
  EClass getRAZAO_PARA_ALCANCAR_A_META();

  /**
   * Returns the meta object for the attribute '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META#getRazao_para_alcancar_a_meta <em>Razao para alcancar ameta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Razao para alcancar ameta</em>'.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META#getRazao_para_alcancar_a_meta()
   * @see #getRAZAO_PARA_ALCANCAR_A_META()
   * @generated
   */
  EAttribute getRAZAO_PARA_ALCANCAR_A_META_Razao_para_alcancar_a_meta();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StoryDslFactory getStoryDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Funcionalidade</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FUNCIONALIDADE = eINSTANCE.getModel_Funcionalidade();

    /**
     * The meta object literal for the '<em><b>Usuario Meta Razao</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__USUARIO_META_RAZAO = eINSTANCE.getModel_UsuarioMetaRazao();

    /**
     * The meta object literal for the '<em><b>Cenarios</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CENARIOS = eINSTANCE.getModel_Cenarios();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl <em>Usuario Meta Razao</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getUsuarioMetaRazao()
     * @generated
     */
    EClass USUARIO_META_RAZAO = eINSTANCE.getUsuarioMetaRazao();

    /**
     * The meta object literal for the '<em><b>Nome do ator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USUARIO_META_RAZAO__NOME_DO_ATOR = eINSTANCE.getUsuarioMetaRazao_Nome_do_ator();

    /**
     * The meta object literal for the '<em><b>Meta aser alcancada</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USUARIO_META_RAZAO__META_ASER_ALCANCADA = eINSTANCE.getUsuarioMetaRazao_Meta_a_ser_alcancada();

    /**
     * The meta object literal for the '<em><b>Razao para alcancar meta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META = eINSTANCE.getUsuarioMetaRazao_Razao_para_alcancar_meta();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.FuncionalidadeImpl <em>Funcionalidade</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.FuncionalidadeImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getFuncionalidade()
     * @generated
     */
    EClass FUNCIONALIDADE = eINSTANCE.getFuncionalidade();

    /**
     * The meta object literal for the '<em><b>Nome funcionadade</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCIONALIDADE__NOME_FUNCIONADADE = eINSTANCE.getFuncionalidade_Nome_funcionadade();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.CenarioImpl <em>Cenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.CenarioImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getCenario()
     * @generated
     */
    EClass CENARIO = eINSTANCE.getCenario();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl <em>Identificador Cenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getIdentificadorCenario()
     * @generated
     */
    EClass IDENTIFICADOR_CENARIO = eINSTANCE.getIdentificadorCenario();

    /**
     * The meta object literal for the '<em><b>Xer</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFICADOR_CENARIO__XER = eINSTANCE.getIdentificadorCenario_Xer();

    /**
     * The meta object literal for the '<em><b>Sentencas qualite</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE = eINSTANCE.getIdentificadorCenario_Sentencas_qualite();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFICADOR_CENARIO__NAME = eINSTANCE.getIdentificadorCenario_Name();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.SentencaQualiteImpl <em>Sentenca Qualite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.SentencaQualiteImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getSentencaQualite()
     * @generated
     */
    EClass SENTENCA_QUALITE = eINSTANCE.getSentencaQualite();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.MetaImpl <em>Meta</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.MetaImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getMeta()
     * @generated
     */
    EClass META = eINSTANCE.getMeta();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META__X = eINSTANCE.getMeta_X();

    /**
     * The meta object literal for the '<em><b>Lista metas</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META__LISTA_METAS = eINSTANCE.getMeta_Lista_metas();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ExecutarCenarioImpl <em>Executar Cenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ExecutarCenarioImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getExecutarCenario()
     * @generated
     */
    EClass EXECUTAR_CENARIO = eINSTANCE.getExecutarCenario();

    /**
     * The meta object literal for the '<em><b>Cenario executar ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF = eINSTANCE.getExecutarCenario_Cenario_executar_ref();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ListaItensImpl <em>Lista Itens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ListaItensImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getListaItens()
     * @generated
     */
    EClass LISTA_ITENS = eINSTANCE.getListaItens();

    /**
     * The meta object literal for the '<em><b>Item</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LISTA_ITENS__ITEM = eINSTANCE.getListaItens_Item();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.NOME_DO_ATORImpl <em>NOME DO ATOR</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.NOME_DO_ATORImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getNOME_DO_ATOR()
     * @generated
     */
    EClass NOME_DO_ATOR = eINSTANCE.getNOME_DO_ATOR();

    /**
     * The meta object literal for the '<em><b>Nome do ator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NOME_DO_ATOR__NOME_DO_ATOR = eINSTANCE.getNOME_DO_ATOR_Nome_do_ator();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.META_A_SER_ALCANCADAImpl <em>META ASER ALCANCADA</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.META_A_SER_ALCANCADAImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getMETA_A_SER_ALCANCADA()
     * @generated
     */
    EClass META_ASER_ALCANCADA = eINSTANCE.getMETA_A_SER_ALCANCADA();

    /**
     * The meta object literal for the '<em><b>Meta aser alcancada</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META_ASER_ALCANCADA__META_ASER_ALCANCADA = eINSTANCE.getMETA_A_SER_ALCANCADA_Meta_a_ser_alcancada();

    /**
     * The meta object literal for the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.RAZAO_PARA_ALCANCAR_A_METAImpl <em>RAZAO PARA ALCANCAR AMETA</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.RAZAO_PARA_ALCANCAR_A_METAImpl
     * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslPackageImpl#getRAZAO_PARA_ALCANCAR_A_META()
     * @generated
     */
    EClass RAZAO_PARA_ALCANCAR_AMETA = eINSTANCE.getRAZAO_PARA_ALCANCAR_A_META();

    /**
     * The meta object literal for the '<em><b>Razao para alcancar ameta</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA = eINSTANCE.getRAZAO_PARA_ALCANCAR_A_META_Razao_para_alcancar_a_meta();

  }

} //StoryDslPackage
