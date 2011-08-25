package net.efano.dominco.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class SWTEditor implements IEditor {

	   public static void main (String [] args) {
		      Display display = new Display ();
		      Shell shell = new Shell (display);
		      Label label = new Label (shell, SWT.CENTER);
		      label.setText ("Hello_world");
		      label.setBounds (shell.getClientArea ());
		      shell.open ();
		      while (!shell.isDisposed ()) {
		         if (!display.readAndDispatch ()) display.sleep ();
		      }
		      display.dispose ();
		   }


	
	public SWTEditor() {
		
	}
	
	@Override
	public IDrawable getNewDrawable() {
		// TODO Auto-generated method stub
		return null;
	}

}
