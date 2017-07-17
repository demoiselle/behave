/* 
 * Lista de funções Javascript para manipulação do compoente PrimeFaces Tree
 * 
 * getPrimefacesWidgetById(id)		: Recupera o widget do Primefaces pelo ID
 *
 * getNodeByPath(widget,path)		: Recupera o node da árvore pelo caminho de posição, iniciado a posição em 1 e separado os níveis por ponto, por exemplo: 1.1.3
 * getNodeByLabel(widget,label)     : Recupera o node da árvore pelo label
 * 
 * collapseByPath(widget, path)		: Colapsa o node localizado pelo caminho de posição
 * collapseByLabel(widget,label)    : Colapsa o node localizado pelo label
 * collapse(widget,node)			: Colapsa o node
 *  
 * expandByLabel(widget, label)		: Expande o node localizado pelo label
 * expandByPath(widget, path)		: Expande o node localizado pelo caminho de posição
 * expand(widget, node)				: Expande o node
 * 
 * selectByLabel(widget, label)		: Seleciona o node localizado pelo label
 * selectByPath(widget, path)		: Seleciona o node localizado pelo caminho de posição
 * select(widget,node)				: Seleciona o node
 * 
 * unselectByLabel(widget, label)	: Deseleciona o node localizado pelo label
 * unselectByPath(widget, path)		: Deseleciona o node localizado pelo caminho de posição
 * unselect(widget,node)			: Deseleciona o node
 * 
 * toggleByLabel(widget, label)		: Alterna o checkbox do node localizado pelo label
 * toggleByPath(widget, path)		: Alterna o checkbox do node localizado pelo caminho de posição
 * toggle(widget, node)				: Alterna o checkbox do node
 * 
 * nodeIsLeaf(node)					: Verifica se o node é uma folha
 * nodeIsParent(node)				: Verifica se o node tem é um pai
 * nodeIsChecked(node)				: Verifica se um node está marcado
 * nodeIsVisible(node)				: Verifica se um node é visível a partir do valor do estilo 'display' da lista <ul> à qual o node pertence
 * 
 * Estes códigos não funcionam com o componente Horizontal Tree. 
 *
 * Autor: Lucas Mazzardo Veloso <lmveloso@gmail.com>
 * 
 */

var getPrimefacesWidgetById = function(id) {
	for ( var key in PrimeFaces.widgets) {
		if (id == PrimeFaces.widgets[key].id)
			return PrimeFaces.widgets[key];
	}
	return null;
}

var getNodeByPath = function(w, path) {
	var node = null;
	var nodeList = w.jq.children('ul.ui-tree-container').children(
			'li.ui-treenode');
	var sPath = path.split('.');
	for ( var i in sPath) {
		var n = parseInt(sPath[i]);
		if (n > 0 && n <= nodeList.length) {
			node = jQuery(nodeList.get(n - 1));
			nodeList = node.children('ul.ui-treenode-children').children(
					'li.ui-treenode')
		} else
			return null;
	}
	return node;
}

var getNodeByLabel = function(w, label) {
	var node = null;
	var nodeList = w.jq.find('li.ui-treenode');
	for ( var i in nodeList) {
		node = jQuery(nodeList[i]);
		if (label.trim() == node.children('span.ui-treenode-content').children(
				'span.ui-treenode-label').text().trim()) {
			return node;
		}
	}
	return null;
}

var collapseByLabel = function(w, label) {
	var node = getNodeByLabel(w, label);
	return collapse(w, node);
}

var collapseByPath = function(w, path) {
	var node = getNodeByPath(w, path);
	return collapse(w, node);
}

var collapse = function(w, node) {
	if (w != null && node != null) {
		w.collapseNode(node);
		return true;
	}
	return false;
}

var expandByLabel = function(w, label) {
	var node = getNodeByLabel(w, label);
	return expand(w, node);
}

var expandByPath = function(w, path) {
	var node = getNodeByPath(w, path);
	return expand(w, node);
}
var expand = function(w, node) {
	if (w != null && node != null) {
		w.expandNode(node);
		return true;
	}
	return false;
}

var toggleByLabel = function(w, label) {
	var node = getNodeByLabel(w, label);
	return toggle(w, node);
}

var toggleByPath = function(w, path) {
	var node = getNodeByPath(w, path);
	return toggle(w, node);
}

