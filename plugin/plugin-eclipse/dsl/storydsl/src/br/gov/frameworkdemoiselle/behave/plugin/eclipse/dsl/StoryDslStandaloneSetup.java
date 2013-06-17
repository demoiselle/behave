
package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class StoryDslStandaloneSetup extends StoryDslStandaloneSetupGenerated{

	public static void doSetup() {
		new StoryDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

