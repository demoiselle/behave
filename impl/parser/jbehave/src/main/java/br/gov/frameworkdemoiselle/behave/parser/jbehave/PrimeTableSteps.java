/*
 * Demoiselle Framework
 * Copyright (C) 2013 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */

package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;

import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatasetProvider;
import br.gov.frameworkdemoiselle.behave.internal.util.DataProviderUtil;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Grid;

public class PrimeTableSteps extends CommonSteps{

	
	protected Runner runner;
	protected DataProvider dataProvider;
	protected DatasetProvider datasetProvider;
	protected static String currentPageName;
		
	
	public PrimeTableSteps() {
		super();
		this.runner = super.runner;
		this.dataProvider = super.dataProvider;
		this.datasetProvider = super.datasetProvider;
		
	}
	
	/**
	 * 
	 * Armazena um campo de texto exibido em uma Table no dataProvider
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 * @param container
	 *            chave no dataProvider para armazenar o texto encontrado
	 */
	@Then("armazeno a célula \"$l\",\"$c\" da tabela \"$tabela\" em \"$container\"")
	public void tableTextStore(String l, String c, String tabela, String container) {
		Element element = runner.getElement(currentPageName, tabela);
		dataProvider.put(container, ((Grid) element).findTextInTable(element, l, c));
	}

	/**
	 * 
	 * Armazena um campo de texto exibido em uma Table no dataProvider Este
	 * método utiliza a última linha exibida da tabela, por isso não é informada
	 * a linha.
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 * @param container
	 *            chave no dataProvider para armazenar o texto encontrado
	 */
	@Then("armazeno a coluna \"$c\" da tabela \"$tabela\" em \"$container\"")
	public void tableTextStoreLL(String c, String tabela, String container) {
		Element element = runner.getElement(currentPageName, tabela);
		tableTextStore(((Grid) element).findLastLine(element), c, tabela, container);
	}

	/**
	 * 
	 * Compara um campo de texto exibido em uma Table com o texto do
	 * dataProvider ou, caso não seja encontrado, com o texto enviado
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 * @param container
	 *            chave no dataProvider para ler o texto ou texto desejado
	 */
	@Then("comparo o texto da célula \"$l\",\"$c\" da tabela \"$tabela\" com \"$container\"")
	public void tableTextCheck(String l, String c, String tabela, String container) {
		Element element = runner.getElement(currentPageName, tabela);
		while (!container.equals(DataProviderUtil.replaceValue(container)))
			container = DataProviderUtil.replaceValue(container);
		Assert.assertEquals(container, ((Grid) element).findTextInTable(element, l, c));

	}

	/**
	 * 
	 * Compara um campo de texto exibido em uma Table com o texto do
	 * dataProvider ou, caso não seja encontrado, com o texto enviado Este
	 * método utiliza a última linha exibida da tabela, por isso não é informada
	 * a linha.
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 * @param container
	 *            chave no dataProvider para ler o texto ou texto desejado
	 */
	@Then("comparo o texto da coluna \"$c\" da tabela \"$tabela\" com \"$container\"")
	public void tableTextCheckLL(String c, String tabela, String container) {
		Element element = runner.getElement(currentPageName, tabela);
		tableTextCheck(((Grid) element).findLastLine(element), c, tabela, container);
	}

	/**
	 * 
	 * Clica em um botão (submit ou button), checkbox, radio, expansor de
	 * detalhes do prime ou link
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 */
	@Then("clico na célula \"$l\",\"$c\" da tabela \"$tabela\"")
	public void tableButtonClick(String l, String c, String tabela) {
		Element element = runner.getElement(currentPageName, tabela);
		((Grid) element).tableButtonClick(element, l, c);

	}

	/**
	 * 
	 * Clica em um botão (submit ou button), checkbox, radio, expansor de
	 * detalhes do prime ou link Este método utiliza a última linha exibida da
	 * tabela, por isso não é informada a linha.
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 */
	@Then("clico na coluna \"$c\" da tabela \"$tabela\"")
	public void tableButtonClickLL(String c, String tabela) {
		Element element = runner.getElement(currentPageName, tabela);
		tableButtonClick(((Grid) element).findLastLine(element), c, tabela);
	}

	/**
	 * Seleciona uma opção pelo texto exibido em um input select do prime em
	 * determinada linha e coluna da tabela
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 */
	@Then("escolho a opção \"$value\" na célula \"$l\",\"$c\" da tabela \"$tabela\"")
	public void tableSelectClick(String value, String l, String c, String tabela) {
		Element element = runner.getElement(currentPageName, tabela);
		((Grid) element).tableSelectClick(value, l, c, element);
	}

	/**
	 * 
	 * Seleciona uma opção pelo texto exibido em um input select do prime em
	 * determinada linha e coluna da tabela Este método utiliza a última linha
	 * exibida da tabela, por isso não é informada a linha.
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 */
	@Then("escolho a opção \"$value\" na coluna \"$c\" da tabela \"$tabela\"")
	public void tableSelectClickLL(String value, String c, String tabela) {
		Element element = runner.getElement(currentPageName, tabela);
		tableSelectClick(value, ((Grid) element).findLastLine(element), c, tabela);
	}

	/**
	 * 
	 * Preenche o conteúdo de um input text ou textarea localizado em uma tabela
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 */

	@Then("informo o texto \"$value\" na célula \"$l\",\"$c\" da tabela \"$tabela\"")
	public void tableTextSendKeys(String value, String l, String c, String tabela) {
		Element element = runner.getElement(currentPageName, tabela);
		((Grid) element).tableTextSendKeys(value, l, c, element);
	}

	/**
	 * 
	 * Preenche o conteúdo de um input text ou textarea localizado em uma tabela
	 * Este método utiliza a última linha exibida da tabela, por isso não é
	 * informada a linha.
	 * 
	 * @author Tiago Tosta Peres<tiago.peres@serpro.gov.br>
	 * @param l
	 *            linha da tabela
	 * @param c
	 *            coluna da tabela
	 * @param tabela
	 *            tabela a ser lida
	 */
	@Then("informo o texto \"$value\" na coluna \"$c\" da tabela \"$tabela\"")
	public void tableTextSendKeysLL(String value, String c, String tabela) {
		Element element = runner.getElement(currentPageName, tabela);
		tableTextSendKeys(value, ((Grid) element).findLastLine(element), c, tabela);
	}
	
}
