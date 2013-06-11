/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Meta;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.MetaImpl#getX <em>X</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.MetaImpl#getLista_metas <em>Lista metas</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaImpl extends SentencaQualiteImpl implements Meta
{
  /**
   * The default value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected static final String X_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected String x = X_EDEFAULT;

  /**
   * The cached value of the '{@link #getLista_metas() <em>Lista metas</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLista_metas()
   * @generated
   * @ordered
   */
  protected EList<String> lista_metas;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MetaImpl()
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
    return StoryDslPackage.Literals.META;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getX()
  {
    return x;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX(String newX)
  {
    String oldX = x;
    x = newX;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.META__X, oldX, x));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getLista_metas()
  {
    if (lista_metas == null)
    {
      lista_metas = new EDataTypeEList<String>(String.class, this, StoryDslPackage.META__LISTA_METAS);
    }
    return lista_metas;
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
      case StoryDslPackage.META__X:
        return getX();
      case StoryDslPackage.META__LISTA_METAS:
        return getLista_metas();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StoryDslPackage.META__X:
        setX((String)newValue);
        return;
      case StoryDslPackage.META__LISTA_METAS:
        getLista_metas().clear();
        getLista_metas().addAll((Collection<? extends String>)newValue);
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
      case StoryDslPackage.META__X:
        setX(X_EDEFAULT);
        return;
      case StoryDslPackage.META__LISTA_METAS:
        getLista_metas().clear();
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
      case StoryDslPackage.META__X:
        return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
      case StoryDslPackage.META__LISTA_METAS:
        return lista_metas != null && !lista_metas.isEmpty();
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
    result.append(" (x: ");
    result.append(x);
    result.append(", lista_metas: ");
    result.append(lista_metas);
    result.append(')');
    return result.toString();
  }

} //MetaImpl
