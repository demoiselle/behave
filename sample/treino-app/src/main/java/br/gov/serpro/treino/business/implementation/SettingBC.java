package br.gov.serpro.treino.business.implementation;

import java.util.List;

import org.apache.log4j.Logger;

import br.gov.serpro.treino.bean.Setting;
import br.gov.serpro.treino.business.ISettingBC;
import br.gov.serpro.treino.persistence.dao.ISettingDAO;
import br.gov.serpro.treino.persistence.dao.implementation.SettingDAO;

public class SettingBC implements ISettingBC {

	private static final long serialVersionUID = 1L;

	private static Setting setting;
	
	private static Logger log = Logger.getLogger(SettingBC.class);

	private ISettingDAO settingDAO = new SettingDAO();

	public Setting update(Setting _setting) {
		log.info("update");
		settingDAO.save(_setting);
		setting = findCurrentSetting();
		return _setting;
	}

	private Setting findCurrentSetting() {
		log.info("findCurrentSetting");
		List<Setting> settings = settingDAO.list();
		if (settings != null && settings.size() > 0) {
			return settings.get(0);
		}
		return null;
	}
	
	public static Setting getCurrentSetting(){
		if (setting == null){
			setting = new SettingBC().findCurrentSetting();
		}
		return setting;
	}

}
