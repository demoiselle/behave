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
package br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console;

import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.BOLD;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.CYAN;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.GREEN;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.RED;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.RESET;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.YELLOW;
import static org.jbehave.core.steps.StepCreator.PARAMETER_VALUE_END;
import static org.jbehave.core.steps.StepCreator.PARAMETER_VALUE_START;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.ConsoleOutput;

public class ColoredConsoleOutput extends ConsoleOutput implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, ANSIColor> outputTypeColor = new ColeredHash();

	class ColeredHash extends HashMap<String, ANSIColor> {

		private static final long serialVersionUID = 1L;

		ColeredHash() {
			put("successful", GREEN);
			put("pending", YELLOW);
			put("pendingMethod", YELLOW);
			put("notPerformed", YELLOW);
			put("ignorable", CYAN);
			put("failed", RED);
		}
	}

	public ColoredConsoleOutput() {
		super();

	}

	public ColoredConsoleOutput(Keywords keywords) {
		super(keywords);
	}

	public ColoredConsoleOutput(Properties outputPatterns, Keywords keywords, boolean reportFailureTrace) {
		super(outputPatterns, keywords, reportFailureTrace);
	}

	public void assignColorToOutputType(String outputType, ANSIColor color) {
		outputTypeColor.put(outputType, color);
	}

	private String boldifyParams(String formatted, ANSIColor currentColor) {
		final String valueStart = lookupPattern(PARAMETER_VALUE_START, PARAMETER_VALUE_START);
		final String valueEnd = lookupPattern(PARAMETER_VALUE_END, PARAMETER_VALUE_END);
		return formatted.replaceAll(valueStart, escapeCodeFor(BOLD, currentColor)).replaceAll(valueEnd, escapeCodeFor(RESET, currentColor));
	}

	private String escape(String code) {
		return (char) 27 + "[" + code;
	}

	private String escapeCodeFor(ANSIColor code) {
		return escape(code + "m");
	}

	private String escapeCodeFor(ANSIColor first, ANSIColor second) {
		return escape(first + ";" + second + "m");
	}

	@Override
	protected String format(String outputType, String defaultPattern, Object... args) {
		final String formatted = super.format(outputType, defaultPattern, args);

		if (outputTypeColor.containsKey(outputType)) {
			ANSIColor color = outputTypeColor.get(outputType);
			return escapeCodeFor(color) + boldifyParams(formatted, color) + escapeCodeFor(RESET);
		}

		return formatted;
	}

	@Override
	public void overwritePattern(String key, String pattern) {
		super.overwritePattern(key, pattern);
	}
}