package br.gov.frameworkdemoiselle.behave.integration.alm;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.gov.frameworkdemoiselle.behave.integration.Integration;

public class ALMIntegration implements Integration {

	private Logger logger = Logger.getLogger(this.toString());

	@Override
	public void run(Object... params) {
		logger.log(Level.INFO, "Rodou a INTEGRATION ALM");
	}

}
