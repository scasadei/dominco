package net.efano.dominco.ui.swt;

public interface IViewpageFactory {

	boolean isReady();
	void syncExec(Runnable aRunnable);
	IViewpage getNewTable(String pageName,String [] colNames);
	
}
