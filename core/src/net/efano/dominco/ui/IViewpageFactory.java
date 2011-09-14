package net.efano.dominco.ui;

public interface IViewpageFactory {

	boolean isReady();
	void syncExec(Runnable aRunnable);
	void asyncExec(Runnable aRunnable);
	IViewpage getNewViewpage(String pageName,String [] colNames);
	
}
