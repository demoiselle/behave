//package br.gov.frameworkdemoiselle.behave.parser.jbehave;
//
//import static org.junit.Assert.*;
//
//import mockit.Mock;
//import mockit.MockClass;
//import mockit.MockUp;
//
//import org.jbehave.core.configuration.Keywords;
//import org.junit.Test;
//
//import br.gov.frameworkdemoiselle.behave.runner.BehaveDriver;
//import br.gov.frameworkdemoiselle.behave.runner.Runner;
//import br.gov.frameworkdemoiselle.behave.util.DependenciesUtil;
//
//public class JBehaveParserTest {
//
//	@MockClass(realClass = DependenciesUtil.class)
//	public static class DependenciesUtilMock extends MockUp<DependenciesUtil> {
//
//		@Mock
//		public Object getInstanceDependecy(
//				@SuppressWarnings("rawtypes") Class clazz) {
//			return new Runner() {
//
//				@Override
//				public void run(Object... params) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public BehaveDriver getDriver() {
//					// TODO Auto-generated method stub
//					return null;
//				}
//			};
//
//		}
//	}
//
//	@Test
//	public void testGetKeywordsLocale() {
//		new DependenciesUtilMock();
//		JBehaveParser parser = new JBehaveParser();
//		Keywords keyword = parser.getKeywordsLocale();
//
//		assertNotNull(keyword);
//
//	}
//
//	@Test
//	public void testRun() {
//		JBehaveParser parser = new JBehaveParser();
//		try {
//			parser.run();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testConfiguration() {
//		JBehaveParser parser = new JBehaveParser();
//		parser.configuration();
//	}
//
//	@Test
//	public void testStepsFactory() {
//		JBehaveParser parser = new JBehaveParser();
//		parser.stepsFactory();
//	}
//
//	
//
//}
