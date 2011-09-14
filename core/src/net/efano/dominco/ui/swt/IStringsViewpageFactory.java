package net.efano.dominco.ui.swt;

public interface IStringsViewpageFactory {

	IStringsViewpage getNewViewpage();
	boolean isReady();
	void syncExec(Runnable aRunnable);
	//Display getDisplay();
	IStringsViewpage getNewViewpage(String pageName,String [] colNames);
	
}
