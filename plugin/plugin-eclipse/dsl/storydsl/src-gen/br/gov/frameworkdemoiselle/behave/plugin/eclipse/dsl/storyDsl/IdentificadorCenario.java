/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identificador Cenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getXer <em>Xer</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getSentencas_qualite <em>Sentencas qualite</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getIdentificadorCenario()
 * @model
 * @generated
 */
public interface IdentificadorCenario extends Cenario
{
  /**
   * Returns the value of the '<em><b>Xer</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xer</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xer</em>' attribute list.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getIdentificadorCenario_Xer()
   * @model unique="false"
   * @generated
   */
  EList<String> getXer();

  /**
   * Returns the value of the '<em><b>Sentencas qualite</b></em>' containment reference list.
   * The list contents are of type {@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sentencas qualite</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sentencas qualite</em>' containment reference list.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getIdentificadorCenario_Sentencas_qualite()
   * @model containment="true"
   * @generated
   */
  EList<SentencaQualite> getSentencas_qualite();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getIdentificadorCenario_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // IdentificadorCenario
