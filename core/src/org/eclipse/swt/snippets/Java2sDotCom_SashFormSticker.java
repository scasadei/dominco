package org.eclipse.swt.snippets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Java2sDotCom_SashFormSticker {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Sash One");

    shell.setLayout(new FormLayout());

    final Sash sash = new Sash(shell, SWT.VERTICAL);
    FormData data = new FormData();
    data.top = new FormAttachment(0, 0); // Attach to top
    data.bottom = new FormAttachment(100, 0); // Attach to bottom
    data.left = new FormAttachment(50, 0); // Attach halfway across
    sash.setLayoutData(data);

    Text one = new Text(shell, SWT.BORDER);
    data = new FormData();
    data.top = new FormAttachment(0, 0);
    data.bottom = new FormAttachment(100, 0);
    data.left = new FormAttachment(0, 0);
    data.right = new FormAttachment(sash, 0);
    one.setLayoutData(data);

    Text two = new Text(shell, SWT.BORDER);
    data = new FormData();
    data.top = new FormAttachment(0, 0);
    data.bottom = new FormAttachment(100, 0);
    data.left = new FormAttachment(sash, 0);
    data.right = new FormAttachment(100, 0);
    two.setLayoutData(data);

    
    sash.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        // Reattach to the left edge, and use the x value of the event to
        // determine the offset from the left
        ((FormData) sash.getLayoutData()).left = new FormAttachment(0, event.x);

        // Until the parent window does a layout, the sash will not be redrawn in
        // its new location. So, force a layout.
        sash.getParent().layout();
      }
    });
    
    
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();

  }
}