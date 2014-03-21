package br.gov.serpro.treino.business;

import br.gov.framework.demoiselle.core.layer.IBusinessController;

public interface IThreadEnvironment extends IBusinessController {

	public String getIp();

	public void setIp(String ip);

	public String getUser();

	public void setUser(String user);

	public String getPassword();

	public void setPassword(String password);

	public String getMessages();

	public void setMessages(String messages);

	public boolean isBRunning();

	public void setBRunning(boolean running);

	public boolean isFinalized();

	public void setFinalized(boolean finalized);

	public void run();

	public void interrupt();

}
