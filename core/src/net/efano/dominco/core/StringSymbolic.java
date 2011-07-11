package net.efano.dominco.core;

public class StringSymbolic implements Symbolic {

	String data;
	
	StringSymbolic(String aString) {
		data = aString;
	}
	
	public String symbolic() { return data; }
}
