package br.gov.frameworkdemoiselle.behave.regression.report;

import java.io.File;

public class ReportMain {

	static ReportConfig config;

	public static void main(String[] args) {

		File target = new File("/home/xxx/Demoiselle Behave/workspace/behave/sample/search-google-regression/target/");

		ReportContext c = new ReportContext();
		c.run(target);

	}
}
