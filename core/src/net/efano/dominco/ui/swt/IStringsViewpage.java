package net.efano.dominco.ui.swt;

import net.efano.dominco.strings.*;

/*
 * A GUI object to be attached to a Strings object (via the method setStrings) 
 * so as to provide interactive functionality for viewing and editing such object 
 * The method setStrings must be called before calling any of the other methods  
 */

public interface IStringsViewpage {

	void setStrings(Strings aStrings);
	Strings getStrings();
	void drawStrings();
	void readStrings();
	
}
