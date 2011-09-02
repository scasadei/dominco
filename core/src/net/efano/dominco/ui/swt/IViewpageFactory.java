package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;

public interface IViewpageFactory {

	boolean isReady();
	Display getDisplay();
	// IViewpage getNewViewpage();
	Table getNewTable(String pageName,String [] colNames);
	
}
