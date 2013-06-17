/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Cenario;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Funcionalidade;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.Model;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl#getFuncionalidade <em>Funcionalidade</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl#getUsuarioMetaRazao <em>Usuario Meta Razao</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.ModelImpl#getCenarios <em>Cenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getFuncionalidade() <em>Funcionalidade</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFuncionalidade()
   * @generated
   * @ordered
   */
  protected Funcionalidade funcionalidade;

  /**
   * The cached value of the '{@link #getUsuarioMetaRazao() <em>Usuario Meta Razao</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsuarioMetaRazao()
   * @generated
   * @ordered
   */
  protected EList<UsuarioMetaRazao> usuarioMetaRazao;

  /**
   * The cached value of the '{@link #getCenarios() <em>Cenarios</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCenarios()
   * @generated
   * @ordered
   */
  protected EList<Cenario> cenarios;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return StoryDslPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Funcionalidade getFuncionalidade()
  {
    return funcionalidade;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFuncionalidade(Funcionalidade newFuncionalidade, NotificationChain msgs)
  {
    Funcionalidade oldFuncionalidade = funcionalidade;
    funcionalidade = newFuncionalidade;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoryDslPackage.MODEL__FUNCIONALIDADE, oldFuncionalidade, newFuncionalidade);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFuncionalidade(Funcionalidade newFuncionalidade)
  {
    if (newFuncionalidade != funcionalidade)
    {
      NotificationChain msgs = null;
      if (funcionalidade != null)
        msgs = ((InternalEObject)funcionalidade).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.MODEL__FUNCIONALIDADE, null, msgs);
      if (newFuncionalidade != null)
        msgs = ((InternalEObject)newFuncionalidade).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.MODEL__FUNCIONALIDADE, null, msgs);
      msgs = basicSetFuncionalidade(newFuncionalidade, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.MODEL__FUNCIONALIDADE, newFuncionalidade, newFuncionalidade));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UsuarioMetaRazao> getUsuarioMetaRazao()
  {
    if (usuarioMetaRazao == null)
    {
      usuarioMetaRazao = new EObjectContainmentEList<UsuarioMetaRazao>(UsuarioMetaRazao.class, this, StoryDslPackage.MODEL__USUARIO_META_RAZAO);
    }
    return usuarioMetaRazao;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Cenario> getCenarios()
  {
    if (cenarios == null)
    {
      cenarios = new EObjectContainmentEList<Cenario>(Cenario.class, this, StoryDslPackage.MODEL__CENARIOS);
    }
    return cenarios;
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
      case StoryDslPackage.MODEL__FUNCIONALIDADE:
        return basicSetFuncionalidade(null, msgs);
      case StoryDslPackage.MODEL__USUARIO_META_RAZAO:
        return ((InternalEList<?>)getUsuarioMetaRazao()).basicRemove(otherEnd, msgs);
      case StoryDslPackage.MODEL__CENARIOS:
        return ((InternalEList<?>)getCenarios()).basicRemove(otherEnd, msgs);
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
      case StoryDslPackage.MODEL__FUNCIONALIDADE:
        return getFuncionalidade();
      case StoryDslPackage.MODEL__USUARIO_META_RAZAO:
        return getUsuarioMetaRazao();
      case StoryDslPackage.MODEL__CENARIOS:
        return getCenarios();
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
      case StoryDslPackage.MODEL__FUNCIONALIDADE:
        setFuncionalidade((Funcionalidade)newValue);
        return;
      case StoryDslPackage.MODEL__USUARIO_META_RAZAO:
        getUsuarioMetaRazao().clear();
        getUsuarioMetaRazao().addAll((Collection<? extends UsuarioMetaRazao>)newValue);
        return;
      case StoryDslPackage.MODEL__CENARIOS:
        getCenarios().clear();
        getCenarios().addAll((Collection<? extends Cenario>)newValue);
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
      case StoryDslPackage.MODEL__FUNCIONALIDADE:
        setFuncionalidade((Funcionalidade)null);
        return;
      case StoryDslPackage.MODEL__USUARIO_META_RAZAO:
        getUsuarioMetaRazao().clear();
        return;
      case StoryDslPackage.MODEL__CENARIOS:
        getCenarios().clear();
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
      case StoryDslPackage.MODEL__FUNCIONALIDADE:
        return funcionalidade != null;
      case StoryDslPackage.MODEL__USUARIO_META_RAZAO:
        return usuarioMetaRazao != null && !usuarioMetaRazao.isEmpty();
      case StoryDslPackage.MODEL__CENARIOS:
        return cenarios != null && !cenarios.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
