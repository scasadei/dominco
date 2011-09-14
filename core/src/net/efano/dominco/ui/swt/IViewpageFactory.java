package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;

public interface IViewpageFactory {

	boolean isReady();
	// Display getDisplay();
	// IViewpage getNewViewpage();
	void syncExec(Runnable aRunnable);
	Table getNewTable(String pageName,String [] colNames);
	
}
