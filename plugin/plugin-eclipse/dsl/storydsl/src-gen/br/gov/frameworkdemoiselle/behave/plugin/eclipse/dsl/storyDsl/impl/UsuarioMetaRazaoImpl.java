/**
 */
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.META_A_SER_ALCANCADA;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.NOME_DO_ATOR;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.RAZAO_PARA_ALCANCAR_A_META;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.StoryDslPackage;
import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.UsuarioMetaRazao;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usuario Meta Razao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl#getNome_do_ator <em>Nome do ator</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl#getMeta_a_ser_alcancada <em>Meta aser alcancada</em>}</li>
 *   <li>{@link br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.impl.UsuarioMetaRazaoImpl#getRazao_para_alcancar_meta <em>Razao para alcancar meta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsuarioMetaRazaoImpl extends MinimalEObjectImpl.Container implements UsuarioMetaRazao
{
  /**
   * The cached value of the '{@link #getNome_do_ator() <em>Nome do ator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNome_do_ator()
   * @generated
   * @ordered
   */
  protected NOME_DO_ATOR nome_do_ator;

  /**
   * The cached value of the '{@link #getMeta_a_ser_alcancada() <em>Meta aser alcancada</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeta_a_ser_alcancada()
   * @generated
   * @ordered
   */
  protected META_A_SER_ALCANCADA meta_a_ser_alcancada;

  /**
   * The cached value of the '{@link #getRazao_para_alcancar_meta() <em>Razao para alcancar meta</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRazao_para_alcancar_meta()
   * @generated
   * @ordered
   */
  protected RAZAO_PARA_ALCANCAR_A_META razao_para_alcancar_meta;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UsuarioMetaRazaoImpl()
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
    return StoryDslPackage.Literals.USUARIO_META_RAZAO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NOME_DO_ATOR getNome_do_ator()
  {
    return nome_do_ator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNome_do_ator(NOME_DO_ATOR newNome_do_ator, NotificationChain msgs)
  {
    NOME_DO_ATOR oldNome_do_ator = nome_do_ator;
    nome_do_ator = newNome_do_ator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR, oldNome_do_ator, newNome_do_ator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNome_do_ator(NOME_DO_ATOR newNome_do_ator)
  {
    if (newNome_do_ator != nome_do_ator)
    {
      NotificationChain msgs = null;
      if (nome_do_ator != null)
        msgs = ((InternalEObject)nome_do_ator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR, null, msgs);
      if (newNome_do_ator != null)
        msgs = ((InternalEObject)newNome_do_ator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR, null, msgs);
      msgs = basicSetNome_do_ator(newNome_do_ator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR, newNome_do_ator, newNome_do_ator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public META_A_SER_ALCANCADA getMeta_a_ser_alcancada()
  {
    return meta_a_ser_alcancada;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMeta_a_ser_alcancada(META_A_SER_ALCANCADA newMeta_a_ser_alcancada, NotificationChain msgs)
  {
    META_A_SER_ALCANCADA oldMeta_a_ser_alcancada = meta_a_ser_alcancada;
    meta_a_ser_alcancada = newMeta_a_ser_alcancada;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA, oldMeta_a_ser_alcancada, newMeta_a_ser_alcancada);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMeta_a_ser_alcancada(META_A_SER_ALCANCADA newMeta_a_ser_alcancada)
  {
    if (newMeta_a_ser_alcancada != meta_a_ser_alcancada)
    {
      NotificationChain msgs = null;
      if (meta_a_ser_alcancada != null)
        msgs = ((InternalEObject)meta_a_ser_alcancada).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA, null, msgs);
      if (newMeta_a_ser_alcancada != null)
        msgs = ((InternalEObject)newMeta_a_ser_alcancada).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA, null, msgs);
      msgs = basicSetMeta_a_ser_alcancada(newMeta_a_ser_alcancada, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA, newMeta_a_ser_alcancada, newMeta_a_ser_alcancada));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RAZAO_PARA_ALCANCAR_A_META getRazao_para_alcancar_meta()
  {
    return razao_para_alcancar_meta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRazao_para_alcancar_meta(RAZAO_PARA_ALCANCAR_A_META newRazao_para_alcancar_meta, NotificationChain msgs)
  {
    RAZAO_PARA_ALCANCAR_A_META oldRazao_para_alcancar_meta = razao_para_alcancar_meta;
    razao_para_alcancar_meta = newRazao_para_alcancar_meta;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META, oldRazao_para_alcancar_meta, newRazao_para_alcancar_meta);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRazao_para_alcancar_meta(RAZAO_PARA_ALCANCAR_A_META newRazao_para_alcancar_meta)
  {
    if (newRazao_para_alcancar_meta != razao_para_alcancar_meta)
    {
      NotificationChain msgs = null;
      if (razao_para_alcancar_meta != null)
        msgs = ((InternalEObject)razao_para_alcancar_meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META, null, msgs);
      if (newRazao_para_alcancar_meta != null)
        msgs = ((InternalEObject)newRazao_para_alcancar_meta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META, null, msgs);
      msgs = basicSetRazao_para_alcancar_meta(newRazao_para_alcancar_meta, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META, newRazao_para_alcancar_meta, newRazao_para_alcancar_meta));
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
      case StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR:
        return basicSetNome_do_ator(null, msgs);
      case StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA:
        return basicSetMeta_a_ser_alcancada(null, msgs);
      case StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META:
        return basicSetRazao_para_alcancar_meta(null, msgs);
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
      case StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR:
        return getNome_do_ator();
      case StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA:
        return getMeta_a_ser_alcancada();
      case StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META:
        return getRazao_para_alcancar_meta();
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
      case StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR:
        setNome_do_ator((NOME_DO_ATOR)newValue);
        return;
      case StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA:
        setMeta_a_ser_alcancada((META_A_SER_ALCANCADA)newValue);
        return;
      case StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META:
        setRazao_para_alcancar_meta((RAZAO_PARA_ALCANCAR_A_META)newValue);
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
      case StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR:
        setNome_do_ator((NOME_DO_ATOR)null);
        return;
      case StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA:
        setMeta_a_ser_alcancada((META_A_SER_ALCANCADA)null);
        return;
      case StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META:
        setRazao_para_alcancar_meta((RAZAO_PARA_ALCANCAR_A_META)null);
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
      case StoryDslPackage.USUARIO_META_RAZAO__NOME_DO_ATOR:
        return nome_do_ator != null;
      case StoryDslPackage.USUARIO_META_RAZAO__META_ASER_ALCANCADA:
        return meta_a_ser_alcancada != null;
      case StoryDslPackage.USUARIO_META_RAZAO__RAZAO_PARA_ALCANCAR_META:
        return razao_para_alcancar_meta != null;
    }
    return super.eIsSet(featureID);
  }

} //UsuarioMetaRazaoImpl
