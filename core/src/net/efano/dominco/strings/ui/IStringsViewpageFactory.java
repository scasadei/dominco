package net.efano.dominco.strings.ui;

public interface IStringsViewpageFactory {

	// IStringsViewpage getNewViewpage();
	IStringsViewpage getNewViewpage2();
	IStringsViewpage getNewViewpage(String pageName,String [] colNames);
	boolean isReady();
	// void syncExec(Runnable aRunnable);
	
}
