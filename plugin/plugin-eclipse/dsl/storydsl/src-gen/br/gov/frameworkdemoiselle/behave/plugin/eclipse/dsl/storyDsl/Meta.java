/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getX <em>X</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getLista_metas <em>Lista metas</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getMeta()
 * @model
 * @generated
 */
public interface Meta extends SentencaQualite
{
  /**
   * Returns the value of the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>X</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' attribute.
   * @see #setX(String)
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getMeta_X()
   * @model
   * @generated
   */
  String getX();

  /**
   * Sets the value of the '{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' attribute.
   * @see #getX()
   * @generated
   */
  void setX(String value);

  /**
   * Returns the value of the '<em><b>Lista metas</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lista metas</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lista metas</em>' attribute list.
   * @see br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage#getMeta_Lista_metas()
   * @model unique="false"
   * @generated
   */
  EList<String> getLista_metas();

} // Meta
