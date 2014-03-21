package br.gov.serpro.treino.view.managedbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.gov.framework.demoiselle.core.layer.IViewController;

public class TestGridMB implements IViewController {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(TestGridMB.class);

	protected boolean modeInsert;

	protected Boolean modeReadyOnly;

	public Boolean getModeInsert() {
		return modeInsert;
	}

	public void setModeInsert(Boolean modeInsert) {
		this.modeInsert = modeInsert;
	}

	public Boolean getModeReadyOnly() {
		return modeReadyOnly;
	}

	public void setModeReadyOnly(Boolean modeReadyOnly) {
		this.modeReadyOnly = modeReadyOnly;
	}

	public void nothing() {
		log.debug("nothing");
	}

	public void logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
	}

	public String getDateNow() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		return format.format(new Date());
	}

}
