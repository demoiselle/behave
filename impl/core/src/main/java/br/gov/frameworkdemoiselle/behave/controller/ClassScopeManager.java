package br.gov.frameworkdemoiselle.behave.controller;

import org.junit.AfterClass;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

public class ClassScopeManager {

	
	private static BehaveContext behaveContext = BehaveContext.getInstance();
	

	@AfterClass
	public static void clearClassLists() {
		BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);
		if (!BehaveConfig.getRunner_legacyRunner()){
			System.out.println("*************************limpando as classes***************************");
			behaveContext.getStepsClass().clear();
			behaveContext.getStoriesClass().clear();
			behaveContext.getStoriesReuseClass().clear();
			System.out.println("*************************limpei as classes***************************");
		}else{
			throw new BehaveException(bm.getString("exception-legacyRunner-false"));
		}
	}
	
}
