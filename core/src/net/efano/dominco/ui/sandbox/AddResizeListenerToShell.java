package net.efano.dominco.ui.sandbox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class AddResizeListenerToShell {
  
public static void main (String [] args) {
  Display display = new Display ();
  final Shell shell = new Shell (display, SWT.SHELL_TRIM | SWT.H_SCROLL | SWT.V_SCROLL);

  shell.addListener (SWT.Resize,  new Listener () {
    public void handleEvent (Event e) {
      Rectangle rect = shell.getClientArea ();
      System.out.println(rect);
    }
  });
  shell.open ();
  while (!shell.isDisposed()) {
    if (!display.readAndDispatch ()) display.sleep ();
  }
  display.dispose ();
}


	
}
