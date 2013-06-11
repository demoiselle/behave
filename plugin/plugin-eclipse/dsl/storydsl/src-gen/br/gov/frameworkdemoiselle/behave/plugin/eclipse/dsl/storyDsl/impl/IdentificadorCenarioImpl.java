/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.SentencaQualite;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identificador Cenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl#getXer <em>Xer</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl#getSentencas_qualite <em>Sentencas qualite</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.IdentificadorCenarioImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentificadorCenarioImpl extends CenarioImpl implements IdentificadorCenario
{
  /**
   * The cached value of the '{@link #getXer() <em>Xer</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXer()
   * @generated
   * @ordered
   */
  protected EList<String> xer;

  /**
   * The cached value of the '{@link #getSentencas_qualite() <em>Sentencas qualite</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSentencas_qualite()
   * @generated
   * @ordered
   */
  protected EList<SentencaQualite> sentencas_qualite;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IdentificadorCenarioImpl()
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
    return StoryDslPackage.Literals.IDENTIFICADOR_CENARIO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getXer()
  {
    if (xer == null)
    {
      xer = new EDataTypeEList<String>(String.class, this, StoryDslPackage.IDENTIFICADOR_CENARIO__XER);
    }
    return xer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SentencaQualite> getSentencas_qualite()
  {
    if (sentencas_qualite == null)
    {
      sentencas_qualite = new EObjectContainmentEList<SentencaQualite>(SentencaQualite.class, this, StoryDslPackage.IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE);
    }
    return sentencas_qualite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.IDENTIFICADOR_CENARIO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StoryDslPackage.IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE:
        return ((InternalEList<?>)getSentencas_qualite()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case StoryDslPackage.IDENTIFICADOR_CENARIO__XER:
        return getXer();
      case StoryDslPackage.IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE:
        return getSentencas_qualite();
      case StoryDslPackage.IDENTIFICADOR_CENARIO__NAME:
        return getName();
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
      case StoryDslPackage.IDENTIFICADOR_CENARIO__XER:
        getXer().clear();
        getXer().addAll((Collection<? extends String>)newValue);
        return;
      case StoryDslPackage.IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE:
        getSentencas_qualite().clear();
        getSentencas_qualite().addAll((Collection<? extends SentencaQualite>)newValue);
        return;
      case StoryDslPackage.IDENTIFICADOR_CENARIO__NAME:
        setName((String)newValue);
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
      case StoryDslPackage.IDENTIFICADOR_CENARIO__XER:
        getXer().clear();
        return;
      case StoryDslPackage.IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE:
        getSentencas_qualite().clear();
        return;
      case StoryDslPackage.IDENTIFICADOR_CENARIO__NAME:
        setName(NAME_EDEFAULT);
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
      case StoryDslPackage.IDENTIFICADOR_CENARIO__XER:
        return xer != null && !xer.isEmpty();
      case StoryDslPackage.IDENTIFICADOR_CENARIO__SENTENCAS_QUALITE:
        return sentencas_qualite != null && !sentencas_qualite.isEmpty();
      case StoryDslPackage.IDENTIFICADOR_CENARIO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (xer: ");
    result.append(xer);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //IdentificadorCenarioImpl
