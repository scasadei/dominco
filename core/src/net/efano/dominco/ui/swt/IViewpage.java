package net.efano.dominco.ui.swt;


public interface IViewpage {

	void setViewable(IViewable aViewable);
	IViewable getViewable();
	void drawViewable();
	// void drawRow(IViewable aViewable);
	void readViewable();
	
}
