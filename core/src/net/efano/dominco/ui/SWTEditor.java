package net.efano.dominco.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class SWTEditor implements IEditor {

	private Shell rootWidget;

	   public static void main (String [] args) {
	   
		   new SWTEditor();
		   }


	
	public SWTEditor() {
	      Display display = new Display ();
	       rootWidget = new Shell (display);

	      
	  	final TabFolder tabFolder = new TabFolder (rootWidget, SWT.BORDER);
		Rectangle clientArea = rootWidget.getClientArea ();
		tabFolder.setLocation (clientArea.x, clientArea.y);
		for (int i=0; i<6; i++) {
			TabItem item = new TabItem (tabFolder, SWT.NONE);
			item.setText ("TabItem " + i);
			Button button = new Button (tabFolder, SWT.PUSH);
			button.setText ("Page " + i);
			item.setControl (button);
		}
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

}
