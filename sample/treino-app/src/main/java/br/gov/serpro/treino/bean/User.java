package br.gov.serpro.treino.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.framework.demoiselle.core.bean.IPojo;

@Entity
@Table(name = "tb_user")
public class User implements IPojo {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "login", length = 30)
	private String login;

	@Column(name = "name", length = 150)
	private String name;

	@Column(name = "password", length = 256)
	private String password;

	@Column(name = "lastLogin")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lastLogin;

	public User(String login, String password) {
		setLogin(login);
		setPassword(password);
		setName(login);
		setLastLogin(new Date());
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
