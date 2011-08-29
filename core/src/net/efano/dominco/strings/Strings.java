package net.efano.dominco.strings;

import java.util.Iterator;
import java.util.Vector;

import net.efano.dominco.ui.IDrawable;
import net.efano.dominco.ui.DrawableFactory;

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

		
		
		ed.getDisplay().asyncExec(new Runnable() {
			public void run () {
				IDrawable sw = ed.getNewDrawable();
				sw.setStrings(Strings.this);
				sw.drawStrings();
		}
		});

	}
	
	private IDrawable drawable;
	private Vector<String> extent;
	
	public Strings() {
		extent = new Vector<String>();
	}

	public Strings(DrawableFactory ed) {
		extent = new Vector<String>();
		drawable = ed.getNewDrawable();
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
		drawable.drawString(it.next()); 
		}
	}
}
