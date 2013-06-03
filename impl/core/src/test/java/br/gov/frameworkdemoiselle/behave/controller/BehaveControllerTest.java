package br.gov.frameworkdemoiselle.behave.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BehaveControllerTest {

	@Test
	public void testGetInstance() {
		BehaveController controller=BehaveController.getInstance();
		Assert.assertNotNull(controller);
	}

	@Test
	public void testRunListOfString() {
		BehaveController controller=BehaveController.getInstance();
		List<String> listaPath=new ArrayList<String>();
		controller.run(listaPath);
	}

	@Test
	public void testRunString() {
		BehaveController controller=BehaveController.getInstance();		
		controller.run("path");
	}

	@Test
	public void testRun() {
		BehaveController controller=BehaveController.getInstance();
		controller.run();
	}

	@Test
	public void testAddStories() {
		BehaveController controller=BehaveController.getInstance();
		controller.addStories("path");
		controller.run();
	}

}
