package net.efano.dominco.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class SWTEditor implements DrawableFactory {

	private Shell rootWidget;

	   public static void main (String [] args) {
	   
		   new SWTEditor();
		   }


	
	public SWTEditor() {
	      Display display = new Display ();
	       rootWidget = new Shell (display);

	      
	  	final TabFolder tabFolder = new TabFolder (rootWidget, SWT.BORDER);
	  	
	  	// dont know what these do:
		// Rectangle clientArea = rootWidget.getClientArea ();
		// tabFolder.setLocation (clientArea.x, clientArea.y);
		
		TabItem item = new TabItem (tabFolder, SWT.NONE);
		item.setText ("Classes");
		
		final ScrolledComposite scr = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		// scr.setLayout(new GridLayout()); --- not required
		final Composite panel = new Composite(scr,SWT.NONE);
		scr.setContent(panel);

		// panel.setSize(600,200);

		
		GridLayout layout = new GridLayout();
		panel.setLayout(layout);
		
		for (int i=0; i<6; i++) {
		Button button = new Button (panel, SWT.PUSH);
		button.setText ("Strings");
		button.setSize(600,600);
		}
		
		item.setControl (scr);
		// scr.pack(); // --- not required
		panel.pack();
		tabFolder.pack ();
		rootWidget.pack ();
		rootWidget.open ();		      
	      
		
	      while (!rootWidget.isDisposed ()) {
	         if (!display.readAndDispatch ()) display.sleep ();
	      }
	      display.dispose ();
		
	}
	
	@Override
	public IDrawable getNewDrawable() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Display getDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

}
