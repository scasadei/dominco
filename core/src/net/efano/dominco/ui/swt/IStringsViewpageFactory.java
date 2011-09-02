package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Display;

public interface IStringsViewpageFactory {

	IStringsViewpage getNewViewpage();
	boolean isReady();
	Display getDisplay();
	IStringsViewpage getNewViewpage(String pageName,String [] colNames);
	
}
