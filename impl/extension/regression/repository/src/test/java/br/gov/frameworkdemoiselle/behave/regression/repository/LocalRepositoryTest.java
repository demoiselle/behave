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
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.regression.Repository;
import br.gov.frameworkdemoiselle.behave.regression.Result;

public class LocalRepositoryTest {

	private Repository repo;

	@Before
	public void setup() {
		repo = FactoryRepository.getInstance();
		repo.clean();
	}

	@Test
	public void testSaveAndClean() {
		repo.save(new Result("login", "ubuntu/firefox", "Ok"));
		assertEquals(1, repo.countResults());
		repo.save(new Result("logout", "ubuntu/firefox", "Ok"));
		assertEquals(2, repo.countResults());
		repo.clean();
		assertEquals(0, repo.countResults());
	}

	@Test
	public void testSaveAndCleanFile() {
		repo.save(new Result("login", "ubuntu/firefox", "Ok", new File("target/test-classes/logo-dbehave.png")));
		assertEquals(1, repo.countResults());
		repo.save(new Result("logout", "ubuntu/firefox", "Ok", new File("target/test-classes/logo-dbehave.png")));
		assertEquals(2, repo.countResults());
		repo.clean();
		assertEquals(0, repo.countResults());
	}

	@Test
	public void testGetResult() {
		repo.save(new Result("r1", "ubuntu/chrome", "Ok1"));
		repo.save(new Result("r2", "ubuntu/chrome", "Ok2"));
		repo.save(new Result("r3", "ubuntu/chrome", "Ok3"));
		Result result = repo.getResult("ubuntu/chrome", "r2");
		assertEquals("r2", result.getId());
		assertEquals("Ok2", result.getDetail());
		assertNull(result.getFile());
	}

	@Test
	public void testGetResultFile() {
		repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r2", "ubuntu/chrome", "Ok2", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r3", "ubuntu/chrome", "Ok3", new File("target/test-classes/logo-dbehave.png")));
		Result result = repo.getResult("ubuntu/chrome", "r2");
		assertEquals("r2", result.getId());
		assertEquals("Ok2", result.getDetail());
		assertEquals("r2.png", result.getFile().getName());
		assertTrue(result.getFile().exists());
	}

	@Test
	public void testGetResultNotFound() {
		repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r2", "ubuntu/chrome", "Ok2", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r3", "ubuntu/chrome", "Ok3", new File("target/test-classes/logo-dbehave.png")));
		Result result = repo.getResult("ubuntu/chromeold", "r2");
		assertNull(result);
	}

	@Test
	public void testGetLocationsInOrder() {
		repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r2", "windows/iexplorer", "Ok2", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r3", "mac/safari", "Ok3"));

		List<String> locations = repo.getLocations();
		assertEquals(3, locations.size());
		
		assertEquals("mac" + File.separatorChar + "safari", locations.get(0));
		assertEquals("ubuntu" + File.separatorChar + "chrome", locations.get(1));
		assertEquals("windows" + File.separatorChar + "iexplorer", locations.get(2));
	}

	@Test
	public void testGetLocationsPosClean() {
		repo.save(new Result("r1", "ubuntu/chrome", "Ok1", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r2", "windows/iexplorer", "Ok2", new File("target/test-classes/logo-dbehave.png")));
		repo.save(new Result("r3", "mac/safari", "Ok3"));
		repo.clean();
		List<String> locations = repo.getLocations();
		assertEquals(0, locations.size());
	}
	
	
	@Test
	public void testGetResultsByLocation() {
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
