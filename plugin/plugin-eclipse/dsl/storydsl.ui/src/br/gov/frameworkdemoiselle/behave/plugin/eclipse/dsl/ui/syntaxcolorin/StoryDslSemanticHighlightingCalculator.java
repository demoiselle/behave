package br.gov.frameworkdemoiselle.behave.plugin.eclipse.dsl.ui.syntaxcolorin;

public class StoryDslSemanticHighlightingCalculator  
	//implements ISemanticHighlightingCalculator 
{
	
	/*
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		
		if (resource == null || resource.getParseResult() == null){
			
			return;
			
		}
		
		INode root = resource.getParseResult().getRootNode();
		
		for (INode node : root.getAsTreeIterable()) {
			
			if (node.getGrammarElement() instanceof CrossReference 
				|| (node.getGrammarElement() instanceof org.eclipse.xtext.impl.RuleCallImpl && ((org.eclipse.xtext.impl.RuleCallImpl)node.getGrammarElement()).getRule().getName().equalsIgnoreCase("IdentificadorCenario"))) {
				
				acceptor.addPosition(node.getOffset(), node.getLength(), StoryDslSemanticHighlightingConfiguration.CROSS_REF);
				
			}else if( node instanceof LeafNode){ 

				if( node.getGrammarElement() instanceof org.eclipse.xtext.impl.RuleCallImpl){
					AbstractRule lRule = ((org.eclipse.xtext.impl.RuleCallImpl)node.getGrammarElement()).basicGetRule();
					if(lRule instanceof TerminalRuleImpl){
						String lNomeRule = lRule.getName();
						if(lNomeRule.equals("ENTAO_") ||lNomeRule.equals("DADO_")||lNomeRule.equals("QUANDO_")||lNomeRule.equals("E_")||lNomeRule.equals("MAS_")){ 
							acceptor.addPosition(node.getOffset(), node.getLength(), StoryDslSemanticHighlightingConfiguration.BDD_REF);
						}
					}
				}
				
			}

		}

	}
	*/
	
}