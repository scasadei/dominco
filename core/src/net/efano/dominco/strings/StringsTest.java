package net.efano.dominco.strings;

// import static org.junit.Assert.*;

import net.efano.dominco.strings.ui.IStringsViewpage;
import net.efano.dominco.strings.ui.swt.StringsViewbookAsTabbedTables;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringsTest {


	public static void main(String [] args) {
		strings = new Strings();
		strings.add("ciccio");
		org.junit.Assert.assertEquals(strings.numel(), 1);
		strings.add("pillo");
		org.junit.Assert.assertEquals(strings.numel(), 2);

		final StringsViewbookAsTabbedTables ed = new StringsViewbookAsTabbedTables();
		
		try {
		
		synchronized (strings) {
			ed.openInOwnThread(); 
		}
		synchronized (strings) {
			strings.makeViewAndSitOnIt(ed);
		}
	    synchronized (strings) {
	    	strings.getView().drawStrings2();/*
			ed.getDisplay().asyncExec(new Runnable() {
				public void run () {
					strings.getView().drawStrings();
				}
			});*/
		}
		} finally {};// catch (InterruptedException e) {e.printStackTrace();}
	}
	
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
		net.efano.dominco.strings.ui.swt.StringsViewbookAsTabbedTables ed = new net.efano.dominco.strings.ui.swt.StringsViewbookAsTabbedTables();
		ed.init();
		ed.open();
		IStringsViewpage sw = ed.getNewViewpage();
		sw.setStrings(strings);
		sw.drawStrings();
	}

}
