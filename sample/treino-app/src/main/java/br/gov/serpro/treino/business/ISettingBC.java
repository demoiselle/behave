package br.gov.serpro.treino.business;

import br.gov.framework.demoiselle.core.layer.IBusinessController;
import br.gov.serpro.treino.bean.Setting;

public interface ISettingBC extends IBusinessController {

	public Setting update(Setting setting);


}
