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
package br.gov.frameworkdemoiselle.behave.regression.repository;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.resetAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.regression.Repository;
import br.gov.frameworkdemoiselle.behave.regression.Result;

@RunWith( PowerMockRunner.class )
@PrepareForTest( {BehaveConfig.class} )
public class FTPRepositoryTest {
	
	private Repository repo;
	
	@Before
	public void setup() {	
	}

	@Test
	public void testSaveAndClean() {
        
		mockStatic(BehaveConfig.class);
		expect(BehaveConfig.getProperty("behave.regression.type")).andReturn("ftp");		
		expect(BehaveConfig.getProperty("behave.regression.url")).andReturn("10.200.232.59:/home/stct3");
		expect(BehaveConfig.getProperty("behave.regression.folder")).andReturn("dbehave/regression");				
		expect(BehaveConfig.getProperty("behave.message.locale", "pt")).andReturn("pt");
		expect(BehaveConfig.getProperty("behave.message.locale", "pt")).andReturn("pt");
		expect(BehaveConfig.getProperty("behave.regression.user")).andReturn("stct3");
		expect(BehaveConfig.getProperty("behave.regression.password")).andReturn("stct3");

		replayAll();

		repo = FactoryRepository.getInstance();
		repo.connect();
		
		repo.clean();

		assertTrue(repo instanceof FTPRepository);

		repo.save(new Result("login", "ubuntu/firefox", "Ok"));
		Assert.assertEquals(1, repo.countResults());
		repo.save(new Result("logout", "ubuntu/firefox", "Ok"));		
		Assert.assertEquals(2, repo.countResults());
		
		
		repo.save(new Result("screen-01", "windows/firefox", "screen-01"));
		repo.save(new Result("screen-02", "windows/firefox", "screen-02"));
		
		repo.save(new Result("screen-01", "windows/iexplorer", "screen-01"));
		repo.save(new Result("screen-02", "windows/iexplorer", "screen-02"));
		
		Assert.assertEquals(6, repo.countResults());
		
		repo.clean();
		Assert.assertEquals(0, repo.countResults());
		repo.disconnect();

		verifyAll();
		resetAll();

	}
}
