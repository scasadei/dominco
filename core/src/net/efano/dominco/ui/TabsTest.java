package net.efano.dominco.ui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
 
public class TabsTest {
 
	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
	
		Shell shell2 = new Shell(display);
		shell2.setLayout(new FillLayout());
		CTabFolder folder = new CTabFolder(shell, SWT.CLOSE | SWT.BOTTOM);
		folder.setUnselectedCloseVisible(false);
		folder.setSimple(false);
		for (int i = 0; i < 6; i++) {
			CTabItem item = new CTabItem(folder, SWT.NONE);
			item.setText("Tab Item "+i);
			Text text = new Text(folder, SWT.BORDER | SWT.MULTI);
			text.setText("Content for Item "+i);
			item.setControl(text);
		}
		
		folder.setSize (400, 200);
		
		
		TabFolder tabFolder = new TabFolder (shell2, SWT.NONE);
		for (int i=0; i<6; i++) {
			TabItem item = new TabItem (tabFolder, SWT.NULL);
			item.setText ("Tab Item " + i);
			Text text = new Text(tabFolder, SWT.BORDER | SWT.MULTI);
			text.setText("Content for Item "+i);
			item.setControl(text);
		}
		tabFolder.setSize (400, 200);
		
		shell.pack ();
		shell.open ();
		shell2.pack();
		shell2.open();
		while (!shell.isDisposed () || !shell2.isDisposed()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
		
	}
}
