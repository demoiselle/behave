/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.util;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage
 * @generated
 */
public class StoryDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static StoryDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoryDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = StoryDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StoryDslSwitch<Adapter> modelSwitch =
    new StoryDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseUsuarioMetaRazao(UsuarioMetaRazao object)
      {
        return createUsuarioMetaRazaoAdapter();
      }
      @Override
      public Adapter caseFuncionalidade(Funcionalidade object)
      {
        return createFuncionalidadeAdapter();
      }
      @Override
      public Adapter caseCenario(Cenario object)
      {
        return createCenarioAdapter();
      }
      @Override
      public Adapter caseIdentificadorCenario(IdentificadorCenario object)
      {
        return createIdentificadorCenarioAdapter();
      }
      @Override
      public Adapter caseSentencaQualite(SentencaQualite object)
      {
        return createSentencaQualiteAdapter();
      }
      @Override
      public Adapter caseMeta(Meta object)
      {
        return createMetaAdapter();
      }
      @Override
      public Adapter caseExecutarCenario(ExecutarCenario object)
      {
        return createExecutarCenarioAdapter();
      }
      @Override
      public Adapter caseListaItens(ListaItens object)
      {
        return createListaItensAdapter();
      }
      @Override
      public Adapter caseNOME_DO_ATOR(NOME_DO_ATOR object)
      {
        return createNOME_DO_ATORAdapter();
      }
      @Override
      public Adapter caseMETA_A_SER_ALCANCADA(META_A_SER_ALCANCADA object)
      {
        return createMETA_A_SER_ALCANCADAAdapter();
      }
      @Override
      public Adapter caseRAZAO_PARA_ALCANCAR_A_META(RAZAO_PARA_ALCANCAR_A_META object)
      {
        return createRAZAO_PARA_ALCANCAR_A_METAAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao <em>Usuario Meta Razao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao
   * @generated
   */
  public Adapter createUsuarioMetaRazaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade <em>Funcionalidade</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade
   * @generated
   */
  public Adapter createFuncionalidadeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario <em>Cenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario
   * @generated
   */
  public Adapter createCenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario <em>Identificador Cenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario
   * @generated
   */
  public Adapter createIdentificadorCenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite <em>Sentenca Qualite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite
   * @generated
   */
  public Adapter createSentencaQualiteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta <em>Meta</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta
   * @generated
   */
  public Adapter createMetaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario <em>Executar Cenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario
   * @generated
   */
  public Adapter createExecutarCenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens <em>Lista Itens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ListaItens
   * @generated
   */
  public Adapter createListaItensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR <em>NOME DO ATOR</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR
   * @generated
   */
  public Adapter createNOME_DO_ATORAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA <em>META ASER ALCANCADA</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA
   * @generated
   */
  public Adapter createMETA_A_SER_ALCANCADAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META <em>RAZAO PARA ALCANCAR AMETA</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META
   * @generated
   */
  public Adapter createRAZAO_PARA_ALCANCAR_A_METAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //StoryDslAdapterFactory
