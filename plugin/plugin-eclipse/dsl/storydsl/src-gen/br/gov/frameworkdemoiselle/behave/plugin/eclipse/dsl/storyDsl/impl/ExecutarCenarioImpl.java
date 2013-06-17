/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.ExecutarCenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executar Cenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ExecutarCenarioImpl#getCenario_executar_ref <em>Cenario executar ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutarCenarioImpl extends SentencaQualiteImpl implements ExecutarCenario
{
  /**
   * The cached value of the '{@link #getCenario_executar_ref() <em>Cenario executar ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCenario_executar_ref()
   * @generated
   * @ordered
   */
  protected Cenario cenario_executar_ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecutarCenarioImpl()
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
    return StoryDslPackage.Literals.EXECUTAR_CENARIO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cenario getCenario_executar_ref()
  {
    if (cenario_executar_ref != null && cenario_executar_ref.eIsProxy())
    {
      InternalEObject oldCenario_executar_ref = (InternalEObject)cenario_executar_ref;
      cenario_executar_ref = (Cenario)eResolveProxy(oldCenario_executar_ref);
      if (cenario_executar_ref != oldCenario_executar_ref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoryDslPackage.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF, oldCenario_executar_ref, cenario_executar_ref));
      }
    }
    return cenario_executar_ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cenario basicGetCenario_executar_ref()
  {
    return cenario_executar_ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCenario_executar_ref(Cenario newCenario_executar_ref)
  {
    Cenario oldCenario_executar_ref = cenario_executar_ref;
    cenario_executar_ref = newCenario_executar_ref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF, oldCenario_executar_ref, cenario_executar_ref));
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
      case StoryDslPackage.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF:
        if (resolve) return getCenario_executar_ref();
        return basicGetCenario_executar_ref();
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
      case StoryDslPackage.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF:
        setCenario_executar_ref((Cenario)newValue);
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
      case StoryDslPackage.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF:
        setCenario_executar_ref((Cenario)null);
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
      case StoryDslPackage.EXECUTAR_CENARIO__CENARIO_EXECUTAR_REF:
        return cenario_executar_ref != null;
    }
    return super.eIsSet(featureID);
  }

} //ExecutarCenarioImpl
