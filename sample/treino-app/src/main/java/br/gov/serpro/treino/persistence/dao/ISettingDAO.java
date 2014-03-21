package br.gov.serpro.treino.persistence.dao;

import java.util.List;

import br.gov.framework.demoiselle.core.layer.IDAO;
import br.gov.serpro.treino.bean.Setting;

public interface ISettingDAO extends IDAO<Setting>{

	public List<Setting> list();

	public Setting save(Setting setting);

}
