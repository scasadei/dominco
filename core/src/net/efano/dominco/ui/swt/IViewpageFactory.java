package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Display;

public interface IViewpageFactory {

	IViewpage getNewDrawable();
	boolean isReady();
	Display getDisplay();
	IViewpage getNewViewpage(String viewName,String [] colNames);
	
}
