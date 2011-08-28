package net.efano.dominco.strings;

import java.util.Vector;

import net.efano.dominco.ui.IDrawable;
import net.efano.dominco.ui.IEditor;

public class Strings {

	
	private IDrawable drawable;
	private Vector<String> extent;
	
	public Strings() {
		extent = new Vector<String>();
	}

	public Strings(IEditor ed) {
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
		drawable.drawStrings();
	}
}
