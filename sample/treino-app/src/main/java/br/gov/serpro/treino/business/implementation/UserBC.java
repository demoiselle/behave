package br.gov.serpro.treino.business.implementation;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import br.gov.serpro.treino.bean.User;
import br.gov.serpro.treino.business.IUserBC;
import br.gov.serpro.treino.exception.ErrorMessage;
import br.gov.serpro.treino.exception.TestGridException;

public class UserBC implements IUserBC {

	private static ResourceBundle bundle;

	private static final long serialVersionUID = 1L;

	public User find(String login, String password) {
		try {
			if (bundle == null) {
				bundle = ResourceBundle.getBundle("treino_login");
			}
			String senha = bundle.getString(login);
			if (senha != null && senha.equals(password)) {
				return new User(login, password);
			}else{
				throw new TestGridException(ErrorMessage.USER_LOGIN);
			}
		} catch (MissingResourceException e) {
			throw new TestGridException(ErrorMessage.USER_LOGIN);
		}
	}

}
