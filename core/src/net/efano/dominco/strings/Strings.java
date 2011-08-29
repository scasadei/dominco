package net.efano.dominco.strings;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.swt.widgets.Display;

import net.efano.dominco.ui.IDrawable;
import net.efano.dominco.ui.DrawableFactory;
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
		
		final net.efano.dominco.ui.wb.SWTEditor ed = new net.efano.dominco.ui.wb.SWTEditor();
		ed.startInOwnThread();
		makeView(ed);
		ed.getDisplay().asyncExec(new Runnable() {
			public void run () {
				view.drawStrings();
		}
		});
		}
	
	private Vector<String> extent;
	/*
	 * An optional view
	 */
	private StringsView view;
	// private IDrawable drawable;
	
	public void makeView(final SWTEditor df) {
		
		Display display = df.getDisplay();

		display.asyncExec(new Runnable() {
			public void run () {
				IDrawable sw = df.getNewDrawable();
				sw.setStrings(Strings.this);
				// sw.drawStrings();
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
