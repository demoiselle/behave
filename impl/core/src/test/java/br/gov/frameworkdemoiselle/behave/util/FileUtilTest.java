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
package br.gov.frameworkdemoiselle.behave.util;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.internal.util.FileUtil;

/**
 * 
 * @author SERPRO
 * 
 */
public class FileUtilTest {
	

	@Test
	public void testLoadFile() {
		try {			 
			String path = FileUtilTest.class.getResource("/files/filesample.txt").getPath();
			String content = FileUtil.loadFile(path);
			Assert.assertEquals("content\n", content);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testGetAbsolutePath() {
		String absolutePath = FileUtil.getAbsolutePath();
		Assert.assertTrue(absolutePath.contains("behave"));
	}

	@Test
	public void testGetFilesInFolder() {
		List<String> files = FileUtil.getFilesInFolder(FileUtilTest.class.getResource("/files").getPath(), true);
		Assert.assertTrue(files.get(0).contains("filesample.txt"));
	}

	@Test
	public void testGetFilesInFolderByExtension() {
		List<String> files = FileUtil.getFilesInFolderByExtension(FileUtilTest.class.getResource("/files").getPath(), ".txt", true);
		Assert.assertTrue(files.get(0).contains("filesample.txt"));
	}

}