package br.gov.serpro.treino.business;

import br.gov.framework.demoiselle.core.layer.IBusinessController;
import br.gov.serpro.treino.bean.User;

public interface IUserBC extends IBusinessController {

	public User find(String login, String passwork);

}
