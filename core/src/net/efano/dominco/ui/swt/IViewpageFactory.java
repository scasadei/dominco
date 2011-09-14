package net.efano.dominco.ui.swt;

import org.eclipse.swt.widgets.Table;

public interface IViewpageFactory {

	boolean isReady();
	void syncExec(Runnable aRunnable);
	IViewpage getNewTable(String pageName,String [] colNames);
	
}
