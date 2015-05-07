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

import java.util.Iterator;
import java.util.Map;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

public class DataProviderSteps extends CommonSteps {

	@When("informo: $table")
	@Given("informo: $table")
	public void setDataProvideTable(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			Iterator<String> it = row.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();

				setDataProvider(key, row.get(key));
			}
		}
	}

	@When("informo o campo: $table")
	@Alias("informo os campos: $table")
	public void informFields(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			Iterator<String> it = row.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				inform(row.get(key), key);
			}
		}
	}

	@Given("selecionei \"$recordId\" do conjunto de dados \"$dataSetType\"")
	@When("seleciono \"$recordId\" do conjunto de dados \"$dataSetType\"")
	public void putRecordIntoDataProvider(String recordId, String dataSetType) {
		datasetProvider.setDataProviderCurrentRecord(dataSetType, recordId);
	}

	@When("informo o valor do campo \"$fieldName\"")
	@Then("informo o valor do campo \"$fieldName\"")
	public void informWithDataProviderValue(String fieldName) {
		inform(fieldName, fieldName);
	}

	@When("informo \"$key\" com valor \"$value\"")
	@Given("informo \"$key\" com valor \"$value\"")
	@Then("informo \"$key\" com valor \"$value\"")
	@Aliases(values = { "defino a variável \"$key\" com valor \"$value\"" })
	public void setDataProvider(String key, String value) {
		dataProvider.put(key, value);
	}

	@When("obtenho \"$var\" do campo \"$fieldName\"")
	@Given("obtenho \"$var\" do campo \"$fieldName\"")
	@Then("obtenho \"$var\" do campo \"$fieldName\"")
	public void getValue(String var, String fieldName) {
		Element element = (Element) runner.getElement(currentPageName, fieldName);
		String value = element.getText();
		dataProvider.put(var, value);
	}
	
}
