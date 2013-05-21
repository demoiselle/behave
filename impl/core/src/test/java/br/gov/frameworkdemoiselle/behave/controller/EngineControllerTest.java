package br.gov.frameworkdemoiselle.behave.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mockit.Mock;
import mockit.MockClass;
import mockit.MockUp;
import mockit.Mockit;
import mockit.internal.MockingBridge;

import org.junit.Test;
import org.mockito.internal.util.MockUtil;

import br.gov.frameworkdemoiselle.behave.parser.Parser;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.util.DependenciesUtil;

public class EngineControllerTest {

	@Test
	public void testAddSteps() {
		EngineController controller = new EngineController();
		controller.addSteps(new Step() {
		});

	}
	
	@MockClass(realClass=DependenciesUtil.class)
	public static class DespendenciesUtilMock extends MockUp<DependenciesUtil>{
		
		@Mock
		public Object getInstanceDependecy(Class clazz) {
			return new Parser() {
				
				@Override
				public void setStoryPaths(List<String> storyPaths) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setSteps(List<Step> steps) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void run() throws Throwable {
					// TODO Auto-generated method stub
					
				}
			};
		}
		
	}

	@Test
	public void testRun() {
		EngineController controller = new EngineController();
		controller.addSteps(new Step() {
		});
		
		List<String> lista = new ArrayList<String>();
		
		new DespendenciesUtilMock();

		try {
			controller.run(lista);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
