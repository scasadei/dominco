package net.efano.dominco.ui.wb;

import net.efano.dominco.ui.IDrawable;
import net.efano.dominco.ui.DrawableFactory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
// import net.efano.dominco.ui.wb.StringsView;;

public class SWTEditor implements DrawableFactory {

	protected Shell shell;
	private CTabFolder tabFolder;
	private Display display;
	
	public synchronized boolean isReady() {
		return (display!=null && shell!=null && !shell.isDisposed());
	}
	
	public SWTEditor() {
		// display = Display.getDefault(); -- this causes an error!
	}
	
	synchronized public Display getDisplay() {
		return display;
	}
	
	synchronized public void setDisplay() {
		display = Display.getDefault();
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SWTEditor window = new SWTEditor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		init();
		addContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public synchronized void  openInOwnThread() {
		Runnable ru = new Runnable() {
			@Override
			public void run() {
				open();
			}
		};
		new Thread(ru).start();
	}

	public void init() {
		setDisplay(); 
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Strings Viewer");
		
		 shell.addListener (SWT.Resize,  new Listener () {
			    public void handleEvent (Event e) {
			      Rectangle rect = shell.getClientArea ();
			      if (tabFolder!=null) {
				  tabFolder.setBounds(0,0,shell.getSize().x,shell.getSize().y);
			    }
			      System.out.println(rect);
			    }
			  });
		
		 
		tabFolder = new CTabFolder(shell, SWT.BORDER);
		// tabFolder.setBounds(23, 32, 156, 125);
		tabFolder.setBounds(0,0,shell.getSize().x,shell.getSize().y);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

	}
	
	private void addContents() {
		Table table = addView("Nomi","nomi");
		Table table_1 = addView("Citta","citta");
		drawString(table,"Pinco Pallino Mezzolo");
		drawString(table,"Gurdo");
		drawString(table,"Miolo");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Megolo");
	}

	@Override
	public IDrawable getNewDrawable() {
		return new StringsView(addView("StringsView","Strings'"));
	}

	private TableItem drawString(Table aTable,String aString) {
		TableItem aTableItem = new TableItem(aTable, SWT.NONE);
		aTableItem.setText(aString);
		return aTableItem;
	}
	
	private Table addView(String tableName, String columnName) {
		CTabItem tbtmNomi = new CTabItem(tabFolder, SWT.NONE);
		tbtmNomi.setText(tableName);

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmNomi.setControl(scrolledComposite);

		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Table table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNomi = new TableColumn(table, SWT.NONE);
		tblclmnNomi.setWidth(100);
		tblclmnNomi.setText(columnName);
		
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	    tabFolder.addSelectionListener(new SelectionListener() {
	        public void widgetSelected(SelectionEvent e) {
	          System.out.println("Selected item index = " + tabFolder.getSelectionIndex());
	          System.out.println("Selected item = " + (tabFolder.getSelection() == null ? "null" : tabFolder.getSelection().toString()));
	        }
	        public void widgetDefaultSelected(SelectionEvent e) {
	            widgetSelected(e);
	          }
	    });
	    		
		return table;
	}	
}
