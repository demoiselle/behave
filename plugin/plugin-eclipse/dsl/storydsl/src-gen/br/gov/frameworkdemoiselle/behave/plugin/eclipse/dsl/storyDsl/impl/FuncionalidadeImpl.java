/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Funcionalidade</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.FuncionalidadeImpl#getNome_funcionadade <em>Nome funcionadade</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FuncionalidadeImpl extends MinimalEObjectImpl.Container implements Funcionalidade
{
  /**
   * The default value of the '{@link #getNome_funcionadade() <em>Nome funcionadade</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNome_funcionadade()
   * @generated
   * @ordered
   */
  protected static final String NOME_FUNCIONADADE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNome_funcionadade() <em>Nome funcionadade</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNome_funcionadade()
   * @generated
   * @ordered
   */
  protected String nome_funcionadade = NOME_FUNCIONADADE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FuncionalidadeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return StoryDslPackage.Literals.FUNCIONALIDADE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNome_funcionadade()
  {
    return nome_funcionadade;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNome_funcionadade(String newNome_funcionadade)
  {
    String oldNome_funcionadade = nome_funcionadade;
    nome_funcionadade = newNome_funcionadade;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.FUNCIONALIDADE__NOME_FUNCIONADADE, oldNome_funcionadade, nome_funcionadade));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case StoryDslPackage.FUNCIONALIDADE__NOME_FUNCIONADADE:
        return getNome_funcionadade();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StoryDslPackage.FUNCIONALIDADE__NOME_FUNCIONADADE:
        setNome_funcionadade((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case StoryDslPackage.FUNCIONALIDADE__NOME_FUNCIONADADE:
        setNome_funcionadade(NOME_FUNCIONADADE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case StoryDslPackage.FUNCIONALIDADE__NOME_FUNCIONADADE:
        return NOME_FUNCIONADADE_EDEFAULT == null ? nome_funcionadade != null : !NOME_FUNCIONADADE_EDEFAULT.equals(nome_funcionadade);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (nome_funcionadade: ");
    result.append(nome_funcionadade);
    result.append(')');
    return result.toString();
  }

} //FuncionalidadeImpl
