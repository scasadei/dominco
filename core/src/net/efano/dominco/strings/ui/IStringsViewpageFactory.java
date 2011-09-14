package net.efano.dominco.strings.ui;

public interface IStringsViewpageFactory {

	IStringsViewpage getNewViewpage();
	boolean isReady();
	void syncExec(Runnable aRunnable);
	IStringsViewpage getNewViewpage(String pageName,String [] colNames);
	
}
