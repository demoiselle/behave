/*
 * Demoiselle Framework
 * Copyright (C) 2015 SERPRO
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
package br.gov.frameworkdemoiselle.behave.regression.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 
 * @author SERPRO
 * 
 */
@Mojo(name = "regression")
@Execute(goal = "regression", phase = LifecyclePhase.TEST)
public class ReportMojo extends AbstractMojo {


	@Parameter(defaultValue = "${project.build.directory}", readonly = true)
	private File target;
	
	private Properties properties = new Properties();

	public void execute() {
		getLog().info("========================================");
		getLog().info("REGRESSION");
		getLog().info("========================================");
		getLog().info("target:" + target);
		loadBehaveProperties();		
		getLog().info("behave.properties");
		getLog().info("type:" + getProperty("behave.regression.type"));
		getLog().info("url:" + getProperty("behave.regression.url"));		
		getLog().info("user:" + getProperty("behave.regression.user"));
		getLog().info("password:" + getProperty("behave.regression.password"));
		getLog().info("========================================");
	}

	public String getProperty(String key){
		if (properties.containsKey(key)){
			return properties.getProperty(key);
		}else{
			throw new RuntimeException("properties '"+ key +"' not found");
		}
	}

	private void loadBehaveProperties() {
		String behaveProperties = target + "" + File.separatorChar + "test-classes" + File.separatorChar + "behave.properties";
		File file = new File(behaveProperties);
		if (file.exists()) {
			try {
				getLog().info("Load: " + behaveProperties);
				InputStream in = new FileInputStream(new File(behaveProperties));
				properties.load(in);
			} catch (Exception e) {
				getLog().error(e);
			}
		} else {
			getLog().error(	"File behave.properties not found: " + behaveProperties);
		}		
	}	
}
