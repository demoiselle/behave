package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.primefaces;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente Primefaces
 * Tree
 * 
 * Utiliza a API Javascript do Primefaces para a correta manipulação do
 * componente. O locator do mapeamento de tela deve retornar o primeiro div
 * gerado pelo componente rich:calendar, aquele div que possui 'class="ui-tree"'
 * 
 * @author lmveloso
 * 
 */

public class Tree extends WebBase {

	/*
	 * Lista de funções Javascript para manipulação do compoente PrimeFaces Tree
	 * 
	 * getPrimefacesWidgetById(id) : Recupera o widget do Primefaces pelo ID
	 * getNodeByPath(widget,path) : Recupera o node da árvore pelo caminho de
	 * posição, iniciado a posição em 1 e separado os níveis por ponto, por
	 * exemplo: 1.1.3 getNodeByLabel(widget,label) : Recupera o node da árvore
	 * pelo label
	 * 
	 * collapseByPath(widget, path) : Colapsa o node localizado pelo caminho de
	 * posição collapseByLabel(widget,label) : Colapsa o node localizado pelo
	 * label collapse(widget,node) : Colapsa o node
	 * 
	 * expandByLabel(widget, label) : Expande o node localizado pelo label
	 * expandByPath(widget, path) : Expande o node localizado pelo caminho de
	 * posição expand(widget, node) : Expande o node
	 * 
	 * selectByLabel(widget, label) : Seleciona o node localizado pelo label
	 * selectByPath(widget, path) : Seleciona o node localizado pelo caminho de
	 * posição select(widget,node) : Seleciona o node
	 * 
	 * unselectByLabel(widget, label) : Deseleciona o node localizado pelo label
	 * unselectByPath(widget, path) : Deseleciona o node localizado pelo caminho
	 * de posição unselect(widget,node) : Deseleciona o node
	 * 
	 * toggleByLabel(widget, label) : Alterna o checkbox do node localizado pelo
	 * label toggleByPath(widget, path) : Alterna o checkbox do node localizado
	 * pelo caminho de posição toggle(widget, node) : Alterna o checkbox do node
	 * 
	 * nodeIsLeaf(node) : Verifica se o node é uma folha nodeIsParent(node) :
	 * Verifica se o node tem é um pai nodeIsChecked(node) : Verifica se um node
	 * está marcado nodeIsVisible(node) : Verifica se um node é visível a partir
	 * do valor do estilo 'display' da lista <ul> à qual o node pertence
	 * 
	 * Estes códigos não funcionam com o componente Horizontal Tree.
	 */
	private String JSTREECODE = "var getPrimefacesWidgetById=function(e){for(var t in PrimeFaces.widgets){if(e==PrimeFaces.widgets[t].id)return PrimeFaces.widgets[t]}return null};var getNodeByPath=function(e,t){var n=null;var r=e.jq.children(\"ul.ui-tree-container\").children(\"li.ui-treenode\");var i=t.split(\".\");for(var s in i){var o=parseInt(i[s]);if(o>0&&o<=r.length){n=jQuery(r.get(o-1));r=n.children(\"ul.ui-treenode-children\").children(\"li.ui-treenode\")}else return null}return n};var getNodeByLabel=function(e,t){var n=null;var r=e.jq.find(\"li.ui-treenode\");for(var i in r){n=jQuery(r[i]);if(t.trim()==n.children(\"span.ui-treenode-content\").children(\"span.ui-treenode-label\").text().trim()){return n}}return null};var collapseByLabel=function(e,t){var n=getNodeByLabel(e,t);return collapse(e,n)};var collapseByPath=function(e,t){var n=getNodeByPath(e,t);return collapse(e,n)};var collapse=function(e,t){if(e!=null&&t!=null){e.collapseNode(t);return true}return false};var expandByLabel=function(e,t){var n=getNodeByLabel(e,t);return expand(e,n)};var expandByPath=function(e,t){var n=getNodeByPath(e,t);return expand(e,n)};var expand=function(e,t){if(e!=null&&t!=null){e.expandNode(t);return true}return false};var toggleByLabel=function(e,t){var n=getNodeByLabel(e,t);return toggle(e,n)};var toggleByPath=function(e,t){var n=getNodeByPath(e,t);return toggle(e,n)};var toggle=function(e,t){if(e!=null&&t!=null){e.toggleCheckboxNode(t);return true}return false};var selectByLabel=function(e,t){var n=getNodeByLabel(e,t);return select(e,n)};var selectByPath=function(e,t){var n=getNodeByPath(e,t);return select(e,n)};var select=function(e,t){if(e!=null&&t!=null){e.selectNode(t);return true}return false};var unselectByLabel=function(e,t){var n=getNodeByLabel(e,t);return unselect(e,n)};var unselectByPath=function(e,t){var n=getNodeByPath(e,t);return unselect(e,n)};var unselect=function(e,t){if(e!=null&&t!=null){e.unselectNode(t);return true}return false};var nodeIsLeaf=function(e){return e.hasClass(\"ui-treenode-leaf\")};var nodeIsParent=function(e){return e.hasClass(\"ui-treenode-parent\")};var nodeIsChecked=function(e){return e.hasClass(\"ui-treenode-unselected\")};var nodeIsVisible=function(e){return e.parent().prop(\"style\").display!=\"none\"}; ";

