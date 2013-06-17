/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslFactory;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryDslPackageImpl extends EPackageImpl implements StoryDslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usuarioMetaRazaoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass funcionalidadeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identificadorCenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sentencaQualiteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executarCenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listaItensEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nomE_DO_ATOREClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metA_A_SER_ALCANCADAEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass razaO_PARA_ALCANCAR_A_METAEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private StoryDslPackageImpl()
  {
    super(eNS_URI, StoryDslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link StoryDslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static StoryDslPackage init()
  {
    if (isInited) return (StoryDslPackage)EPackage.Registry.INSTANCE.getEPackage(StoryDslPackage.eNS_URI);

    // Obtain or create and register package
    StoryDslPackageImpl theStoryDslPackage = (StoryDslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StoryDslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StoryDslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theStoryDslPackage.createPackageContents();

    // Initialize created meta-data
    theStoryDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theStoryDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(StoryDslPackage.eNS_URI, theStoryDslPackage);
    return theStoryDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Funcionalidade()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_UsuarioMetaRazao()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Cenarios()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUsuarioMetaRazao()
  {
    return usuarioMetaRazaoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUsuarioMetaRazao_Nome_do_ator()
  {
    return (EReference)usuarioMetaRazaoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUsuarioMetaRazao_Meta_a_ser_alcancada()
  {
    return (EReference)usuarioMetaRazaoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUsuarioMetaRazao_Razao_para_alcancar_meta()
  {
    return (EReference)usuarioMetaRazaoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFuncionalidade()
  {
    return funcionalidadeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFuncionalidade_Nome_funcionadade()
  {
    return (EAttribute)funcionalidadeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCenario()
  {
    return cenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentificadorCenario()
  {
    return identificadorCenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentificadorCenario_Xer()
  {
    return (EAttribute)identificadorCenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIdentificadorCenario_Sentencas_qualite()
  {
    return (EReference)identificadorCenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentificadorCenario_Name()
  {
    return (EAttribute)identificadorCenarioEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSentencaQualite()
  {
    return sentencaQualiteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMeta()
  {
    return metaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMeta_X()
  {
    return (EAttribute)metaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMeta_Lista_metas()
  {
    return (EAttribute)metaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecutarCenario()
  {
    return executarCenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExecutarCenario_Cenario_executar_ref()
  {
    return (EReference)executarCenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListaItens()
  {
    return listaItensEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getListaItens_Item()
  {
    return (EAttribute)listaItensEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNOME_DO_ATOR()
  {
    return nomE_DO_ATOREClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNOME_DO_ATOR_Nome_do_ator()
  {
    return (EAttribute)nomE_DO_ATOREClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMETA_A_SER_ALCANCADA()
  {
    return metA_A_SER_ALCANCADAEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMETA_A_SER_ALCANCADA_Meta_a_ser_alcancada()
  {
    return (EAttribute)metA_A_SER_ALCANCADAEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRAZAO_PARA_ALCANCAR_A_META()
  {
    return razaO_PARA_ALCANCAR_A_METAEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRAZAO_PARA_ALCANCAR_A_META_Razao_para_alcancar_a_meta()
  {
    return (EAttribute)razaO_PARA_ALCANCAR_A_METAEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoryDslFactory getStoryDslFactory()
  {
    return (StoryDslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__FUNCIONALIDADE);
    createEReference(modelEClass, MODEL__USUARIO_META_RAZAO);
    createEReference(modelEClass, MODEL__CENARIOS);

    usuarioMetaRazaoEClass = createEClass(USUARIO_META_RAZAO);
    createEReference(usuarioMetaRazaoEClass, USUARIO_META_RAZAO__NOME_DO_ATOR);
    createEReference(usuarioMetaRazaoEClass, USUARIO_META_RAZAO__META_ASER_ALCANCADA);
    createEReference(usuarioMetaRazaoEClass, USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META);

    funcionalidadeEClass = createEClass(FUNCIONALIDADE);
    createEAttribute(funcionalidadeEClass, FUNCIONALIDADE__NOME_FUNCIONADADE);

    cenarioEClass = createEClass(CENARIO);

    identificadorCenarioEClass = createEClass(IDENTIFICADOR_CENARIO);
    createEAttribute(identificadorCenarioEClass, IDENTIFICADOR_CENARIO__XER);
    createEReference(identificadorCenarioEClass, IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE);
    createEAttribute(identificadorCenarioEClass, IDENTIFICADOR_CENARIO__NAME);

    sentencaQualiteEClass = createEClass(SENTENCA_QUALITE);

    metaEClass = createEClass(META);
    createEAttribute(metaEClass, META__X);
    createEAttribute(metaEClass, META__LISTA_METAS);

    executarCenarioEClass = createEClass(EXECUTAR_CENARIO);
    createEReference(executarCenarioEClass, EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF);

    listaItensEClass = createEClass(LISTA_ITENS);
    createEAttribute(listaItensEClass, LISTA_ITENS__ITEM);

    nomE_DO_ATOREClass = createEClass(NOME_DO_ATOR);
    createEAttribute(nomE_DO_ATOREClass, NOME_DO_ATOR__NOME_DO_ATOR);

    metA_A_SER_ALCANCADAEClass = createEClass(META_ASER_ALCANCADA);
    createEAttribute(metA_A_SER_ALCANCADAEClass, META_ASER_ALCANCADA__META_ASER_ALCANCADA);

    razaO_PARA_ALCANCAR_A_METAEClass = createEClass(RAZAO_PARA_ALCANCAR_AMETA);
    createEAttribute(razaO_PARA_ALCANCAR_A_METAEClass, RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    identificadorCenarioEClass.getESuperTypes().add(this.getCenario());
    metaEClass.getESuperTypes().add(this.getSentencaQualite());
    executarCenarioEClass.getESuperTypes().add(this.getSentencaQualite());
    listaItensEClass.getESuperTypes().add(this.getSentencaQualite());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Funcionalidade(), this.getFuncionalidade(), null, "funcionalidade", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_UsuarioMetaRazao(), this.getUsuarioMetaRazao(), null, "usuarioMetaRazao", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Cenarios(), this.getCenario(), null, "cenarios", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(usuarioMetaRazaoEClass, UsuarioMetaRazao.class, "UsuarioMetaRazao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUsuarioMetaRazao_Nome_do_ator(), this.getNOME_DO_ATOR(), null, "nome_do_ator", null, 0, 1, UsuarioMetaRazao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUsuarioMetaRazao_Meta_a_ser_alcancada(), this.getMETA_A_SER_ALCANCADA(), null, "meta_a_ser_alcancada", null, 0, 1, UsuarioMetaRazao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUsuarioMetaRazao_Razao_para_alcancar_meta(), this.getRAZAO_PARA_ALCANCAR_A_META(), null, "razao_para_alcancar_meta", null, 0, 1, UsuarioMetaRazao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(funcionalidadeEClass, Funcionalidade.class, "Funcionalidade", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFuncionalidade_Nome_funcionadade(), ecorePackage.getEString(), "nome_funcionadade", null, 0, 1, Funcionalidade.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cenarioEClass, Cenario.class, "Cenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(identificadorCenarioEClass, IdentificadorCenario.class, "IdentificadorCenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdentificadorCenario_Xer(), ecorePackage.getEString(), "xer", null, 0, -1, IdentificadorCenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIdentificadorCenario_Sentencas_qualite(), this.getSentencaQualite(), null, "sentencas_qualite", null, 0, -1, IdentificadorCenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIdentificadorCenario_Name(), ecorePackage.getEString(), "name", null, 0, 1, IdentificadorCenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sentencaQualiteEClass, SentencaQualite.class, "SentencaQualite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(metaEClass, Meta.class, "Meta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMeta_X(), ecorePackage.getEString(), "x", null, 0, 1, Meta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMeta_Lista_metas(), ecorePackage.getEString(), "lista_metas", null, 0, -1, Meta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executarCenarioEClass, ExecutarCenario.class, "ExecutarCenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExecutarCenario_Cenario_executar_ref(), this.getCenario(), null, "cenario_executar_ref", null, 0, 1, ExecutarCenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listaItensEClass, ListaItens.class, "ListaItens", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getListaItens_Item(), ecorePackage.getEString(), "item", null, 0, -1, ListaItens.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nomE_DO_ATOREClass, br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR.class, "NOME_DO_ATOR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNOME_DO_ATOR_Nome_do_ator(), ecorePackage.getEString(), "nome_do_ator", null, 0, 1, br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(metA_A_SER_ALCANCADAEClass, META_A_SER_ALCANCADA.class, "META_A_SER_ALCANCADA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMETA_A_SER_ALCANCADA_Meta_a_ser_alcancada(), ecorePackage.getEString(), "meta_a_ser_alcancada", null, 0, 1, META_A_SER_ALCANCADA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(razaO_PARA_ALCANCAR_A_METAEClass, RAZAO_PARA_ALCANCAR_A_META.class, "RAZAO_PARA_ALCANCAR_A_META", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRAZAO_PARA_ALCANCAR_A_META_Razao_para_alcancar_a_meta(), ecorePackage.getEString(), "razao_para_alcancar_a_meta", null, 0, 1, RAZAO_PARA_ALCANCAR_A_META.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //StoryDslPackageImpl
