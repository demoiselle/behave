package br.gov.frameworkdemoiselle.behave.integration.alm.autenticator;

public class AutenticatorClientTests {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			AutenticatorClient autenticator = new AutenticatorClient(9990, "stct3.cta.serpro");
			autenticator.open();
			String user = autenticator.getUser();
			String password = autenticator.getPassword();
			System.out.println(user);
			System.out.println(password);
			autenticator.close();
		}
	}

}
