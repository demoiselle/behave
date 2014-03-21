package br.gov.serpro.treino.view.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.gov.serpro.treino.constant.Navigation;

@ManagedBean
@SessionScoped
public class LoginMB extends TestGridMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{userMB}")
	private UserMB userMB;

	private String username;
	private String password;

	public String login() {
		userMB.login(username, password);
		if (userMB.isLogged()) {
			return Navigation.INDEX;
		} else {
			return Navigation.LOGIN;
		}
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
