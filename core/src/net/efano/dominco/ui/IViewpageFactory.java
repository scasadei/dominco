package net.efano.dominco.ui;

public interface IViewpageFactory {

	boolean isReady();
	void syncExec(Runnable aRunnable);
	IViewpage getNewTable(String pageName,String [] colNames);
	
}
