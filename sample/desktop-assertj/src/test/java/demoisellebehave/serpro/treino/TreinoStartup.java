package demoisellebehave.serpro.treino;

import javax.swing.JFrame;

import br.gov.frameworkdemoiselle.behave.runner.assertj.AssertJStartup;
import demoisellebehave.serpro.treino.ui.JFrameLogin;

public class TreinoStartup implements AssertJStartup {

	public JFrame getFrame() {
		System.out.println("TreinoStartup");
		return new JFrameLogin();
	}

}
