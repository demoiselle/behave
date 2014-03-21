package br.gov.serpro.treino.business;

import br.gov.framework.demoiselle.core.layer.IBusinessController;

public interface ISendMailBC extends IBusinessController {

	public void sendMail(String to, String assunto, String message);
	
	public void sendMailFeedback(String to, String SS, String projectName, String link);
	
}
