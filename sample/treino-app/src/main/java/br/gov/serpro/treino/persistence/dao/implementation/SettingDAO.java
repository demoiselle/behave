package br.gov.serpro.treino.persistence.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;

import br.gov.serpro.treino.bean.Setting;
import br.gov.serpro.treino.persistence.dao.ISettingDAO;

public class SettingDAO extends TestGridDAO<Setting> implements ISettingDAO {

	private static final long serialVersionUID = 1L;
	
	
	public Setting save(Setting setting) {
		if (setting.getId() != null) {
			this.update(setting);
		} else {
			this.insert(setting);
		}
		super.flush();
		return setting;
	}

	@SuppressWarnings("unchecked")
	public List<Setting> list() {
		Criteria criteria = this.getSession().createCriteria(Setting.class);
		return criteria.list();
	}

}
