package net.efano.dominco.ui.sandbox;

/*
 * Caret example snippet: create a caret
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class TestCaret {

// public class Snippet74 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Caret caret = new Caret (shell, SWT.NONE);
	caret.setBounds (10, 10, 2, 32);
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 




