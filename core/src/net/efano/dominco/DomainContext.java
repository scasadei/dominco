package net.efano.dominco;

import java.util.Properties;

import net.efano.dominco.ui.IViewable;
import net.efano.dominco.ui.IViewpage;
import net.efano.dominco.ui.IViewpageFactory;

public class DomainContext implements IViewable {

	private Properties properties;
	/*
	 * An optional gui element to show itself
	 */
	private IViewpage viewpage;
	
	
	@Override
	public void makeViewAndSitOnIt(final IViewpageFactory df)  {

		// sleep until the df is ready
		boolean dfReady = false;
		while (!dfReady) {
			dfReady = df.isReady();
    		System.out.println("sleeping");
			try {Thread.sleep(100);}
			catch (InterruptedException e) {}
		}
		// syncExec waits that argument terminates
        df.syncExec(new Runnable() {
			public void run () {
				viewpage = df.getNewViewpage("DomContext",
						new String []{"a","b"});
				viewpage.setViewable(DomainContext.this);
			}
		});
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
	
}
