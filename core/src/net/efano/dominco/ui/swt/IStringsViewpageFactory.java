package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Display;

public interface IStringsViewpageFactory {

	IStringsViewpage getNewDrawable();
	boolean isReady();
	Display getDisplay();
	IStringsViewpage getNewDrawable(String viewName,String [] colNames);
	
}
