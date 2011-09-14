package net.efano.dominco.ui;

/*
 * A GUI object to be attached to a Viewable object (via the method setViewable) 
 * so as to provide interactive functionality for viewing and editing such object 
 * The method setViewable must be called before calling any of the other methods  
 */

public interface IViewpage {

	void setViewable(IViewable aViewable);
	IViewable getViewable();
	void drawViewable();
	void readViewable();
	
}
