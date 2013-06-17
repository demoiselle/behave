/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getFuncionalidade <em>Funcionalidade</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getUsuarioMetaRazao <em>Usuario Meta Razao</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getCenarios <em>Cenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Funcionalidade</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Funcionalidade</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Funcionalidade</em>' containment reference.
   * @see #setFuncionalidade(Funcionalidade)
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getModel_Funcionalidade()
   * @model containment="true"
   * @generated
   */
  Funcionalidade getFuncionalidade();

  /**
   * Sets the value of the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model#getFuncionalidade <em>Funcionalidade</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Funcionalidade</em>' containment reference.
   * @see #getFuncionalidade()
   * @generated
   */
  void setFuncionalidade(Funcionalidade value);

  /**
   * Returns the value of the '<em><b>Usuario Meta Razao</b></em>' containment reference list.
   * The list contents are of type {@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Usuario Meta Razao</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Usuario Meta Razao</em>' containment reference list.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getModel_UsuarioMetaRazao()
   * @model containment="true"
   * @generated
   */
  EList<UsuarioMetaRazao> getUsuarioMetaRazao();

  /**
   * Returns the value of the '<em><b>Cenarios</b></em>' containment reference list.
   * The list contents are of type {@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cenarios</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cenarios</em>' containment reference list.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getModel_Cenarios()
   * @model containment="true"
   * @generated
   */
  EList<Cenario> getCenarios();

} // Model
