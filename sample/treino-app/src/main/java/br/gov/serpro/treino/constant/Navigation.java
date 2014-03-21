package br.gov.serpro.treino.constant;

public class Navigation {

	/** Pastas */
	public static final String PRIVATE_FOLDER = "/private/pages/";
	public static final String PUBLIC_FOLDER = "/public/pages/";

	/** Pagina privadas */
	public static final String INDEX = PRIVATE_FOLDER + "index?faces-redirect=true";
	public static final String OBRA = PRIVATE_FOLDER + "obra?faces-redirect=true";
	public static final String TESTE = PRIVATE_FOLDER + "teste?faces-redirect=true";
	public static final String DESEMPENHO = PRIVATE_FOLDER + "desempenho?faces-redirect=true";
	
	
	/** Pagina publicas */
	public static final String REPORT = PUBLIC_FOLDER + "report?faces-redirect=true";
	public static final String LOGIN = PUBLIC_FOLDER + "security/login.html?faces-redirect=true";
	

}
