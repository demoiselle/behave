/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>META ASER ALCANCADA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.META_A_SER_ALCANCADAImpl#getMeta_a_ser_alcancada <em>Meta aser alcancada</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class META_A_SER_ALCANCADAImpl extends MinimalEObjectImpl.Container implements META_A_SER_ALCANCADA
{
  /**
   * The default value of the '{@link #getMeta_a_ser_alcancada() <em>Meta aser alcancada</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeta_a_ser_alcancada()
   * @generated
   * @ordered
   */
  protected static final String META_ASER_ALCANCADA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMeta_a_ser_alcancada() <em>Meta aser alcancada</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeta_a_ser_alcancada()
   * @generated
   * @ordered
   */
  protected String meta_a_ser_alcancada = META_ASER_ALCANCADA_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected META_A_SER_ALCANCADAImpl()
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
    return StoryDslPackage.Literals.META_ASER_ALCANCADA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMeta_a_ser_alcancada()
  {
    return meta_a_ser_alcancada;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMeta_a_ser_alcancada(String newMeta_a_ser_alcancada)
  {
    String oldMeta_a_ser_alcancada = meta_a_ser_alcancada;
    meta_a_ser_alcancada = newMeta_a_ser_alcancada;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.META_ASER_ALCANCADA__META_ASER_ALCANCADA, oldMeta_a_ser_alcancada, meta_a_ser_alcancada));
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
      case StoryDslPackage.META_ASER_ALCANCADA__META_ASER_ALCANCADA:
        return getMeta_a_ser_alcancada();
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
      case StoryDslPackage.META_ASER_ALCANCADA__META_ASER_ALCANCADA:
        setMeta_a_ser_alcancada((String)newValue);
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
      case StoryDslPackage.META_ASER_ALCANCADA__META_ASER_ALCANCADA:
        setMeta_a_ser_alcancada(META_ASER_ALCANCADA_EDEFAULT);
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
      case StoryDslPackage.META_ASER_ALCANCADA__META_ASER_ALCANCADA:
        return META_ASER_ALCANCADA_EDEFAULT == null ? meta_a_ser_alcancada != null : !META_ASER_ALCANCADA_EDEFAULT.equals(meta_a_ser_alcancada);
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
    result.append(" (meta_a_ser_alcancada: ");
    result.append(meta_a_ser_alcancada);
    result.append(')');
    return result.toString();
  }

} //META_A_SER_ALCANCADAImpl
