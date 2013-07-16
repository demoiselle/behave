package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import org.openqa.selenium.Keys;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.runner.ui.StateUI;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class WebTextField extends WebBase implements TextField {

	public void sendKeys(CharSequence... keysToSend) {
		verifyState(StateUI.ENABLE);
		verifyState(StateUI.VISIBLE);

		getElements().get(0).sendKeys(keysToSend);
	}

	/**
	 * Função que tenta preencher mais de uma vez o campo. Ela verifica se o
	 * conteúdo enviado é o mesmo que esta atualmente no campo.
	 */
	public void sendKeysWithTries(CharSequence... keysToSend) {
		int totalMilliseconds = 0;
		while (!getElements().get(0).getAttribute("value").equals(keysToSend)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Keys[] keys = new Keys[getElements().get(0).getAttribute("value").length()];
			for (int i = 0; i < keys.length; i++)
				keys[i] = Keys.BACK_SPACE;

			sendKeys(Keys.chord(keys), keysToSend.toString());

			totalMilliseconds += 1000;

			if (totalMilliseconds > BehaveConfig.getRunner_ScreenMaxWait())
				throw new RuntimeException("Limpeza de campo não concluída com sucesso.");
		}
	}

	public void clear() {
		verifyState(StateUI.ENABLE);
		verifyState(StateUI.VISIBLE);
		getElements().get(0).clear();
	}
	
	@Override
	public String getText() {
		waitElement(0);
		return getElements().get(0).getAttribute("value");
	}

}
