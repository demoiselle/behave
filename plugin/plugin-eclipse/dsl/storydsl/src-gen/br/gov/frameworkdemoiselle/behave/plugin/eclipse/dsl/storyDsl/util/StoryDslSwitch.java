/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.util;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage
 * @generated
 */
public class StoryDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static StoryDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoryDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = StoryDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case StoryDslPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.USUARIO_META_RAZAO:
      {
        UsuarioMetaRazao usuarioMetaRazao = (UsuarioMetaRazao)theEObject;
        T result = caseUsuarioMetaRazao(usuarioMetaRazao);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.FUNCIONALIDADE:
      {
        Funcionalidade funcionalidade = (Funcionalidade)theEObject;
        T result = caseFuncionalidade(funcionalidade);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.CENARIO:
      {
        Cenario cenario = (Cenario)theEObject;
        T result = caseCenario(cenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.IDENTIFICADOR_CENARIO:
      {
        IdentificadorCenario identificadorCenario = (IdentificadorCenario)theEObject;
        T result = caseIdentificadorCenario(identificadorCenario);
        if (result == null) result = caseCenario(identificadorCenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.SENTENCA_QUALITE:
      {
        SentencaQualite sentencaQualite = (SentencaQualite)theEObject;
        T result = caseSentencaQualite(sentencaQualite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.META:
      {
        Meta meta = (Meta)theEObject;
        T result = caseMeta(meta);
        if (result == null) result = caseSentencaQualite(meta);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.EXECUTAR_CENARIO:
      {
        ExecutarCenario executarCenario = (ExecutarCenario)theEObject;
        T result = caseExecutarCenario(executarCenario);
        if (result == null) result = caseSentencaQualite(executarCenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.LISTA_ITENS:
      {
        ListaItens listaItens = (ListaItens)theEObject;
        T result = caseListaItens(listaItens);
        if (result == null) result = caseSentencaQualite(listaItens);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.NOME_DO_ATOR:
      {
        NOME_DO_ATOR nomE_DO_ATOR = (NOME_DO_ATOR)theEObject;
        T result = caseNOME_DO_ATOR(nomE_DO_ATOR);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.META_ASER_ALCANCADA:
      {
        META_A_SER_ALCANCADA metA_A_SER_ALCANCADA = (META_A_SER_ALCANCADA)theEObject;
        T result = caseMETA_A_SER_ALCANCADA(metA_A_SER_ALCANCADA);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA:
      {
        RAZAO_PARA_ALCANCAR_A_META razaO_PARA_ALCANCAR_A_META = (RAZAO_PARA_ALCANCAR_A_META)theEObject;
        T result = caseRAZAO_PARA_ALCANCAR_A_META(razaO_PARA_ALCANCAR_A_META);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Usuario Meta Razao</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Usuario Meta Razao</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUsuarioMetaRazao(UsuarioMetaRazao object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Funcionalidade</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Funcionalidade</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFuncionalidade(Funcionalidade object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCenario(Cenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identificador Cenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identificador Cenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentificadorCenario(IdentificadorCenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sentenca Qualite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sentenca Qualite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSentencaQualite(SentencaQualite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Meta</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMeta(Meta object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Executar Cenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Executar Cenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutarCenario(ExecutarCenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lista Itens</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lista Itens</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListaItens(ListaItens object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>NOME DO ATOR</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NOME DO ATOR</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNOME_DO_ATOR(NOME_DO_ATOR object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>META ASER ALCANCADA</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>META ASER ALCANCADA</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMETA_A_SER_ALCANCADA(META_A_SER_ALCANCADA object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RAZAO PARA ALCANCAR AMETA</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RAZAO PARA ALCANCAR AMETA</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRAZAO_PARA_ALCANCAR_A_META(RAZAO_PARA_ALCANCAR_A_META object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //StoryDslSwitch
