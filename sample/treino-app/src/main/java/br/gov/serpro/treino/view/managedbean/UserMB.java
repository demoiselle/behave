package br.gov.serpro.treino.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.gov.serpro.treino.bean.Obra;
import br.gov.serpro.treino.bean.User;
import br.gov.serpro.treino.business.IUserBC;
import br.gov.serpro.treino.business.implementation.UserBC;
import br.gov.serpro.treino.config.TreinoConfig;
import br.gov.serpro.treino.constant.Navigation;
import br.gov.serpro.treino.exception.ErrorMessage;

@SessionScoped
@ManagedBean(name = "userMB")
public class UserMB extends TestGridMB {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserMB.class);

	private List<Obra> users;

	private User user;

	private IUserBC userBC = new UserBC();

	@PostConstruct
	public void init() {
		users = new ArrayList<Obra>();
		modeInsert = false;
		user = new User();
	}

	public boolean isLogged() {
		String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
		return (username != null && !username.equals(""));
	}
	
	public void login(String _user, String _pass) {
		try {
			User user = userBC.find(_user, _pass);
			if (user != null) {
				
				// Inicia as configurações e dados do banco em memória
				TreinoConfig.getInstance();
				
				log.info("usuário [" + user.getName() + "] logado");
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", _user);
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, Navigation.INDEX);
				return;
			}

			

		} catch (Throwable e) {
			FacesUtil.addMessage(ErrorMessage.USER_LOGIN, null, e);
		}
	}

	


	public List<Obra> getUsers() {
		return users;
	}

	public void setUsers(List<Obra> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
