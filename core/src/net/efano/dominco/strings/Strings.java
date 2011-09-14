package net.efano.dominco.strings;

import java.util.Iterator;
import java.util.Vector;

import net.efano.dominco.strings.ui.IStringsViewpageFactory;
import net.efano.dominco.strings.ui.swt.StringsViewAsTable;
import net.efano.dominco.strings.ui.swt.StringsViewbookAsTabbedTables;

public class Strings {

	public static void main(String[] args) {
		Strings strings = new Strings();
		strings.test();
	}
	
	public void test()  {
		add("ciccio");
		org.junit.Assert.assertEquals(numel(), 1);
		add("pillo");
		org.junit.Assert.assertEquals(numel(), 2);

		final StringsViewbookAsTabbedTables ed = new StringsViewbookAsTabbedTables();
		
		try {
		
		synchronized (this) {
			ed.openInOwnThread(); 
		}
		synchronized (this) {
			makeViewAndSitOnIt(ed);
		}
	    synchronized (this) {
			ed.getDisplay().asyncExec(new Runnable() {
				public void run () {
					view.drawStrings();
				}
			});
		}
		} finally {};// catch (InterruptedException e) {e.printStackTrace();}

	}

	private Vector<String> extent;
	/*
	 * An optional view
	 */
	private StringsViewAsTable view;
	// private IDrawable drawable;

	public void makeViewAndSitOnIt(final IStringsViewpageFactory df)  {

		
		boolean dfReady = false;
		while (!dfReady) {
			dfReady = df.isReady();
    		System.out.println("waiting for ViewpageFactory to become ready");
			try {Thread.sleep(100);}
			catch (InterruptedException e) {}
		}

		// syncExec waits that argument terminates
		df.syncExec(
    	// df.getDisplay().syncExec(
    			new Runnable() {
			public void run () {
				view = (StringsViewAsTable) df.getNewViewpage();
				view.setStrings(Strings.this);
			}
		});
	}

	public Strings() {
		extent = new Vector<String>();
	}


	@Override
	public String toString() {
		return extent.toString();

	}

	public void add(String s) {
		extent.add(s);
	}

	public Object numel() {
		return extent.size();
	}

	/*
	 * Can be called only if view is not null. 
	 * That is makeView must have been called before.
	 */
	public void draw() {
		// shoud add code to clear the view (in case it's already showing some strings)
		Iterator<String> it = extent.iterator();
		while (it.hasNext()) {
		view.drawString(it.next()); 
		}
	}
}
