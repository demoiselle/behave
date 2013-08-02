package demoisellebehave.serpro.treino.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ObraDAO {

	private Session session = null;

	public Obra save(Obra proj) {
		proj.setAtualizacao(new Date());
		if (proj.getId() != null) {
			this.update(proj);
		} else {
			this.insert(proj);
		}
		return proj;
	}

	public Obra findProjetoByName(String nome) {
		return (Obra) findObjectByField("nome", nome, Obra.class);
	}

	public List<Obra> list() {
		return list("nome", Obra.class);
	}

	public List<Obra> listRemoved() {
		return listRemoved("nome", Obra.class);
	}

	public Obra load(Obra Obra) {
		return (Obra) load(Obra, Obra.class);
	}

	protected Object findObjectByField(String field, Object value, Class<? extends Serializable> c) {
		Criteria criteria = this.getSession().createCriteria(c);
		criteria.add(Restrictions.eq(field, value));
		Object objt = criteria.uniqueResult();
		return objt;
	}

	public Session getSession() {
		if (session == null){
			session = HibernateUtil.openSession();
		}
		return session;
	}

	public Obra insert(Obra pojo) {
		getSession().save(pojo);
		getSession().flush();
		return pojo;
	}

	public void update(Obra pojo) {
		getSession().update(pojo);
		getSession().flush();
	}

	public void merge(Obra pojo) {
		getSession().merge(pojo);
		getSession().flush();
	}

	public void remove(Obra pojo) {
		getSession().delete(pojo);
		getSession().flush();
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
			throw new RuntimeException("Erro ao fazer load", e);
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
			throw new RuntimeException("Erro ao fazer load", e);
		}
	}

	protected List<Obra> list(String field, Class<? extends Serializable> c) {
		return filterRemoved(field, false, c);
	}

	@SuppressWarnings("unchecked")
	protected List<Obra> listAll(String field, Class<? extends Serializable> c) {
		Criteria criteria = this.getSession().createCriteria(c);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	protected List<Obra> listRemoved(String field, Class<? extends Serializable> c) {
		return filterRemoved(field, true, c);
	}

	@SuppressWarnings("unchecked")
	private List<Obra> filterRemoved(String field, boolean removed, Class<? extends Serializable> c) {
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
