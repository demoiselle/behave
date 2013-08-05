/*
 * Demoiselle Framework
 * Copyright (C) 2013 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package demoisellebehave.serpro.treino.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * @author SERPRO
 *
 */
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
	public Obra load(Long id) {
		try {
			if (id == null) {
				return null;
			}
			return (Obra) getSession().load(Obra.class, id);
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
