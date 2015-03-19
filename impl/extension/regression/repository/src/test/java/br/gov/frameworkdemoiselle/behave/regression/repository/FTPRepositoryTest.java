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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.resetAll;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.regression.Repository;
import br.gov.frameworkdemoiselle.behave.regression.Result;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ BehaveConfig.class })
public class FTPRepositoryTest {

	protected static char BAR = File.separatorChar;
	private String url = "10.200.232.59";
	private String user = "user";
	private String pass = "123456";
	private static boolean connected = true;

	private Repository repo;

	@Before
	public void setup() {
		if (connected) {
			try {

				mockStatic(BehaveConfig.class);
				expect(BehaveConfig.getProperty("behave.regression.type")).andReturn("ftp");
				expect(BehaveConfig.getProperty("behave.regression.url")).andReturn(url);
				expect(BehaveConfig.getProperty("behave.regression.folder")).andReturn("dbehave/regression");
				expect(BehaveConfig.getProperty("behave.message.locale", "pt")).andReturn("pt");
				expect(BehaveConfig.getProperty("behave.message.locale", "pt")).andReturn("pt");
				expect(BehaveConfig.getProperty("behave.regression.user")).andReturn(user);
				expect(BehaveConfig.getProperty("behave.regression.password")).andReturn(pass);

				replayAll();

				repo = FactoryRepository.getInstance();
				repo.connect();
			} catch (BehaveException e) {
				connected = false;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}

	@After
	public void after() {
		if (connected) {
			repo.disconnect();
		}
		resetAll();

	}

	@Test
	public void testInstanceof() {
		if (connected) {
			assertTrue(repo instanceof FTPRepository);
		}
	}

	@Test
	public void testSaveAndClean() {
		if (connected) {
			repo.clean();
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
		}
	}

	@Test
	public void testGetResult() {
		if (connected) {
			repo.clean();
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1"));
			repo.save(new Result("r2", "ubuntu/chrome", "Ok2"));
			repo.save(new Result("r3", "ubuntu/chrome", "Ok3"));

			Assert.assertEquals(3, repo.countResults());

			Result result = repo.getResult("ubuntu/chrome", "r2");
			assertEquals("r2", result.getId());
			assertEquals("Ok2", result.getDetail());
			assertNull(result.getFile());
		}
	}

	@Test
	public void testGetResultFile() {
		if (connected) {
			repo.clean();
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "ubuntu/chrome", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r3", "ubuntu/chrome", "Ok3", new File("target/test-classes/logo-dbehave.png")));
			Result result = repo.getResult("ubuntu/chrome", "r2");
			assertEquals("r2", result.getId());
			assertEquals("Ok2", result.getDetail());
			assertEquals("r2.png", result.getFile().getName());
			assertTrue(result.getFile().exists());
		}
	}

	@Test
	public void testGetResultNotFound() {
		if (connected) {
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "ubuntu/chrome", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r3", "ubuntu/chrome", "Ok3", new File("target/test-classes/logo-dbehave.png")));
			Result result = repo.getResult("ubuntu/chromeold", "r2");
			assertNull(result);
		}
	}

	@Test
	public void testGetResultFile2() {
		if (connected) {
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "ubuntu/chrome", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r3", "ubuntu/chrome", "Ok3", new File("target/test-classes/logo-dbehave.png")));
			Result result = repo.getResult("ubuntu/chrome", "r2");
			assertEquals("r2", result.getId());
			assertEquals("Ok2", result.getDetail());
			assertEquals("r2.png", result.getFile().getName());
			assertTrue(result.getFile().exists());
		}
	}

	@Test
	public void testGetResultNotFound2() {
		if (connected) {
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "ubuntu/chrome", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r3", "ubuntu/chrome", "Ok3", new File("target/test-classes/logo-dbehave.png")));
			Result result = repo.getResult("ubuntu/chromeold", "r2");
			assertNull(result);
		}
	}

	@Test
	public void testGetLocationsInOrder() {
		if (connected) {
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "windows/iexplorer", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r3", "mac/safari", "Ok3"));

			List<String> locations = repo.getLocations();
			assertEquals(3, locations.size());

			assertEquals("mac/safari", locations.get(0));
			assertEquals("ubuntu/chrome", locations.get(1));
			assertEquals("windows/iexplorer", locations.get(2));
		}
	}

	@Test
	public void testGetLocationsPosClean() {
		if (connected) {
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "windows/iexplorer", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r3", "mac/safari", "Ok3"));
			repo.clean();
			List<String> locations = repo.getLocations();
			assertEquals(0, locations.size());
		}
	}

	@Test
	public void testGetResultsByLocation() {
		if (connected) {
			repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r1", "windows/iexplorer", "Ok1", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r2", "windows/iexplorer", "Ok2", new File("target/test-classes/logo-dbehave.png")));
			repo.save(new Result("r1", "mac/safari", "Ok3"));

			List<Result> results = repo.getResulstByLocation("windows/iexplorer");
			assertEquals(2, results.size());
			assertEquals("r1", results.get(0).getId());
			assertEquals("Ok1", results.get(0).getDetail());
			assertEquals("r1.png", results.get(0).getFile().getName());

			assertEquals("r2", results.get(1).getId());
			assertEquals("Ok2", results.get(1).getDetail());
			assertEquals("r2.png", results.get(1).getFile().getName());
		}
	}

}
