package net.efano.dominco;

import java.util.Properties;

import org.eclipse.swt.widgets.Table;

import net.efano.dominco.ui.swt.DomainContextView;
import net.efano.dominco.ui.swt.IViewable;
import net.efano.dominco.ui.swt.IViewpageFactory;

public class DomainContext implements IViewable {

	private Properties properties;
	/*
	 * An optional gui element to show itself
	 */
	private DomainContextView viewpage;
	
	
	@Override
	public void makeView(final IViewpageFactory df)  {

		// sleep until the df is ready
		boolean dfReady = false;
		while (!dfReady) {
			dfReady = df.isReady();
    		System.out.println("sleeping");
			try {Thread.sleep(100);}
			catch (InterruptedException e) {}
		}

		// syncExec waits that argument terminates
    	// df.getDisplay().syncExec(new Runnable() {
        df.syncExec(new Runnable() {
			public void run () {
				Table swtTable = df.getNewTable("DomContext",
						new String []{"a","b"});
				viewpage = new DomainContextView(swtTable);
				viewpage.setViewable(DomainContext.this);
			}
		});
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
	
}
