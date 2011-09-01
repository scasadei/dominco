package net.efano.dominco.strings;

import static org.junit.Assert.*;

import net.efano.dominco.ui.IDrawable;
import net.efano.dominco.ui.swt.StringsView;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringsTest {

	
	private static Strings strings;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		strings = new Strings();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAdd() {
		strings.add("ciccio");
		org.junit.Assert.assertEquals(strings.numel(), 1);
		strings.add("pillo");
		org.junit.Assert.assertEquals(strings.numel(), 2);
		net.efano.dominco.ui.swt.SWTEditor ed = new net.efano.dominco.ui.swt.SWTEditor();
		ed.init();
		ed.open();
		IDrawable sw = ed.getNewDrawable();
		sw.setStrings(strings);
		sw.drawStrings();
	}

}
