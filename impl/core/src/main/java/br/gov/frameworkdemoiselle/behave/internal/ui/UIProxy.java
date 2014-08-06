package br.gov.frameworkdemoiselle.behave.internal.ui;

import java.lang.reflect.Method;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

public class UIProxy implements java.lang.reflect.InvocationHandler {

	private Object obj;
	Logger log = Logger.getLogger(UIProxy.class);
	private BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new UIProxy(obj));
	}

	private UIProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result;

		long startedTime = GregorianCalendar.getInstance().getTimeInMillis();

		while (true) {

			try {
				result = m.invoke(obj, args);
				return result;
			} catch (Throwable ex) {
				// Somente armazena o erro do valor não encontrado, e tenta
				// novamente
				if (BehaveConfig.getRunner_CatchUIException().contains(ex.getCause().getClass().getCanonicalName())) {
					log.debug(bm.getString("exception-value-dont-selected"));
				} else {
					throw ex;
				}
			}
			
			// Faz uma pequena espera entre as tentativas
			Thread.sleep(BehaveConfig.getRunner_ScreenMinWait());

			// Se nenhum valor selecionado for encontrado tem que dar erro
			// depois do timeout
			if ((GregorianCalendar.getInstance().getTimeInMillis() - startedTime) > BehaveConfig.getRunner_ScreenMaxWait()) {
				throw new BehaveException(bm.getString("exception-value-dont-selected"));
			}

		}

	}
}
