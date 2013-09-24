package demoisellebehave.serpro.treino;

import javax.swing.JFrame;

import br.gov.frameworkdemoiselle.behave.runner.fest.FestStartup;
import demoisellebehave.serpro.treino.ui.JFrameLogin;

public class TreinoStartup implements FestStartup {

	public JFrame getFrame() {
		System.out.println("TreinoStartup");
		return new JFrameLogin();
	}

}
