package br.gov.serpro.treino.persistence.dao.implementation;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.framework.demoiselle.core.bean.IPojo;
import br.gov.framework.demoiselle.persistence.hibernate.HibernateGenericDAO;
import br.gov.framework.demoiselle.persistence.hibernate.HibernateUtil;
import br.gov.serpro.treino.exception.ErrorMessage;
import br.gov.serpro.treino.exception.TestGridException;

public class TestGridDAO<A extends IPojo> extends HibernateGenericDAO<A> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object insert(A pojo) {
		Object obj = super.insert(pojo);
		getSession().flush();
		return obj;
	}

	@Override
	public void update(A pojo) {
		super.update(pojo);
		getSession().flush();
	}

	public void merge(A pojo) {
		getSession().merge(pojo);
		getSession().flush();
	}

	public void remove(A pojo) {
		super.remove(pojo);
		getSession().flush();
	}

	public Session getSession() {
		return HibernateUtil.getInstance().getSession();
	}

	protected Object findObjectByField(String field, Object value, Class<? extends IPojo> c) {
		Criteria criteria = this.getSession().createCriteria(c);
		criteria.add(Restrictions.eq(field, value));
		Object objt = criteria.uniqueResult();
		return objt;
	}

	@SuppressWarnings("all")
	public Object load(Object obj, Class cl) {
		try {
			if (obj == null) {
				return null;
			}
			Method getid = cl.getMethod("getId", null);
			Long id = (Long) getid.invoke(obj, null);
			if (id == null) {
				return null;
			}
			return getSession().load(cl, id);
		} catch (Throwable e) {
			String[] param = { e.getMessage() };
			throw new TestGridException(ErrorMessage.UNEXPECTED, param);
		}
	}

	@SuppressWarnings("all")
	public Object load(Long id, Class cl) {
		try {
			if (id == null) {
				return null;
			}
			return getSession().load(cl, id);
		} catch (Throwable e) {
			String[] param = { e.getMessage() };
			throw new TestGridException(ErrorMessage.UNEXPECTED, param);
		}
	}

	protected List<A> list(String field, Class<? extends IPojo> c) {
		return filterRemoved(field, false, c);
	}

	@SuppressWarnings("unchecked")
	protected List<A> listAll(String field, Class<? extends IPojo> c) {
		Criteria criteria = this.getSession().createCriteria(c);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	protected List<A> listRemoved(String field, Class<? extends IPojo> c) {
		return filterRemoved(field, true, c);
	}

	@SuppressWarnings("unchecked")
	private List<A> filterRemoved(String field, boolean removed, Class<? extends IPojo> c) {
		Criteria criteria = this.getSession().createCriteria(c);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	public void flush() {
		getSession().flush();
		getSession().clear();
	}

	public void delete(Object obj) {
		getSession().delete(obj);
		flush();
	}

}