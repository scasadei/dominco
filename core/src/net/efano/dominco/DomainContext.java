package net.efano.dominco;

import java.util.Properties;

import net.efano.dominco.strings.Strings;
import net.efano.dominco.ui.swt.IDrawableFactory;
import net.efano.dominco.ui.swt.IViewable;
import net.efano.dominco.ui.swt.IViewpageFactory;
import net.efano.dominco.ui.swt.DomainContextView;
import net.efano.dominco.ui.swt.StringsView;

public class DomainContext implements IViewable {

	private DomainContextView view;

	private Properties properties;

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
    	df.getDisplay().syncExec(new Runnable() {
			public void run () {
				view = (DomainContextView) df.getNewDrawable();
				view.setViewable(DomainContext.this);
			}
		});
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
