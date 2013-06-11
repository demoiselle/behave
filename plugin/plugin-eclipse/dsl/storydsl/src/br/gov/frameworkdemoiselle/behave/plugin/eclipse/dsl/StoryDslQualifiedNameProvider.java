package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.storyDsl.IdentificadorCenario;

public class StoryDslQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	
	protected QualifiedName qualifiedName(IdentificadorCenario e) {

		String lSegment = e.getName();
		
		lSegment = lSegment.replaceAll("\"([^\"]*)\"","\"\"");
		
	    return QualifiedName.create(lSegment);
		 
	 }

	
}
