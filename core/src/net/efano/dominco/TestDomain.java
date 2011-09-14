package net.efano.dominco;

import static org.junit.Assert.*;

import net.efano.dominco.ui.swt.ViewbookAsTabbedTables;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDomain {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void test() {
		DomainContext dc = new DomainContext();
		final ViewbookAsTabbedTables ed = new ViewbookAsTabbedTables();
		try {
			synchronized (dc) {
				ed.openInOwnThread(); 
			}
			synchronized (dc) {
				dc.makeViewAndSitOnIt(ed);
			}
			synchronized (dc) {
				ed.asyncExec(new Runnable() {
					public void run () {
						// dc.getView().drawStrings();
					}
				});
			}
		} finally {};

		// fail("Not yet implemented");
	}

}
