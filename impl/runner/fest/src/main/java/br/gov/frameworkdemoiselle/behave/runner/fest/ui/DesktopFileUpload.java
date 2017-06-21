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
package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import java.io.File;

import org.fest.swing.finder.JFileChooserFinder;
import org.fest.swing.fixture.JFileChooserFixture;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.fest.FestRunner;
import br.gov.frameworkdemoiselle.behave.runner.ui.FileUpload;

/**
 * 
 * @author SERPRO
 *
 */
public class DesktopFileUpload extends DesktopBase implements FileUpload {
	
	protected BehaveMessage coreMessage = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Implement for desktop applications
		throw new BehaveException(coreMessage.getString("exception-method-not-implemented", "DesktopFileUpload.sendKeys(CharSequence... keysToSend)"));
	}

	@Override
	public void cancel() {
		JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(((FestRunner) runner).robot);
		fileChooser.cancel();
	}

	@Override
	public void setCurrentDirectory(String dirPath) {
		File dir = new File(dirPath);
		JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(((FestRunner) runner).robot);
		fileChooser.setCurrentDirectory(dir);
	}

	@Override
	public void openFile(String fileName) {
		File file = new File(fileName);
		JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(((FestRunner) runner).robot);
		fileChooser.selectFile(file);
		fileChooser.approve();
	}

}
