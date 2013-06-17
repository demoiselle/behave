/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NOME DO ATOR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.NOME_DO_ATORImpl#getNome_do_ator <em>Nome do ator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NOME_DO_ATORImpl extends MinimalEObjectImpl.Container implements NOME_DO_ATOR
{
  /**
   * The default value of the '{@link #getNome_do_ator() <em>Nome do ator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNome_do_ator()
   * @generated
   * @ordered
   */
  protected static final String NOME_DO_ATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNome_do_ator() <em>Nome do ator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNome_do_ator()
   * @generated
   * @ordered
   */
  protected String nome_do_ator = NOME_DO_ATOR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NOME_DO_ATORImpl()
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
    return StoryDslPackage.Literals.NOME_DO_ATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNome_do_ator()
  {
    return nome_do_ator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNome_do_ator(String newNome_do_ator)
  {
    String oldNome_do_ator = nome_do_ator;
    nome_do_ator = newNome_do_ator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.NOME_DO_ATOR__NOME_DO_ATOR, oldNome_do_ator, nome_do_ator));
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
      case StoryDslPackage.NOME_DO_ATOR__NOME_DO_ATOR:
        return getNome_do_ator();
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
      case StoryDslPackage.NOME_DO_ATOR__NOME_DO_ATOR:
        setNome_do_ator((String)newValue);
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
      case StoryDslPackage.NOME_DO_ATOR__NOME_DO_ATOR:
        setNome_do_ator(NOME_DO_ATOR_EDEFAULT);
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
      case StoryDslPackage.NOME_DO_ATOR__NOME_DO_ATOR:
        return NOME_DO_ATOR_EDEFAULT == null ? nome_do_ator != null : !NOME_DO_ATOR_EDEFAULT.equals(nome_do_ator);
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
    result.append(" (nome_do_ator: ");
    result.append(nome_do_ator);
    result.append(')');
    return result.toString();
  }

} //NOME_DO_ATORImpl
