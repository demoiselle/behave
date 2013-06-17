/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RAZAO PARA ALCANCAR AMETA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.RAZAO_PARA_ALCANCAR_A_METAImpl#getRazao_para_alcancar_a_meta <em>Razao para alcancar ameta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RAZAO_PARA_ALCANCAR_A_METAImpl extends MinimalEObjectImpl.Container implements RAZAO_PARA_ALCANCAR_A_META
{
  /**
   * The default value of the '{@link #getRazao_para_alcancar_a_meta() <em>Razao para alcancar ameta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRazao_para_alcancar_a_meta()
   * @generated
   * @ordered
   */
  protected static final String RAZAO_PARA_ALCANCAR_AMETA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRazao_para_alcancar_a_meta() <em>Razao para alcancar ameta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRazao_para_alcancar_a_meta()
   * @generated
   * @ordered
   */
  protected String razao_para_alcancar_a_meta = RAZAO_PARA_ALCANCAR_AMETA_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RAZAO_PARA_ALCANCAR_A_METAImpl()
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
    return StoryDslPackage.Literals.RAZAO_PARA_ALCANCAR_AMETA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRazao_para_alcancar_a_meta()
  {
    return razao_para_alcancar_a_meta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRazao_para_alcancar_a_meta(String newRazao_para_alcancar_a_meta)
  {
    String oldRazao_para_alcancar_a_meta = razao_para_alcancar_a_meta;
    razao_para_alcancar_a_meta = newRazao_para_alcancar_a_meta;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA, oldRazao_para_alcancar_a_meta, razao_para_alcancar_a_meta));
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
      case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA:
        return getRazao_para_alcancar_a_meta();
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
      case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA:
        setRazao_para_alcancar_a_meta((String)newValue);
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
      case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA:
        setRazao_para_alcancar_a_meta(RAZAO_PARA_ALCANCAR_AMETA_EDEFAULT);
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
      case StoryDslPackage.RAZAO_PARA_ALCANCAR_AMETA__RAZAO_PARA_ALCANCAR_AMETA:
        return RAZAO_PARA_ALCANCAR_AMETA_EDEFAULT == null ? razao_para_alcancar_a_meta != null : !RAZAO_PARA_ALCANCAR_AMETA_EDEFAULT.equals(razao_para_alcancar_a_meta);
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
    result.append(" (razao_para_alcancar_a_meta: ");
    result.append(razao_para_alcancar_a_meta);
    result.append(')');
    return result.toString();
  }

} //RAZAO_PARA_ALCANCAR_A_METAImpl