var toggle = function(w, node) {
	if (w != null && node != null) {
		w.toggleCheckboxNode(node);
		return true;
	}
	return false;
}

var selectByLabel = function(w, label) {
	var node = getNodeByLabel(w, label);
	return select(w, node);
}

var selectByPath = function(w, path) {
	var node = getNodeByPath(w, path);
	return select(w, node);
}

var select = function(w, node) {
	if (w != null && node != null) {
		w.selectNode(node);
		return true;
	}
	return false;
}

var unselectByLabel = function(w, label) {
	var node = getNodeByLabel(w, label);
	return unselect(w, node);
}

var unselectByPath = function(w, path) {
	var node = getNodeByPath(w, path);
	return unselect(w, node);
}

var unselect = function(w, node) {
	if (w != null && node != null) {
		w.unselectNode(node);
		return true;
	}
	return false;
}

var nodeIsLeaf = function(node) {
	return node.hasClass('ui-treenode-leaf');
}

var nodeIsParent = function(node) {
	return node.hasClass('ui-treenode-parent');
}

var nodeIsChecked = function(node) {
	return node.hasClass('ui-treenode-unselected');
}

var nodeIsVisible = function(node) {
	return node.parent().prop('style').display != 'none';
}

// Sugestão: comprimir com http://jscompress.com/
// Não esquecer de colocar um ; ao final da linha gerada antes de copiar para a
// variável JSTREECODE no Tree.java.
// var getPrimefacesWidgetById=function(e){for(var t in
// PrimeFaces.widgets){if(e==PrimeFaces.widgets[t].id)return
// PrimeFaces.widgets[t]}return null};var getNodeByPath=function(e,t){var
// n=null;var r=jQuery(e.jqId);var
// i=r.children("ul.ui-tree-container").children("li.ui-treenode");var
// s=w.jq.split(".");for(var o in s){var
// u=parseInt(s[o]);if(u>0&&u<=i.length){n=jQuery(i.get(u-1));i=n.children("ul.ui-treenode-children").children("li.ui-treenode")}else
// return null}return n};var getNodeByLabel=function(e,t){var n=null;var
// r=jQuery(e.jqId);var i=r.find("li.ui-treenode");for(var s in
// i){n=jQuery(i[s]);if(w.jq.trim()==n.children("span.ui-treenode-content").children("span.ui-treenode-label").text().trim()){return
// n}}return null};var collapseByLabel=function(e,t){var
// n=getNodeByLabel(e,t);return collapse(e,n)};var
// collapseByPath=function(e,t){var n=getNodeByPath(e,t);return
// collapse(e,n)};var
// collapse=function(e,t){if(e!=null&&t!=null){e.collapseNode(t);return
// true}return false};var expandByLabel=function(e,t){var
// n=getNodeByLabel(e,t);return expand(e,n)};var expandByPath=function(e,t){var
// n=getNodeByPath(e,t);return expand(e,n)};var
// expand=function(e,t){if(e!=null&&t!=null){e.expandNode(t);return true}return
// false};var toggleByLabel=function(e,t){var n=getNodeByLabel(e,t);return
// toggle(e,n)};var toggleByPath=function(e,t){var n=getNodeByPath(e,t);return
// toggle(e,n)};var
// toggle=function(e,t){if(e!=null&&t!=null){e.toggleCheckboxNode(t);return
// true}return false};var selectByLabel=function(e,t){var
// n=getNodeByLabel(e,t);return select(e,n)};var selectByPath=function(e,t){var
// n=getNodeByPath(e,t);return select(e,n)};var
// select=function(e,t){if(e!=null&&t!=null){e.selectNode(t);return true}return
// false};var unselectByLabel=function(e,t){var n=getNodeByLabel(e,t);return
// unselect(e,n)};var unselectByPath=function(e,t){var
// n=getNodeByPath(e,t);return unselect(e,n)};var
// unselect=function(e,t){if(e!=null&&t!=null){e.unselectNode(t);return
// true}return false};var nodeIsLeaf=function(e){return
// e.hasClass("ui-treenode-leaf")};var nodeIsParent=function(e){return
// e.hasClass("ui-treenode-parent")};var nodeIsChecked=function(e){return
// e.hasClass("ui-treenode-unselected")};var nodeIsVisible=function(e){return
// e.parent().prop("style").display!="none"};

