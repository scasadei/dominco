package net.efano.dominco.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class SWTEditor implements IEditor {

	   public static void main (String [] args) {
		      Display display = new Display ();
		      Shell shell = new Shell (display);
		      
				
				shell.setLayout(new RowLayout(SWT.VERTICAL));
		      
		      
			      Label label = new Label (shell, SWT.CENTER);
			      label.setText ("Hello_world");
			      
			      Label label2 = new Label (shell, SWT.CENTER);
			      label2.setText ("Hello_world2");

			      
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
