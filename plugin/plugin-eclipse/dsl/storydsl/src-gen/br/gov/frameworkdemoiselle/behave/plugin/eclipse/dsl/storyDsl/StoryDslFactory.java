/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage
 * @generated
 */
public interface StoryDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StoryDslFactory eINSTANCE = br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.StoryDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Usuario Meta Razao</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Usuario Meta Razao</em>'.
   * @generated
   */
  UsuarioMetaRazao createUsuarioMetaRazao();

  /**
   * Returns a new object of class '<em>Funcionalidade</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Funcionalidade</em>'.
   * @generated
   */
  Funcionalidade createFuncionalidade();

  /**
   * Returns a new object of class '<em>Cenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cenario</em>'.
   * @generated
   */
  Cenario createCenario();

  /**
   * Returns a new object of class '<em>Identificador Cenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identificador Cenario</em>'.
   * @generated
   */
  IdentificadorCenario createIdentificadorCenario();

  /**
   * Returns a new object of class '<em>Sentenca Qualite</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sentenca Qualite</em>'.
   * @generated
   */
  SentencaQualite createSentencaQualite();

  /**
   * Returns a new object of class '<em>Meta</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta</em>'.
   * @generated
   */
  Meta createMeta();

  /**
   * Returns a new object of class '<em>Executar Cenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Executar Cenario</em>'.
   * @generated
   */
  ExecutarCenario createExecutarCenario();

  /**
   * Returns a new object of class '<em>Lista Itens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lista Itens</em>'.
   * @generated
   */
  ListaItens createListaItens();

  /**
   * Returns a new object of class '<em>NOME DO ATOR</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>NOME DO ATOR</em>'.
   * @generated
   */
  NOME_DO_ATOR createNOME_DO_ATOR();

  /**
   * Returns a new object of class '<em>META ASER ALCANCADA</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>META ASER ALCANCADA</em>'.
   * @generated
   */
  META_A_SER_ALCANCADA createMETA_A_SER_ALCANCADA();

  /**
   * Returns a new object of class '<em>RAZAO PARA ALCANCAR AMETA</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RAZAO PARA ALCANCAR AMETA</em>'.
   * @generated
   */
  RAZAO_PARA_ALCANCAR_A_META createRAZAO_PARA_ALCANCAR_A_META();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  StoryDslPackage getStoryDslPackage();

} //StoryDslFactory
