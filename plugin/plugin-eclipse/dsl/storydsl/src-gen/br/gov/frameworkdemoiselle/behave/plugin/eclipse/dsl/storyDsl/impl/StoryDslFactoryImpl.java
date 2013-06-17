/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryDslFactoryImpl extends EFactoryImpl implements StoryDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StoryDslFactory init()
  {
    try
    {
      StoryDslFactory theStoryDslFactory = (StoryDslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.gov.br/frameworkdemoiselle/behave/plugin/eclipse/dsl/StoryDsl"); 
      if (theStoryDslFactory != null)
      {
        return theStoryDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new StoryDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoryDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case StoryDslPackage.MODEL: return createModel();
      case StoryDslPackage.USUARIO_META_RAZAO: return createUsuarioMetaRazao();
      case StoryDslPackage.FUNCIONALIDADE: return createFuncionalidade();
      case StoryDslPackage.CENARIO: return createCenario();
      case StoryDslPackage.IDENTIFICADOR_CENARIO: return createIdentificadorCenario();
      case StoryDslPackage.SENTENCA_QUALITE: return createSentencaQualite();
      case StoryDslPackage.META: return createMeta();
      case StoryDslPackage.EXECUTAR_CENARIO: return createExecutarCenario();
      case StoryDslPackage.LISTA_ITENS: return createListaItens();
      case StoryDslPackage.NOME_DO_ATOR: return createNOME_DO_ATOR();
      case StoryDslPackage.META_ASER_ALCANCADA: return createMETA_A_SER_ALCANCADA();
      case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA: return createRAZAO_PARA_ALCANCAR_A_META();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UsuarioMetaRazao createUsuarioMetaRazao()
  {
    UsuarioMetaRazaoImpl usuarioMetaRazao = new UsuarioMetaRazaoImpl();
    return usuarioMetaRazao;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Funcionalidade createFuncionalidade()
  {
    FuncionalidadeImpl funcionalidade = new FuncionalidadeImpl();
    return funcionalidade;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cenario createCenario()
  {
    CenarioImpl cenario = new CenarioImpl();
    return cenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdentificadorCenario createIdentificadorCenario()
  {
    IdentificadorCenarioImpl identificadorCenario = new IdentificadorCenarioImpl();
    return identificadorCenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SentencaQualite createSentencaQualite()
  {
    SentencaQualiteImpl sentencaQualite = new SentencaQualiteImpl();
    return sentencaQualite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Meta createMeta()
  {
    MetaImpl meta = new MetaImpl();
    return meta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutarCenario createExecutarCenario()
  {
    ExecutarCenarioImpl executarCenario = new ExecutarCenarioImpl();
    return executarCenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListaItens createListaItens()
  {
    ListaItensImpl listaItens = new ListaItensImpl();
    return listaItens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NOME_DO_ATOR createNOME_DO_ATOR()
  {
    NOME_DO_ATORImpl nomE_DO_ATOR = new NOME_DO_ATORImpl();
    return nomE_DO_ATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public META_A_SER_ALCANCADA createMETA_A_SER_ALCANCADA()
  {
    META_A_SER_ALCANCADAImpl metA_A_SER_ALCANCADA = new META_A_SER_ALCANCADAImpl();
    return metA_A_SER_ALCANCADA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RAZAO_PARA_ALCANCAR_A_META createRAZAO_PARA_ALCANCAR_A_META()
  {
    RAZAO_PARA_ALCANCAR_A_METAImpl razaO_PARA_ALCANCAR_A_META = new RAZAO_PARA_ALCANCAR_A_METAImpl();
    return razaO_PARA_ALCANCAR_A_META;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoryDslPackage getStoryDslPackage()
  {
    return (StoryDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static StoryDslPackage getPackage()
  {
    return StoryDslPackage.eINSTANCE;
  }

} //StoryDslFactoryImpl
