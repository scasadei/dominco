package net.efano.dominco.strings;

import java.util.Iterator;
import java.util.Vector;
import net.efano.dominco.ui.wb.SWTEditor;
import net.efano.dominco.ui.wb.StringsView;

public class Strings  {

	public static void main(String[] args) {
		Strings strings = new Strings();
		strings.test();
	}
	
	public void test() {
		add("ciccio");
		org.junit.Assert.assertEquals(numel(), 1);
		add("pillo");
		org.junit.Assert.assertEquals(numel(), 2);

		final SWTEditor ed = new SWTEditor();
		
		synchronized (this) {
			ed.startInOwnThread(); 
		}
		synchronized (this) {
			makeView(ed);
		}
	    synchronized (this) {
	    	if (ed.getDisplay() == null) {
	    		System.out.println("display at Strings.java%31 is null");
	    	}
			ed.getDisplay().asyncExec(new Runnable() {
				public void run () {
					view.drawStrings();
				}
			});
		}

	}

	private Vector<String> extent;
	/*
	 * An optional view
	 */
	private StringsView view;
	// private IDrawable drawable;

	public void makeView(final SWTEditor df) {

    	if (df.getDisplay() == null) {
    		System.out.println("display at line 52 of Strings.java is null");
    	}

    	df.getDisplay().syncExec(new Runnable() {
			public void run () {
				view = (StringsView) df.getNewDrawable();
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
		// TODO Auto-generated method stub
		return extent.size();
	}

	public void draw() {
		Iterator<String> it = extent.iterator();
		while (it.hasNext()) {
		view.drawString(it.next()); 
		}
	}
}
