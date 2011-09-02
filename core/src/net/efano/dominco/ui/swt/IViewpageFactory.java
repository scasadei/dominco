package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Display;

public interface IViewpageFactory {

	boolean isReady();
	Display getDisplay();
	IViewpage getNewViewpage();
	IViewpage getNewViewpage(String pageName,String [] colNames);
	
}