	public void collapseByLabel(String label) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,label) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && collapseByLabel(w,label)  );})('" + getId() + "','" + label + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível colapsar o nó com label [" + label + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void collapseByPath(String path) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,path) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && collapseByPath(w,path)  );})('" + getId() + "','" + path + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível colapsar o nó com caminho [" + path + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void expandByLabel(String label) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,label) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && expandByLabel(w,label)  );})('" + getId() + "','" + label + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível expandir o nó com label [" + label + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void expandByPath(String path) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,path) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && expandByPath(w,path)  );})('" + getId() + "','" + path + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível expandir o nó com caminho [" + path + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void selectByLabel(String label) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,label) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && selectByLabel(w,label)  );})('" + getId() + "','" + label + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível selecionar o nó com label [" + label + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void selectByPath(String path) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,path) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && selectByPath(w,path)  );})('" + getId() + "','" + path + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível selecionar o nó com caminho [" + path + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void unselectByLabel(String label) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,label) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && unselectByLabel(w,label)  );})('" + getId() + "','" + label + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível deselecionar o nó com label [" + label + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void unselectByPath(String path) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,path) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && unselectByPath(w,path)  );})('" + getId() + "','" + path + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível deselecionar o nó com caminho [" + path + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void toggleByLabel(String label) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,label) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && toggleByLabel(w,label)  );})('" + getId() + "','" + label + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível alternar o checkbox do nó com label [" + label + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	public void toggleByPath(String path) {
		waitElement(0);
		checkPrimeFacesComponent();
		String jsCode = "return (function(id,path) { " + JSTREECODE + "var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && toggleByPath(w,path)  );})('" + getId() + "','" + path + "');";
		if (!(Boolean) getJavascriptExecutor().executeScript(jsCode))
			throw new BehaveException("Não foi possível alternar o checkbox do nó com caminho [" + path + "] do compoente [" + this.getElementMap().name() + "] ID [" + getId() + "].");
	}

	/**
	 * Verifica se o componente selecionado é realmente um coponente PrimeFaces
	 * Tree
	 * 
	 * @return
	 */
	public boolean isTree() {
		// Deve ser uma ui-tree e não ui-tree-horizontal
		String jsCodeCheckComponent = "return (function(id) { " + JSTREECODE + " var w = getPrimefacesWidgetById( id ); return (typeof(w) == \"object\" && w.jq.hasClass('ui-tree') && !w.jq.hasClass('ui-tree-horizontal'));})('" + getId() + "');";
		System.out.println(jsCodeCheckComponent);
		return (Boolean) getJavascriptExecutor().executeScript(jsCodeCheckComponent);
	}

	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkPrimeFacesComponent() {
		if (!isTree())
			throw new BehaveException("O elemento [" + this.getElementMap().name() + "] selecionado possui ID [" + getId() + "] mas não é um componente PrimeFaces do tipo Tree.");

	}

}
