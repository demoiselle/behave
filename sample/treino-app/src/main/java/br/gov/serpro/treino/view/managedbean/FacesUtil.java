package br.gov.serpro.treino.view.managedbean;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.gov.framework.demoiselle.core.message.IMessage;
import br.gov.framework.demoiselle.web.transaction.WebTransactionContext;
import br.gov.serpro.treino.exception.ErrorMessage;
import br.gov.serpro.treino.exception.TestGridException;

public class FacesUtil {

	private static ResourceBundle bundle = null;

	private static Logger log = Logger.getLogger(FacesUtil.class);

	public static void addMessage(IMessage message) {
		addMessage(message, null, null);
	}

	public static void addMessage(IMessage message, String[] param) {
		addMessage(message, param, null);
	}

	public static void addMessage(IMessage message, String[] param, Throwable error) {
		try {
			log.debug("addMessage " + message.getKey());
			if (bundle == null){
				log.debug("iniciou bundle");
				log.debug("locale " + FacesContext.getCurrentInstance().getViewRoot().getLocale());
				bundle = ResourceBundle.getBundle("facesMessage");
			}
			if (message != null) {
				String msg = bundle.getString(message.getKey());
				if (param != null) {
					MessageFormat format = new MessageFormat(msg);
					msg = format.format(param);
				}
				FacesContext fc = FacesContext.getCurrentInstance();
				switch (message.getSeverity()) {
				case ERROR:
					log.info(msg);
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
					break;
				default:
					log.info(msg);
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
					break;
				}
			}
			if (error != null) {
				log.error(message, error);
				WebTransactionContext.getInstance().add(error);
			}
		} catch (MissingResourceException e) {
			String msg = "???" + message.getKey() + "???";
			FacesContext fc = FacesContext.getCurrentInstance();
			log.error(msg);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		} catch (Exception e) {
			String msg = "Erro inesperado n método addMessage. :" + e.getMessage();
			FacesContext fc = FacesContext.getCurrentInstance();
			log.error(msg);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}

	}

	public static void addMessage(String message) {
		FacesMessage msg = new FacesMessage("Succesful", message);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public static void handleException(Throwable e) {
		if (e instanceof TestGridException) {
			TestGridException exc = (TestGridException) e;
			FacesUtil.addMessage(exc.getObjectMessage(), exc.getParams());
		} else {
			String[] param = { e.getMessage() };
			FacesUtil.addMessage(ErrorMessage.UNEXPECTED, param, e);
		}
	}

}
