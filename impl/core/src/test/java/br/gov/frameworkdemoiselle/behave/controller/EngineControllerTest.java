//package br.gov.frameworkdemoiselle.behave.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import br.gov.frameworkdemoiselle.behave.parser.Parser;
//import br.gov.frameworkdemoiselle.behave.parser.Step;
//import br.gov.frameworkdemoiselle.behave.util.DependenciesUtil;
//
//public class EngineControllerTest {
//
//	@Test
//	public void testAddSteps() {
//		EngineController controller = new EngineController();
//		controller.addSteps(new Step() {
//		});
//
//	}
//	
//	@MockClass(realClass=DependenciesUtil.class)
//	public static class DependenciesUtilMock extends MockUp<DependenciesUtil>{
//		
//		@Mock
//		public Object getInstanceDependecy(@SuppressWarnings("rawtypes") Class clazz) {
//			return new Parser() {
//				
//				@Override
//				public void setStoryPaths(List<String> storyPaths) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void setSteps(List<Step> steps) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void run() throws Throwable {
//					// TODO Auto-generated method stub
//					
//				}
//			};
//		}
//		
//	}
//
//	@Test
//	public void testRun() {
//		EngineController controller = new EngineController();
//		controller.addSteps(new Step() {
//		});
//		
//		List<String> lista = new ArrayList<String>();
//		
//		new DependenciesUtilMock();
//
//		try {
//			controller.run(lista);
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
// }
